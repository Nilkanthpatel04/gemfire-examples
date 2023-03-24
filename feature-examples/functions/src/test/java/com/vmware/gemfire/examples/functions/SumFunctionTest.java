// Copyright (c) VMware, Inc. 2023.
// All rights reserved. SPDX-License-Identifier: Apache-2.0

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vmware.gemfire.examples.functions;



import java.math.BigDecimal;

import com.vmware.gemfire.examples.functions.bookshop.buslogic.SummingResultCollector;
import com.vmware.gemfire.examples.functions.bookshop.domain.BookMaster;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;


public class SumFunctionTest {
  private Region<Integer, BookMaster> books;
  private ClientCache cache;

  @Before
  public void setup() {
    // XML way of creating cache and region
    /*
     * cache = new ClientCacheFactory() .set("name", "ClientWorker") .set("cache-xml-file",
     * "xml/clientCache.xml").create(); books = cache.getRegion("BookOrder");
     */

    // connect to the locator using default port 10334
    this.cache = new ClientCacheFactory().addPoolLocator("127.0.0.1", 10334)
        .set("log-level", "WARN").create();

    this.books =
        cache.<Integer, BookMaster>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY)
            .create("BookOrder");
  }


  @After
  public void teardown() {
    System.out.println("********************************************");
    System.out.println("Closing the cache and disconnecting.");
    cache.close();
  }

  @Test
  public void shouldComputeTotalForAllOrders() throws Exception {

    // TODO-07: execute the function using the totalPrice field on the BookOrder object
    Execution execution = FunctionService.onRegion(books).setArguments("totalPrice")
        .withCollector(new SummingResultCollector());

    ResultCollector rc = execution
        .execute("com.vmware.gemfire.examples.functions.bookshop.buslogic.GenericSumFunction");

    // TODO-08: Get result and assert that the two orders total $93.95
    BigDecimal result = (BigDecimal) rc.getResult();

    System.out.println("Function execution result --> " + result.toString());
    // assertEquals(new BigDecimal("93.95"), result);


  }
}
