/**
 * Copyright (C) 2008 Ovea <dev@ovea.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.core.component.datagrid

import org.testatoo.core.component.Component
import org.testatoo.core.property.Size
import org.testatoo.core.property.Title
import org.testatoo.core.state.Available
import org.testatoo.core.state.Hidden
import org.testatoo.core.state.Missing
import org.testatoo.core.state.Visible

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Column extends Component {

    Column() {
        support Size, {
            int index = evaluator.getInt("\$('#${id}').index()") + 1
            evaluator.getInt("\$('#${id}').closest('table').find('tbody tr').find('td:nth-child(${index})').length")
        }
        support Title, {
            evaluator.getString("\$('#${id}').text()")
        }
        support Available, Missing, Hidden, Visible
    }

    List<Cell> getCells() {
        int index = evaluator.getInt("\$('#${id}').index()") + 1
        this.evaluator.getMetaInfo("\$('#${id}').closest('table').find('tbody tr').find('td:nth-child(${index})')").collect { it as Cell }
    }

}
