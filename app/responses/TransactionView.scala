/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package responses

object TransactionView {

  def successResponse(stcId: String, utrn: String): String =
    s"""
      |{
      |  "success": {
      |    "processingDate": "2001-12-17T09:30:47Z",
      |    "charges": [
      |      {
      |        "chargeTypeDescription": "chargeTypeDescription1",
      |        "chargeReference": "XA001234567890",
      |        "chargeType": "STC",
      |        "chargeAmount": 0,
      |        "chargeDueDate": "1900-03-14"
      |      },
      |      {
      |        "chargeTypeDescription": "chargeTypeDescription2",
      |        "chargeReference": "XA001234567891",
      |        "chargeType": "STC",
      |        "chargeAmount": 0,
      |        "chargeDueDate": "1900-03-15"
      |      }
      |    ],
      |    "transactionDetails": {
      |      "submissionId": "123456789012",
      |      "submissionDate": "2026-03-14",
      |      "recordId": 1,
      |      "transactionType": 1,
      |      "reasonForPurchase": 1,
      |      "descriptionOfSecurity": "Ordinary A",
      |      "numberOfShares": 1,
      |      "nominalValue": 1,
      |      "marketValue": 0.1,
      |      "qualifyAsTreasuryShares": "T",
      |      "maxPricePaid": 999999999.9,
      |      "minPricePaid": 999999999.9,
      |      "originalChargingPoint": "2026-03-14",
      |      "considerationActual": 1,
      |      "isConnectedPartiesTransactions": "T",
      |      "companyName": "Test Company Ltd",
      |      "companyRegistrationNumber": "ABCDEFGH",
      |      "reliefClaimedName": "S42",
      |      "reliefPercentage": 20
      |    },
      |    "contingentDetails": [
      |      {
      |        "provisionalId": "1",
      |        "provisionalDate": "2026-03-14",
      |        "actualDate": "2026-03-14",
      |        "isAmountUnasertainable": "T",
      |        "unascertainableAmount": 1000,
      |        "ascertainableAmount": 999999999999.99,
      |        "unascertainableAmountActual": 1000,
      |        "ascertainableAmountActual": 999999999999.99,
      |        "defermentOfPayment": "T",
      |        "originalDefermentDate": "2026-03-14"
      |      }
      |    ],
      |    "mainSellerDetails": {
      |      "sellerName": "Main Seller",
      |      "addr1": "1 Test Street",
      |      "addr2": "Test Area",
      |      "addr3": "Test City",
      |      "addr4": "Test Region",
      |      "postcode": "TE1 1ST",
      |      "country": "United Kingdom"
      |    },
      |    "otherSellers": [
      |      { "sellerName": "Other Seller 1" }
      |    ],
      |    "mainBuyerDetails": {
      |      "buyerName": "Main Buyer",
      |      "addr1": "2 Test Street",
      |      "addr2": "Test Area",
      |      "addr3": "Test City",
      |      "addr4": "Test Region",
      |      "postcode": "TE2 2ST",
      |      "country": "United Kingdom",
      |      "email": "buyer@example.com",
      |      "uniqueId": "UID001",
      |      "taxRate": 1,
      |      "isPLC": "T"
      |    },
      |    "otherBuyers": [
      |      { "buyerName": "Other Buyer 1" }
      |    ],
      |    "agentDetails": {
      |      "name": "Test Agent",
      |      "addr1": "3 Agent Street",
      |      "addr2": "Agent Area",
      |      "addr3": "Agent City",
      |      "addr4": "Agent Region",
      |      "postcode": "AG1 1NT",
      |      "country": "United Kingdom",
      |      "phone": "01234567890",
      |      "email": "agent@example.com",
      |      "clientReference": "REF001"
      |    },
      |    "declaration": {
      |      "role1": "1",
      |      "role2": "Director",
      |      "name": "Declarant Name",
      |      "addr1": "4 Dec Street",
      |      "addr2": "Dec Area",
      |      "addr3": "Dec City",
      |      "addr4": "Dec Region",
      |      "postcode": "DC1 1AR",
      |      "country": "United Kingdom",
      |      "selfDeclarationAgent": "T",
      |      "isCorrectInfo": "T"
      |    }
      |  }
      |}
      |""".stripMargin

  val errorResponse422: String =
    """
      |{
      |  "errors": {
      |    "processingDate": "2001-12-17T09:30:47Z",
      |    "code": "005",
      |    "text": "UTRN not found"
      |  }
      |}
      |""".stripMargin
}
