<?php

// Escalares

//string
$nome = "Vinicius 321 @#!";
var_dump($nome);

if (is_string($nome)):
	echo "É uma string";
else:
	echo "Não é uma string";
endif;
echo "<hr>";

// int
$idade = 20;
var_dump($idade);
if (is_int($idade)):
	echo "É inteiro";
else:
	echo "Não é inteiro";
endif;
echo "<hr>";

// float
$altura = 1.777;
var_dump($altura);
if (is_float($altura)):
	echo "É float";
else:
	echo "Não é float";
endif;
echo "<hr>";

// boolean
$admin = false;
var_dump($admin);
if (is_bool($admin)):
	echo "É boolean";
else:
	echo "Não é boolean";
endif;
echo "<hr>";

/********* compostos **********/
//array
$carros = array("gol", "uno", "Fox", 12, 20.6);
var_dump($carros);
if (is_array($carros)):
	echo "É array";
else:
	echo "Não é array";
endif;
echo "<hr>";

//object
class Cliente {
	public $nome;
	public function atribuirNome($nome){
		$this->$nome = $nome;
	}
}

$cliente = new Cliente();
$cliente->atribuirNome("Vinicius");
var_dump($cliente);
if (is_object($cliente)):
	echo "É um objeto";
else:
	echo "Não é objeto";
endif;
echo "<hr>";

// null
$cidade = null;
var_dump($cidade);
if (is_null($cidade)):
	echo "É null";
else:
	echo "Não é null";
endif;
echo "<hr>";



?>