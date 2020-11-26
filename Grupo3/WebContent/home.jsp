<%@page import="model.Alumno"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
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
<%
  	ArrayList<Curso> listacursos = (ArrayList<Curso>) session.getAttribute("listacursos");
%>

<body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark px-5 py-3">
        <button class="navbar-toggler d-lg-none " type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse mx-5" id="collapsibleNavId">
            <ul class="navbar-nav">  
                <li>
                    <form class="form-inline">
                        <input class="form-control mr-sm-2 mx-5 px-5 mt-2" type="text" placeholder="Search">
                    </form>
                </li>
                
                <li class="nav-item">
                    <div class="form-group px-5 mt-2">
                        <form action="Controller?op=traeralumnos" method="POST" name="fcurso">
                              <div class="form-group row">
                                <select class="form-control" name="combocurso" id="combocurso" onchange="this.form.submit()">
                                  <option value="" readonly>SELECCIONE CURSO</option>  
                                  <% for (Curso curso:listacursos){%>                             
                                      <option "<%=curso.getCurso()%>"><%=curso.getCurso()%></option>
                                  <%} %>
                                </select>
                            </div>
                             <input type="hidden" name="op" value="traeralumnos">
                        </form>
                    </div>
                </li> 
                <button type="button" class="btn" data-toggle="modal" data-target="#ModalAñadirCurso"><img class=""
                    src="img/boton.png" alt=""></button>        
            </ul>                      
        </div>
        <img src="img/logo.png" class="mx-5"alt="">
    </nav>
    <div class="col text-center">
        <button type="button" class="btn" data-toggle="modal" data-target="#ModalAñadirAlumno"><img class=""
            src="img/boton.png" alt=""></button>
      </div>
    
    
    

    <div class="row">
		<% ArrayList<Alumno> listaalumnos = (ArrayList<Alumno>)request.getAttribute("listaalumnos"); 
        if (listaalumnos!=null) {
        	for (Alumno alumno:listaalumnos){
        %>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 mt-2">
            <div class="card bg-dark px-1 py-1">
                
                <img class="card-img-top px-4 py-1 bg-light" src="img/icono.png" alt="">
                <div class="col text-right">
                    <button type="button" class="btn" data-toggle="modal" data-target="#ModalEliminarAlumno"><img class=""
                        src="img/basura.png" alt=""></button>
                    <button type="button" class="btn openBtn" data-toggle="modal" data-target="#ModalEditarAlumno"><img class=""
                        src="img/editar.png" alt=""></button>
                </div>
                <div class="row card-body text-light">
                    <div class="col-12">
                        <h4 class="card-title" id="nombre">Pedro Garcia Nobillo</h4>
                        Mail:<button class="btn openBtn" data-toggle="modal" data-target="#ModalAñadirMail"><img class=""
                            src="img/botonA.png" alt=""></button>
                        <p class="card-text">pedrogn@gmail.com<button  class="btn" data-toggle="modal" data-target="#ModalEliminarMail"><img class=""
                            src="img/basuraA.png" alt=""></button>
                        </p>
                        Telefono:<button class="btn openBtn" data-toggle="modal" data-target="#ModalAñadirTelefono"><img class=""
                            src="img/botonA.png" alt=""></button>
                        <p class="card-text">654321698<button  class="btn" data-toggle="modal" data-target="#ModalEliminarTelefono"><img class=""
                            src="img/basuraA.png" alt=""></button></p>
                        
                        <p class="card-text">Curso: 2019-2021</p>
                    </div>
                    
                </div>
            </div>
        </div>
        <%}
        } %>
        

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
<div class="modal fade" id="ModalEliminarAlumno" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar alumno</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!-- Mediante el siguiente script puedo introducir el nombre del contacto a eliminar utilizando su posicion-->
            <div class="modal-body">
                Desea eliminar a
                <script>
                        var modal = $(this)
                        var parrafos = document.getElementsByTagName('h4');
                        var contenido = parrafos[1].innerHTML; 
                        document.write(contenido)  
                </script>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalAñadirAlumno" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalAñadirAlumno">Añadir alumno</h5>
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

<div class="modal fade" id="ModalEditarAlumno" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalAñadirAlumno">Añadir alumno</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            
            
            <div class="modal-body">         
                <form>
                    <div class="form-group">
                        <label for="nombre" class="col-form-label">Nombre completo:</label>
                        <input type="text" class="form-control" id="recipient-name" placeholder="Campo de texto">
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

<div class="modal fade" id="ModalAñadirCurso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Añadir grupo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Año:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Añadir</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalAñadirMail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Añadir mail</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">email:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Añadir</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalAñadirTelefono" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Añadir telefono</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Número:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Añadir</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalEliminarMail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar mail</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!-- Mediante el siguiente script puedo introducir el nombre del contacto a eliminar utilizando su posicion-->
            <div class="modal-body">
                Desea eliminar email de
                <script>
                        var modal = $(this)
                        var parrafos = document.getElementsByTagName('h4');
                        var contenido = parrafos[1].innerHTML; 
                        document.write(contenido)  
                </script>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="ModalEliminarTelefono" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar telefono</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!-- Mediante el siguiente script puedo introducir el nombre del contacto a eliminar utilizando su posicion-->
            <div class="modal-body">
                Desea eliminar telefono de
                <script>
                        var modal = $(this)
                        var parrafos = document.getElementsByTagName('h4');
                        var contenido = parrafos[1].innerHTML; 
                        document.write(contenido)  
                </script>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Aceptar</button>
            </div>
        </div>
    </div>
</div>
</html>