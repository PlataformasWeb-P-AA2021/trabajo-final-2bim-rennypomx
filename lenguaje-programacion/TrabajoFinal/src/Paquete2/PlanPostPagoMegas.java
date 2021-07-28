/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete2;

import Paquete1.Persona;

/**
 *
 * @author ASUS
 */
public class PlanPostPagoMegas extends PlanCelular{
    protected double gigas;
    protected double costGigas;
    protected double tarifaBase;
    public PlanPostPagoMegas(Persona p, String cp, String mc, String modc, 
            String nc, double g, double cg, double tb) {
        super(p, cp, mc, modc, nc);
        gigas=g; 
        costGigas=cg;
        tarifaBase=tb;
    }

    public double getGigas() {
        return gigas;
    }

    public double getCostGigas() {
        return costGigas;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setGigas(double gigas) {
        this.gigas = gigas;
    }

    public void setCostGigas(double costGigas) {
        this.costGigas = costGigas;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    @Override
    public void setPagomensual() {
        pagomensual=gigas+costGigas+tarifaBase;
    }
    @Override
    public String toString() {
        String cadena = String.format("%s\n\t"
            + "Megas expresado en gigas: %s\n\t"
            + "Costo por cada gigas:%s\n\t"
            + "Tarifa base: %s\n\t"
            + "Pago Mensual: %.2f",
            super.toString(),
            gigas,costGigas,tarifaBase,pagomensual);
        return cadena;
    }
}
