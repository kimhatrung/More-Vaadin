package org.vaadin.wiki.js.flot;

import com.vaadin.shared.communication.ServerRpc;

public interface FlotClickRpc extends ServerRpc {
	
    void onPlotClick(int seriesIndex, int dataIndex);
    
}
