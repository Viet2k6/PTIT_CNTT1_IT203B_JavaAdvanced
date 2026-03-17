package Bai5;

public class Fan implements Observer {

    public void low() {
        System.out.println("Quạt chạy tốc độ thấp");
    }

    @Override
    public void update(int temp) {
        if (temp > 30) {
            System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
        }
    }
}