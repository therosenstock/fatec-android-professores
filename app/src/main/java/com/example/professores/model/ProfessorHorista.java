package com.example.professores.model;

public class ProfessorHorista extends Professor{
    /*
     *@author:<Fabiola Rodrigues dos Santos / RA: 1110482313011>
     */
    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista(){
        super();
    }
    @Override
    public double calcSalario() {
        return horasAula * valorHoraAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }
}
