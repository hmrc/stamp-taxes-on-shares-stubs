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

// Leaf class for sourceFaultDetail
case class SourceFaultDetail(detail: Seq[String])
object SourceFaultDetail:
  given Format[SourceFaultDetail] = Json.format[SourceFaultDetail]

// errorDetail object
case class ErrorDetail(
                        correlationId: String,
                        errorCode: String,
                        errorMessage: String,
                        source: String,
                        sourceFaultDetail: SourceFaultDetail,
                        timestamp: String
                      )
object ErrorDetail:
  given Format[ErrorDetail] = Json.format[ErrorDetail]

// Root object
case class ErrorResponse(errorDetail: ErrorDetail)
object ErrorResponse:
  given Format[ErrorResponse] = Json.format[ErrorResponse]

