package org.vaadin.wiki.flot;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class JsFlotState extends JavaScriptComponentState {
    public List<List<List<Double>>> series = new ArrayList<List<List<Double>>>();
}