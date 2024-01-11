
/**
 * VentanaDialogo.java
 * Nov 23, 2023 8:31:08 AM
 * @author Germán Nájar Delgado
*/

package swing_c_p02_NajarDelgadoGerman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 * The Class VentanaDialogo.
 */
public class VentanaDialogo extends JDialog {

	/**
	 * Instantiates a new ventana dialogo.
	 *
	 * @param padre  the padre
	 * @param titulo the titulo
	 * @param modal  the modal
	 */
	public VentanaDialogo(JFrame padre, String titulo, boolean modal) {
		super(padre, titulo, modal);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimensiones = pantalla.getScreenSize();

		int altoPantalla = dimensiones.height;
		int anchoPantalla = dimensiones.width;

		this.setBounds(0, 0, anchoPantalla, altoPantalla);

		this.setIconImage(new ImageIcon(getClass().getResource("/resources/Icon.PNG")).getImage());
		PanelDialogo panelDialogo = new PanelDialogo();
		panelDialogo.setBackground(Color.BLUE);
		this.add(panelDialogo);
	}
}
