const enderecos = {};

function ListAllPais(country, estado, cidade){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/paises/76")
        .then(response => response.json())
        .then(paises => {
            var select = document.getElementById("pais").getElementsByTagName("select")[0];
            select.innerHTML = "<option selected value=''>Selecione...</option>";

            paises.forEach(pais => {
                option = document.createElement("option");
                option.value = pais['id']['M49'];
                option.selected= pais['id']['M49']==country;
                option.text = pais['nome'];
                select.appendChild(option);

            });       
        });
    
    ListAllEstados(estado, cidade);
}

function ListAllEstados(estado, cidade){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/estados")
        .then(response => response.json())
        .then(paises => {
            var select = document.getElementById("estado").getElementsByTagName("select")[0];
            select.innerHTML = "<option selected value=''>Selecione...</option>";

            paises.forEach(pais => {
                option = document.createElement("option");
                option.value = pais['id'];
                option.selected = pais['id']==estado;
                option.text = pais['nome'];
                
                select.appendChild(option);

            });       
        });
    
    ListAllCidades(estado, cidade);

}


function ListAllCidades(estado, city){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado + "/municipios?orderBy=nome")
        .then(response => response.json())
        .then(cidades => {
            var select = document.getElementById("cidade").getElementsByTagName("select")[0];
            select.innerHTML = "<option selected value=''>Selecione...</option>";

            cidades.forEach(cidade => {
                option = document.createElement("option");
                option.value = cidade['id'];
                option.selected=cidade['id']==city;
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

    var todosPreenchidos = formRequiredVerify(form);

    console.log(todosPreenchidos['inputs']);

    for (const input in todosPreenchidos['inputs']) {
       console.log(input);
    }
    json = {};
    var FormJson = FormSerializer(json,form);
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(FormJson)
    };


    
    fetch("/usuarios", requestOptions)
        .then(response => {

            if (response.ok) {

                response.text().then(mensagem => {
                    InfoModal(mensagem);
                })

            } else {
                
                response.text().then(erro => {
                    InfoModal(erro);
                })

            }


        })

        .then(data => console.log("Data: ", data))
        .catch(error => console.log("Erro: ", error));

}