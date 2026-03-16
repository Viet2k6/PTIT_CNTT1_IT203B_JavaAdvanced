package Bai5;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getSubtotal();
        }
        double finalAmount = discount.applyDiscount(total);
        order.setTotal(finalAmount);

        repository.save(order);
        payment.pay(finalAmount);
        notification.send("Đơn hàng " + order.getOrderId() + " đã được tạo", order.getCustomer().getEmail());
    }

    public void listOrders() {
        for (Order o : repository.findAll()) {
            System.out.println(o.getOrderId() + " - " + o.getCustomer().getName() + " - " + o.getTotal());
        }
    }

    public double calculateRevenue() {
        double sum = 0;
        for (Order o : repository.findAll()) {
            sum += o.getTotal();
        }
        return sum;
    }
}

class InvoiceGenerator {
    public static void printInvoice(Order order) {
        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.getCustomer().getName());
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getProduct().getName() + " - SL: " + item.getQuantity() +
                    " - Đơn giá: " + item.getProduct().getPrice() +
                    " - Thành tiền: " + item.getSubtotal());
        }
        System.out.println("Tổng tiền: " + order.getTotal());
    }
}
