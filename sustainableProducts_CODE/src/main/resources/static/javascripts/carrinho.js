
var carrinhoId;
window.onload = async function () {
    let produtos_carr = document.getElementById("produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");
    let tot = document.getElementById("total");

  
    carrinhoId= sessionStorage.getItem("carrinhoId");
   


    try {
        
        //A Chamar os produtos na galeria
        let produto = await $.ajax({
            url: "/api/categorias/produtos/",
            method: "get",
            dataType: "json"
        });
        //let html = "";
        let html3 = "";
        var marca = "";
        let m = [];
        
        for (let prod of produto){
                  
            //A chamar as marcas
                 
            if(!m.includes(prod.marca)){
                m.push(prod.marca)
                marca = prod.marca
                html3 += ` <a href="marca.html" onclick='showMarca("${marca}")' > ${marca} </a>`
            } 

        }    
        marcs.innerHTML = html3;
   
            
    
    
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


        // A chamar produtos no carrinho
        let carrinho = await $.ajax({
            url: "/api/carrinhos/"+carrinhoId,
            method: "get",
            dataType: "json"
        });
        let html4 = "";
        let total= 0;
        let quant=0

        for (let prods of carrinho.carrinhoprodutos){
            html4 += `<p style="font-size: 50px;color: rgb(43, 32, 32) "> <img src="./images/logoSP.jpg" style="width: 100px;height: 100px"> ${prods.produto.nome} - Preço: €${prods.produto.preco}</p>`

            // A calcular o preço total do carrinho
            total+=prods.produto.preco
            quant+=1
        }

        tot.innerHTML =  `<p style="float: right;">Total: € ${total} - ${quant} Produtos </p>`
        produtos_carr.innerHTML = html4;



    
    
    
    } 
      
    catch (err) {
        console.log(err);
        prods.innerHTML = "<h1> Page not vailable </h1>";
    }
}



function showCategoria(idcat) {
    sessionStorage.setItem("categoriaId", idcat);
    //window.location = "categoria.html";
}



function showMarca(marc) {
    sessionStorage.setItem("marca", marc);
    
}


/*
function showProduto(idprod) {
    sessionStorage.setItem("produtoId", idprod);
    window.location = "produto.html";
}
*/