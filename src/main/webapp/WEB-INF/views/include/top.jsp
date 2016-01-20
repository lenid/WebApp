
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><s:message code="global.project.name" /></a>
		</div>

		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${includeAccountData}">
					<!-- li><form class="navbar-form navbar-right" method="GET" action="issuesSearch">
							<input type="text" name="text" class="form-control" placeholder="Search by Id and Subject...">
						</form></li -->
					<li><a href="<c:url value="/account"/>"><s:message code="header.button.account" /></a></li>
					<li><a href="<c:url value="/logout"/>"><s:message code="header.button.logout" />, ${userName}</a></li>
				</c:if>
				<li>|</li>
				<li><a href="?lang=en">eng</a></li>
				<li><a href="?lang=uk">rus</a></li>
			</ul>
		</div>
	</div>
</div>