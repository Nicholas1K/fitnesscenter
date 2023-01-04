package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.Payment;
import com.spring.fitnesscenter.service.PaymentService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PaymentWeb {
    @Autowired
    PaymentService paymentService;

    //metodo Get che ritorna la lista degli Payment

    @GetMapping({"/payment"})
    public String showPayment(Model model){
        model.addAttribute("payment", paymentService.getAllPayment());
        return "payment";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo payment

    @GetMapping("/payment/create")
    public String showPaymentForm(Model model) {
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "payment-create";
    }
    //metodo Post che salva un nuovo payment

    @PostMapping("/payment/create")
    public String insertPayment(@ModelAttribute("payment") Payment payment){
        paymentService.savePayment(payment);
        return"redirect:/address/create";
    }

    //metodo Get che ritorna la tabella per modificare un payment

    @GetMapping("/payment/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("payment", paymentService.findPaymentByID(id));
        return "update-payment";
    }

    //metodo Post che modifica effettivamente il payment

    @PostMapping("/payment/{id}")
    public String updatePayment(@PathVariable Long id,@ModelAttribute("payment") Payment payment, Model model){
        Payment oldPayment = paymentService.findPaymentByID(id);
        
        oldPayment.setUsers(payment.getUsers());
        oldPayment.setUserPay(payment.getUserPay());

        paymentService.updatePayment(oldPayment);
        return "redirect:/payment";
    }

    //metodo Get per eliminare un payment

    @GetMapping("/payment/{id}")
    public String deletePayment(@PathVariable Long id){
        paymentService.deletePaymentByID(id);
        return "redirect:/payment";
    }

}
