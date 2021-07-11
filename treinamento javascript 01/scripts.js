
// ========= MODAL DO FORMULÁRIO ========
const Modal = {
  open() {
    document.querySelector(".modal-overlay").classList.add("active");
    document.body.style.overflow = "hidden";
  },
  close() {
    document.querySelector(".modal-overlay").classList.remove("active");
    document.body.style.overflow = "initial";
  },
};

// ===============  consumindo api ==============
async function getFinancy() {
  try {
    const response = await fetch("http://localhost:8080/financas/1");
    const data = await response.json();
    show(data.transacoes)
    calcTransactions(data.transacoes)
  } catch (error) {
    console.log(error);
  }
}

function deleteTransaction(id){
     fetch(`http://localhost:8080/transacoes/${id}`, {
        method: 'DELETE', 
        headers: {
          'Content-Type': 'application/json'
        },
        body: null
    }).then(() => {
        document.location.reload()
        
    });
 };


getFinancy();
// ========= POPULAR TABELA ========= 
function show(transactions) {
  let output = "";
  let transactionFormat = ""
  for (let transaction of transactions) {
      if(transaction.valorTransacao<0){
          transactionFormat = "transaction__expense"
      }else{
        transactionFormat = "transaction__income"
      }
    output += `
    <tr>
      <td class="transaction__description">${transaction.descricao}</td>
      <td class=${transactionFormat}>${Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(transaction.valorTransacao)}</td>
      <td class="transaction__date">${moment(transaction.data).format('L')}</td>
      <td>
        <img
            id="delete"
          src="./assets/minus.svg"
          alt="imagem de simbolo negativo"
          onclick = "deleteTransaction(${transaction.id})"
        />
      </td>
    </tr>
`;
  }
  document.querySelector('tbody').innerHTML = output;
}

// ========= EXIBIR ENTRADAS SAIDAS E TOTAL =========
function calcTransactions(transacactions){
    let calcEntrada = 0;
    let calcSaida = 0;
    let total = 0;
    for (let transaction of transacactions) {
        if(transaction.valorTransacao>0){
            calcEntrada+=transaction.valorTransacao;
        }
        else{
            calcSaida+=(-1*(transaction.valorTransacao))
        }
    }
    total = calcEntrada - calcSaida;
    document.querySelector('#enter').textContent = `${Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(calcEntrada)}`
    document.querySelector('#left').textContent = `${Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(calcSaida)}`
    document.querySelector('#total').textContent = `${Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(total)}`
}
