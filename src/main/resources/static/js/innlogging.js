const form = document.getElementById("form");
const mobil = document.getElementsByName("mobil")[0];
const passord = document.getElementsByName("passord")[0];

form.addEventListener("submit", e => {
    if (!isValid())
        e.preventDefault();
});

function isValid() {
    let valid = true;
    if (mobil.value == "") {
        valid = false;
        mobil.setCustomValidity("Mangler mobilnummer");
    } else {
        mobil.setCustomValidity("");
    }

    if (passord.value == "") {
        valid = false;
        passord.setCustomValidity("Mangler passord");
    } else {
        passord.setCustomValidity("");
    }

    return valid;
}
