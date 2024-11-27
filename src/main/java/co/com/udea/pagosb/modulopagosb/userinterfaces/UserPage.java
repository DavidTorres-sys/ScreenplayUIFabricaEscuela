package co.com.udea.pagosb.modulopagosb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UserPage {
    public static final Target FLIGHT_FARE_DROPDOWN = Target.the("Flight fare dropdown")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[3]/div/div[1]/div");

    public static final Target FLIGHT_FARE_VALUE = Target.the("Flight fare value")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[3]/div/div[1]/ul/li/p[2]");

    public static final Target TAXES_DROPDOWN = Target.the("Taxes dropdown")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[3]/div/div[3]/div");

    public static final Target TAXES_VALUE = Target.the("Taxes value")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[3]/div/div[3]/ul/li/p[2]");

    public static final Target ADDITIONAL_CHARGES_DROPDOWN = Target.the("Additional charges dropdown")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[3]/div/div[2]/div");

    public static final Target ADDITIONAL_CHARGES_VALUE = Target.the("Additional charges value")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[3]/div/div[2]/ul/li/p[2]");

    public static final Target PAYMENT_MENU = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[1]/div");

    public static final Target BANCOLOMBIA_OPTION = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[1]/form/label[1]/p");

    public static final Target PAYPAL_OPTION = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[1]/form/label[2]/p");

    public static final Target PAYU_OPTION = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[1]/form/label[3]/p");

    public static final Target PSE_OPTION = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[1]/form/label[4]/p");

    public static final Target  PAYMENT_CONTINUE_BUTTON = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[3]/a/button");

    public static final Target  PAYMENT_GATEWAY_NOT_SELECTED_MESSAGE = Target.the("Payment selection menu")
            .locatedBy("/html/body/div/main/div/div[2]/div/div[1]/div/div[1]/div[2]/p");

    public static final Target PURCHASE_SUMMARY_PAGE_TITLE = Target.the("Detalles de tu vuelo")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[1]/div/div[1]/div[1]/div/h2");

    public static final Target BTN_PAYMENT_WITH_CARD = Target.the("Payment method")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[2]/div/div[2]/form/label");

    public static final Target BTN_CONTINUE = Target.the("Continue button")
            .locatedBy("//*[@id=\"__next\"]/main/div/div[2]/div/div[3]/a/button");

    public static final Target TOTAL_AMOUNT = Target.the("Total amount displayed")
            .locatedBy("//*[@id=\"total-price-number\"]");
}
