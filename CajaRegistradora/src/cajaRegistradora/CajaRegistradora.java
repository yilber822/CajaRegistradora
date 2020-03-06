package cajaRegistradora;
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

import control.Cuenta;
import control.ListaCircular;
import control.Nodo;

/**
 *
 * @author Yilber
 */
public class CajaRegistradora {

	public static Cuenta cuenta;
	public static Nodo cabezaCuenta;
	public static Nodo colaCuenta;
	public static ListaCircular lista = new ListaCircular();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int x = 0;
        while(x != -1){
        switch(x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese una opción\n"
        		+ "1. Crear nuevo usuario"))){
        
        case 1:
        	String nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
            String documento = JOptionPane.showInputDialog(null,"Ingrese su número de documento");
            int mesa = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el número de su mesa"));
            String pago = JOptionPane.showInputDialog(null,"Ingrese su método de pago");
            String plato = JOptionPane.showInputDialog(null,"Ingrese sus platos");
        	if(nombre.equals("") || documento.equals("") || mesa == 0 || pago.equals("") || plato.equals("")){
            	JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }else{
            	cuenta = new Cuenta(nombre, documento, mesa, pago);
            	Cuenta temp = new Cuenta();
            	
            	if(!lista.buscarElemento(documento)){
            		lista.insertarEnCola(documento);
            		JOptionPane.showMessageDialog(null, "Se ha registrado la cuenta de " + cuenta.getNombre());
            		JOptionPane.showMessageDialog(null, lista.iterarLista());
            	}else{
            		JOptionPane.showMessageDialog(null, "El usuario ya se ha registrado");
            	}
            	
            	
            }
        	break;
        	default:
        		JOptionPane.showMessageDialog(null, "Al 1");
        }
        
        }
        
    }
    
}
