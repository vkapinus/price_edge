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

import com.qaprosoft.carina.core.foundation.IAbstractTest;

/**
 * This sample shows how initialize multiple drivers and run the tests on different browsers.
 *
 * @author qpsdemo
 */
public class WebMultipleBrowserTest implements IAbstractTest {

//    @Test
//    @MethodOwner(owner = "qpsdemo")
//    public void multipleBrowserTest() {
//        DashboardHomePage chromeHomePage = new DashboardHomePage(getDriver("chrome", new ChromeCapabilities().getCapability("Chrome Test")));
//        chromeHomePage.open();
//        Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");
//
//        DashboardHomePage firefoxHomePage = new DashboardHomePage(getDriver("firefox", new FirefoxCapabilities().getCapability("Firefox Test")));
//        firefoxHomePage.open();
//        Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");
//        Assert.assertEquals(firefoxHomePage.getDriver().getTitle(), "GSMArena.com - mobile phone reviews, news, specifications and more...");
//        Screenshot.capture(firefoxHomePage.getDriver(), "Firefox capture!");
//
//        NewsPage newsPage = chromeHomePage.getFooterMenu().openNewsPage();
//        final String searchQ = "iphone";
//        List<NewsItem> news = newsPage.searchNews(searchQ);
//        Screenshot.capture(chromeHomePage.getDriver(), "Chrome capture!");
//        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
//
//        for(NewsItem n : news) {
//            System.out.println(n.readTitle());
//            Assert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), searchQ), "Invalid search results!");
//        }
//
//    }
}