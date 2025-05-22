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

object SubscriptionView {

  def successResponse(stsReference: String) =
    s"""
      |{
      |  "success": {
      |    "stsSubscriptionDetails": {
      |      "stsReference": $stsReference,
      |      "gbUser": true,
      |      "primaryContact": {
      |        "email": "davidbeckham@hmrc.gov.uk",
      |        "individual": {
      |          "firstName": "David",
      |          "lastName": "Beckham",
      |          "middleName": "Robert Joseph"
      |        },
      |        "mobile": 7896543333,
      |        "phone": "0202731454"
      |      }
      |    },
      |    "processingDate": "2024-01-25T09:26:17Z"
      |  }
      |}
      |""".stripMargin
}
