package org.vaadin.example;

import org.vaadin.wiki.cc.simple.SimpleComponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExampleUI extends UI {
	
	@Override
	public void init(final VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		final Label l1 = new Label("Hello World!");
		layout.addComponent(l1);
		// simple component example
		final SimpleComponent sc = new SimpleComponent();
		sc.setText("custom widget");
		layout.addComponent(sc);
	}
}
