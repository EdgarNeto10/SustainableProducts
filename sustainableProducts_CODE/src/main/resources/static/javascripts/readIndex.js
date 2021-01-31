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




async function readVendedorindex() {


    try {

        // Chamar um determinado cliente e pôr na sessionStorage
        let vendedor = await $.ajax({
            url: "/api/vendedores/2",
            method: "get",
            dataType: "json"
        });
        var option = "";
        option += "<option value='" + vendedor.id + "'>"
                + vendedor.utilizador.nome + "</option>"
        
        selecionar_V.innerHTML = option;
       
    } 

    catch (err) {
        console.log(err);
        prods.innerHTML = "<h1> Page not vailable </h1>";
    }

  
 
   
}



function setIdCliente(){
  window.sessionStorage.setItem('clienteId', selecionar_C.value)
}


function setIdVendedor(){
  window.sessionStorage.setItem('vendedorId', selecionar_V.value)
}