/**
 * PanelTitulo.java
 * Nov 23, 2023 12:23:19 PM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * The Class PanelTitulo.
 */
public class PanelTitulo extends JPanel {

	/** The titulo. */
	private JLabel titulo;

	/**
	 * Instantiates a new panel titulo.
	 */
	public PanelTitulo() {
		super(new BorderLayout());

		insertarTitulo();

		this.setBackground(Color.decode("#e81416"));

		this.setBorder(BorderFactory.createLineBorder(Color.decode("#ffa500"), 5));

	}

	/**
	 * Insertar titulo.
	 */
	private void insertarTitulo() {
		titulo = new JLabel("Gestión Apartamentos Turísticos MikeleTroll", JLabel.CENTER);
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		titulo.setForeground(Color.decode("#FFFFFF"));
		this.add(titulo, BorderLayout.CENTER);

	}
}
