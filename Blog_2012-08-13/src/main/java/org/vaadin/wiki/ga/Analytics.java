package org.vaadin.wiki.ga;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.server.ClientConnector;
import com.vaadin.ui.UI;

@JavaScript("ga_connector.js")
public class Analytics extends AbstractJavaScriptExtension {
    public Analytics(String account) {
        pushCommand("_setAccount", account);
    }

    public void trackPageview(String name) {
        pushCommand("_trackPageview", name);
    }

    private void pushCommand(Object... commandAndArguments) {
        // Cast to Object to use Object[] commandAndArguments as the first
        // varargs argument instead of as the full varargs argument array.
        callFunction("pushCommand", (Object) commandAndArguments);
    }

    @Override
    protected Class<? extends ClientConnector> getSupportedParentType() {
        return UI.class;
    }
}