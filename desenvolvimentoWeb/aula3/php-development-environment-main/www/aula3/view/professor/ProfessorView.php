<?php $professores = $_REQUEST['professores']; ?>

<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Lista de Professores</title>

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
        <a href="http://localhost:8081/<?php echo FOLDER; ?>/?controller=Professor&acao=salvar" class="btn btn-success">Cadastrar Professor</a>
        <br>
        <br>

        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Idade</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($professores as $professorAtual) { ?>
                    <tr>
                        <td><?php echo $professorAtual['id']; ?></td>
                        <td><?php echo $professorAtual['nome']; ?></td>
                        <td><?php echo $professorAtual['idade']; ?></td>
                        <td>
                          <a href="/<?php echo FOLDER; ?>?controller=Professor&acao=editar&id=<?php echo $professorAtual['id']; ?>" class="btn btn-primary">Editar</a>
                          <a href="/<?php echo FOLDER; ?>?controller=Professor&acao=excluir&id=<?php echo $professorAtual['id']; ?>" class="btn btn-primary">Excluir</a>
                        </td>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
</body>

</html>