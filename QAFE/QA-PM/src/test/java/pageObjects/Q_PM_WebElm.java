package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Q_PM_Init;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.By.className;

public class Q_PM_WebElm extends Q_PM_Init {

    public static void myWait(Integer duration) {
        try {
            Thread.sleep(duration);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
    public static void frameElement() {
        WebElement frameElement = driver.findElement(By.xpath("//body/iframe[2]"));
        driver.switchTo().frame(frameElement);
    }
    public static void moveIt(Properties proper, String locator) {
        String seleniumElement = proper.getProperty(locator);
        Actions moveTo = new Actions(driver);
        WebElement other = driver.findElement(By.xpath(seleniumElement));
        moveTo.moveToElement(other).moveToElement(other).perform();
        myWait(1000);
    }
    public static void moveToId(String id) {
        Actions moveTo = new Actions(driver);
        WebElement myElem = driver.findElement(By.id(id));
        moveTo.moveToElement(myElem).moveToElement(myElem).perform();
    }
    public static void moveToxp(String xp) {
        Actions moveTo = new Actions(driver);
        WebElement myElem = driver.findElement(By.xpath(xp));
        moveTo.moveToElement(myElem).moveToElement(myElem).perform();
    }

    public static void xp(Properties proper, String locator) {
        driver.findElement(By.xpath(proper.getProperty(locator))).click();
    }
    public static void xp(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).click();
    }
    public static void xp(Properties proper, String begxp, Integer row, String midxp, Integer col, String endxp){
        driver.findElement(By.xpath(proper.getProperty(begxp) + row + proper.getProperty(midxp) + col + proper.getProperty(endxp))).click();
    }

    public static void xpText(Properties proper, String locator) {
        driver.findElement(By.xpath(proper.getProperty(locator))).getText();
    }
    public static String xpRetText(Properties proper, String locator) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(locator)));
        element.getText();
        return element.getText();
    }
    public static String xpRetText(Properties proper, String catQtyBeg, Integer item, String catQtyEnd) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)));
        element.getText();
        return element.getText();
    }
    public static String xpRetText(Properties proper, String Beg, Integer record, String mid, Integer item, String End) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(Beg) + record + proper.getProperty(mid)+ item + proper.getProperty(End)));
        element.getText();
        return element.getText();
    }
    public static String xpRetTextReplace(Properties proper, String locator){
        WebElement element = driver.findElement(By.xpath(proper.getProperty(locator)));
        return element.getText().toString().replaceAll("[^0-9?!\\.]","");
    }
    public static String xpRetTextReplace(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        return driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).getText().replaceAll("[^0-9?!\\.]","");
    }
    public static String xpRetTextReplace(Properties proper, String Beg, Integer record, String mid, Integer item, String End) {
        return driver.findElement(By.xpath(proper.getProperty(Beg) + record + proper.getProperty(mid)+ item + proper.getProperty(End))).getText().replaceAll("[^0-9?!\\.]","");
    }
    public static String xpRetAttr(Properties proper, String locator, String attr){
        return driver.findElement(By.xpath(proper.getProperty(locator))).getAttribute(attr);
    }
    public static String xpRetAttr(Properties proper, String catQtyBeg, Integer item, String catQtyEnd, String attr) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)));
        element.getAttribute(attr);
        return element.getAttribute(attr);
    }
    public static String xpReturnAttributeReplace(Properties proper, String locator){
        return driver.findElement(By.xpath(proper.getProperty(locator))).getAttribute("value").replaceAll("[^0-9?!\\.]","");
    }
    public static String xpReturnAttributeReplace(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        return driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).getAttribute("value").replaceAll("[^0-9?!\\.]","");
    }
    public static String xpAttribute(Properties proper, String catQtyBeg, Integer item, String catQtyEnd, String attr) {
        WebElement element = driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)));
        element.getAttribute(attr);
        return element.getAttribute(attr);
    }
    public static String xpReturnReplace(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        return driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).getText().replaceAll("[^0-9?!\\.]","");
    }
    public static void xpClear(Properties proper, String locator) {
        driver.findElement(By.xpath(proper.getProperty(locator))).clear();
    }
    public static void xpClear(Properties proper, String catQtyBeg, Integer item, String catQtyEnd) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).clear();
    }
    public static void xpSend(Properties proper, String locator, String quan) {
        driver.findElement(By.xpath(proper.getProperty(locator))).sendKeys(quan);
    }
    public static void xpSend(Properties proper, String catQtyBeg, Integer item, String catQtyEnd, String quan) {
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(quan);
    }
    public static void xpSendTab(Properties proper, String locator) {
        driver.findElement(By.xpath(proper.getProperty(locator))).sendKeys(Keys.TAB);
    }
    public static void xpSendTab(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(Keys.TAB);
    }
    public static void xpSendEnter(Properties proper, String locator){
        driver.findElement(By.xpath(proper.getProperty(locator))).sendKeys(Keys.ENTER);
    }
    public static void xpSendEnter(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(Keys.ENTER);
    }
    public static void xpSendDelete(Properties proper, String catQtyBeg, Integer item, String catQtyEnd){
        driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).sendKeys(Keys.DELETE);
    }
    public static Boolean xpEnabled(Properties proper, String locator) {
        return driver.findElement(By.xpath(proper.getProperty(locator))).isEnabled();
    }
    public static Boolean xpEnabled(Properties proper, String catQtyBeg, Integer item, String catQtyEnd) {
        return driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd))).isEnabled();
    }
    public static Boolean xpDisplayed(Properties proper, String locator) {
        try {
            driver.findElement(By.xpath(proper.getProperty(locator))).isDisplayed();
            return true;
        }
        catch(Throwable e){
            return false;
        }
    }
    public static Boolean xpDisplayed(Properties proper, String beg, Integer item, String end) {
        try {
            driver.findElement(By.xpath(proper.getProperty(beg) + item + proper.getProperty(end))).isDisplayed();
            return true;
        }
        catch(Throwable e){
            return false;
        }
    }
    public static Boolean xpSelected(Properties proper, String locator) {
        return driver.findElement(By.xpath(proper.getProperty(locator))).isSelected();
    }
    public static Boolean xpSelected(Properties proper, String beg, Integer item, String end) {
        try {
            driver.findElement(By.xpath(proper.getProperty(beg) + item + proper.getProperty(end))).isSelected();
            return true;
        }
        catch(Throwable e){
            return false;
        }
    }
    public static void xpSelectValue(Properties proper, String locator, String sortValue){
        WebElement xpMonth = driver.findElement(By.xpath(proper.getProperty(locator)));
        new Select(driver.findElement(By.xpath(proper.getProperty(locator)))).selectByValue(sortValue);
    }
    public static void xpSelectIndex(Properties proper, String locator, Integer index){
        WebElement xpMonth = driver.findElement(By.xpath(proper.getProperty(locator)));
        new Select(driver.findElement(By.xpath(proper.getProperty(locator)))).selectByIndex(index);
    }
    public static void xpSelectText(Properties proper, String locator, String text){
        WebElement xpMonth = driver.findElement(By.xpath(proper.getProperty(locator)));
        new Select(driver.findElement(By.xpath(proper.getProperty(locator)))).selectByVisibleText(text);
    }

    public static Boolean checkBox(Properties proper, String beg, String item, String end){
        try {
            driver.findElement(By.xpath(proper.getProperty(beg) + item + proper.getProperty(end))).isSelected();
            return true;
        }
        catch(Throwable e){
            return false;
        }
    }
    public static void xpExecutor(Properties proper, String subCategory) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", (driver.findElement(By.xpath(proper.getProperty(subCategory)))));
    }
    public static void xpExecutor(Properties proper,String catQtyBeg, Integer item, String catQtyEnd) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",(driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)))));

    }
    public static Boolean xpExecutorSelect(Properties proper, String subCategory) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(proper.getProperty(subCategory)))).equals(true);
    }
    public static void xpExecutorSend(Properties proper, String locator, String quan) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = quan;", (driver.findElement(By.xpath(proper.getProperty(locator)))));
    }
    public static void xpExecutorSend(Properties proper,String catQtyBeg, Integer item, String catQtyEnd, String quan) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value = quan;",(driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)))));
    }
    public static void xpExecutorScrolToElement(Properties proper,String xp) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()",(driver.findElement(By.xpath(proper.getProperty(xp)))));
    }
    public static void xpExecutorScrolToElement(Properties proper,String catQtyBeg, Integer item, String catQtyEnd) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()",(driver.findElement(By.xpath(proper.getProperty(catQtyBeg) + item + proper.getProperty(catQtyEnd)))));
    }
    /********************************************************************************************************
     ********************************************************************************************************/

    public static void id(Properties proper, String locator){
        driver.findElement(By.id(proper.getProperty(locator))).click();
    }
    public static void idExecutor(Properties proper, String locator){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", (driver.findElement(By.id(proper.getProperty(locator)))));
    }
    public static void idExecutorScrolToElement(Properties proper,String id) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()",(driver.findElement(By.id(proper.getProperty(id)))));
    }
    public static String idRetText(Properties proper, String locator){
        return driver.findElement(By.id(proper.getProperty(locator))).getText();
    }
    public static String idRetTextRep(Properties proper, String locator){
        return driver.findElement(By.id(proper.getProperty(locator))).getText().replaceAll("[^0-9?!\\.]","");
    }
    public static String idAttrRet(Properties proper, String locator, String attr){

        return driver.findElement(By.id(proper.getProperty(locator))).getAttribute(attr);
    }
    public static String idRetSelectedText(Properties proper, String locator) {

        Select supplier = new Select(driver.findElement(By.id(proper.getProperty(locator))));
        WebElement option = supplier.getFirstSelectedOption();

        return option.getText();
    }
    public static void idClear(Properties proper, String locator){
        driver.findElement(By.id(proper.getProperty(locator))).clear();
    }
    public static void idSend(Properties proper, String locator, String quan){
        driver.findElement(By.id(proper.getProperty(locator))).sendKeys(quan);
    }
    public static void idSendTab(Properties proper, String locator){
        driver.findElement(By.id(proper.getProperty(locator))).sendKeys(Keys.TAB);
    }
    public static void idSendchord(Properties proper, String locator, String quan){
        driver.findElement(By.id(proper.getProperty(locator))).sendKeys(Keys.HOME,Keys.chord(Keys.HOME),quan,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);;
    }
    public static Boolean idDisplayed(Properties proper, String locator) {
        try{
            return driver.findElement(By.id(proper.getProperty(locator))).isDisplayed();
        }
        catch(Throwable e){
            return false;
        }
    }
    public static void idSelectValue(Properties proper, String locator, String monthV){
        WebElement xpMonth = driver.findElement(By.id(proper.getProperty(locator)));
        new Select(driver.findElement(By.id(proper.getProperty(locator)))).selectByValue(monthV);
    }
    public static void idSelectIndex(Properties proper, String locator, Integer year){
        WebElement xpMonth = driver.findElement(By.id(proper.getProperty(locator)));
        new Select(driver.findElement(By.id(proper.getProperty(locator)))).selectByIndex(year);
    }
    public static void idSelectText(Properties proper, String locator, String year){
        WebElement xpMonth = driver.findElement(By.id(proper.getProperty(locator)));
        new Select(driver.findElement(By.id(proper.getProperty(locator)))).selectByVisibleText(year);
    }
    public static Boolean idEnabled(Properties proper, String locator) {
        return driver.findElement(By.id(proper.getProperty(locator))).isEnabled();
    }

    /********************************************************************************************************
     ********************************************************************************************************/

    public static void name(Properties proper, String locator){

        driver.findElement(By.name(proper.getProperty(locator))).click();
    }
    public static String nameRetText(Properties proper, String cartProp) {
        return driver.findElement(By.name(proper.getProperty(cartProp))).getText();
    }

    public static Boolean nameSelected(Properties proper, String locator){

        return driver.findElement(By.name(proper.getProperty(locator))).isSelected();
    }
    public static String  nameRetAttr(Properties proper, String locator, String attr) {
        WebElement element = driver.findElement(By.name(proper.getProperty(locator)));
        return element.getAttribute(attr);

    }
    public static void nameSelectValue(Properties proper, String locator, String sortValue){
        WebElement xpMonth = driver.findElement(By.name(proper.getProperty(locator)));
        new Select(driver.findElement(By.name(proper.getProperty(locator)))).selectByValue(sortValue);
    }


    /********************************************************************************************************
     ********************************************************************************************************/

    public static void cn(Properties proper, String metalType) {

        driver.findElement(By.className(proper.getProperty(metalType))).click();
    }

    public static String cnRetText(Properties proper, String cartProp) {
        return driver.findElement(By.className(proper.getProperty(cartProp))).getText();
    }

    public static Boolean cnDisplayed(Properties proper, String locator) {

        return driver.findElement(By.className(proper.getProperty(locator))).isDisplayed();
    }
    public static Boolean cnEnabled(Properties proper, String locator) {

        return driver.findElement(By.className(proper.getProperty(locator))).isEnabled();
    }
    public static void cnExecutor(Properties proper, String locator) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",(driver.findElement(By.className(proper.getProperty(locator)))));
    }
    public static void cnSelectValue(Properties proper, String locator, String value){
        WebElement xpSort = driver.findElement(className(proper.getProperty(locator)));
        new Select(driver.findElement(className(proper.getProperty(locator)))).selectByValue(value);
    }
    public static List<String> cnReturnAllOptions(Properties proper, String locator){
        Select payment = new Select(driver.findElement(By.className(proper.getProperty(locator))));
        List<WebElement> paymentTypes = payment.getOptions();
        List<String> ls = new ArrayList<String>();

        for(WebElement a : paymentTypes){
            if(a.isEnabled()&&(!a.getAttribute("value").matches(".*^x.*"))){

                ls.add(a.getAttribute("value"));
                ls.remove(a.getAttribute("value").equals(payment.getFirstSelectedOption()));
            }
        }
        return ls;
    }
    public static void cnmove(Properties proper, String locator){

        new Actions(driver).moveToElement(driver.findElement(className(proper.getProperty(locator)))).perform();
    }
    /********************************************************************************************************
     ********************************************************************************************************/

    public static void linkText(Properties proper, String locator){
        driver.findElement(By.linkText(proper.getProperty(locator))).click();
    }
    public static Boolean linkTextDisplayed(Properties proper, String locator){
        return driver.findElement(By.linkText(proper.getProperty(locator))).isDisplayed();
    }

    public static void partialLinkText(Properties proper, String locator){
        driver.findElement(By.partialLinkText(proper.getProperty(locator))).click();
    }
    public static void tagName(Properties proper, String locator){
        driver.findElement(By.tagName(proper.getProperty(locator))).click();

    }
    /********************************************************************************************************
     ********************************************************************************************************/


    public  static int countTableRows(Properties proper, String cssLocator){
        int count = 0;
        List<WebElement> rowNum =driver.findElements(By.cssSelector(proper.getProperty(cssLocator)));
        for (WebElement r:rowNum){
            count++;
            //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Inside " +count);
        }
        return count;
    }
    public  static int xpCountTableRows(){
        int count = 0;
        driver.navigate().to("https://qa.jmbullion.com/accessories/coin-supplies/");
        List<WebElement> allElements = driver.findElements(By.xpath("//*[@id]"));
        for (WebElement r:allElements){
            System.out.println(r.getAttribute("id"));
            count++;
        }
        Q_PM_WebElm.myWait(2000);
        driver.findElement(By.xpath("//*[@id='menu-item-1943985']")).click();
        return count;
    }

    public static int xpCountTableRows(Properties proper, String locator){
        int count = 0;
        List<WebElement> rowNum =driver.findElements(By.xpath(proper.getProperty(locator)));
        for (WebElement r:rowNum){
            count++;
        }
        return count;
    }
    public static int xpCountTableDiv(Properties proper, String locator){
        int count = 0;
        List<WebElement> rowNum =driver.findElements(By.xpath(proper.getProperty(locator)));
        for (WebElement r:rowNum){
            count++;
        }
        return count;
    }
    /********************************************************************************************************
     ********************************************************************************************************/
    public static boolean css(String beg, Integer item, String end, String attr) {
        try{
            if (driver.findElement(By.cssSelector(beg + item + end)).getAttribute(attr).length() > 0) {
                System.out.println("This is a reportable item ");
            }
            return true;
        }
        catch(Throwable ex){
            System.out.println("This is not a reportable item ");

        }
        return false;
    }
}

