package b4;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;
    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void run() {

        while (roomA.remainingTickets() > 0 || roomB.remainingTickets() > 0) {

            Ticket ticket = null;

            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
                if (ticket != null) {
                    System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
                    soldCount++;
                } else {
                    ticket = roomB.sellTicket();
                    if (ticket != null) {
                        System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
                        soldCount++;
                    }
                }
            } else {
                ticket = roomB.sellTicket();
                if (ticket != null) {
                    System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
                    soldCount++;
                } else {
                    ticket = roomA.sellTicket();
                    if (ticket != null) {
                        System.out.println(counterName + " đã bán vé " + ticket.getTicketId());
                        soldCount++;
                    }
                }
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}