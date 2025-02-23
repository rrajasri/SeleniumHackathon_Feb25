package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login");
    }

    public void enterCredentials(String userName, String password) {
        WebElement userNameText = driver.findElement(By.id("username"));
        WebElement passwordText = driver.findElement(By.id("password"));

        userNameText.sendKeys(userName);
        passwordText.sendKeys(password);
    }

    public void selectAdminRole() {
        driver.findElement(By.id("mat-select-0")).click();
        driver.findElement(By.id("mat-option-0")).click();
    }

    public void login() {
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
    }
}