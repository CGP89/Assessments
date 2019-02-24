package PageObjects;

import Utils.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UltimateQA_Forms extends DriverUtil {


    public UltimateQA_Forms(){

        PageFactory.initElements(driver, this);
    }


   @FindBy(id = "et_pb_contact_name_0")
    @CacheLookup
    WebElement contactNameInput;

   @FindBy(id = "et_pb_contact_message_0")
    @CacheLookup
    WebElement contactMessageInput;

    @FindBy(className = "et_pb_contact_submit")
    @CacheLookup
    WebElement submitButton;

    @FindBy(xpath = "//p[text()='Form filled out successfully']")
    @CacheLookup
    WebElement SuccessfullyFilledOutForm;

public void navigateToFormsPage(){
    driver.navigate().to("https://www.ultimateqa.com/filling-out-forms/");
}

public boolean validateSubmit(){
wait(SuccessfullyFilledOutForm);
    return true;
}

public void enterName(String name){
    contactNameInput.sendKeys(name);

}

public void enterMessage(String message){
    contactMessageInput.sendKeys(message);
}

public void clickSubmit(){
    submitButton.click();
}
}
