package b3;

public class BookingCounter extends Thread {

    private String name;
    private TicketPool pool;
    private int sold = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            Ticket ticket = pool.sellTicket();

            if (ticket != null) {
                sold++;
                System.out.println(name + " đã bán vé " + ticket.getId());
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println(name + " bán được: " + sold + " vé");
    }
}