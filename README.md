# SustainableProducts
E- commerce de compra de produtos e serviços sustentáveis 

## Autores:

| Número | Nome |
|--------|------|
|  50035284  | Edgar Neto |
|  50036877  | Fábio Costa |

## Enquadramento

Sustentável é um adjetivo para algo que pode ser sustentado, ou seja, algo que é “suportável” e “capaz de ser continuado em um determinado nível”. \
No final das contas, a sustentabilidade pode talvez ser vista como o (s) processo (s) pelo qual algo é mantido em um determinado nível.

No entanto, hoje em dia, devido aos problemas ambientais e sociais que a sociedade enfrenta, a sustentabilidade é comumente utilizada de uma forma específica.\
Portanto, sustentabilidade pode ser definida como os processos e ações por meio dos quais a humanidade evita o esgotamento dos recursos naturais
(que é influenciado pela forma como as sociedades se organizam) para manter um equilíbrio ecológico para que a qualidade de vida da sociedade não diminua.

Uma solução para este problema de esgotamento de recursos naturais são os produtos e serviços sustentáveis, que são aqueles que apresentam o melhor desempenho ambiental 
ao longo de seu ciclo de vida, com função, qualidade e nível de satisfação igual, ou melhor, se comparado com um produto/serviços-padrão.
Isto dito, muitos destes produtos para serem utilizados é necessario uma devida instalação, como por exemplo os painéis solares, para isto pode-se recorrer 
ao que chamamos de serviços sustentáveis para instalação dos mesmos.  

Tendo em conta que a sustentabilidade é um dos assuntos de maior relevância nos últimos anos, por conta de problemas ambientais e sociais que a humanidade vem passando,
pretendemos desenvolver a plataforma E- commerce SustainableProducts que irá facilitar um consumo mais sustentável de produtos e serviços por parte dos utilizadores.\
A plataforma terá como objetivo principal, oferecer os produtos e serviços mais vantajosos para o meio ambiente e de sensibilizar os utilizadores da importância ecológica
do consumo de produtos e serviços que serão fornecidos em relação a outros que utilizam materiais que prejudicam o meio ambiente. 

De acordo a pesquisa de mercado que foi realizada no que toca ao âmbito do projeto, foi verificado que existem ferramentas que possibilitam a compra de produtos sustentáveis.
Plataformas como: [1] Pegada verde, [2] Insane in the rain e a [3] Organiko suportam a compra e vendas de produtos sustentáveis.

Sendo assim, a diferença da plataforma SustainableProducts para com as que foram mencionadas acima é que a SustainableProducts pretende fornecer diferentes tipos serviços sustentáveis 
que serão fornecidos por empresas que são especializadas no desenvolvimento de serviços sustentáveis.

## Interfaces Implementadas

### Produtos
Interface que permite o cliente visualizar os produtos disponíveis.
![Produtos](https://user-images.githubusercontent.com/55880884/109402375-5b87c800-794d-11eb-8645-8ec66710c2e9.png)

### Produto
Interface que permite o cliente visualizar um determinado produto e adicionar ao carrinho.
![Produto](https://user-images.githubusercontent.com/55880884/109402430-b7eae780-794d-11eb-8b4b-10a69e3daf19.png)

### Carrinho
Interface que permite o cliente visualizar os produtos adicionados ao carrinho.
![Carrinho](https://user-images.githubusercontent.com/55880884/109402494-52e3c180-794e-11eb-8782-2221d0f9d3f4.png)

### Finalizar encomendas 
Interface que permite o cliente finalizar a encomenda.
![Finalizar encomenda](https://user-images.githubusercontent.com/55880884/109402562-c08fed80-794e-11eb-8fc1-2ebde1adcf3d.png)

### Aceder encomendas 
Interface que permite o cliente aceder as suas encomendas efetuadas.
![Encomendas_Cliente](https://user-images.githubusercontent.com/55880884/109402604-ffbe3e80-794e-11eb-86e6-2739b3ac7e0e.png)

### Aceder encomendas dos clientes e alterar o estado
Interface que permite o vendedor aceder as encomendas efetuadas e alterar o estado das mesmas.
![Encomendas_vend](https://user-images.githubusercontent.com/55880884/109402647-53c92300-794f-11eb-953e-18d4d664d652.png)



## Casos de utilização:

### Compra de um produto.
**Descrição:** \
O cliente poderá selecionar um produto e efetuar a compra do mesmo.

**Pré-condições:**
- Cliente logado com sucesso.

**Passo a passo:**
1. O cliente na HomePage poderá clicar na categoria de vários produtos.   
1. Depois o sistema irá redirecionar o cliente a lista de produtos da categoria que clicou.
1. O cliente poderá selecionar o  produto que pretende.
1. Depois é redirecionado a uma pagina onde poderá visualizar a descrição detalhada do produto e o respectivo preço.
1. Isto feito, o cliente poderá adicionar o produto ao seu carrinho.
1. Após a visualização dos produtos no carrinho, o cliente pode decidir se apagará um produto ou não do carrinho.
1. Depois o cliente poderá finalizar a compra do produto clicando em "finalizar encomenda".
1. Isto feito, o cliente terá que escolher o transporte do produto que prefere e por fim clicará em "encomendar".

**Pós-condições:**
- São guardados no sistema os dados do cliente, dos produtos no carrinho e da encomenda realizada.
- A cada encomenda realizada, diminui a quantidade do stock de cada produto.
- Carrinho zerado com sucesso.

### Visualização e alteração do estado de encomendas por parte do vendedor.
**Descrição:** \
O vendedor poderá visualizar e alterar o estado das encomendas realizadas por um determinado cliente.

**Pré-condições:**
- Vendedor logado com sucesso.

**Passo a passo:**
1. O vendedor na HomePage poderá clicar na secção de encomendas realizadas pelo cliente.   
1. Depois o sistema irá redirecionar o vendedor para a lista de encomendas em processamento.
1. O vendedor poderá selecionar o estado(nova) de  cada encomenda que pretende alterar.
1. Após clicar em "alterar", o estado da encomenda é alterado.
1. E por fim, a página é actualizada e o estado da coluna "Estado da Encomenda" é actualizado.


**Pós-condições:**
O sistema altera o estado da encomenda (aguarde -> enviada -> entregue).

### Visualização do estado de encomendas efetuadas por parte do cliente.
**Descrição:** \
O cliente poderá visualizar as encomendas e seus respectivos estados.

**Pré-condições:**
- Cliente logado com sucesso.

**Passo a passo:**
1. O cliente na HomePage poderá clicar na secção de encomendas efetuadas.   
1. Depois o sistema irá redirecionar o cliente para lista de encomendas.
1. Por fim, o cliente poderá visualizar o estado das encomendas alteradas pelo vendedor.


**Pós-condições:**
N/A


**Personas**
1. Cliente: responsável por fazer a compra de um produto.
1. Vendedor: responsável por alterar o estado das encomendas dos produtos.

## Block Diagram 
![Block Diagram SustProd](https://user-images.githubusercontent.com/55880884/109402725-0ef1bc00-7950-11eb-98c2-c00d4dd2a77c.png)


## Domain Model
![ClassDiagram](https://user-images.githubusercontent.com/55880884/109402870-4b71e780-7951-11eb-9dd5-fef4049cdcc0.png)





## Referências:
[1]Pegada verde. Acedido em: 31, 10, 2020, em: https://pegadaverde.pt/pt_pt/ \
[2]Insane in the rain. Acedido em: 31, 10, 2020, em: https://insaneintherain.com/ \
[3]Organiko. Acedido em: 31, 10, 2020, em:https://www.organiko.pt/ 

