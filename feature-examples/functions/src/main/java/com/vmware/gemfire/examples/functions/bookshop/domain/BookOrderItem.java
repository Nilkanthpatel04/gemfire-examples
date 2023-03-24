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
package com.vmware.gemfire.examples.functions.bookshop.domain;

import java.io.Serializable;

public class BookOrderItem implements Serializable {
  private static final long serialVersionUID = 7526471155622776147L;

  private int orderLine;
  private Integer itemNumber;
  private float quantity;
  private float discount;


  public BookOrderItem() {}

  public BookOrderItem(int orderLine, Integer itemNumber, float quantity, float discount) {
    super();
    this.orderLine = orderLine;
    this.itemNumber = itemNumber;
    this.quantity = quantity;
    this.discount = discount;
  }

  public int getOrderLine() {
    return orderLine;
  }

  public void setOrderLine(int orderLine) {
    this.orderLine = orderLine;
  }

  public Integer getItemNumber() {
    return itemNumber;
  }

  public void setItemNumber(Integer itemNumber) {
    this.itemNumber = itemNumber;
  }

  public float getQuantity() {
    return quantity;
  }

  public void setQuantity(float quantity) {
    this.quantity = quantity;
  }

  public float getDiscount() {
    return discount;
  }

  public void setDiscount(float discount) {
    this.discount = discount;
  }

  @Override
  public String toString() {
    return "BookOrderItem [orderLine=" + orderLine + ", itemNumber=" + itemNumber + ", quantity="
        + quantity + ", discount=" + discount + "]";
  }
}
