package co.com.udea.pagosb.modulopagosb.tasks;

import co.com.udea.pagosb.modulopagosb.interactions.ClickElement;
import co.com.udea.pagosb.modulopagosb.interactions.EnterValue;
import co.com.udea.pagosb.modulopagosb.models.CardForm;
import co.com.udea.pagosb.modulopagosb.userinterfaces.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProvideCardDetails implements Task {

    private final CardForm cardForm;

    public ProvideCardDetails(CardForm cardForm) {
        this.cardForm = cardForm;
    }

    public static ProvideCardDetails with(CardForm cardForm) {
        return instrumented(ProvideCardDetails.class, cardForm);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterValue.into(PaymentPage.CARD_HOLDER_NAME_INPUT, cardForm.getCardHolderName()),
                EnterValue.into(PaymentPage.CARD_NUMBER_INPUT, cardForm.getCardNumber()),
                ClickElement.click(PaymentPage.CARD_EXPIRATION_MONTH_INPUT),
                SelectFromOptions.byValue(cardForm.getExpirationMonth()).from(PaymentPage.CARD_EXPIRATION_MONTH_INPUT),
                ClickElement.click(PaymentPage.CARD_EXPIRATION_YEAR_INPUT),
                SelectFromOptions.byValue(cardForm.getExpirationYear()).from(PaymentPage.CARD_EXPIRATION_YEAR_INPUT),
                EnterValue.into(PaymentPage.CARD_SECURITY_CODE_INPUT, cardForm.getCvv())
        );
    }
}
