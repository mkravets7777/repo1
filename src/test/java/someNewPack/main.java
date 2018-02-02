package someNewPack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class main{

  WebDriver driver;

  @Test
  public void firstTest(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://webmaker.org/");
    driver.manage().window().maximize();
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
