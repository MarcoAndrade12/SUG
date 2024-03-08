
class BackGroundModal {

    color;
    visible;
    self;
    modalbox;

    constructor(modalbox = new Modal(), color='#59ff0a7a', visible=true){
        this.color = color;
        this.visible = visible;
        this.modalbox = modalbox;
        this.setSelf();
    }


    setSelf(){

        var background = document.createElement('div');
        
        if (!this.visible){
            background.style.display = "none";
        }

        background.classList.add("background-modal");
        background.style.position = "absolute";
        background.style.display = "flex";
        background.style.flexDirection = "column"
        background.style.zIndex = 1000;
        background.style.backgroundColor = this.color;
        background.style.justifyContent = "center";
        background.style.alignItems = "center";
        background.appendChild(this.modalbox.getSelf());
        this.self = background;
    }
    
    getSelf(){
        return this.self;
    }


}

class ModalBox {

    classes = ["modal-box"];
    isForm;
    action;
    method;
    menssage;
    color;
    self;
    buttons = [];

    constructor(buttons=[new Buttom("Butão")], isForm=false, formulario="", action="#", method="post", menssage="Hello", classes = ["modal-box"], color="white") {
        this.classes = this.classes.concat(classes);
        this.buttons = this.buttons.concat(buttons);
        this.color = color;
        this.menssage = menssage;
        this.isForm = isForm;
        this.action = action;
        this.method = method;
        this.formulario = formulario;
        this.setSelf();
    }

    setSelf(){
        if (this.isForm) {
            var modalbox = document.createElement("form");
            modalbox.method = this.method;
            modalbox.action = this.action;
        } else {
            var modalbox = document.createElement("div");
        }
 
        this.classes.forEach(classe => {
            modalbox.classList.add(classe);
            console.log(classe);
        });

        modalbox.style.zIndex = 1001;
        modalbox.style.backgroundColor = this.color;
        modalbox.style.padding = "1rem";
        modalbox.style.display = "flex";
        modalbox.style.flexDirection = "column";
        modalbox.style.justifyContent = "space-between";
        modalbox.style.alignItems = "center"
        modalbox.style.gap = "5px";
        
        var msg = document.createElement("label");
        msg.classList.add("msg-model");
        msg.innerText = this.menssage;
        modalbox.appendChild(msg);
        
        console.log(this.formulario);

        if(this.isForm) {
            modalbox.appendChild(this.formulario.getSelf());
        }

        var buttons = document.createElement("div");
        buttons.style.display = "flex";
        buttons.style.flexDirection = "row";    


        this.buttons.forEach(button => {
            buttons.appendChild(button.getSelf());
        });

        modalbox.appendChild(buttons);

        this.self = modalbox;
    }

    getSelf(){
        return this.self;
    }

}



class Buttom {

    classes = [];
    type;
    self;
    styles = [];
    text;
    onclick;

    constructor(text="Butão", styles=["success", "btn"], type="buttom", classes=["btn"], onclick=hello, closeModel=true){
        this.classes.concat(classes);
        this.text = text;
        this.type = type;

        if (closeModel){
            this.onclick = function() {
                Modal.closeModel(onclick);
            }

        } else {
            this.onclick = onclick;
        }

        this.styles = this.styles.concat(styles);
        this.setSelf();
    }
    
    setSelf(){
        var buttom = document.createElement("button");

        this.styles.forEach(style => {
            buttom.classList.add(style);
        });

        buttom.type = this.type;
        buttom.onclick = this.onclick;
        
        buttom.innerText = this.text;

        this.self = buttom;

    }

    getSelf(){
        return this.self;
    }

}

class Input {

    classes = [];
    placeholder = "Um Input";
    type = "text";
    required = false;
    self;

    constructor(type= "text", placeholder = "Um Input", required = false, classes=["input-text", "input-modal"]){
        this.self = document.createElement("input");

        classes.forEach(classe => {
            this.self.classList.add(classe);
        });

        this.self.type = type;
        this.self.placeholder = placeholder;
        this.self.required = required;
    }

    getSelf(){
        return this.self;
    }

    toString(){
        return this.self;
    }

}


class Modal {

    static background;
    static modalBox;
    buttons = [];
    
    constructor(mensagem="Hello World!!", buttons = [new Buttom()], form=false, formulario=null, action="#", method="post", modalClasses=["modal-box"], colorModal="white",backgroundColor="#59ff0a7a"){
        Modal.modalBox = new ModalBox(buttons, form, formulario, action, method, mensagem,  modalClasses, colorModal);
        Modal.background = new BackGroundModal(Modal.modalBox, backgroundColor);
    }

    GetBackground(){
        return Modal.background;
    }

    Render(){
        document.body.appendChild(Modal.background.getSelf())
    }
    

    static closeModel(functi){
        if (Modal.background) {
            functi();
            this.background.self.remove();
        }
    }

}

function hello(){
    console.log("Hello World");
}