/*
 * Copyright 2025 HM Revenue & Customs
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


object SubscriptionCreate {

    var successResponse = """
{
  "registerWithIDResponse": {
    "responseCommon": {
      "processingDate": "2016-08-16T15:55:30Z",
      "status": "OK"
    },
    "responseDetail": {
      "ARN": "AARN8764123",
      "SAFEID": "XE0000123456789",
      "address": {
        "addressLine1": "22 livingston road",
        "addressLine2": "43",
        "addressLine3": "near A&E",
        "addressLine4": "Oxford",
        "countryCode": "GB",
        "postalCode": "OX2 3HD"
      },
      "contactDetails": {
        "emailAddress": "anr@bbc.com",
        "faxNumber": 2073648933,
        "mobileNumber": "07634527721",
        "phoneNumber": 20947376
      },
      "individual": {
        "dateOfBirth": "1980-12-12",
        "firstName": "Ron",
        "lastName": "Singleton",
        "middleName": "Madisson"
      },
      "isAnASAgent": true,
      "isAnAgent": false,
      "isAnIndividual": true,
      "isEditable": true
    }
  }      
}
"""

}
