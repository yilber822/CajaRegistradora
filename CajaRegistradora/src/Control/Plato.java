/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Yilber
 */
public class Plato {
    
    public String nombrePlato;
    public int cantidad;
    public String tipoPlato;
    public float precio;

    public Plato(String nombrePlato, int cantidad, String tipoPlato, float precio) {
        this.nombrePlato = nombrePlato;
        this.cantidad = cantidad;
        this.tipoPlato = tipoPlato;
        this.precio = precio;
    }

    public Plato() {
        this.nombrePlato = "";
        this.cantidad = 0;
        this.tipoPlato = "";
        this.precio = 0;
    }
    
    
}
