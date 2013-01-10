package org.vaadin.wiki.cc.dynupdate;

import org.vaadin.wiki.cc.dynupdate.shared.AddResultState;

import com.vaadin.ui.AbstractComponent;

public class Addition extends AbstractComponent {
	private int term1;
	private int term2;
	private boolean needsRecalculation = false;

	public void setTerm1(int value1) {
		this.term1 = value1;
		needsRecalculation = true;

		//Mark the component as dirty to ensure beforeClientResponse will be invoked
		markAsDirty();
	}

	public void setTerm2(int value2) {
		this.term2 = value2;
		needsRecalculation = true;

		//Mark the component as dirty to ensure beforeClientResponse will be invoked
		markAsDirty();
	}

	private int calculateSum() {
		return term1 + term2;
	}

	@Override
	public void beforeClientResponse(boolean initial) {
		super.beforeClientResponse(initial);
		if (needsRecalculation) {
			needsRecalculation = false;
			// This could be an expensive operation that we don't want to do every time setTerm1 or setTerm2 is invoked.
			getState().sum = calculateSum();
		}
	}

	@Override
	protected AddResultState getState() {
		return (AddResultState) super.getState();
	}
}
