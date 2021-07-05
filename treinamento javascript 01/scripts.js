const Modal = {
    open(){
        document.querySelector(".modal-overlay").classList.add("active");
        document.body.style.overflow = 'hidden'
    },
    close(){
        document.querySelector(".modal-overlay").classList.remove("active");
        document.body.style.overflow ='initial'
    }
}