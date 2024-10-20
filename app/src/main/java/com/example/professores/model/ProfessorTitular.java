package com.example.professores.model;

public class ProfessorTitular extends Professor {
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */
    private int anosInstituicao;
    private double salario;

    public ProfessorTitular(){
        super();
    }

    @Override
    public double calcSalario() {
        return salario + salario * 0.05 * anosInstituicao / 5;
    }
    public int getAnosInstituicao() {
        return anosInstituicao;
    }
    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
