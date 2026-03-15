package b2;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 5);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB);

        counter1.start();
        counter2.start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }

            roomA.addTickets(3);

        }).start();
    }
}