package Tests;

import PageObjects.UltimateQA_Forms;
import Utils.DriverUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class UltimateQA_Forms_Test extends DriverUtil {

    public UltimateQA_Forms uForms;
    public Properties prop;

    @BeforeMethod
    public void StartTest()throws FileNotFoundException, IOException
    {
    startDriver();
        prop = new Properties();
    prop.load(new FileInputStream("./src/test/java/Properties/UltimateQA_Forms_Test"));
    uForms = new UltimateQA_Forms();
    }

    @Test
    public void FormsTest(){
        uForms.navigateToFormsPage();
        uForms.enterName(prop.getProperty("name"));
        uForms.enterMessage(prop.getProperty("message"));
        uForms.clickSubmit();
        Assert.assertTrue(uForms.validateSubmit());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
