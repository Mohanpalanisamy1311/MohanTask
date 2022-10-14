package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.BaseClass;

import dev.failsafe.internal.util.Assert;

public class Vitals extends BaseClass {

	public Vitals() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='w8']")
	private WebElement height;
	
	@FindBy(xpath="//input[@id='w10']")
	private WebElement Weight;
	@FindBy(xpath="//button[@id='next-button']")
	private WebElement btnNext;
	@FindBy(xpath="//span[@id='calculated-bmi']")
	private WebElement BMI;
	public WebElement getHeight() {
		return height;
	}
	public WebElement getWeight() {
		return Weight;
	}
	public WebElement getBtnNext() {
		return btnNext;
	}
	public WebElement getBMI() {
		return BMI;
	}
	
	
	public  void BMICheck() {
	
		enterText(height, "162");
		clickElement(btnNext);
		enterText(Weight, "59");
		clickElement(btnNext);
		String bmi=getElementValue(BMI);
		Double displayedbmi=Double.valueOf(bmi);
		double weight = Double.valueOf("59");
	      double height = Double.valueOf("162");
	      double calcBMI = weight / (height * height);
		
	     if(calcBMI==displayedbmi) {
	    	  System.out.println("BMI validated ");
	     }
	      
	      
	}
	
	
	
}


