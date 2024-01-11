/**
 * PanelInmueble.java
 * Nov 25, 2023 4:01:54 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * The Class PanelInmueble.
 */
public class PanelInmueble extends JPanel {

	/** The constraints. */
	private GridBagConstraints constraints;

	/** The layout. */
	private GridBagLayout layout;

	/** The panel inmueble formulario. */
	private PanelInmuebleFormulario panelInmuebleFormulario = new PanelInmuebleFormulario();

	/** The panel imagenes. */
	private JPanel panelImagenes = new PanelImagenes();

	/**
	 * Instantiates a new panel inmueble.
	 */
	public PanelInmueble() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		addComponent(panelInmuebleFormulario, 0, 0, 1, 1, 2, 0, GridBagConstraints.BOTH);
		addComponent(panelImagenes, 1, 0, 1, 1, 1, 0, GridBagConstraints.BOTH);
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#70369d"), 5));
	}

	/**
	 * Campos validos.
	 *
	 * @return true, if successful
	 */
	public boolean camposValidos() {
		return panelInmuebleFormulario.camposValidos();
	}

	/**
	 * Imprimir campos.
	 *
	 * @return the string
	 */
	public String imprimirCampos() {
		return panelInmuebleFormulario.imprimirCampos();
	}

	/**
	 * Reset.
	 */
	public void reset() {
		panelInmuebleFormulario.reset();
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

}
