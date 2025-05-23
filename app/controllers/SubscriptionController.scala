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

package controllers

import models.Payload

import javax.inject.*
import play.api.*
import play.api.mvc.*
import play.api.libs.json.*
import responses.SubscriptionResponses

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class SubscriptionController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def subscribe: Action[JsValue] = Action(parse.json) { request =>
    request.body.validate[Payload] match {
      case JsSuccess(_, _) => Ok(SubscriptionResponses.successResponse)
      case JsError(errors) =>
        errors.foreach { case (path, validationErrors) =>
          println(s"Path: $path, Errors: $validationErrors")
        }
        // Handle the error
        val errorResponse = Json.obj(
          "status" -> "error",
          "message" -> "Invalid payload"
        )
        BadRequest(errorResponse)
    }
  }

}
