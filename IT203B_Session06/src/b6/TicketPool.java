package b6;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int price = 250000;

    public TicketPool(String roomName, int amount) {
        this.roomName = roomName;

        for (int i = 1; i <= amount; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public int soldCount() {
        int c = 0;
        for (Ticket t : tickets) if (t.isSold()) c++;
        return c;
    }

    public int total() {
        return tickets.size();
    }

    public int revenue() {
        return soldCount() * price;
    }

    public String getRoomName() {
        return roomName;
    }

    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", start + i);
            tickets.add(new Ticket(id, roomName));
        }

        System.out.println("Đã thêm " + count + " vé vào phòng " + roomName);
    }
}