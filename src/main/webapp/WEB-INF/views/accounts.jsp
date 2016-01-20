<%@include file="include/bodyStart.jsp"%>

<h3>Accounts</h3>

<div align="left">
	<button type="button" onclick="location.href='account_one';" class="btn btn-default">
		<span class="glyphicon glyphicon-plus" aria-hidden="true" title="Add"></span>
	</button>
	<br />
	<br />
</div>

<c:if test="${empty accountList}">
	<h4>There are no any Account</h4>
</c:if>
<c:if test="${not empty accountList}">
	<table class="table table-striped table-hover">
		<tr>
			<th>Description</th>
			<th>Incoming Mail</th>
			<th>Incoming Host</th>
			<th>Outgoing Mail</th>
			<th>Outgoing Host</th>
			<th></th>
		</tr>
		<c:forEach var="account" items="${accountList}">
			<tr class="clickable">
				<td onclick="location.href='account?id=${account.id}';">${account.description}</td>
				<td onclick="location.href='account?id=${account.id}';">${account.inMail}</td>
				<td onclick="location.href='account?id=${account.id}';">${account.inHost}</td>
				<td onclick="location.href='account?id=${account.id}';">${account.outMail}</td>
				<td onclick="location.href='account?id=${account.id}';">${account.outHost}</td>
				<td align="right" width="10%" nowrap>
					<button type="button" data-toggle="modal" class="btn btn-default" data-target="#confirmDialogModal"
						onclick="setConfirmDelete('Delete Account?', '#${account.id} - ${account.description}', 'accountdel?id='+${account.id})">
						<span class="glyphicon glyphicon-trash" aria-hidden="true" title="Delete"></span>
					</button>
					<button type="button" onclick="location.href='account?id=${account.id}';" class="btn btn-default">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Edit"></span>
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<jsp:include page="include/modal/confirmDialog.jsp" />
<%@include file="include/bodyFinish.jsp"%>
