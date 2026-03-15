package b6;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CinemaSystem system = new CinemaSystem();

        while (true) {

            System.out.println("\n1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Tiếp tục mô phỏng");
            System.out.println("4. Thêm vé vào phòng");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();

                    System.out.print("Số vé/phòng: ");
                    int tickets = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();

                    system.startSimulation(rooms, tickets, counters);
                    break;

                case 2:
                    system.pause();
                    break;

                case 3:
                    System.out.println("Đã tiếp tục hoạt động.");
                    break;

                case 4:

                    System.out.print("Phòng (0=A,1=B...): ");
                    int room = sc.nextInt();

                    System.out.print("Số vé thêm: ");
                    int count = sc.nextInt();

                    system.addTickets(room, count);
                    break;

                case 5:
                    system.stats();
                    break;

                case 6:
                    new DeadlockDetector().run();
                    break;

                case 7:
                    system.stop();
                    System.out.println("Kết thúc chương trình.");
                    return;
            }
        }
    }
}
