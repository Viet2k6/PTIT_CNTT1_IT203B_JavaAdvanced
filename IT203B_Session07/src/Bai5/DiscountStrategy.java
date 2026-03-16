package Bai5;

public interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

class PercentageDiscount implements DiscountStrategy {
    private double percent;
    public PercentageDiscount(double percent) { this.percent = percent; }
    public double applyDiscount(double totalAmount) {
        return totalAmount - totalAmount * percent / 100;
    }
}

class FixedDiscount implements DiscountStrategy {
    private double amount;
    public FixedDiscount(double amount) { this.amount = amount; }
    public double applyDiscount(double totalAmount) {
        return totalAmount - amount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    private double percent;
    public HolidayDiscount(double percent) { this.percent = percent; }
    public double applyDiscount(double totalAmount) {
        return totalAmount - totalAmount * percent / 100;
    }
}
