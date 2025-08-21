package steps;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.TestPage;

public class TestSteps {
    WebDriver driver;
    TestPage page;

    @Given("user is on the practice form page")
    public void openPracticeForm() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new TestPage(driver);
        page.openPage();
    }

    @When("user fills all valid details")
    public void fillAllValid() {
        page.fillMandatory("John","Doe","john.doe@example.com","9999999999");
    }

    @When("user fills only mandatory details")
    public void fillOnlyMandatory() {
        page.fillMandatory("Jane","Smith","jane.smith@example.com","8888888888");
    }

    @When("user fills mandatory details and uploads picture")
    public void fillAndUploadPic() {
        fillOnlyMandatory();
        page.uploadPicture(System.getProperty("user.dir")+ "/resources/sample.jpg");
    }

    @When("user fills mandatory details and selects hobbies")
    public void fillAndSelectHobbies() {
        fillOnlyMandatory();
        page.selectHobbies();
    }

    @When("user fills mandatory details with mobile {string}")
    public void fillWithMobile(String mobile) {
        page.fillMandatory("Test","User","test.user@example.com", mobile);
    }

    @When("user leaves mandatory details blank")
    public void leaveBlank() {
        // nothing
    }

    @When("user fills with invalid email {string}")
    public void invalidEmail(String email) {
        page.fillMandatory("Test","User", email, "9999999999");
    }

    @When("user fills with mobile {string}")
    public void invalidMobile(String mobile) {
        page.fillMandatory("Test","User","test@example.com", mobile);
    }

    @When("user selects future date of birth")
    public void futureDOB() {
        fillOnlyMandatory();
        page.setFutureDOB();
    }

    @When("user fills everything except gender")
    public void exceptGender() {
    	driver.findElement(By.xpath(""));
        driver.findElement(By.id("firstName")).sendKeys("X");
        driver.findElement(By.id("lastName")).sendKeys("Y");
        driver.findElement(By.id("userEmail")).sendKeys("xy@example.com");
        driver.findElement(By.id("userNumber")).sendKeys("7777777777");
    }

    @When("submits the form")
    public void submitForm(){
        page.clickSubmit();
    }

    @Then("success modal should appear")
    public void verifySuccess(){
        Assert.assertTrue(page.isModalVisible());
        driver.quit();
    }

    @Then("error should be displayed")
    public void verifyError(){
        Assert.assertFalse(page.isModalVisible());
        driver.quit();
    }
}
