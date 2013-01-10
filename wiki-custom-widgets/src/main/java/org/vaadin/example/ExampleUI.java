package org.vaadin.example;

import org.vaadin.wiki.cc.delayed.CapsLockWarningWithRpc;
import org.vaadin.wiki.cc.dynupdate.Addition;
import org.vaadin.wiki.cc.gflot.LinePlot;
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
		final Label l2 = new Label("simple component example");
		layout.addComponent(l2);
		final SimpleComponent sc = new SimpleComponent();
		sc.setText("custom widget: click here for caps lock warning");
		layout.addComponent(sc);
		
		// password extension example (delayed, caps lock warning)
		final Label l3 = new Label("password extension example");
		layout.addComponent(l3);
		final PasswordField f1 = new PasswordField("secret:");
		layout.addComponent(f1);
		
		// dynamically update example (Addition)
		final Label l4 = new Label("dynamically update example");
		layout.addComponent(l4);
		final Addition add = new Addition();
		add.setTerm1(10);
		add.setTerm1(22);
		layout.addComponent(add);
		
		// GFlot external GWT library example
		final LinePlot plot = new LinePlot();
		plot.setHeight(100, Unit.PIXELS);
		plot.setWidth(100, Unit.PIXELS);
		plot.setCaption("GFlot external GWT library example");
		plot.addSeries("1. Serie", "red", new Float[] { 0.0f, 1.0f, 2.0f, 4.0f, 8.0f});
		plot.addSeries("2. Serie", "blue", new Float[] { 0.0f, 1.0f, 2.0f, 3.0f, 4.0f});
		layout.addComponent(plot);
	}
}
