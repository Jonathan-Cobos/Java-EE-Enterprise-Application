/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Component.java to edit this template
 */
package com.example.JavaEEAplication.main;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import java.util.List;


/**
 *
 * @author user
 */
@Entity(name = "Cursos")
@Table(name = "Cursos")
public class Cursos {
    @Id
    @Column
    long codigoCurso;
    @Column
    String nombreCurso;
    @Column
    int numCreditos;
    @Column
    int semestre;
    @Column
    int nuEstudientes;

    public Cursos() {
    }

    public Cursos(long codigocurso, String nombreCurso, int numCreditos, int semestre, int nuEstudientes) {
        this.codigoCurso = codigocurso;
        this.nombreCurso = nombreCurso;
        this.numCreditos = numCreditos;
        this.semestre = semestre;
        this.nuEstudientes = nuEstudientes;
    }

    public long getCodigocurso() {
        return codigoCurso;
    }

    public void setCodigocurso(long codigocurso) {
        this.codigoCurso = codigocurso;
    }

    

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNuEstudientes() {
        return nuEstudientes;
    }

    public void setNuEstudientes(int nuEstudientes) {
        this.nuEstudientes = nuEstudientes;
    }

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes;

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Cursos{" + "codigocurso=" + codigoCurso + ", nombreCurso=" + nombreCurso + ", numCreditos=" + numCreditos + ", semestre=" + semestre + ", nuEstudientes=" + nuEstudientes + '}';
    }


    
}
