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

package controllers

import javax.inject.*
import play.api.*
import play.api.mvc.*
import play.api.libs.json.*

@Singleton
class TransactionController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /** POST /RESTAdapter/stc/transaction/:stcId
   *  STCTransactionCreate - EPID1684
   */
  def create(stcId: String): Action[AnyContent] = Action { request =>
    val correlationId = request.headers.get("correlationid").getOrElse("unknown")
    Created(Json.parse(responses.TransactionCreate.successResponse))
      .withHeaders("correlationid" -> correlationId)
  }

  /** GET /RESTAdapter/stc/transaction/:stcId/:utrn
   *  STCTransactionView - EPID1686
   */
  def view(stcId: String, utrn: String): Action[AnyContent] = Action { request =>
    val correlationId = request.headers.get("correlationid").getOrElse("unknown")
    Ok(Json.parse(responses.TransactionView.successResponse(stcId, utrn)))
      .withHeaders("correlationid" -> correlationId)
  }

  /** PUT /RESTAdapter/stc/transaction/:stcId/:utrn
   *  STCTransactionAmend - EPID1685
   */
  def amend(stcId: String, utrn: String): Action[AnyContent] = Action { request =>
    val correlationId = request.headers.get("correlationid").getOrElse("unknown")
    Ok(Json.parse(responses.TransactionAmend.successResponse))
      .withHeaders("correlationid" -> correlationId)
  }
}
