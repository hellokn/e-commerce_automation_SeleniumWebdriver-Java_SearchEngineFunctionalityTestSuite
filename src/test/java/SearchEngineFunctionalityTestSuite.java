import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;




public class SearchEngineFunctionalityTestSuite {
    private WebDriver driver;

    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://reserved.com");
    }


    @Test
    public void TestCases() throws Exception {
        String language = "United Kingdom";
        WebElement cookiesAcceptButton;
        WebElement selectLanguage;

        //TestCase1Data
        String searchPhraseGeneral = "T-shirts";
        WebElement findSearchBr;
        WebElement searchBrCrnr;
        WebElement searchBrExtndd;
        WebElement clearBTTN;

        //TestCase2Data
        String searchPhraseDetailed = "White T-shirts";
        WebElement searchBrCntr;
        WebElement searchCloseBttn;

        //TestCase3Data
        WebElement searchBrCrnr3;
        WebElement selectRandomLastSearchedPhrase;
        WebElement searchBrCntrd3;
        WebElement removeBttn;

        //TestCase4Data
        WebElement mostPplrPhrase;
        int randomizePopular = (new Random()).nextInt(1,8);

        //TestCase5Data
        WebElement mostSrchdBttnR;
        WebElement removeBttn5_4;
        WebElement mostSrchdBttnL;
        WebElement mostSearched;
        int randomizeMostSearched = (new Random()).nextInt(1,4);

        ScreenRecorderUtil.startRecord("testRecording");

// GIVEN
        cookiesAcceptButton = driver.findElement(By.id("cookiebotDialogOkButton"));
        cookiesAcceptButton.click();
        selectLanguage = driver.findElement(By.linkText(language));
        selectLanguage.click();

// TEST CASE 1. Search by general phrase, CLEAR search phrase. ******************************************************************************

        //TestCase1_step2
        // WHEN        //The search bar in the top right corner of the page is clicked.
        findSearchBr = driver.findElement(By.xpath("//input[@data-testid=\"search-open-button\"]"));
        findSearchBr.click();
        // taking screenshot TestCase1_step2
        //THEN        //The search bar changes its position to the center of the page.
        //    AND        //MOST POPULAR phrases section and MOST SEARCHED section are displayed below the search bar.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts1_2 = (TakesScreenshot)driver;
        File file1_2 = ts1_2.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file1_2, new File("./ScreenShots_Folder/TestCase1_step2_WHENTheSearchBarInTheTopRightCornerOfThePageIsClicked.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the screenshot TestCase1_step2 is taken");


        //TestCase1_step3
        // WHEN        //The general phrase "T-shirts" is entered in the search bar.
        //    AND        //The inquiry is confirmed.
        searchBrCrnr = driver.findElement(By.xpath("//*[@role=\"search\"]"));
        searchBrCrnr.sendKeys(searchPhraseGeneral);
        searchBrCrnr.sendKeys(Keys.RETURN);
        // taking screenshot TestCase1_step3
        // THEN         //The Product Listing Page matching the search query is displayed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts1_3 = (TakesScreenshot)driver;
        File file1_3 = ts1_3.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file1_3, new File("./ScreenShots_Folder/TestCase1_step3_WHENTheGeneralPhraseIsEnteredInTheSearchBar_THENTheProductListingPageMatchingTheSearchQueryIsDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TestCase1_step4
        // WHEN         //After mouseover the search bar, CLEAR BUTTON is displayed.
        Actions action = new Actions(driver);
        searchBrExtndd = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        action.moveToElement(searchBrExtndd).perform();
        // taking screenshot TestCase1_step4
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts1_4W = (TakesScreenshot)driver;
        File file1_4W = ts1_4W.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file1_4W, new File("./ScreenShots_Folder/TestCase1_step4_WHENAfterMouseoverTheSearchBar_CLEAR_BUTTON_IsDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //    AND        //The CLEAR BUTTON for the search bar is clicked.
        clearBTTN = driver.findElement(By.xpath("//button[@aria-label=\"Clear\"]"));
        clearBTTN.click();
        // taking screenshot TestCase1_step4
        //THEN         //Homepage with blank centered search bar is displayed.
        //    AND         //Underneath centered search bar LAST SEARCHED and MOST SEARCHED sections are displayed.
        //    AND         //MOST POPULAR section is changed to LAST SEARCHED section.
        //    AND         //The phrase previously entered in the search bar is displayed in the LAST SEARCHED section.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts1_4T = (TakesScreenshot)driver;
        File file1_4T = ts1_4T.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file1_4T, new File("./ScreenShots_Folder/TestCase1_step4_THENHomepageWithBlankCenteredSearchBarIsDisplayed_ANDUnderneathCenteredSearchBar_LAST_SEARCHED_And_MOST_SEARCHED_SectionsAreDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

// TEST CASE 2. Search by detailed phrase, CLOSE search bar. ******************************************************************************

        //TestCase2_Step2
        // WHEN         //The detailed phrase "White T-shirts" is entered in the search bar.
        //	AND        //The inquiry is confirmed.
        searchBrCntr = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        searchBrCntr.sendKeys(searchPhraseDetailed);
        searchBrCntr.sendKeys(Keys.RETURN);
        // taking screenshot TestCase2_step2
        //THEN        //The Product Listing Page matching the search query is displayed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts2_2T = (TakesScreenshot)driver;
        File file2_2T = ts2_2T.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file2_2T, new File("./ScreenShots_Folder/TestCase2_step2_WHENTheDetailedPhraseIsEnteredInTheSearchBar_THENTheProductListingPageMatchingTheSearchQueryIsDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TestCase2_Step3
        // WHEN        //The CLOSE BUTTON in the top right corner of the page is clicked.
        searchCloseBttn = driver.findElement(By.xpath("//button[@data-testid=\"search-close-button\"]"));
        searchCloseBttn.click();



// TEST CASE 3. Search with the last searched phrase, clear search bar by Backspace key, REMOVE last searched phrases in LAST SEARCHED section. ******************************************************************************

        // TestCase3_Step2
        //WHEN         //The search bar in the top right corner of the page is clicked.
        searchBrCrnr3 = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        searchBrCrnr3.click();
        // taking screenshot TestCase3_step2
        //THEN         //The search bar changes its position to the center of the page.
        //	AND         //LAST SEARCHED phrases section and MOST SEARCHED section are displayed below the search bar.
        //	AND         //LAST SEARCHED phrases section contains both previously searched phrases.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts3_2T = (TakesScreenshot)driver;
        File file3_2T = ts3_2T.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file3_2T, new File("./ScreenShots_Folder/TestCase3_step2_THENTheSearchBarChangesItsPositionToTheCenterOfThePage_AND_LAST_SEARCHED_PhrasesSectionContainsBothPreviouslySearchedPhrases.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TestCase3_Step3
        //WHEN         //Randomly selected phrase from LAST SEARCHED phrases section is clicked.
        String[] randomizeSelectedPhrases = {searchPhraseGeneral, searchPhraseDetailed};
        Random ran = new Random();
        String randomLastSearchedPhrase = randomizeSelectedPhrases[ran.nextInt(randomizeSelectedPhrases.length)];
        selectRandomLastSearchedPhrase = driver.findElement(By.xpath("//span[text()='"+randomLastSearchedPhrase+"']"));
        selectRandomLastSearchedPhrase.click();
        // taking screenshot TestCase3_step3
        //THEN        //The Product Listing Page matching the search query is displayed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts3_3T = (TakesScreenshot)driver;
        File file3_3T = ts3_3T.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file3_3T, new File("./ScreenShots_Folder/TestCase3_step3_WHENRandomlySelectedPhraseFrom_LAST_SEARCHED_PhrasesSectionIsClicked_THENTheProductListingPageMatchingTheSearchQueryIsDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test Case3_Step4
        // WHEN        //The search bar area is clicked.
        //    AND        //Displayed phrase is cleared by using Backspace key.
        searchBrCntrd3 = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        Actions backspace=new Actions(driver);
        backspace.moveToElement(searchBrCntrd3).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        //    THEN         //Homepage with blank centered search bar is displayed.
        //    AND         //Underneath centered search bar LAST SEARCHED and MOST SEARCHED sections are displayed.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Test Case3_Step5
        // WHEN        //REMOVE BUTTONS on the right side of both last searched phrases are clicked.
        removeBttn = driver.findElement(By.xpath("//button[contains(@class,\"RemoveSearchIconWrapper\")]"));
        removeBttn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        removeBttn.click();
        // taking screenshot TestCase3_step5
        // THEN        //LAST SEARCHED section is changed to MOST POPULAR section.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts3_5 = (TakesScreenshot)driver;
        File file3_5 = ts3_5.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file3_5, new File("./ScreenShots_Folder/TestCase3_step5_WHEN_REMOVE_BUTTONS_OnTheRightSideOfBothLastSearchedPhrasesAreClicked_THEN_LAST_SEARCHED_SectionIsChangedTo_MOST_POPULAR_Section.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

// TEST CASE 4. Search with random MOST POPULAR search phrase, CLEAR search phrase. ******************************************************************************

        // Test Case4_Step2
        // WHEN         //Randomly selected phrase from MOST POPULAR section is clicked.
        mostPplrPhrase = driver.findElement(By.xpath("//div[contains(@class,\"popular-chip\")]["+randomizePopular+"]"));
        mostPplrPhrase.click();
        // taking screenshot TestCase4_step2
        // THEN        //The Product Listing Page matching the search query is displayed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts4_2 = (TakesScreenshot)driver;
        File file4_2 = ts4_2.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file4_2, new File("./ScreenShots_Folder/TestCase4_step2_WHENRandomlySelectedPhraseFrom_MOST_POPULAR_SectionIsClicked_THENTheProductListingPageMatchingTheSearchQueryIsDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Test Case4_Step3
        // WHEN         //After hover-over the search bar again CLEAR BUTTON is displayed
        //    AND        //The CLEAR BUTTON for the search bar is clicked.
        Actions action4_3 = new Actions(driver);
        searchBrExtndd = driver.findElement(By.xpath("//input[@type=\"search\"]"));
        action4_3.moveToElement(searchBrExtndd).perform();
        clearBTTN = driver.findElement(By.xpath("//button[@aria-label=\"Clear\"]"));
        clearBTTN.click();
        // taking screenshot TestCase4_step3
        //    THEN        //Homepage with blank centered search bar is displayed.
        //    AND        //Underneath centered search bar LAST SEARCHED and MOST SEARCHED sections are displayed.
        //    AND        //MOST POPULAR section is changed to LAST SEARCHED section containing previously selected phrase from MOST POPULAR set.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts4_3 = (TakesScreenshot)driver;
        File file4_3 = ts4_3.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file4_3, new File("./ScreenShots_Folder/TestCase4_step3_THEN_MOST_POPULAR_SectionIsChangedTo_LAST_SEARCHED_SectionContainingPreviouslySelectedPhraseFrom_MOST_POPULAR_Set.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


// TEST CASE 5. Search with the MOST SEARCHED products; testing CAROUSEL SLIDER properties. ******************************************************************************

        // Test Case5_Step2
        // WHEN
        //The ARROW BUTTON of the CAROUSEL SLIDER is clicked;
        mostSrchdBttnR = driver.findElement(By.xpath("//button[contains(@class,\"ArrowRight\")]"));
        mostSrchdBttnR.click();
        // taking screenshot TestCase5_step2
        // THEN        //The CAROUSEL SLIDER displays view with one more product item.
        //AND        //The first item from MOST SEARCHED set is no longer visible.
        //AND        //ARROW BUTTONS for the changing view of the CAROUSEL SLIDER are displayed above last visible items to both sides of the CAROUSEL SLIDER according to the direction.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts5_2 = (TakesScreenshot)driver;
        File file5_2 = ts5_2.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file5_2, new File("./ScreenShots_Folder/TestCase5_step2_WHENThe_ARROW_BUTTON_OfThe_CAROUSEL_SLIDER_IsClicked_THENThe_CAROUSEL_SLIDER_DisplaysViewWithOneMoreProductItem.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test Case5_Step3
        // WHEN        //The right ARROW BUTTON is clicked to reach the end of the CAROUSEL SLIDER items set.
        mostSrchdBttnR.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mostSrchdBttnR.click();
        // taking screenshot TestCase5_step3
        // THEN        //The ARROW BUTTON is displayed only above last visible item to the left in the CAROUSEL SLIDER.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts5_3 = (TakesScreenshot)driver;
        File file5_3 = ts5_3.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file5_3, new File("./ScreenShots_Folder/TestCase5_step3_WHENTheRight_ARROW_BUTTON_IsClickedToReachTheEndOfThe_CAROUSEL_SLIDER_ItemsSet_THENThe_ARROW_BUTTON_IsDisplayedOnlyAboveLastVisibleItemToTheLeftInThe_CAROUSEL_SLIDER.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test Case5_Step4
        // WHEN        //REMOVE BUTTON on the right side of the phrase in LAST SEARCHED section is clicked.
        removeBttn5_4 = driver.findElement(By.xpath("//button[contains(@class,\"RemoveSearchIconWrapper\")]"));
        removeBttn5_4.click();
        // taking screenshot TestCase5_step4
        // THEN        //LAST SEARCHED section is changed to MOST POPULAR section.
        //AND        //The CAROUSEL SLIDER view stays unaffected.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts5_4 = (TakesScreenshot)driver;
        File file5_4 = ts5_4.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file5_4, new File("./ScreenShots_Folder/TestCase5_step4_WHEN_REMOVE_BUTTON_OnTheRightSideOfThePhraseIn_LAST_SEARCHED_SectionIsClicked_THENThe_CAROUSEL_SLIDER_ViewStaysUnaffected.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test Case5_Step5
        // WHEN        //The ARROW BUTTON of the CAROUSEL SLIDER is clicked;
        mostSrchdBttnL = driver.findElement(By.xpath("//button[contains(@class,\"ArrowLeft\")]"));
        mostSrchdBttnL.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // THEN        //The CAROUSEL SLIDER displays and hides items from the set according to direction.
        //AND        //The ARROW BUTTONS of the CAROUSEL SLIDER are displayed above last visible items to both sides of the CAROUSEL SLIDER according to directions.

        // Test Case5_Step6
        // WHEN        //The left ARROW BUTTON is clicked to reach the beginning of the CAROUSEL SLIDER view;
        mostSrchdBttnL.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mostSrchdBttnL.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // taking screenshot TestCase5_step6
        // THEN        //The ARROW BUTTON is displayed only above first visible item of the set to the right in the CAROUSEL SLIDER.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts5_6 = (TakesScreenshot)driver;
        File file5_6 = ts5_6.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file5_6, new File("./ScreenShots_Folder/TestCase5_step6_WHENTheLeft_ARROW_BUTTON_IsClickedToReachTheBeginningOfThe_CAROUSEL_SLIDER_View_THENThe_ARROW_BUTTON_IsDisplayedOnlyAboveFirstVisibleItemOfTheSetToTheRightInThe_CAROUSEL_SLIDER.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Test Case5_Step7
        // WHEN        //Random product item from the CAROUSEL SLIDER set is clicked;
        mostSearched = driver.findElement(By.xpath("//div[contains(@class,\"most-searched\")]//ul//li["+randomizeMostSearched+"]"));
        mostSearched.click();
        // taking screenshot TestCase5_step7
        // THEN        //The Product Page matching the product choice from the MOST SEARCHED section is displayed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TakesScreenshot ts5_7 = (TakesScreenshot)driver;
        File file5_7 = ts5_7.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file5_7, new File("./ScreenShots_Folder/TestCase5_step7_WHENRandomProductItemFromThe_CAROUSEL_SLIDER_SetIsClicked_THENTheProductPageMatchingTheProductChoiceFromThe_MOST_SEARCHED_SectionIsDisplayed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ScreenRecorderUtil.stopRecord();
    }


    @After
    public void tearDown()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
