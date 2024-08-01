package com.wtw.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wtw.enums.WaitType;
import com.wtw.utils.DriverUtilites;

public class FooterPage {

	@FindBy(xpath = "//a[@data-test='social-twitter']")
	private WebElement iconTwitter;

	@FindBy(xpath = "//a[@data-test='social-facebook']")
	private WebElement iconFacebook;

	@FindBy(xpath = "//a[@data-test='social-linkedin']")
	private WebElement iconLinkedin;

	private WebDriver driver;

	public FooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public FooterPage clickTwitterIcon() {
		DriverUtilites.scrollToElement(iconTwitter);
		DriverUtilites.click(iconTwitter, WaitType.CLICKABLE, "Twitter icon");
		return this;
	}

	public FooterPage clickFacebookIcon() {
		DriverUtilites.scrollToElement(iconFacebook);
		DriverUtilites.click(iconFacebook, WaitType.CLICKABLE, "Facebook icon");
		return this;
	}

	public FooterPage clickLinkedinIcon() {
		DriverUtilites.scrollToElement(iconLinkedin);
		DriverUtilites.click(iconLinkedin, WaitType.CLICKABLE, "linkdein icon");
		return this;
	}
}
