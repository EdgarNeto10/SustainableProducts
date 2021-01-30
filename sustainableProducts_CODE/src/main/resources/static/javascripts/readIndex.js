//|----------Variaveis globais----------|
var selecionar;
var vendedor;
//---------------------------------------

window.onload =  function () {
    selecionar_C= document.getElementById('selectCliente');
    selecionar_V= document.getElementById('selectVendedor');
    readClienteindex();
    readVendedorindex();
    
   
}

  
//  Functions

// Esta função pega os dados de todos atletas e insere os seus nomes em um select.  

  async function readClienteindex() {


    try {

        // Chamar um determinado cliente e pôr na sessionStorage
        let cliente = await $.ajax({
            url: "/api/clientes/14",
            method: "get",
            dataType: "json"
        });
        var option = "";
        option += "<option value='" + cliente.cli_id + "'>"
                  + cliente.utilizador.nome + "</option>"
          
        selecionar_C.innerHTML = option;
       
    } 
      
    catch (err) {
        console.log(err);
        prods.innerHTML = "<h1> Page not vailable </h1>";
    }
  

}


// Esta função pega os dados de todos membros da staff e insere os seus nomes em um select.  

async function readVendedorindex() {


    try {

        // Chamar um determinado cliente e pôr na sessionStorage
        let vendedor = await $.ajax({
            url: "/api/vendedores/2",
            method: "get",
            dataType: "json"
        });
        var option = "";
        option += "<option value='" + vendedor.vend_id + "'>"
                + vendedor.utilizador.nome + "</option>"
        
        selecionar_V.innerHTML = option;
       
    } 

    catch (err) {
        console.log(err);
        prods.innerHTML = "<h1> Page not vailable </h1>";
    }

  
 
   
}




//Esta função pega o nome de um determinado atleta e mostra na pagina.
/*
function readAtletasNomes() {
  $.ajax({
      url: '/api/atletas/'+sessionStorage.getItem('atletaId'),
      method: 'get',
      contentType: "application/json", // sending in json
      dataType: "json",// receiving in json
      success: function (res, status) {
          var html = "";

          nomes = res
          for (i in nomes) {
              html += '<li>' + nomes[i].atleta_nome + '</li>'

          }

          nome.innerHTML = html;
      },
      error: function () {

      }
  })

}*/


//--------------Session Storage------------//


// Esta função guarda o id do atleta no session storage das paginas.
function setIdCliente(){
  window.sessionStorage.setItem('clienteId', selecionar_C.value)
}

// Esta função guarda o id da staff no session storage das paginas.
function setIdVendedor(){
  window.sessionStorage.setItem('vendedorId', selecionar_V.value)
}