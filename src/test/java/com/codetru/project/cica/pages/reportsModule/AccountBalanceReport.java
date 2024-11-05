package com.codetru.project.cica.pages.reportsModule;

import static com.codetru.keywords.WebUI.sleep;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;

public class AccountBalanceReport extends CommonPageCICA {
	private By title = By.xpath("//ion-title[starts-with(text(), 'Account Balance - Post')]");
	private By agentDetails = By.xpath("//ion-list-header");
	private By agentCaret_btn = By.xpath("//ion-icon[@name='caret-down']");
//	private By agentsList=By.xpath("//ion-list[@role='list']/parent::ion-list");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn = By.xpath("//ion-button[text()='Close']");
	private By searchBar = By.xpath("//ion-searchbar[@type='text']");
	private By agentsText = By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput = By.xpath("//input[@aria-label='search text']");
	private By resetBtn = By.xpath("//button[@aria-label='reset']");
	private By dateFilter = By.xpath("//select[@formcontrolname='dateFilter']");
	private By checkDate = By.xpath("//h2[.='Advance Account Balance ']/following-sibling::tbody/tr[3]/td");
	private By advanceAccountBalance = By.xpath("//*[text()=' Advance Account Balance ']");
	private By agentId = By.xpath("(//table)[2]/tbody/tr/td[2]");
	private By HighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[1]");
	private By secondHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[2]");
	private By thirdHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[3]");
	private By fourthHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[4]");
	private By fifthHighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[5]");
	private By postedDateCol = By
			.xpath("//h2[.='Advance Account Balance ']/following-sibling::thead/tr/th[.='Posted Date']");
	private By descriptionCol = By
			.xpath("//h2[.='Advance Account Balance ']/following-sibling::thead/tr/th[.='Description']");
	private By amountCol = By.xpath("//h2[.='Advance Account Balance ']/following-sibling::thead/tr/th[.='Amount']");
	private By details = By
			.xpath("//h2[.='Advance Account Balance ']/parent::table/following-sibling::ion-button[.='Details']");
	private By postedDateCol2 = By
			.xpath("//h2[.='As-Earned Commission Account Balance ']/following-sibling::thead/tr/th[.='Posted Date']");
	private By descriptionCol2 = By
			.xpath("//h2[.='As-Earned Commission Account Balance ']/following-sibling::thead/tr/th[.='Description']");
	private By amountCol2 = By
			.xpath("//h2[.='As-Earned Commission Account Balance ']/following-sibling::thead/tr/th[.='Amount']");
//private By details2=By.xpath("//h2[.='As-Earned Commission Account Balance ']/parent::table/following-sibling::ion-button[.='Details']");
	private By exportDownloadBtn = By.xpath("//ion-button[.=' Export for Full Details ']");
	private By pagenationDropdown = By.xpath("//option[.='10']/parent::select");
	private By pagenation = By.xpath("//ion-col[starts-with(text(), ' Page')]");

	public void accountBalance() throws Exception {

		String id = null;
		String fullName = null;
		String[] nameParts = null;
		String lastName = null;
		String five = "5";
		String firstName = null;
		String newTabUrl = "chrome://downloads/";

		String jspath = "return document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#file-link\")";

		WebUI.sleep(3);
		WebUI.verifyElementVisible(title);
		WebUI.clickElement(advanceAccountBalance);
		WebUI.sleep(2);
		WebUI.clickElementWithJs(agentCaret_btn);
		WebUI.verifyElementVisible(agentsList);
		WebUI.verifyElementVisible(closeBtn);
		WebUI.verifyElementVisible(searchBar);
		WebUI.verifyElementVisible(agentDetails);
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementNotVisible(agentsList);
		WebUI.clickElement(agentCaret_btn);
		WebUI.setText(searchBoxInput, "55555");
		WebUI.sleep(0.6);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.setText(searchBoxInput, "Japfu");
		WebUI.sleep(0.6);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.setText(searchBoxInput, "magpie");
		WebUI.sleep(0.6);
		WebUI.verifyElementNotVisible(agentsText);
		WebUI.clearText(searchBoxInput);
		WebUI.sleep(0.6);
		WebUI.clickElement(resetBtn);
		WebUI.sleep(1.5);
		String Id1 = WebUI.validateElementContainsDataAndExtractID(HighestLevel);
		try {
			DriverManager.getDriver().findElement(secondHighestLevel).isDisplayed();
			String Id2 = WebUI.validateElementContainsDataAndExtractID(secondHighestLevel);
			String Id3 = WebUI.validateElementContainsDataAndExtractID(thirdHighestLevel);
			String Id4 = WebUI.validateElementContainsDataAndExtractID(fourthHighestLevel);
			String Id5 = WebUI.validateElementContainsDataAndExtractID(fifthHighestLevel);
			System.out.println(Id3);
			WebUI.sleep(2);

			Pattern pattern = Pattern.compile("\\d+\\s*-\\s*-\\s*(\\d+)\\s*-\\s*([^,]+),\\s*(.+)");
			List<String> listNames = WebUI.getElementTextsInList(agentsText);
			int count = 0;
			for (String name : listNames) {
				System.out.println(name);
			    if (count >= 2) {
			        break;
			    }
			    System.out.println("Processing: " + name);  
			    Matcher matcher = pattern.matcher(name);
			    if (matcher.find()) {
			        id = matcher.group(1).trim();
			        lastName = matcher.group(2).trim();
			        firstName = matcher.group(3).trim();
			        System.out.println("ID: " + id);
			        System.out.println("Last Name: " + lastName);
			        System.out.println("First Name: " + firstName);
			        WebUI.setText(searchBoxInput, id);
			        WebUI.sleep(1);
			        WebUI.verifyContains(WebUI.getTextElement(agentsText), id);
			        WebUI.sleep(0.2);
			        WebUI.clearText(searchBoxInput);
			        WebUI.setText(searchBoxInput, firstName);
			        WebUI.sleep(1);
			        WebUI.verifyContains(WebUI.getTextElement(agentsText), firstName);
			        WebUI.sleep(0.2);
			        WebUI.clearText(searchBoxInput);
			        WebUI.setText(searchBoxInput, lastName);
			        WebUI.sleep(1);
			        WebUI.verifyContains(WebUI.getTextElement(agentsText), lastName);
			        WebUI.sleep(0.2);
			        WebUI.clearText(searchBoxInput);
			        count++;
			        System.out.println("Count: " + count);  
			    } else {
			        System.out.println("Pattern did not match for: " + name);  
			    }
			}
			WebUI.clickElement(resetBtn);
			WebUI.sleep(0.2);
			WebUI.clickElement(closeBtn);
			WebUI.sleep(0.2);
			WebUI.verifyElementNotVisible(HighestLevel);
			WebUI.clickElement(agentCaret_btn);
			WebUI.sleep(0.2);
			WebUI.clickElement(HighestLevel);
			WebUI.sleep(0.5);
			WebUI.clickElement(dateFilter);
			String selectedMonth = WebUI.getTextElement(dateFilter);
			WebUI.sleep(2);
			WebUI.clickElement(dateFilter);
			WebUI.sleep(0.2);
			WebUI.scrollToElementAtBottom(checkDate);
			WebUI.sleep(0.5);
			WebUI.verifyElementVisible(agentId);
			String[] dateParts = WebUI.getTextElement(checkDate).split("/");
			String month = dateParts[0];
			String year = dateParts[2];
			String formattedDate = month + "/" + year;
			WebUI.verifyContains(selectedMonth, formattedDate);
			WebUI.scrollToElementAtBottom(details);
			WebUI.verifyElementVisible(postedDateCol);
			WebUI.verifyElementVisible(descriptionCol);
			WebUI.verifyElementVisible(amountCol);
			WebUI.verifyElementVisible(details);
			WebUI.verifyElementVisible(postedDateCol2);
			WebUI.verifyElementVisible(descriptionCol2);
			WebUI.verifyElementVisible(amountCol2);
			// WebUI.verifyElementVisible(details2);
			WebUI.sleep(0.5);
			WebUI.clickElement(details);
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.sleep(0.2);
			WebUI.clickElement(pagenationDropdown);
			WebUI.selectOptionByText(pagenationDropdown, five);
			WebUI.verifyElementVisible(exportDownloadBtn);
			WebUI.clickElement(exportDownloadBtn);
			WebUI.sleep(2);
			WebUI.openNewTabWindow(newTabUrl);
			WebUI.sleep(2);
			// WebUI.clickWebElementwithJs(jspath);
			WebUI.switchToMainWindow();
		} catch (Exception e) {
			System.out.println("There is only one agent in this Login");
			try {
				if (DriverManager.getDriver().findElement(closeBtn).isDisplayed()) {
					WebUI.clickElement(closeBtn);
				}
			} catch (Exception ex) {
				sleep(0.5);
			}
			WebUI.clickElement(details);
			WebUI.scrollToElementAtBottom(pagenation);
			WebUI.sleep(0.2);
			WebUI.clickElement(pagenationDropdown);
			WebUI.selectOptionByText(pagenationDropdown, five);
			WebUI.scrollToElementAtBottom(exportDownloadBtn);
			WebUI.clickElement(exportDownloadBtn);

		}
	}
}