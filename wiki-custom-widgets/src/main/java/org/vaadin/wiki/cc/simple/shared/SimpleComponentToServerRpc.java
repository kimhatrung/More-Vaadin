package org.vaadin.wiki.cc.simple.shared;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface SimpleComponentToServerRpc extends ServerRpc {
	
	void clicked(MouseEventDetails mouseDetails);

}
