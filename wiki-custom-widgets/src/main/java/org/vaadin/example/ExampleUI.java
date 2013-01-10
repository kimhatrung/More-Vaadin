package org.vaadin.example;

import java.util.Random;

import org.vaadin.wiki.cc.container.SimpleComponentContainer;
import org.vaadin.wiki.cc.delayed.CapsLockWarningWithRpc;
import org.vaadin.wiki.cc.dynupdate.Addition;
import org.vaadin.wiki.cc.gflot.LinePlot;
import org.vaadin.wiki.cc.scss.MyPicker;
import org.vaadin.wiki.cc.simple.SimpleComponent;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Theme("mytheme")
public class ExampleUI extends UI {
	
	private static final Random RANDOM_GENERATOR = new Random();
	
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
		
		// scss/css example
		final MyPicker picker = new MyPicker();
		// make it smaller to see the effects of scss
		picker.setWidth(110, Unit.PIXELS);
		picker.setCaption("scss/css example");
		layout.addComponent(picker);
		
		// simple component container example
		final SimpleComponentContainer container = new SimpleComponentContainer();
        layout.addComponent(container);
        container.addComponent(new Label(
                "Click the button to add components to the WidgetContainer."));
        Button button = new Button("Add more components", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                int random = RANDOM_GENERATOR.nextInt(3);
                final Component component;
                if (random % 3 == 0) {
                    component = new Label("A new label");
                } else if (random % 3 == 1) {
                    component = new Button("A button!");
                } else {
                    component = new CheckBox("A textfield");
                }
                container.addComponent(component);
            }
        });
        layout.addComponent(button);		
	}
}
