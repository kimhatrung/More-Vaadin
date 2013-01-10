package org.vaadin.wiki.cc.scss;

import org.vaadin.wiki.cc.scss.shared.MyPickerState;

import com.vaadin.ui.AbstractComponent;

public class MyPicker3 extends AbstractComponent {

	@Override
	public MyPickerState getState() {
		return (MyPickerState) super.getState();
	}

	public void setButtonText(String text) {
		getState().customButtonText = text;
	}

	public void setText(String text) {
		getState().customText = text;
	}

}
