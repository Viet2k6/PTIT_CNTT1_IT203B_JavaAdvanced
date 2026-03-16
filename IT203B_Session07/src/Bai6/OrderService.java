package Bai6;

public class OrderService {
    private NotificationService notification;

    public OrderService(NotificationService notification) {
        this.notification = notification;
    }

    public void createOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getSubtotal();
        }
        double finalAmount = discount.applyDiscount(total);
        order.setTotal(finalAmount);

        payment.pay(finalAmount);
        notification.send("Đơn hàng " + order.getOrderId() + " đã được tạo", order.getCustomer().getEmail());
    }
}
