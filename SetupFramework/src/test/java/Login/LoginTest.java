package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {


    @Test
    public void testLoginIntoSpree() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        // Thread.sleep(5);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("link-to-login")));
        WebElement login_icon = driver.findElement(By.id("link-to-login"));
        login_icon.click();
        WebElement userEmail =  driver.findElement(By.id("spree_user_email"));
        userEmail.sendKeys("jency@gmail.com");
        WebElement userPassword = driver.findElement(By.id("spree_user_password"));
        userPassword.sendKeys("jency123");
        WebElement clickLogin = driver.findElement(By.name("commit"));
        clickLogin.click();
        String success_message = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText();
        Assert.assertEquals(success_message,"Logged in successfully");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
        //driver.findElement(By.linkText("Logout")).click();
        WebElement logout_icon = driver.findElement(By.linkText("Logout"));
        logout_icon.click();
        driver.close();
    }
    @Test
    public void validUserLogin(){
        System.setProperty("webdriver.chrome.driver","/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("link-to-login")));
        WebElement login_icon = driver.findElement(By.id("link-to-login"));
        login_icon.click();
        WebElement userEmail =  driver.findElement(By.id("spree_user_email"));
        userEmail.sendKeys("jency@gmail.com");
        WebElement userPassword = driver.findElement(By.id("spree_user_password"));
        userPassword.sendKeys("jency123");
        WebElement clickLogin = driver.findElement(By.name("commit"));
        clickLogin.click();
        String success_message = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText();
        Assert.assertEquals(success_message,"Logged in successfully");
        driver.close();
    }
    @Test
    public void invalidUserLogin(){
        System.setProperty("webdriver.chrome.driver","/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("link-to-login")));
        WebElement login_icon = driver.findElement(By.id("link-to-login"));
        login_icon.click();
        WebElement userEmail =  driver.findElement(By.id("spree_user_email"));
        userEmail.sendKeys("jency@gmail.com");
        WebElement userPassword = driver.findElement(By.id("spree_user_password"));
        userPassword.sendKeys("jency1234");
        WebElement clickLogin = driver.findElement(By.name("commit"));
        clickLogin.click();
        String invalidUserLoginMessage = driver.findElement(By.cssSelector("#content > div.alert.alert-error")).getText();
        Assert.assertEquals(invalidUserLoginMessage,"Invalid email or password.");
        driver.close();
    }
    @Test
    public void logoutSuccessfulMessage(){
        System.setProperty("webdriver.chrome.driver","/Users/jency.saral/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        //driver.quit();
        // Thread.sleep(5);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("link-to-login")));
        WebElement login_icon = driver.findElement(By.id("link-to-login"));
        login_icon.click();
        WebElement userEmail =  driver.findElement(By.id("spree_user_email"));
        userEmail.sendKeys("jency@gmail.com");
        WebElement userPassword = driver.findElement(By.id("spree_user_password"));
        userPassword.sendKeys("jency123");
        WebElement clickLogin = driver.findElement(By.name("commit"));
        clickLogin.click();
        String success_message = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText();
        Assert.assertEquals(success_message,"Logged in successfully");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
        //driver.findElement(By.linkText("Logout")).click();
        WebElement logout_icon = driver.findElement(By.linkText("Logout"));
        logout_icon.click();
        String invalidUserLoginMessage = driver.findElement(By.cssSelector("#content > div.alert.alert-notice")).getText();
        Assert.assertEquals(invalidUserLoginMessage,"Signed out successfully.");
        driver.close();
    }
}
