function VerifyInputAndSelect(inputs){
    var invalids = {};
    inputs.forEach(input => {

        if (input.required && input.value === ""){
            invalids[input.name] = {
                "Tag" : input.tagName,
                "Required" : input.required,
                "Value" : input.value
            };
        }
    });

    return invalids;
}


/**
 * 
 * @param {HTMLElement} form 
 * @returns 
 */
function formRequiredVerify(form){
    var inputs = Array.from(form.getElementsByTagName("input"));
    var selects = Array.from(form.getElementsByTagName("select"));    

    var verify = {};

    verify["inputs"] = VerifyInputAndSelect(inputs)
    verify["selects"] = VerifyInputAndSelect(selects)
    
    return verify;

}