package com.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.BaseClass;

import dev.failsafe.internal.util.Assert;

public class RegistrationPage extends BaseClass {

	public RegistrationPage() {
		PageFactory.initElements (driver, this);
	}
	@FindBy(xpath="//input[@name='givenName']")
	private WebElement txtGiven;
	
	@FindBy(xpath="//input[@id='fr6338-field']")
	private WebElement txtMiddle;
	
	@FindBy(xpath="//input[@name='familyName']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//select[@id='gender-field']")
	private WebElement txtgender;
	
	@FindBy(id="address1")
	private WebElement txtAddress;
	
	@FindBy(id="birthdateDay-field")
	private WebElement birthDateday;
	
	@FindBy(id="birthdateMonth-field")
	private WebElement birthDateMonth;
	
	@FindBy(id="birthdateYear-field")
	private WebElement birthDateYear;
	
	@FindBy(id="address1")
	private WebElement address1;
	
	@FindBy(id="address2")
	private WebElement address2;
	
	@FindBy(id="cityVillage")
	private WebElement city;
	
	@FindBy(xpath="//input[@name='phoneNumber']")
	private WebElement phonenum;
	
	@FindBy(id="next-button")
	private WebElement btnnext;
	@FindBy(xpath="//div[@id='dataCanvas']")
	private WebElement datacanvas;
	@FindBy(xpath="(//div[@id='dataCanvas']/div/p)[1]")
	private WebElement userName;
	@FindBy(xpath="(//div[@id='dataCanvas']/div/p)[2]")
	private WebElement gender;
	
	@FindBy(xpath="(//div[@id='dataCanvas']/div/p)[2]")
	private WebElement birthdate;
	@FindBy(xpath="(//div[@id='dataCanvas']/div/p)[3]")
	private WebElement City;

	@FindBy(xpath="(//div[@id='dataCanvas']/div/p)[3]")
	private WebElement phno;
	
	@FindBy(id="submit")
	private WebElement btnconfirm;
	
	public WebElement getTxtGiven() {
		return txtGiven;
	}
	public WebElement getTxtMiddle() {
		return txtMiddle;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtgender() {
		return txtgender;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getBirthDateday() {
		return birthDateday;
	}
	public WebElement getBirthDateMonth() {
		return birthDateMonth;
	}
	public WebElement getBirthDateYear() {
		return birthDateYear;
	}
	public WebElement getAddress1() {
		return address1;
	}
	public WebElement getAddress2() {
		return address2;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getPhonenum() {
		return phonenum;
	}
	public WebElement getBtnnext() {
		return btnnext;
	}
	public WebElement getBtnconfirm() {
		return btnconfirm;
	}
	public WebElement getDatacanvas() {
		return datacanvas;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getGender() {
		return gender;
	}
	public WebElement getBirthdate() {
		return birthdate;
	}
	public WebElement getPhno() {
		return phno;
	}
	
public void completeregistration() {
getTxtGiven().sendKeys("Mohan");
getTxtLastName().sendKeys("P");
getBtnnext().click();
selectDropDown(txtgender, "Male");
getBtnnext().click();
getBirthDateday().sendKeys("2");
selectDropDown(birthDateMonth, "January");	
getBirthDateYear().sendKeys("1995");
btnnext.click();
getAddress1().sendKeys("chennai");
btnnext.click();
enterText(phonenum, "9123456789012");
btnnext.click();
btnnext.click();
System.out.println("Registration Completed");
}
public void verifythepatientInfo() {
	
	Assert.isTrue(( BaseClass.getElementValue(getUserName()).contains("Mohan")),"Check patient name");
	getElementValue(gender).contains("Male");
	getElementValue(birthdate).contains("2, January, 1995");
	getElementValue(City).contains("chennai");
	getElementValue(City).contains("9123456789012");
	getBtnconfirm().click();
	System.out.println("Patient details verified");

}

	

}
