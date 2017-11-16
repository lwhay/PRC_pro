/**
 * 
 */
var jq = jQuery.noConflict();
function show3d(){
	jq("#3dshow").load(
	"/pro/3dshow/all_3d.jsp");
	$("#showBotton").attr({"disabled":"disabled"});
}

function TestShow3d(){
	jq("#3dtest").load(
	"/pro/3dshow/all_3d.jsp");
}
	