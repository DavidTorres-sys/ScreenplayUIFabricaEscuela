package co.com.udea.pagosb.modulopagosb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PaymentPage {
    public static final Target CARD_NUMBER_INPUT = Target.the("Card number input")
            .locatedBy("//*[@id=\"card-number\"]");

    public static final Target CARD_EXPIRATION_MONTH_INPUT = Target.the("Card expiration month input")
            .locatedBy("//*[@id=\"expitation-month\"]");

    public static final Target CARD_EXPIRATION_YEAR_INPUT = Target.the("Card expiration year input")
            .locatedBy("//*[@id=\"expitation-year\"]");

    public static final Target CARD_SECURITY_CODE_INPUT = Target.the("Card security code input")
            .locatedBy("//*[@id=\"cvv\"]");

    public static final Target CARD_HOLDER_NAME_INPUT = Target.the("Card holder name input")
            .locatedBy("//*[@id=\"user-name\"]");

    public static final Target BTN_CONFIRM_PURCHASE = Target.the("Confirm purchase button")
            .locatedBy("//*[@id=\"id-pay-button\"]");

    public static final Target PURCHASE_SUCCESSFUL_MESSAGE = Target.the("Purchase successful message")
            .locatedBy("//*[@id=\"successfull-buy-title\"]");
}
