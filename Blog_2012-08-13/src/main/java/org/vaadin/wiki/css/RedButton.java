package org.vaadin.wiki.css;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.NativeButton;

@StyleSheet("redbutton.css")
public class RedButton extends NativeButton {
    public RedButton(String caption) {
        super(caption);
        addStyleName("redButton");
    }
}