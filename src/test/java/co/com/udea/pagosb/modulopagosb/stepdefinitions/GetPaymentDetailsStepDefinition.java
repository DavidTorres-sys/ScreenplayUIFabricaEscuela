package co.com.udea.pagosb.modulopagosb.stepdefinitions;

import co.com.udea.pagosb.modulopagosb.questions.ParameterToValidate;
import co.com.udea.pagosb.modulopagosb.tasks.FindThe;
import co.com.udea.pagosb.modulopagosb.tasks.NavigateToPurchaseSummaryPage;
import co.com.udea.pagosb.modulopagosb.userinterfaces.UserPage;
import co.com.udea.pagosb.modulopagosb.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class GetPaymentDetailsStepDefinition {

    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String url = environmentVariables.getProperty("webdriver.base.url");

    /**
     * Setup method executed before the tests begin. Configures the actor and RestAssured settings.
     * This method ensures that the actor is ready to perform tasks
     */
    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        Actor actor = OnStage.theActorCalled("actor");
        actor.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
    }

    @Given("that the user is on the purchase summary page")
    public void thatTheUserIsOnThePurchaseSummaryPage() {
        OnStage.theActorCalled("actor").attemptsTo(
                NavigateToPurchaseSummaryPage.to(this.url)
        );
        OnStage.theActorCalled("actor")
                .should(seeThat(ParameterToValidate
                        .with(Constants.PURCHASE_SUMMARY_PAGE_TITLE_STRING, UserPage.PURCHASE_SUMMARY_PAGE_TITLE.toString()), is(true))
        );
    }

    @When("the user displays the purchase details tab")
    public void theUserDisplaysThePurchaseDetailsTab() {
        OnStage.theActorCalled("actor").attemptsTo(
                FindThe.element(UserPage.FLIGHT_FARE_DROPDOWN)
        );
        OnStage.theActorCalled("actor").attemptsTo(
                FindThe.element(UserPage.TAXES_DROPDOWN)
        );
        OnStage.theActorCalled("actor").attemptsTo(
                FindThe.element(UserPage.ADDITIONAL_CHARGES_DROPDOWN)
        );
    }

    @Then("the system should display the detailed breakdown of the purchase, including taxes, fees and additional charges")
    public void theSystemShouldDisplayTheDetailedBreakdownOfThePurchaseIncludingTaxesFeesAndAdditionalCharges() {

    }

    @Given("that the system has displayed the breakdown of the purchase costs")
    public void thatTheSystemHasDisplayedTheBreakdownOfThePurchaseCosts() {

    }

    @When("the system adds up the value of each item on the invoice")
    public void theSystemAddsUpTheValueOfEachItemOnTheInvoice() {

    }

    @Then("the system should calculate the total amount of the purchase")
    public void theSystemShouldCalculateTheTotalAmountOfThePurchase() {
    }
}
