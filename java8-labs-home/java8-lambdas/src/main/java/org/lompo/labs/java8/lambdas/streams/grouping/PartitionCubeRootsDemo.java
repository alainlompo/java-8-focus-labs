package org.lompo.labs.java8.lambdas.streams.grouping;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.partitioningBy;

public class PartitionCubeRootsDemo {
	
	
	public Map<Boolean, List<Integer>> partitionPerfectCubes(int n) {
		return IntStream.rangeClosed(1, n)
				.boxed()
				.collect(partitioningBy(candidate -> isPerfectCube(candidate)));
				
		
	}
	public boolean isPerfectCube(int candidate) {

		double cubeRootD =(double)(Math.round( Math.pow(candidate*1.0D, 1.0/3.0)));		
		return ((double)candidate) % cubeRootD == 0;
		
	}
	
	public static void main(String[] args) {
		int N =75;
		Map<Boolean, List<Integer>> perfectCubePartition = (new PartitionCubeRootsDemo())
				.partitionPerfectCubes(N);
		System.out.println("The perfect cubes are: " + perfectCubePartition.get(Boolean.valueOf(true)));
		System.out.println("The IMperfect cubes are: " + perfectCubePartition.get(Boolean.valueOf(false)));
		
	}
}
