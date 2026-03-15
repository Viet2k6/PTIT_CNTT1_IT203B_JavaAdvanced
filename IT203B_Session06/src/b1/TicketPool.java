package b1;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private Queue<String> tickets = new LinkedList<>();
    private String roomName;

    public TicketPool(String roomName, int amount) {
        this.roomName = roomName;
        for (int i = 1; i <= amount; i++) {
            tickets.add(roomName + "-" + String.format("%03d", i));
        }
    }

    public String getTicket() {
        return tickets.poll();
    }

    public void returnTicket(String ticket) {
        if (ticket != null) {
            tickets.add(ticket);
        }
    }

    public String getRoomName() {
        return roomName;
    }
}