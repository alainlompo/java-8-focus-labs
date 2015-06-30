package org.lompo.labs.java8.lambdas.fi.io;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	
	String process(BufferedReader bR) throws IOException;

}
