package org.vaadin.wiki.cc.scss.shared;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class MyPickerState extends AbstractComponentState {
	
	@DelegateToWidget("setButtonText")
	public String customButtonText;

}
