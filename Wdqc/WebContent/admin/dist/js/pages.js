function loadPage(url) {
	if (!url) {
		return;
	}
	$("#page").load(url);
};