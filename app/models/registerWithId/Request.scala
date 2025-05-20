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

package models.registerWithId

import play.api.libs.json.{Json, OFormat}

case class RequestParameter(paramName: String, paramValue: String)

object RequestParameter {
  implicit val format: OFormat[RequestParameter] = Json.format[RequestParameter]
}

case class RequestCommon(
  acknowledgementReference: String,
  receiptDate: String,
  regime: String,
  requestParameters: Seq[RequestParameter]
)

object RequestCommon {
  implicit val format: OFormat[RequestCommon] = Json.format[RequestCommon]
}

case class Individual(
  dateOfBirth: String,
  firstName: String,
  lastName: String,
  middleName: Option[String]
)

object Individual {
  implicit val format: OFormat[Individual] = Json.format[Individual]
}

case class Organisation(
  organisationName: String,
  organisationType: String
)

object Organisation {
  implicit val format: OFormat[Organisation] = Json.format[Organisation]
}

case class RequestDetail(
  IDNumber: String,
  IDType: String,
  individual: Option[Individual],
  organisation: Option[Organisation],
  isAnAgent: Boolean,
  requiresNameMatch: Boolean
)

object RequestDetail {
  implicit val format: OFormat[RequestDetail] = Json.format[RequestDetail]
}

case class RegisterWithIDRequest(
  requestCommon: RequestCommon,
  requestDetail: RequestDetail
)

object RegisterWithIDRequest {
  implicit val format: OFormat[RegisterWithIDRequest] = Json.format[RegisterWithIDRequest]
}

case class Payload(registerWithIDRequest: RegisterWithIDRequest)
object Payload {
  implicit val format: OFormat[Payload] = Json.format[Payload]
}
