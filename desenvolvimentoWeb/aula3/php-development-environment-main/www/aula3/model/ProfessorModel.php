<?php

require_once $_SERVER['DOCUMENT_ROOT'] . '/'. FOLDER .'/database/Database.php';

class ProfessorModel
{
    private int $idade;

    private string $nome;

    private $database;

    //Getters and setters

    public function __construct()
    {
        $this->database = new Database();
    }

    public function listarModel(): array
    {
        //$array = array();
        //$array = [];

        $dadosArray = $this->database->select("SELECT * FROM professores");
        
        return $dadosArray;
    }

    public function salvarModel(string $nome, int $idade)
    {
        $sql = "INSERT INTO professores (nome, idade) values ('$nome', '$idade')";
        $this->database->insert($sql);
    }
}