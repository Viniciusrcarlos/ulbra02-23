<?php

$controller = $_GET['controller'];
$metodo = $_GET['acao'];

$controller .= "Controller";

require_once $_SERVER['DOCUMENT_ROOT'] . '/aula3/controller/'. $controller .'.php';

$objeto = new $controller();
$objeto->$metodo();