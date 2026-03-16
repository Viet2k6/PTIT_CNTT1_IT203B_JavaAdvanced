package Bai6;

public class MobileAppFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new HolidayDiscount(15);
    }
    @Override
    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }
    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}