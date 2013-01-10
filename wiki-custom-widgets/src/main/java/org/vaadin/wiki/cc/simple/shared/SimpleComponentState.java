package org.vaadin.wiki.cc.simple.shared;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class SimpleComponentState extends AbstractComponentState {

	@DelegateToWidget("setText")
	public String text;

}
