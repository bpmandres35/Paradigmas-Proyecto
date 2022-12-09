package RB;

import javax.swing.JFrame;

public class Main {
    
	//Método para generar, hacer visible e inicializar la ventana principal del juego
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame obj = new JFrame();
		SalaJuego salaJuego = new SalaJuego();
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Rompe Bloques");
		obj.setResizable(false);
		obj.add(salaJuego);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
