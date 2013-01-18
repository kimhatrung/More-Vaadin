package org.vaadin.example;

import java.util.Random;

import org.vaadin.wiki.cc.container.SimpleComponentContainer;
import org.vaadin.wiki.cc.delayed.CapsLockWarningWithRpc;
import org.vaadin.wiki.cc.dynupdate.Addition;
import org.vaadin.wiki.cc.gflot.LinePlot;
import org.vaadin.wiki.cc.gwt.EndlessScrollList;
import org.vaadin.wiki.cc.gwt.GwtCellListShowcase;
import org.vaadin.wiki.cc.scss.MyPicker;
import org.vaadin.wiki.cc.scss.MyPicker2;
import org.vaadin.wiki.cc.scss.MyPicker3;
import org.vaadin.wiki.cc.simple.SimpleComponent;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Theme("mytheme")
public class ExampleUI extends UI {
	
	private static final Random RANDOM_GENERATOR = new Random();
	
	//
	
	private TabSheet tabs;
	
	public ExampleUI() {
	}
	
	@Override
	public void init(final VaadinRequest request) {
		// register extension for password field
		addExtension(new CapsLockWarningWithRpc());
		
		final TabSheet tabs = new TabSheet();
		setContent(tabs);
		tabs.addTab(initHello(), "Hello");
		tabs.addTab(initSimple(), "Simple");
		tabs.addTab(initGFlot(), "GFlot");
		tabs.addTab(initContainer(), "Container");
		tabs.addTab(initScss(), "Scss");
		tabs.addTab(initGWT1(), "GWT1");
		tabs.addTab(initGWT2(), "GWT2");
	}
	
	private Component initHello() {
		final Layout layout = new VerticalLayout();
		
		final Label l1 = new Label("Hello World!");
		layout.addComponent(l1);
				
		return layout;
	}

	private Component initSimple() {
		final Layout layout = new VerticalLayout();
		
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
		
		return layout;
	}
	
	private Component initScss() {
		final Layout layout = new VerticalLayout();
		
		// scss/css example
		final MyPicker picker = new MyPicker();
		// make it smaller to see the effects of scss
		picker.setWidth(110, Unit.PIXELS);
		picker.setCaption("scss/css example");
		layout.addComponent(picker);
		
		// scss/css example with variable button text
		final MyPicker2 picker2 = new MyPicker2();
		// make it smaller to see the effects of scss
		picker2.setWidth(110, Unit.PIXELS);
		picker2.setCaption("scss/css example with variable button text");
		picker2.setButtonText("more text ...");
		layout.addComponent(picker2);
		
		// scss/css example with complex layout
		final MyPicker3 picker3 = new MyPicker3();
		// make it smaller to see the effects of scss
		picker3.setWidth(110, Unit.PIXELS);
		picker3.setCaption("scss/css example with complex layout");
		picker3.setButtonText("more text ...");
		picker3.setText("Dynamic text also in the text field");
		layout.addComponent(picker3);
				
		return layout;
	}

	private Component initGFlot() {
		final Layout layout = new VerticalLayout();
		
		// GFlot external GWT library example
		final LinePlot plot = new LinePlot();
		layout.addComponent(plot);
		plot.setHeight(100, Unit.PIXELS);
		plot.setWidth(100, Unit.PIXELS);
		plot.setCaption("GFlot external GWT library example");
		plot.addSeries("1. Serie", "red", new Float[] { 0.0f, 1.0f, 2.0f, 4.0f, 8.0f});
		plot.addSeries("2. Serie", "blue", new Float[] { 0.0f, 1.0f, 2.0f, 3.0f, 4.0f});
				
		return layout;
	}

	private Component initContainer() {
		final Layout layout = new VerticalLayout();
		
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
		
		return layout;
	}

	private Component initGWT1() {
		final Layout layout = new VerticalLayout();
		
		// GWT cell list example
		final GwtCellListShowcase contacts = new GwtCellListShowcase();
		contacts.setCaption("GWT cell list example");
		// Restrict height to enable scrolling
		// contacts.setHeight(300, Unit.PIXELS);
		layout.addComponent(contacts);
				
		return layout;
	}

	private Component initGWT2() {
		final Layout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.setHeight(600, Unit.PIXELS);
		
		final EndlessScrollList esl = new EndlessScrollList(new IndexedContainer());
		esl.setCaption("EndlessScrollList (vaadinzied GWT cell list)");
		// do this with css/scss
		// esl.setHeight(400, Unit.PIXELS);
		layout.addComponent(esl);
		
		return layout;
	}

}
