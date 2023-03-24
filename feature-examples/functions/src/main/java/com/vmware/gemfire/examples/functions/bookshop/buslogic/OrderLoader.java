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
package com.vmware.gemfire.examples.functions.bookshop.buslogic;

import java.util.ArrayList;
import java.util.Date;

import com.vmware.gemfire.examples.functions.bookshop.domain.BookOrder;
import com.vmware.gemfire.examples.functions.bookshop.domain.BookOrderItem;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;

/*
 * This is a fallback class that was used early on to bootstrap the BookOrder data. It presumed you
 * had a locator and server(s) started. In general though, the preferred approach is to run the
 * server-bootstrap start script to start the server processes. That way, this works as a stand
 * alone when a client-only course is defined.
 *
 */
public class OrderLoader {
  private ClientCache cache;

  public static void main(String[] args) {
    OrderLoader loader = new OrderLoader();
    loader.getCache();
    loader.populateBookOrders();
    loader.closeCache();
  }

  public void setCache(ClientCache cache) {
    this.cache = cache;
  }


  public void populateBookOrders() {
    // Region<Integer, BookOrder> orders = cache.getRegion("BookOrder");
    // create a local region that matches the server region
    Region<Integer, BookOrder> orders =
        cache.<Integer, BookOrder>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY)
            .create("BookOrder");

    // Order for Kari Powell for book: A Treatise of Treatises
    BookOrder order1 = new BookOrder(17699, new Date(), (float) 5.99, new Date(), new ArrayList(),
        5598, (float) 40.98);
    order1.addOrderItem(new BookOrderItem(1, 123, (float) 1, (float) 0));
    orders.put(17699, order1);

    // Order for Lula Wax book: A Treatise of Treatises & Clifford the Big Red Dog
    BookOrder order2 = new BookOrder(17700, new Date(), (float) 5.99, new Date(), new ArrayList(),
        5543, (float) 52.97);
    order2.addOrderItem(new BookOrderItem(1, 123, (float) 1, (float) 0));
    order2.addOrderItem(new BookOrderItem(2, 456, (float) 1, (float) 0));
    orders.put(17700, order2);
  }

  public void closeCache() {
    cache.close();
  }

  public void getCache() {
    // create cache using XML
    /**
     * this.cache = new ClientCacheFactory() .set("name", "ClientWorker") .set("cache-xml-file",
     * "xml/clientCache.xml") .create();
     */

    // connect to the locator using default port 10334
    this.cache = new ClientCacheFactory().addPoolLocator("127.0.0.1", 10334)
        .set("log-level", "WARN").create();
  }
}
