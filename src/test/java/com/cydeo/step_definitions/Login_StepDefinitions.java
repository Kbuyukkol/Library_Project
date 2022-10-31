package com.cydeo.step_definitions;

import com.cydeo.pages.LibrarianDashboardPage;
import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login_StepDefinitions {

    static String expectedUserName = "";

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
    LibrarianDashboardPage librarianDashboardPage = new LibrarianDashboardPage();

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        libraryLoginPage.inputUsername.sendKeys("librarian1@library");
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        libraryLoginPage.inputPassword.sendKeys("rs4BNN9G" + Keys.ENTER);
    }

    @Then("librarian should see the dashboard")
    public void librarian_should_see_the_dashboard() {

        String currentURL = "https://library1.cydeo.com/#dashboard";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlToBe(currentURL));
        Assert.assertEquals(currentURL, Driver.getDriver().getCurrentUrl());


    }

    @Then("student should see the dashboard")
    public void student_should_see_the_dashboard() {

        String currentURL = "https://library1.cydeo.com/#books";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlToBe(currentURL));
        Assert.assertEquals(currentURL, Driver.getDriver().getCurrentUrl());


    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        libraryLoginPage.inputUsername.sendKeys("student1@library");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        libraryLoginPage.inputPassword.sendKeys("i2A9TgXa" + Keys.ENTER);
    }


    @Given("user is on the library login page")
    public void userIsOnTheLibraryLoginPage() {
        Driver.getDriver().get("https://library1.cydeo.com/login.html");

    }

    @When("librarian enters {string}")
    public void librarian_enters(String username) {
        libraryLoginPage.inputUsername.sendKeys(username);
    }

    @When("librarian enters the {string}")
    public void librarian_enters_the(String password) {
        libraryLoginPage.inputPassword.sendKeys(password + Keys.ENTER);
    }

    @When("student enters {string}")
    public void student_enters(String username) {
        libraryLoginPage.inputUsername.sendKeys(username);
    }

    @When("student enters the {string}")
    public void student_enters_the(String password) {
        libraryLoginPage.inputPassword.sendKeys(password + Keys.ENTER);
    }

    @When("librarian enters {string} and {string}")
    public void librarian_enters_and(String username, String password) {
        libraryLoginPage.inputUsername.sendKeys(username);
        libraryLoginPage.inputPassword.sendKeys(password + Keys.ENTER);
    }

    @When("student enters email and password")
    public void student_enters_email_and_password() throws IOException {

        String path = "Library credentials.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("library1");

        String username = String.valueOf(sheet.getRow(0).getCell(1));

        String password = String.valueOf(sheet.getRow(0).getCell(2));

        expectedUserName = String.valueOf(sheet.getRow(0).getCell(0));

        libraryLoginPage.inputUsername.sendKeys(username);

        libraryLoginPage.inputPassword.sendKeys(password + Keys.ENTER);

    }


    @Then("there should be {int} users")
    public void there_should_be_users(Integer userCount) {
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),5);

        wait.until(ExpectedConditions.urlContains("dashboard"));

        String actualUserCount = librarianDashboardPage.userCount.getText();

        String expectedUserCount = String.valueOf(userCount);


        //System.out.println("librarianDashboardPage.userCount.getText() = " + librarianDashboardPage.userCount.getText());
        Assert.assertEquals(expectedUserCount, actualUserCount);
    }

    @When("librarian clicks on {string} link")
    public void librarian_clicks_on_link(String string) {
        librarianDashboardPage.usersLink.click();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {


        List<String> actualColumnNames = new ArrayList<>();

        for (WebElement each : librarianDashboardPage.columnNames) {
            actualColumnNames.add(each.getText());
        }

        Assert.assertEquals(expectedColumnNames, actualColumnNames);

    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedUserName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(librarianDashboardPage.userName));
        String actualUserName = librarianDashboardPage.userName.getText();
        Assert.assertEquals(expectedUserName, actualUserName);
    }

    @Then("account holder name should match")
    public void account_holder_name_should_match() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(librarianDashboardPage.userName));
        String actualUserName = librarianDashboardPage.userName.getText();
        Assert.assertEquals(expectedUserName, actualUserName);
    }
}
