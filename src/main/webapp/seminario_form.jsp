<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

     
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>Seminarios | Segundo Parcial</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="seminarios"/>
        </jsp:include>
        <div class="container">
            <p class="text-center" style="margin-top: 10px; border: 1px solid #a0a0a0;">
             <b>SEGUNDO PARCIAL</b>
                <br>
                <b>Nombre: </b>JUAN EXALTO HUANCA NINACHOQUE
                <br>
                <b>Cédula de Identidad: </b>9234096
            </p>
            <h1>Formulario de Seminarios</h1>
            <br>
            <form action="SeminarioControlador" method="post" >
                <input type="hidden" name="id" value="${seminario.id}" >
                <div class="mb-3">
                    <label for="titulo" class="form-label">Título</label>
                    <input type="text"  name="titulo" value="${seminario.titulo}" class="form-control" id="titulo" required>                    
                </div>
                <div class="mb-3">
                    <label for="fecha" class="form-label">Fecha</label>
                    <input type="date" name="fecha" value="${seminario.fecha}" class="form-control" id="fecha" required>
                </div>
                <div class="mb-3">
                    <label for="cupo" class="form-label">Cupo</label>
                    <input type="number" name="cupo" value="${seminario.cupo}" class="form-control" id="celular" required>
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
