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

package models.subscriptionAmend

import play.api.libs.json.{Json, OFormat}

case class IndividualContact(
                              firstName: String,
                              lastName: String,
                              middleName: Option[String]
                            )

object IndividualContact {
  implicit val format: OFormat[IndividualContact] = Json.format[IndividualContact]
}

case class OrganisationContact(name: String)

object OrganisationContact {
  implicit val format: OFormat[OrganisationContact] = Json.format[OrganisationContact]
}

case class PrimaryContact(
                           email: String,
                           mobile: String,
                           phone: String,
                           individual: Option[IndividualContact] = None,
                           organisation: Option[OrganisationContact] = None
                         )

object PrimaryContact {
  implicit val format: OFormat[PrimaryContact] = Json.format[PrimaryContact]
}

case class Request(
                    gbUser: Boolean,
                    idNumber: String,
                    idType: String,
                    primaryContact: PrimaryContact
                  )

object Request {
  implicit val format: OFormat[Request] = Json.format[Request]
}

case class Payload(request: Request)
object Payload {
  implicit val format: OFormat[Payload] = Json.format[Payload]
}
