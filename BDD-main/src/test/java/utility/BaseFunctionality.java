package utility;

import elementsModel.KwikspaceLogin;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BaseFunctionality {

    private final KwikspaceLogin kwikspaceObjects = new KwikspaceLogin(driverFactory.getDriver());

    //Method to create Screenshot
    public static void TakeScreenShots(String TestID) {
        String Error;
        try {
            WebDriverWait wait = new WebDriverWait(driverFactory.driver, 10);
            File scrFile = ((TakesScreenshot) driverFactory.driver).getScreenshotAs(OutputType.FILE);
            // copy screenshot to certain location
            FileUtils.copyFile(scrFile, new File("src\\screenshots" + "\\" + TestID + ".png"));

        } catch (Exception e) {
            Error = e.getMessage();
            System.out.println(Error);
        }
    }

    //Waits for an object to be Visible(Subject to implicit wait time)
    public static void WaitUntilVisible(WebElement object, String data) {
        try {
            WebDriverWait wait = new WebDriverWait(driverFactory.driver, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(object));
        } catch (Exception e) {
            //Log.error("Not able to Select an item --- " + e.getMessage());
        }
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driverFactory.driver, seconds);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        return element;
    }

    public static void waitForAnElementToBeVisible(WebDriver driver, WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(driverFactory.driver, seconds);
        var element = wait.until(ExpectedConditions.visibilityOf(webElement));
        // if (!element) throw new AssertionError();

    }

    public static void selectElementByValue(WebElement element, String value) {
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }

    public static void selectElementByVisibleText(WebElement element, String text) {
        Select selectElement = new Select(element);
        selectElement.selectByVisibleText(text);
    }

    public static void selectElementByIndex(WebElement element, int index) {
        Select selectElement = new Select(element);
        selectElement.selectByIndex(index);
    }

    //method to check visibility of web element
    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    public static void SendTextToIWebElement(WebElement element, String textToSend)// make static
    {
        waitForElementToBeClickable(driverFactory.driver, element, 10).click();
        element.clear();
        element.sendKeys(textToSend);
    }

    public static void SendTextToIWebElementAndEnter(WebElement element, String textToSend) {
        waitForElementToBeClickable(driverFactory.driver, element, 10).click();
        element.clear();
        element.sendKeys(textToSend);
        element.sendKeys(Keys.ENTER);
    }

    public String PageTitle() {
        return driverFactory.driver.getTitle();
    }

    public static void WaitForAnElementToBeClickable(WebElement element, int timeout) {
        new WebDriverWait(driverFactory.driver, timeout).until(ExpectedConditions.elementToBeClickable(element));// Expectedcondition for the element to be clickable
        element.click();
    }

    public static void WaitForAnElementToBeToBeSelected(WebElement element, int timeout) {
        new WebDriverWait(driverFactory.driver, timeout).until(ExpectedConditions.elementToBeSelected(element));// Expectedcondition for the element to be clickable
        element.click();
    }

    public void RefreshPage() {
        driverFactory.driver.navigate().refresh();
    }

    public void ClosePopUpWindow() {
        driverFactory.driver.quit();
    }

    public void MinimiseCurrentBrowserWindow() {
        driverFactory.driver.manage().window().maximize();
    }

    public static void GoToUrl(String url) {
        driverFactory.driver.navigate().to(url);
    }

    public void SwitchToMainFrame() {
        driverFactory.driver.switchTo().defaultContent();
    }

    public WebElement expandRootElement(WebElement element) {
        WebElement ielement = (WebElement) ((JavascriptExecutor) driverFactory.driver).executeScript("return arguments[0].shadowRoot", element);
        return ielement;
    }

    public void getWindowHandles() {
        //Get handles of the windows
        String mainWindowHandle = driverFactory.driver.getWindowHandle();
        Set<String> allWindowHandles = driverFactory.driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driverFactory.driver.switchTo().window(ChildWindow);
                WebElement text = driverFactory.driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }
    }

    public void CloseChildWIndows() {
        String MainWindow = driverFactory.driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driverFactory.driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();

        // Here we will check if child window has other child windows and when child window is the main window it will come out of loop.
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driverFactory.driver.switchTo().window(ChildWindow);
                driverFactory.driver.close();
                System.out.println("Child window closed");
            }
        }
    }

    //sendkeys method
    public static void sendKeys(WebDriver driver1, WebElement element, int timeout, String value) {
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void ScrollToProvinceElement() {
        WebElement element = driverFactory.driver.findElement(By.xpath("//label[contains(text(),'* Province')]"));
        ((JavascriptExecutor) driverFactory.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void ScrollToAnyElement(By locator) {
        WebElement element = driverFactory.driver.findElement(locator);
        ((JavascriptExecutor) driverFactory.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void SelectAnyElementFromAnySelectList(String name, By locator) {
        driverFactory.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> names = driverFactory.driver.findElements(locator);
        var elementfound = false;
        boolean run = true;
        while (!elementfound && run) {
            for (var user : names) {
                String x = user.getText();
                String modifiedSearch = x.replace("\r", "").replace("\n", " ");
                if (modifiedSearch.equals(name)) {
                    user.click();
                    elementfound = true;
                    break;
                } else {
                    System.out.println("the user specified is unavailable to select");
                    run = false;
                }
            }
        }
    }

    //	 when 'start' is a method call or calculated value to ensure that 'start' is obtained just once.
     public static String SubString(String string, int start, int length) {
        if (length < 0)
            throw new IndexOutOfBoundsException("Parameter length cannot be negative.");

        return string.substring(start, start + length);
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isNullOrWhiteSpace(String string) {
        if (string == null)
            return true;

        for (int index = 0; index < string.length(); index++) {
            if (!Character.isWhitespace(string.charAt(index)))
                return false;
        }

        return true;
    }

    //	static string method 'Join' (2 parameter version).
    public static String Join(String separator, String[] stringArray, int i, int length) {
        if (stringArray == null)
            return null;
        else
            return Join(separator, stringArray, 0, stringArray.length);
    }

    //static string method 'Join' (4 parameter version).
     public static String join(String separator, String[] stringArray, int startIndex, int count) {
        if (stringArray == null)
            return null;

        StringBuilder sb = new StringBuilder();

        for (int index = startIndex; index < stringArray.length && index - startIndex < count; index++) {
            if (separator != null && index > startIndex)
                sb.append(separator);

            if (stringArray[index] != null)
                sb.append(stringArray[index]);
        }

        return sb.toString();
    }

     //	string method 'Remove' (1 parameter version).
    public static String Remove(String string, int start) {
        return string.substring(0, start);
    }

    //	string method 'Remove' (2 parameter version).
     public static String RemoveTwo(String string, int start, int count) {
        return string.substring(0, start) + string.substring(start + count);
    }

    //	string method 'TrimEnd'.
    public static String TrimEnd(String string, Character... charsToTrim) {
        if (string == null || charsToTrim == null)
            return string;

        int lengthToKeep = string.length();
        for (int index = string.length() - 1; index >= 0; index--) {
            boolean removeChar = false;
            if (charsToTrim.length == 0) {
                if (Character.isWhitespace(string.charAt(index))) {
                    lengthToKeep = index;
                    removeChar = true;
                }
            } else {
                for (int trimCharIndex = 0; trimCharIndex < charsToTrim.length; trimCharIndex++) {
                    if (string.charAt(index) == charsToTrim[trimCharIndex]) {
                        lengthToKeep = index;
                        removeChar = true;
                        break;
                    }
                }
            }
            if (!removeChar)
                break;
        }
        return string.substring(0, lengthToKeep);
    }

    //	string method 'TrimStart'.
    public static String TrimStart(String string, Character... charsToTrim) {
        if (string == null || charsToTrim == null)
            return string;

        int startingIndex = 0;
        for (int index = 0; index < string.length(); index++) {
            boolean removeChar = false;
            if (charsToTrim.length == 0) {
                if (Character.isWhitespace(string.charAt(index))) {
                    startingIndex = index + 1;
                    removeChar = true;
                }
            } else {
                for (int trimCharIndex = 0; trimCharIndex < charsToTrim.length; trimCharIndex++) {
                    if (string.charAt(index) == charsToTrim[trimCharIndex]) {
                        startingIndex = index + 1;
                        removeChar = true;
                        break;
                    }
                }
            }
            if (!removeChar)
                break;
        }
        return string.substring(startingIndex);
    }

    //------------------------------------------------------------------------------------
    //string method 'Trim' when arguments are used.
    //------------------------------------------------------------------------------------
    public static String Trim(String string, Character... charsToTrim) {
        return TrimEnd(TrimStart(string, charsToTrim), charsToTrim);
    }

    //	This method is used for string equality comparisons when the option	'Use helper 'stringsEqual' method to handle null strings' is selected
    public static boolean StringsEqual(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        else
            return s1 != null && s1.equals(s2);
    }
    //	string method 'PadRight' (1 parameter version).
    public static String padRight(String string, int totalWidth) {
        return padRight(string, totalWidth, ' ');
    }

    //	This method replaces the .NET string method 'PadRight' (2 parameter version).
    public static String padRight(String string, int totalWidth, char paddingChar) {
        StringBuilder sb = new StringBuilder(string);

        while (sb.length() < totalWidth) {
            sb.append(paddingChar);
        }
        return sb.toString();
    }
    //	string method 'PadLeft' (1 parameter version).
    public static String padLeft(String string, int totalWidth) {
        return padLeft(string, totalWidth, ' ');
    }

    //string method 'PadLeft' (2 parameter version).
    public static String padLeft(String string, int totalWidth, char paddingChar) {
        StringBuilder sb = new StringBuilder();

        while (sb.length() + string.length() < totalWidth) {
            sb.append(paddingChar);
        }

        sb.append(string);
        return sb.toString();
    }

    //	string constructor which repeats a character.
    public static String repeatChar(char charToRepeat, int count) {
        String newString = "";
        for (int i = 1; i <= count; i++) {
            newString += charToRepeat;
        }
        return newString;
    }

     //	string method 'LastIndexOf' (char version).
    public static int lastIndexOf(String string, char value, int startIndex, int count) {
        int leftMost = startIndex + 1 - count;
        int rightMost = startIndex + 1;
        String substring = string.substring(leftMost, rightMost);
        int lastIndexInSubstring = substring.lastIndexOf(value);
        if (lastIndexInSubstring < 0)
            return -1;
        else
            return lastIndexInSubstring + leftMost;
    }

    //	string method 'LastIndexOf' (string version).
    public static int lastIndexOf(String string, String value, int startIndex, int count) {
        int leftMost = startIndex + 1 - count;
        int rightMost = startIndex + 1;
        String substring = string.substring(leftMost, rightMost);
        int lastIndexInSubstring = substring.lastIndexOf(value);
        if (lastIndexInSubstring < 0)
            return -1;
        else
            return lastIndexInSubstring + leftMost;
    }


}
