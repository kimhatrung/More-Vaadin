package org.vaadin.wiki.cc.gwt.vaadin;

import java.util.List;

import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ProvidesKey;
import com.vaadin.data.Container.Indexed;
import com.vaadin.data.Item;

public class IndexedDataProvider<T extends Item> extends AbstractDataProvider<T> {

	private Indexed container;
	
	private ProvidesKey<T> keyProvider;

	public IndexedDataProvider(Indexed container, ProvidesKey<T> keyProvider) {
		this.container = container;
	}

	@Override
	protected void onRangeChanged(HasData<T> display) {
		int size = container.size();
		if (size > 0) {
			// Do not push data if the data set is empty.
			updateRowData(display, 0, new IndexedAsUnmodifialbeList<T>(container, keyProvider));
		}
	}

}
