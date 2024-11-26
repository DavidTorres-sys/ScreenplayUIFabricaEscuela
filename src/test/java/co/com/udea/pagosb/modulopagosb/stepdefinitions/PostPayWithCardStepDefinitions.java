package co.com.udea.pagosb.modulopagosb.stepdefinitions;

import co.com.udea.pagosb.modulopagosb.questions.ParameterToValidate;
import co.com.udea.pagosb.modulopagosb.tasks.FindThe;
import co.com.udea.pagosb.modulopagosb.tasks.NavigateTo;
import co.com.udea.pagosb.modulopagosb.tasks.ProvideCardDetails;
import co.com.udea.pagosb.modulopagosb.userinterfaces.PaymentPage;
import co.com.udea.pagosb.modulopagosb.userinterfaces.UserPage;
import co.com.udea.pagosb.modulopagosb.utils.CardFormBuild;
import co.com.udea.pagosb.modulopagosb.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PostPayWithCardStepDefinitions {

    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String url = environmentVariables.getProperty("webdriver.base.url");
    private Actor actor;

    /**
     * Setup method executed before the tests begin. Configures the actor and browser.
     */
    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("actor");
        actor.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
    }

    @Given("The user is on the payment page")
    public void theUserIsOnThePaymentPage() {
        actor.attemptsTo(NavigateTo.to(this.url));
        actor.should(seeThat(ParameterToValidate.
                        with(Constants.PURCHASE_SUMMARY_PAGE_TITLE_STRING, Text.of(UserPage.PURCHASE_SUMMARY_PAGE_TITLE).answeredBy(actor)),
                is(true)));
    }

    @When("The user selects the option to pay with a credit card or debit card")
    public void theUserSelectsTheOptionToPayWithADebitCard() {
        actor.attemptsTo(
                FindThe.element(UserPage.BTN_PAYMENT_WITH_CARD)
        );
        actor.attemptsTo(
                FindThe.element(UserPage.BTN_CONTINUE)
        );
    }

    @And("The user provides the card details \\(card number, expiration date, CVV)")
    public void theUserProvidesTheCardDetailsCardNumberExpirationDateCVV() {
        actor.attemptsTo(ProvideCardDetails.with(CardFormBuild.validForm()));
        actor.attemptsTo(
                FindThe.element(PaymentPage.BTN_CONFIRM_PURCHASE)
        );
    }

    @Then("The user sees a payment confirmation message")
    public void theUserSeesAPaymentConfirmationMessage() {
        actor.should(seeThat(
                ParameterToValidate.
                        with(Text.of(PaymentPage.PURCHASE_SUCCESSFUL_MESSAGE).answeredBy(actor), Constants.PURCHASE_SUCCESSFUL_MESSAGE_STRING),
                is(true)
        ));
    }

    @And("The user push the button to navegate to the next page")
    public void theUserPushTheButtonToNavegateToTheNextPage() {
        actor.attemptsTo(
                FindThe.element(PaymentPage.BTN_BACK_TO_HOME)
        );
    }

    @And("The user provides invalid card information \\(invalid card number, expired expiration date, incorrect CVV)")
    public void theUserProvidesInvalidCardInformationInvalidCardNumberExpiredExpirationDateIncorrectCVV() {
        actor.attemptsTo(ProvideCardDetails.with(CardFormBuild.invalidForm()));
        actor.attemptsTo(
                FindThe.element(PaymentPage.BTN_CONFIRM_PURCHASE)
        );
    }

    @Then("The user sees an error message indicating that the provided information is invalid")
    public void theUserSeesAnErrorMessageIndicatingThatTheProvidedInformationIsInvalid() {
        actor.should(seeThat(
                ParameterToValidate.
                        with(Text.of(PaymentPage.PURCHASE_UNSUCCESSFUL_MESSAGE).answeredBy(actor), Constants.PURCHASE_SUCCESSFUL_MESSAGE_STRING),
                is(true)
        ));
    }

}
