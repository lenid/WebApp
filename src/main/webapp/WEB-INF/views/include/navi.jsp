
<%
	String collapseIssue = "";
	//String collapseTemplates = "";
	String collapseSettings = "";

	String subURL = request.getRequestURI().split("views/")[1].substring(0, 4);
	if (subURL.equals("issu") || subURL.equals("inde") || subURL.equals("mail") || subURL.equals("sear")) {
		collapseIssue = " in";
	} else {
		collapseSettings = " in";
	}
	/*if (subURL.equals("grou") || subURL.equals("phra") || subURL.equals("temp")) {
		collapseTemplates = " in";
	}
	if (subURL.equals("sett") || subURL.equals("cate") || subURL.equals("acco") || subURL.equals("user")) {
		collapseSettings = " in";
	}*/
%>

<div class="col-lg-2 sidebar">
	<div class="accordion">
		<ul class="nav nav-sidebar">
			<!-- Issues sub menu -->
			<li class="dropdown"><a class="accordion-toggle dropdown-toggle" data-toggle="collapse" href="#collapseIssues">Issues <b
					class="caret"></a></b></li>
			<div id="collapseIssues" class="accordion-body collapse<%=collapseIssue%>">
				<ul class="nav nav-sidebar">
					<li class="naviSubItem"><a href="issues">Critical & New</a></li>
					<li class="naviSubItem"><a href="issues?criteria=critical">Critical</a></li>
					<li class="naviSubItem"><a href="issues?criteria=new">New</a></li>
					<li class="naviSubItem"><a href="issues?criteria=feedback">Feedback</a></li>
					<li class="naviSubItem"><a href="issues?criteria=closed">Closed</a></li>
				</ul>
			</div>
			<!-- Templates sub menu -->
			<!-- li class="dropdown"><a class="accordion-toggle dropdown-toggle" data-toggle="collapse" href="#collapseTemplates">Templates
									<b class="caret">
							</a></b></li>
							<div id="collapseTemplates" class="accordion-body collapse">
								<ul class="nav nav-sidebar">
									<li class="naviSubItem"><a href="groups">Phrases Groups</a></li>
									<li class="naviSubItem"><a href="phrases">Phrases</a></li>
									<li class="naviSubItem"><a href="templates">Templates</a></li>
								</ul>
							</div -->
			<!-- Settings sub menu -->
			<c:if test="${isAdmin}">
				<li class="dropdown"><a class="accordion-toggle dropdown-toggle" data-toggle="collapse" href="#collapseSettings">Settings <b
						class="caret"></a></b></li>
				<div id="collapseSettings" class="accordion-body collapse<%=collapseSettings%>">
					<ul class="nav nav-sidebar">
						<li class="naviSubItem"><a href="settings">General</a></li>
						<li class="naviSubItem"><a href="categories">Categories</a></li>
						<li class="naviSubItem"><a href="accounts">Accounts</a></li>
						<li class="naviSubItem"><a href="users">Users</a></li>
						<li class="naviSubItem"><a href="groups">Phrases Groups</a></li>
						<li class="naviSubItem"><a href="phrases">Phrases</a></li>
						<li class="naviSubItem"><a href="templates">Templates</a></li>
					</ul>
				</div>
			</c:if>
			<!-- Other items of menu -->
			<c:if test="${isAdmin}">
			</c:if>
		</ul>
	</div>
</div>