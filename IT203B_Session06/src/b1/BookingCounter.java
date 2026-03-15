package b1;

public class BookingCounter extends Thread {

    private String counterName;
    private TicketPool firstRoom;
    private TicketPool secondRoom;

    public BookingCounter(String counterName, TicketPool firstRoom, TicketPool secondRoom) {
        this.counterName = counterName;
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

    public void sellCombo() {

        synchronized (firstRoom) {

            String ticket1 = firstRoom.getTicket();

            if (ticket1 == null) {
                System.out.println(counterName + ": Hết vé phòng " + firstRoom.getRoomName());
                return;
            }

            System.out.println(counterName + ": Đã lấy vé " + ticket1);

            try {
                Thread.sleep(100);
            } catch (Exception e) {}

            System.out.println(counterName + ": Đang chờ vé " + secondRoom.getRoomName() + "...");

            synchronized (secondRoom) {

                String ticket2 = secondRoom.getTicket();

                if (ticket2 == null) {

                    firstRoom.returnTicket(ticket1);
                    System.out.println(counterName + ": Bán combo thất bại");
                    return;
                }

                System.out.println(counterName + " bán combo thành công: " + ticket1 + " & " + ticket2);
            }
        }
    }

    public void run() {
        while (true) {
            sellCombo();
        }
    }
}