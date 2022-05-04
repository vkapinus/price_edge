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
package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

@Endpoint(url = "${base_url}/api/priceobjects/Items/${itemNumber}/ManualPrices", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/objects/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetItemByNumber extends AbstractApiMethodV2 {

    public GetItemByNumber(String itemNumber) {
        setHeaders("Authorization=Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1bmlxdWVfbmFtZSI6InNvbHZkLnZpa3RvcnlpYS5rYXBpbnVzIiwic3ViIjoic29sdmQudmlrdG9yeWlhLmthcGludXMiLCJyb2xlIjoiQWRtaW5pc3RyYXRvciIsImlzcyI6ImxvY2FsaG9zdCIsImF1ZCI6IjViOTE5YWY0MmU0YTQ5OGViNGM3OTA5ZWUzMDJiMDkwIiwiZXhwIjoxNjUxNjY2Mzc4LCJuYmYiOjE2NTE2NjQ1Nzh9.hT1Juv-zHXRcAFKX-lbGxSOLlIl44omQr8IHxoAn5l8");
        replaceUrlPlaceholder("base_url", R.CONFIG.get("api_url"));
        replaceUrlPlaceholder("itemNumber", String.valueOf(itemNumber));
    }
}