package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class TextArea {

    private static final String inputTextArea = ("//textarea[@id='%s']") ;
    private static final String inputTextAreaInFullAdd = ("//textarea[@name='%s']");

    WebDriver driver;
    String label;

    public TextArea(WebDriver driver, String label) {
        this.label = label;
        this.driver = driver;
    }

    public void write(String text) {
        log.info("Send text to textarea {} ", label);
        driver.findElement(By.xpath(String.format(inputTextArea, this.label))).sendKeys(text);
    }

    public void writeFullAdd(String text) {
        log.info("Send text to textarea {} ", label);
        driver.findElement(By.xpath(String.format(inputTextAreaInFullAdd, this.label))).sendKeys(text);
    }
}