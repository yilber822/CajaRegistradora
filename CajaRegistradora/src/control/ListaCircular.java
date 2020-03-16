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
	
	public Nodo getReferencia() {
		return referencia;
	}
	
	public ListaCircular() {
		referencia = null;
		cantidad = 0;
	}
	
	public boolean checkEmpty() {
		return referencia == null;
	}
	
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
		if(!encontrado){
			return null;
		}else{		
			return retornar;
		}
	}
	
	/**
	 * @param <E>
	 * @param dato is the value that will be the new head of the list
	 * The method inserts the value given to the head of the list, moving the current head to the next position 
	 * and then modifying the tail next reference to the new head of the list
	 */
	public <E> void insertar(E dato) {
		Nodo nodo = new Nodo(dato);
		Nodo buscador;
		//check if the list is currently empty
		try{
		if(checkEmpty()) {
			//set the head and the tail as the new node
			referencia = nodo;
			//set the next node of the head as itself
			nodo.setSiguiente(referencia);
		}else {
			nodo.setSiguiente(referencia);
			buscador = referencia;
			while(buscador.getSiguiente() != referencia){
				buscador = buscador.getSiguiente();
				}
			buscador.setSiguiente(nodo);
			referencia = nodo;
		 }
		this.cantidad++;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error inesperado, por favor contacte a soporte +57 3192638574");
		}
	}
	
	public <E> void eliminarElemento(String dato) {
		boolean encontrado = false;
		Nodo buscador;
		Nodo salida;
		Plato platoActual;
		buscador = referencia;
		if(checkEmpty()) {
			JOptionPane.showMessageDialog(null, "Usted no tiene platos en su cuenta");
		}else{
			if(cantidad == 1){ //CASO 1 EN EL QUE SÓLO HAY 1 ELEMENTO
				platoActual = (Plato)buscador.getDato();
				if(platoActual.getNombrePlato().equals(dato)){
					referencia = null;
					cantidad = 0;
				}else{
					JOptionPane.showMessageDialog(null, "El plato que desea eliminar no se encuentra registrado");
				}
			}else					//FIN DEL CASO 1 
			if(cantidad == 2){     //CASO 2 EN EL QUE HAY 2 ELEMENTOS
				platoActual = (Plato)buscador.getDato();
				if(platoActual.getNombrePlato().equals(dato)){
					buscador.getSiguiente().setSiguiente(buscador.getSiguiente());
					referencia = buscador.getSiguiente();
					buscador.setSiguiente(null);
					cantidad --;
				}else{
					platoActual = (Plato)buscador.getSiguiente().getDato();
					if(platoActual.getNombrePlato().equals(dato)){
						buscador.setSiguiente(null);
						referencia.setSiguiente(referencia);
						cantidad --;
					}else{ 
						JOptionPane.showMessageDialog(null, "El plato que desea eliminar no se encuentra registrado");
					}
				}
			}					//FIN DEL CASO 2
			if(cantidad > 2){   //CASO 3 MÁS DE 2
				platoActual = (Plato)referencia.getDato();
				if(platoActual.getNombrePlato().equals(dato)){
					while(buscador.getSiguiente() != referencia){
						buscador = buscador.getSiguiente();
					}
					buscador.setSiguiente(referencia.getSiguiente());
					referencia.setSiguiente(null);
					referencia = buscador.getSiguiente();
					cantidad --;
				}else{
					platoActual = (Plato)buscador.getSiguiente().getDato();
					encontrado = false;
					while(buscador.getSiguiente() != referencia && !encontrado){
						encontrado = platoActual.getNombrePlato().equals(dato);
						if(!encontrado){
							buscador.setSiguiente(buscador);
						}
					}
					if(encontrado){
						Nodo borrar = buscador.getSiguiente();
						buscador.setSiguiente(buscador.getSiguiente().getSiguiente());
						borrar.setSiguiente(null);
						cantidad --;
					}else{
						JOptionPane.showMessageDialog(null, "El plato que desea eliminar no se encuentra registrado");
					}
				}
			}
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
		this.referencia = null;
		this.cantidad = 0;
	}

	public int getCantidad() {
		return cantidad;
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
