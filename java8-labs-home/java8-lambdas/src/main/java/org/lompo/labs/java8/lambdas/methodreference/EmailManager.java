package org.lompo.labs.java8.lambdas.methodreference;

/**
 * The primary purpose of the implementation of this class
 * is to show the use of Function composition
 * @author LOMPO
 *
 */
public class EmailManager {
	
	static StringBuilder emailHeader;
	static StringBuilder emailBody;
	static StringBuilder emailFooter;
	static final String UNINITIALIZED_SECTION = "UNINITIALIZED SECTION";
	
	
	
	public static void instanciateEmail() {
		emailHeader = new StringBuilder();
		emailBody = new StringBuilder();
		emailFooter = new StringBuilder();
	}
	
	public static String addHeader(String headerText) {
		if (null == emailHeader) {
			return UNINITIALIZED_SECTION;
		}
		
		emailHeader.append(headerText);
		return emailHeader.toString();
	}
	
	public static String addFooter(String footerText) {
		if (null == emailFooter) {
			return UNINITIALIZED_SECTION;
		}
		emailFooter.append(footerText);
		return emailFooter.toString();
	}
	
	public static String addBody(String bodyText) {
		if (null == emailBody) {
			return UNINITIALIZED_SECTION;
		}
		emailBody.append(bodyText);
		return emailBody.toString();
	}
	
	public static String render() {
		
		StringBuilder result = new StringBuilder();
		result.append(emailHeader.toString())
		.append("\n")
		.append("\n")
		.append(emailBody.toString())
		.append("\n")
		.append("\n")
		.append(emailFooter.toString());
		
		return result.toString();
	}
	
	

}
