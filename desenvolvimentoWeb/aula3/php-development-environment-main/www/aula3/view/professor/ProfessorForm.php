<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <title>Cadastro de Professor</title>
</head>

<body>

  <?php require_once $_SERVER['DOCUMENT_ROOT'] . '/' . FOLDER . '/view/navbar.php'; ?>

  <br>
  <div class="container">
    <form method="POST" action="/<?php echo FOLDER; ?>/?controller=Professor&acao=salvar">
      <div class="mb-3">
        <label for="nome" class="form-label">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome">
      </div>
      <div class="mb-3">
        <label for="Idade" class="form-label">Idade</label>
        <input type="number" class="form-control" id="Idade" name="idade">
      </div>
      <button type="submit" class="btn btn-primary">Salvar</button>
    </form>
  </div>
</body>

</html>