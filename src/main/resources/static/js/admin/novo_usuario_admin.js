function InfoModal(mensagem) {
    var modal = new ModalOK("Atenção!", mensagem, "Ok");
    modal.open();
}


function EnviarNovoUsuario(form) {
    console.log(form);
    json = {};
    var FormJson = FormSerializer(json,form);
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(FormJson)
    };

    
    console.log("Formulário: ", FormJson);
    console.log("Requisição: ", requestOptions);

    fetch("/usuarios", requestOptions)
        .then(response => {
            console.log("Status: ", response.status);
            console.log("Resposta: ", response);

            if (response.ok) {
                InfoModal("Usuário cadastrado com sucesso");
            }


        })

        .then(data => console.log("Data: ", data))
        .catch(error => console.log("Erro: ", error));

}