function DivSerializer (json, div) {
    div = Array.from(div.children);
    div.forEach(tag => {
        if (tag.localName === 'input') {
            json[tag.id] = document.getElementById(tag.id).value;
        } else if (tag.localName === 'select') {
            SelectSerializer(json, tag);
        } else if (tag.localName === 'section'){
            json[tag.id] = FormSerializer({}, tag);
        } else if (tag.localName === 'div'){
            DivSerializer(json, tag);   
        }});
}

function SelectSerializer(json, select) {
    options = Array.from(select.children);
    options.forEach(option => {
        if (option.selected) {
            json[select.id] = select.value;
        }
    })
}

function FormSerializer(json, form) {

    var childrens = Array.from(form.children);


    childrens.forEach(tag => {
        if (tag.localName === 'input') {
            json[tag.id] = document.getElementById(tag.id).value;
        } else if (tag.localName === 'select') {
            SelectSerializer(json, tag);
        } else if (tag.localName === 'section'){
            json[tag.id] = FormSerializer({}, tag);
        } else if (tag.localName === 'div'){
            DivSerializer(json, tag);
        }
    });

    return json;
}

