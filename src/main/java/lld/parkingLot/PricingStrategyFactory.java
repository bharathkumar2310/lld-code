package lld.parkingLot;

import java.util.Map;

public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(PricingType pricingType) {
        UtilityClass utilClass = new UtilityClass();
        Map<VehicleType, Double> hourlyRate = utilClass.initializeHourlyPlan();
        Map<VehicleType, Double> dailyPlan = utilClass.initializeDailyPlan();

        if(pricingType == PricingType.HOURLY) {
            return new PricingStrategyHourly(hourlyRate);
        }
        else if (pricingType == PricingType.DAILY) {
            return new PricingStrategyDaily(dailyPlan);
        }
        return null;
    }
}
