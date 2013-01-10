package org.vaadin.wiki.cc.simple;

import org.vaadin.wiki.cc.simple.shared.SimpleComponentState;

import com.vaadin.ui.AbstractComponent;

public class SimpleComponent extends AbstractComponent {

	@Override
	public SimpleComponentState getState() {
		return (SimpleComponentState) super.getState();
	}

	public void setText(String text) {
		getState().text = text;
	}

	public String getText() {
		return getState().text;
	}

}
