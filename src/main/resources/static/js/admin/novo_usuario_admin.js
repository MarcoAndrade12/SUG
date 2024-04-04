const enderecos = {};

ListAllPais();
ListAllEstados();


function ListAllPais(){
    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/paises")
        .then(response => response.json())
        .then(paises => {
            paises.forEach(pais => {
                var select = document.getElementById("pais").getElementsByTagName("select")[0];


                option = document.createElement("option");
                option.value = pais['id']['M49'];
                option.text = pais['nome'];
                
                select.appendChild(option);

            });       
        });
}

function ListAllEstados(pais){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/estados")
        .then(response => response.json())
        .then(paises => {
            paises.forEach(pais => {
                var select = document.getElementById("estado").getElementsByTagName("select")[0];
                option = document.createElement("option");
                option.value = pais['id'];
                option.text = pais['nome'];
                
                select.appendChild(option);

            });       
        });
}


function ListAllCidades(estado){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado + "/municipios?orderBy=nome")
        .then(response => response.json())
        .then(cidades => {
            var select = document.getElementById("cidade").getElementsByTagName("select")[0];
            select.children = "";

            cidades.forEach(cidade => {
                option.value = cidade['id'];
                option.text = cidade['nome'];
                
                select.appendChild(option);

            });       
        });
}

 
    


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