/*
 *
 * Copyright (c) 2013 - 2019 Lijun Liao
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

package org.xipki.ocsp.server.store;

/**
 * TODO.
 * @author Lijun Liao
 * @since 2.0.0
 */

class SimpleIssuerEntry {

  private final int id;

  private final Long revocationTimeMs;

  SimpleIssuerEntry(int id, Long revocationTimeMs) {
    this.id = id;
    this.revocationTimeMs = revocationTimeMs;
  }

  public boolean match(IssuerEntry issuer) {
    if (id != issuer.getId()) {
      return false;
    }

    if (revocationTimeMs == null) {
      return issuer.getRevocationInfo() == null;
    }

    return (issuer.getRevocationInfo() == null) ? false
        : revocationTimeMs == issuer.getRevocationInfo().getRevocationTime().getTime();
  }

} // class SimpleIssuerEntry
