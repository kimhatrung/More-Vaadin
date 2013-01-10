package org.vaadin.wiki.cc.simple;

import org.vaadin.wiki.cc.simple.shared.SimpleComponentServerRpc;
import org.vaadin.wiki.cc.simple.shared.SimpleComponentState;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;

public class SimpleComponent extends AbstractComponent {
	
	private int clickCount = 0;
	
	private SimpleComponentServerRpc rpc = new SimpleComponentServerRpc() {

		@Override
		public void clicked(MouseEventDetails mouseDetails) {
			clickCount++;
			setText("You have clicked " + clickCount + " times");
		}
	};

	public SimpleComponent() {
		registerRpc(rpc);
	}

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
