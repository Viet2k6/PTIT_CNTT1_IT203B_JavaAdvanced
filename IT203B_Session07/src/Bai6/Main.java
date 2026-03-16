package Bai6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh bán hàng:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. Store POS");
        int choice = Integer.parseInt(sc.nextLine());

        SalesChannelFactory factory;
        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                break;
            case 2:
                factory = new MobileAppFactory();
                break;
            case 3:
                factory = new StorePOSFactory();
                break;
            default:
                System.out.println("Sai lựa chọn!");
                return;
        }

        OrderService service = new OrderService(factory.createNotificationService());

        Customer customer = new Customer("Việt", "viet@gmail.com", "0123456789");
        Product product = new Product("SP01", "Laptop", 15000000, "Điện tử");
        Order order = new Order("ORD001", customer);
        order.addItem(new OrderItem(product, 1));

        service.createOrder(order,
                factory.createDiscountStrategy(),
                factory.createPaymentMethod());
    }
}
