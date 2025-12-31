package lld.parkingLot;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ParkingLot {

    List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Ticket allocateParkingSlot(Vehicle vehicle, PricingType pricingType) {
        Optional<ParkingSlot> availableParkingSLot = floors.stream().flatMap((fl) -> fl.getParkingSlots().stream())
                                                                   .filter((parkSlot) -> !parkSlot.isOccupied() && parkSlot.getSlotType()==vehicle.getVehicleType()).findFirst();
        if(availableParkingSLot.isEmpty()) {
            System.out.println("ParkingSlots are full");
            throw new RuntimeException("ParkingSlots are full");
        }
        else{

            availableParkingSLot.get().parkVehicle(vehicle);
            Ticket ticket = new Ticket(availableParkingSLot.get(), pricingType);
            return ticket;

        }
    }


    public void unAllocateParkingSlotAndPay(Ticket ticket, PaymentType paymentType) {
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        ticket.exit();
        PricingType pricingType = ticket.getPricingType();
        PricingStrategy pricingStrategy = PricingStrategyFactory.getPricingStrategy(pricingType);
        PaymentService paymentService = PaymentServiceFactory.getPaymentService(paymentType, pricingStrategy);
        boolean isPaid = paymentService.pay(ticket);
        if(isPaid) {
            parkingSlot.unPark();


        }




        ticket.close();

    }
}
