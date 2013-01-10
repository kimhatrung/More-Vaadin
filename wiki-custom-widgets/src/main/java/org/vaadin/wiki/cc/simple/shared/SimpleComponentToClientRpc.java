package org.vaadin.wiki.cc.simple.shared;

import com.vaadin.shared.communication.ClientRpc;

public interface SimpleComponentToClientRpc extends ClientRpc {
	
	void alert(String message);

}
