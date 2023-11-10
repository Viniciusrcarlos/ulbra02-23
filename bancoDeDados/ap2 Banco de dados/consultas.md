1 - Relatório que efetue uma busca por geolocalização (clientes ou restaurantes).
// 


2 - Relatório de busque todos os pedidos por cliente.
{
    "idCliente": "653c54381aeaad55307b7644"
}

3 - Relatório que mostra todos os pedidos por cliente, mostrando os itens pertencentes ao pedido.
{
  "$lookup": {
    "from": "itensPedido",
    "localField": "_id",
    "foreignField": "idPedido",
    "as": "itens"
  }
}

4 - Relatório que busque pedidos por períodos definidos (data de inicio e fim)
{
  "dataPedido": {
    "$gte": {
      "$date": "2023-01-01T00:00:00.000Z" //data inicio
    },
    "$lte": {
      "$date": "2023-01-31T23:59:59.999Z"  //data fim
    }
  }
}


5 - Relatório que mostra uma lista de todos os clientes com o total de pedidos

{
  "$lookup": {
    "from": "pedidos",
    "localField": "_id",
    "foreignField": "idCliente",
    "as": "pedidos"
  }
},
{
    "$project": {
    "nome": 1,
    "totalPedidos": { "$size": "$pedidos" }
   }
}
