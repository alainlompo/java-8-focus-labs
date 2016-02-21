package org.lompo.labs.java8.lambdas.streams.multiop.parallel;

import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

/**
 * 
 *  @author Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft
 *
 * @param <T>
 */
public class BlockingQueueSpliterator<T> implements Spliterator<T> {

	private final BlockingQueue<T> queue;

	/**
	 * Passes a BlockingQueue parameter
	 * @param queue
	 */
	BlockingQueueSpliterator(BlockingQueue<T> queue) {
		this.queue = queue;
	}
	
	
	/**
	 * This is the main capacity of the Spliterator we are interested in in this
	 * particular case. If a remained element exists the Spliterator will perform
	 * the given action on it, returning true. The element here will be taken from
	 * the BlockingQueue<T> parameter passed via the constructor
	 */
	@Override
	public boolean tryAdvance(Consumer<? super T> action) {
		T t;
		while(true) {
			try {
				// Retrieves and remove the head of the queue
				t = queue.take();
				break;
			} catch (InterruptedException iE) {
				// TODO: Log the exception 
			}
		}
		
		if (t == null) {
			return false;
		}
		
		if (t!= ForkingStreamConsumer.END_OF_STREAM) {
			action.accept(t);
			return true;
		}
		
		return false;
	}

	@Override
	public Spliterator<T> trySplit() {
			
		return null;
	}

	@Override
	public long estimateSize() {
		
		return 0;
	}

	@Override
	public int characteristics() {
		
		return 0;
	}
}