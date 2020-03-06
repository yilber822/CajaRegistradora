/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajaregistradora;

import javax.swing.JOptionPane;

/**
 *
 * @author Yilber
 */
public class CajaRegistradora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
        String documento = JOptionPane.showInputDialog(null,"Ingrese su número de documento");
        int mesa = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el número de su mesa"));
        String pago = JOptionPane.showInputDialog(null,"Ingrese su método de pago");
        String plato = JOptionPane.showInputDialog(null,"Ingrese su plato");
        
    }
    
}
