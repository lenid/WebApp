<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function setConfirmDelete(dialogHeader, dialogBody, url) {
		$("#dialogConfirmButton").text('Delete');
		$("#dialogConfirmButton").prop('class', 'btn btn-danger');
		setConfirmDialog(dialogHeader, dialogBody, url);
	}

	function setConfirmDialog(dialogHeader, dialogBody, url) {
		$("#dialogHeader").text(dialogHeader);
		$("#dialogBody").text(dialogBody);
		$("#dialogConfirmButton").click(function() {
			location.href = url;
		});
	}
</script>

<div class="modal fade" id="confirmDialogModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modalLabel"><span id="dialogHeader"></span></h4>
			</div>

			<div class="modal-body">
				<h4 class="modal-title" id="modalLabel"><span id="dialogBody"></span></h4>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-default" id="dialogConfirmButton">Ok</button>
			</div>
		</div>
	</div>
</div>
