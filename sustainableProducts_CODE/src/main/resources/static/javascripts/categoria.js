var categoriaId;
window.onload = async function () {
    let prods = document.getElementById("cat_produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");

    categoriaId= sessionStorage.getItem("categoriaId");
    try {
        
        //A Chamar os produtos da categoria selecionada na galeria
        let categoria = await $.ajax({
            url: "/api/produtos/categorias/"+categoriaId,
            method: "get",
            dataType: "json"
        });
        let html = "";
        let html3 = "";
        for (let prod of categoria.categoriaprodutos){   
            html += ` <figure class="gallery-frame" id=${prod.produto.id} ><img class="gallery-img" src="../images/${prod.produto.nome}.jpg" width="600" height="400"><figcaption>${prod.produto.nome} - preço: €${prod.produto.preco}</figcaption></figure>`
            //A chamar as marcas por categoria
            html3 += ` <a href="marca.html"   onclick='showMarca("${prod.produto.marca}")> ${prod.produto.marca} </a>`

        }
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
