package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.tools.ConexionBaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDaoImplementacion extends ConexionBaseDatos implements SeminarioDao  {

    @Override
    public void insert(Seminario seminario) throws Exception {
        String sql = "INSERT INTO seminarios (titulo, fecha, cupo) VALUES (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminario.getTitulo());
        ps.setString(2, seminario.getFecha());
        ps.setInt(3, seminario.getCupo());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        String sql = "UPDATE seminarios SET titulo=?, fecha=?, cupo=? WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminario.getTitulo());
        ps.setString(2, seminario.getFecha());
        ps.setInt(3, seminario.getCupo());
        ps.setInt(4, seminario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM seminarios WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario seminario = new Seminario();
        String sql = "SELECT * FROM seminarios WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            seminario.setId(rs.getInt("id"));
            seminario.setTitulo(rs.getString("titulo"));
            seminario.setFecha(rs.getString("fecha"));
            seminario.setCupo(rs.getInt("cupo"));
        }
        this.desconectar();
        return seminario;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List<Seminario> lista = null;
        String sql = "SELECT * FROM seminarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Seminario>();
        while (rs.next()) {            
            Seminario seminario = new Seminario();
            seminario.setId(rs.getInt("id"));
            seminario.setTitulo(rs.getString("titulo"));
            seminario.setFecha(rs.getString("fecha"));
            seminario.setCupo(rs.getInt("cupo"));
            lista.add(seminario);
        }
        this.desconectar();
        return lista;
    }
    
}
