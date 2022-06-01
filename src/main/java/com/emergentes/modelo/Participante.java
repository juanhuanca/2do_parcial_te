package com.emergentes.modelo;

public class Participante {
    private int id;
    private String nombres;
    private String apellidos;
    private int id_seminario;
    private int confirmado;
    private String titulo_seminario;
    
    public Participante() {
        id = 0;
        nombres = "";
        apellidos = "";
        id_seminario = 0;
        confirmado = 0;
        titulo_seminario = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdSeminario() {
        return id_seminario;
    }

    public void setIdSeminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }
    
    public String getTituloSeminario() {
        return titulo_seminario;
    }

    public void setTituloSeminario(String titulo_seminario) {
        this.titulo_seminario = titulo_seminario;
    }
}
