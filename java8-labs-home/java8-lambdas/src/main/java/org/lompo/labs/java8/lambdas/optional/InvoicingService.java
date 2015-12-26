package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class InvoicingService {
	
	/**
	 * We apply map on an optional<T> as though it was a stream
	 * containing at least a single element. Now we can use the reference
	 * in the Optional<T> fashion.
	 * @param invoice
	 * @return
	 */
	public static Optional<String> getInvoiceReference(Invoice invoice) {
		Optional<Invoice> optInvoice = Optional.ofNullable(invoice);
		return optInvoice.map(Invoice::getReference);
	}
	
	public static Optional<Email> getEmailFrom(Invoice invoice) {
		return invoice.getCustomer().isPresent()?
				invoice.getCustomer().get().getBusinessEmail():Optional.empty();
		
	}
	
	/**
	 * flatmap helps to flaten the maps that would be otherwise nested
	 * @param invoice
	 * @return
	 */
	public static Optional<Phone> getContactPersonMainPhone(Invoice invoice) {
		Optional<Invoice> optInvoice = Optional.ofNullable(invoice);
		return optInvoice.flatMap(Invoice::getCustomer)
				.flatMap(Customer::getBusinessContactPerson)
				.flatMap(Person::getMainPhone);
				
	}

}
