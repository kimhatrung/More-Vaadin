package org.vaadin.wiki.cc.gflot;

import java.util.Arrays;

import org.vaadin.wiki.cc.gflot.shared.LinePlotState;
import org.vaadin.wiki.cc.gflot.shared.LinePlotState.DataSeries;

import com.vaadin.ui.AbstractComponent;

public class LinePlot extends AbstractComponent {

	public LinePlot() {
	}

	@Override
	public LinePlotState getState() {
		return (LinePlotState) super.getState();
	}

	public void addSeries(String label, String color, Float[] fs) {
		DataSeries ds = new DataSeries();
		ds.label = label;
		ds.color = color;
		ds.data = Arrays.asList(fs);
		getState().series.add(ds);
	}
}
