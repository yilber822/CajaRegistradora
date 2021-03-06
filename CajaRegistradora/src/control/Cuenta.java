/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Yilber
 */
public class Cuenta {

    public String nombre;
    public String documento;
    public int mesa;
    public String pago;
    public ListaCircular lista;
    
    public Cuenta(){
    	
    }
    
	public Cuenta(String nombre, String documento, int mesa, String pago) {
		super();
		this.lista = new ListaCircular();
		this.pago = pago;
		this.nombre = nombre;
		this.documento = documento;
		this.mesa = mesa;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public int getMesa() {
		return mesa;
	}



	public void setMesa(int mesa) {
		this.mesa = mesa;
	}



	public String getPago() {
		return pago;
	}



	public void setPago(String pago) {
		this.pago = pago;
	}
	
	

	public ListaCircular getLista() {
		return lista;
	}

	public void setLista(ListaCircular lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", documento=" + documento + ", mesa=" + mesa + ", pago=" + pago
				+ ", lista=" + lista + "]";
	}
    
    
    
	
}
