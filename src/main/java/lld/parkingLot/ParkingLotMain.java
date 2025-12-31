package lld.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotMain {
    public static void main(String[] args) {

        UtilityClass utilClass = new UtilityClass();
        ParkingLot parkingLot  = utilClass.initialize();
        PricingType pricingTypeHourly = PricingType.HOURLY;
        PricingType pricingTypeDaily = PricingType.DAILY;
        PaymentType UPIType = PaymentType.UPI;
        PaymentType DebitType = PaymentType.DEBIT;




        Vehicle vehicle1 = new BikeVehicle("ABC123");
        Ticket ticket1 = parkingLot.allocateParkingSlot(vehicle1, pricingTypeHourly);
        System.out.println(ticket1.toString());
        System.out.println("-----------------------------------------------------");


        Vehicle vehicle2 = new CarVehicle("ABD123");
        Ticket ticket2 = parkingLot.allocateParkingSlot(vehicle2, pricingTypeHourly);
        System.out.println(ticket2.toString());
        System.out.println("-----------------------------------------------------");



        parkingLot.unAllocateParkingSlotAndPay(ticket1,UPIType);
        System.out.println(ticket1.toString());
        System.out.println("-----------------------------------------------------");



        Vehicle vehicle3 = new BikeVehicle("AEC123");
        Ticket ticket3 = parkingLot.allocateParkingSlot(vehicle3, pricingTypeDaily);
        System.out.println(ticket3.toString());
        System.out.println("-----------------------------------------------------");








    }
}
