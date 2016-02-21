package org.lompo.labs.java8.lambdas.annotations;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class AnnotationsDemo1 {
	public static void main(String[] args) {
		Annotation[] anos = java.util.concurrent.ForkJoinPool.class.getAnnotations();
//		Annotation[] anos = org.xml.sax.helpers.XMLReaderFactory.class.getAnnotations();
		for (Annotation ano: anos) {
			System.out.println(ano.annotationType().getName() ); 
			
		}
		
	}

}
