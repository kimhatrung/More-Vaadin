package org.vaadin.wiki.cc.gflot.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.AbstractComponentState;

public class LinePlotState extends AbstractComponentState {

	public List<DataSeries> series = new ArrayList<DataSeries>();

	public static class DataSeries implements Serializable {
		public String label;
		public String color;
		public List<Float> data;
	}
}
