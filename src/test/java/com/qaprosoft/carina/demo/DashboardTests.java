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
package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.AddNewItem;
import com.qaprosoft.carina.demo.gui.components.AddNewWidget;
import com.qaprosoft.carina.demo.gui.pages.ItemsPage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.zebrunner.agent.core.annotation.Maintainer;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import com.qaprosoft.carina.demo.gui.pages.DashboardHomePage;


/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
@Maintainer("vkapinus")
public class DashboardTests implements IAbstractTest {

    private LoginPage loginPage;

    @BeforeSuite
     void openLoginPage(){
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(R.TESTDATA.get("email"), R.TESTDATA.get("password"));
    }



    @TestRailCases(testCasesId = "1,2")
    @Test(groups ={"MA"})
    public void verifyPossibilityLoginAndLogout(){
        SoftAssert softAssert = new SoftAssert();
        DashboardHomePage dashboardHomePage = new DashboardHomePage(getDriver());
        softAssert.assertTrue(dashboardHomePage.isPageOpened(), "Dashboard home page is not opened");
        softAssert.assertTrue(dashboardHomePage.userDropdownMenuCorrect(), "Dropdown menu is not correct");
        dashboardHomePage.signOut();
        loginPage = new LoginPage(getDriver());
        softAssert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "3,4,5,6")
    @Test(groups ={"MA"})
    public void verifyPossibilityWidgetAdding() {
        loginPage = new LoginPage(getDriver());
        loginPage.login(R.TESTDATA.get("email"), R.TESTDATA.get("password"));
        SoftAssert softAssert = new SoftAssert();
        DashboardHomePage dashboardHomePage = new DashboardHomePage(getDriver());
        softAssert.assertTrue(dashboardHomePage.isAddAnyWidgetsTextPresent(), "Add any widgets text is not present");
        AddNewWidget addNewWidget = dashboardHomePage.clickAddNewWidgetButton();
        softAssert.assertTrue(addNewWidget.isSelectNewWidgetModalOpened(), "Select widget modal is not opened");
        addNewWidget.clickCloseButton();
        dashboardHomePage.clickAddWidgetCentralButton();
        softAssert.assertTrue(addNewWidget.isSelectNewWidgetModalOpened(), "Select widget modal is not opened");
        addNewWidget.selectWidget(1);
        softAssert.assertTrue(dashboardHomePage.isWidgetPresent(), "Widget is not added to dashboard");
        dashboardHomePage.removeWidget();
        softAssert.assertFalse(dashboardHomePage.isWidgetPresent(), "Widget is not removed from dashboard");
        dashboardHomePage.clickAddWidgetCentralButton();
        addNewWidget.selectWidget(1);
        softAssert.assertTrue(dashboardHomePage.isWidgetPresent(), "Widget is not added to dashboard");
        dashboardHomePage.clickAddNewWidgetButton();
        addNewWidget.selectWidget(1);
        softAssert.assertFalse(dashboardHomePage.isWidgetPresent(), "Widget is not removed from dashboard");
        softAssert.assertAll();
    }


    @TestRailCases(testCasesId = "7,8")
    @Test(groups ={"MA"})
    public void verifyPossibilityItemAdding(){
        SoftAssert softAssert = new SoftAssert();
        String itemNumber = "000000000001";
        String itemName = "TEST_PRODUCT";
        DashboardHomePage dashboardHomePage = new DashboardHomePage(getDriver());
        ItemsPage itemsPage  = dashboardHomePage.openPriceObjectElementByName("Items");
        softAssert.assertTrue(itemsPage.isPageOpened(), "Items page is not opened");
        AddNewItem addNewItem = itemsPage.openAddItemModal();
        addNewItem.addNewItem(itemNumber, itemName);
        softAssert.assertTrue(itemsPage.isPageOpened(), "Items page is not opened");
        softAssert.assertTrue(itemsPage.isItemByNumberPresent(itemNumber), "Item was not added");
        itemsPage.deleteItemByNumber(itemNumber);
        softAssert.assertFalse(itemsPage.isItemByNumberPresent(itemNumber), "Item was not removed");
        softAssert.assertAll();
    }
}
