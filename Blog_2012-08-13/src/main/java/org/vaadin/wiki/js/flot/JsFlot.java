package org.vaadin.wiki.js.flot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

// @JavaScript({"https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js", "jquery.flot.js", "js_flot_connector.js"})
@JavaScript({"jquery.js", "jquery.flot.js", "js_flot_connector.js"})
public class JsFlot extends AbstractJavaScriptComponent {
    public void addSeries(double... points) {
        List<List<Double>> pointList = new ArrayList<List<Double>>();
        for (int i = 0; i < points.length; i++) {
            pointList.add(Arrays.asList(Double.valueOf(i),
                    Double.valueOf(points[i])));
        }

        getState().series.add(pointList);
    }

    @Override
    public JsFlotState getState() {
        return (JsFlotState) super.getState();
    }
}
