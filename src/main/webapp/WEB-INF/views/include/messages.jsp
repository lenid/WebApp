<c:forEach var="message" items="${messages}">
	<c:if test="${message.success}">
		<div class="alert alert-success">${message.text}</div>
	</c:if>
	<c:if test="${!message.success}">
		<div class="alert alert-warning">${message.text}</div>
	</c:if>
</c:forEach>