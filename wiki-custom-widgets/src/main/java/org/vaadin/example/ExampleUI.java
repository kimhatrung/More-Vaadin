package org.vaadin.example;

import org.vaadin.wiki.cc.simple.SimpleComponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExampleUI extends UI {
	
	@Override
	public void init(final VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		// simple component example
		final SimpleComponent sc = new SimpleComponent();
		layout.addComponent(sc);
	}
}
