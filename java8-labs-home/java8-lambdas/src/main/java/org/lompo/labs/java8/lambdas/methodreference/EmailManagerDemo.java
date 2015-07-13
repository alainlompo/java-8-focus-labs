package org.lompo.labs.java8.lambdas.methodreference;
import java.util.function.Function;

public class EmailManagerDemo {
	
	static final Function<String, String> ADD_HEADER = EmailManager::addHeader;
	static final Function<String, String> EMAIL_CREATION_PIPELINE = ADD_HEADER.andThen(EmailManager::addBody)
			.andThen(EmailManager::addFooter);
	

}
