package org.vaadin.wiki.cc.gwt.client;

import java.util.Iterator;

import org.vaadin.wiki.cc.gwt.shared.ContactInfo;

import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import com.google.gwt.view.client.HasRows;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Focusable;
import com.vaadin.client.ui.Action;
import com.vaadin.client.ui.ActionOwner;
import com.vaadin.client.ui.TreeAction;
import com.vaadin.client.ui.dd.VHasDropHandler;

public class EndlessScrollListWidget extends AbstractPager implements HasWidgets
		, ActionOwner
/* , ScrollHandler, VHasDropHandler, FocusHandler, BlurHandler, Focusable */
{
	/**
	 * The default increment size.
	 */
	private static final int DEFAULT_INCREMENT = 20;
	
	private static final String CLASSNAME = "v-endlessscrolllist";
	
	//

	/**
	 * The increment size.
	 */
	private int incrementSize = DEFAULT_INCREMENT;

	/**
	 * The last scroll position.
	 */
	private int lastScrollPos = 0;

	/**
	 * The scrollable panel.
	 */
	private final ScrollPanel scrollable = new ScrollPanel();
	
	/* Vaadin stuff */

	private ApplicationConnection client;

	private String[] bodyActionKeys;

	private String paintableId;

	private WidgetCollection children = new WidgetCollection(this);
	
	// ???
	private CellList<ContactInfo> cellList;

	public EndlessScrollListWidget() {
		// setStyleName(CLASSNAME);
		
		initWidget(scrollable);

		// Do not let the scrollable take tab focus.
		scrollable.getElement().setTabIndex(-1);

		// Handle scroll events.
		scrollable.addScrollHandler(new ScrollHandler() {
			public void onScroll(ScrollEvent event) {
				// If scrolling up, ignore the event.
				int oldScrollPos = lastScrollPos;
				lastScrollPos = scrollable.getVerticalScrollPosition();
				if (oldScrollPos >= lastScrollPos) {
					return;
				}

				HasRows display = getDisplay();
				if (display == null) {
					return;
				}
				int maxScrollTop = scrollable.getWidget().getOffsetHeight()
						- scrollable.getOffsetHeight();
				if (lastScrollPos >= maxScrollTop) {
					// We are near the end, so increase the page size.
					int newPageSize = Math.min(
							display.getVisibleRange().getLength() + incrementSize,
							display.getRowCount());
					display.setVisibleRange(0, newPageSize);
				}
			}
		});
		
		onInitialize();
	}

	/**
	 * Extracted from CwCellList.java
	 * ???
	 */
	public void onInitialize() {
		// Images images = GWT.create(Images.class);

		// Create a CellList.
		// ContactCell contactCell = new ContactCell(images.contact());
		ContactCell contactCell = new ContactCell(null);

		// Set a key provider that provides a unique key for each contact. If key is
		// used to identify contacts when fields (such as the name and address)
		// change.
		cellList = new CellList<ContactInfo>(contactCell, ContactInfo.KEY_PROVIDER);
		cellList.setPageSize(30);
		cellList.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		cellList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		// Add a selection model so we can select cells.
		final SingleSelectionModel<ContactInfo> selectionModel = new SingleSelectionModel<ContactInfo>(
				ContactInfo.KEY_PROVIDER);
		cellList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				// contactForm.setContact(selectionModel.getSelectedObject());
			}
		});

		// Create the UiBinder.
		// Binder uiBinder = GWT.create(Binder.class);
		// Widget widget = uiBinder.createAndBindUi(this);

		// Add the CellList to the data provider in the database.
		ContactDatabase.get().addDataDisplay(cellList);

		// Set the cellList as the display of the pagers. This example has two
		// pagers. pagerPanel is a scrollable pager that extends the range when the
		// user scrolls to the bottom. rangeLabelPager is a pager that displays the
		// current range, but does not have any controls to change the range.
		setDisplay(cellList);

		// Handle events from the generate button.
		/*
		generateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ContactDatabase.get().generateContacts(50);
			}
		});
		 */
	}
	
	/* pager implementation */

	/**
	 * Get the number of rows by which the range is increased when the scrollbar
	 * reaches the bottom.
	 *
	 * @return the increment size
	 */
	public int getIncrementSize() {
		return incrementSize;
	}

	@Override
	public void setDisplay(HasRows display) {
		assert display instanceof Widget : "display must extend Widget";
		scrollable.setWidget((Widget) display);
		super.setDisplay(display);
	}

	/**
	 * Set the number of rows by which the range is increased when the scrollbar
	 * reaches the bottom.
	 *
	 * @param incrementSize the incremental number of rows
	 */
	public void setIncrementSize(int incrementSize) {
		this.incrementSize = incrementSize;
	}

	/* Vaadin contract */

	public void init(ApplicationConnection client) {
		this.client = client;
	}

	@Override
	public Action[] getActions() {
		if (bodyActionKeys == null) {
			return new Action[] {};
		}
		final Action[] actions = new Action[bodyActionKeys.length];
		for (int i = 0; i < actions.length; i++) {
			final String actionKey = bodyActionKeys[i];
			Action bodyAction = new TreeAction(this, null, actionKey);
			// bodyAction.setCaption(getActionCaption(actionKey));
			// bodyAction.setIconUrl(getActionIcon(actionKey));
			actions[i] = bodyAction;
		}
		return actions;
	}

	@Override
	public ApplicationConnection getClient() {
		return client;
	}

	@Override
	public String getPaintableId() {
		return paintableId;
	}

	/* HasWidgets contract */

	protected WidgetCollection getChildren() {
		return children;
	}

	protected final void orphan(Widget child) {
		assert (child.getParent() == this);
		// ???
		// child.setParent(null);
	}

	@Override
	public void add(Widget w) {
		getChildren().add(w);
	}

	@Override
	public void clear() {
		final int size = getChildren().size();
		for (int i = 0; i < size; ++i) {
			remove(i);
		}
	}

	@Override
	public Iterator<Widget> iterator() {
		return getChildren().iterator();
	}

	public boolean remove(int index) {
		return remove(getChildren().get(index));
	}

	@Override
	public boolean remove(Widget w) {
		// Validate.
		if (w.getParent() != this) {
			return false;
		}
		// Orphan.
		try {
			orphan(w);
		}
		finally {
			// Physical detach.
			Element elem = w.getElement();
			DOM.removeChild(DOM.getParent(elem), elem);

			// Logical detach.
			getChildren().remove(w);
		}
		return true;
	}

	@Override
	protected void onRangeOrRowCountChanged() {
		// TODO Auto-generated method stub
	}

}
