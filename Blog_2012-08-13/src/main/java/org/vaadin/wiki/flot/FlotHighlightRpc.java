package org.vaadin.wiki.flot;

import com.vaadin.shared.communication.ClientRpc;

public interface FlotHighlightRpc extends ClientRpc {
	
    void highlight(int seriesIndex, int dataIndex);
    
}
