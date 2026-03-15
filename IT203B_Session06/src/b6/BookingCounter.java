package b6;

import java.util.*;

public class BookingCounter implements Runnable {

    private String name;
    private List<TicketPool> pools;
    private boolean running = true;

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    public void stop() {
        running = false;
    }

    public void run() {

        Random r = new Random();

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            TicketPool pool = pools.get(r.nextInt(pools.size()));
            Ticket t = pool.sellTicket();

            if (t != null) {
                System.out.println(name + " đã bán vé " + t.getId());
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}