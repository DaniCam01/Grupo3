<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

    <button type="button" class="btn" data-toggle="modal" data-target="#ModalA�adirAlumno"><img class=""
            src="img/boton.png" alt=""></button>
    <button type="button" class="btn" data-toggle="modal" data-target="#ModalA�adirCurso"><img class=""
            src="img/boton.png" alt=""></button>


    <div class="row">

        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
            <div class="card bg-dark px-1 py-1">
                <img class="card-img-top px-4 py-1 bg-light" src="img/icono.png" alt="">
                <div class="row card-body text-light">
                    <div class="col-9">
                        <h4 class="card-title">Pedro Garcia Nobillo</h4>
                        <p class="card-text">Mail: pedrogn@gmail.com</p>
                        <p class="card-text">Telefono: 654321698</p>
                        <p class="card-text">Curso: 2019-2021</p>
                    </div>
                    <div class="col-3">
                        <button type="button" class="btn" data-toggle="modal" data-target="#exampleModal"><img class=""
                                src="img/basura.png" alt=""></button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
            <div class="card bg-dark px-1 py-1">
                <img class="card-img-top px-4 py-1 bg-light" src="img/icono.png" alt="">
                <div class="row card-body text-light">
                    <div class="col-9">
                        <h4 class="card-title">Pedro Garcia Nobillo</h4>
                        <p class="card-text">Mail: pedrogn@gmail.com</p>
                        <p class="card-text">Telefono: 654321698</p>
                        <p class="card-text">Curso: 2019-2021</p>
                    </div>
                    <div class="col-3">
                        <button type="button" class="btn"><img class="" src="img/basura.png" alt=""></button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
            <div class="card bg-dark px-1 py-1">
                <img class="card-img-top px-4 py-1 bg-light" src="img/icono.png" alt="">
                <div class="row card-body text-light">
                    <div class="col-9">
                        <h4 class="card-title">Pedro Garcia Nobillo</h4>
                        <p class="card-text">Mail: pedrogn@gmail.com</p>
                        <p class="card-text">Telefono: 654321698</p>
                        <p class="card-text">Curso: 2019-2021</p>
                    </div>
                    <div class="col-3">
                        <button type="button" class="btn"><img class="" src="img/basura.png" alt=""></button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
            <div class="card bg-dark px-1 py-1">
                <img class="card-img-top px-4 py-1 bg-light" src="img/icono.png" alt="">
                <div class="row card-body text-light">
                    <div class="col-9">
                        <h4 class="card-title">Pedro Garcia Nobillo</h4>
                        <p class="card-text">Mail: pedrogn@gmail.com</p>
                        <p class="card-text">Telefono: 654321698</p>
                        <p class="card-text">Curso: 2019-2021</p>
                    </div>
                    <div class="col-3">
                        <button type="button" class="btn"><img class="" src="img/basura.png" alt=""></button>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar alumno</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Desea eliminar a .....?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalA�adirAlumno" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalA�adirAlumno">A�adir alumno</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="nombre" class="col-form-label">Nombre completo:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="dni" class="col-form-label">DNI:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-form-label">Email:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="telefono" class="col-form-label">Telefono:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="curso" class="col-form-label">Curso:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalA�adirCurso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">A�adir grupo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">A�o:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-primary">A�adir</button>
      </div>
    </div>
  </div>
</div>


</html>