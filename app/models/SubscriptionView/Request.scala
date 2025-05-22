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

object Request {

  import play.api.libs.json.{Json, OFormat}
  
  case class RequestCommon(
    acknowledgementReference: String,
    receiptDate: String,
    regime: String
  )
  
  object RequestCommon {
    implicit val format: OFormat[RequestCommon] = Json.format[RequestCommon]
  }
  
  case class RequestDetail(
    stsReference: String
  )
  
  object RequestDetail {
    implicit val format: OFormat[RequestDetail] = Json.format[RequestDetail]
  }
  
  case class STSSubscriptionViewAPIRequest(
    requestCommon: RequestCommon,
    requestDetail: RequestDetail
  )
  
  object STSSubscriptionViewAPIRequest {
    implicit val format: OFormat[STSSubscriptionViewAPIRequest] = Json.format[STSSubscriptionViewAPIRequest]
  }
  
  def apply(
    acknowledgementReference: String,
    receiptDate: String,
    regime: String,
    stsReference: String
  ): STSSubscriptionViewAPIRequest = {
    val common = RequestCommon(acknowledgementReference, receiptDate, regime)
    val detail = RequestDetail(stsReference)
    STSSubscriptionViewAPIRequest(common, detail)
  }
}
