package Bai6;

public class WebsiteFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new PercentageDiscount(10);
    }
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}