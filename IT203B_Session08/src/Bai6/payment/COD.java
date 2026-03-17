package Bai6.payment;

public class COD implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán khi nhận hàng: " + amount);
    }
}