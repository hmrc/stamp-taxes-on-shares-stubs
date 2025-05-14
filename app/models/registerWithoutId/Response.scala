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

import play.api.libs.json.{Format, Json}

// Leaf class for returnParameters array
case class ReturnParameter(paramName: String, paramValue: Long)
object ReturnParameter:
  given Format[ReturnParameter] = Json.format[ReturnParameter]

// responseCommon object
case class ResponseCommon(
                           processingDate: String,
                           returnParameters: Seq[ReturnParameter],
                           status: String
                         )
object ResponseCommon:
  given Format[ResponseCommon] = Json.format[ResponseCommon]

// responseDetail object
case class ResponseDetail(
                           ARN: String,
                           SAFEID: String
                         )
object ResponseDetail:
  given Format[ResponseDetail] = Json.format[ResponseDetail]

// Top-level registerWithoutIDResponse object
case class RegisterWithoutIDResponse(
                                      responseCommon: ResponseCommon,
                                      responseDetail: ResponseDetail
                                    )
object RegisterWithoutIDResponse:
  given Format[RegisterWithoutIDResponse] = Json.format[RegisterWithoutIDResponse]

// Root object
case class Root(registerWithoutIDResponse: RegisterWithoutIDResponse)
object Root:
  given Format[Root] = Json.format[Root]

