const form = document.getElementById("form");
const fornavn = document.getElementsByName("fornavn")[0];
const etternavn = document.getElementsByName("etternavn")[0];
const mobil = document.getElementsByName("mobil")[0];
const passord = document.getElementsByName("passord")[0];
const repetert = document.getElementsByName("passordRepetert")[0];
const kjonn = document.getElementsByName("kjonn");

form.addEventListener("submit", e => {
    if (!isValid()){
        e.preventDefault();
        console.log("invalid");
    }
});

function isValid() {
    let valid = true;

    valid = !!validateFornavn() && valid;
    valid = !!validateEtternavn() && valid;
    valid = !!validateMobil() && valid;
    valid = !!validatePassord() && valid;
    valid = !!validateRepetert() && valid;

    return valid;
}

fornavn.addEventListener("input", validateFornavn);
function validateFornavn() {
    fornavn.setCustomValidity("");
    const verdi = fornavn.value;
    if (verdi.match(/^\p{L}(\p{L}|-| ){1,19}$/u))
        return true;

    if (verdi == "")
        return fornavn.setCustomValidity("Fornavn mangler");
    if (!verdi.match(/^\p{L}/u))
        return fornavn.setCustomValidity("Fornavn må starte med stor bokstav")
    if (verdi.length < 2 || verdi > 20)
        return fornavn.setCustomValidity("Fornavn kan ha mellom 2 og 20 tegn");
    let symbols = new Set([...verdi.replace(/\p{L}|-| /gu, "")]);
    if (symbols.size > 0)
        return fornavn.setCustomValidity(`Ulovelige tegn i fornavn: ${[...symbols].join(", ")}`);
    return true;
}
etternavn.addEventListener("input", validateEtternavn);
function validateEtternavn() {
    etternavn.setCustomValidity("");
    const verdi = etternavn.value;
    if (verdi.match(/^\p{L}(\p{L}|-){1,19}$/u))
        return true;

    if (verdi == "")
        return etternavn.setCustomValidity("Etternavn mangler");
    if (!verdi.match(/^\p{L}/u))
        return etternavn.setCustomValidity("Etternavn må starte med stor bokstav")
    if (verdi.length < 2 || verdi > 20)
        return etternavn.setCustomValidity("Etternavn kan ha mellom 2 og 20 tegn");
    let symbols = new Set([...verdi.replace(/\p{L}|-| /gu, "")]);
    if (symbols.size > 0)
        return etternavn.setCustomValidity(`Ulovelige tegn i etternavn: ${[...symbols].join(", ")}`);

    return true;
}

mobil.addEventListener("input", validateMobil);
function validateMobil() {
    mobil.setCustomValidity("");
   const verdi = mobil.value.trim();
   if (verdi.match(/^\d{8}$/))
       return true;

   if (verdi == "")
       return mobil.setCustomValidity("Mobilnummer mangler");
   let symbols = new Set([...verdi.replace(/[0-9]/g, "")])
   if (symbols.size > 0)
       return mobil.setCustomValidity(`Ulovelige tegn i mobilnummer: ${[...symbols].join(", ")}`);
   if (verdi.length !== 8)
       return mobil.setCustomValidity("Mobilnummer må ha 8 siffer");

   return true;
}

passord.addEventListener("input", validatePassord);
function validatePassord() {
    passord.setCustomValidity("");
    const verdi = passord.value;
    if (verdi.match(/^.{,}$/))
        return true;

    if (verdi == "")
        return passord.setCustomValidity("Passord mangler");
    if (verdi.length < 8)
        return passord.setCustomValidity("Passord må ha minst 8 tegn");

    return true;
}

repetert.addEventListener("input", validateRepetert);
function validateRepetert() {
    repetert.setCustomValidity("");
    if (passord.value !== repetert.value)
        return repetert.setCustomValidity("Passordene må være lik");
    if (repetert.value == "")
        return repetert.setCustomValidity("Passord mangler");

    return true;
}