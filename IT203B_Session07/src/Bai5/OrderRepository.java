package Bai5;

import java.util.*;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}

class FileOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu đơn hàng vào file: " + order.getOrderId());
    }
    public List<Order> findAll() { return orders; }
}

class DatabaseOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu đơn hàng vào database: " + order.getOrderId());
    }
    public List<Order> findAll() { return orders; }
}

interface NotificationService {
    void send(String message, String recipient);
}

class EmailNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("Gửi email đến " + recipient + ": " + message);
    }
}

class SMSNotification implements NotificationService {
    public void send(String message, String recipient) {
        System.out.println("Gửi SMS đến " + recipient + ": " + message);
    }
}
