<?php
// Constantes
define("nome", "Vinicius Raupp");
define("idade", 20);
define("altura", 1.79);
define("times", ['Internacional','gremio', 'Caxias', 'pelotas']);

echo 'Meu nome é '.nome.' tenho '.idade.' e minha altura é '.altura;
echo "<hr>";
echo times[0];
echo "<hr>";

function exibeNome(){
    echo nome;
}

exibeNome();


?>