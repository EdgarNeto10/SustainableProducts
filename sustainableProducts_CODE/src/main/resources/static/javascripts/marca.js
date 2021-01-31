var Marca;
window.onload = async function () {
    let prods = document.getElementById("Marca_produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");

    Marca= sessionStorage.getItem("marca");
    try {
        
        //A Chamar os produtos na galeria
        let produtos = await $.ajax({
            url: "/api/categorias/produtos/"+Marca,
            method: "get",
            dataType: "json"
        });
        let html = "";
        let html3 = "";

        for (let prod of produtos)
            html += ` <figure class="gallery-frame" id=${prod.id} ><img class="gallery-img" src="../images/${prod.nome}.jpg" width="600" height="400"><figcaption>${prod.nome} - preço: €${prod.preco}</figcaption></figure>`
        
        prods.innerHTML= html
        
        
        let produtosM = await $.ajax({
            url: "/api/categorias/produtos",
            method: "get",
            dataType: "json"
        });

        let m=[]
        var marc=""
        for (let prod of produtosM){

        if(!m.includes(prod.marca)){
            m.push(prod.marca)
            marc = prod.marca
            html3 += ` <a href="marca.html" onclick='showMarca("${marc}")' > ${marc} </a>`
        }
    }
     marcs.innerHTML= html3
            
    
    
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
   
}

function showMarca(marc) {
    sessionStorage.setItem("marca", marc);
    
   
}
