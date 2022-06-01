<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
     
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        
        <title>Participantes | Segundo Parcial</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="participantes"/>
        </jsp:include>
        <div class="container">
            <p class="text-center" style="margin-top: 10px; border: 1px solid #a0a0a0;">
                <b>SEGUNDO PARCIAL</b>
                <br>
                <b>Nombre: </b>JUAN EXALTO HUANCA NINACHOQUE
                <br>
                <b>Cédula de Identidad: </b>9234096
            </p>
            <h1>Formulario de Participantes</h1>
            <br>
            <form action="ParticipanteControlador" method="post" >
                <input type="hidden" name="id" value="${participante.id}" >
                <div class="mb-3">
                    <label for="nombres" class="form-label">Nombres</label>
                    <input type="text"  name="nombres" value="${participante.nombres}" class="form-control" id="nombres" required>                    
                </div>
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" name="apellidos" value="${participante.apellidos}" class="form-control" id="apellidos" required>
                </div>
                <div class="mb-3">
                    <label for="id_seminario" class="form-label">Seminario</label>
                    <select class="form-control" name="id_seminario" id="id_seminario">
                        <option value="">--Seleccione una opción--</option>
                        <c:forEach var="item" items="${seminarios}">
                            <option value="${item.id}" <c:if test="${item.id == participante.idSeminario}">selected</c:if>>${item.titulo}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="confirmado" class="form-label">Confirmado</label>
                    <select class="form-control" name="confirmado" id="confirmado" required>
                        <option value="">--Seleccione una opción--</option>
                        <option value="1" <c:if test="${participante.confirmado == 1}">selected</c:if>>SI</option>
                        <option value="0" <c:if test="${participante.confirmado == 0}">selected</c:if>>NO</option>
                    </select>
                    
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
