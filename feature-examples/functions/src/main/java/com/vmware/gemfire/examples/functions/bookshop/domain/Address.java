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

public class Address implements Serializable {
  private static final long serialVersionUID = 7526471155622776147L;

  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String city;
  private String state;
  private String postalCode;
  private String country;
  private String phoneNumber;
  private String addressTag;

  public Address(String postalCode) {
    this.postalCode = postalCode;
  }

  public Address(String addressLine1, String addressLine2, String addressLine3, String city,
      String state, String postalCode, String country, String phoneNumber, String addressTag) {
    super();
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.addressLine3 = addressLine3;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;
    this.phoneNumber = phoneNumber;
    this.addressTag = addressTag;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getAddressLine3() {
    return addressLine3;
  }

  public void setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddressTag() {
    return addressTag;
  }

  public void setAddressTag(String addressTag) {
    this.addressTag = addressTag;
  }

  @Override
  public String toString() {
    return "Address [addressTag=" + addressTag + ", addressLine1=" + addressLine1 + ", city=" + city
        + ", state=" + state + ", postalCode=" + postalCode + ", country=" + country
        + ", phoneNumber=" + phoneNumber + "]";
  }
}
