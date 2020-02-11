	$(document).ready(function() {
		//alert("this script is loaded");
		$(function() {
			$('form[id="userForm"]').validate({
				rules : {
					username : 'required',
					pazzword : {
						required : true,
						minlength : 8,
						maxlength : 15
					},
					email : {
						required : true,
						email : true
					},
					phno : {
						required : true,
						number : true,
						minlength : 10,
						maxlength : 10
					}
				},
				messages : {
					username : 'Please Enter userName',
					password : {
						required : 'Please Enter password',
						minlength : 'Length should be 8 to 15 char',
						maxlength : 'Length should  not be exceed to 15'
					},
					email : 'Please Enter email',
					phno : {
						required : 'Please Enter phone Number',
						number :'Enter Only Numbers',
						minlength: 'Phone no. must be 10 digit',
						maxlength:'Phone No. Must be 10 digit'
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
			/*$.validator.addMethod("regex", function(value, element, reg) {
				var re = new RegExp(reg);
				var strExp = new regExp("/")
				console.log('re ', re);
				console.log('value ', value);
				console.log('regExp ', reg);
				console.log('test result', re.test(value));
				return this.optional(element) || !re.test(value);
			}, "Invalid Phone No.");
*/
		});

	});