package Bai6;

// Discount
public class PercentageDiscount implements DiscountStrategy {
    private double percent;
    public PercentageDiscount(double percent) { this.percent = percent; }
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - totalAmount * percent / 100;
    }
}

class FixedDiscount implements DiscountStrategy {
    private double amount;
    public FixedDiscount(double amount) { this.amount = amount; }
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - amount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    private double percent;
    public HolidayDiscount(double percent) {
        this.percent = percent;
    }
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - totalAmount * percent / 100;
    }
}

// Payment
class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + amount);
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán thẻ tín dụng: " + amount);
    }
}

class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán MoMo: " + amount);
    }
}

// Notification
class EmailNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi email đến " + recipient + ": " + message);
    }
}

class PushNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi push notification: " + message);
    }
}

class PrintInvoiceNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}
