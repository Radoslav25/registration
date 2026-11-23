
function validateForm() {
    let fornavn = document.forms["registrationForm"]["fornavn"].value;
    let etternavn = document.forms["registrationForm"]["etternavn"].value;
    let tel = document.forms["registrationForm"]["tel"].value;
    let passord = document.forms["registrationForm"]["passord"].value;
    let repetertPassord = document.forms["registrationForm"]["repetertPassord"].value;
    let kjonn = document.forms["registrationForm"]["kjonn"] ? form["kjonn"].value : "";
    
    if(!fornavn || !etternavn || !tel || !passord || !repetertPassord || !kjonn) {
        alert("All fields are Required!");
        return false;
    }
   
    const navnPattern = /^[A-Za-z]+$/;
    const telPattern = /^\d{8}$/;
    const passordPattern = /^.{6,}$/;
    
    if (!navnPattern.test(fornavn) || !navnPattern.test(etternavn)) {
        alert("Names can contain only big and small letters.");
        return false;
    }
    
    if(!telPattern.test(tel)) {
        alert("phone number must be 8 digits.");
        return false;
    }
    if (!passordPattern.test(passord)) {
        alert("password must be at least 6 characters.");
        return false;
    }
    
    if (passord !== repetertPassord) {
           alert("Passwords dont match!");
           return false;
           
       }
       
    return true;
}