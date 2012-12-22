package org.vaadin.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.vaadin.blog.JsLabel;
import org.vaadin.wiki.css.RedButton;
import org.vaadin.wiki.flot.JsFlot;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ExampleUI extends UI {
	@Override
	public void init(final VaadinRequest request) {
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

		final VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		layout.addComponent(new JsLabel("Hello World!"));
		final JsFlot flot = new JsFlot();

		// this is always needed
		flot.setHeight(100, Unit.PIXELS);
		flot.setWidth(100, Unit.PIXELS);

		flot.addSeries(0.0, 0.0, 1.0, 1.0, 2.0, 3.0);

		layout.addComponent(flot);
		
		layout.addComponent(new RedButton("css styled"));
		
		layout.addComponent(new Link("Send message",
				new ExternalResource(
						"javascript:(function(){com.example.api.notify(prompt('Message'),2);})();"
				)
		));
	}
}
