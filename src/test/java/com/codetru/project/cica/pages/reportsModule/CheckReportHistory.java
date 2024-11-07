package com.codetru.project.cica.pages.reportsModule;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.codetru.driver.DriverManager;
import com.codetru.keywords.WebUI;
import com.codetru.project.cica.CommonPageCICA;
import com.codetru.project.cica.utils.ProjectUtilities;

public class CheckReportHistory extends CommonPageCICA {
	private By title = By.xpath("//ion-title[starts-with(text(),'Check Report')]");
	private By agentDetails = By.xpath("//ion-list-header");
	private By agentCaret_btn = By.xpath("//ion-icon[@name='caret-down']");
//private By agentsList=By.xpath("//ion-list[@role='list']/parent::ion-list");
	private By agentsList = By.xpath("//ion-list[@role='list']/ancestor::ion-item");
	private By closeBtn = By.xpath("//ion-button[text()='Close']");
	private By searchBar = By.xpath("//ion-searchbar[@type='text']");
	private By agentsText = By.xpath("//ion-list-header[contains(text(), ',')]");
	private By searchBoxInput = By.xpath("//input[@aria-label='search text']");
	private By resetBtn = By.xpath("//button[@aria-label='reset']");
	private By dateFilter = By.xpath("//select[@formcontrolname='dateFilter']");
	private By selectMnth = By.xpath("//select[@formcontrolname='dateFilter']/option[3]");
	private By loadMnthBtn = By.xpath("//ion-button[.=' Load Month ']");
	private By checkDate = By.xpath("((//table)[2]/tbody/tr/td[12])[1]");
	private By agentId = By.xpath("(//table)[2]/tbody/tr/td[2]");
	private By loadAllBtn = By.xpath("//ion-button[.=' Load All ']");
	private By loadAllBtnText = By.xpath("//ion-col[.=' Load all is export only. ']");
	private By exportBtn = By.xpath("//ion-button[.=' Export ']");
	private By HighestLevel = By.xpath("(//ion-list-header[contains(text(), ',')])[1]");
	private By searchingSpinner = By.xpath("//div[text()='Searching...']");

	public void checkReportsHistory() {
		String id = null;
		String fullName = null;
		String[] nameParts = null;
		String lastName = null;
		String firstName = null;

		String newTabUrl = "chrome://downloads/";

		WebUI.sleep(5);
		WebUI.verifyElementVisible(title);
		WebUI.clickElement(agentCaret_btn);
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
		WebUI.sleep(1);
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
		WebUI.clickElement(closeBtn);
		WebUI.verifyElementNotVisible(HighestLevel);
		WebUI.clickElement(agentCaret_btn);
		WebUI.clickElement(HighestLevel);
		WebUI.clickElement(dateFilter);
		String selectedMonth = WebUI.getTextElement(selectMnth);
		WebUI.clickElement(selectMnth);
		WebUI.clickElement(loadMnthBtn);
		ProjectUtilities.spinnerWaitWithTime(searchingSpinner,30);
		try {
			if (DriverManager.getDriver().findElement(checkDate).isDisplayed()) {
				WebUI.scrollToElementAtBottom(checkDate);
				WebUI.verifyElementVisible(agentId);
				String[] dateParts = WebUI.getTextElement(checkDate).split("/");
				String month = dateParts[0];
				String year = dateParts[2];
				String formattedDate = month + "/" + year;
				WebUI.verifyContains(selectedMonth, formattedDate);
			}
		} catch (Exception ex) {
			WebUI.sleep(1);
		}
		WebUI.verifyElementVisible(loadAllBtn);
		WebUI.clickElement(loadAllBtn);
		ProjectUtilities.spinnerWaitWithTime(searchingSpinner,30);
		WebUI.scrollToElementAtBottom(loadAllBtnText);
		WebUI.verifyElementVisible(loadAllBtnText);
		WebUI.clickElement(exportBtn);
		WebUI.sleep(2);
		WebUI.openNewTabWindow(newTabUrl);
		WebUI.sleep(1);
		WebUI.switchToMainWindow();

	}
}
