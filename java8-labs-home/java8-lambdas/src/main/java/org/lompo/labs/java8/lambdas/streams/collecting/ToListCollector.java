package org.lompo.labs.java8.lambdas.streams.collecting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.EnumSet;
import static java.util.stream.Collector.Characteristics.*;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	/**
	 * The accumulator method returns the function that performs the reduction operation
	 */
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		// TODO: we could have used return List::add instead
		return (list, item) -> list.add(item);
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
	}

	/**
	 * This methods implements how the accumulators resulting from the
	 * reduction of subparts of the stream are combined in case the 
	 * subpart are processed in parallel
	 */
	@Override
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	/**
	 * Returns a function that is invoked when the accumulation process is finished
	 */
	@Override
	public Function<List<T>, List<T>> finisher() {
		// TODO we can also use return Function.identity();
		return list -> list;
		
	}

	/**
	 * This method should return a supplier of an empty result
	 * It is to be a method without parameters that (when invoked) returns an instance
	 * of an empty class to be used as an accumulator 
	 * @see: we can also use return ArrayList::new to produce the same result
	 */
	@Override
	public Supplier<List<T>> supplier() {

		return () -> new ArrayList<T>();
	}
	

}
