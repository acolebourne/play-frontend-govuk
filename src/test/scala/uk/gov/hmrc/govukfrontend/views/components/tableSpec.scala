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

class tableSpec extends RenderHtmlSpec("govukTable") {
  override implicit val reads: Reads[Html] = (
    (__ \ "rows").readWithDefault[Seq[Seq[TableRow]]](Nil) and
      (__ \ "head").readWithDefault[Seq[HeadCell]](Nil) and
      (__ \ "caption").readNullable[String] and
      (__ \ "captionClasses").readWithDefault[String]("") and
      (__ \ "firstCellIsHeader").readWithDefault[Boolean](false) and
      (__ \ "classes").readWithDefault[String]("") and
      (__ \ "attributes").readWithDefault[Map[String, String]](Map.empty)
  )(Table.apply _)
}