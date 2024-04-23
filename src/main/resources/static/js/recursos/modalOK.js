class ModalOK {
    constructor(title, body, closeButtonLabel = 'Close') {
        this.title = title;
        this.body = body;
        this.closeButtonLabel = closeButtonLabel;
        this.modalElement = null;
        this.createModal();
    }

    createModal() {
        // Cria o elemento modal
        this.modalElement = document.createElement('div');
        this.modalElement.classList.add('modal', 'fade');
        this.modalElement.setAttribute('tabindex', '-1');
        this.modalElement.setAttribute('role', 'dialog');
        this.modalElement.setAttribute('aria-labelledby', 'modalTitle');
        this.modalElement.setAttribute('aria-hidden', 'true');

        // Cria o conteúdo do modal
        const modalContent = document.createElement('div');
        modalContent.classList.add('modal-dialog');
        this.modalElement.appendChild(modalContent);

        const modalBody = document.createElement('div');
        modalBody.classList.add('modal-content');
        modalContent.appendChild(modalBody);

        const modalHeader = document.createElement('div');
        modalHeader.classList.add('modal-header');
        modalBody.appendChild(modalHeader);

        const modalTitle = document.createElement('h5');
        modalTitle.classList.add('modal-title');
        modalTitle.setAttribute('id', 'modalTitle');
        modalTitle.textContent = this.title;
        modalHeader.appendChild(modalTitle);

        const modalBodyContent = document.createElement('div');
        modalBodyContent.classList.add('modal-body');
        modalBodyContent.innerHTML = this.body;
        modalBody.appendChild(modalBodyContent);

        const modalFooter = document.createElement('div');
        modalFooter.classList.add('modal-footer');
        modalBody.appendChild(modalFooter);

        const closeButtonFooter = document.createElement('button');
        closeButtonFooter.setAttribute('type', 'button');
        closeButtonFooter.classList.add('btn', 'btn-secondary');
        closeButtonFooter.setAttribute('data-dismiss', 'modal');
        closeButtonFooter.addEventListener('click', () => {
            this.close();
        });
        closeButtonFooter.textContent = this.closeButtonLabel;
        modalFooter.appendChild(closeButtonFooter);

        // Adiciona o modal ao final do body
        document.body.appendChild(this.modalElement);
    }

    open() {
        // Abre o modal
        $(this.modalElement).modal('show');
    }

    close() {
        // Fecha o modal
        $(this.modalElement).modal('hide');
    }

    destroy() {
        // Remove o modal do DOM
        this.modalElement.remove();
    }
}