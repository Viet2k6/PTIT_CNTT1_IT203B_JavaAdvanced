package Bai1;

public class Main {
    public static void main(String[] args) {
        Product sp1 = new Product("SP01", "Laptop", 15000000);
        Product sp2 = new Product("SP02", "Chuột", 200000);

        Customer kh = new Customer("Nguyễn Văn A", "a123@gmail.com");

        Order order = new Order("ORD001", kh);
        order.addProduct(sp1);
        order.addProduct(sp2);

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        System.out.println("Tổng tiền: " + total);

        OrderRepository repo = new OrderRepository();
        repo.save(order);

        EmailService emailService = new EmailService();
        emailService.sendConfirmation(order);
    }
}

