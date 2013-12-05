
function form_object (dclass, type, count, state, time) {
	var req_obj = {
		'class': dclass,
		'type' : type,
		'count' : count,
		'state' : state,
		'time' : time
	};
	
	return req_obj;
}