package Bai6;


public class StorePOSFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FixedDiscount(50000);
    }
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }
    @Override
    public NotificationService createNotificationService() {
        return new PrintInvoiceNotification();
    }
}
