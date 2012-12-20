org_vaadin_wiki_flot_JsFlot = function() {
	var element = $(this.getElement());

	this.onStateChange = function() {
		$.plot(element, this.getState().series);
	}
}
