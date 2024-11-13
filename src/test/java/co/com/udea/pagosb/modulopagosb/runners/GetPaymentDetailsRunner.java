package co.com.udea.pagosb.modulopagosb.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/get_payment_details.feature/",
        glue = "co.com.udea.pagosb.modulopagosb.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class GetPaymentDetailsRunner {}