package b3;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<Ticket> tickets = new LinkedList<>();
    private String roomName;
    private int counter = 1;

    public TicketPool(String roomName, int initial) {
        this.roomName = roomName;
        for (int i = 0; i < initial; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", counter++)));
        }
    }

    public synchronized Ticket sellTicket() {
        if (tickets.isEmpty()) return null;
        return tickets.poll();
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", counter++)));
        }
        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public synchronized int remainingTickets() {
        return tickets.size();
    }
}