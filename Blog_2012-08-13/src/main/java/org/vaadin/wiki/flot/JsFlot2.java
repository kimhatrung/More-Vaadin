package org.vaadin.wiki.flot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.Notification;

// @JavaScript({"https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js", "jquery.flot.js", "flot_connector.js" })
@JavaScript({"jquery.js", "jquery.flot.js", "js_flot2_connector.js"})
public class JsFlot2 extends AbstractJavaScriptComponent {
	
    public JsFlot2() {
        registerRpc(new FlotClickRpc() {
            public void onPlotClick(int seriesIndex, int dataIndex) {
                Notification.show("Clicked on [" + seriesIndex + ", "
                        + dataIndex + "]");
            }
        });
        /*
        registerCallback("onPlotClick", new JavaScriptCallback() {
            public void call(JSONArray arguments) throws JSONException {
                int seriesIndex = arguments.getInt(0);
                int dataIndex = arguments.getInt(1);
                Notification.show("Clicked on [" + seriesIndex + ", "
                        + dataIndex + "]");
            }
        });
         */
        registerRpc(new FlotClickRpc() {
			
			@Override
			public void onPlotClick(int seriesIndex, int dataIndex) {
                Notification.show("Clicked on [" + seriesIndex + ", "
                        + dataIndex + "]");
			}
		});
    }

    public void addSeries(double... points) {
        List<List<Double>> pointList = new ArrayList<List<Double>>();
        for (int i = 0; i < points.length; i++) {
            pointList.add(Arrays.asList(Double.valueOf(i),
                    Double.valueOf(points[i])));
        }

        getState().series.add(pointList);

        // requestRepaint();
        markAsDirty();
    }

    public void highlight(int seriesIndex, int dataIndex) {
        getRpcProxy(FlotHighlightRpc.class).highlight(seriesIndex, dataIndex);
        // invokeCallback("highlight", seriesIndex, dataIndex);
        callFunction("highlight", seriesIndex, dataIndex);
    }

    @Override
    public JsFlotState getState() {
        return (JsFlotState) super.getState();
    }
}
