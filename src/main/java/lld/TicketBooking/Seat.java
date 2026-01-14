package lld.TicketBooking;

public class Seat {

    private String seatNo;
    private SeatType seatType;

    public Seat(String seatNo, SeatType seatType) {
        this.seatNo = seatNo;
        this.seatType = seatType;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNo='" + seatNo + '\'' +
                ", seatType=" + seatType +
                '}';
    }
}
