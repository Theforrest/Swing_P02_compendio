/**
 * PanelImagenes.java
 * Nov 25, 2023 5:10:19 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * The Class PanelImagenes.
 */
public class PanelImagenes extends JPanel implements ActionListener {

	/** The constraints. */
	private GridBagConstraints constraints;

	/** The layout. */
	private GridBagLayout layout;

	/** The imagenes. */
	private final ImageIcon[] imagenes = { new ImageIcon(getClass().getResource("/resources/dinnerroom.jpeg")),
			new ImageIcon(getClass().getResource("/resources/bathroom.jpeg")),
			new ImageIcon(getClass().getResource("/resources/bedroom.jpeg")) };

	/** The num imagen. */
	private int numImagen = 0;

	/** The label imagen. */
	private JLabel labelImagen = new JLabel(imagenes[numImagen]);

	/** The flecha izquierda. */
	private ImageIcon flechaIzquierda = new ImageIcon(getClass().getResource("/resources/leftArrow.png"));

	/** The flecha derecha. */
	private ImageIcon flechaDerecha = new ImageIcon(getClass().getResource("/resources/rightArrow.png"));

	/** The boton izquierda. */
	private JButton botonIzquierda = new JButton(flechaIzquierda);

	/** The boton derecha. */
	private JButton botonDerecha = new JButton(flechaDerecha);

	/**
	 * Instantiates a new panel imagenes.
	 */
	public PanelImagenes() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent componentEvent) {
				resizeImages();
			}
		});
		botonIzquierda.addActionListener(this);
		botonDerecha.addActionListener(this);

		addComponent(labelImagen, 0, 0, 2, 1, 0, 0, GridBagConstraints.BOTH);
		addComponent(botonIzquierda, 0, 1, 1, 1, 0, 0, GridBagConstraints.BOTH);
		addComponent(botonDerecha, 1, 1, 1, 1, 0, 0, GridBagConstraints.BOTH);

	}

	/**
	 * Adds the component.
	 *
	 * @param component the component
	 * @param column    the column
	 * @param row       the row
	 * @param width     the width
	 * @param height    the height
	 * @param weightx   the weightx
	 * @param weighty   the weighty
	 * @param fill      the fill
	 */
	private void addComponent(Component component, int column, int row, int width, int height, int weightx, int weighty,
			int fill) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		layout.setConstraints(component, constraints);
		component.setForeground(Color.decode("#487DE7"));
		this.add(component);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonIzquierda) {
			if (numImagen != 0) {
				numImagen--;
			} else {
				numImagen = imagenes.length - 1;
			}
			resizeImages();
		} else if (e.getSource() == botonDerecha) {
			if (numImagen != imagenes.length - 1) {
				numImagen++;
			} else {
				numImagen = 0;
			}
			resizeImages();
		}

	}

	/**
	 * Resize images.
	 */
	private void resizeImages() {
		int altoPanel = this.getParent().getHeight();
		int anchoPanel = this.getParent().getWidth();

		labelImagen.setIcon(new ImageIcon(imagenes[numImagen].getImage().getScaledInstance(anchoPanel / 8,
				altoPanel - altoPanel / 4, Image.SCALE_DEFAULT)));
		botonIzquierda.setIcon(new ImageIcon(
				flechaIzquierda.getImage().getScaledInstance(anchoPanel / 24, altoPanel / 6, Image.SCALE_SMOOTH)));
		botonDerecha.setIcon(new ImageIcon(
				flechaDerecha.getImage().getScaledInstance(anchoPanel / 24, altoPanel / 6, Image.SCALE_SMOOTH)));

	}
}
