/*
$(document).ready(function() {
    $('#passwdEditForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
			login : {
				validators : {
					notEmpty : {
						message : 'The Login is required and cannot be empty'
					},
					stringLength : {
						message : 'The field must be in range from 3 to 20 characters',
						min : 3,
						max : 20,
					}
				}
			},
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
					}
				}
			},
        	confirmPasswd: {
                validators: {
                    identical: {
                        field: 'newPasswd',
                        message: 'The password and its confirm are not the same'
                    }
                }
            }
        }
    });
});

*/