package lld.parkingLot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PricingStrategyHourly implements  PricingStrategy{

    private Map<VehicleType, Double> hourlyRates;

    public PricingStrategyHourly(Map<VehicleType, Double> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    @Override
    public double calculateFee(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = ticket.getExitTIme() ;
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);
        VehicleType vehicleType = ticket.getParkingSlot().getVehicle().getVehicleType();
        return hourlyRates.get(vehicleType) * hours;
    }
}
