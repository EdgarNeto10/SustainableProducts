var prodId;
window.onload = async function () {
    ProdId = sessionStorage.getItem("prodId");
    try {
        //A Chamar os produtos
        let produto = await $.ajax({
            url: `/api/categorias/produtos/${prodId}`,
            method: "get",
            dataType: "json"
        });
        let html = "";
        let html3 = "";
        for (let prod of produto.categoriaprodutos) {
            html += ` <figure class="gallery-frame" id=${prod.produto.id} ><img class="gallery-img" src="../images/logoSP.jpg"><figcaption>${prod.produto.nome} - preço: €${prod.produto.preco}</figcaption></figure>`
            //A chamar as marcas
            html3 += ` <a href="#"> ${prod.produto.marca} </a>`

        }

    } catch (err) {
        console.log(err);
        elem.innerHTML = "<h1> Page not available </h1>";
    }
}


async function add() {
    let data = {
        produto: { id: parseInt(produtoId) }
    };
    try {
        let result = await $.ajax({
            url: `/api/carrinhos`,
            method: "post", data: JSON.stringuify(data),
            dataType: "json", contentType: "application/json"
        });
        document.getElementById("result").innerHTML = result.msg;
    } catch (err) { console.log(err); }
}