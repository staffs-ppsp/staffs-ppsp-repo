Event.observe(window,'load',function() {
	for (var intIndex=0; intIndex<window.document.forms.length; intIndex++) {
		window.document.forms[intIndex].reset();
	}
	var arrDisabledLinks = $$("a.link-disabled");
	for (var intIndex=0; intIndex<arrDisabledLinks.length; intIndex++) {
		Event.observe(arrDisabledLinks[intIndex],'click',function(objEvent) {
			Event.stop(objEvent);
			return false;
		});
	}
});
