package org.testatoo

import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.testatoo.config.TestatooJunitRunner
import org.testatoo.config.TestatooModules
import org.testatoo.core.Testatoo
import org.testatoo.core.component.*

import static org.testatoo.core.Testatoo.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(TestatooJunitRunner.class)
@TestatooModules(TestModule)
class ComponentTest {

    @Delegate
    private static Testatoo testatoo = new Testatoo()

    @BeforeClass
    public static void openTestPage() {
        open('/component.html')
    }

    @Test
    public void test_button() {
        // input type=button
        Button button = $('#button') as Button
        assert button.is(enabled)
        assert button.is(visible)

        assertThat { button.has text.equalsTo('Button') }

        // input type=submit
        button = $('#submit') as Button
        assert button.has(text.equalsTo('Submit'))

        // input type=reset
        button = $('#reset') as Button
        assert button.has(text.equalsTo('Reset'))

        // button element
        button = $('#btn') as Button
        assert button.has(text.equalsTo('My Button Text'))
    }

    @Test
    public void test_input_fields() {
        TextField textField = $('#text_field') as TextField

        assert textField.is(enabled)
        assert textField.is(visible)

        assert textField.has(label.equalsTo('Text'))
        assert textField.is(empty);

        textField.enter 'some value'
        assert textField.has(text.equalsTo('some value'))
        assert textField.has(value.equalsTo('some value'))
        assert textField.is(filled);

        PasswordField passwordField = $('#password_field') as PasswordField

        assert passwordField.is(enabled)
        assert passwordField.is(visible)

        assert passwordField.has(label.equalsTo('Password'))
        assert passwordField.has(text.equalsTo('?art'))

        // Textarea
    }

    @Test
    public void test_checkbox() {
        CheckBox checkBox = $('#checkbox') as CheckBox
        assert checkBox.is(enabled)
        assert checkBox.is(visible)

        assert checkBox.is(unchecked)
        assert checkBox.has(label.containing('Check me out'))

//        checkBox.check()
//        assert checkBox.is(checked)
    }

    @Test
    public void test_link() {
        Link link = $('#link') as Link
        assert link.is(enabled)
        assert link.is(visible)

        assert link.has(text.equalsTo('Link to index'))
        assert link.has(reference.containing('/component.html'))
    }

    @Test
    public void test_panel() {
        Panel panel = $('#panel') as Panel
        assert panel.is(enabled)
        assert panel.is(visible)

        assert panel.has(title.equalsTo(''))
    }

    @Test
    public void test_list() {
        List list = $('#list_view') as List

        assert list.is(filled);



//        assert list.contains(item1, item2);

//        assert list.has(5.items);
        assert list.has(size.equalsTo(5));
        assert list.items().size == 5;


//        assert list.has(values(['Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5']))




    }

    @Test
    public void test_contains() {

    }



//    @Test
//    public void test_radio() {
//        open('/component.html');
//
//        Radio radio = new Radio('radio');
//        assertThat(radio.is(enabled()));
//        assertThat(radio.is(visible()));
//        assertThat(radio.is(checked()));
//
//        assertThat(radio.has(label()).contains('Radio label'));
//    }

//    @Test
//    public void test_page() {
//        open('/component.html');
//
//        assertThat(page().has(title()).equalsTo('Testatoo Rocks'));
//    }
//
//    @Test
//    public void test_contains() {
//        open('/component.html');
//
//        assertThat(page().contains(
//                new Button('button'),
//                new TextField('text_field'),
//                new Radio('radio')
//        ));
//
//        Panel panel = new Panel('panel');
//        assertThat(panel.contains(
//                new Button('button_in_visible_panel'),
//                new Button('invisible_button_in_visible_panel')
//        ));
//
//        Panel invisible_panel = new Panel('invisible_panel');
//        try {
//            assertThat(invisible_panel.contains(
//                    new Button('button_in_visible_panel')
//            ));
//        } catch (AssertionError e) {
//            assertEquals('Component Panel with id: \'invisible_panel\' does no contains component Button with id: \'button_in_visible_panel\'', e.getMessage());
//        }
//    }
//
//    @Test
//    public void test_displays() {
//        open('/component.html');
//
//        assertThat(page().displays(
//                new Button('button'),
//                new TextField('text_field'),
//                new Radio('radio')
//        ));
//
//        Panel panel = new Panel('panel');
//        assertThat(panel.displays(
//                new Button('button_in_visible_panel')
//        ));
//
//        try {
//            assertThat(panel.displays(
//                    new Button('button_in_visible_panel'),
//                    new Button('invisible_button_in_visible_panel')
//            ));
//        } catch (AssertionError e) {
//            assertEquals('Component Panel with id: \'panel\' does no displays component Button with id: \'invisible_button_in_visible_panel\'', e.getMessage());
//        }
//    }

//    @Test
//    public void componentType() {
//
//    }

}
