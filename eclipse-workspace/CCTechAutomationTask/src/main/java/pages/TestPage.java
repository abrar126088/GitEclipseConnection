package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestPage {
	

	
	    WebDriver driver;
	    public TestPage(WebDriver driver) { this.driver = driver; }

	    By firstName = By.id("firstName");
	    By lastName = By.id("lastName");
	    By email = By.id("userEmail");
	    By maleGender = By.xpath("//label[text()='Male']");
	    By mobile = By.id("userNumber");
	    By dob = By.id("dateOfBirthInput");
	    By pictureUpload = By.id("uploadPicture");
	    By hobbiesSport = By.xpath("//label[text()='Sports']");
	    By submitBtn = By.id("submit");
	    By modal = By.id("example-modal-sizes-title-lg");

	    public void openPage() { driver.get("https://demoqa.com/automation-practice-form"); }
	    public void fillMandatory(String fn, String ln, String mail, String mob) {
	        driver.findElement(firstName).sendKeys(fn);
	        driver.findElement(lastName).sendKeys(ln);
	        driver.findElement(email).sendKeys(mail);
	        driver.findElement(maleGender).click();
	        driver.findElement(mobile).sendKeys(mob);
	    }
	    public void uploadPicture(String path) { driver.findElement(pictureUpload).sendKeys(path); }
	    public void selectHobbies() { driver.findElement(hobbiesSport).click(); }
	    public void setFutureDOB() {
	        WebElement ds = driver.findElement(dob);
	        ds.clear();
	        ds.sendKeys("01 Jan 3000");
	    }
	    public void clickSubmit() { driver.findElement(submitBtn).click(); }
	    public boolean isModalVisible() {
	        return driver.findElement(modal).isDisplayed();
	    }
	}


