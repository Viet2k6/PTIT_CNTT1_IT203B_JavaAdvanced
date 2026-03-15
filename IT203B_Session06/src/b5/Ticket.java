package b5;

public class Ticket {

    private String ticketId;
    private String roomName;
    private boolean isSold;
    private boolean isHeld;
    private boolean isVIP;
    private long holdExpiryTime;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
        this.isHeld = false;
        this.isVIP = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }
}