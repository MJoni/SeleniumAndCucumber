package com.qa.seleniumandcucumber.Selenium;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver;

    @Before("")
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1366, 768));

    }
    @Test
    public void newTestCase(){
        //step 1
        driver.get("http://automationpractice.com/index.php");
        try {
            Thread.sleep(2000);
            //step 2
            WebElement target = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"));
            target.click();
            Thread.sleep(1000);
            //step 3
            target = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a"));
            String expectedProduct = target.getText();
            System.out.println(expectedProduct);
            target.click();
            Thread.sleep(1000);

            //step 4
            WebElement button = driver.findElement(By.id("add_to_cart"));
            button.click();
            Thread.sleep(2000);

            //step 5
            driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")).click();
            Thread.sleep(1000);

            String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a")).getText();
            System.out.println(actual);

            //step 6
            assertEquals(expectedProduct,actual);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void taskTestOne() throws InterruptedException {
        driver.get("http://thedemosite.co.uk/");

        WebElement users = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
        users.click();

        WebElement name = driver.findElement(By.name("username"));
        name.sendKeys("mjoni");

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("123456");

        //click button
        driver.findElement(By.name("FormsButton2")).click();

        Thread.sleep(1000);
        WebElement login = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
        login.click();

        WebElement actulName = driver.findElement(By.name("username"));
        actulName.sendKeys("mjoni");

        WebElement actualPass = driver.findElement(By.name("password"));
        actualPass.sendKeys("123456");
        //click button
        driver.findElement(By.name("FormsButton2")).click();
        String actual = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();


        assertEquals("**Successful Login**", actual);


    }
    @Test
    public void taskTestThree(){
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        List<WebElement> allElm =driver.findElements(By.className("tabs-divide-two-line clearfix spacer-bottom spacer-top marketsChangeView responsive-tabs"));
        //WebElement risers = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[4]/div[1]/ul/li[2]"));
        //risers.click();
        for(WebElement element: allElm){
            System.out.println(element.getText());
        }


    }
    @Test
    public void taskTestTwoAgain(){
        driver.get("http://automationpractice.com/index.php");


    }
    @Test
    public void taskTestFour() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/newtours/");
        //click register
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
        driver.findElement(By.name("firstName")).sendKeys("Speciment");
        driver.findElement(By.name("lastName")).sendKeys("Version");
        driver.findElement(By.name("phone")).sendKeys("123456");
        driver.findElement(By.name("userName")).sendKeys("Speciment");
        driver.findElement(By.name("address1")).sendKeys("Speciment");
        driver.findElement(By.name("city")).sendKeys("Speciment");
        driver.findElement(By.name("state")).sendKeys("Speciment");
        driver.findElement(By.name("postalCode")).sendKeys("Speciment");
        driver.findElement(By.name("state")).sendKeys("Speciment");
        driver.findElement(By.name("country")).sendKeys("United Kingdom");
        driver.findElement(By.id("email")).sendKeys("Speciment");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")).sendKeys("confirmPassword");
        driver.findElement(By.name("confirmPassword")).sendKeys("confirmPassword");
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();




    }
    @Test
    public void taskTestTwo() throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();

        // An output stream accepts output bytes and sends them to sink.
        OutputStream fileOut = new FileOutputStream("Customers.xlsx");

        // Creating Sheets using sheet object
        XSSFSheet sheet1 = wb.createSheet("Accounts");
        System.out.println("Sheets Has been Created successfully");


        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ID", "NAME", "LASTNAME", "EMAIL",
                "PASSWORD","ADDRESS", "CITY", "STATE", "POSTAL CODE",
                "COUNTRY", "MOBILE PHONE"});
        data.put("2", new Object[]{1, "Pankaj", "Kumar","pkumar@gmail.com", "123456",
                "101 My address", "London", "XOXO", "UK", "0101010101"});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // this creates a new row in the sheet
            Row row = sheet1.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a"));
        WebElement fieldloc = driver.findElement(By.id("email_create"));
        String email ="";
        fieldloc.sendKeys();

    }

    @Test
    public void shoppingTest(){
        driver.get("http://automationpractice.com/index.php");
        String str = driver.getTitle();
    }

    @Test
    public void passionTeaTest(){
        driver.get("http://www.practiceselenium.com/welcome.html");
        String str = driver.getTitle();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}