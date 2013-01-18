package org.vaadin.wiki.cc.gwt.shared;

import java.util.Map;

import com.vaadin.shared.AbstractComponentState;

public class ScrollListState extends AbstractComponentState {
	
    {
        primaryStyleName = "v-endlessscrolllist";
    }
    
	public int chuckSize;
	
	public Map<Integer,Object> items;

}
