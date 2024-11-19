package co.com.udea.pagosb.modulopagosb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateText implements Question<Boolean> {

    private final String textToValidate;
    private final String textToCompare;

    public ValidateText(
            String textToValidate,
            String textToCompare) {
        this.textToValidate = textToValidate;
        this.textToCompare = textToCompare;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return textToValidate.equals(textToCompare);
    }

    public static ValidateText with(
            String textToValidate,
            String textToCompare) {
        return new ValidateText(textToValidate, textToCompare);
    }
}
