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
	public static ListaCircular listaCuentas = new ListaCircular();;
	
	public CajaRegistradora(){
		
	};
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
            	//JOptionPane.showMessageDialog(null, listaCuentas.iterarLista());
            	if(!listaCuentas.buscarElemento(cuenta)){
            		listaCuentas.insertar(cuenta);
            		JOptionPane.showMessageDialog(null, "Se ha registrado la cuenta de " + cuenta.getNombre());
            	}else{
            		JOptionPane.showMessageDialog(null, "El usuario ya se ha registrado");
            		JOptionPane.showMessageDialog(null, listaCuentas.iterarLista());
            	}
            		
            }
        	break;
        	default:
        		System.exit(0);
        		JOptionPane.showMessageDialog(null, "Al 1");
        }
        
        }
        
    }
    
}
