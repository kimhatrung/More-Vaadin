window.org_vaadin_wiki_flot_JsFlot2 = function() {
	
	/*
    var element = $(this.getElement());
    var rpcProxy = this.getRpcProxy();
    var flot;
    
    this.onStateChange = function() {
        flot = $.plot(element, this.getState().series, {grid: {clickable: true}});
    };
        
    element.bind('plotclick', function(event, point, item) {
        if (item) {
            rpcProxy.onPlotClick(item.seriesIndex, item.dataIndex);
        }
    });
    
    this.registerRpc({
        highlight: function(seriesIndex, dataIndex) {
            if (flot) {
                flot.highlight(seriesIndex, dataIndex);
            }
        }
    });
     */
	
    var element = $(this.getElement());
    var rpcProxy = this.getRpcProxy();
    var self = this;
    var flot;
    
    this.onStateChange = function() {
            flot = $.plot(element, this.getState().series, {grid: {clickable: true}});
    }
            
    element.bind('plotclick', function(event, point, item) {
            if (item) {
                    rpcProxy.onPlotClick(item.seriesIndex, item.dataIndex);
                    self.onPlotClick(item.seriesIndex, item.dataIndex);
            }
    });
    
    this.registerRpc({
            highlight: function(seriesIndex, dataIndex) {
                    if (flot) {
                            flot.highlight(seriesIndex, dataIndex);
                    }
            }
    });
    
    this.highlight = function(seriesIndex, dataIndex) {
            if (flot) {
                    flot.highlight(seriesIndex, dataIndex);
            }
    };	
}