package org.lompo.labs.java8.lambdas;

import java.io.File;

public class SubdDirectoriesLister {
	
	public static void main(String[] args) {
		File[] subDirectories = new File("C:\\Hypernovae\\Technical\\RD\\All_Java")
		.listFiles(File::isDirectory);
		for (File f: subDirectories) {
			System.out.println(f.getPath());
		}
	}

}
