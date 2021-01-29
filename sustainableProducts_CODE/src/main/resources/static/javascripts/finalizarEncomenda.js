var carrinhoId;
var carrinho;
var cliente;
var tot;
var res = ""
var results;


window.onload = async function () {
    var client_data = document.getElementById("cliente");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");
    let shipping_methods = document.getElementById("envio")
    var produtos_carr = document.getElementById("produtos");
    tot = document.getElementById("total");
    let msgerror = document.getElementById("error")
    results = document.getElementById("result");


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




        tot.innerHTML = `<p style="float: right;">Total: € ${carrinho.somaTotal} - ${carrinho.quantidadeProds} Produtos </p>`
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

//Função para enviar os dados relacionados a encomenda
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
        localentrega: cliente.utilizador.morada,
        estado: "Nova",
        precoporte: parseFloat(porte),
        precototal: parseFloat(parseFloat(porte) + carrinho.somaTotal),
        cliid: parseInt(cliente.cli_id),
        vendid: parseInt(2) // As encomendas vão para o unico vendedor presente na plataforma

    };

    try {

        let result = await $.ajax({
            url: `/api/clientes/encomendas`,
            method: "post",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json"
        });

        saveEncomenda();
        res += "Encomenda efectuada com sucesso -> ";
        results.innerHTML = res

    } catch (err) { console.log(err); }
}


//Função para salvar os produtos do carrinho na encomenda. 
async function saveEncomenda() {


    try {
        let encomendas = await $.ajax({
            url: "/api/clientes/encomendas",
            method: "get",
            dataType: "json"
        });

        // A pegar o id da ultima encomenda, calculando o maior id na lista.
        for (let enc of encomendas) {
            var id = 0
            if (enc.id > id) {
                id = enc.id
            }

        }

        // A pegar os produtos no carrinho do cliente.
        let carrinho = await $.ajax({
            url: "/api/carrinhos/" + carrinhoId,
            method: "get",
            dataType: "json"
        });

        // A percorrer a lista de produtos no carrinho, para inserir cada produto na encomenda.
        for (let carr of carrinho.carrinhoprodutos) {

            var datacarr = {
                produto: { id: parseInt(carr.produto.id) },
                encomenda: { id: parseInt(id) }
            };



            let result = await $.ajax({
                url: `/api/clientes/encomendas/produtos`,
                method: "post",
                data: JSON.stringify(datacarr),
                dataType: "json",
                contentType: "application/json"
            });


            // Update o stock de cada produto da encomenda realizada
            let updateQtd = carr.produto.stock.quantidade - 1;
            let dataStock = {
                quantidade: updateQtd 

            }

            await $.ajax({
                url: `/api/categorias/produtos/${carr.produto.id}/stocks/${carr.produto.stock.id}`,
                method: "put",
                data: JSON.stringify(dataStock),
                dataType: "json",
                contentType: "application/json"
            });


        }
        deleteAllProducts();
        res += "Produtos da encomenda salvos com sucesso -> ";
        results.innerHTML = res





    }
    catch (err) { console.log(err); }



}



// Função para apagar todos os produtos no carrinho
async function deleteAllProducts() {

    try {

        await $.ajax({
            url: "/api/carrinhos/produtos/" + carrinhoId,
            method: "delete",
            dataType: "json"
        });

        res += "Carrinho zerado com sucesso";
        results.innerHTML = res

    }
    catch (err) { console.log(err); }



}




