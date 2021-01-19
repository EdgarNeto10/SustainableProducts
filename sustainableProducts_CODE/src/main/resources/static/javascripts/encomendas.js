window.onload = async function () {
    let prods = document.getElementById("produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");
    let encomenda = document.getElementById("encomendas");
    try {
        
        //A Chamar os produtos na galeria
        let produtos = await $.ajax({
            url: "/api/categorias/produtos",
            method: "get",
            dataType: "json"
        });
       
        let html3 = "";
        var marca = "";
        let m = [];
        for (let prod of produtos){
           
            
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

        //A chamar as encomendas 
        let encomendas = await $.ajax({
            url: "/api/clientes/encomendas",
            method: "get",
            dataType: "json"
        });

        let htmlenc=
        //Header
        `<tr>
        <th>Data da encomenda</th>
        <th>Detalhes da encomenda</th>
        <th>Estado da encomenda</th>
        </tr>`
        

        for (let enc of encomendas){
            // A preencher a tabela coma as informações da encomenda
    
            htmlenc+=

            `<tr>
            <td>${enc.dataenvio}</td>
            <td>Cliente: ${enc.cliente.utilizador.nome} <br> Morada de envio: ${enc.cliente.utilizador.morada} </td>
            <td>${enc.estado}</td>
            </tr>` 

        
        
        }

       
        encomenda.innerHTML=htmlenc;
       
       

       
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


