package org.vaadin.wiki.cc.gflot.client;

import org.vaadin.wiki.cc.gflot.LinePlot;
import org.vaadin.wiki.cc.gflot.shared.LinePlotState;
import org.vaadin.wiki.cc.gflot.shared.LinePlotState.DataSeries;

import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.SeriesHandler;
import ca.nanometrics.gflot.client.SimplePlot;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(LinePlot.class)
public class LinePlotConnector extends AbstractComponentConnector {

	@Override
	public LinePlotState getState() {
		return (LinePlotState) super.getState();
	}

	@Override
	public SimplePlot getWidget() {
		return (SimplePlot) super.getWidget();
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(SimplePlot.class);
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		getWidget().getModel().clear();
		for (DataSeries ds : getState().series) {

			SeriesHandler s = getWidget().getModel().addSeries(ds.label,
					ds.color);
			for (int i = 0; i < ds.data.size(); i++) {
				s.add(new DataPoint(i, ds.data.get(i)));
			}
		}
		getWidget().redraw();
	}
}
