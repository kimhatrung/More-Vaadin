package org.vaadin.blog;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class ExampleRoot extends UI {
    @Override
    public void init(final VaadinRequest request) {
        addComponent(new JsLabel("Hello World!"));
    }
}
