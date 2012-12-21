package org.vaadin.example;

import org.vaadin.blog.JsLabel;
import org.vaadin.wiki.flot.JsFlot;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExampleUI extends UI {
	@Override
	public void init(final VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		layout.addComponent(new JsLabel("Hello World!"));
		final JsFlot flot = new JsFlot();

		// this is always needed
		flot.setHeight(100, Unit.PIXELS);
		flot.setWidth(100, Unit.PIXELS);

		flot.addSeries(0.0, 0.0, 1.0, 1.0, 2.0, 3.0);

		layout.addComponent(flot);
	}
}