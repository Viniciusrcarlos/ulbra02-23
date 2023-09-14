<?php $estudante = $_REQUEST['estudante']; ?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <title>Editar estudantes</title>
</head>

<body class="bg-dark">

  <?php require_once $_SERVER['DOCUMENT_ROOT'] . '/'. FOLDER .'/view/navbar.php'; ?>

    <br>
    <div class="container">
        <form method="POST" action="/<?php echo FOLDER; ?>/?controller=Estudante&acao=editar&id=<?php echo $estudante['id']; ?>">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" value="<?php echo $estudante['nome']; ?>">
        </div>
        <div class="mb-3">
            <label for="Idade" class="form-label">Idade</label>
            <input type="number" class="form-control" id="Idade" name="idade"value="<?php echo $estudante['idade']; ?>">
        </div>
        <button type="submit" class="btn btn-primary">Editar</button>
        </form>
    </div>
</body>

</html>