function validate() {
    let username = $('#username');
    let email = $('#email');
    let password = $('#password');
    let confirmPassword = $('#confirm-password');
    let isCompany = $('#company');
    let companyInfo = $('#companyInfo');
    let companyNum = $('#companyNumber');
    let submitBtn = $('#submit');

    let usernamePattern = /^[a-zA-Z0-9]{3,20}$/g;
    let passwordPattern = /^[\w]{5,15}$/g;
    let confirmPasswordPattern = /^[\w]{5,15}$/g;
    let emailPattern = /[\w]+@{1}([\w]*[\.]+[\w]*)+/g;
    let companyInfoPattern = /^[1-9][0-9][0-9][0-9]$/;

    isCompany.on('change', function() {
        if (isCompany.is(':checked')) {
            companyInfo.css('display', 'block');
        } else {
            companyInfo.css('display', 'none');
        }
    });

    submitBtn.on('click', function(event) {
        event.preventDefault();

        validateElement(usernamePattern,username);
        validateElement(emailPattern,email);

        if (password.val() !== confirmPassword.val()) {
            password.css('border-color','red');
            confirmPassword.css('border-color','red');
        } else {
            validateElement(passwordPattern,password);
            validateElement(confirmPasswordPattern,confirmPassword);
        }

        if (isCompany.is(':checked')) {
            validateElement(companyInfoPattern, companyNum);
        }

        let allCorrect = ($('input[style*="red"]').length > 0) ? false : true;

        if (allCorrect) {
            $('#valid').css('display', 'block');
        } else {
            $('#valid').css('display', 'none');
        }
    });

    function validateElement(pattern, element) {
        if (!pattern.test(element.val())) {
            element.css('border-color','red');
        } else {
            element.css('border-color','');
        }
    }
}
