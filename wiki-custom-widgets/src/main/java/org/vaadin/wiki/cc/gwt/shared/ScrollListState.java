package org.vaadin.wiki.cc.gwt.shared;

import java.util.Map;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.AbstractFieldState;

public class ScrollListState extends AbstractFieldState {
	
    {
        primaryStyleName = "v-endlessscrolllist";
    }
    
	public int chunkSize;
	
	public Map<Integer,ContactInfo> items;

}
