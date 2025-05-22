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

package models.SubscriptionView

object Response {

  import models.Individual
  
  import play.api.libs.json.{Json, OFormat}
  
  case class Organisation(name: String)
  
  object Organisation {
    implicit val format: OFormat[Organisation] = Json.format[Organisation]
  }
  
  case class PrimaryContact(
    email: String,
    mobile: String,
    phone: String,
    individual: Option[Individual],
    organisation: Option[Organisation]
  )
  
  object PrimaryContact {
    implicit val format: OFormat[PrimaryContact] = Json.format[PrimaryContact]
  }
  
  case class STSSubscriptionDetails(
    stsReference: String,
    gbUser: Boolean,
    primaryContact: PrimaryContact
  )
  
  object STSSubscriptionDetails {
    implicit val format: OFormat[STSSubscriptionDetails] = Json.format[STSSubscriptionDetails]
  }
  
  case class SuccessResponse(
    stsSubscriptionDetails: STSSubscriptionDetails,
    processingDate: String
  )
  
  object SuccessResponse {
    implicit val format: OFormat[SuccessResponse] = Json.format[SuccessResponse]
  }
  
  case class STSSubscriptionViewAPIResponse(
    success: SuccessResponse
  )
  
  object STSSubscriptionViewAPIResponse {
    implicit val format: OFormat[STSSubscriptionViewAPIResponse] = Json.format[STSSubscriptionViewAPIResponse]
  }
}
