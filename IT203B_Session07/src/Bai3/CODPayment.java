package Bai3;

public class CODPayment implements CODPayable {
    @Override
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán COD: " + amount + " – Thành công");
    }
}

class CreditCardPayment implements CardPayable {
    @Override
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " – Thành công");
    }
}

class MomoPayment implements EWalletPayable {
    @Override
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount + " – Thành công");
    }
}
