package com.example.professores.model;

public abstract class Professor {

    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */    private String nome;
    private int idade;
    private String matricula;

    public Professor(){
        super();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public abstract double calcSalario();
}
