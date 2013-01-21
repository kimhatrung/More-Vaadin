package org.vaadin.wiki.cc.gwt.client;

import org.vaadin.wiki.cc.gwt.shared.ContactInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class GwtCellListShowcaseWidget extends ComplexPanel {

	public static final String CLASSNAME = "v-celllist";

	//

	private final ContactDatabase db = ContactDatabase.get();
	
	private CellList<ContactInfo> cellList;
	private SingleSelectionModel<ContactInfo> selectionModel;

	// GUI elements

	private final ShowMorePagerPanel more = new ShowMorePagerPanel();
	private final RangeLabelPager range = new RangeLabelPager();
	private final PushButton button = new PushButton("Generate more Contacts");

	// end of GUI elements

	public GwtCellListShowcaseWidget() {
		setElement(Document.get().createDivElement());
		setStylePrimaryName(CLASSNAME);

		more.setStylePrimaryName(CLASSNAME + "-more");
		range.setStylePrimaryName(CLASSNAME + "-range");
		button.setStylePrimaryName(CLASSNAME + "-button");

		add(more, getElement());
		add(range, getElement());
		add(button, getElement());

		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Not yet supported!");
			}
		});
		
		onInitialize();
	}

	/**
	 * Extracted from CwCellList.java
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
		more.setDisplay(cellList);
		range.setDisplay(cellList);

		// Handle events from the generate button.
		/*
		generateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ContactDatabase.get().generateContacts(50);
			}
		});
		 */
	}

}
