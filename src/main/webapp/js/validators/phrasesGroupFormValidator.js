$(document)
	.ready(
		function() {
			$('#phrasesGroupForm')
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
						}
					}
				});
		});
