$(document)
		.ready(
				function() {
					$('#userForm')
							.bootstrapValidator(
									{
										container : '#messages',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										fields : {
											name : {
												validators : {
													notEmpty : {
														message : 'The Name is required and cannot be empty'
													}
												}
											},
											login : {
												validators : {
													notEmpty : {
														message : 'The Login is required and cannot be empty'
													}
												}
											},
											passwd : {
												validators : {
									                notEmpty : {
														message : 'The Password is required and cannot be empty'
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
													},
													identical: {
									                    field: 'confirmPasswd',
									                    message: 'The Password and its confirm are not the same'
									                }
												}
											},
											confirmPasswd : {
												validators : {
													notEmpty : {
														message : 'The ConfirmPassword is required and cannot be empty'
													},
													identical: {
									                    field: 'passwd',
									                    message: 'The Password and its confirm are not the same'
									                }
												}
											}
											/*
											mail : {
												validators : {
													notEmpty : {
														message : 'The E-mail is required and cannot be empty'
													},
													emailAddress : {
														message : 'The E-mail address is not valid'
													}
												}
											}
											*/
										}
									});
				});
