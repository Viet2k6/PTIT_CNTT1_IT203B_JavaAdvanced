package Bai1;

public class OrderCalculator {
    public double calculateTotal(Order order) {
        double sum = 0;
        for (Product p : order.getProducts()) {
            sum += p.getPrice();
        }
        order.setTotal(sum);
        return sum;
    }
}
