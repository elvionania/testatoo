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
package org.testatoo.core.component.list

import org.testatoo.core.component.Component
import org.testatoo.core.property.Items
import org.testatoo.core.property.Size
import org.testatoo.core.state.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class ListView extends Component {

    ListView() {
        support Size, {
            Component c -> c.evaluator.getInt("\$('#${id}').find('li').length")
        }
        support Items, {
            Component c -> c.evaluator.getMetaInfo("\$('#${id}').find('li')").collect { it as Item }
        }
        support Enabled, Disabled, Available, Missing, Hidden, Visible
    }

    List<Item> getItems() {
        this.evaluator.getMetaInfo("\$('#${id}').find('li')").collect { it as Item }
    }
}
