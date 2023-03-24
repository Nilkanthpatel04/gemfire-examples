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

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.distributed.DistributedMember;

public class SummingResultCollector implements ResultCollector<Serializable, Serializable> {
  // TODO-03: Determine what type will be used to contain results
  // HINT: You only need to keep a final sum
  BigDecimal total = BigDecimal.ZERO;

  @Override
  public void addResult(DistributedMember memberID, Serializable resultOfSingleExecution) {
    // TODO-04: Implement the addResult method
    // HINT: Keep in mind what was sent from the function in the prior lab.
    total = total.add((BigDecimal) resultOfSingleExecution);
  }

  @Override
  public void clearResults() {
    // TODO-05: Implement clearResults method
    total = BigDecimal.ZERO;

  }

  @Override
  public void endResults() {
    // No special processing required.

  }

  @Override
  public Serializable getResult() throws FunctionException {
    // TODO-06: Implement getResult method
    return total.setScale(2, RoundingMode.HALF_UP);
  }

  @Override
  public Serializable getResult(long timeout, TimeUnit unit)
      throws FunctionException, InterruptedException {
    // This method will do whatever the other getResult() method does.
    return this.getResult();
  }
}
