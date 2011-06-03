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
	var updated; // {} = id -> employee
	var cols = [ {
		id : "lastName",
		field : "lastName",
		name : "Last Name",
		width : 200,
		sortable : true,
		editor : TextCellEditor
	}, {
		id : "firstName",
		field : "firstName",
		name : "First Name",
		width : 200,
		sortable : true,
		editor : TextCellEditor
	}, {
		id : "email",
		field : "email",
		name : "Email",
		width : 200,
		sortable : true,
		editor : TextCellEditor
	}, {
		id : "hireDate",
		field : "hireDate",
		width : 200,
		name : "Hire Date",
		sortable : true,
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

		setup_sorting();
	}

	function setup_sorting() {
		function comparer(a, b) {
			var x = a[sortcol], y = b[sortcol];
			if (sortdir == 1) {
				return (x == y ? 0 : (x > y ? -1 : 1));
			} else {
				return (x == y ? 0 : (x > y ? 1 : -1));
			}

		}

		grid.onSort.subscribe(function(e, args) {
			sortdir = args.sortAsc ? 1 : -1;
			sortcol = args.sortCol.field;
			data.sort(comparer, sortdir);
			grid.invalidate();
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

	$("#employees_save").click(function() {
		Employees.save();
	});
});