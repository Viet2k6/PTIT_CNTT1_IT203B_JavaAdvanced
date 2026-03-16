package Bai1;

import java.util.*;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }
}

