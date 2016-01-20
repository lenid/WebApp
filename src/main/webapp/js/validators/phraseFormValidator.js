$(document)
	.ready(
		function() {
			$('#phraseForm')
				.bootstrapValidator({
					container : '#messages',
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
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
