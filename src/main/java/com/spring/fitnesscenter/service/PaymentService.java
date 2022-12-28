package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.Payment;
import com.spring.fitnesscenter.repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }
    
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }
    
    public Payment findPaymentByID(Long id){
        Optional<Payment> tempP = paymentRepository.findById(id);

        if(tempP.isPresent()){
            return tempP.get();
        }else{
            return null;
        }
    }
    
    public void deletePaymentByID(Long id){
        paymentRepository.deleteById(id);
    }
    public Payment updatePayment(Payment newPayment){
        Payment oldP = findPaymentByID(newPayment.getId());

        if(oldP != null){
            oldP.setUsers(newPayment.getUsers());
            oldP.setUserPay(newPayment.getUserPay());
            
            paymentRepository.save(newPayment);
        }
        return null;
    }
    
    public Payment updatePaymentByID(Long id, Payment newPayment) {
        Optional<Payment> tempOldPayment = paymentRepository.findById(newPayment.getId());

        if (tempOldPayment.isPresent()) {
            Payment oldPayment = tempOldPayment.get();

            oldPayment.setUsers(newPayment.getUsers());
            oldPayment.setUserPay(newPayment.getUserPay());

            paymentRepository.save(newPayment);

        }
        return null;
    }
}
