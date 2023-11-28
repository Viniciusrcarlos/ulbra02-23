const express = require('express')
const mysql = require ('mysql2')

const app = express()
const port = 3000 // porta


const dataBaseMysql = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'1q2w3e4r5t',
    database:'node'
})


dataBaseMysql.connect((err) => {
    if (err) {
        console.error("Erro ao conectar", err.stack)
        return
    }
    console.log("Conectado!!")
})

app.use(express.json())


app.get('/produtos', (req, res) => {
    dataBaseMysql.query('SELECT * FROM produtos', (err, result) =>{
        if (err) {
            res.status(500).send('Erro ao executar consulta')
        } else {
            res.json(result)
        }
    })
})

app.post('/produtos', (req, res) => {
    const registro = {
        descricao : req.body.descricao,
        preco : req.body.preco,
        nome_categoria : req.body.nome_categoria,
        descricao_categoria : req.body.descricao_categoria
    }

    dataBaseMysql.query('INSERT INTO produtos SET ?', registro, (err, result) => {
        if (err) {
            res.status(500).send('Erro')
        } else {
            res.json(result)
        }
    })
})

app.listen(port, () => {
    console.log("StartApi")
})