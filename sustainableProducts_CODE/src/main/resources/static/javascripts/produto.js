var produtoId;
var carrinhoId;
var produto;
window.onload = async function () {
    let prods = document.getElementById("produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");

    produtoId= sessionStorage.getItem("produtoId");
    carrinhoId= sessionStorage.getItem("carrinhoId");

 
    
   


    try {
        
        //A Chamar os produtos na galeria
        produto = await $.ajax({
            url: "/api/categorias/produtos/"+produtoId,
            method: "get",
            dataType: "json"
        });
        let html = "";
        let html3 = "";
        var marca = "";
        let m = [];
        /*
        for (let prod of produto){
           
            
            //A chamar as marcas
            
            /*
            if(!m.includes(prod.marca)){
                m.push(prod.marca)
                marca = prod.marca
                html3 += ` <a href="marca.html" onclick='showMarca("${marca}")' > ${marca} </a>`
            }
            

    
            

        }
        */
        html = ` <figure class="gallery-frame" onclick='showProduto (id=${produto.id})' ><img class="gallery-img" src="../images/logoSP.jpg"><figcaption>${produto.nome} - preço: €${produto.preco}</figcaption></figure>`
        marcs.innerHTML = html3;
        prods.innerHTML = html;
            
    
    
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


function showProduto(idprod) {
    sessionStorage.setItem("produtoId", idprod);
    window.location = "produto.html";
}

//Post: Adding a product to cart
async function add() {
    // A verificar primeiro se o produto está disponivel em stock
    if(produto.stock.disponivel){
        let carrid= carrinhoId
        let data = {
            produto: { id: parseInt(produtoId) },
            carrinho:  {carr_id: parseInt(carrid)}
        };
        try {
            let resultt = await $.ajax({
                url: `/api/carrinhos/${carrinhoId}/produtos`,
                method: "post",
                data: JSON.stringify(data),
                dataType: "json", 
                contentType: "application/json"
            });
            document.getElementById("result").innerHTML = "Produdo adicionado ao carrinho com sucesso";
        
        } 

        catch (err) { console.log(err); }
    }
    else 
        document.getElementById("result").innerHTML = "Produdo não disponível em Stock ";

}

/*

//update está a ser calculado no back-end

async function updatecarr() {
  

    try {

         // A chamar produtos no carrinho para calcular o preço total e o quantidade dos produtos
         let carrinho = await $.ajax({
            url: "/api/carrinhos/"+carrinhoId,
            method: "get",
            dataType: "json"
        });

        var total= 0;
        var quant=0;

        for (let prods of carrinho.carrinhoprodutos){
            total+=prods.produto.preco
            quant+=1

        }

         // A fazer o update dos dados no carrinho

        let dataCarr = {
            carr_quant_prod: parseFloat(quant) ,
            carr_preco_total:  parseFloat(total)
        };
        
       
        let result = await $.ajax({
            url: '/api/carrinhos/'+carrinhoId,
            method: "put",
            data: JSON.stringify(dataCarr),
            dataType: "json", 
            contentType: "application/json"
        });

}
catch (err) { console.log(err); }

}
*/
