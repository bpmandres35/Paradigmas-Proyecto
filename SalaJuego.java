package RB;

/*
* Conjunto de funciones utiles para el uso de la aplicacion
* Proyecto para Politecnico Grancolombiano
 *@author Ricardo Perez
 *@author Jose Rodriguez
 *@author Yojhan Arias
 *@author Elkin Pinzon
 *@version 1.0
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class SalaJuego extends JPanel implements KeyListener, ActionListener  {
	
	//Inicializando variables
	private boolean juego = false;
	private int marcador = 0;
	
	private int totalBloques = 28;
	
	private Timer tiempo;
	private int retraso = 8;
	
	private int jugadorX = 310;
	
	private int pospelX = 120;
	private int pospelY = 350;
	private int pelXdir = -1;
	private int pelYdir = -2;
	
	private GeneradorMapa mapa;
	
	// Método para establecer los valores iniciales del Juego
	//Se invocan otras clases
	public SalaJuego() {
		mapa = new GeneradorMapa(4, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		tiempo = new Timer(retraso, this);
		tiempo.start();
		
		
		
	}
	public void paint(Graphics g) {
		
		// En este método de gráficos vamos a mostrar la pelota, la plataforma y además vamos a controlar todas las cosas
		// que se muestran en nuestro juego 
		
		//Fijamos el fondo de nuestra ventana
		g.setColor(Color.white);
		g.fillRect(1, 1, 692, 592);
		
		mapa.draw((Graphics2D)g);
		
		//Fijamos los bordes de la pantalla
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		//Fijamos y establecemos los atributos de la plataforma
		g.setColor(Color.blue);
		g.fillRect(jugadorX, 550, 100, 8);
		
		//Fijamos y establecemos los atributos de nuestra pelota
		g.setColor(Color.red);
		g.fillOval(pospelX, pospelY, 20, 20);
		
		//Fijamos y establecemos los atributos del marcador en la esquina del juego y actualizarlo
		g.setColor(Color.black);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + marcador, 590, 30);
		
		
		if (totalBloques == 28) {
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Presione Enter para Iniciar.", 230, 350);	
			
		}
		
		//Condicionales para saber cuando se gana o se pierde el Juego y poder reiniciarlo
		if (totalBloques <= 0) {
			juego = false;
			pelXdir = 0;
			pelYdir = 0;
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Ganaste, Marcador: " + marcador, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Presione Enter para Reiniciar.", 230, 350);	
			
		}
		
		if(pospelY > 570) {
			juego = false;
			pelXdir = 0;
			pelYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Juego Terminado, Marcador: " + marcador, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Presione Enter para Reiniciar.", 230, 350);	
		} 
		
		
		
		g.dispose();
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		tiempo.start();
		if(juego) {
			//Interacción Pelota - Bloques
			//Asigna posiciones de los bloques dentro del Mapa
			//Bucles para barrer la matriz de bloques y establecer cuando deben ser borrados al ser golpeados por la pelota y asignar valor al marcador
			
			if(new Rectangle(pospelX, pospelY, 20, 20).intersects(new Rectangle(jugadorX, 550, 100, 8))) {
				pelYdir = - pelYdir;
			}
			for( int i = 0; i<mapa.mapa.length; i++) {
				for(int j = 0; j<mapa.mapa[0].length; j++) {
					if(mapa.mapa[i][j] > 0) {
						int bloqueX = j*mapa.anchoBloque + 80;
						int bloqueY = i*mapa.altoBloque + 50;
						int bloqueAncho= mapa.anchoBloque;
						int bloqueAlto = mapa.altoBloque;
						
						Rectangle rect = new Rectangle(bloqueX, bloqueY, bloqueAncho, bloqueAlto);
						Rectangle pelRect = new Rectangle(pospelX, pospelY, 20,20);
						Rectangle bloqueRect = rect;
						
						if(pelRect.intersects(bloqueRect) ) {
							mapa.setBrickValue(0, i, j);
							totalBloques--;
							marcador+=5;
							
							if(pospelX + 19 <= bloqueRect.x || pospelX +1 >= bloqueRect.x + bloqueRect.width) 
								pelXdir = -pelXdir;
							 else {
								pelYdir = -pelYdir;
							}
						}
						
					}
					
				}
			}
			
			// Interacción Pelota - Plataforma
			
			pospelX += pelXdir;
			pospelY += pelYdir;
			if(pospelX < 0) {
				pelXdir = -pelXdir;
			}
			if(pospelY < 0) {
				pelYdir = -pelYdir;
			}
			if(pospelX > 670) {
				pelXdir = -pelXdir;  
			
			}
			
		}
		
		
		repaint();

	}
	
    //Método para establecer los eventos que son generados al pulsar las teclas Enter y flechas derecha o izquierda 
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(jugadorX >= 600) {
				jugadorX = 600;
			} else {
				moveRight();
					
			}
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			if(jugadorX < 10) {
				jugadorX = 10;
			} else {
				moveLeft();
					
			}
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!juego) {
				juego = true;
				pospelX = 120;
				pospelY = 350;
				pelXdir = -1;
				pelYdir = -2;
				marcador = 0;
				totalBloques = 28;
				mapa = new GeneradorMapa(4,7);
				
				repaint();
			}
		}
		
	}	
		public void moveRight() {
			juego = true;
			jugadorX += 20;
		}
		public void moveLeft() {
			juego = true;
			jugadorX -= 20;
		}
		
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

    public int numero_mayor(int a, int b, int c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
