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

object TransactionCreate {

  val successResponse: String =
    """
      |{
      |  "success": {
      |    "processingDate": "2001-12-17T09:30:47Z",
      |    "charges": [
      |      {
      |        "recordId": 1,
      |        "utrn": "900459020010",
      |        "chargeTypeDescription": "Charge Type Description",
      |        "chargeReference": "XA001234567890",
      |        "chargeType": "STC",
      |        "chargeAmount": 0,
      |        "chargeDueDate": "2026-03-14"
      |      }
      |    ]
      |  }
      |}
      |""".stripMargin

  val errorResponse422: String =
    """
      |{
      |  "errors": {
      |    "processingDate": "2001-12-17T09:30:47Z",
      |    "code": "002",
      |    "text": "STC ID does not exist"
      |  }
      |}
      |""".stripMargin
}
