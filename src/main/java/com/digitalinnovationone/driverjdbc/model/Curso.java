package com.digitalinnovationone.driverjdbc.model;

import java.sql.Time;
import java.text.ParseException;

public class Curso {

    private Integer id;
    private String nome;
    private java.sql.Time duracaoHoras;

    public Curso(Integer id, String nome, String duracaoHoras) throws ParseException {
        this(nome, duracaoHoras);
        this.id = id;
    }

    public Curso(String nome, Time duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, String duracaoHoras) throws ParseException {
        this(nome, new Time(new java.text.SimpleDateFormat("HH:mm:ss").parse(duracaoHoras).getTime()));
    }

    public Curso(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(Time duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracaoHoras=" + duracaoHoras +
                '}';
    }
}
