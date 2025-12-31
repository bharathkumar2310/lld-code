package lld.parkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private String ticketNo;
    private ParkingSlot parkingSlot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime ;
    private TicketStatus ticketStatus;
    private PricingType pricingType;


    public Ticket(ParkingSlot parkingSlot, PricingType pricingType) {
        this.parkingSlot = parkingSlot;
        this.ticketNo = UUID.randomUUID().toString();
        this.entryTime= LocalDateTime.now();
        this.ticketStatus = TicketStatus.ACTIVE;
        this.pricingType = pricingType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public LocalDateTime getExitTIme() {
        return exitTime ;
    }

    public void setExitTIme(LocalDateTime exitTIme) {
        this.exitTime  = exitTIme;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public PricingType getPricingType() {
        return pricingType;
    }

    public void setPricingType(PricingType pricingType) {
        this.pricingType = pricingType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo='" + ticketNo + '\'' +
                ", parkingSlot=" + parkingSlot +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", ticketStatus=" + ticketStatus +
                ", pricingType=" + pricingType +
                '}';
    }

    public void exit() {
        this.exitTime  = LocalDateTime.now().plusHours(2);
    }

    public void close() {
        this.ticketStatus = TicketStatus.CLOSED;
    }
}
