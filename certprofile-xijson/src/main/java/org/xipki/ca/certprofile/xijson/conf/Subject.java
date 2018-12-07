/*
 *
 * Copyright (c) 2013 - 2018 Lijun Liao
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

package org.xipki.ca.certprofile.xijson.conf;

import java.util.LinkedList;
import java.util.List;

import org.xipki.ca.api.profile.Certprofile.StringType;
import org.xipki.ca.certprofile.xijson.conf.Describable.DescribableOid;
import org.xipki.util.InvalidConfException;
import org.xipki.util.ValidatableConf;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.0.0
 */

public class Subject extends ValidatableConf {

  @JSONField(ordinal = 1)
  private boolean incSerialNumber;

  /**
   * whether the RDNs occurs as in the defined ASN.1 order
   */
  @JSONField(ordinal = 2)
  private boolean keepRdnOrder;

  @JSONField(ordinal = 3)
  private List<RdnType> rdns;

  public boolean isIncSerialNumber() {
    return incSerialNumber;
  }

  public void setIncSerialNumber(boolean incSerialNumber) {
    this.incSerialNumber = incSerialNumber;
  }

  public boolean isKeepRdnOrder() {
    return keepRdnOrder;
  }

  public void setKeepRdnOrder(boolean keepRdnOrder) {
    this.keepRdnOrder = keepRdnOrder;
  }

  public List<RdnType> getRdns() {
    if (rdns == null) {
      rdns = new LinkedList<>();
    }
    return rdns;
  }

  public void setRdns(List<RdnType> rdns) {
    this.rdns = rdns;
  }

  @Override
  public void validate() throws InvalidConfException {
    notEmpty(rdns, "rdns");
    validate(rdns);
  }

  public static class RdnType extends ValidatableConf {

    @JSONField(ordinal = 1)
    private DescribableOid type;

    @JSONField(ordinal = 2)
    private Integer minLen;

    @JSONField(ordinal = 3)
    private Integer maxLen;

    @JSONField(ordinal = 4)
    private StringType stringType;

    @JSONField(ordinal = 5)
    private String regex;

    @JSONField(ordinal = 6)
    private String prefix;

    @JSONField(ordinal = 7)
    private String suffix;

    @JSONField(ordinal = 8)
    private int minOccurs = 1;

    @JSONField(ordinal = 9)
    private int maxOccurs = 1;

    @JSONField(ordinal = 10)
    private String group;

    public DescribableOid getType() {
      return type;
    }

    public void setType(DescribableOid type) {
      this.type = type;
    }

    public Integer getMinLen() {
      return minLen;
    }

    public void setMinLen(Integer minLen) {
      this.minLen = minLen;
    }

    public Integer getMaxLen() {
      return maxLen;
    }

    public void setMaxLen(Integer maxLen) {
      this.maxLen = maxLen;
    }

    public StringType getStringType() {
      return stringType;
    }

    public void setStringType(StringType stringType) {
      this.stringType = stringType;
    }

    public String getRegex() {
      return regex;
    }

    public void setRegex(String regex) {
      this.regex = regex;
    }

    public String getPrefix() {
      return prefix;
    }

    public void setPrefix(String prefix) {
      this.prefix = prefix;
    }

    public String getSuffix() {
      return suffix;
    }

    public void setSuffix(String suffix) {
      this.suffix = suffix;
    }

    public int getMinOccurs() {
      return minOccurs;
    }

    public void setMinOccurs(int minOccurs) {
      this.minOccurs = minOccurs;
    }

    public int getMaxOccurs() {
      return maxOccurs;
    }

    public void setMaxOccurs(int maxOccurs) {
      this.maxOccurs = maxOccurs;
    }

    public String getGroup() {
      return group;
    }

    public void setGroup(String group) {
      this.group = group;
    }

    @Override
    public void validate() throws InvalidConfException {
      notNull(type, "type");
      validate(type);
      if (minOccurs > maxOccurs) {
        throw new InvalidConfException(
            "minOccurs (" + minOccurs + ") may not be greater than maxOccurs (" + maxOccurs + ")");
      }
    }

  }

}

