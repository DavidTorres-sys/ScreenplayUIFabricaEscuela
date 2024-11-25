package co.com.udea.pagosb.modulopagosb.tasks;

import co.com.udea.pagosb.modulopagosb.userinterfaces.UserPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class CalculateTotal {
    public static Question<Boolean> matchesDisplayedTotal() {
        return actor -> {
            String flightFare = Text.of(UserPage.FLIGHT_FARE_VALUE).answeredBy(actor);
            String taxes = Text.of(UserPage.TAXES_VALUE).answeredBy(actor);
            String additionalCharges = Text.of(UserPage.ADDITIONAL_CHARGES_VALUE).answeredBy(actor);
            String displayedTotal = Text.of(UserPage.TOTAL_AMOUNT).answeredBy(actor);

            if (flightFare == null || flightFare.isEmpty() ||
                    taxes == null || taxes.isEmpty() ||
                    additionalCharges == null || additionalCharges.isEmpty() ||
                    displayedTotal == null || displayedTotal.isEmpty()) {
                throw new AssertionError("One or more values are empty: " +
                        "Flight Fare: " + flightFare +
                        ", Taxes: " + taxes +
                        ", Additional Charges: " + additionalCharges +
                        ", Total: " + displayedTotal);
            }

            try {
                int flightFareValue = Integer.parseInt(flightFare.replaceAll("[^\\d]", ""));
                int taxesValue = Integer.parseInt(taxes.replaceAll("[^\\d]", ""));
                int additionalChargesValue = Integer.parseInt(additionalCharges.replaceAll("[^\\d]", ""));
                int displayedTotalValue = Integer.parseInt(displayedTotal.replaceAll("[^\\d]", ""));

                int expectedTotal = flightFareValue + taxesValue + additionalChargesValue;

                return displayedTotalValue == expectedTotal;

            } catch (NumberFormatException e) {
                throw new AssertionError("Error parsing numeric values: " +
                        "Flight Fare: " + flightFare +
                        ", Taxes: " + taxes +
                        ", Additional Charges: " + additionalCharges +
                        ", Total: " + displayedTotal, e);
            }
        };
    }
}
