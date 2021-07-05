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

const transactions = [{
    id:1,
    description: 'Luz',
    amount: -50000,
    date: '23/01/2021'
},
{
    id:2,
    description: 'Criação website',
    amount: 200000,
    date: '23/01/2021'
},
{
    id:3,
    description: 'Internet',
    amount: -20000,
    date: '23/01/2021'
}]

const Transaction = {
    incomes() {

    },
    expenses(){

    },
    total(){
        
    }
}