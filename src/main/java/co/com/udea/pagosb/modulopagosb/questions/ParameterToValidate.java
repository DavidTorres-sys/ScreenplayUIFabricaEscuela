package co.com.udea.pagosb.modulopagosb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ParameterToValidate implements Question<Boolean> {

    private final String toValidate;
    private final String toCompare;

    public ParameterToValidate(
            String toValidate,
            String toCompare) {
        this.toValidate = toValidate;
        this.toCompare = toCompare;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return toValidate.equals(toCompare);
    }

    public static ParameterToValidate with(
            String toValidate,
            String toCompare) {
        return new ParameterToValidate(toValidate, toCompare);
    }
}
