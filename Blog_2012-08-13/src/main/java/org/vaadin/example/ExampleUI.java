package org.vaadin.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.vaadin.blog.js.JsLabel;
import org.vaadin.wiki.css.RedButton;
import org.vaadin.wiki.js.flot.JsFlot;
import org.vaadin.wiki.js.flot.JsFlot2;
import org.vaadin.wiki.js.ga.Analytics;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class ExampleUI extends UI {
	
	private Analytics googleAnalytics;
	
	@Override
	public void init(final VaadinRequest request) {
		googleAnalytics = new Analytics("test");
		googleAnalytics.trackPageview("home");
		addExtension(googleAnalytics);
		
		// https://vaadin.com/wiki/-/wiki/Main/Exposing%20server%20side%20API%20to%20JavaScript
		JavaScript.getCurrent().addFunction("notify", new JavaScriptFunction() {
            public void call(JSONArray arguments) throws JSONException {
                Notification.show(arguments.getString(0));
            }
        });
		JavaScript.getCurrent().addFunction("com.example.api.notify",
				new JavaScriptFunction() {
					public void call(JSONArray arguments) throws JSONException {
						try {
							String caption = arguments.getString(0);
							if (arguments.length() == 1) {
								// only caption
								Notification.show(caption);
							}
							else {
								// type should be in [1]
								Notification.show(caption,
										Notification.Type.values()[arguments.getInt(1)]);
							}
						}
						catch (JSONException e) {
							// We'll log in the console, you might not want to
							JavaScript.getCurrent().execute(
									"console.error('" + e.getMessage() + "')");
						}
					}
				});
		
		// JsFlot example

		final VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		layout.addComponent(new JsLabel("Hello World!"));
		final JsFlot flot = new JsFlot();

		// this is always needed
		flot.setHeight(100, Unit.PIXELS);
		flot.setWidth(100, Unit.PIXELS);

		flot.addSeries(0.0, 0.0, 1.0, 1.0, 2.0, 3.0);

		layout.addComponent(flot);
		
		// JsFlot2 example
		
        final JsFlot2 jsFlot2 = new JsFlot2();
        jsFlot2.setHeight("300px");
        jsFlot2.setWidth("400px");

        jsFlot2.addSeries(1, 2, 4, 8, 16);
        layout.addComponent(jsFlot2);

        layout.addComponent(new Button("Highlight point", new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                jsFlot2.highlight(0, 3);
            }
        }));
		
		// red button example
		
		layout.addComponent(new RedButton("css styled"));
		
		// js call/api example
		
		layout.addComponent(new Link("Send message",
				new ExternalResource(
						"javascript:(function(){com.example.api.notify(prompt('Message'),2);})();"
				)
		));
	}
}
