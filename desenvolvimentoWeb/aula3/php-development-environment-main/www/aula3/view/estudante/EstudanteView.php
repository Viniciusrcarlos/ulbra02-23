<?php $estudantes = $_REQUEST['estudantes']; ?>

<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Lista de Estudantes</title>

</head>

<body class="bg-dark">
    
  <?php require_once $_SERVER['DOCUMENT_ROOT'] . '/'. FOLDER .'/view/navbar.php'; ?>

    <div class="container">
        <div class="row text-center">
            <h2>Semana da acessibilidade</h2>
        </div>

        <div class="text-center">
            <img class="rounded" src="https://cta.ifrs.edu.br/wp-content/uploads/sites/3/2018/12/18_BoasPrativasDescricaoImagens.jpg" alt="Representação grafica de como utilizar a tag alt em uma imagem para pessoas com deficiencia visual.">
        </div>

        <br>
        <a href="http://localhost:8081/<?php echo FOLDER; ?>/?controller=Estudante&acao=salvar" class="btn btn-success">Cadastrar Estudante</a>
        <br>
        <br>

        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Idade</th>
                    <th scope="col">Açãoes</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($estudantes as $estudanteAtual) { ?>
                    <tr>
                        <td><?php echo $estudanteAtual['id']; ?></td>
                        <td><?php echo $estudanteAtual['nome']; ?></td>
                        <td><?php echo $estudanteAtual['idade']; ?></td>
                        <td>
                          <a href="/<?php echo FOLDER; ?>?controller=Estudante&acao=editar&id=<?php echo $estudanteAtual['id']; ?>" class="btn btn-primary">Editar</a>
                          <a href="/<?php echo FOLDER; ?>?controller=Estudante&acao=excluir&id=<?php echo $estudanteAtual['id']; ?>" class="btn btn-primary">Excluir</a>
                        </td>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</body>

</html>