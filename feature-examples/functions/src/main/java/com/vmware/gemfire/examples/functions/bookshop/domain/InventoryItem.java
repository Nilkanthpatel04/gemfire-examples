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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import org.apache.geode.Delta;
import org.apache.geode.InvalidDeltaException;

public class InventoryItem implements Serializable, Delta {
  private static final long serialVersionUID = 7526471155622776147L;

  private int itemNumber;
  private float costToXYZ;
  private float priceToCustomer;
  private float quantityInStock;
  private String vendor;
  private String location;

  private transient boolean costChg = false;
  private transient boolean priceChg = false;
  private transient boolean qtyChg = false;
  private transient boolean vndChg = false;



  public InventoryItem(int itemNumber, float costToXYZ, float priceToCustomer,
      float quantityInStock, String vendor, String location) {
    super();
    this.itemNumber = itemNumber;
    this.costToXYZ = costToXYZ;
    this.priceToCustomer = priceToCustomer;
    this.quantityInStock = quantityInStock;
    this.vendor = vendor;
    this.location = location;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
    this.vndChg = true;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setItemNumber(int itemNumber) {
    this.itemNumber = itemNumber;
  }

  public float getCostToXYZ() {
    return costToXYZ;
  }

  public void setCostToXYZ(float costToXYZ) {
    this.costToXYZ = costToXYZ;
    this.costChg = true;
  }

  public float getPriceToCustomer() {
    return priceToCustomer;
  }

  public void setPriceToCustomer(float priceToCustomer) {
    this.priceToCustomer = priceToCustomer;
    this.priceChg = true;
  }

  public float getQuantityInStock() {
    return quantityInStock;
  }

  public void setQuantityInStock(float quantityInStock) {
    this.quantityInStock = quantityInStock;
    this.qtyChg = true;
  }

  @Override
  public String toString() {
    return "InventoryItem [itemNumber=" + itemNumber + ", quantityInStock=" + quantityInStock
        + ", location=" + location + "]";
  }


  @Override
  public void fromDelta(DataInput in) throws IOException, InvalidDeltaException {
    if (in.readBoolean()) {
      this.priceToCustomer = in.readFloat();
    }
    if (in.readBoolean()) {
      this.costToXYZ = in.readFloat();

    }
    if (in.readBoolean())
      this.quantityInStock = in.readFloat();
    if (in.readBoolean())
      this.vendor = in.readLine();

    System.out.println("InventoryItem: finished fromDelta()");
  }

  @Override
  public boolean hasDelta() {
    System.out.println("InventoryItem: in hasDelta()");
    return priceChg || costChg || qtyChg || vndChg;


  }

  @Override
  public void toDelta(DataOutput out) throws IOException {
    out.writeBoolean(priceChg);
    if (priceChg) {
      out.writeFloat(this.priceToCustomer);
      this.priceChg = false;
    }

    out.writeBoolean(costChg);
    if (costChg) {
      out.writeFloat(this.costToXYZ);
      this.costChg = false;
    }

    out.writeBoolean(qtyChg);
    if (qtyChg) {
      out.writeFloat(quantityInStock);
      this.qtyChg = false;
    }

    out.writeBoolean(vndChg);
    if (vndChg) {
      out.writeChars(vendor);
      this.vndChg = false;
    }

    System.out.println("InventoryItem: finished toDelta()");

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(costToXYZ);
    result = prime * result + itemNumber;
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + Float.floatToIntBits(priceToCustomer);
    result = prime * result + Float.floatToIntBits(quantityInStock);
    result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
    InventoryItem other = (InventoryItem) obj;
    if (Float.floatToIntBits(costToXYZ) != Float.floatToIntBits(other.costToXYZ))
      return false;
    if (itemNumber != other.itemNumber)
      return false;
    if (location == null) {
      if (other.location != null)
        return false;
    } else if (!location.equals(other.location))
      return false;
    if (Float.floatToIntBits(priceToCustomer) != Float.floatToIntBits(other.priceToCustomer))
      return false;
    if (Float.floatToIntBits(quantityInStock) != Float.floatToIntBits(other.quantityInStock))
      return false;
    if (vendor == null) {
      if (other.vendor != null)
        return false;
    } else if (!vendor.equals(other.vendor))
      return false;
    return true;
  }
}
