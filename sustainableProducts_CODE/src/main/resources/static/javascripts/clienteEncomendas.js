window.onload = async function() {
    let clienteEncomenda = document.getElementById("clienteEncomendas");
    var vendedorID = sessionStorage.getItem("vendedorId");
    try {
        //A chamar o vendedor
        let vendedor = await $.ajax({
            url: "/api/vendedores/"+vendedorID ,
            method: "get",
            dataType: "json"
        });

        let htmlenc=
        //Header

        `<tr>
        <th>Data da encomenda</th>
        <th>Detalhes da encomenda</th>
        <th>Estado da encomenda</th>
        <th>Alterar estado da encomenda</th>
        </tr>`


        for (let enc of vendedor.encomendas){

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
            <td>Cliente: ${enc.cliente.utilizador.nome} <br> Morada de envio: ${enc.cliente.utilizador.morada} <br> Produtos: ${htmlpro} <br> <p>Preço Total:${enc.precototal}</p> </td>
            <td>${enc.estado}</td>
            <td> 
               <select  id="${enc.id}">
                 <option value="Aguarde">Aguarde</option>
                 <option value="Enviada">Enviada</option>
                 <option value="Entregue">Entregue</option>
                 
               </select>
          <br><br>
          <input type="Button" value="Alterar" onclick="alterar(${enc.id})">
            </tr>` 



        }


        clienteEncomenda.innerHTML=htmlenc;
      




    } 

    catch (err) {
        console.log(err);
        prods.innerHTML = "<h1> Page not vailable </h1>";
    }




}

// Update estado de uma deteminada encomenda
async function alterar(id) {
    let estado= document.getElementById(id).value

    let data = {
        estado: estado
    }

    try {
        
        let result = await $.ajax({
            url: `/api/clientes/encomendas/`+id,
            method: "put",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json"
        });

        location.reload(); 

    }
    catch (err) {
        console.log(err);
    }



}
    
