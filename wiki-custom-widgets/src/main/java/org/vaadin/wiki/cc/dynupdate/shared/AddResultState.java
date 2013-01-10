package org.vaadin.wiki.cc.dynupdate.shared;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;

public class AddResultState extends AbstractComponentState {
	
	@DelegateToWidget("setSum")
	public int sum;

}
