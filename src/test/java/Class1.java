package com.sell;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Class1 {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        // TODO Auto-generated method stubs
        // TODO Auto-generated method stub
        // TODO Auto-generated method stubE:\posting for day\images100\301-20221109T110636Z-001\301
        // TODO Auto-generated method stub
        // WebDriver opening commands
        //System.setProperty("webdriver.chrome.driver", "C:\\99acres\\chromefile\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        // Create an instance of the FirefoxDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.99acres.com/");
// Clicks on Login functionalityE:\posting for day\images100\301-20221109T110636Z-001\301
        Thread.sleep(2000);
        WebElement Hamburger_button = driver.findElement(By.xpath("(//i[@class='iconS_Common_24 icon_menuIcon hmenu__explicitSpriteSize'])[1]"));// Clicks on Hamburger  button required for login
        Hamburger_button.click();
        Thread.sleep(1500);
        WebElement Login_Register = driver.findElement(By.xpath("(//div[@class='P500 hmenu__loginRegister'])[1]"));// Clicks on Login/Register button
        Login_Register.click();
// Enter Login details of the user
        Thread.sleep(3000);

        //Click on Continue with UserName/Email
       WebElement Login= driver.findElement(By.xpath("//span[text()='Continue with Email/Username']"));
       Login.click();
       Thread.sleep(1000);
        //User enters UserName/Email and click on Continue
        driver.findElement(By.xpath("//input[@title='Email Id/Username']")).sendKeys("Luxury.REALTORS");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        Thread.sleep(1000);
         driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Luxury_99");
         driver.findElement(By.xpath("//div[@class='password__submitBtn']")).click();



        /* WebElement User_name = driver.findElement(By.xpath("//input[@name='username']"));
        User_name.sendKeys("Royalti99");// Enters User Email/password
        Thread.sleep(1500);
        WebElement username_continue = driver.findElement(By.xpath("//a[@class='component__loginRegiterBtn component__ripple component__colorWhite']"));
        username_continue.click();
        Thread.sleep(1500);
        //Enter password for login
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Luxury@99");
        Thread.sleep(2000);
        WebElement login_continue = driver.findElement(By.xpath("//a[@class='component__loginRegiterBtn component__ripple component__colorWhite']"));
        login_continue.click();
        Thread.sleep(5000);// waits for browser to load*/

// Clicks on Post property
     /*   WebElement Post_property = driver.findElement(By.xpath("//div[contains(@class,'pageComponent theader__op1 theader__toggleCursor')]"));
		Post_property.click();// clicks on post property button
		Thread.sleep(3000);*/

//Login if session expired
	/*	Thread.sleep(3000);
		 String loginifnotsuccessful1=driver.getCurrentUrl();
		if(loginifnotsuccessful1.equalsIgnoreCase("https://www.99acres.com/postproperty")) {
		System.out.println("session expired need to enter otp");
		}*/
        Thread.sleep(3000);

        int boss=driver.findElements(By.xpath("//span[text()='Do not want a BOSS plan now!']")).size();
        if(boss>0) {
            driver.findElement(By.xpath("//span[text()='Do not want a BOSS plan now!']")).click();
        }
        Thread.sleep(3000);
// Reading data from Excel using FileInputStream class
        FileInputStream file = new FileInputStream("C:\\99acres\\99acres excel\\Apartment_sell(template).xlsx");// Pass the path of file
        XSSFWorkbook workbook = new XSSFWorkbook(file);// Class used for workbook
        XSSFSheet sheet = workbook.getSheet("Apartment(Sell)");// Now we are getting or fetching data from sheet from entire//XSSF Sheet is class used from reading data from particular selected sheet
        int rowcount = sheet.getLastRowNum();/// returns index of last row
        int cellcount = sheet.getRow(0).getLastCellNum();// count the total number of columns(index+1)
        System.out.println("no of rows:" + rowcount);
        System.out.println("no of cells:" + cellcount);


//Check 94 cell if contains data or empty,if empty only then execute for 2nd for loop
        for(int j=1;j<=rowcount;j++) {
            XSSFRow currentrow1 = sheet.getRow(j);

//Check which property to be started loop from
            String postedlinkemptyorfilled=currentrow1.getCell(94).getStringCellValue();
            System.out.println("successfully posted these links:"+postedlinkemptyorfilled);
//if statement for stop of program
            if(postedlinkemptyorfilled.equalsIgnoreCase("stop")) {
                System.out.println("all property posted successfully");
                driver.quit();
                break;


            }
//if statement for property to be posted

            if(postedlinkemptyorfilled.equalsIgnoreCase("property to be posted"))
            {

// Iterating between rows
                for (int i = j; i <= rowcount; i++) {// for loop is used to iterate between all rows in a particular sheet
                    System.out.println();
                    System.out.println("Current row no is:"+i);
                    XSSFRow currentrow = sheet.getRow(i);// focuses on current row
                    // saves entire row in a variable called as current row we are using XSSF IN FRONT OF current row because it is saving not only one value, it is saving entire row(many values) writing for loop to iterate between cells/columns of a particular selected row
                    Thread.sleep(1000);
                    driver.navigate().to("https://www.99acres.com/");
                    Thread.sleep(5000);
// Start to fetch data from excel
//After navigate back to 99acres need to click on post property again
                    WebElement Post_property1 = driver.findElement(By.xpath("(//div[text()='Post property'])[1]"));
                    Post_property1.click();// clicks on post property button
                    Thread.sleep(6000);

//if webpage of session expired is encountered
                    String sessionexpiredurl= driver.getCurrentUrl();
                    if(sessionexpiredurl.equalsIgnoreCase("https://www.99acres.com/postproperty")) {
                        System.out.println("                     session has expired : need to enter otp");
                    }

// Fetch data of Iam looking to component
                    String Iamlookingto = currentrow.getCell(0).getStringCellValue();
                    System.out.println("1.Iam looking to:"+Iamlookingto);
                    Thread.sleep(1000);
                    if (Iamlookingto.equalsIgnoreCase("Rent / Lease")) {
                        WebElement SellWebElement = driver.findElement(By.xpath("//span[text()='Rent / Lease']"));
                        SellWebElement.click();
                        Thread.sleep(1000);
                    }

// Click on Flat/Apartment or 1RK/Studio Apartment
                    String Whatkindofpropertydoyouhavebuttons = currentrow.getCell(2).getStringCellValue();
                    System.out.println("2.What kind of property do you have:"+Whatkindofpropertydoyouhavebuttons);
                    Thread.sleep(1000);
                    if (Whatkindofpropertydoyouhavebuttons.equalsIgnoreCase("Flat/Apartment")) {
                        WebElement Apartment1 = driver.findElement(By.xpath("//span[text()='Flat/Apartment']"));
                        Apartment1.click();
                    }
                    Thread.sleep(1000);
                    if(Whatkindofpropertydoyouhavebuttons.equalsIgnoreCase("1 RK/ Studio Apartment")) {
                        driver.findElement(By.xpath("//span[text()='1 RK/ Studio Apartment']")).click();

                    }
                    Thread.sleep(1000);
//For session expired --Begin to post
                    int begintopostpropertyifvisible= driver.findElements(By.xpath("(//span[text()='Begin to Post your Property'])[1]")).size();
                    System.out.println("session expired and size of begin to property:"+begintopostpropertyifvisible);
                    Thread.sleep(1000);
                    if(begintopostpropertyifvisible>0) {
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("(//span[text()='Begin to Post your Property'])[1]")).click();
                        Thread.sleep(1000);
                    }

// Continue button of page1
                    WebElement Continue_page1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                    Continue_page1.click();

// Handling page-2 components
                    Thread.sleep(2000);

// Handling city auto suggestive drop down(Hard coded as MumbaiThane)
                    WebElement ElementCity = driver.findElement(By.xpath("//input[@id='city']"));
                    ElementCity.sendKeys("mumbai thane");
                    Thread.sleep(1500);
                    driver.findElement(By.xpath("//span[text()='Mumbai Thane']")).click();
                    Thread.sleep(1000);
//scroll after enter city name
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,220)");
                    Thread.sleep(3000);
// Handling Apartment/Society
                    String ApartmentLocation = currentrow.getCell(4).getStringCellValue();
                    System.out.println("3.Apartment location is:"+ApartmentLocation);
// Just print locality address in console(no interaction on page since takes value by default)
//			String locality = currentrow.getCell(5).getStringCellValue();
//			System.out.println("4.Locality is:"+locality);
//Enter project name and select from list
                    WebElement Apartmentname = driver.findElement(By.xpath("//input[@id='project']"));
                    Apartmentname.sendKeys(ApartmentLocation);
                    Thread.sleep(8000);
//Apartment/Society if/if not zero
                    int dropdown_zero=driver.findElements(By.xpath("//div[contains(@class,'suggestorDropdownList_dropdownText__21PCH caption_strong_large  pageComponent')]")).size();
                    Thread.sleep(2000);
                    if(dropdown_zero>0) {
                        try {
                            Thread.sleep(2000);
                            Apartmentname.sendKeys(Keys.DOWN);
                            Thread.sleep(5000);
                            Apartmentname.sendKeys(Keys.ENTER);
                            Thread.sleep(4000);
                            int buyourservices=	driver.findElements(By.xpath("//div[@class='Modal_popContent__1TTM2   ']   ")).size();
                            if(buyourservices>0) {
                                Thread.sleep(1000);
                                driver.findElement(By.xpath("//span[text()='Cancel']")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//input[@id='project']")).click();
                                Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@id='project']")).sendKeys(Keys.CONTROL)
//			driver.findElement(By.xpath("//input[@id='project']"))
                                Thread.sleep(2000);
                                WebElement	buyservicesapartmentaddress= driver.findElement(By.xpath("//input[@id='project']"));
                                Thread.sleep(3000);
                                String Apartmentlocation_new=currentrow.getCell(4).getStringCellValue();
                                buyservicesapartmentaddress.sendKeys(Apartmentlocation_new);
                                System.out.println("new buy our services"+Apartmentlocation_new);
                                Thread.sleep(3000);
                                driver.findElement(By.xpath("//span[text()='click here to add']")).click();
                                Thread.sleep(2000);
                                String locality = currentrow.getCell(5).getStringCellValue();
                                WebElement localityaddress = driver.findElement(By.xpath("//input[@id='locality']"));
                                localityaddress.sendKeys(locality);
                                Thread.sleep(1000);
                                localityaddress.sendKeys(Keys.DOWN);
                                Thread.sleep(1000);
                                localityaddress.sendKeys(Keys.ENTER);
                            }

                        } catch (Exception e) {
                            System.out.println("Exception found");
                            Apartmentname.sendKeys(Keys.DOWN);
                            Thread.sleep(3000);
                            Apartmentname.sendKeys(Keys.ENTER);
                        }
                    }
                    else {
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("//span[text()='click here to add']")).click();
                        Thread.sleep(2000);
                        String locality = currentrow.getCell(5).getStringCellValue();
                        WebElement localityaddress = driver.findElement(By.xpath("//input[@id='locality']"));
                        localityaddress.sendKeys(locality);
                        Thread.sleep(3500);
                        localityaddress.sendKeys(Keys.DOWN);
                        Thread.sleep(3000);
                        localityaddress.sendKeys(Keys.ENTER);

                    }

// // If drop down content is zero this entire if from line 137 to 164
//			if (String.valueOf(numberofvaluesindropdown).equals("0")) {
//				Thread.sleep(1000);
//				driver.findElement(By.xpath("//span[text()='click here to add']")).click();
//				Thread.sleep(2000);
//				WebElement localityaddress = driver.findElement(By.xpath("//input[@id='locality']"));
//				localityaddress.sendKeys(locality);
//				Thread.sleep(3000);
//             // Keys down of send keys of locality
//				localityaddress.sendKeys(Keys.DOWN);
//				Thread.sleep(3000);
//				localityaddress.sendKeys(Keys.ENTER);
//				Thread.sleep(2000);
////Handling pop up that rises randomly and just select continue
//				int continuepopupiffound = driver.findElements(By.xpath("(//span[text()='Continue'])[2]")).size();
//
//				if (continuepopupiffound > 0) {
//					System.out.println("Continue popup has arised");
//					WebElement continue_popup = driver.findElement(By.xpath("(//span[text()='Continue'])[2]"));
//					continue_popup.click();
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//input[@id='project']")).sendKeys(ApartmentLocation);
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("//span[text()='click here to add']")).click();
//					Thread.sleep(2000);
//				}
//
//			}
//Entering House no.in page-2
                    Thread.sleep(3000);
                    int searchhousenoelement = driver.findElements(By.xpath("//input[@id='address-input']")).size();
                    if (searchhousenoelement>0) {
                        String HouseNo = currentrow.getCell(6).getStringCellValue();
                        System.out.println("5.House no is:"+HouseNo);
                        Thread.sleep(1000);
                        WebElement Houseno_WebElement = driver.findElement(By.xpath("//input[@id='address-input']"));
                        Houseno_WebElement.sendKeys(HouseNo);
                        Thread.sleep(2000);
                    }
// Continue of page2 and java script Executor
                    WebElement continuepage2 = driver.findElement(By.xpath("//span[text()='Continue']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", continuepage2);
                    Thread.sleep(1000);
                    continuepage2.click();
                    Thread.sleep(2000);

// Page-3 --Tell Us about your property
// Your Apartment is a -If 1BHK-2BHK-3BHK component is available only then I need to select,so applying displayed like method
                    int yourapartmentisasearch = driver.findElements(By.xpath("//span[text()='Your apartment is a']")).size();
                    if (yourapartmentisasearch > 0) {
                        String YourApartmentisa = currentrow.getCell(7).getStringCellValue();
                        System.out.println(YourApartmentisa);
                        Thread.sleep(1000);
                        if (YourApartmentisa.equalsIgnoreCase("1 BHK")) {
                            int onebhksearch = driver.findElements(By.xpath("//span[text()='1 BHK']")).size();
                            if (onebhksearch > 0) {
                                WebElement ONE_BHK = driver.findElement(By.xpath("//span[text()='1 BHK']"));
                                ONE_BHK.click();
                                Thread.sleep(2000);
                                ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,520)");
                            } else {
                                WebElement OTHER_BHK = driver.findElement(By.xpath("//span[text()='Other']"));
                                OTHER_BHK.click();
                                Thread.sleep(1000);
                            }
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,520)");

                        }
                        if (YourApartmentisa.equalsIgnoreCase("2 BHK")) {
                            int twobhksearch = driver.findElements(By.xpath("//span[text()='2 BHK']")).size();
                            if (twobhksearch > 0) {
                                WebElement TWO_BHK = driver.findElement(By.xpath("//span[text()='2 BHK']"));
                                TWO_BHK.click();
                                Thread.sleep(2000);
                                ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,520)");
                            } else {
                                WebElement OTHER_BHK = driver.findElement(By.xpath("//span[text()='Other']"));
                                OTHER_BHK.click();
                                Thread.sleep(1000);
                            }

                        }
                        if (YourApartmentisa.equalsIgnoreCase("3 BHK")) {
                            int threebhksearch = driver.findElements(By.xpath("//span[text()='3 BHK']")).size();
                            if (threebhksearch > 0) {
                                WebElement THREE_BHK = driver.findElement(By.xpath("//span[text()='3 BHK']"));
                                THREE_BHK.click();
                                Thread.sleep(2000);
                                ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,520)");
                            } else {
                                WebElement OTHER_BHK = driver.findElement(By.xpath("//span[text()='Other']"));
                                OTHER_BHK.click();
                                Thread.sleep(1000);
                            }

                        }
                        if (YourApartmentisa.equalsIgnoreCase("4 BHK")) {
                            int fourbhksearch = driver.findElements(By.xpath("//span[text()='4 BHK']")).size();
                            if (fourbhksearch > 0) {
                                WebElement Four_BHK = driver.findElement(By.xpath("//span[text()='4 BHK']"));
                                Four_BHK.click();
                                Thread.sleep(2000);
                                ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,520)");
                            } else {
                                WebElement OTHER_BHK = driver.findElement(By.xpath("//span[text()='Other']"));
                                OTHER_BHK.click();
                                Thread.sleep(1000);
                            }

                        }

                        if (YourApartmentisa.equalsIgnoreCase("Other")) {
                            WebElement OTHER_BHK = driver.findElement(By.xpath("//span[text()='Other']"));
                            OTHER_BHK.click();
                        }
                    }
                    Thread.sleep(1000);

// No of Bedrooms Handling

                    String NoOfBedrooms = currentrow.getCell(8).getStringCellValue();
                    System.out.println(NoOfBedrooms);
                    Thread.sleep(3000);
                    if (NoOfBedrooms.equals("1")) {

                        WebElement one_click = driver.findElement(By.xpath("(//span[text()='1'])[1]"));
                        one_click.click();

                    }
                    if (NoOfBedrooms.equals("2")) {
                        WebElement two_click = driver.findElement(By.xpath("(//span[text()='2'])[1]"));
                        two_click.click();

                    }
                    if (NoOfBedrooms.equals("3")) {
                        WebElement three_click = driver.findElement(By.xpath("(//span[text()='3'])[1]"));
                        three_click.click();
                    }
                    if (NoOfBedrooms.equals("4")) {
                        WebElement four_click = driver.findElement(By.xpath("(//span[text()='4'])[1]"));
                        four_click.click();
                    }

                    if (NoOfBedrooms.equals("5")) {
                        driver.findElement(By.xpath("(//span[contains(@class,'AddOther_toggleLabel__YwU_k')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//input[@id='undefined-input'])[1]")).sendKeys(NoOfBedrooms);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//span[text()='Done'])[1]")).click();

                    }
                    if (NoOfBedrooms.equals("6")) {
                        driver.findElement(By.xpath("(//span[contains(@class,'AddOther_toggleLabel__YwU_k')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//input[@id='undefined-input'])[1]")).sendKeys(NoOfBedrooms);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//span[text()='Done'])[1]")).click();

                    }

// No of Bathrooms Handling
                    Thread.sleep(1000);
                    String NoOfBathrooms = currentrow.getCell(9).getStringCellValue();

                    System.out.println(NoOfBathrooms);
                    if (NoOfBathrooms.equalsIgnoreCase("1")) {
                        driver.findElement(By.xpath("(//span[text()='1'])[2]")).click();

                    }
                    if (NoOfBathrooms.equalsIgnoreCase("2")) {
                        driver.findElement(By.xpath("(//span[text()='2'])[2]")).click();
                    }
                    if (NoOfBathrooms.equalsIgnoreCase("3")) {
                        driver.findElement(By.xpath("(//span[text()='3'])[2]")).click();

                    }
                    if (NoOfBathrooms.equalsIgnoreCase("4")) {
                        driver.findElement(By.xpath("(//span[text()='4'])[2]")).click();

                    }
                    if (NoOfBathrooms.equalsIgnoreCase("5")) {

                        driver.findElement(By.xpath("(//span[contains(@class,'AddOther_toggleLabel__YwU_k')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//input[@id='undefined-input'])[1]")).sendKeys(NoOfBathrooms);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//span[text()='Done'])[1]")).click();

                    }
                    if (NoOfBathrooms.equalsIgnoreCase("6")) {

                        driver.findElement(By.xpath("(//span[contains(@class,'AddOther_toggleLabel__YwU_k')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//input[@id='undefined-input'])[1]")).sendKeys(NoOfBathrooms);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//span[text()='Done'])[1]")).click();

                    }

                    Thread.sleep(2000);
                    WebElement bedroomupscroll = driver.findElement(By.xpath("//span[text()='No. of Bathrooms']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", bedroomupscroll);
// No. of Balconies handling
                    Thread.sleep(2000);
                    String NoOfBalconies = currentrow.getCell(10).getStringCellValue();
                    System.out.println(NoOfBalconies);
                    Thread.sleep(1000);
                    if (NoOfBalconies.equalsIgnoreCase("0")) {
                        WebElement zero_Balcony = driver.findElement(By.xpath("(//span[text()='0'])[1]"));
                        zero_Balcony.click();
                    }
                    if (NoOfBalconies.equalsIgnoreCase("1")) {
                        WebElement one_Balcony = driver.findElement(By.xpath("(//span[text()='1'])[3]"));
                        one_Balcony.click();
                    }
                    if (NoOfBalconies.equalsIgnoreCase("2")) {
                        WebElement two_Balcony = driver.findElement(By.xpath("(//span[text()='2'])[3]"));
                        two_Balcony.click();
                    }
                    if (NoOfBalconies.equalsIgnoreCase("3")) {
                        WebElement three_Balcony = driver.findElement(By.xpath("(//span[text()='3'])[3]"));
                        three_Balcony.click();
                    }
                    if (NoOfBalconies.equalsIgnoreCase("More than 3")) {
                        WebElement morethan_three_Balcony = driver.findElement(By.xpath("//span[text()='More than 3']"));
                        morethan_three_Balcony.click();
                    }

                    Thread.sleep(1500);
// Enter Carpet Area details
                    String CarpetAreadata = currentrow.getCell(11).toString();
                    System.out.println(CarpetAreadata);
                    WebElement CarpetArea = driver.findElement(By.xpath("(//input[@inputmode='decimal'])[1]"));
                    CarpetArea.sendKeys(CarpetAreadata);
                    Thread.sleep(2000);
// Clicking on Super Built-Up Area
                    String Superbuiltupareauparea = currentrow.getCell(15).toString();
                    System.out.println(Superbuiltupareauparea);
                    Thread.sleep(2000);
                    WebElement W_SuperBuiltupArea = driver.findElement(By.xpath("(//div[contains(@class,'hyperlinks_medium areaWidget_areaLink__2QO3z')])[2]"));
                    W_SuperBuiltupArea.click();
                    Thread.sleep(2000);
                    WebElement W_superbuiltuparea = driver.findElement(By.xpath("(//input[@inputmode='decimal'])[2]"));
                    W_superbuiltuparea.sendKeys(Superbuiltupareauparea);
                    Thread.sleep(2000);

// Others rooms(Optional)
                    //code for pooja room
                    try {
                        String Poojaroom = currentrow.getCell(17).getStringCellValue();
                        if (Poojaroom.equalsIgnoreCase("YES")) {
                            System.out.println("pooja room selected:"+Poojaroom);
                            WebElement w_poojaroom = driver.findElement(By.xpath("//span[text()='Pooja Room']"));
                            w_poojaroom.click();
                        }
                        else {
                            System.out.println("pooja room selected no/empty");
                        }
                    }
                    catch(NullPointerException e) {
                        System.out.println("pooja room found empty");
                    }
                    Thread.sleep(1000);
                    //code for study room
                    try {
                        String Studyroom = currentrow.getCell(18).getStringCellValue();
                        if (Studyroom.equalsIgnoreCase("YES")) {
                            System.out.println("study room selected:"+Studyroom);
                            WebElement w_studyroom = driver.findElement(By.xpath("//span[text()='Study Room']"));
                            w_studyroom.click();
                        }
                        else {
                            System.out.println("study room no/empty");
                        }
                    }
                    catch(NullPointerException e) {
                        System.out.println("study room found empty");
                    }
                    Thread.sleep(1000);
                    //Code for servant room
                    try {
                        String Servantroom = currentrow.getCell(19).getStringCellValue();
                        if (Servantroom.equalsIgnoreCase("YES")) {
                            System.out.println("servant room selected:"+Servantroom);
                            WebElement w_servantroom = driver.findElement(By.xpath("//span[text()='Servant Room']"));
                            w_servantroom.click();
                            Thread.sleep(1000);
                        }
                        else {
                            System.out.println("servant room value no/null entered");
                        }
                    }
                    catch(NullPointerException e) {
                        System.out.println("servant cell found empty");
                    }
                    Thread.sleep(1000);
                    //Store room cell
                    try {
                        String Storeroom = currentrow.getCell(20).getStringCellValue();
                        if (Storeroom.equalsIgnoreCase("YES")) {
                            System.out.println("store room selected:"+Storeroom);
                            WebElement w_storeroom = driver.findElement(By.xpath("//span[text()='Store Room']"));
                            w_storeroom.click();
                        }
                        else {
                            System.out.println("store room value no/null entered");
                        }
                    }
                    catch(NullPointerException e) {
                        System.out.println("store room cell found empty");
                    }
                    Thread.sleep(1000);
                    // Scroll to move till Furnishing/Semi-Furnishing/Unfurnished

                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,500)");
                    Thread.sleep(2000);
// Furnishing,Semi-furnishing and Unfurnishing
                    String FurnishedandUnfurnisheddata = currentrow.getCell(21).getStringCellValue();
                    System.out.println(FurnishedandUnfurnisheddata);
//Furnishing starts here
                    if (FurnishedandUnfurnisheddata.equalsIgnoreCase("Furnished")) {
                        WebElement Furnished = driver.findElement(By.xpath("//span[text()='Furnished']"));
                        Furnished.click();
                        Thread.sleep(1200);

// Code for light
                        try {
                            int light = Integer.parseInt(currentrow.getCell(22).getStringCellValue());
                            System.out.println("no of light bulbs:" + light);
                            Thread.sleep(1000);
                            for (int lightclick = 1; lightclick <= light; lightclick++) {

                                WebElement lightplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[2]"));
                                lightplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("light cell empty");
                        }
                        Thread.sleep(1000);
// code for fans
                        try {
                            int fans = Integer.parseInt(currentrow.getCell(23).getStringCellValue());
                            System.out.println("no of fans:" + fans);
                            Thread.sleep(1000);
                            for (int fansclick = 1; fansclick <= fans; fansclick++) {

                                WebElement fansplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[4]"));
                                fansplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("fan cell empty");
                        }
                        Thread.sleep(1000);

// code for AC
                        try {
                            int AC = Integer.parseInt(currentrow.getCell(24).getStringCellValue());
                            System.out.println("no of AC:" + AC);
                            Thread.sleep(1000);
                            for (int ACclick = 1; ACclick <= AC; ACclick++) {

                                WebElement ACplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[6]"));
                                ACplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("ac cell empty");
                        }
                        Thread.sleep(1000);

// code for beds
                        try {
                            int beds = Integer.parseInt(currentrow.getCell(26).getStringCellValue());
                            System.out.println(" no of beds:" + beds);
                            Thread.sleep(1000);
                            for (int bedsclick = 1; bedsclick <= beds; bedsclick++) {

                                WebElement bedsplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[10]"));
                                bedsplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("beds cell found empty");
                        }
                        Thread.sleep(1000);

// code for wadrobe
                        try {
                            int wadrobe = Integer.parseInt(currentrow.getCell(27).getStringCellValue());
                            System.out.println(" no of wadrobe:" + wadrobe);
                            Thread.sleep(1000);
                            for (int wadrobeclick = 1; wadrobeclick <= wadrobe; wadrobeclick++) {

                                WebElement wadrobeplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[12]"));
                                wadrobeplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("wadrobe cell found empty");
                        }
                        Thread.sleep(1000);

// Code for Fridge
                        try {
                            String Fridge = currentrow.getCell(32).getStringCellValue();
                            if (Fridge.equalsIgnoreCase("YES")) {
                                System.out.println("Fridge selected:"+Fridge);
                                WebElement Fridgecheck = driver.findElement(By.xpath("//label[text()='Fridge']"));
                                Fridgecheck.click();
                            }
                            else {
                                System.out.println("Fridge element selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Fridge cell empty");
                        }

                        Thread.sleep(1000);
//Scroll after Fridge
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,200)");
                        Thread.sleep(3000);
// Code for Modular Kitchen
                        try {
                            String ModularKitchen = currentrow.getCell(35).getStringCellValue();
                            if (ModularKitchen.equalsIgnoreCase("YES")) {
                                System.out.println("Modularkitchen element selected:"+ModularKitchen);
                                WebElement ModularKitchencheck = driver.findElement(By.xpath("//label[text()='Modular Kitchen']"));
                                ModularKitchencheck.click();

                            }
                            else {
                                System.out.println("modular kitchen selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Modular kitchen empty");
                        }
                        Thread.sleep(1000);
// Code for Chimney
                        try {
                            String Chimney = currentrow.getCell(36).getStringCellValue();
                            if (Chimney.equalsIgnoreCase("YES")) {
                                System.out.println("Chimney element selected;"+Chimney);
                                WebElement Chimneycheck = driver.findElement(By.xpath("//label[text()='Chimney']"));
                                Chimneycheck.click();

                            }
                            else {
                                System.out.println("chimney cell selected no");
                            }
                        }
                        catch(NullPointerException e){
                            System.out.println("chimney cell empty");
                        }
                        Thread.sleep(1000);

// Code for Curtains
                        try {
                            String Curtains = currentrow.getCell(38).getStringCellValue();
                            if (Curtains.equalsIgnoreCase("YES")) {
                                System.out.println("Curtain element selected:"+Curtains);
                                WebElement Curtainscheck = driver.findElement(By.xpath("//label[text()='Curtains']"));
                                Curtainscheck.click();
                            }
                            else {
                                System.out.println("curtain cell selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("curtain cell empty");
                        }
                        Thread.sleep(1000);
//Scroll after curtains
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,200)");
                        Thread.sleep(2000);
//Code for Covered parking
                        try {
                            int Coveredparking = Integer.parseInt(currentrow.getCell(40).getStringCellValue());
                            System.out.println(Coveredparking);
                            Thread.sleep(1000);
                            for (int Coveredparkingclick = 1; Coveredparkingclick <= Coveredparking; Coveredparkingclick++) {

                                WebElement Coveredparkingclickplus = driver
                                        .findElement(By.xpath("(//span[@class='caption_subdued_large'])[16]"));
                                Coveredparkingclickplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("covered parking cell empty");
                        }
                        Thread.sleep(1000);
//scroll after covered parking
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,600)");
                        Thread.sleep(2000);
                    }
//For semi furnished
                    if (FurnishedandUnfurnisheddata.equalsIgnoreCase("Semi-furnished")) {
                        WebElement SemiFurnished = driver.findElement(By.xpath("//span[text()='Semi-furnished']"));
                        SemiFurnished.click();

                        // Code for light
                        try {
                            int light = Integer.parseInt(currentrow.getCell(22).getStringCellValue());
                            System.out.println("no of light bulbs:" + light);
                            Thread.sleep(1000);
                            for (int lightclick = 1; lightclick <= light; lightclick++) {

                                WebElement lightplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[2]"));
                                lightplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("light cell found empty");
                        }
                        Thread.sleep(1000);
                        // code for fans
                        try {
                            int fans = Integer.parseInt(currentrow.getCell(23).getStringCellValue());
                            System.out.println("no of fans:" + fans);
                            Thread.sleep(1000);
                            for (int fansclick = 1; fansclick <= fans; fansclick++) {

                                WebElement fansplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[4]"));
                                fansplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("fan cell found empty");
                        }
                        Thread.sleep(1000);

                        // code for AC
                        try {
                            int AC = Integer.parseInt(currentrow.getCell(24).getStringCellValue());
                            System.out.println("no of AC:" + AC);
                            Thread.sleep(1000);
                            for (int ACclick = 1; ACclick <= AC; ACclick++) {

                                WebElement ACplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[6]"));
                                ACplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("AC cell found empty");
                        }
                        Thread.sleep(1000);

                        // code for beds
                        try {
                            int beds = Integer.parseInt(currentrow.getCell(26).getStringCellValue());
                            System.out.println("no of beds:" + beds);
                            Thread.sleep(1000);
                            for (int bedsclick = 1; bedsclick <= beds; bedsclick++) {

                                WebElement bedsplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[10]"));
                                bedsplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Bed cell found empty");
                        }
                        Thread.sleep(1000);

                        // code for wadrobe
                        try {
                            int wadrobe = Integer.parseInt(currentrow.getCell(27).getStringCellValue());
                            System.out.println("no of wadrobe:" + wadrobe);
                            Thread.sleep(1000);
                            for (int wadrobeclick = 1; wadrobeclick <= wadrobe; wadrobeclick++) {

                                WebElement wadrobeplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[12]"));
                                wadrobeplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Wadrobe cell found empty");
                        }
                        Thread.sleep(1000);
                        // Code for Fridge
                        try {
                            String Fridge = currentrow.getCell(32).getStringCellValue();
                            System.out.println(Fridge);
                            if (Fridge.equalsIgnoreCase("YES")) {
                                WebElement Fridgecheck = driver.findElement(By.xpath("//label[text()='Fridge']"));
                                Fridgecheck.click();

                            }
                            else {
                                System.out.println("Fridge cell selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Fridge cell empty");
                        }
                        Thread.sleep(1000);
//Scroll after Fridge
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,200)");
                        Thread.sleep(2000);

                        // Code for Modular Kitchen
                        try {
                            String ModularKitchen = currentrow.getCell(35).getStringCellValue();
                            System.out.println(ModularKitchen);
                            if (ModularKitchen.equalsIgnoreCase("YES")) {
                                WebElement ModularKitchencheck = driver.findElement(By.xpath("//label[text()='Modular Kitchen']"));
                                ModularKitchencheck.click();

                            }
                            else {
                                System.out.println("Modular Kitchen selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Modular Kitchen empty");
                        }
                        Thread.sleep(1000);

// Code for Chimney
                        try {
                            String Chimney = currentrow.getCell(36).getStringCellValue();
                            System.out.println(Chimney);
                            if (Chimney.equalsIgnoreCase("YES")) {
                                WebElement Chimneycheck = driver.findElement(By.xpath("//label[text()='Chimney']"));
                                Chimneycheck.click();

                            }
                            else {
                                System.out.println("Chimney selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Chimney empty");
                        }
                        Thread.sleep(1000);

// Code for Curtains
                        try {
                            String Curtains = currentrow.getCell(38).getStringCellValue();
                            System.out.println(Curtains);
                            if (Curtains.equalsIgnoreCase("YES")) {
                                WebElement Curtainscheck = driver.findElement(By.xpath("//label[text()='Curtains']"));
                                Curtainscheck.click();

                            }
                            else {
                                System.out.println("Curtains selected no");
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("Curtains kept empty");
                        }
                        Thread.sleep(1000);
//Scroll after curtains
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,200)");
                        Thread.sleep(2000);

/// Code for Covered parking
                        try {
                            int Coveredparking = Integer.parseInt(currentrow.getCell(40).getStringCellValue());
                            System.out.println(Coveredparking);
                            Thread.sleep(1000);
                            for (int Coveredparkingclick = 1; Coveredparkingclick <= Coveredparking; Coveredparkingclick++) {
                                WebElement Coveredparkingclickplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[16]"));
                                Coveredparkingclickplus.click();
                            }
                        }
                        catch(NullPointerException e) {
                            System.out.println("covered parking selected null");
                        }
                        Thread.sleep(1000);
//Scroll after covered parking
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,600)");

                    }
//Code if just unfurnished
                    if (FurnishedandUnfurnisheddata.equalsIgnoreCase("Un-furnished")) {

                        WebElement UnFurnished = driver.findElement(By.xpath("//span[text()='Un-furnished']"));
                        UnFurnished.click();
                        Thread.sleep(3000);
                        /// Code for Reserved parking--Covered parking
                        int Coveredparking = Integer.parseInt(currentrow.getCell(40).getStringCellValue());
                        System.out.println(Coveredparking);
                        Thread.sleep(1000);
                        for (int Coveredparkingclick = 1; Coveredparkingclick <= Coveredparking; Coveredparkingclick++) {

                            WebElement Coveredparkingclickplus = driver.findElement(By.xpath("(//span[@class='caption_subdued_large'])[2]"));
                            Coveredparkingclickplus.click();
                        }
                        Thread.sleep(2000);
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,500)");

                    }

                    Thread.sleep(2000);
// Code for Total floors details
                    int Totalfloors = Integer.parseInt(currentrow.getCell(42).getStringCellValue());
                    System.out.println(Totalfloors);
                    WebElement Totalfloors_Web = driver.findElement(By.xpath("//div[@id='totalFloor-input']//div//div//input[@type='text']"));
                    Totalfloors_Web.clear();
                    Thread.sleep(1000);
                    Totalfloors_Web.sendKeys("" + Totalfloors);
                    Thread.sleep(1000);
// Code for property on floor dropdown--clicking and opening drop down
                    WebElement drop11 = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false  ']"));
                    Actions action5 = new Actions(driver);
                    action5.moveToElement(drop11);
                    action5.click();
                    action5.perform();
                    Thread.sleep(2000);
                    String DropdownPropertyOnFloor = currentrow.getCell(43).getStringCellValue();
                    Thread.sleep(1000);
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("Basement")) {

                        WebElement D_Basement = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[1]"));
                        D_Basement.click();

                        action5.moveToElement(D_Basement);

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("Lower Ground")) {

                        WebElement D_LowerGround = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[2]"));
                        D_LowerGround.click();

                        action5.moveToElement(D_LowerGround);

                        action5.click();
                        action5.build();
                    }

                    if (DropdownPropertyOnFloor.equalsIgnoreCase("Ground")) {

                        WebElement D_Ground = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[3]"));
                        D_Ground.click();

                        action5.moveToElement(D_Ground);

                        action5.click();
                        action5.build();
                    }

                    if (DropdownPropertyOnFloor.equalsIgnoreCase("1")) {

                        WebElement D_1 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[4]"));
                        D_1.click();
                        // Actions action4=new Actions(driver);
                        action5.moveToElement(D_1);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("2")) {

                        WebElement D_2 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[5]"));
                        D_2.click();
                        // Actions action5=new Actions(driver);
                        action5.moveToElement(D_2);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("3")) {

                        WebElement D_3 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[6]"));
                        D_3.click();
                        // Actions action6=new Actions(driver);
                        action5.moveToElement(D_3);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("4")) {

                        WebElement D_4 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[7]"));
                        D_4.click();
                        // Actions action7=new Actions(driver);
                        action5.moveToElement(D_4);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("5")) {

                        WebElement D_5 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[8]"));
                        D_5.click();
                        // Actions action8=new Actions(driver);
                        action5.moveToElement(D_5);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("6")) {

                        WebElement D_6 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[9]"));
                        D_6.click();
                        // Actions action9=new Actions(driver);
                        action5.moveToElement(D_6);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("7")) {

                        WebElement D_7 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[10]"));
                        D_7.click();
                        // Actions action10=new Actions(driver);
                        action5.moveToElement(D_7);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("8")) {

                        WebElement D_8 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[11]"));
                        D_8.click();
                        // Actions action11=new Actions(driver);
                        action5.moveToElement(D_8);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("9")) {

                        WebElement D_9 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[12]"));
                        D_9.click();
                        // Actions action12=new Actions(driver);
                        action5.moveToElement(D_9);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("10")) {

                        WebElement D_10 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[13]"));
                        D_10.click();
                        // Actions action13=new Actions(driver);
                        action5.moveToElement(D_10);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("11")) {

                        WebElement D_11 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[14]"));
                        D_11.click();
                        // Actions action14=new Actions(driver);
                        action5.moveToElement(D_11);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("12")) {

                        WebElement D_12 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[15]"));
                        D_12.click();
                        // Actions action15=new Actions(driver);
                        action5.moveToElement(D_12);
                        // action.perform();

                        action5.click();
                        action5.build();
                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("13")) {

                        WebElement D_13 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[16]	"));
                        D_13.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_13);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("14")) {

                        WebElement D_14 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[17]	"));
                        D_14.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_14);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("15")) {

                        WebElement D_15 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[18]	"));
                        D_15.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_15);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("16")) {

                        WebElement D_16 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[19]	"));
                        D_16.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_16);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("17")) {

                        WebElement D_17 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[20]	"));
                        D_17.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_17);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("18")) {

                        WebElement D_18 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[21]	"));
                        D_18.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_18);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("19")) {

                        WebElement D_19 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[22]	"));
                        D_19.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_19);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    if (DropdownPropertyOnFloor.equalsIgnoreCase("20")) {

                        WebElement D_20 = driver.findElement(By.xpath("//div[@class='selectInput_dropdownList__AuMXU selectInput_showDropdown__fZ1YM pageComponent select-dropdown']//div[23]	"));
                        D_20.click();
                        // Actions action16=new Actions(driver);
                        action5.moveToElement(D_20);
                        // action.perform();

                        action5.click();
                        action5.build();

                    }
                    Thread.sleep(1000);
//Scroll to move till Availability status
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                    Thread.sleep(2000);
//Selecting Availability status
                    // Availability status
                    String Availabilitystatustext = currentrow.getCell(44).getStringCellValue();
                    System.out.println(Availabilitystatustext);
//if Availability status is Ready to move
                    if (Availabilitystatustext.equalsIgnoreCase("Ready to move")) {
                        WebElement ElementReadytomove = driver.findElement(By.xpath("//span[text()='Ready to move']"));
                        ElementReadytomove.click();
                        Thread.sleep(1000);
//Selecting Age of property
                        String Ageofproperty = currentrow.getCell(45).getStringCellValue();
                        System.out.println(Ageofproperty);
                        if (Ageofproperty.equalsIgnoreCase("0-1 years")) {
                            WebElement zero_to_one = driver.findElement(By.xpath("//span[text()='0-1 years']"));
                            zero_to_one.click();
                        }
                        if (Ageofproperty.equalsIgnoreCase("1-5 years")) {
                            WebElement one_to_five = driver.findElement(By.xpath("//span[text()='1-5 years']"));
                            one_to_five.click();
                        }
                        if (Ageofproperty.equalsIgnoreCase("5-10 years")) {
                            WebElement five_to_ten = driver.findElement(By.xpath("//span[text()='5-10 years']"));
                            five_to_ten.click();
                        }
                        if (Ageofproperty.equalsIgnoreCase("10+ years")) {
                            WebElement ten_plus = driver.findElement(By.xpath("//span[text()='10+ years']"));
                            ten_plus.click();
                        }
                    }

//Availability status if Under Construction
                    if (Availabilitystatustext.equalsIgnoreCase("Under construction")) {
                        WebElement ElementUnderconstruction = driver.findElement(By.xpath("//span[text()='Under construction']"));
                        ElementUnderconstruction.click();
                        Thread.sleep(2000);
//scroll after under construction
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                        Thread.sleep(2000);

//Open drop down of Year of Availabilty if Under Construction
                        String AvailabilityststusifUnderConstruction = currentrow.getCell(46).getStringCellValue();
                        System.out.println(AvailabilityststusifUnderConstruction);
                        Thread.sleep(1000);

                        WebElement PossessionBy = driver.findElement(By.xpath("//div[contains(text(),'Expected by')]"));
                        Actions action6 = new Actions(driver);
                        action6.moveToElement(PossessionBy);
                        PossessionBy.click();
                        action6.perform();
                        Thread.sleep(1000);
//Print Month of possession if available
                        String Monthofpossession = null;
                        try {
                            Monthofpossession = currentrow.getCell(47).getStringCellValue();
                            System.out.println(Monthofpossession);
                            Thread.sleep(1000);
                        }
                        catch(NullPointerException m) {
                            System.out.println("exception found");
                        }

                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("Within 3 Months")) {
                            Thread.sleep(1000);
                            WebElement within3months = driver.findElement(By.xpath("//span[text()='Within 3 Months']"));
                            within3months.click();
                            action6.moveToElement(within3months);
                            action6.click();
                            action6.build();
                        }
                        Thread.sleep(1000);
                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("Within 6 Months")) {
                            Thread.sleep(1000);
                            WebElement within6months = driver.findElement(By.xpath("//span[text()='Within 6 Months']"));
                            within6months.click();
                            action6.moveToElement(within6months);
                            action6.click();
                            action6.build();
                        }
                        Thread.sleep(1000);
                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2023")) {
                            Thread.sleep(1000);
                            WebElement By2023 = driver.findElement(By.xpath("//span[text()='By 2023']"));
                            By2023.click();
                            action6.moveToElement(By2023);
                            action6.click();
                            action6.build();
                            Thread.sleep(2000);
//scroll after 2023
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);
                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Thread.sleep(1000);
                            Actions action7 = new Actions(driver);
                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }

                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2024")) {
                            Thread.sleep(1000);
                            WebElement By2024 = driver.findElement(By.xpath("//span[text()='By 2024']"));
                            By2024.click();
                            action6.moveToElement(By2024);
                            action6.click();
                            action6.build();
                            //scroll after 2024
                            Thread.sleep(1000);
                            //scroll after 2024
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);

                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Thread.sleep(1000);
                            Actions action7 = new Actions(driver);


                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }
                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2025")) {
                            Thread.sleep(1000);
                            WebElement By2025 = driver.findElement(By.xpath("//span[text()='By 2025']"));
                            By2025.click();
                            action6.moveToElement(By2025);
                            action6.click();
                            action6.build();
                            Thread.sleep(2000);
//scroll after 2025
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);
                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Thread.sleep(1000);
                            Actions action7 = new Actions(driver);
                            Thread.sleep(1000);
                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }
                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2026")) {
                            Thread.sleep(1000);
                            WebElement By2026 = driver.findElement(By.xpath("//span[text()='By 2026']"));
                            By2026.click();
                            action6.moveToElement(By2026);
                            action6.click();
                            action6.build();
                            Thread.sleep(2000);
                            //scroll after 2026
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);

                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Thread.sleep(1000);
                            Actions action7 = new Actions(driver);
                            Thread.sleep(1000);

                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }
                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2027")) {
                            Thread.sleep(1000);
                            WebElement By2027 = driver.findElement(By.xpath("//span[text()='By 2027']"));
                            By2027.click();
                            Thread.sleep(1000);
                            action6.moveToElement(By2027);
                            action6.click();
                            action6.build();
                            Thread.sleep(2000);
                            //scroll after 2027
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);

                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Actions action7 = new Actions(driver);
                            Thread.sleep(1000);


                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }

                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2028")) {
                            Thread.sleep(1000);
                            WebElement By2028 = driver.findElement(By.xpath("//span[text()='By 2028']"));
                            By2028.click();
                            Thread.sleep(1000);
                            action6.moveToElement(By2028);
                            action6.click();
                            action6.build();
                            Thread.sleep(2000);
                            //scroll after 2028
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);

                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Actions action7 = new Actions(driver);

                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }
                        if (AvailabilityststusifUnderConstruction.equalsIgnoreCase("By 2029")) {
                            Thread.sleep(1000);
                            WebElement By2029 = driver.findElement(By.xpath("//span[text()='By 2029']"));
                            By2029.click();
                            Thread.sleep(1000);
                            action6.moveToElement(By2029);
                            action6.click();
                            action6.build();
                            Thread.sleep(2000);
                            //scroll after 2029
                            ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");
                            Thread.sleep(2300);

                            WebElement Monthdropdownclick = driver.findElement(By.xpath("//div[@class='selectInput_custom_input__DdGZD input_placeholder_completed false undefined ']"));//
                            Monthdropdownclick.click();
                            Actions action7 = new Actions(driver);
                            Thread.sleep(1000);
                            // If month is January
                            if (Monthofpossession.equalsIgnoreCase("January")) {
                                WebElement January = driver.findElement(By.xpath("//span[text()='January']"));
                                January.click();
                                action7.moveToElement(January);
                                action7.click();
                                action7.build();
                            }
                            // If month is February
                            if (Monthofpossession.equalsIgnoreCase("February")) {
                                WebElement February = driver.findElement(By.xpath("//span[text()='February']"));
                                February.click();
                                action7.moveToElement(February);
                                action7.click();
                                action7.build();
                            }
                            // If month is March
                            if (Monthofpossession.equalsIgnoreCase("March")) {
                                WebElement March = driver.findElement(By.xpath("//span[text()='March']"));
                                March.click();
                                action7.moveToElement(March);
                                action7.click();
                                action7.build();
                            }
                            // If month is April
                            if (Monthofpossession.equalsIgnoreCase("April")) {
                                WebElement April = driver.findElement(By.xpath("//span[text()='April']"));
                                April.click();
                                action7.moveToElement(April);
                                action7.click();
                                action7.build();
                            }
                            // If month is May
                            if (Monthofpossession.equalsIgnoreCase("May")) {
                                WebElement May = driver.findElement(By.xpath("//span[text()='May']"));
                                May.click();
                                action7.moveToElement(May);
                                action7.click();
                                action7.build();
                            }
                            // If month is June
                            if (Monthofpossession.equalsIgnoreCase("June")) {
                                WebElement June = driver.findElement(By.xpath("//span[text()='June']"));
                                June.click();
                                action7.moveToElement(June);
                                action7.click();
                                action7.build();
                            }
                            // If month is July
                            if (Monthofpossession.equalsIgnoreCase("July")) {
                                WebElement July = driver.findElement(By.xpath("//span[text()='July']"));
                                July.click();
                                action7.moveToElement(July);
                                action7.click();
                                action7.build();
                            }
                            // If month is August
                            if (Monthofpossession.equalsIgnoreCase("August")) {
                                WebElement August = driver.findElement(By.xpath("//span[text()='August']"));
                                August.click();
                                action7.moveToElement(August);
                                action7.click();
                                action7.build();
                            }
                            // If month is September
                            if (Monthofpossession.equalsIgnoreCase("September")) {
                                WebElement September = driver.findElement(By.xpath("//span[text()='September']"));
                                September.click();
                                action7.moveToElement(September);
                                action7.click();
                                action7.build();
                            }
                            // If month is October
                            if (Monthofpossession.equalsIgnoreCase("October")) {
                                WebElement October = driver.findElement(By.xpath("//span[text()='October']"));
                                October.click();
                                action7.moveToElement(October);
                                action7.click();
                                action7.build();
                            }
                            // If month is November
                            if (Monthofpossession.equalsIgnoreCase("November")) {
                                WebElement November = driver.findElement(By.xpath("//span[text()='November']"));
                                November.click();
                                action7.moveToElement(November);
                                action7.click();
                                action7.build();
                            }
                            // If month is December
                            if (Monthofpossession.equalsIgnoreCase("December")) {
                                WebElement December = driver.findElement(By.xpath("//span[text()='December']"));
                                December.click();
                                action7.moveToElement(December);
                                action7.click();
                                action7.build();
                            }

                        }

                    }
                    Thread.sleep(2000);
//Continue of page3
                    WebElement Continue3page3search = driver.findElement(By.xpath("//span[text()='Continue']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue3page3search);
                    Thread.sleep(2000);
                    WebElement continuepage3 = driver.findElement(By.xpath("//span[text()='Continue']"));
                    continuepage3.click();
//Page 4 loads
                    Thread.sleep(3000);
                    int uploadphotostatus = driver.findElements(By.xpath("//span[text()='Upload Photos Now']")).size();
                    if (uploadphotostatus > 0) {
                        System.out.println("File upload element found");
                        String Filepath = currentrow.getCell(48).getStringCellValue();
                        //	if(Filepath!=null) {
                        //Upload photos now
                        WebElement Uploadphotosnow = driver.findElement(By.xpath("//span[text()='Upload Photos Now']"));
                        Uploadphotosnow.click();// opens file upload window
                        Thread.sleep(1000);
                        Robot rb = new Robot();
                        rb.delay(3000);
                        // put path to file in clipboard
                        StringSelection ss = new StringSelection(Filepath);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                        // Ctrl+v(Paste the path in excel)
                        Thread.sleep(1000);
                        rb.keyPress(KeyEvent.VK_CONTROL);
                        rb.keyPress(KeyEvent.VK_V);
                        rb.keyRelease(KeyEvent.VK_CONTROL);
                        rb.keyRelease(KeyEvent.VK_V);
                        Thread.sleep(2000);

                        // //Enter
                        rb.keyPress(KeyEvent.VK_ENTER);
                        rb.keyPress(KeyEvent.VK_ENTER);
                        Thread.sleep(2000);
                        // Tab action-1
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-2
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-3
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-4
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-5
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-6
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-7
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-8
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-9
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-10
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(500);
                        // Tab action-11
                        rb.keyPress(KeyEvent.VK_TAB);
                        rb.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(1000);
// Ctrl+A(Select all images in folder)

                        rb.keyPress(KeyEvent.VK_CONTROL);
                        rb.keyPress(KeyEvent.VK_A);
                        rb.keyRelease(KeyEvent.VK_CONTROL);
                        rb.keyRelease(KeyEvent.VK_A);
                        Thread.sleep(3000);
                        // Enter again
                        rb.keyPress(KeyEvent.VK_ENTER);
                        rb.keyPress(KeyEvent.VK_ENTER);
                        Thread.sleep(7000);



                        WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                        Thread.sleep(3000);
                        Continue_page4.click();
                        //}
                        Thread.sleep(2000);



                    }
                    else {
                        WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                        Thread.sleep(3000);

                        System.out.println("File upload element not found");
                        driver.findElement(By.xpath("//span[text()='Continue without photos']")).click();
                    }

//Page-5 loads
                    Thread.sleep(2000);
                    WebElement Freehold = driver.findElement(By.xpath("//span[text()='Freehold']"));
                    Freehold.click();
//Sometimes photos update message appears,so need to scroll
                    Thread.sleep(1000);
                    WebElement Ownershipscroll = driver.findElement(By.xpath("//span[text()='Ownership']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Ownershipscroll);
                    Thread.sleep(3000);
// Get numeric cell value from excel
                    int PriceDetails = (int) currentrow.getCell(49).getNumericCellValue();
                    WebElement PriceDetails_address = driver.findElement(By.xpath("(//input[@inputmode='decimal'])[1]"));
                    PriceDetails_address.sendKeys(String.valueOf(PriceDetails));
                    Thread.sleep(2000);

//Scroll down after price details
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,100)");
                    Thread.sleep(2000);

// Checkboxes of Tax/Govt and All Inclusive price
                    String check_boxesdata = currentrow.getCell(50).getStringCellValue();
                    System.out.println(check_boxesdata);
                    Thread.sleep(1000);
                    if (check_boxesdata.equalsIgnoreCase("yes")) {
                        WebElement AllInclusiveprice = driver.findElement(By.xpath("(//label['before'])[1]"));
                        AllInclusiveprice.click();
                    }

                    String check_boxesdata2 = currentrow.getCell(51).getStringCellValue();
                    System.out.println(check_boxesdata2);
                    Thread.sleep(1000);
                    if (check_boxesdata2.equalsIgnoreCase("yes")) {
                        WebElement TaxandGovtcharge = driver.findElement(By.xpath("(//label['before'])[2]"));
                        TaxandGovtcharge.click();
                    }
                    Thread.sleep(1000);


// Price Negotiable
                    driver.findElement(By.xpath("(//label['before'])[3]")).click();
                    Thread.sleep(1000);
//Scroll after price Negotiable
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,100)");
                    Thread.sleep(2000);


//Clicks on Add more pricing details
                    driver.findElement(By.xpath("//span[text()='Add more pricing details']")).click();
                    Thread.sleep(1000);
                    //Maintainance
                    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("4");
                    Thread.sleep(1000);
                    //Select monthly/unit
                    //Click on Monthly select box
                    driver.findElement(By.xpath("//div[text()='Monthly']")).click();
                    Thread.sleep(1500);
                    //Select value-Monthly/Unit from text box
                    driver.findElement(By.xpath("//span[text()='Per Unit/Monthly']")).click();
                    Thread.sleep(1500);
                    driver.findElement(By.xpath("//div[@id='bookingAmount-input']//div[contains(@class,'numberInput_inputContainer__CHL96  numberInput_multiple_input__33UOZ')]//div[@class='false']//input[@inputmode='decimal']")).sendKeys("100000");
                    Thread.sleep(1000);
//Scroll till do u charge brokerage
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,400)");

// //Do you charge brokerage
// First check displayed or not
                    WebElement Yesbrokeragesearch = driver.findElement(By.xpath("//label[text()='Yes']"));
                    Boolean yesbrokeragestatus = Yesbrokeragesearch.isDisplayed();
                    System.out.println("brokerage element found:" + yesbrokeragestatus);
                    String resultofbrokerage = yesbrokeragestatus.toString();
                    Thread.sleep(1000);
                    if (resultofbrokerage.equalsIgnoreCase("true")) {

                        WebElement Yesbrokerage = driver.findElement(By.xpath("//label[text()='Yes']"));
                        Yesbrokerage.click();
                        Thread.sleep(1000);
                        //Click percentage of price
                        WebElement percentageofprice = driver.findElement(By.xpath("//span[text()='Percentage of Price']"));
                        percentageofprice.click();
                        Thread.sleep(2000);
                        //Enter percentage of price
                        driver.findElement(By.xpath("//div[@id='brokerage-input']//div[contains(@class,'numberInput_inputContainer__CHL96  numberInput_multiple_input__33UOZ')]//div[@class='false']//input[@type='text']")).sendKeys("1");
                        Thread.sleep(1000);
                    }
//scroll after you charge brokerage
                    WebElement doyouchargebrokeragescroll = driver.findElement(By.xpath("//span[text()='Do you charge brokerage?']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",doyouchargebrokeragescroll);
                    Thread.sleep(2000);

// What makes your property unique
                    String WhatMakesYourPropertyUniquetext = currentrow.getCell(52).getStringCellValue();
                    System.out.println(WhatMakesYourPropertyUniquetext);
                    Thread.sleep(1000);
                    WebElement WhatMakesYourPropertyUnique = driver.findElement(By.xpath("//textarea[@id='description-input']"));
                    WhatMakesYourPropertyUnique.sendKeys(WhatMakesYourPropertyUniquetext);
                    Thread.sleep(4000);
                    WebElement Continueofpage5 = driver.findElement(By.xpath("//button[@id='FeaturePricingDetailsButton']"));
                    Continueofpage5.click();

// Page6 starts from here--incase upload photos found
                    Thread.sleep(2000);
                    int scrollpage5topextra = driver.findElements(By.xpath("//span[text()='Upload Some Photos']")).size();
                    Thread.sleep(2000);
                    if (scrollpage5topextra > 0) {

                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(100,500)");
                    }
                    Thread.sleep(2000);

                    // Maintainance staff
                    try {
                        String Maintainancestaff = currentrow.getCell(53).getStringCellValue();
                        if (Maintainancestaff.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Maintenance Staff']")).click();
                        }
                        else {
                            System.out.println("maintaince staff selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("maintainance staff empty");
                    }
                    Thread.sleep(1000);
                    // Waterstorage
                    try {
                        String Waterstorage = currentrow.getCell(54).getStringCellValue();
                        if (Waterstorage.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Water Storage']")).click();
                        }
                        else {
                            System.out.println("water storage selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("water storage selected empty");
                    }
                    Thread.sleep(1000);
                    // securityfirealram
                    try {
                        String securityfirealram = currentrow.getCell(55).getStringCellValue();
                        if (securityfirealram.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Security / Fire Alarm']")).click();
                        }
                        else {
                            System.out.println("security fire alaram selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("security fire alaram kept empty");
                    }
                    Thread.sleep(1000);
                    // visitor parking
                    try {
                        String visitorparking = currentrow.getCell(56).getStringCellValue();
                        if (visitorparking.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Visitor Parking']")).click();
                        }
                        else {
                            System.out.println("visitor parking selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("visitor parking kept empty");
                    }
                    Thread.sleep(1000);
                    // Vaastu
                    try {
                        String Vaastu = currentrow.getCell(57).getStringCellValue();
                        if (Vaastu.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Feng Shui / Vaastu Compliant']")).click();
                        }
                        else {
                            System.out.println("vaastu cell selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("vaastu cell kept empty");
                    }
                    Thread.sleep(1000);
                    // Park
                    try {
                        String park = currentrow.getCell(58).getStringCellValue();
                        if (park.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Park']")).click();
                        }
                        else {
                            System.out.println("park cell selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("park cell kept empty");
                    }
                    Thread.sleep(1500);
                    // Intercom
		/*	String Intercom = currentrow.getCell(59).getStringCellValue();
			System.out.println("Intercom value is");
			int Intercommsize=driver.findElements(By.xpath("//span[text()='Intercom Facility']")).size();
			if(Intercommsize>0) {
			if (Intercom.equalsIgnoreCase("yes")) {
				driver.findElement(By.xpath("//span[text()='Intercom Facility']")).click();
			}
			}
			Thread.sleep(1000);*/
                    // Lift
                    try {
                        String Lift = currentrow.getCell(60).getStringCellValue();
                        System.out.println("the value in the lift is:"+Lift);
                        if (Lift.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Lift(s)']")).click();
                        }
                        else {
                            System.out.println("Lift cell selected no");
                        }
                    }
                    catch(NullPointerException nooo) {
                        System.out.println("Lift cell kept empty");
                    }
                    Thread.sleep(3000);

// Scroll up Property features

                    WebElement Liftsscroll = driver.findElement(By.xpath("//span[text()='Lift(s)']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Liftsscroll);
                    Thread.sleep(2000);

// PROPERTY FEATURES
                    // Clicking on 7 more first
                    WebElement seven_more = driver.findElement(By.xpath("(//div[@class='hyperlinks_medium d-inline-block'])[1]"));
                    seven_more.click();
                    Thread.sleep(2000);
                    // High ceiling height
                    try {
                        String Highceilingheight = currentrow.getCell(61).getStringCellValue();
                        if (Highceilingheight.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='High Ceiling Height']")).click();
                        }
                        else {
                            System.out.println("High ceiling height selected no");
                        }
                    }
                    catch(NullPointerException nooo ) {
                        System.out.println("High ceiling height empty");
                    }
                    Thread.sleep(1000);
                    // false ceiling lighting
                    try {
                        String flaseceilinglighting = currentrow.getCell(62).getStringCellValue();
                        if (flaseceilinglighting.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='False Ceiling Lighting']")).click();
                        }
                        else {
                            System.out.println(" false ceiling lighting selected :no");
                        }
                    }
                    catch(NullPointerException f1) {
                        System.out.println("false ceiling lighting empty");
                    }
                    Thread.sleep(1000);
                    // piped gas
                    try {
                        String pipedgas = currentrow.getCell(63).getStringCellValue();
                        if (pipedgas.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Piped-gas']")).click();
                        }
                        else {
                            System.out.println("piped gas selected :no");
                        }
                    }
                    catch(NullPointerException p1) {
                        System.out.println("piped gas empty");
                    }
                    Thread.sleep(1000);
                    // internet wi-fi
                    try {
                        String wifi = currentrow.getCell(64).getStringCellValue();
                        if (wifi.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Internet/wi-fi connectivity']")).click();
                        }
                        else {
                            System.out.println("Internet wi-fi selected :no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("Internet wi-fi kept empty");
                    }
                    Thread.sleep(1000);
                    // central ac
                    try {
                        String ac = currentrow.getCell(65).getStringCellValue();
                        if (ac.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Centrally Air Conditioned']")).click();
                        }
                        else {
                            System.out.println("central ac selected :no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("central ac kept empty");
                    }
                    Thread.sleep(1000);
                    // water purifier
                    try {
                        String purifier = currentrow.getCell(66).getStringCellValue();
                        if (purifier.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Water purifier']")).click();
                        }
                        else {
                            System.out.println("water purifier selected:no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("water purifier kept empty");
                    }
                    Thread.sleep(1000);
                    // recently renovated
                    try {
                        String recentlyrenovated = currentrow.getCell(67).getStringCellValue();
                        if (recentlyrenovated.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Recently Renovated']")).click();
                        }
                        else {
                            System.out.println("recently renovated selected:no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("recently renovated kept empty");
                    }
                    Thread.sleep(1000);
                    // private garden terrace
                    try {
                        String privategarden = currentrow.getCell(68).getStringCellValue();
                        if (privategarden.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Private Garden / Terrace']")).click();
                        }
                        else {
                            System.out.println("private garden terrace selected:no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("private garden terrace kept empty");
                    }
                    Thread.sleep(1000);
                    // natural light
                    try {
                        String naturallight = currentrow.getCell(69).getStringCellValue();
                        if (naturallight.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Natural Light']")).click();
                        }
                        else {
                            System.out.println(" natural light selected:no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println(" natural light kept empty");
                    }
                    Thread.sleep(1000);
                    // airy room
                    try {
                        String airyroom = currentrow.getCell(70).getStringCellValue();
                        if (airyroom.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Airy Rooms']")).click();
                        }
                        else {
                            System.out.println("airy room selected:no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("airy room kept empty");
                    }
                    Thread.sleep(1000);
                    // spacious interior
                    try {
                        String spaciousinterior = currentrow.getCell(71).getStringCellValue();
                        if (spaciousinterior.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Spacious Interiors']")).click();
                        }
                        else {
                            System.out.println("spacious interior selected:no");
                        }
                    }
                    catch(NullPointerException i1) {
                        System.out.println("spacious interior kept empty");
                    }
                    Thread.sleep(2000);
// Society/building feature

// Scroll up to view Society/Building feature at top
                    WebElement scrolltoSocietyBuildingfeature = driver.findElement(By.xpath("//span[text()='Internet/wi-fi connectivity']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
                            scrolltoSocietyBuildingfeature);
                    Thread.sleep(2000);

                    // Clicking on 2 more first
                    WebElement two_more = driver.findElement(By.xpath("(//div[@class='hyperlinks_medium d-inline-block'])[1]"));
                    two_more.click();
                    Thread.sleep(2000);

                    //water softening plant
                    try {
                        String Watersofteningplant = currentrow.getCell(72).getStringCellValue();
                        if (Watersofteningplant.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Water softening plant']")).click();
                        }
                        else {
                            System.out.println("water softening plant selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("water softening plant kept empty");
                    }
                    Thread.sleep(1000);
                    //ShoppingCentre
                    try {
                        String ShoppingCentre = currentrow.getCell(73).getStringCellValue();
                        if (ShoppingCentre.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Shopping Centre']")).click();
                        }
                        else {
                            System.out.println("ShoppingCentre selected:no");
                        }
                    } catch(NullPointerException a1) {
                        System.out.println("ShoppingCentre kept empty");
                    }
                    Thread.sleep(1000);
                    //Fitness centre
                    try {
                        String FitnessCentre = currentrow.getCell(74).getStringCellValue();
                        if (FitnessCentre.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Fitness Centre / GYM']")).click();
                        }
                        else{
                            System.out.println("Fitness centre selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Fitness centre kept empty");
                    }
                    Thread.sleep(1000);
                    //SwimmingPool
                    try {
                        String SwimmingPool = currentrow.getCell(75).getStringCellValue();
                        if (SwimmingPool.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Swimming Pool']")).click();
                        }
                        else {
                            System.out.println("Swimming Pool selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Swimming Pool kept empty");
                    }
                    Thread.sleep(1000);
                    //Club house Community
                    try {
                        String ClubhouseCommunity = currentrow.getCell(76).getStringCellValue();
                        if (ClubhouseCommunity.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Club house / Community Center']")).click();
                        }
                        else {
                            System.out.println("Club house Community selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Club house Community kept empty");
                    }
                    Thread.sleep(1000);
			/*int securitypersonnel1=driver.findElements(By.xpath("//span[text()='Security Personnel']")).size();
			System.out.println("security personnel count:"+securitypersonnel1);
			if(securitypersonnel1>0) {
			String SecurityPersonnel = currentrow.getCell(77).getStringCellValue();
			if (SecurityPersonnel.equalsIgnoreCase("yes")) {
				driver.findElement(By.xpath("//span[text()='Security Personnel']")).click();
			}
			}*/
                    Thread.sleep(1000);
                    // Dealing with additional features
                    //scroll
                    WebElement scrolltoadditionalfeatures = driver.findElement(By.xpath("//span[text()='Fitness Centre / GYM']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",scrolltoadditionalfeatures);
                    Thread.sleep(2000);
                    //click two or more
                    WebElement two_more1 = driver.findElement(By.xpath("(//div[@class='hyperlinks_medium d-inline-block'])[1]"));
                    two_more1.click();
                    Thread.sleep(2000);
                    //Separate entry for servant room
                    try {
                        String Separateentryforservantroom = currentrow.getCell(78).getStringCellValue();
                        if (Separateentryforservantroom.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Separate entry for servant room']")).click();
                        }
                        else {
                            System.out.println("Separate entry for servant room selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Separate entry for servant room kept empty");
                    }
                    Thread.sleep(1000);
                    //WasteDisposal
                    try {
                        String WasteDisposal = currentrow.getCell(79).getStringCellValue();
                        if (WasteDisposal.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Waste Disposal']")).click();
                        }
                        else {
                            System.out.println("WasteDisposal selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("WasteDisposal kept empty");
                    }
                    Thread.sleep(1000);
                    //No open drainage around
                    try {
                        String Noopendrainagearound = currentrow.getCell(80).getStringCellValue();
                        if (Noopendrainagearound.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='No open drainage around']")).click();
                        }
                        else {
                            System.out.println("No open drainage around selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("No open drainage around kept empty");
                    }
                    Thread.sleep(1000);
                    //Rain Water Harvesting
                    try {
                        String RainWaterHarvesting = currentrow.getCell(81).getStringCellValue();
                        if (RainWaterHarvesting.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Rain Water Harvesting']")).click();
                        }
                        else {
                            System.out.println("Rain Water Harvesting selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Rain Water Harvestingkept empty");
                    }
                    Thread.sleep(1000);
                    //Bank Attached Property
                    try {
                        String BankAttachedProperty = currentrow.getCell(82).getStringCellValue();
                        if (BankAttachedProperty.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Bank Attached Property']")).click();
                        }
                        else {
                            System.out.println("Bank AttachedProperty selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Bank AttachedProperty empty");
                    }
                    Thread.sleep(1000);
                    //Low density society
                    try {
                        String Lowdensitysociety = currentrow.getCell(83).getStringCellValue();
                        if (Lowdensitysociety.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Low Density Society']")).click();
                        }
                        else {
                            System.out.println("Low density society selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Low density society empty");
                    }
                    Thread.sleep(2000);
//scroll to water source
                    WebElement scrolltoservantroom = driver
                            .findElement(By.xpath("//span[text()='Separate entry for servant room']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", scrolltoservantroom);
                    Thread.sleep(2000);

                    // Water source
                    try {
                        String Municipalcorporation = currentrow.getCell(84).getStringCellValue();
                        if (Municipalcorporation.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Municipal corporation']")).click();
                        }
                        else {
                            System.out.println("Municipal corporation selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Municipal corporation empty");
                    }
                    Thread.sleep(1000);

                    // Borewell/Tank
                    try {
                        String BorewellTank = currentrow.getCell(85).getStringCellValue();
                        if (BorewellTank.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Borewell/Tank']")).click();
                        }
                        else {
                            System.out.println("BorewellTank selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("BorewellTank empty");
                    }
                    Thread.sleep(1000);
                    // 247 water
                    try {
                        String Water247 = currentrow.getCell(86).getStringCellValue();
                        if (Water247.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='24*7 Water']")).click();
                        }
                        else {
                            System.out.println("247 water selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("247 water empty");
                    }

                    Thread.sleep(3000);
//scroll to municipal corporation
                    WebElement municipalcorporation = driver.findElement(By.xpath("//span[text()='Municipal corporation']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", municipalcorporation);
                    Thread.sleep(2000);

//Overlooking properties
                    // Pool
                    try {
                        String Pool = currentrow.getCell(87).getStringCellValue();
                        if (Pool.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Pool']")).click();
                        }
                        else {
                            System.out.println("Pool selected:no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Pool kept empty");
                    }
                    Thread.sleep(1000);
                    // Park/Garden
                    try {
                        String ParkGarden = currentrow.getCell(88).getStringCellValue();
                        if (ParkGarden.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Park/Garden']")).click();
                        }
                        else {
                            System.out.println("Park Garden selected :no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Park Garden kept empty");
                    }

                    Thread.sleep(1000);
                    // Club
                    try {
                        String Club = currentrow.getCell(89).getStringCellValue();
                        if (Club.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Club']")).click();
                        }
                        else {
                            System.out.println("Club selected :no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println(" Club kept empty");
                    }
                    Thread.sleep(1000);
                    // Main road
                    try {
                        String Mainroad = currentrow.getCell(90).getStringCellValue();
                        if (Mainroad.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("//span[text()='Main Road']")).click();
                        }
                        else {
                            System.out.println("Main road selected :no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Main road kept empty");
                    }
                    Thread.sleep(1000);
                    // Others
                    try {
                        String Otherspage6 = currentrow.getCell(91).getStringCellValue();
                        if (Otherspage6.equalsIgnoreCase("yes")) {
                            driver.findElement(By.xpath("(//span[text()='Others'])[1]")).click();
                        }
                        else {
                            System.out.println("Others selected :no");
                        }
                    }
                    catch(NullPointerException a1) {
                        System.out.println("Others kept empty");
                    }
                    Thread.sleep(2000);

// Other features
                    WebElement scrolltootherfeatures = driver.findElement(By.xpath("(//span[text()='Others'])[1]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", scrolltootherfeatures);
                    Thread.sleep(2000);
// Hard code in a gated society
                    WebElement Inagatedsociety = driver.findElement(By.xpath("//label[text()='In a gated society']"));
                    Inagatedsociety.click();
                    Thread.sleep(1000);
// Hard code power backup
                    WebElement powerbackup = driver.findElement(By.xpath("//span[text()='Full']"));
                    powerbackup.click();
                    Thread.sleep(1000);
// scroll to property facing with address of power backup

                    WebElement scrolltopowerbackup1 = driver.findElement(By.xpath("//span[text()='Full']"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", scrolltopowerbackup1);
                    Thread.sleep(2000);


// Hard code property as always East
                    WebElement East = driver.findElement(By.xpath("//span[text()='East']"));
                    East.click();
                    Thread.sleep(1000);
                    ((JavascriptExecutor)driver).executeScript("window.scrollBy(100,150)");
                    Thread.sleep(2000);

// Selecting type of flooring(open drop down)
                    WebElement tilesdropdown = driver.findElement(By.xpath("//div[text()='Select']"));
                    Actions action9 = new Actions(driver);
                    action9.moveToElement(tilesdropdown);
                    action9.click();
                    action9.perform();
                    Thread.sleep(2000);
                    String typeofflooring = currentrow.getCell(92).getStringCellValue();
                    Thread.sleep(2000);
                    System.out.println(typeofflooring);
                    if (typeofflooring.equalsIgnoreCase("Vitrified")) {
                        WebElement Vitriified_web = driver.findElement(By.xpath("//div//span[text()='Vitrified']"));
                        Vitriified_web.click();
                        Thread.sleep(1000);
                        action9.moveToElement(Vitriified_web);
                        Thread.sleep(1000);
                        action9.click();
                        action9.build();

                    }
                    if (typeofflooring.equalsIgnoreCase("Marble")) {
                        WebElement marble_web = driver.findElement(By.xpath("//span[text()='Marble']"));
                        marble_web.click();
                        action9.moveToElement(marble_web);
                        action9.click();
                        action9.build();

                    }
                    Thread.sleep(1000);

//Hard code width of road facing
                    WebElement roadfacing = driver.findElement(By.xpath("//input[@inputmode='decimal']"));
                    roadfacing.sendKeys("40");
                    Thread.sleep(1000);

                    WebElement continueofpage6 = driver.findElement(By.xpath("//span[text()='Continue']"));
                    Boolean continepage6status = continueofpage6.isDisplayed();
                    String continuepage6text = continepage6status.toString();
                    if (continuepage6text.equals("true")) {
                        driver.findElement(By.xpath("//span[text()='Continue']")).click();

                    }

                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//span[text()='Confirm & Post property']")).click();
                    Thread.sleep(2000);
                    String modaltitle = driver.findElement(By.className("title_l_semiBold")).getText();
                    System.out.println(modaltitle);
                    Thread.sleep(2000);
                    String modalbody = driver.findElement(By.className("body_large")).getText();
                    System.out.println(modalbody);
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("(//div[contains(@class,'subscription_cardWapper__3HavH pageComponent false')])[1]")).click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//span[text()='Submit']")).click();
                    Thread.sleep(2000);
// After submit there is another component to be handled(skip to post)
                    driver.findElement(By.xpath("//span[text()='Skip to Post']")).click();
                    Thread.sleep(2000);


//Handling duplicate listing scenario if exists
                    int duplicatepopup=driver.findElements(By.xpath("//span[text()='Refresh Listing']")).size();
                    System.out.println("duplicate pop up is found for first time and size is:"+duplicatepopup);
                    Thread.sleep(1000);
                    if(duplicatepopup>0) {
                        driver.findElement(By.xpath("(//i[@class='iconS_Common_24 icon_close'])[2]")).click();//clicks on X button
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//a[text()='Edit'])[3]")).click();
                        Thread.sleep(2000);
//Scroll to carpet area
                        WebElement searchandscrolltocarpetarea=driver.findElement(By.xpath("//span[text()='Balconies']"));
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",searchandscrolltocarpetarea);
                        Thread.sleep(2000);

                        int CarpetAreadata1_duplicate=(int) currentrow.getCell(11).getNumericCellValue();
                        System.out.println("carpet area value in duplicate posting is:"+CarpetAreadata1_duplicate);
                        int carpetarea1_duplicate_added1=CarpetAreadata1_duplicate+1;

                        System.out.println("duplicate carpet area of first time:"+carpetarea1_duplicate_added1);
//Write new value of carpet area to excel
                        XSSFCell carpetarea_firstiteration = sheet.getRow(i).createCell(11);
                        carpetarea_firstiteration.setCellValue(carpetarea1_duplicate_added1);
                        //Send data to excel
                        FileOutputStream outputStream_duplicate1 = new FileOutputStream("F:\\99acres\\99acres recording\\Apartment_sell(template).xlsx");
                        workbook.write(outputStream_duplicate1);

//Moving newly added value to carpet area text box
                        WebElement CarpetAreanew1 = driver.findElement(By.xpath("(//input[@inputmode='decimal'])[1]"));
                        CarpetAreanew1.clear();
                        Thread.sleep(1000);
                        CarpetAreanew1.sendKeys(String.valueOf(carpetarea1_duplicate_added1));
                        Thread.sleep(2000);
///Duplicate-1 Move to continue of page-3
                        WebElement Continue3page3search1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue3page3search1);
                        Thread.sleep(2000);
                        WebElement continuepage3_1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                        continuepage3_1.click();
//
                        //Page 4 loads
                        Thread.sleep(3000);
                        int uploadphotostatus_duplicate1= driver.findElements(By.xpath("//span[text()='Upload Photos Now']")).size();
                        if (uploadphotostatus_duplicate1 > 0) {
                            System.out.println("File upload element found");
                            String Filepath = currentrow.getCell(48).getStringCellValue();

                            WebElement Uploadphotosnow = driver.findElement(By.xpath("//span[text()='Upload Photos Now']"));
                            Uploadphotosnow.click();// opens file upload window
                            Thread.sleep(1000);
                            Robot rb = new Robot();
                            rb.delay(3000);
                            // put path to file in clipboard
                            StringSelection ss = new StringSelection(Filepath);
                            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                            // Ctrl+v(Paste the path in excel)
                            Thread.sleep(1000);
                            rb.keyPress(KeyEvent.VK_CONTROL);
                            rb.keyPress(KeyEvent.VK_V);
                            rb.keyRelease(KeyEvent.VK_CONTROL);
                            rb.keyRelease(KeyEvent.VK_V);
                            Thread.sleep(1000);

                            // //Enter
                            rb.keyPress(KeyEvent.VK_ENTER);
                            rb.keyPress(KeyEvent.VK_ENTER);
                            Thread.sleep(1000);
                            // Tab action-1
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-2
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-3
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-4
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-5
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-6
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-7
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-8
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-9
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-10
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-11
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(1000);
// Ctrl+A(Select all images in folder)

                            rb.keyPress(KeyEvent.VK_CONTROL);
                            rb.keyPress(KeyEvent.VK_A);
                            rb.keyRelease(KeyEvent.VK_CONTROL);
                            rb.keyRelease(KeyEvent.VK_A);
                            Thread.sleep(1000);
                            // Enter again
                            rb.keyPress(KeyEvent.VK_ENTER);
                            rb.keyPress(KeyEvent.VK_ENTER);
                            Thread.sleep(4000);

                            WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                            Thread.sleep(3000);
                            Continue_page4.click();

                        } else {
                            WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                            Thread.sleep(3000);

                            System.out.println("File upload element not found");
                            driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
                            //driver.findElement(By.xpath("//span[text()='Continue without photos']")).click();
                        }
//Duplicate-1 Page5 continue
                        Thread.sleep(4000);
//Scroll to page 5 continue

                        WebElement page5continue=driver.findElement(By.xpath("//span[text()='Continue']"));
                        Thread.sleep(2000);
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", page5continue);
                        Thread.sleep(2000);
                        page5continue.click();

                        //Page-6 continue
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Continue']")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Confirm & Post property']")).click();
                        Thread.sleep(2000);
                        String modaltitle1 = driver.findElement(By.className("title_l_semiBold")).getText();
                        System.out.println(modaltitle1);
                        Thread.sleep(2000);
                        String modalbody1 = driver.findElement(By.className("body_large")).getText();
                        System.out.println(modalbody1);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//div[contains(@class,'subscription_cardWapper__3HavH pageComponent false')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Submit']")).click();
// After submit there is another component to be handled(skip to post)
                        driver.findElement(By.xpath("//span[text()='Skip to Post']")).click();
                        Thread.sleep(2000);

                    }

                    //End of duplication

//Start of duplication-2 for second time
//Handling duplicate listing scenario if exists
                    int duplicatepopup2=driver.findElements(By.xpath("//span[text()='Refresh Listing']")).size();
                    System.out.println("duplicate pop up is found and size is:"+duplicatepopup2);
                    Thread.sleep(1000);
                    if(duplicatepopup2>0) {
                        driver.findElement(By.xpath("(//i[@class='iconS_Common_24 icon_close'])[2]")).click();//clicks on X button
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//a[text()='Edit'])[3]")).click();
                        Thread.sleep(2000);
//Scroll to carpet area
                        WebElement searchandscrolltocarpetarea=driver.findElement(By.xpath("//span[text()='Balconies']"));
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",searchandscrolltocarpetarea);
                        Thread.sleep(2000);

                        int CarpetAreadata_seconditeration=(int) currentrow.getCell(11).getNumericCellValue();
                        System.out.println("carpet area value during second iteration is:"+CarpetAreadata_seconditeration);
                        int carpetarea2_seconditeration_added=CarpetAreadata_seconditeration+1;
                        System.out.println("second time added carpet area is:"+carpetarea2_seconditeration_added);
//Moving newly added value to carpet area textbox
                        WebElement CarpetAreanew1 = driver.findElement(By.xpath("(//input[@inputmode='decimal'])[1]"));
                        CarpetAreanew1.clear();
                        Thread.sleep(2000);
                        CarpetAreanew1.sendKeys(String.valueOf(carpetarea2_seconditeration_added));
//Duplicate Move to continue of page-3
                        WebElement Continue3page3search1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue3page3search1);
                        Thread.sleep(2000);
                        WebElement continuepage3_1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                        continuepage3_1.click();
//Duplicate Page 4 loads
                        Thread.sleep(3000);
                        int uploadphotostatus_duplicate1= driver.findElements(By.xpath("//span[text()='Upload Photos Now']")).size();
                        if (uploadphotostatus_duplicate1 > 0) {
                            System.out.println("File upload element found");
                            String Filepath = currentrow.getCell(48).getStringCellValue();

                            WebElement Uploadphotosnow = driver.findElement(By.xpath("//span[text()='Upload Photos Now']"));
                            Uploadphotosnow.click();// opens file upload window
                            Thread.sleep(1000);
                            Robot rb = new Robot();
                            rb.delay(3000);
                            // put path to file in clipboard
                            StringSelection ss = new StringSelection(Filepath);
                            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                            // Ctrl+v(Paste the path in excel)
                            Thread.sleep(1000);
                            rb.keyPress(KeyEvent.VK_CONTROL);
                            rb.keyPress(KeyEvent.VK_V);
                            rb.keyRelease(KeyEvent.VK_CONTROL);
                            rb.keyRelease(KeyEvent.VK_V);
                            Thread.sleep(1000);

                            // //Enter
                            rb.keyPress(KeyEvent.VK_ENTER);
                            rb.keyPress(KeyEvent.VK_ENTER);
                            Thread.sleep(1000);
                            // Tab action-1
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-2
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-3
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-4
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-5
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-6
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-7
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-8
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-9
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-10
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-11
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(1000);
// Ctrl+A(Select all images in folder)

                            rb.keyPress(KeyEvent.VK_CONTROL);
                            rb.keyPress(KeyEvent.VK_A);
                            rb.keyRelease(KeyEvent.VK_CONTROL);
                            rb.keyRelease(KeyEvent.VK_A);
                            Thread.sleep(1000);
                            // Enter again
                            rb.keyPress(KeyEvent.VK_ENTER);
                            rb.keyPress(KeyEvent.VK_ENTER);
                            Thread.sleep(4000);

                            WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                            Thread.sleep(3000);
                            Continue_page4.click();

                        } else {
                            WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                            Thread.sleep(3000);

                            System.out.println("File upload element not found");
                            driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
                            //driver.findElement(By.xpath("//span[text()='Continue without photos']")).click();
                        }
//Page5 continue
                        Thread.sleep(4000);
//Scroll to page5 continue

                        WebElement page5continue=driver.findElement(By.xpath("//span[text()='Continue']"));
                        Thread.sleep(2000);
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", page5continue);
                        Thread.sleep(2000);
                        page5continue.click();

                        //Page-6 continue
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Continue']")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Confirm & Post property']")).click();
                        Thread.sleep(2000);
                        String modaltitle1 = driver.findElement(By.className("title_l_semiBold")).getText();
                        System.out.println(modaltitle1);
                        Thread.sleep(2000);
                        String modalbody1 = driver.findElement(By.className("body_large")).getText();
                        System.out.println(modalbody1);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//div[contains(@class,'subscription_cardWapper__3HavH pageComponent false')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Submit']")).click();
// After submit there is another component to be handled(skip to post)
                        driver.findElement(By.xpath("//span[text()='Skip to Post']")).click();
                        Thread.sleep(2000);

                    }
//End of duplication-2


//start of duplicate-3
                    //Handling duplicate listing scenario if exists
                    int duplicatepopup3=driver.findElements(By.xpath("//span[text()='Refresh Listing']")).size();
                    System.out.println("duplicate pop up is found and size is:"+duplicatepopup3);
                    Thread.sleep(1000);
                    if(duplicatepopup3>0) {
                        driver.findElement(By.xpath("(//i[@class='iconS_Common_24 icon_close'])[2]")).click();//clicks on X button
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//a[text()='Edit'])[3]")).click();
                        Thread.sleep(2000);
//Scroll to carpet area
                        WebElement searchandscrolltocarpetarea=driver.findElement(By.xpath("//span[text()='Balconies']"));
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",searchandscrolltocarpetarea);
                        Thread.sleep(2000);

                        int CarpetAreadata_3time=(int) currentrow.getCell(11).getNumericCellValue();
                        System.out.println("carpet area value in 3rd duplicate posting is:"+CarpetAreadata_3time);
                        int carpetarea_3tim3_added=CarpetAreadata_3time+1;
                        System.out.println("third time added carpet area is:"+carpetarea_3tim3_added);
//Moving newly added value to carpet area textbox
                        WebElement CarpetAreanew1 = driver.findElement(By.xpath("(//input[@inputmode='decimal'])[1]"));
                        CarpetAreanew1.clear();
                        Thread.sleep(2000);
                        CarpetAreanew1.sendKeys(String.valueOf(carpetarea_3tim3_added));
//Move to continue of page-3
                        WebElement Continue3page3search1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue3page3search1);
                        Thread.sleep(2000);
                        WebElement continuepage3_1 = driver.findElement(By.xpath("//span[text()='Continue']"));
                        continuepage3_1.click();
//Page 4 loads
                        Thread.sleep(3000);
                        int uploadphotostatus_duplicate1= driver.findElements(By.xpath("//span[text()='Upload Photos Now']")).size();
                        if (uploadphotostatus_duplicate1 > 0) {
                            System.out.println("File upload element found");
                            String Filepath = currentrow.getCell(48).getStringCellValue();

                            WebElement Uploadphotosnow = driver.findElement(By.xpath("//span[text()='Upload Photos Now']"));
                            Uploadphotosnow.click();// opens file upload window
                            Thread.sleep(1000);
                            Robot rb = new Robot();
                            rb.delay(3000);
                            // put path to file in clipboard
                            StringSelection ss = new StringSelection(Filepath);
                            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                            // Ctrl+v(Paste the path in excel)
                            Thread.sleep(1000);
                            rb.keyPress(KeyEvent.VK_CONTROL);
                            rb.keyPress(KeyEvent.VK_V);
                            rb.keyRelease(KeyEvent.VK_CONTROL);
                            rb.keyRelease(KeyEvent.VK_V);
                            Thread.sleep(1000);

                            // //Enter
                            rb.keyPress(KeyEvent.VK_ENTER);
                            rb.keyPress(KeyEvent.VK_ENTER);
                            Thread.sleep(1000);
                            // Tab action-1
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-2
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-3
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-4
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-5
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-6
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-7
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-8
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-9
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-10
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(500);
                            // Tab action-11
                            rb.keyPress(KeyEvent.VK_TAB);
                            rb.keyRelease(KeyEvent.VK_TAB);
                            Thread.sleep(1000);
// Ctrl+A(Select all images in folder)

                            rb.keyPress(KeyEvent.VK_CONTROL);
                            rb.keyPress(KeyEvent.VK_A);
                            rb.keyRelease(KeyEvent.VK_CONTROL);
                            rb.keyRelease(KeyEvent.VK_A);
                            Thread.sleep(1000);
                            // Enter again
                            rb.keyPress(KeyEvent.VK_ENTER);
                            rb.keyPress(KeyEvent.VK_ENTER);
                            Thread.sleep(4000);

                            WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                            Thread.sleep(3000);
                            Continue_page4.click();

                        } else {
                            WebElement Continue_page4 = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Continue_page4);
                            Thread.sleep(3000);

                            System.out.println("File upload element not found");
                            driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
                            //driver.findElement(By.xpath("//span[text()='Continue without photos']")).click();
                        }
//Page5 continue
                        Thread.sleep(4000);
//Scroll to page5 continue

                        WebElement page5continue=driver.findElement(By.xpath("//span[text()='Continue']"));
                        Thread.sleep(2000);
                        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", page5continue);
                        Thread.sleep(2000);
                        page5continue.click();

                        //Page-6 continue
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Continue']")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Confirm & Post property']")).click();
                        Thread.sleep(2000);
                        String modaltitle1 = driver.findElement(By.className("title_l_semiBold")).getText();
                        System.out.println(modaltitle1);
                        Thread.sleep(2000);
                        String modalbody1 = driver.findElement(By.className("body_large")).getText();
                        System.out.println(modalbody1);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("(//div[contains(@class,'subscription_cardWapper__3HavH pageComponent false')])[1]")).click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Submit']")).click();
// After submit there is another component to be handled(skip to post)
                        driver.findElement(By.xpath("//span[text()='Skip to Post']")).click();
                        Thread.sleep(2000);

                    }
///Duplicate-3 ends here

/// clicking on sub-user(Present after duplication complete)
                    //Thread.sleep(2000);
                    //applying try and catch to sub-user
                    try {
                        WebElement subusermodalpopup = driver.findElement(By.xpath("//div[@id='sub_user_button']"));
                        subusermodalpopup.click();
                        Thread.sleep(2000);
                        WebElement modalpopupname = driver.findElement(By.xpath("//div[@class='Modal_popContent__1TTM2   ']"));
                        Thread.sleep(2000);
                        // getting sub-user from modal pop-up
                        String subuser_name = currentrow.getCell(93).getStringCellValue();
                        System.out.println("assigned sub-user is:" + subuser_name);
                        Thread.sleep(2000);
                        if (subuser_name.equalsIgnoreCase("Muskan Qureshi")) {
                            driver.findElement(By.xpath("//span[text()='Muskan Qureshi']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Ajit Masal")) {
                            driver.findElement(By.xpath("//span[text()='Ajit Masal']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Karishma Rohra")) {
                            driver.findElement(By.xpath("//span[text()='Karishma Rohra']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Sagar Khatri")) {
                            driver.findElement(By.xpath("//span[text()='Sagar Khatri']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Sagar Talreja")) {
                            driver.findElement(By.xpath("//span[text()='Sagar Talreja ']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Jay Kinni")) {
                            driver.findElement(By.xpath("//span[text()='Jay Kinni']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Hero Rupani")) {
                            driver.findElement(By.xpath("//span[text()='Hero Rupani']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Ajay Bakhru")) {
                            driver.findElement(By.xpath("//span[text()='Ajay Bakhru']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Suyog Pawar")) {
                            driver.findElement(By.xpath("//span[text()='Suyog Pawar']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Prapti shetty")) {
                            driver.findElement(By.xpath("//span[text()='Prapti shetty']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Shreedhar jani")) {
                            driver.findElement(By.xpath("//span[text()='Shreedhar jani']")).click();
                        }
                        if (subuser_name.equalsIgnoreCase("Trimandeep Singh")) {
                            driver.findElement(By.xpath("//span[text()='Trimandeep Singh']")).click();
                        }
                        Thread.sleep(1000);
                        if(subuser_name.equalsIgnoreCase("Kishor Bhuvad")) {
                            driver.findElement(By.xpath("//span[text()='Kishor Bhuvad']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Sonali Kakade")) {
                            driver.findElement(By.xpath("//span[text()='Sonali Kakade']")).click();
                        }
                        //new
                        if(subuser_name.equalsIgnoreCase("Jeel Thakkar")) {
                            driver.findElement(By.xpath("//span[text()='Jeel Thakkar']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Hashim Shaikh")) {
                            driver.findElement(By.xpath("//span[text()='Hashim Shaikh']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Abir Patel")) {
                            driver.findElement(By.xpath("//span[text()='Abir Patel']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Yash Pandey")) {
                            driver.findElement(By.xpath("//span[text()='Yash Pandey']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Dhruti Hodar")) {
                            driver.findElement(By.xpath("//span[text()='Dhruti Hodar']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Bhavna Kesharwani")) {
                            driver.findElement(By.xpath("//span[text()='Bhavna Kesharwani']")).click();
                        }
                        if(subuser_name.equalsIgnoreCase("Sarawar Miyagul")) {
                            driver.findElement(By.xpath("//span[text()='Sarawar Miyagul']")).click();
                        }

                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//span[text()='Done']")).click();
                    }
                    catch(NullPointerException nl) {
                        System.out.println("sub-user not selected in excel");
                    }
                    Thread.sleep(2000);

// Get parent window handle
                    String parent1 = driver.getWindowHandle();
                    System.out.println("Parent window id is:" + parent1);
// Clicking Preview
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//span[text()='Preview']")).click();
                    Thread.sleep(3000);

//Switch focus of selenium to new tab
                    Set<String> allwindows = driver.getWindowHandles();
                    for (String child1 : allwindows) {
                        if (!parent1.equalsIgnoreCase(child1)) {
                            driver.switchTo().window(child1);
                            Thread.sleep(3000);
                            String url = driver.getCurrentUrl();
                            System.out.println(url);


//Seperating id from url
                            int lastindex = url.lastIndexOf("-");
                            System.out.println("the required last index is:" + lastindex);
                            String url_id = url.substring(lastindex + 1, url.length());
                            System.out.println("lAST URL IS:" + url_id);
                            Thread.sleep(1000);
                            // Get date from web page
                            String datepropertyposted = driver.findElement(By.xpath("//i[@id='pdPropDate']")).getText();
                            System.out.println("date on which property posted is:" + datepropertyposted);
                            // Creating cell in excel

                            XSSFCell cell2 = sheet.getRow(i).createCell(94);
                            cell2.setCellValue(url);
                            XSSFCell cell3 = sheet.getRow(i).createCell(95);
                            cell3.setCellValue(url_id);

                            XSSFCell cell4 = sheet.getRow(i).createCell(96);
                            cell4.setCellValue(datepropertyposted);

                            // Write data back to excel
                            FileOutputStream outputStream = new FileOutputStream("F:\\99acres\\99acres recording\\Apartment_sell(template).xlsx");
                            workbook.write(outputStream);
                            Thread.sleep(3000);
                            driver.close();
                        }//line 2530

                    }//line 2529

                    driver.switchTo().window(parent1);




//Commenting temporary basis
                }//ends for loop i
            }//end property to be posted if
        }//ends for loop j
    }//ends main method


}

