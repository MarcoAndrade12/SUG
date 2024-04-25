function popularList(json, list) {

    if (!json) {
        console.log(list + " Não foi populada com nada");
        return null;
    }

    var lista = document.getElementById(list);
    lista.children = "";

    json.forEach(nome => {
        var option = document.createElement("option");
        option.value = nome;
        lista.appendChild(option);
    });
}

function GET(URL) {
    var responseFinal = null;

    const requestOptions = {
        method: 'GET'
    };

    fetch(URL, requestOptions)
            .then(response => {
                if (response.ok) {
                    response.text().then(
                        resp => {
                            responseFinal = resp;
                        }
                    )
                } else {
                    console.log("Erro no GET: " + URL);
                }
            })
            .catch(error => {
                console.log("ERRO: " + error);
            })
    return responseFinal;
}

function PopularNomesComuns() {

    var nome_comum = document.getElementById("nome_comum");
    var especie = document.getElementById("especie");
    var genero = document.getElementById("genero");
    var familia = document.getElementById("familia");

    if (especie.value != "") {
        console.log("Populando nome_comum por especie: " + especie.value);
        popularList(GET("/coletas/nomes_comuns?especie=" + especie.value), "nome_comum_list");
    } else if (genero.value != "") {
        console.log("Populando nome_comum por genero: " + genero.value);
        popularList(GET("/coletas/nomes_comuns?genero=" + genero.value), "nome_comum_list");
    } else if (familia.value != "") {
        console.log("Populando nome_comum por familia: " + familia.value);
        popularList(GET("/coletas/nomes_comuns?familia=" + familia.value), "nome_comum_list");
    } else {
        console.log("Populando nome_comum");
        popularList(GET("/coletas/nomes_comuns"), "nome_comum_list");
    }
    
    
    AttNomeColeta()
}

function AttNomeColeta(){
    var especie = document.getElementById("especie").value;
    var genero = document.getElementById("genero").value;
    var familia = document.getElementById("familia").value;
    
    var nomeColeta = document.getElementById("nomeColeta");
    nomeColeta.text = familia + " " + genero + " " + especie

}

function NovoCampoColeta() {
    console.log("Hello");
}


PopularNomesComuns();