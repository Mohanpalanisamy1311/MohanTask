package com.pom;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BaseClass;

import dev.failsafe.internal.util.Assert;

public class PatientDetailPage extends BaseClass {

	public PatientDetailPage() {
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='gender-age col-auto']//span[2]")
	private WebElement age;
	public WebElement getAge() {
		return age;
	}
	@FindBy(xpath="//div[@class='att_header']//time")
	private WebElement attachmentimeElement;
	@FindBy(xpath="//div[contains(text(),' Start Visit')]")
	private WebElement btnstartVisit;
	
	@FindBy(xpath="//p[text()='Are you sure you want to start a visit for Mohan P now?']/following-sibling::button[@class='confirm right']")
	private WebElement btnconfirm;
	
	@FindBy(xpath="//div[@class='active-visit-started-at-message']")
	private WebElement txtRecentvisittime;
	
	@FindBy(xpath="//li[@ng-if='$ctrl.visits.length != 0']")
	private WebElement txtRecentvistattachment;
	
	
	
	
	public WebElement getBtnconfirm() {
		return btnconfirm;
	}

@FindBy(xpath="(//div[contains(text(),'End Visit')])[1]")
private WebElement btnEndvisit;

@FindBy(xpath="(//button[text()='Yes' and @class='confirm right'])[2]")
private WebElement btnvisitconfirm;



	public WebElement getBtnvisitconfirm() {
	return btnvisitconfirm;
}

	public WebElement getBtnEndvisit() {
	return btnEndvisit;
}

	public WebElement getBtnstartVisit() {
		return btnstartVisit;
	}

	public void verifyAge() {
		String displayedage =getElementValue(age);
		
	String s[]=	displayedage.split(" ");
	int actualAge=Integer.parseInt(s[0]);
	//Period period 
	String bornyear=s[s.length-1].substring(7,11);
	String currentdate=new SimpleDateFormat("dd/MMM/YYYY").format(new Date());
	int currentYear=Integer.parseInt(currentdate.substring(currentdate.length()-4));
	int expectedage  =currentYear-Integer.parseInt(bornyear);
	
		Assert.isTrue(expectedage==actualAge, "validating the age calculation");
		System.out.println("Age verified ");
	}
	
	public void startvisiting() {
	btnstartVisit.click();
	btnconfirm.click();
	System.out.println("Started visiting");
	}
	
	public void attachmentCheck() {
		Assert.isTrue(attachmentimeElement.isDisplayed(), "checking the attachment availability")	;
		System.out.println("Attachement check is done");
	}
	public  void recentVisitCheck() {
	Assert.isTrue(txtRecentvistattachment.isDisplayed() ,"recent visit checking status");
System.out.println("Recent visit check Done");
	}
	public  void clickEndVisit() {
		clickElement(btnEndvisit);
		clickElement(btnvisitconfirm);

	}









	public WebElement getAttachmentimeElement() {
		return attachmentimeElement;
	}









	public WebElement getTxtRecentvisittime() {
		return txtRecentvisittime;
	}









	public WebElement getTxtRecentvistattachment() {
		return txtRecentvistattachment;
	}

}
