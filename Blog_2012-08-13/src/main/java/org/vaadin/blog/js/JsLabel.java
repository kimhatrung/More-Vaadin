package org.vaadin.blog.js;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "js_label.js" })
public class JsLabel extends AbstractJavaScriptComponent {

    public JsLabel(final String xhtml) {
        getState().xhtml = xhtml;
    }

    @Override
    protected JsLabelState getState() {
        return (JsLabelState) super.getState();
    }
}
