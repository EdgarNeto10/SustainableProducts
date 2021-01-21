window.onload = async function() {
    let clienteEncomenda = document.getElementById("clienteEncomendas");
    try {
        //A chamar as encomendas 
        let clienteencomendas = await $.ajax({
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
        <th>Alterar estado da encomenda</th>
        </tr>`


        for (let enc of clienteencomendas){

            // Percorrer a lista antes para inserir os produtos em uma string; 
            htmlpro=''

            for (let prods of enc.encomendaprodutos){
                htmlpro += `${prods.produto.nome}`;
            }

            // A preencher a tabela coma as informações da encomenda
            htmlenc+=

            `<tr>
            <td>${enc.dataenvio}</td>
            <td>Cliente: ${enc.cliente.utilizador.nome} <br> Morada de envio: ${enc.cliente.utilizador.morada} </td>
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

    }
    catch (err) {
        console.log(err);
    }
}
    
