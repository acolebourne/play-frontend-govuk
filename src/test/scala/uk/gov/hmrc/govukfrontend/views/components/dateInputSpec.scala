/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.govukfrontend.views.components

import play.api.libs.functional.syntax._
import play.api.libs.json._
import play.twirl.api.Html
import uk.gov.hmrc.govukfrontend.views.html.components._

class dateInputSpec
    extends RenderHtmlSpec(
      Seq(
//        "date-input-default",
//        "date-input-with-autocomplete-values",
//        "date-input-with-default-items",
//        "date-input-with-error-on-day-input",
//        "date-input-with-error-on-month-input",
//        "date-input-with-error-on-year-input",
        "date-input-with-errors"
//        "date-input-with-input-attributes",
//        "date-input-with-optional-form-group-classes"
      )
    ) {
  override implicit val reads: Reads[Html] = (
    (__ \ "id").readNullable[String] and
      (__ \ "namePrefix").readNullable[String] and
      (__ \ "items").readWithDefault[Seq[InputParams]](Nil) and
      (__ \ "hint").readNullable[HintParams] and
      (__ \ "errorMessage").readNullable[ErrorMessageParams] and
      (__ \ "formGroup").readNullable[FormGroup].map(_.map(formGroup => formGroup.classes).getOrElse("")) and
      (__ \ "fieldset").readNullable[FieldsetParams] and
      (__ \ "classes").readWithDefault[String]("") and
      (__ \ "attributes").readWithDefault[Map[String, String]](Map.empty)
  )(DateInput.apply _)
}
