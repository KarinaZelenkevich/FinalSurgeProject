package tests;

import io.qameta.allure.Description;
import models.CaloricNeeds;
import models.CaloricNeedsFactory;
import models.PaceCalculator;
import models.PaceCalculatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CaloricNeedsModalPage;
import pages.PaceCalculatorModalPage;
import utils.AllureUtils;


public class OtherCalculatorTest extends BaseTest {


    @Test(description = "Using 'Other Calculators' to calculate daily caloric needs")
    @Description(value = "Using 'Other Calculators' to calculate daily caloric needs")
    public void calculateCaloricNeedsTest() {
        loginPage
                .open()
                .login(email, password);
        CaloricNeeds form = CaloricNeedsFactory.getDataFromTheForm();
        CaloricNeedsModalPage
                .open()
                .fillForm(form)
                .clickCalculateButton();
        Assert.assertTrue(caloricNeedsModalPage.isPageOpen(), "CaloricNeeds page wasn't opened");
    }

    @Test(description = "Using 'Other Calculators' to calculate pace")
    @Description(value = "Using 'Other Calculators' to calculate pace")
    public void paceCalculatorTest() {
        loginPage
                .open()
                .login(email, password);
        CaloricNeedsModalPage
                .open()
                .clickPaceCalculatorButton();
        PaceCalculator form = PaceCalculatorFactory.getDataFromTheForm();
        PaceCalculatorModalPage
                .fillInForm(form)
                .clickCalculateButton();
        Assert.assertTrue(paceCalculatorModalPage.paceChartTableIsVisible(), "Results table has not been opened");
    }
}