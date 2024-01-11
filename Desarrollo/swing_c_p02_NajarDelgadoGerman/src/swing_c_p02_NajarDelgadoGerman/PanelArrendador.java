/**
 * PanelArrendador.java
 * Nov 24, 2023 8:36:20 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


/**
 * The Class PanelArrendador.
 */
public class PanelArrendador extends JPanel {

	/** The constraints. */
	private GridBagConstraints constraints;

	/** The layout. */
	private GridBagLayout layout;

	/** The label nombre. */
	private JLabel labelNombre = new JLabel();

	/** The caja texto nombre. */
	private JTextField cajaTextoNombre = new JTextField();

	/** The label apellidos. */
	private JLabel labelApellidos = new JLabel();

	/** The caja texto apellidos. */
	private JTextField cajaTextoApellidos = new JTextField();

	/** The label telefono. */
	private JLabel labelTelefono = new JLabel();

	/** The caja texto formateado telefono. */
	private JFormattedTextField cajaTextoFormateadoTelefono = new JFormattedTextField();

	/** The label dni. */
	private JLabel labelDni = new JLabel();

	/** The caja texto formateado dni. */
	private JFormattedTextField cajaTextoFormateadoDni = new JFormattedTextField();

	/**
	 * Instantiates a new panel arrendador.
	 */
	public PanelArrendador() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		labelNombre.setText("Nombre:");
		addComponent(new JLabel(), 0, 0, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);
		addComponent(labelNombre, 1, 0, 1, 1, 0, 0, GridBagConstraints.NONE);
		addComponent(cajaTextoNombre, 2, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(new JLabel(), 3, 0, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);

		labelApellidos.setText("Apellidos:");
		addComponent(new JLabel(), 0, 1, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);
		addComponent(labelApellidos, 1, 1, 1, 1, 0, 0, GridBagConstraints.NONE);
		addComponent(cajaTextoApellidos, 2, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(new JLabel(), 3, 1, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);

		labelTelefono.setText("Telefono:");
		ponerMascara(cajaTextoFormateadoTelefono, "#########");

		addComponent(new JLabel(), 0, 2, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);
		addComponent(labelTelefono, 1, 2, 1, 1, 0, 0, GridBagConstraints.NONE);
		addComponent(cajaTextoFormateadoTelefono, 2, 2, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(new JLabel(), 3, 2, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);

		labelDni.setText("DNI:");
		ponerMascara(cajaTextoFormateadoDni, "########?");

		addComponent(new JLabel(), 0, 3, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);
		addComponent(labelDni, 1, 3, 1, 1, 0, 0, GridBagConstraints.NONE);
		addComponent(cajaTextoFormateadoDni, 2, 3, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(new JLabel(), 3, 3, 1, 1, 2, 0, GridBagConstraints.HORIZONTAL);

		this.setBorder(BorderFactory.createLineBorder(Color.decode("#79c314"), 5));

	}

	/**
	 * Poner mascara.
	 *
	 * @param cajaTextoFormateado the caja texto formateado
	 * @param mascaraTexto        the mascara texto
	 */
	private void ponerMascara(JFormattedTextField cajaTextoFormateado, String mascaraTexto) {
		try {
			MaskFormatter mascara;
			mascara = new MaskFormatter(mascaraTexto);

			cajaTextoFormateado.setFormatterFactory(new DefaultFormatterFactory(mascara));

			cajaTextoFormateado.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Campos validos.
	 *
	 * @return true, if successful
	 */
	public boolean camposValidos() {
		return !(cajaTextoNombre.getText().isBlank() || cajaTextoApellidos.getText().isBlank()
				|| cajaTextoFormateadoDni.getText().isBlank() || cajaTextoFormateadoTelefono.getText().isBlank());
	}

	/**
	 * Imprimir campos.
	 *
	 * @return the string
	 */
	public String imprimirCampos() {
		return String.format("%s%s, %s%s, %s%s, %s%s", labelNombre.getText(), cajaTextoNombre.getText(),
				labelApellidos.getText(), cajaTextoApellidos.getText(), labelDni.getText(),
				cajaTextoFormateadoDni.getText(), labelTelefono.getText(), cajaTextoFormateadoTelefono.getText());
	}

	/**
	 * Reset.
	 */
	public void reset() {
		cajaTextoNombre.setText("");
		cajaTextoApellidos.setText("");
		cajaTextoFormateadoDni.setText("");
		cajaTextoFormateadoTelefono.setText("");
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