function DivSerializer (sessaoSerializer, div) {
    div = Array.from(div.children);
    div.forEach(tag => {
        if (tag.localName === 'input') {
            sessaoSerializer[tag.id] = document.getElementById(tag.id).value;
        } else if (tag.localName === 'section'){
            sessaoSerializer[tag.id] = SessaoSerializer(tag);
        } else if (tag.localName === 'div'){
            DivSerializer(sessaoSerializer, tag);   
        }});
}

function SessaoSerializer(sessao) {
    childrens = Array.from(sessao.children);
    let sessaoSerializer = {};

    childrens.forEach(tag => {
        
        if (tag.localName === 'input') {
            sessaoSerializer[tag.id] = document.getElementById(tag.id).value;
        } else if (tag.localName === 'section'){
            sessaoSerializer[tag.id] = SessaoSerializer(tag);
        } else if (tag.localName === 'div'){
            DivSerializer(sessaoSerializer, tag);
        }
    });

    console.log(sessaoSerializer);
    return sessaoSerializer;
}


function FormSerializer(formulario) {

    sessoes =  Array.from(formulario.children).filter(children => children.localName === 'section');
    console.log(formulario);
    var serializer = {};

    sessoes.forEach(sessao => {
        serializer[sessao.id] = SessaoSerializer(sessao);
    });

    console.log(serializer);

    return serializer;

}

