const formulario = document.getElementById("form")
const campoNome = document.getElementById("nome")
const campoMatricula = document.getElementById("matricula")
const campoEmail = document.getElementById("email")
const campoIdade = document.getElementById("idade")
const salvar = document.getElementById("adicionar")


const pesquisar = document.getElementById("pesquisar")
const listarTodos = document.getElementById("listarTodos")
const campoMatriculaPesquisa = document.getElementById("matriculaPesquisa")

const hiddenTable = document.getElementById("hiddenTable")
const tabela = document.getElementById("myTable")
let tabelaCorpo = document.getElementById("tabela")

let editarIsPressed = false

salvar.addEventListener("click", function(event) {
    event.preventDefault(); 
    
   salvarAluno()

});

function salvarAluno(){
    let nome = campoNome.value;
    let matricula = campoMatricula.value;
    let email = campoEmail.value;
    let idade = campoIdade.value;

    let alunoData = {
        nome: nome,
        matricula: matricula,
        email: email,
        idade: idade
    };

    fetch('http://localhost:8080/aluno/inserir', { 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(alunoData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        else{
            if(editarIsPressed){
                listAll();
                editarIsPressed = false;
            }
        }
        return response.json();
    })
    .then(data => {
        console.log("Resposta da API:", data);
        formulario.reset();
    })
    .catch(error => {
        console.error("Erro ao enviar dados para a API:", error);
    });
}

pesquisar.addEventListener("click", function(event){
    event.preventDefault(); 

    pesquisarPorMatricula()

});

function pesquisarPorMatricula(){
let matricula = campoMatriculaPesquisa.value


    fetch(`http://localhost:8080/aluno/obter/${matricula}`, { 
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        if (Array.isArray(data)) {
            createRows(data);
            hiddenTable.style.display = "block";
        } else {
            createRows([data]);
            hiddenTable.style.display = "block";
        }
    })
    .catch(error => {
        console.error("Erro ao enviar dados para a API:", error);
    });

}

listarTodos.addEventListener("click", function(event){
   listAll();
});

function listAll(){
    fetch('http://localhost:8080/aluno/listar', { 
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        console.log(response);
        return response.json();
    })
    .then(datas => {
        createRows(datas);
        hiddenTable.style = "display: block;"
    })
    .catch(error => {
        console.error("Erro ao enviar dados para a API:", error);
    });
}

function createRows(datas){
    tabelaCorpo.remove(); 
    tabelaCorpo = document.createElement("tbody");
    tabelaCorpo.id = "tabela";

    tabela.appendChild(tabelaCorpo);

    for(let data of datas){
        const tr = document.createElement("tr");
        tr.setAttribute("matricula", data.matricula);
        let arrayData = Object.values(data);
        
        for(let i = 0; i < arrayData.length+1; i++){
            let td = document.createElement("td");

            if(i === arrayData.length){
                let btnEditar = document.createElement("button");
                let btnExcluir = document.createElement("button");

                btnEditar.setAttribute("class","btn btn-secondary");
                btnExcluir.setAttribute("class","btn btn-danger");
                
                btnEditar.innerText = "Editar";
                btnExcluir.innerText = "Excluir";

                btnExcluir.style = "margin: 3px;"

                td.appendChild(btnEditar);
                td.appendChild(btnExcluir);

                tr.appendChild(td);
                tabelaCorpo.append(tr);

                excluirAluno(btnExcluir)

                break;
            }
            td.innerText = arrayData[i];
            tr.appendChild(td);
        }
    }
    
}

function excluirAluno(btnExcluir){

    const tr = btnExcluir.closest("tr");
    const matricula = tr.getAttribute("matricula");

    btnExcluir.addEventListener("click", function(event){
        fetch(`http://localhost:8080/aluno/deletar/${matricula}`, { 
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            console.log(response);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            
            listAll()

        })
        .catch(error => {
            console.error("Erro ao enviar dados para a API:", error);
        });
    
    })

}





