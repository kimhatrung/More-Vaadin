package org.vaadin.example;

import org.vaadin.wiki.cc.delayed.CapsLockWarningWithRpc;
import org.vaadin.wiki.cc.dynupdate.Addition;
import org.vaadin.wiki.cc.simple.SimpleComponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExampleUI extends UI {
	
	@Override
	public void init(final VaadinRequest request) {
		// register extension for password field
		addExtension(new CapsLockWarningWithRpc());
		
		final VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		final Label l1 = new Label("Hello World!");
		layout.addComponent(l1);
		
		// simple component example
		final SimpleComponent sc = new SimpleComponent();
		sc.setText("custom widget: click here for caps lock warning");
		layout.addComponent(sc);
		
		// password extension example (delayed, caps lock warning)
		final PasswordField f1 = new PasswordField("secret:");
		layout.addComponent(f1);
		
		// dynamically update example (Addition)
		final Addition add = new Addition();
		add.setTerm1(10);
		add.setTerm1(22);
		layout.addComponent(add);
	}
}
