package RB;

/**
 * Proyecto para Politecnico Grancolombiano
 *@author Ricardo Perez
 *@author Jose Rodriguez
 *@author Yojhan Arias
 *@author Elkin Pinzon
 *@version 1.0
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class GeneradorMapa {
	
	public int mapa [][];
	public int anchoBloque;
	public int altoBloque;
	
	//Método para generar la matriz de bloques en el juego genera el mapa
	public GeneradorMapa(int fila, int col) {
		mapa = new int [fila][col];
		for (int i = 0; i < mapa.length; i++) {
			for (int j=0; j< mapa[0].length;j++) {
				mapa[i][j] = 1;
			}
		}
		
		anchoBloque = 540/col;
		altoBloque = 150/fila;
	}
	
	//Método para dibujar la matriz de bloques en el juego
	public void draw(Graphics2D g) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j=0; j< mapa[0].length;j++) {
				if(mapa[i][j] > 0) {
					g.setColor(Color.black);
					g.fillRect(j*anchoBloque + 80, i*altoBloque + 50, anchoBloque, altoBloque);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.white);
					g.drawRect(j*anchoBloque + 80, i*altoBloque + 50, anchoBloque, altoBloque);
				}
			}
			
		}
		
		}
	// Método para establecer el valor de los bloques	
	public void setBrickValue(int valor, int filas, int col) {
		mapa[filas][col] = valor;
	}

}
