var carrinhoId;
var carrinho;
var cliente;
var tot;

window.onload = async function () {
    var client_data = document.getElementById("cliente");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");
    let shipping_methods = document.getElementById("envio")
    var produtos_carr = document.getElementById("produtos");
    tot = document.getElementById("total");
    let msgerror = document.getElementById("error")

    



    carrinhoId = sessionStorage.getItem("carrinhoId");

    try {


        //let html = "";
        let html3 = "";
        var marca = "";
        let m = [];

        /*for (let prod of produto){
                  
            //A chamar as marcas
                 
            if(!m.includes(prod.marca)){
                m.push(prod.marca)
                marca = prod.marca
                html3 += ` <a href="marca.html" onclick='showMarca("${marca}")' > ${marca} </a>`
            } 

        }    
        marcs.innerHTML = html3;*/





        //A chamar as categorias 
        let categorias = await $.ajax({
            url: "/api/produtos/categorias",
            method: "get",
            dataType: "json"
        });
        let html2 = "";
        for (let cat of categorias)
            html2 += ` <a href="categoria.html" onclick='showCategoria(${cat.cat_id})' )> ${cat.cat_nome} </a>`


        cats.innerHTML = html2;


        // A chamar os dados do cliente
         cliente = await $.ajax({
            url: "/api/clientes/14",
            method: "get",
            dataType: "json"
        });
        let html4 = "";
        html4 = `<p> Nome: ${cliente.utilizador.nome} <br>Morada de Envio: ${cliente.utilizador.morada}</p> `
        client_data.innerHTML = html4


        // A chamar produtos no carrinho
        carrinho = await $.ajax({
            url: "/api/carrinhos/" + carrinhoId,
            method: "get",
            dataType: "json"
        });
        html5 = "";
     


        for (let prods of carrinho.carrinhoprodutos) {
            html5 += `<p style="font-size: 50px;color: rgb(43, 32, 32) "> <img src="./images/logoSP.jpg" style="width: 100px;height: 100px"> ${prods.produto.nome} - Preço: €${prods.produto.preco}</p>`

        }
       
    


        tot.innerHTML =  `<p style="float: right;">Total: € ${carrinho.carr_preco_total} - ${carrinho.carr_quant_prod} Produtos </p>`
        produtos_carr.innerHTML = html5;
         
    
    }
    catch (err) {
        console.log(err);
        msgerror.innerHTML = "<h1> Page not available </h1>";
    }
}

/*
function calcpreco(){
    let total=0
    let porte = document.getElementById("porte").value
    total = parseFloat(carrinho.carr_preco_total + parseFloat(porte))
    tot.innerHTML =  `<p style="float: right;">Total: € ${total} - ${carrinho.carr_quant_prod} Produtos </p>`

}
*/

function showCategoria(idcat) {
    sessionStorage.setItem("categoriaId", idcat);

}



function showMarca(marc) {
    sessionStorage.setItem("marca", marc);

}


async function encomendar() {
    let porte = document.getElementById("porte").value
 
    now = new Date;

    function dataAtualFormatada() {
        var data = new Date(),
            dia = data.getDate().toString(),
            diaF = (dia.length == 1) ? '0' + dia : dia,
            mes = (data.getMonth() + 1).toString(), //+1 pois no getMonth Janeiro começa com zero.
            mesF = (mes.length == 1) ? '0' + mes : mes,
            anoF = data.getFullYear();
        return anoF + "-" + mesF + "-" + diaF;
    }

  
    let data = {
        dataenvio: dataAtualFormatada(),
        localentrega: "rua lima",
        estado: "Nova",
        precoporte: parseFloat(porte),
        precototal: parseFloat(parseFloat(porte) + carrinho.carr_preco_total)

    };
   

    try {
        let result = await $.ajax({
            url: `/api/clientes/encomendas`,
            method: "post",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json"
        });
        document.getElementById("result").innerHTML = "Encomenda efectuada com sucesso";
    } catch (err) { console.log(err); }
}



