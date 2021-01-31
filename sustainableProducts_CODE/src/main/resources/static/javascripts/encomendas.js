window.onload = async function () {
    let prods = document.getElementById("produtos");
    let cats = document.getElementById("categorias");
    let marcs = document.getElementById("marcas");
    let encomenda = document.getElementById("encomendas");
    var clienteID = sessionStorage.getItem("clienteId");
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

        //A chamar o cliente
        let cliente = await $.ajax({
            url: "/api/clientes/"+clienteID ,
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
        

    
       for (let enc of cliente.encomendas){
                  // Percorrer a lista antes para inserir os produtos em uma string; 
            htmlpro=''
            var c=1
            for (let prods of enc.encomendaprodutos){
                htmlpro+= `${prods.produto.nome}`
                if(c<enc.encomendaprodutos.length){
                htmlpro+= ', '
                }
               
                else{
                htmlpro+='.'
                }
                c++

            }
            // A preencher a tabela coma as informações da encomenda
            htmlenc+=

            `<tr>
            <td>${enc.dataenvio}</td>
            <td>Cliente: ${cliente.utilizador.nome} <br> Morada de envio: ${cliente.utilizador.morada} <br> Produtos: ${htmlpro} <br> <p>Preço Total:${enc.precototal}</p>  </td>
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


