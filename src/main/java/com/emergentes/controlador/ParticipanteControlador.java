package com.emergentes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.emergentes.dao.ParticipanteDao;
import com.emergentes.dao.ParticipanteDaoImplementacion;
import com.emergentes.modelo.Participante;
import com.emergentes.modelo.Seminario;
import com.emergentes.dao.SeminarioDao;
import com.emergentes.dao.SeminarioDaoImplementacion;

@WebServlet(name = "ParticipanteControlador", urlPatterns = {"/ParticipanteControlador"})
public class ParticipanteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ParticipanteDao dao = new ParticipanteDaoImplementacion();
            SeminarioDao daoSeminario = new SeminarioDaoImplementacion();
            List<Seminario> listaSeminarios = daoSeminario.getAll();
            Participante participante = new Participante();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("seminarios", listaSeminarios);
                    request.setAttribute("participante", participante);
                    request.getRequestDispatcher("participante_form.jsp").forward(request, response);
                    break;
                case "edit":
                    request.setAttribute("seminarios", listaSeminarios);
                    id = Integer.parseInt(request.getParameter("id"));
                    participante = dao.getById(id);
                    request.setAttribute("participante", participante);
                    request.getRequestDispatcher("participante_form.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ParticipanteControlador");
                    break;
                case "view":
                    List<Participante> lista = dao.getAll();
                    request.setAttribute("participantes", lista);
                    request.getRequestDispatcher("participante_listado.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));
        Participante participante = new Participante();
        participante.setId(id);
        participante.setNombres(nombres);
        participante.setApellidos(apellidos);
        participante.setIdSeminario(id_seminario);
        participante.setConfirmado(confirmado);
        ParticipanteDao dao = new ParticipanteDaoImplementacion();
            if (id == 0) {
            try {
                dao.insert(participante);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(participante);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("ParticipanteControlador");
    }

}
