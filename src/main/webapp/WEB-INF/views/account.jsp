<%@include file="include/bodyStart.jsp"%>

<c:set var="col_1" value="col-lg-4" />
<c:set var="col_offset_1" value="col-lg-offset-4" />
<c:set var="col_2" value="col-lg-8" />

<c:if test="${includeAccountData}">
	<c:set var="action" value="account" />
	<c:set var="col" value="col-lg-6" />
</c:if>

<c:if test="${not includeAccountData}">
	<c:set var="action" value="signup" />
	<c:set var="col" value="col-lg-6 col-lg-offset-2" />
</c:if>

<h3>${headerMessage}</h3>

<div class="${col}">

	<form:form id="accountForm" class="form-horizontal" method="POST" action="${action}" modelAttribute="account" role="form">
		<form:hidden path="id" />
		<form:hidden path="type" />
		<form:hidden path="hashPasswd" />

		<div class="form-group">
			<form:label class="${col_1} control-label" path="name"><s:message code="account.label.name" /></form:label>
			<div class="${col_2}">
				<form:input class="form-control" path="name" />
			</div>
		</div>
		<div class="form-group required">
			<form:label class="${col_1} control-label" path="login"><s:message code="account.label.login" /></form:label>
			<div class="${col_2}">
				<form:input class="form-control" path="login" autocomplete="off" />
			</div>
		</div>

		<c:if test="${not includeAccountData}">
			<div class="form-group required">
				<label class="${col_1} control-label"><s:message code="account.label.passwd" /></label>
				<div class="${col_2}">
					<form:password class="form-control" path="newPasswd" />
				</div>
			</div>
			<div class="form-group required">
				<label class="${col_1} control-label"><s:message code="account.label.passwd_confirm" /></label>
				<div class="${col_2}">
					<input id="confirmPasswd" class="form-control" name="confirmPasswd" type="password" />
				</div>
			</div>
		</c:if>

		<c:if test="${includeAccountData}">
			<form:hidden path="created" />

			<div id="noEditPasswd" class="form-group" style="display: block">
				<label class="${col_1} control-label"><s:message code="account.label.passwd" /></label>
				<div class="${col_2}">
					<div class="input-group">
						<input id="passwd" class="form-control" value="********" readonly />
						<div class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="showPsswdForm()">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Edit password"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
			
			<div id="editPasswd" style="display: none">
				<div class="form-group required">
					<label class="${col_1} control-label"><s:message code="account.label.passwd_old" /></label>
					<div class="${col_2}">
						<form:password class="form-control" path="oldPasswd" />
					</div>
				</div>
				<div class="form-group required">
					<label class="${col_1} control-label"><s:message code="account.label.passwd_new" /></label>
					<div class="${col_2}">
						<form:password class="form-control" path="newPasswd" />
					</div>
				</div>
				<div class="form-group required">
					<label class="${col_1} control-label"><s:message code="account.label.passwd_confirm" /></label>
					<div class="${col_2}">
						<input id="confirmPasswd" class="form-control" name="confirmPasswd" type="password" />
					</div>
				</div>
				<div class="form-group">
					<div class="${col_offset_1} ${col_2}" align="right">
						<button class="btn btn-link" type="button" onclick="hidePsswdForm()"><s:message code="account.button.cancel_passwd" /></button>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="${col_1} control-label"><s:message code="account.label.created" /></label>
				<div class="${col_2}">
					<label class="control-label"><nobr>
							<fmt:formatDate value="${account.created}" pattern='${dateFormat}' />
						</nobr></label>
				</div>
			</div>
		</c:if>

		<div class="form-group">
			<div class="col-lg-12">
				<p>&nbsp;</p>
			</div>
		</div>

		<div class="form-group">
			<div class="${col_offset_1} ${col_2}" align="right">
				<button class="btn btn-default" type="button" onclick="location.href='index';"><s:message code="account.button.back" /></button>
				<button class="btn btn-primary" type="submit"><s:message code="account.button.submit" /></button>
			</div>
		</div>
	</form:form>

</div>

<script type="text/javascript">
	function showPsswdForm() {
		document.getElementById('noEditPasswd').style.display = "none";
		document.getElementById('editPasswd').style.display = "block";
	}

	function hidePsswdForm() {
		var validator = $('#accountForm').data('formValidation');
		validator.resetField('oldPasswd');
		validator.resetField('newPasswd');
		validator.resetField('confirmPasswd');

		$('#oldPasswd').val('');
		$('#newPasswd').val('');
		$('#confirmPasswd').val('');

		document.getElementById('noEditPasswd').style.display = "block";
		document.getElementById('editPasswd').style.display = "none";
	}

	$(document).ready(function() {
		$('#accountForm').formValidation({
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				login : {
					validators : {
						notEmpty : {
							message : '<s:message code="account.valid.not_empty" />'
						},
						stringLength : {
							message : '<s:message code="account.valid.size.4_20" />',
							min : 4,
							max : 20,
						}
					}
				},
				oldPasswd : {
					validators : {
						notEmpty : {
							message : '<s:message code="account.valid.not_empty" />'
						}
					}
				},
				newPasswd : {
					validators : {
						notEmpty : {
							message : '<s:message code="account.valid.not_empty" />'
						},
						stringLength : {
							message : '<s:message code="account.valid.size.4_20" />',
							min : 4,
							max : 20,
						}
					}
				},
				confirmPasswd : {
					validators : {
						identical : {
							field : 'newPasswd',
							message : '<s:message code="account.valid.not_the_same" />'
						}
					}
				}
			}
		});
	});
</script>

<script type="text/javascript" src="vendors/jquery/formValidation.min.js"></script>
<script type="text/javascript" src="vendors/jquery/framework/bootstrap.min.js"></script>

<%@include file="include/bodyFinish.jsp"%>