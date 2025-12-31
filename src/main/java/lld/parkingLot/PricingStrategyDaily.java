package lld.parkingLot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class PricingStrategyDaily implements PricingStrategy{

    private Map<VehicleType, Double> dailyPlan;

    public PricingStrategyDaily(Map<VehicleType, Double> dailyPlan) {
        this.dailyPlan = dailyPlan;
    }

    @Override
    public double calculateFee(Ticket ticket) {

        VehicleType vehicleType = ticket.getParkingSlot().getVehicle().getVehicleType();
        return dailyPlan.get(vehicleType);
    }
}
