$(document)
	.ready(
		function() {
			$('#templateForm')
				.bootstrapValidator({
					container : '#messages',
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						'name' : {
							validators : {
								notEmpty : {
									message : 'The Name is required and cannot be empty'
								}
							}
						},
						'text' : {
							validators : {
								notEmpty : {
									message : 'The Text is required and cannot be empty'
								}
							}
						}
					}
				});
		});
