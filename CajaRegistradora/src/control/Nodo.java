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
public class Nodo<E> {
	private E dato = null;
	private Nodo siguiente = null;
	
	public Nodo() {
	}
	
	public Nodo(E dato) {
		this.dato = dato;
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String toString() {
		return "Nodo [dato=" + dato.toString()+"]";
	}
	
	
}
