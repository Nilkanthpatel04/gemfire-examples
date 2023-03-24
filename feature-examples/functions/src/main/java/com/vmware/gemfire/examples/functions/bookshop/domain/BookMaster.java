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

public class BookMaster implements Serializable {
  private static final long serialVersionUID = 7526471155622776147L;
  private int itemNumber;
  private String description;
  private float retailCost;
  private int yearPublished;
  private String author;
  private String title;

  public BookMaster(int itemNumber, String description, float retailCost, int yearPublished,
      String author, String title) {
    super();
    this.itemNumber = itemNumber;
    this.description = description;
    this.retailCost = retailCost;
    this.yearPublished = yearPublished;
    this.author = author;
    this.title = title;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + itemNumber;
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
    BookMaster other = (BookMaster) obj;
    if (itemNumber != other.itemNumber)
      return false;
    return true;
  }


  public int getItemNumber() {
    return itemNumber;
  }

  public void setItemNumber(int itemNumber) {
    this.itemNumber = itemNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getRetailCost() {
    return retailCost;
  }

  public void setRetailCost(float retailCost) {
    this.retailCost = retailCost;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public String toString() {
    return "BookMaster [itemNumber=" + itemNumber + ", title=" + title + "]";
  }
}
