package co.com.udea.pagosb.modulopagosb.models;

import lombok.Data;

@Data
public class CardForm {
    private String CardHolderName;
    private String CardNumber;
    private String ExpirationMonth;
    private String ExpirationYear;
    private String Cvv;
}
