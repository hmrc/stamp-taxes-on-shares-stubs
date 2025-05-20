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

package models.registerWithoutId

import play.api.libs.json.{Json, OFormat}

// RequestParameter
case class RequestParameter(paramName: String, paramValue: String)
object RequestParameter {
  implicit val format: OFormat[RequestParameter] = Json.format[RequestParameter]
}

// RequestCommon
case class RequestCommon(
  acknowledgementReference: String,
  receiptDate: String,
  regime: String,
  requestParameters: Seq[RequestParameter]
)
object RequestCommon {
  implicit val format: OFormat[RequestCommon] = Json.format[RequestCommon]
}

// Address
case class Address(
  addressLine1: String,
  addressLine2: Option[String],
  addressLine3: Option[String],
  addressLine4: Option[String],
  countryCode: String,
  postalCode: Option[String]
)
object Address {
  implicit val format: OFormat[Address] = Json.format[Address]
}

// ContactDetails
case class ContactDetails(
  emailAddress: Option[String],
  faxNumber: Option[String],
  mobileNumber: Option[String],
  phoneNumber: Option[String]
)
object ContactDetails {
  implicit val format: OFormat[ContactDetails] = Json.format[ContactDetails]
}

// Identification
case class Identification(
  idNumber: String,
  issuingCountryCode: String,
  issuingInstitution: String
)
object Identification {
  implicit val format: OFormat[Identification] = Json.format[Identification]
}

// Individual
case class Individual(
  dateOfBirth: String,
  firstName: String,
  lastName: String,
  middleName: Option[String]
)
object Individual {
  implicit val format: OFormat[Individual] = Json.format[Individual]
}

// Organisation
case class Organisation(organisationName: String)
object Organisation {
  implicit val format: OFormat[Organisation] = Json.format[Organisation]
}

// RequestDetail
case class RequestDetail(
  address: Address,
  contactDetails: ContactDetails,
  identification: Option[Identification],
  individual: Option[Individual],
  organisation: Option[Organisation],
  isAGroup: Boolean,
  isAnAgent: Boolean
)
object RequestDetail {
  implicit val format: OFormat[RequestDetail] = Json.format[RequestDetail]
}

// RegisterWithoutIDRequest
case class RegisterWithoutIDRequest(
  requestCommon: RequestCommon,
  requestDetail: RequestDetail
)
object RegisterWithoutIDRequest {
  implicit val format: OFormat[RegisterWithoutIDRequest] = Json.format[RegisterWithoutIDRequest]
}

// Payload
case class Payload(registerWithoutIDRequest: RegisterWithoutIDRequest)
object Payload {
  implicit val format: OFormat[Payload] = Json.format[Payload]
}


