/*
$(document).ready(function() {
	$('#passwdEditForm').bootstrapValidator({
		container : '#messages',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			oldPasswd : {
				validators : {
					notEmpty : {
						message : 'The field is required and cannot be empty'
					}
				}
			},
			newPasswd : {
				validators : {
					notEmpty : {
						message : 'The field is required and cannot be empty'
					},
					stringLength : {
						message : 'The field must be in range from 4 to 20 characters',
						min : 4,
						max : 20,
					},
					callback : {
						callback : function(value, validator, $field) {
							var newUser = !$('#id').val();
							var passwdFilled = value.length > 0;
							if (newUser && !passwdFilled) {
								return false;
							}
							return true;
                        }
					}
				}
			},
			confirmPasswd : {
				validators : {
					identical : {
						field : 'newPasswd',
						message : 'The password and its confirm are not the same'
					},
					notEmpty : {
						message : 'The field is required and cannot be empty'
					}
				}
			}
		}
	});
});
*/
