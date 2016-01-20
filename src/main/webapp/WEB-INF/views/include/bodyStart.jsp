<%@include file="head.jsp"%>

<body ${ onBeforeUnload }>
	<%@include file="top.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<c:if test="${includeNaviPanel}">
				<%@include file="navi.jsp"%>
				<div class="col-lg-10 col-lg-offset-2 main">
			</c:if>
			<c:if test="${not includeNaviPanel}">
				<div class="col-lg-12 main">
			</c:if>
			<%@include file="messages.jsp"%>