package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BaseClass;

public class LoginPage extends BaseClass  {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement txtUserName;
	@FindBy(id="password")
	private WebElement txtPassword;
	@FindBy(id="loginButton")
	private WebElement btnLogin;
	@FindBy(id="Outpatient Clinic")
	private WebElement Outpatientclinic;
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public WebElement getOutpatientclinic() {
		return Outpatientclinic;
	}
	
	public  void logintoTheApplication() {

		enterText(txtUserName, "Admin");
		enterText(txtPassword, "Admin123");
		clickElement(Outpatientclinic);
		clickElement(btnLogin);
		System.out.println("Successfully Logged in ");

	}
	
	
	

}
