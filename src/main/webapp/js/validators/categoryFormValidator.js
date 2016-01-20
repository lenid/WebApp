$(document)
	.ready(
		function() {
			$('#categoryForm')
				.bootstrapValidator({
					container : '#messages',
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						'category.caption' : {
							validators : {
								notEmpty : {
									message : 'The Caption is required and cannot be empty'
								}
							}
						},
						'category.description' : {
							validators : {
								notEmpty : {
									message : 'The Description is required and cannot be empty'
								}
							}
						}
					}
				});
		});
