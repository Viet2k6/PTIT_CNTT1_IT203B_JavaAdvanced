package b3;

public class Main {

    public static void main(String[] args) throws Exception {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB);

        Thread supplier = new Thread(new TicketSupplier(roomA, roomB, 3, 3000, 2));

        counter1.start();
        counter2.start();
        supplier.start();

        Thread.sleep(10000);

        counter1.interrupt();
        counter2.interrupt();

        counter1.join();
        counter2.join();

        System.out.println("Vé còn lại phòng A: " + roomA.remainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.remainingTickets());
    }
}