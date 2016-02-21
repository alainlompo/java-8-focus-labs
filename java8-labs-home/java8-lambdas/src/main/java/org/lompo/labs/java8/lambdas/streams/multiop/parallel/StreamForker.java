package org.lompo.labs.java8.lambdas.streams.multiop.parallel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 
 * @author Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft
 *
 * @param <T>
 */
public class StreamForker<T> {
	private final Stream<T> stream;
	private final Map<Object, Function<Stream<T>, ?>> forks = new HashMap<>();
	
	public StreamForker(Stream<T> stream) {
		this.stream = stream;
	}
	
	public StreamForker<T> fork(Object key, Function<Stream<T>, ?> f) {
		forks.put(key, f);
		return this;
	}
	
	public Results getResults() {
		
		ForkingStreamConsumer<T> consumer = build();
		try {
			stream.sequential().forEach(consumer);
			
		} finally {
			consumer.finish();
		}
		return consumer;
	}

	private ForkingStreamConsumer<T> build() {
		
		// Creates a list of queues with a queue for each operation		
		List<BlockingQueue<T>> queues = new ArrayList<>();
		
		// Map the Futures that will contain the results of the operations
		// with the keys used to identify those operations
		Map<Object, Future<?>> actions =
				forks.entrySet().stream().reduce(
						new HashMap<Object, Future<?>>(),
						(map, e) -> {
							map.put(e.getKey(),
									getOperationResult(queues, e.getValue())
									);
							return map;
						},
						(m1,m2) -> {
							m1.putAll(m2);
							return m1;
						}
						);
		return new ForkingStreamConsumer<>(queues, actions);
	}

	private Future<?> getOperationResult(List<BlockingQueue<T>> queues,
			Function<Stream<T>, ?> f) {
		
		// Create a queue and add it to the list of queues
		BlockingQueue<T> queue = new LinkedBlockingQueue<>();
		queues.add(queue);
		
		// Create a spliterator traversing the elements in that queue
		Spliterator<T> spliterator = new BlockingQueueSpliterator<>(queue);
		
		// Create a stream having that spliterator as source
		Stream<T> source = StreamSupport.stream(spliterator, false);
		
		// Create a future calculating asynchronously the application of the given function
		// on that Stream
		return CompletableFuture.supplyAsync(() -> f.apply(source));
	}
}
