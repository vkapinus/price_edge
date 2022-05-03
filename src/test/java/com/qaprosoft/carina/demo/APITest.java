package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.demo.api.GetItemByNumber;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APITest{
    @Test
    public void testItemByNumber() {
        String number = "0.001";
        GetItemByNumber getItemMethod = new GetItemByNumber(number);
        getItemMethod.callAPIExpectSuccess();
        getItemMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }


//    @Test
//    public void testCreateUser() {
//        PostMethod postMethod = new PostMethod();
//        postMethod.callAPIExpectSuccess();
//        postMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
//    }
//
//    @Test
//    public void testDeletePost() {
//        int id = 1;
//        DeleteUserByIdMethod deleteUserById = new DeleteUserByIdMethod(id);
//        deleteUserById.callAPI();
//    }
}
