package Bai3;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor p1 = new PaymentProcessor(new CODPayment());
        p1.process(500000);

        PaymentProcessor p2 = new PaymentProcessor(new CreditCardPayment());
        p2.process(1000000);

        PaymentProcessor p3 = new PaymentProcessor(new MomoPayment());
        p3.process(750000);

        PaymentProcessor p4 = new PaymentProcessor(new MomoPayment());
        p4.process(1000000);
    }
}

