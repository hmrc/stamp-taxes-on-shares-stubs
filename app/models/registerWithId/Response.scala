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

object Response {
  case class ResponseCommon(
    processingDate: String,
    status: String,
    statusText: Option[String]
  )

  object ResponseCommon {
    implicit val format: OFormat[ResponseCommon] = Json.format[ResponseCommon]
  }

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

  case class ContactDetails(
    emailAddress: Option[String],
    faxNumber: Option[String],
    mobileNumber: Option[String],
    phoneNumber: Option[String]
  )

  object ContactDetails {
    implicit val format: OFormat[ContactDetails] = Json.format[ContactDetails]
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
    organisationType: Option[String],
    isAGroup: Option[Boolean]
  )

  object Organisation {
    implicit val format: OFormat[Organisation] = Json.format[Organisation]
  }

  case class ResponseDetail(
    ARN: Option[String],
    SAFEID: Option[String],
    address: Option[Address],
    contactDetails: Option[ContactDetails],
    individual: Option[Individual],
    organisation: Option[Organisation],
    isAnASAgent: Option[Boolean],
    isAnAgent: Option[Boolean],
    isAnIndividual: Option[Boolean],
    isEditable: Option[Boolean]
  )

  object ResponseDetail {
    implicit val format: OFormat[ResponseDetail] = Json.format[ResponseDetail]
  }

  case class RegisterWithIDResponse(
    responseCommon: ResponseCommon,
    responseDetail: Option[ResponseDetail]
  )

  object RegisterWithIDResponse {
    implicit val format: OFormat[RegisterWithIDResponse] = Json.format[RegisterWithIDResponse]
  }
  
}