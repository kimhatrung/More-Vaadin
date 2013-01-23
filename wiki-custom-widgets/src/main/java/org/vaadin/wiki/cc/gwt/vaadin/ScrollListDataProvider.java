package org.vaadin.wiki.cc.gwt.vaadin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vaadin.wiki.cc.gwt.shared.ContactInfo;
import org.vaadin.wiki.cc.gwt.shared.ScrollListState;
import org.vaadin.wiki.cc.gwt.shared.ScrollListToServerRpc;

import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.vaadin.client.communication.StateChangeEvent;

public class ScrollListDataProvider<T> extends AbstractDataProvider<T> {

	private final ScrollListState state;

	private final ScrollListToServerRpc rpc;

	private final List<HasData<T>> changedDisplays = new ArrayList<HasData<T>>();
	
	private int start = -1;
	
	private int len = 0;

	public ScrollListDataProvider(ScrollListState state, ScrollListToServerRpc rpc) {
		assert state != null;
		this.state = state;
		assert rpc != null;
		this.rpc = rpc;
	}

	@Override
	protected void onRangeChanged(HasData<T> display) {
		final Range range = display.getVisibleRange();
		final Map<Integer, ContactInfo> items = state.items;
		int idx = 0;
		if (items != null) {
			for (int i = 0; i < range.getLength(); ++i) {
				idx = i + range.getStart();
				if (!items.containsKey(idx)) {
					break;
				}
			}
		}
		synchronized (changedDisplays) {
			changedDisplays.add(display);
			start = idx;
			len = display.getVisibleItemCount();
		}
		rpc.after(start, len);
	}

	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		final List<HasData<T>> changed;
		int start, len;
		synchronized (changedDisplays) {
			changed = new ArrayList<HasData<T>>(changedDisplays);
			start = this.start;
			len = this.len;
			this.start = -1;
			this.len = 0;
		}
		changed.retainAll(getDataDisplays());
		if (!changed.isEmpty()) {
			final Map<Integer, ContactInfo> items = state.items;
			if (items != null) {
				final List<T> list = new ArrayList<T>(len);
				for (int i = 0; i < len; ++i) {
					final int idx = i + start;
					// list.set(idx, (T) items.get(idx));
					list.add((T) items.get(idx));
				}
				for (HasData<T> display : changed) {
					updateRowData(display, start, list);
				}
			}
		}
	}

}
