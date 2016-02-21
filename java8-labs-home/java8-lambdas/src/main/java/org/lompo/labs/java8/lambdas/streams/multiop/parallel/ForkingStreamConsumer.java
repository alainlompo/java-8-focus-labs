package org.lompo.labs.java8.lambdas.streams.multiop.parallel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * Implements both the Results interface and the Consumer<T> interface
 * its accept method (Consumer interface) propagates the traversed element of the Stream
 * to all the queues.
 * Its get method (Results interface) returns the result of the operation indexed by the given key
 * @author Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft
 *
 * @param <T>
 */
public class ForkingStreamConsumer<T> implements Consumer<T>, Results {
	static final Object END_OF_STREAM = new Object();
	
	private final List<BlockingQueue<T>> queues;
	private final Map<Object, Future<?>> actions;
	
	ForkingStreamConsumer(List<BlockingQueue<T>> queues, Map<Object, Future<?>> actions) {
		this.queues = queues;
		this.actions = actions;
	}
	
	

	@Override
	public <R> R get(Object key) {
		try {
			// Returns the result of the operation indexed by the given key
			// and waits for the completion of the Future calculating it	
			return ((Future<R>)actions.get(key)).get();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void accept(T t) {
		// Propagates the traversed element of the stream to all the queues
		queues.forEach(q -> q.add(t));		
	}
	
	void finish() {
		// Add one last element to the queue to signal that the stream is finished
		accept((T)END_OF_STREAM);
	}
	

}
