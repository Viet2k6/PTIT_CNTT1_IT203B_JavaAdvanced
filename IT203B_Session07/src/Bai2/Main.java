package Bai2;

public class Main {
    public static void main(String[] args) {
        double total = 1_000_000;

        OrderCalculator calc1 = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Sau giảm 10%: " + calc1.calculate(total));

        OrderCalculator calc2 = new OrderCalculator(new FixedDiscount(50_000));
        System.out.println("Sau giảm 50.000: " + calc2.calculate(total));

        OrderCalculator calc3 = new OrderCalculator(new NoDiscount());
        System.out.println("Không giảm: " + calc3.calculate(total));

        OrderCalculator calc4 = new OrderCalculator(new HolidayDiscount(15));
        System.out.println("Giảm lễ hội 15%: " + calc4.calculate(total));
    }
}
