package org.vaadin.wiki.cc.gwt.vaadin;

import java.util.Map;

import org.vaadin.wiki.cc.gwt.shared.ScrollListState;
import org.vaadin.wiki.cc.gwt.shared.ScrollListToServerRpc;

import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;

public class ScrollListDataProvider<T> extends AbstractDataProvider<T> {

	private final ScrollListState state;

	private final ScrollListToServerRpc rpc;

	public ScrollListDataProvider(ScrollListState state, ScrollListToServerRpc rpc) {
		assert state != null;
		this.state = state;
		assert rpc != null;
		this.rpc = rpc;
	}

	@Override
	protected void onRangeChanged(HasData<T> display) {
		final Range range = display.getVisibleRange();
		final Map<Integer, Object> items = state.items;
		int idx = 0;
		if (items != null) {
			for (int i = 0; i < range.getLength(); ++i) {
				idx = i + range.getStart();
				if (!items.containsKey(idx)) {
					break;
				}
			}
		}
		rpc.after(idx, display.getVisibleItemCount());
	}

}
