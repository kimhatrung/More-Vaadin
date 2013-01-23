package org.vaadin.wiki.cc.gwt;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.vaadin.example.Containers;
import org.vaadin.wiki.cc.gwt.shared.ContactInfo;
import org.vaadin.wiki.cc.gwt.shared.ScrollListState;
import org.vaadin.wiki.cc.gwt.shared.ScrollListToServerRpc;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ItemClickEvent.ItemClickNotifier;
import com.vaadin.event.dd.DragSource;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.server.KeyMapper;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;

public class EndlessScrollList extends AbstractSelect implements Action.Container
		, Container.Ordered, HasComponents
/* , Container.Sortable, DragSource, DropTarget, ItemClickNotifier */
{

	private final Indexed container;

	/**
	 * List of action handlers.
	 */
	private LinkedList<Handler> actionHandlers = null;

	/**
	 * Action mapper.
	 */
	private KeyMapper<Action> actionMapper = null;

	/**
	 * Set of visible components - the is used for needsRepaint calculation.
	 */
	private HashSet<Component> visibleComponents = null;

	private ScrollListToServerRpc rpc = new ScrollListToServerRpc() {

		@Override
		public void after(int startIndex, int minSize) {
			System.err.println("after(" + startIndex + ", " + minSize + ")");
			final ScrollListState state = getState();
			Map<Integer, ContactInfo> items = state.items;
			if (items == null) {
				items = new HashMap<Integer, ContactInfo>();
				state.items = items;
			}
			if (state.chunkSize <= 0) {
				if (minSize <= 0) {
					// ???
					minSize = 30;
				}
				state.chunkSize = minSize;
			}
			int idx;
			for (int i = 0; i < minSize; ++i) {
				idx = startIndex + i;
				final Integer index = Integer.valueOf(idx);
				if (!items.containsKey(index)) {
					final Object itemId = container.getIdByIndex(idx);
					final Item item = container.getItem(itemId);
					items.put(index, Containers.fromContactInfoFromItem(itemId, item));
				}
			}
		}
	};

	public EndlessScrollList(Indexed container) {
		registerRpc(rpc);
		this.container = container;
	}

	@Override
	protected ScrollListState getState() {
		return (ScrollListState) super.getState();
	}

	@Override
	public Iterator<Component> iterator() {
		if (visibleComponents == null) {
			Collection<Component> empty = Collections.emptyList();
			return empty.iterator();
		}
		return visibleComponents.iterator();
	}

	@Override
	public Object nextItemId(Object itemId) {
		return container.nextItemId(itemId);
	}

	@Override
	public Object prevItemId(Object itemId) {
		return container.prevItemId(itemId);
	}

	@Override
	public Object firstItemId() {
		return container.firstItemId();
	}

	@Override
	public Object lastItemId() {
		return container.lastItemId();
	}

	@Override
	public boolean isFirstId(Object itemId) {
		return container.isFirstId(itemId);
	}

	@Override
	public boolean isLastId(Object itemId) {
		return container.isLastId(itemId);
	}

	@Override
	public Object addItemAfter(Object previousItemId) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Item addItemAfter(Object previousItemId, Object newItemId) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/* Action container */

	/**
	 * Registers a new action handler for this container
	 * 
	 * @see com.vaadin.event.Action.Container#addActionHandler(Action.Handler)
	 */
	@Override
	public void addActionHandler(Action.Handler actionHandler) {
		if (actionHandler != null) {
			if (actionHandlers == null) {
				actionHandlers = new LinkedList<Handler>();
				actionMapper = new KeyMapper<Action>();
			}
			if (!actionHandlers.contains(actionHandler)) {
				actionHandlers.add(actionHandler);

				// Assures the visual refresh. No need to reset the page buffer
				// before as the content has not changed, only the action
				// handlers.
				refreshRenderedCells();
			}
		}
	}

	/**
	 * Removes a previously registered action handler for the contents of this
	 * container.
	 * 
	 * @see com.vaadin.event.Action.Container#removeActionHandler(Action.Handler)
	 */
	@Override
	public void removeActionHandler(Action.Handler actionHandler) {
		if (actionHandlers != null && actionHandlers.contains(actionHandler)) {
			actionHandlers.remove(actionHandler);
			if (actionHandlers.isEmpty()) {
				actionHandlers = null;
				actionMapper = null;
			}

			// Assures the visual refresh. No need to reset the page buffer
			// before as the content has not changed, only the action
			// handlers.
			refreshRenderedCells();
		}
	}

	/**
	 * Removes all action handlers
	 */
	public void removeAllActionHandlers() {
		actionHandlers = null;
		actionMapper = null;
		// Assures the visual refresh. No need to reset the page buffer
		// before as the content has not changed, only the action
		// handlers.
		refreshRenderedCells();
	}

	protected void refreshRenderedCells() {
		markAsDirty();
	}

}
