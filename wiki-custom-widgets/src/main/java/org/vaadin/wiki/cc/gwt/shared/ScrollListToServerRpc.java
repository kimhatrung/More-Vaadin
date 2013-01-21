package org.vaadin.wiki.cc.gwt.shared;

import com.vaadin.shared.communication.ServerRpc;

public interface ScrollListToServerRpc extends ServerRpc {
	
	void after(int startIndex, int minSize);

}
