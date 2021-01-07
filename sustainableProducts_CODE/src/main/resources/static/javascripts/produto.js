var produtoId;
var carrinhoId;
window.onload = async function () {
    let prods = document.getElementById("produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");

    produtoId= sessionStorage.getItem("produtoId");
    carrinhoId= sessionStorage.getItem("carrinhoId");


    try {
        
        //A Chamar os produtos na galeria
        let produto = await $.ajax({
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
        html += ` <figure class="gallery-frame" onclick='showProduto (id=${produto.id})' ><img class="gallery-img" src="../images/logoSP.jpg"><figcaption>${produto.nome} - preço: €${produto.preco}</figcaption></figure>`
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
    let carrid= carrinhoId
    let data = {
        produto: { id: parseInt(produtoId) },
        carrinho:  {carr_id: parseInt(carrid)}
    };
    try {
        let result = await $.ajax({
            url: `/api/carrinhos/${produtoId}/produtos`,
            method: "post",
            data: JSON.stringify(data),
            dataType: "json", 
            contentType: "application/json"
        });
        document.getElementById("result").innerHTML = "Produdo adicionado ao carrinho com sucesso";
    } catch (err) { console.log(err); }
}

