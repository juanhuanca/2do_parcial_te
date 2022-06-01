package com.emergentes.modelo;

public class Seminario {
    private int id;
    private String titulo;
    private String fecha;
    private int cupo;
    
    public Seminario() {
        id = 0;
        titulo = "";
        fecha = "";
        cupo = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    
}
