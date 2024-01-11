/**
 * PanelPrincipal.java
 * Nov 23, 2023 8:47:02 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * The Class PanelPrincipal.
 */
public class PanelPrincipal extends JPanel implements ActionListener {

	/** The boton alta pisos. */
	JButton botonAltaPisos;

	/** The boton baja pisos. */
	JButton botonBajaPisos;

	/**
	 * Instantiates a new panel principal.
	 */
	public PanelPrincipal() {
		super(new GridLayout(1, 2));
		botonAltaPisos = new JButton();
		botonBajaPisos = new JButton();

		insertarBoton(botonAltaPisos, "add.png");
		insertarBoton(botonBajaPisos, "remove.png");

	}

	/**
	 * Insertar boton.
	 *
	 * @param boton        the boton
	 * @param nombreImagen the nombre imagen
	 */
	private void insertarBoton(JButton boton, String nombreImagen) {
		ImageIcon imagen = new ImageIcon(getClass().getResource(String.format("/resources/%s", nombreImagen)));
		JLabel labelImagen = new JLabel(imagen);
		boton.setBackground(Color.decode("#B282AA"));
		boton.setBorder(BorderFactory.createLineBorder(Color.decode("#BB97EC"), 2));
		boton.setLayout(new BorderLayout());
		boton.add(labelImagen, BorderLayout.CENTER);
		boton.addActionListener(this);

		this.add(boton);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botonAltaPisos) {
			VentanaDialogo ventanaDialogo = new VentanaDialogo((JFrame) SwingUtilities.getWindowAncestor(this),
					"Alta Pisos", true);
			ventanaDialogo.setVisible(true);
		} else if (e.getSource() == botonBajaPisos) {
			JOptionPane.showMessageDialog(null, "Esta opción todavía no se encuentra desarrollada", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}

	}
}
