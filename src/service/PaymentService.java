package service;

import model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private static List<Payment> paymentDB = new ArrayList<>();

    public static void savePayment(Payment payment){
        paymentDB.add(payment);
    }

    public static void updatePayment(Payment payment){
        Payment p = findPayment(payment.getPaymentId());
        int index = paymentDB.indexOf(p);
        paymentDB.set(index,payment);
    }

    public static void deletePayment(Payment payment){
        int index = paymentDB.indexOf(payment);
        paymentDB.remove(index);
    }

    public static Payment findPayment(String paymentId) {
        for(Payment payment : findAllPayments()){
            if(payment.getPaymentId().equals(paymentId)){
                return payment;
            }
        }
        return null;
    }

    public static List<Payment> findPayments(String query){
        List<Payment> result = new ArrayList<>();
        for(Payment payment : findAllPayments()){
            if(payment.getPayment().contains(query) || payment.getPaymentId().contains(query) || payment.getMethod().contains(query)){
                result.add(payment);
            }
        }
        return result;
    }

    public static List<Payment> findAllPayments() {
        return paymentDB;
    }

    public static String nextPayment(Payment payment) {

        return null;
    }

    public static String getPaymentId() {

        return null;
    }
}
