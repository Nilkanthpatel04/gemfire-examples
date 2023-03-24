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
import java.util.ArrayList;
import java.util.Date;

public class BookOrder implements Serializable {
  private static final long serialVersionUID = 7526471155622776147L;

  private Integer orderNumber;
  private Date orderDate;
  private float shippingCost;
  private Date shipDate;
  private ArrayList<BookOrderItem> orderItems;
  private Integer customerNumber;
  private float totalPrice;



  public BookOrder() {}



  public BookOrder(Integer orderNumber, Date orderDate, float shippingCost, Date shipDate,
      ArrayList<BookOrderItem> orderItems, Integer customerNumber, float totalPrice) {
    super();
    this.orderNumber = orderNumber;
    this.orderDate = orderDate;
    this.shippingCost = shippingCost;
    this.shipDate = shipDate;
    this.orderItems = orderItems;
    this.customerNumber = customerNumber;
    this.totalPrice = totalPrice;
  }

  public float getTotalPrice() {
    return totalPrice;
  }



  public void setTotalPrice(float totalPrice) {
    this.totalPrice = totalPrice;
  }



  public Integer getCustomerNumber() {
    return customerNumber;
  }



  public void setCustomerNumber(Integer customerNumber) {
    this.customerNumber = customerNumber;
  }



  public void addOrderItem(BookOrderItem item) {
    if (orderItems == null) {
      orderItems = new ArrayList();
    }

    orderItems.add(item);
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public float getShippingCost() {
    return shippingCost;
  }

  public void setShippingCost(float shippingCost) {
    this.shippingCost = shippingCost;
  }

  public Date getShipDate() {
    return shipDate;
  }

  public void setShipDate(Date shipDate) {
    this.shipDate = shipDate;
  }

  public ArrayList<BookOrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(ArrayList<BookOrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BookOrder other = (BookOrder) obj;
    if (orderNumber == null) {
      if (other.orderNumber != null)
        return false;
    } else if (!orderNumber.equals(other.orderNumber))
      return false;
    return true;
  }
}
