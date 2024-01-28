package com.jsd.petvilla.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsd.petvilla.entity.Payments;
import com.jsd.petvilla.exception.PaymentRecordsNotFoundException;
import com.jsd.petvilla.repository.PaymentsRepository;
import com.jsd.petvilla.service.PaymentsService;

/*
 * Implementation of methods of PaymentService interface
 * Handles CRUD operation related to PaymentsService entity
 */
@Service
public class PaymentsServiceImpl implements PaymentsService{

	@Autowired
	PaymentsRepository paymentsRepository;
	
	/*
	 * save new payment information
	 * @return saved payments object
	 */
	@Override
	public Payments savePayment(Payments payment) {
		return paymentsRepository.save(payment);
	}
	
	/*
	 * fetch payment information by Customer ID
	 * @return List of Payments object corresponding to customer id
	 */
	@Override
	public List<Payments> fetchPaymentByCId(int customerId) {
		List<Payments> payments = paymentsRepository.findByCId(customerId);
		if(payments.isEmpty()) {
			throw new PaymentRecordsNotFoundException("Payment Records not found for given customer");
		}
		return payments;
	}
}
