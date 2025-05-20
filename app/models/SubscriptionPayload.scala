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

package models

import play.api.libs.json.*

import play.api.libs.json.{JsString, JsValue, Json, OFormat, Writes}

import java.time.format.DateTimeFormatter
import java.util.Date

object SubscriptionPayload {


  case class Payload(
                      registerWithIDRequest: RegisterWithIDRequest)

  case class RegisterWithIDRequest(requestCommon: RequestCommon, requestDetail: RequestDetail)

  case class RequestCommon(
                            acknowledgementReference: String,
                            receiptDate: Date,
                            regime: String,
                            requestParameters: List[RequestParameter]
                          )

  case class RequestParameter(paramName: String, paramValue: String)

  case class RequestDetail(
                            IDNumber: Int,
                            IDType: String,
                            individual: Individual,
                            isAnAgent: Boolean,
                            requiresNameMatch: Boolean
                          )

  case class Individual(
                         dateOfBirth: Date,
                         firstName: String,
                         lastName: String,
                         middleName: String
                       )

  given dateWrites: Writes[Date] with
    def writes(d: Date): JsValue =
      JsString(DateTimeFormatter.ISO_INSTANT.format(d.toInstant))

  object Payload:
    given OFormat[RequestParameter] = Json.format[RequestParameter]

    given OFormat[Individual] = Json.format[Individual]

    given OFormat[RequestDetail] = Json.format[RequestDetail]

    given OFormat[RequestCommon] = Json.format[RequestCommon]

    given OFormat[RegisterWithIDRequest] = Json.format[RegisterWithIDRequest]

    given OFormat[Payload] = Json.format[Payload]

    def apply(
               acknowledgementReference: String,
               receiptDate: Date,
               regime: String,
               requestParameters: List[RequestParameter],
               IDNumber: Int,
               IDType: String,
               individual: Individual,
               isAnAgent: Boolean,
               requiresNameMatch: Boolean
             ): Payload =
      val common = RequestCommon(acknowledgementReference, receiptDate, regime, requestParameters)
      val detail = RequestDetail(IDNumber, IDType, individual, isAnAgent, requiresNameMatch)
      val request = RegisterWithIDRequest(common, detail)
      new Payload(request)
}