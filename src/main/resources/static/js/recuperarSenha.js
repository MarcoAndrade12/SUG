
function RecuperarSenha(){

    var ok = new Buttom("Solicitar Senha", ["success", "btn", "width-content"], "submit", [], null, true)
    var cancelar = new Buttom("Cancelar", ["danger", "btn", "width-content"], "button", [], Cancelar,true)

    var form = new Input(
        type="email",
        placeholder="Digite aqui seu email de recuperação",
        required = true
    );

    modal = new Modal("Poxa! Você parece ter esquecido sua senha.. Recupere-a logo!",[ok, cancelar], true, form, "/login?oi=1","get",["jc","ac","txt-center"]);
    modal.Render();

}

function SolicitarSenha() {
    console.log("solicitar senha");
}

function Cancelar(){
    console.log("Cancelaaado");
}