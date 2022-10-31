package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibrarianDashboardPage {

    public LibrarianDashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//h2[.='173']")
    public WebElement userCount;


    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersLink;


    @FindBy(xpath = "//th")
    public List<WebElement> columnNames;


    @FindBy(xpath = "//img[@id='user_avatar']/following-sibling::span")
    public WebElement userName;
}
