package Bai6;

public interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

interface PaymentMethod {
    void pay(double amount);
}

interface NotificationService {
    void send(String message, String recipient);
}
