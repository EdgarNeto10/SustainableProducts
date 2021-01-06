window.onload = async function () {
    let prods = document.getElementById("produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");
    try {
        
        //A Chamar os produtos na galeria
        let produtos = await $.ajax({
            url: "/api/categorias/produtos",
            method: "get",
            dataType: "json"
        });
        let html = "";
        let html3 = "";
        for (let prod of produtos){
            html += ` <figure class="gallery-frame" id=${prod.id} ><img class="gallery-img" src="../images/logoSP.jpg"><figcaption>${prod.nome} - preço: €${prod.preco}</figcaption></figure>`
            //A chamar as marcas
            html3 += ` <a href="#"> ${prod.marca} </a>`

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
