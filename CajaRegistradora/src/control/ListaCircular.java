/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;

/**
 *
 * @author Yilber
 */
public class ListaCircular {
	private Nodo referencia;
	private int cantidad; 
	
	public ListaCircular() {
		referencia = null;
		cantidad = 0;
	}
	
	public boolean checkEmpty() {
		return referencia == null;
	}
	
	/**
	 * Appends an element by shifting the tail, so the new element will be the tail
	 * O(9)~O(1) the insertion takes constant time, because we just update pointers
	 * @param <E>
	 * @param dato
	 */
	public <E> Nodo retornar(E dato){
		Nodo actual;
		Nodo retornar = null;
		boolean encontrado = false;
		//Se ubica en la cabeza
		actual = referencia;
		if(referencia == null)return null;
				do{
				 //Determina si el valor en el nodo actual es del mismo tipo que el dato buscado
				 retornar = actual;
				 encontrado = (dato.equals(retornar.getDato()));
				 //Compara el nombre y el documento de el dato del nodo que se está recorriendo y el dato que pasa como parámetro
				//Pasa al nodo siguiente
				 actual = actual.getSiguiente();
				}while ((actual.getSiguiente() != referencia && !(encontrado)));
		
		//Recorre la lista mientras que no llegue a la cabeza o encuentre el valor
		return retornar;
	}
	
	/*public <E> void insertarEnCola(E dato) {
		Nodo nodo = new Nodo(dato);
		if(!checkEmpty()) {
			// If the list is not empty, the head is updated to point to the new node
			this.cola.setSiguiente(nodo);
			// The new node is linked to the tail to keep it circular
			nodo.setSiguiente(this.cabeza);
			// The tails is updated
			this.cola = nodo;
		}else {
			// If the list is empty, Just set the tail and head and make it circular
			this.cabeza = nodo;
			this.cola = nodo;
			this.cola.setSiguiente(this.cabeza);
		}
		this.cantidad++;
	}*/
	
	
	/**
	 * @param <E>
	 * @param dato is the value that will be the new head of the list
	 * The method inserts the value given to the head of the list, moving the current head to the next position 
	 * and then modifying the tail next reference to the new head of the list
	 */
	public <E> void insertar(E dato) {
		Nodo nodo = new Nodo(dato);
		Nodo busqueda = referencia;
		//check if the list is currently empty
		if(checkEmpty()) {
			//set the head and the tail as the new node
			referencia = nodo;
			//set the next node of the head as itself
			nodo.setSiguiente(referencia);
		}else {
			//Sets the current head as the next value for the new head
			nodo.setSiguiente(referencia);
			//sets the head as the new node
			while(!busqueda.getSiguiente().equals(referencia)){
				busqueda = referencia.getSiguiente();
				referencia.getSiguiente().setSiguiente(nodo);
			}
			referencia = nodo;
			//sets the next value of the tail as the new head
		}
		this.cantidad++;
	}
	
	public void eliminarCabeza() {
		Nodo eliminar= null;
		if(checkEmpty()) {
			System.out.println("La lista se encuentra vacia");
		}else {
			if(cabeza==cola) {
				cabeza=null;
				cola=null;
				this.cantidad = 0;
			}
			else {
			Nodo actual=cola;
			while(actual.getSiguiente()!=cabeza) {
				actual=actual.getSiguiente();
			}
			
			eliminar=actual.getSiguiente();
			actual.setSiguiente(cabeza.getSiguiente());
			cabeza=actual;
				
			}
			this.cantidad--;
		}
	}
	
	public void eliminarCola() {
        Nodo eliminar = null;
       if(checkEmpty()) {
           System.out.println( "La lista se encuentra vacia");
       }else {
	       if(cabeza == cola) {
	           cabeza = null;
	           cola = null;
	           this.cantidad = 0;
	       }
	       else {
	           Nodo actual = cabeza;
	           while(actual.getSiguiente() != cola) {
	               actual = actual.getSiguiente();
	           }
	           eliminar = actual.getSiguiente();
	           actual.setSiguiente(cabeza);
	
	           cola = actual;
	       }
	       this.cantidad--;
       }
   }
	
	public <E> void eliminarElemento(E dato) {
		//Si esta vacia 
		if(checkEmpty()) {
			System.out.println("Lista Vacia");
		}else {
			//Empezar con la cabeza
			Nodo inicio=this.cabeza;
			Nodo actual=this.cabeza;
			Nodo siguiente=this.cabeza.getSiguiente();
			do {//comparar si es el dato que busco
				if(siguiente.getDato().equals(dato)) {
					
					if(cantidad>1) {
						//conectar el actual con el que va despues del siguiente asi siguiente se pierde
						actual.setSiguiente(actual.getSiguiente().getSiguiente());
						cantidad--;
						if(actual.getSiguiente()==inicio) {
							break;
						}
					}else {
						cantidad--;
						this.cabeza=null;
						this.cola=null;
						break;
					}
				}
				//continuar
				actual=actual.getSiguiente();
				siguiente=actual.getSiguiente();			
			}while(actual!=inicio);
		}
	}
	
	public <E> boolean buscarElemento(E dato) {
		boolean encontrado = false;
		Nodo actual;
		Cuenta cuentaActual;
		Cuenta cuentaTemp;
		Plato platoActual;
		Plato platoTemp;
		//Se ubica en la cabeza
		actual = referencia;
		if(referencia == null)return false;
			if(dato instanceof Cuenta){ //Verifica si el dato en el nodo es un plato o una cuenta
				cuentaTemp = (Cuenta)dato; 
				
				do{
				 //Determina si el valor en el nodo actual es del mismo tipo que el dato buscado
				 cuentaActual = (Cuenta)actual.getDato();
				 //Compara el nombre y el documento de el dato del nodo que se está recorriendo y el dato que pasa como parámetro
				 encontrado = (cuentaActual.getDocumento().equals(cuentaTemp.getDocumento()) 
						 && cuentaActual.getNombre().equals(cuentaTemp.getNombre()));
				//Pasa al nodo siguiente
				 actual = actual.getSiguiente();
				}while ((actual.getSiguiente() != referencia) && (!encontrado));
			}else{
				platoTemp = (Plato)dato;
				do{
				 //Determina si el valor en el nodo actual es del mismo tipo que el dato buscado
				 platoActual = (Plato)actual.getDato();
				 //Compara el nombre y el documento de el dato del nodo que se está recorriendo y el dato que pasa como parámetro
				 encontrado = (platoActual.getNombrePlato().equals(platoTemp.getNombrePlato()));
				//Pasa al nodo siguiente
				 actual = actual.getSiguiente();
				}while ((actual.getSiguiente() != referencia) && (!encontrado));
			}
		
		//Recorre la lista mientras que no llegue a la cabeza o encuentre el valor
		
		
		return encontrado;
	}

	@Override
	public String toString() {
		return "ListaEnlazadaCircular [Nodo referencia: " + referencia + ", Cantidad = " + cantidad + "]";
	}
	
	public void limpiarLista() {
		this.cabeza = null;
		this.cola = null;
		this.cantidad = 0;
	}
	
	public String iterarLista() {
		String msg = this.toString()+"\n";
		Nodo firstNode = this.referencia;
		Nodo current = this.referencia;
		int counter = 1;
		while(current != null) {
			msg += String.format("%d Actual %s:Siguiente:%s\n", counter, current.toString(), current.getSiguiente().toString());
			current = current.getSiguiente();
			counter++;
			if(current.equals(firstNode))break;					
		}
		return msg;
	}

	
}
