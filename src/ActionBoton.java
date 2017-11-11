import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener{

	VentanaPrincipal ventan;
	int i;
	int j;
	

	public ActionBoton(VentanaPrincipal ventana, int i, int j) {
		
		this.ventan = ventana;
		this.i = i;
		this.j = j;
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ControlJuego juego = new ControlJuego();
		
		if(juego.getPuntuacion() < 80) {
			
			for (int i = 0; i < ventan.botonesJuego.length; i++) {
				
				for (int j = 0; j < ventan.botonesJuego.length; j++) {
					
					if(juego.abrirCasilla(i, j)) {
						
						ventan.mostrarFinJuego(true);
						
					}
					else {
						
						ventan.actualizarPuntuacion();
						ventan.mostrarNumMinasAlrededor(i, j);
						ventan.refrescarPantalla();
						
					}
				}
			}
		}
		else {
			
			ventan.mostrarFinJuego(false);
		}
	}

}
