package org.vaadin.wiki.cc.gflot.shared;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.AbstractComponentState;

public class LinePlotState extends AbstractComponentState {

	public List<DataSeries> series = new ArrayList<DataSeries>();

	public static class DataSeries {
		public String label;
		public String color;
		public List<Float> data;
	}
}
