package Bai4;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order) {
        repository.save(order);
        notification.send("Đơn hàng " + order.getOrderId() + " đã được tạo", order.getCustomerEmail());
    }
}
