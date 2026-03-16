package Bai3;

public interface PaymentMethod {
    void pay(double amount);
}

interface CODPayable extends PaymentMethod { }

interface CardPayable extends PaymentMethod { }

interface EWalletPayable extends PaymentMethod { }
