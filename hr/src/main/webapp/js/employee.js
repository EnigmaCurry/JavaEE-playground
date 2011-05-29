function requiredFieldValidator(value) {
	if (value == null || value == undefined || !value.length)
		return {
			valid : false,
			msg : "This is a required field"
		};
	else
		return {
			valid : true,
			msg : null
		};
}

Employees = function() {

	var grid;
	var data;
	var updated; // id -> employee
	var cols = [ {
		id : "firstName",
		field : "firstName",
		name : "First Name",
		width : 100,
		editor : TextCellEditor
	}, {
		id : "lastName",
		field : "lastName",
		name : "Last Name",
		width : 100,
		editor : TextCellEditor
	}, {
		id : "email",
		field : "email",
		name : "Email",
		editor : TextCellEditor
	}, {
		id : "hireDate",
		field : "hireDate",
		name : "Hire Date",
		editor : DateCellEditor
	} ];
	var options = {
		editable : true,
		enableCellNavigation : true
	};

	function create(new_data) {
		data = new_data;
		updated = {};
		grid = new Slick.Grid("#employees_grid", data, cols, options);

		grid.onCellChange.subscribe(function(e, args) {
			var emp = args.item;
			updated[emp.id] = emp;
		});
	}

	function save_updated() {
		grid.getEditController().commitCurrentEdit();
		$.each(updated, function(i, employee) {
			$.update(contextRoot + "/api/employee", employee);
		});
	}

	return {
		create : create,
		getData : function() {
			return data;
		},
		getGrid : function() {
			return grid;
		},
		getCols : function() {
			return cols;
		},
		getUpdated : function() {
			return updated;
		},
		save : save_updated
	};
}();

$(document).ready(function() {
	$.get("api/employee/all", function(data) {
		Employees.create(data);
	});
	
	$("#employees_save").click(function(){
		Employees.save();
	});
});