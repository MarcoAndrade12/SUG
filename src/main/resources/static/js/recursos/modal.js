
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

    classes = [];
    menssage;
    color;
    self;
    buttons = [];

    constructor(buttons=[new Buttom()], classes = ["modal-box"], color="white", menssage="Hello") {
        this.classes = this.classes.concat(classes);
        this.buttons = this.buttons.concat(buttons);
        this.color = color;
        this.menssage = menssage;
        this.setSelf();
    }

    setSelf(){
        var modalbox = document.createElement("div");
        modalbox.classList.add(this.classes);
        modalbox.style.zIndex = 1001;
        modalbox.style.backgroundColor = this.color;
        modalbox.style.padding = "1rem";
        modalbox.style.display = "flex";
        modalbox.style.flexDirection = "column";
        modalbox.style.justifyContent = "space-between";
        modalbox.style.alignItems = "center"
        modalbox.style.gap = "1rem";
        
        var msg = document.createElement("label");
        msg.classList.add("msg-model");
        msg.innerText = this.menssage;

        var buttons = document.createElement("div");
        modalbox.appendChild(msg);

        this.buttons.forEach(button => {
            modalbox.appendChild(button.getSelf());
        });


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

    constructor(text="Butão", styles=["success", "btn"], type="buttom", classes=["btn"], onclick=hello){
        this.classes.concat(classes);
        this.text = text;
        this.type = type;
        this.onclick = onclick;
        this.styles = this.styles.concat(styles);
        this.setSelf();
    }
    
    setSelf(){
        var buttom = document.createElement("button");

        this.styles.forEach(style => {
            buttom.classList.add(style);
        });

        // buttom.classList.add(this.styles);
        buttom.type = this.type;
        buttom.onclick = this.onclick;
        
        buttom.innerText = this.text;

        this.self = buttom;

    }

    getSelf(){
        return this.self;
    }



}


class Modal {

    background;
    modalBox;
    buttons = [];
    
    constructor(mensagem="Hello World!!", buttons = []){
        this.modalBox = new ModalBox();
        this.background = new BackGroundModal(this.modalBox);
        
    }

    GetBackground(){
        return this.background;
    }

    Render(){
        document.body.appendChild(this.background.getSelf())
    }
    



}

function hello(){
    console.log("Hello World");
}