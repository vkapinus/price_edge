package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.AddNewItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsPage extends AbstractPage {

    @FindBy(xpath = "//span[text() = 'Items']")
    private ExtendedWebElement itemsPageTitle;

    @FindBy(xpath = "//button[text() = 'Add ']")
    private ExtendedWebElement addItemButton;

    @FindBy(xpath = "//span[@class = 'ag-cell-value']/a[text() = '%s']")
    private ExtendedWebElement itemNumber;

    @FindBy(xpath = "//div[@class = 'ag-center-cols-container']/div//div/span/a")
    private List<ExtendedWebElement> itemNumbers;

    @FindBy(xpath = "//input[@type='checkbox']")
    //input[@class="ag-input-field-input ag-checkbox-input"]
    private List<ExtendedWebElement> itemsCheckboxes;

    @FindBy(xpath = "//div[contains(@class, 'bp3-dialog')][2]")
    private AddNewItem addNewItemModal;

    @FindBy(xpath = "//button[text() = 'Delete Selected']")
    private ExtendedWebElement deleteSelectedButton;

    @FindBy(xpath = "//button[text() = 'Yes']")
    private ExtendedWebElement yesButton;


    public ItemsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(itemsPageTitle);
    }

    public AddNewItem openAddItemModal(){
        addItemButton.click();
        return addNewItemModal;
    }

    public boolean isItemByNumberPresent(String itemNum){
        return itemNumber.format(itemNum).isPresent();
    }

    public void deleteItemByNumber(String itemNum){
        pause(3);
        itemsCheckboxes.get(9).click();
        pause(3);
        deleteSelectedButton.click();
        if(yesButton.isPresent()){
            yesButton.click();
        }
        driver.navigate().refresh();
    }
}
