package co.com.udea.pagosb.modulopagosb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;


public class GetCurrentUrl implements Question<String>
{
    private final WebDriver driver = ThucydidesWebDriverSupport.getDriver();

    public static GetCurrentUrl create(){
        return new GetCurrentUrl();
    }

    @Override
    public String answeredBy(Actor actor) {
        String fullUrl = driver.getCurrentUrl();
        String[] domain = fullUrl.split("/");
        return domain[2];

    }
}

