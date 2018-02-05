package someNewPack;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class main{

  WebDriver driver;

  @Test(description = "Some first test")
  @Description("Some new test1")
  public void firstTest(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://webmaker.org/");
    driver.findElement(By.xpath("//a[text()='Try Thimble']")).click();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertThat(driver.findElement(By.xpath("//span[text()='Start a project from scratch']")).isDisplayed()).isTrue();
    driver.quit();
  }

  @AfterTest
  public void after(){
    driver.quit();
  }
}
