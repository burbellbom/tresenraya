package com.tmoreno.tresenraya.modelo;

import java.util.ArrayList;
import java.util.List;

import com.tmoreno.tresenraya.modelo.Casilla.Estado;


/**
 * M�todo que modela un tablero
 */
public class Tablero {
	
	/** Casillas que tiene el tablero */
	private List<Casilla> casillas;
	
	public Tablero(){
		casillas = new ArrayList<Casilla>();
	}
	
	/**
	 * M�todo que a�ade una casilla al tablero
	 * @param casilla
	 */
	public void addCasilla(Casilla casilla){
		casillas.add(casilla);
	}
	
	/**
	 * M�todo que reinicia el tablero
	 */
	public void reiniciar(){
		for(Casilla c : casillas){
			c.reiniciar();
		}
	}
	
	/**
	 * M�todo que pone un c�rculo en la casilla que coincide el identificador 
	 * @param idCasilla
	 */
	public void setCirculo(int idCasilla){
		for(Casilla c : casillas){
			if(c.getId() == idCasilla){
				c.setCirculo();
			}
		}
	}
	
	/**
	 * M�todo que pone una cruz en la casilla que coincide el identificador 
	 * @param idCasilla
	 */
	public void setCruz(int idCasilla){
		for(Casilla c : casillas){
			if(c.getId() == idCasilla){
				c.setCruz();
			}
		}
	}
	
	/**
	 * M�todo que devuelve la casilla que est� en la posici�n i
	 * @param i
	 * @return
	 */
	public Casilla getCasilla(int i){
		return casillas.get(i);
	}
	
	/**
	 * M�todo que pregunta si hay un c�rculo, o una cruz, en la casilla i
	 * @param i
	 * @return
	 */
	public boolean isCasillaEstado(int i, Estado estado){
		return casillas.get(i).getEstado() == estado;
	}
	
	/**
	 * M�todo que pregunta si est� vac�a la casilla i
	 * @param i
	 * @return
	 */
	public boolean isCasillaVacia(int i){
		return casillas.get(i).getEstado() == Estado.VACIO;
	}
	
	/**
	 * M�todo que comprueba si se ha terminado el juego teniendo como referencia
	 * un estado
	 * @param estado
	 * @return
	 */
	public boolean comprobarJuegoTerminado(Estado estado) {		
		if(isCasillaEstado(4, estado)){
			if(isCasillaEstado(0, estado) && isCasillaEstado(8, estado)){
				return true;
			}
			
			if(isCasillaEstado(2, estado) && isCasillaEstado(6, estado)){
				return true;
			}
			
			if(isCasillaEstado(1, estado) && isCasillaEstado(7, estado)){
				return true;
			}
			
			if(isCasillaEstado(3, estado) && isCasillaEstado(5, estado)){
				return true;
			}
		}
		
		if(isCasillaEstado(0, estado)){
			if(isCasillaEstado(1, estado) && isCasillaEstado(2, estado)){
				return true;
			}
			
			if(isCasillaEstado(3, estado) && isCasillaEstado(6, estado)){
				return true;
			}
		}
		
		if(isCasillaEstado(8, estado)){
			if(isCasillaEstado(6, estado) && isCasillaEstado(7, estado)){
				return true;
			}
			
			if(isCasillaEstado(2, estado) && isCasillaEstado(5, estado)){
				return true;
			}
		}
		
		return false;
	}

	/**
	 * M�todo que pregunta si quedan casillas vac�as en el tablero
	 * @return
	 */
	public boolean isCompleto() {
		for(Casilla c : casillas){
			if(c.getEstado() == Estado.VACIO){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * M�todo que devuelve una lista con las casillas vacias
	 * @return
	 */
	public List<Integer> getCasillasVacias(){
		List<Integer> casillasVacias = new ArrayList<Integer>();
		
		for(Casilla c : casillas){
			if(c.getEstado() == Estado.VACIO){
				casillasVacias.add(c.getId());
			}
		}
		
		return casillasVacias;
	}
}
