const enderecos = {};

ListAllPais();

function ListAllPais(){
    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/paises/76")
        .then(response => response.json())
        .then(paises => {
            var select = document.getElementById("pais").getElementsByTagName("select")[0];
            select.innerHTML = "<option selected value=''>Selecione...</option>";

            paises.forEach(pais => {
                option = document.createElement("option");
                option.value = pais['id']['M49'];
                option.text = pais['nome'];
                select.appendChild(option);

            });       
        });
    
    ListAllEstados();
}

function ListAllEstados(pais=""){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/estados")
        .then(response => response.json())
        .then(paises => {
            var select = document.getElementById("estado").getElementsByTagName("select")[0];
            select.innerHTML = "<option selected value=''>Selecione...</option>";

            paises.forEach(pais => {
                option = document.createElement("option");
                option.value = pais['id'];
                option.text = pais['nome'];
                
                select.appendChild(option);

            });       
        });
    
    ListAllCidades();

}


function ListAllCidades(estado=''){

    fetch ("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado + "/municipios?orderBy=nome")
        .then(response => response.json())
        .then(cidades => {
            var select = document.getElementById("cidade").getElementsByTagName("select")[0];
            select.innerHTML = "<option selected value=''>Selecione...</option>";

            cidades.forEach(cidade => {
                option = document.createElement("option");
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