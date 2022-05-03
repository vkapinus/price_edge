package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddNewItem extends AbstractUIObject {

    @FindBy(xpath = "//h4[text() = 'Add Item']")
    private ExtendedWebElement addItemTitle;

    @FindBy(xpath = "//input[@name = 'Number']")
    private ExtendedWebElement itemNumberField;

    @FindBy(xpath = "//input[@name = 'Name']")
    private ExtendedWebElement itemNameField;

    @FindBy(xpath = "//input[@name = 'CostForPricing']")
    private ExtendedWebElement itemCostForPricingField;

    @FindBy(xpath = "//input[@name = 'Url']")
    private ExtendedWebElement itemUrlField;

    @FindBy(xpath = "//input[@name = 'ImageUrl']")
    private ExtendedWebElement itemImageUrlField;

    @FindBy(xpath = "//button[text()= 'Cancel']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//button[text()= 'Save']")
    private ExtendedWebElement saveButton;

    public AddNewItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public void addNewItem(String itemNumber, String itemName){
        itemNumberField.type(itemNumber);
        itemNameField.type(itemName);
        saveButton.click();
        pause(3);
        driver.navigate().refresh();
    }
}
