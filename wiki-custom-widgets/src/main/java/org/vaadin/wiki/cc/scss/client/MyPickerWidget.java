package org.vaadin.wiki.cc.scss.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;

public class MyPickerWidget extends ComplexPanel {

	public static final String CLASSNAME = "mypicker";

	private final TextBox textBox = new TextBox();
	private final PushButton button = new PushButton("...");

	public MyPickerWidget() {
		setElement(Document.get().createDivElement());
		setStylePrimaryName(CLASSNAME);

		textBox.setStylePrimaryName(CLASSNAME + "-field");
		button.setStylePrimaryName(CLASSNAME + "-button");

		add(textBox, getElement());
		add(button, getElement());

		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Calendar picker not yet supported!");
			}
		});
	}
}
