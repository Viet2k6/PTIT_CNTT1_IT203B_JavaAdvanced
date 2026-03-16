package Bai4;

public class Main {
    public static void main(String[] args) {
        OrderService service1 = new OrderService(new FileOrderRepository(), new EmailService());
        service1.createOrder(new Order("ORD001", "a@example.com"));

        OrderService service2 = new OrderService(new DatabaseOrderRepository(), new SMSNotification());
        service2.createOrder(new Order("ORD002", "b@example.com"));
    }
}
