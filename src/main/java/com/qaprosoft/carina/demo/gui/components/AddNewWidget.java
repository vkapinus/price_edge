package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddNewWidget extends AbstractUIObject {

    @FindBy(xpath = "//h4[contains(text(), 'Select which widgets')]")
    private ExtendedWebElement selectWidgetTitle;

    @FindBy(xpath = "//button[@aria-label = 'Close']")
    private ExtendedWebElement closeModalButton;

    @FindBy(xpath = "//button[text() = 'Save']")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//button[text() = 'Cancel']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//input[@type = 'search']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[text()= 'Widgets']/following-sibling::ul/li//span[@class = 'bp3-control-indicator']")
    private List<ExtendedWebElement> widgetsElementsCheckBoxes;

    @FindBy(xpath = "//div[text()= 'Reports']/following-sibling::ul/li//span[@class = 'bp3-control-indicator']")
    private List<ExtendedWebElement> reportsElementsCheckBoxes;

    @FindBy(xpath = "//div[text()= 'Processes pricegroups']/following-sibling::ul/li//span[@class = 'bp3-control-indicator']")
    private List<ExtendedWebElement> processPricegroupsElementsCheckBoxes;

    public AddNewWidget(WebDriver driver) {
        super(driver);
    }

    public boolean isSelectNewWidgetModalOpened(){
        return selectWidgetTitle.isPresent();
    }

    public void clickCloseButton(){
        closeModalButton.click();
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public void selectWidget(int widgetType){
        widgetsElementsCheckBoxes.get(widgetType - 1).click();
        clickSaveButton();
    }


}
