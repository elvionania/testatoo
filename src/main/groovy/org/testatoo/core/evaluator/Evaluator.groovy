/**
 * Copyright (C) 2014 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.core.evaluator

import org.testatoo.core.MetaInfo
import org.testatoo.core.action.Action
import org.testatoo.core.action.Unselect
import org.testatoo.core.component.Component
import org.testatoo.core.property.Property
import org.testatoo.core.state.State

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
public interface Evaluator extends AutoCloseable {

    static enum MouseButton { LEFT, RIGHT }
    static enum MouseClick { SINGLE, DOUBLE }

    Object getImplementation()

    void open(String url)

    void  runScript(String script)

    void registerScripts(String... scripts)

    String getString(String jQueryExpr)

    String getProperty(Property property, Component component)

    String getState(State state, Component component)

    void runAction(Action action, Component component)

    String getTitle()

    String getPageSource()

    String getUrl()

    void to(String url)

    void back()

    void forward()

    void refresh()

    public <T> T getJson(String jQueryExpr)

    List<MetaInfo> getMetaInfo(String jQueryExpr)

    void enter(Collection<?> keys)

    void click(String id, MouseButton button, MouseClick click, Collection<?> keys)
    void click(String id, MouseButton button, MouseClick click)
    void click(String id, MouseButton button)
    void click(String id)

    void mouseOver(String id)

    void dragAndDrop(String originId, String targetId)
}
