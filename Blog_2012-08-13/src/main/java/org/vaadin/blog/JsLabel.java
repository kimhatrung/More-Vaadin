package org.vaadin.blog;

@SuppressWarnings("serial")
@com.vaadin.annotations.JavaScript({ "js_label.js" })
public class JsLabel extends com.vaadin.ui.AbstractJavaScriptComponent {

    public JsLabel(final String xhtml) {
        getState().xhtml = xhtml;
    }

    @Override
    protected JsLabelState getState() {
        return (JsLabelState) super.getState();
    }
}
