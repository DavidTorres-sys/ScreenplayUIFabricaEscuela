package co.com.udea.pagosb.modulopagosb.utils;

import co.com.udea.pagosb.modulopagosb.models.CardForm;

public class CardFormBuild {

    public static CardForm validForm() {
        CardForm cardForm = new CardForm();
        cardForm.setCardHolderName("John Doe");
        cardForm.setCardNumber("1234567890123456");
        cardForm.setExpirationMonth("Agosto");
        cardForm.setExpirationYear("2027");
        cardForm.setCvv("777");
        return cardForm;
    }

    public static CardForm invalidForm() {
        CardForm cardForm = new CardForm();
        cardForm.setCardHolderName("John Doe");
        cardForm.setCardNumber("123423456");
        cardForm.setExpirationMonth("Marzo");
        cardForm.setExpirationYear("2020");
        cardForm.setCvv("777");
        return cardForm;
    }
}
