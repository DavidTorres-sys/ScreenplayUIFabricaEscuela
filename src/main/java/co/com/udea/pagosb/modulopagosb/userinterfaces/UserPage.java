package co.com.udea.pagosb.modulopagosb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UserPage {
    public static final Target FLIGHT_FARE_DROPDOWN = Target.the("Flight fare dropdown")
            .locatedBy("//*[@id=\"id-price-title\"]");

    public static final Target TAXES_DROPDOWN = Target.the("Taxes dropdown")
            .locatedBy("//*[@id=\"id-price-title\"]");

    public static final Target ADDITIONAL_CHARGES_DROPDOWN = Target.the("Additional charges dropdown")
            .locatedBy("//*[@id=\"id-price-title\"]");

    public static final Target PURCHASE_SUMMARY_PAGE_TITLE = Target.the("Detalles de tu vuelo")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[1]/div/h2");
}
