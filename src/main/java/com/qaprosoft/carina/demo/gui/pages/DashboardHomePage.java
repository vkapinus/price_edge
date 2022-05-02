/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.demo.gui.components.AddNewWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class DashboardHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text() = 'Price Dashboard']")
    private ExtendedWebElement dashboardTitle;

    @FindBy(className = "user-icon")
    private ExtendedWebElement userIcon;

    @FindBy(className = "expansion")
    private ExtendedWebElement userDropdownList;

    @FindBy(className = "user-info-name")
    private ExtendedWebElement userName;

    @FindBy(className = "user-info-preferences")
    private ExtendedWebElement userPreferencesLink;

    @FindBy(id = "knowledgebase")
    private ExtendedWebElement userKnowledgeBaseLink;

    @FindBy(id = "newZendeskRequest")
    private ExtendedWebElement userSubmitRequestLink;

    @FindBy(id = "changePassword")
    private ExtendedWebElement userChangePasswordLink;

    @FindBy(xpath = "//button[text() = 'Sign out']")
    private ExtendedWebElement signOutButton;

    @FindBy(xpath = "//button[text() = 'Add widget']")
    private ExtendedWebElement addWidgetRightButton;

    @FindBy(xpath = "//button[text() = 'Add widgets to this dashboard']")
    private ExtendedWebElement addWidgetCentralButton;

    @FindBy(xpath = "//p[contains(text(), 'Add any widgets')]")
    private ExtendedWebElement addAnyWidgetsText;

    @FindBy(xpath = "//div[contains(@class, 'widgets-card')]")
    private ExtendedWebElement widgets;

    @FindBy(xpath = "//button[text() = 'Actions']")
    private ExtendedWebElement actionsButton;

    @FindBy(xpath = "//div[text() = 'Remove']")
    private ExtendedWebElement removeWidget;


    public DashboardHomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(dashboardTitle);
    }

    public boolean isAddAnyWidgetsTextPresent(){
        return addAnyWidgetsText.isPresent();
    }

    public void signOut(){
        if(!userName.isPresent()){
            userIcon.click();
        }
        signOutButton.click();
    }

    public boolean userDropdownMenuCorrect(){
        userIcon.click();
        return userName.isPresent() && userPreferencesLink.isPresent() &&
                userKnowledgeBaseLink.isPresent() && userSubmitRequestLink.isPresent() &&
                userChangePasswordLink.isPresent();
    }

    public AddNewWidget clickAddNewWidgetButton(){
        addWidgetRightButton.click();
        return new AddNewWidget(getDriver());
    }

    public AddNewWidget clickAddWidgetCentralButton(){
        addWidgetCentralButton.click();
        return new AddNewWidget(getDriver());
    }

    public boolean isWidgetPresent(){
        pause(3);
        return widgets.isPresent();
    }

    public void removeWidget(){
        widgets.click();
        actionsButton.click();
        removeWidget.click();
    }


}
