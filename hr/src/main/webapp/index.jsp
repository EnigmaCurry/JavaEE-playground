<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script>
contextRoot = "<%=root%>";
</script>

<link rel="stylesheet" href="<%=root%>/css/slick.grid.css" type="text/css"
	media="screen" charset="utf-8" />
<link rel="stylesheet"
	href="<%=root%>/css/smoothness/jquery-ui-1.8.5.custom.css" type="text/css"
	media="screen" charset="utf-8" />
<link rel="stylesheet" href="<%=root%>/css/slick-default-theme.css" type="text/css"
	media="screen" charset="utf-8" />
<link rel="stylesheet" href="<%=root%>/css/site.css" type="text/css"
	media="screen" charset="utf-8" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
<script src="<%=root%>/js/vendor/json2.js"></script>
<script src="<%=root%>/js/vendor/jquery.rest_json.js"></script>

<script
	src="<%=root%>/js/vendor/slickgrid/lib/jquery.event.drag-2.0.min.js"></script>

<script src="<%=root%>/js/vendor/slickgrid/slick.core.js"></script>
<script
	src="<%=root%>/js/vendor/slickgrid/plugins/slick.cellrangeselector.js"></script>
<script
	src="<%=root%>/js/vendor/slickgrid/plugins/slick.cellselectionmodel.js"></script>
<script src="<%=root%>/js/vendor/slickgrid/slick.grid.js"></script>
<script src="<%=root%>/js/slick.editors.js"></script>

<script src="<%=root%>/js/site.js"></script>
<script src="<%=root%>/js/employee.js"></script>


<body>

	<div id="employees_grid"></div>
	<input type="button" value="Save" id="employees_save">
</body>
</html>
