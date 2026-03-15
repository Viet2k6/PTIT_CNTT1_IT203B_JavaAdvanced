package b5;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool[] pools;
    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool[] pools) {
        this.counterName = counterName;
        this.pools = pools;
    }

    public void run() {

        while (true) {

            TicketPool pool = pools[random.nextInt(pools.length)];
            boolean vip = random.nextBoolean();

            Ticket ticket = pool.holdTicket(vip);

            if (ticket != null) {

                System.out.println(counterName + ": Đã giữ vé " + ticket.getTicketId());

                try {
                    Thread.sleep(3000);
                } catch (Exception e) {}

                boolean success = pool.sellHeldTicket(ticket);

                if (success) {
                    System.out.println(counterName + ": Thanh toán thành công vé " + ticket.getTicketId());
                }

            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}