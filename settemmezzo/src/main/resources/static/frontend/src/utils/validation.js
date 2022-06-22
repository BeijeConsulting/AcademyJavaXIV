/**
 * Check if the mail is valid
 * @param {string} mail 
 * @returns {boolean} true if mail passes the regex test (domain and provider given)
 */
function checkMail(mail) {
  const reMail =
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return reMail.test(mail)
}

/**
 * Check if the password is valid
 * @param {string} password 
 * @returns {boolean} true if password passes the regex test (8 chars, 1 capital letter and 1 symbol)
 */
function checkPassword(password) {
    const rePassword = /^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&+=]).*$/;
    return rePassword.test(password)
}

export {
    checkMail,
    checkPassword
}