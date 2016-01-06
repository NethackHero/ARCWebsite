/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arc.test;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.Set;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author jiebing
 */
public class Home {
    private WebDriver createWebDriver(){
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    
    private void goToWebLink(WebDriver driver){
        driver.get("http://www.aredcent.com.au");
    }
    
    private void switchLastWindow(WebDriver driver, String homeHandle){
        Set<String> handles = driver.getWindowHandles();
        
        
        Iterator iterator = handles.iterator();
        
        while(iterator.hasNext()){
            Object nextHandle = iterator.next();
            if(!homeHandle.equals(nextHandle)){
                driver.switchTo().window(nextHandle.toString());
            }
        }
    }
    
    private void waitTillClickable(WebDriver driver, By variableClickable){
        
        /**
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        **/
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //By byLinkText = By.linkText("something");
        ExpectedCondition<WebElement> expect = ExpectedConditions.elementToBeClickable(variableClickable);
        WebElement element = wait.until(expect);
        
    }
    
    private void waitTillDisplayed(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ExpectedCondition<WebElement> expect = ExpectedConditions.visibilityOfElementLocated(element);
        wait.until(expect);
    }
    
    private void waitTillInvisible(WebDriver driver, By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> expect = ExpectedConditions.invisibilityOfElementLocated(element);
        wait.until(expect);
    }

    
    private void clickAfterElementClickable(WebDriver driver, By element){
        waitTillClickable(driver, element);
        driver.findElement(element).click();
    }
    
    private void scrollDown(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver; //nb casting
        jse.executeScript("scroll(0,2000);");
    }
    
    private String getTextAfterElementDisplayed(WebDriver driver, By element){
        waitTillDisplayed(driver, element);
        return driver.findElement(element).getText();
    }
    
    private void waitSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Home() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/home/jiebing/Documents/Testing/chromedriver");
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void navCategoryHealth(){
        WebDriver driver = createWebDriver();
        
        goToWebLink(driver);
        clickAfterElementClickable(driver, By.linkText("Deals Categories"));
        clickAfterElementClickable(driver, By.linkText("Health and Beauty"));
        
        String healthTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Health and beauty - Best deals for you !", healthTitle);
        driver.quit();
    }
    
    @Test
    public void navCategoryCafe(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("Deals Categories"));
        clickAfterElementClickable(driver, By.linkText("Cafes and Restaurants"));
        
        String cafeTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Cafes and restaurants - Best deals for you !", cafeTitle);
        driver.quit();
    }
    
    @Test
    public void navCategoryFashion(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("Deals Categories"));
        clickAfterElementClickable(driver, By.linkText("Fashion and Accessories"));
        
        String fashionTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Fashion and accessories - Best deals for you !", fashionTitle);
        driver.quit();
        
    }
    
    @Test
    public void navCategoryArt(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver,By.linkText("Deals Categories"));
        clickAfterElementClickable(driver, By.linkText("Art and Crafts"));
        
        String artTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Art and crafts - Best deals for you !", artTitle);
        driver.quit();
    }
    
    @Test
    public void navGiveAway(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("Give Away Vouchers"));
        
        String url = driver.getCurrentUrl();
        assertEquals("http://www.aredcent.com.au/giveawayoffers-Parramatta", url);
        driver.quit();
    }
    
    @Test
    public void navRegister(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("Register Your Offers"));
        
        String url = driver.getCurrentUrl();
        assertEquals("http://aredcent.com.au/Login.aspx", url);
        driver.quit();
    }
    
    @Test
    public void iconCategoryHealth(){
        WebDriver driver = createWebDriver();
        
        goToWebLink(driver);
        driver.manage().window().maximize();
        
        clickAfterElementClickable(driver, By.xpath("//img[@src='images/AssetImage/CategPop_af76d361-41d8-4734-96ef-4c2d9fca1a9a.png']"));

        String healthTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Health and beauty - Best deals for you !", healthTitle);
        
        
        driver.quit();
    }
    
    @Test
    public void iconCategoryCafe(){
        WebDriver driver = createWebDriver();
        
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.xpath("//img[@src='images/AssetImage/CategPop_7c737ec9-4415-4bd2-b06a-05245342f347.png']"));
        
        String cafeTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Cafes and restaurants - Best deals for you !", cafeTitle);
        
        driver.quit();
    }
    
    @Test
    public void iconCategoryFashion(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.xpath("//img[@src='images/AssetImage/CategPop_9152a71e-6471-423f-a024-380a925ee0ef.png']"));
        String fashionTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Fashion and accessories - Best deals for you !", fashionTitle);
        
        driver.quit();
    }
    
    @Test
    public void iconCategoryArt(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.xpath("//img[@src='images/AssetImage/CategPop_347ad0b2-dacc-44c1-92b5-617f1ad3a448.png']"));
        String artTitle = driver.findElement(By.className("page-title1")).getText();
        assertEquals("Art and crafts - Best deals for you !", artTitle);
        
        driver.quit();
    }
    
    @Test
    public void footerLinksTerms(){
        System.out.println("Checking footer links ... terms&conditions, privacy, FAQ, Contact");
        WebDriver driver = createWebDriver();
        driver.manage().window().maximize();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("Term & conditions"));
        String termsTitle = driver.findElement(By.className("page-title")).getText();
        assertEquals("Terms and Condition", termsTitle);
        goToWebLink(driver);
        
        driver.quit();
    }
    
    @Test
    public void footerLinksPrivacy(){
        WebDriver driver = createWebDriver();
        driver.manage().window().maximize();
        goToWebLink(driver);
        
        
        clickAfterElementClickable(driver, By.linkText("Privacy"));
        String privacyTitle = driver.findElement(By.className("page-title")).getText();
        assertEquals("Privacy Policy", privacyTitle);
        
        driver.quit();
    }
    
    @Test
    public void footerLinksFaq(){
        WebDriver driver = createWebDriver();
        driver.manage().window().maximize();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("FAQ"));
        
        String FAQTitle = driver.findElement(By.className("page-title")).getText();
        assertEquals("FAQ", FAQTitle);
        
        driver.quit();
    }
    
    @Test
    public void footerLinksContact(){
        WebDriver driver = createWebDriver();
        driver.manage().window().maximize();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.linkText("Contact"));
        
        String ContactTitle = driver.findElement(By.className("page-title")).getText();
        assertEquals("Contact Us", ContactTitle);
        
        driver.quit();
    }
    
    @Test
    public void footerSocialLinksFacebook(){
        System.out.println("Checking footer social links");
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        String homeHandle = driver.getWindowHandle();
        clickAfterElementClickable(driver, By.xpath("//a[@class='fb']"));
        
        //waitTillClickable(driver);
        switchLastWindow(driver, homeHandle);
        String fbUrl = driver.getCurrentUrl();
        String expFbUrl = "https://www.facebook.com/aredcentdeals/";
        assertEquals(expFbUrl, fbUrl);
        //driver.close();
        //driver.switchTo().window(homeHandle);
        
        driver.quit();
    }
    
    @Test
    public void footerSocialLinksTwitter(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        String homeHandle = driver.getWindowHandle();
        
        clickAfterElementClickable(driver, By.xpath("//a[@class='tw']"));
        switchLastWindow(driver, homeHandle);
        
        String twUrl = driver.getCurrentUrl();
        String expTwUrl = "https://twitter.com/a_red_cent";
        assertEquals(expTwUrl, twUrl);
        //driver.close();
        //driver.switchTo().window(homeHandle);
        driver.quit();
        
    }
    
    @Test
    public void footerSocialLinksLinkedin(){
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        String homeHandle = driver.getWindowHandle();
        
        clickAfterElementClickable(driver, By.xpath("//a[@class='log']"));
        switchLastWindow(driver, homeHandle);
        
        String liUrl = driver.getCurrentUrl();
        String expLiUrl = "https://www.linkedin.com/company/a-red-cent";
        assertEquals(expLiUrl, liUrl);
        driver.quit();
    }
    
    @Test
    public void keepMeUpdatedEmpty(){
        System.out.println("Clicking on the newsletter subscribe now button while not entering anything...");
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        
        clickAfterElementClickable(driver, By.id("white_bttn"));
        String invalidCaptchaText = getTextAfterElementDisplayed(driver, By.xpath("//div[@id='MyInvalid_Captcha']/p"));

        assertEquals("Invalid Captcha Code", invalidCaptchaText);
        
        driver.findElement(By.id("closeInvalid")).click();
        waitTillInvisible(driver, By.xpath("//div[@id='MyInvalid_Captcha']/p"));
        Boolean isTextDisplayed = driver.findElement(By.xpath("//div[@id='MyInvalid_Captcha']/p")).isDisplayed();
        assertFalse(isTextDisplayed);
        driver.quit();
    }
    
    @Test
    public void searchNothing(){
        System.out.println("Searching without input...");
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        clickAfterElementClickable(driver, By.id("Btn_Go"));
        By errorTextElement = By.xpath("//div[@id='myModal']/p");
        String errorText = getTextAfterElementDisplayed(driver, errorTextElement);
        assertEquals("Please provide search criteria before Searching.", errorText);
        driver.findElement(By.id("closemyModal")).click();
        
        
        waitTillInvisible(driver, errorTextElement);
        Boolean isTextDisplayed = driver.findElement(errorTextElement).isDisplayed();
        System.out.println(isTextDisplayed);
        assertFalse(isTextDisplayed);
        driver.quit();
    }
    
    @Test
    public void searchWithoutCat(){
        System.out.println("Searching 'toy' without category selected");
        WebDriver driver = createWebDriver();
        goToWebLink(driver);
        //waitTillClickable(driver);
        System.out.println("Using enter/return key");
        waitTillDisplayed(driver, By.id("sys_txt_search"));
        driver.findElement(By.id("sys_txt_search")).sendKeys("toy");
        //waitTillClickable(driver);
        waitSeconds();
        driver.findElement(By.id("sys_txt_search")).sendKeys(Keys.RETURN);
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://www.aredcent.com.au/offer-search/toy-Parramatta";
        assertEquals(expectedUrl, currentUrl);
        goToWebLink(driver);
        System.out.println("Using search button");
        driver.findElement(By.id("sys_txt_search")).sendKeys("toy");
        //waitTillClickable(driver);
        waitSeconds();
        clickAfterElementClickable(driver, By.id("Btn_Go"));
        currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
        driver.quit();
    }
}
