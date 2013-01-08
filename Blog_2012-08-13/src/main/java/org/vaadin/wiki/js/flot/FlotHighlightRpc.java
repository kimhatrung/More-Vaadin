package org.vaadin.wiki.js.flot;

import com.vaadin.shared.communication.ClientRpc;

public interface FlotHighlightRpc extends ClientRpc {
	
    void highlight(int seriesIndex, int dataIndex);
    
}
