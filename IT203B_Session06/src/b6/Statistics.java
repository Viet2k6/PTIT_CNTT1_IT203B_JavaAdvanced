package b6;

import java.util.*;

public class Statistics {

    public static void print(List<TicketPool> pools) {

        int revenue = 0;

        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");

        for (TicketPool p : pools) {

            int sold = p.soldCount();
            int total = p.total();

            System.out.println(
                    "Phòng " + p.getRoomName() +
                            ": Đã bán " + sold + "/" + total + " vé"
            );

            revenue += p.revenue();
        }

        System.out.println("Tổng doanh thu: " + revenue + " VNĐ");
    }
}