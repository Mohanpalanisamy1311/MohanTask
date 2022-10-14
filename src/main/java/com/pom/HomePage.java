package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='icon-user']")
	private WebElement iconRegisterPatient;

	public WebElement getIconRegisterPatient() {
		return iconRegisterPatient;
	}

	public void setIconRegisterPatient(WebElement iconRegisterPatient) {
		this.iconRegisterPatient = iconRegisterPatient;
	}

	public void clickingtheRegisterpatient() {

		clickElement(iconRegisterPatient);
		System.out.println("Registration started ");

	}

}
