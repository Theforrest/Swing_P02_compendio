/**
 * PanelDialogo.java
 * Nov 23, 2023 8:31:57 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The Class PanelDialogo.
 */
public class PanelDialogo extends JPanel implements ActionListener {

	/** The panel titulo. */
	PanelTitulo panelTitulo;

	/** The panel arrendador. */
	PanelArrendador panelArrendador;

	/** The panel inmueble. */
	PanelInmueble panelInmueble;

	/** The panel impresos. */
	PanelImpresos panelImpresos;

	/** The boton imprimir. */
	JButton botonImprimir;

	/** The boton nuevo. */
	JButton botonNuevo;

	/** The boton guardar. */
	JButton botonGuardar;

	/** The boton file searcher. */
	JButton botonFileSearcher;

	/** The file chooser. */
	JFileChooser fileChooser;

	/**
	 * Instantiates a new panel dialogo.
	 */
	public PanelDialogo() {
		super(new GridLayout(8, 1));

		panelTitulo = new PanelTitulo();
		this.add(panelTitulo);

		panelArrendador = new PanelArrendador();
		this.add(panelArrendador);

		panelInmueble = new PanelInmueble();
		this.add(panelInmueble);

		panelImpresos = new PanelImpresos();
		this.add(panelImpresos);

		botonImprimir = new JButton();
		insertarBoton(botonImprimir, "print.png");

		botonNuevo = new JButton();
		insertarBoton(botonNuevo, "new.png");

		botonGuardar = new JButton();
		insertarBoton(botonGuardar, "save.png");

		fileChooser = new JFileChooser();
		botonFileSearcher = new JButton();

		insertarBoton(botonFileSearcher, "folder.png");
	}

	/**
	 * Insertar boton.
	 *
	 * @param boton        the boton
	 * @param nombreImagen the nombre imagen
	 */
	private void insertarBoton(JButton boton, String nombreImagen) {
		ImageIcon imagen = new ImageIcon(
				new ImageIcon(getClass().getResource(String.format("/resources/%s", nombreImagen))).getImage()
						.getScaledInstance(112, 75, Image.SCALE_SMOOTH));
		JLabel labelImagen = new JLabel(imagen);
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
		if (e.getSource() == botonImprimir) {
			if (panelArrendador.camposValidos()) {
				panelImpresos.insertarArrendados(panelArrendador.imprimirCampos());
			} else {
				JOptionPane.showMessageDialog(null, "Todos los campos de los arrendados deben de ser correctos",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			if (panelInmueble.camposValidos()) {
				panelImpresos.insertarInmuebles(panelInmueble.imprimirCampos());
			} else {
				JOptionPane.showMessageDialog(null, "Todos los campos del inmueble deben de ser correctos",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == botonNuevo) {
			panelArrendador.reset();
			panelInmueble.reset();
			panelImpresos.reset();
		} else if (e.getSource() == botonGuardar) {
			if (panelArrendador.camposValidos() && panelInmueble.camposValidos()) {
				JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Todos los campos deben de ser correctos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == botonFileSearcher) {
			fileChooser.showOpenDialog(this);
			File file = fileChooser.getSelectedFile();
			if (file != null) {
				JOptionPane.showMessageDialog(null, String.format("Nombre del archivo: %s", file.getName()),
						"Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
}
