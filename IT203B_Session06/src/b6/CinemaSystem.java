package b6;

import java.util.*;
import java.util.concurrent.*;

public class CinemaSystem {

    private ExecutorService executor;
    private List<TicketPool> pools = new ArrayList<>();
    private List<BookingCounter> counters = new ArrayList<>();

    public void startSimulation(int rooms, int tickets, int countersCount) {

        executor = Executors.newFixedThreadPool(countersCount);

        pools.clear();
        counters.clear();

        for (int i = 0; i < rooms; i++) {

            char name = (char) ('A' + i);
            pools.add(new TicketPool(String.valueOf(name), tickets));
        }

        for (int i = 1; i <= countersCount; i++) {

            BookingCounter c = new BookingCounter("Quầy " + i, pools);
            counters.add(c);

            executor.submit(c);
        }

        System.out.println(
                "Đã khởi tạo hệ thống với "
                        + rooms + " phòng, "
                        + (rooms * tickets) + " vé, "
                        + countersCount + " quầy"
        );
    }

    public void pause() {

        for (BookingCounter c : counters) {
            c.stop();
        }

        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void addTickets(int roomIndex, int count) {

        if (roomIndex >= 0 && roomIndex < pools.size()) {
            pools.get(roomIndex).addTickets(count);
        }
    }

    public void stats() {
        Statistics.print(pools);
    }

    public void stop() {

        executor.shutdownNow();
        System.out.println("Đang dừng hệ thống...");
    }

    public List<TicketPool> getPools() {
        return pools;
    }
}