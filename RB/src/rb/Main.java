package RB;

import javax.swing.JFrame;

public class Main {
	
	// En esta clase que es la principal es donde se corre el juego. Todo el resto de las clases están conectadas a esta clase.
	// En esta clase creamos el método JFrame, el cual creará el marco de nuestro juego.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Método principal para generar, hacer visible e inicializar la ventana principal del juego
		
		JFrame obj = new JFrame();
		SalaJuego salaJuego = new SalaJuego(); //Se crea el objeto salaJuego, el cual conecta la clase SalaJuego con la clase Main
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Rompe Bloques");
		obj.setResizable(false);
		obj.add(salaJuego);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
