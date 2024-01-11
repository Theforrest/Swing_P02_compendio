/**
 * PanelInmueble.java
 * Nov 25, 2023 4:01:54 AM
 * @author German Najar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * The Class PanelInmuebleFormulario.
 */
public class PanelInmuebleFormulario extends JPanel implements ChangeListener, ActionListener, FocusListener {

	/** The constraints. */
	private GridBagConstraints constraints;

	/** The layout. */
	private GridBagLayout layout;

	/** The Constant COLOR_COMPONENTES. */
	private static final Color COLOR_COMPONENTES = Color.decode("#4b369d");

	/** The now. */
	private LocalDateTime now = LocalDateTime.now();

	/** The Constant FORMATO_FECHA. */
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	/** The dtf. */
	private static final DateTimeFormatter FORMATEADOR_FECHA = DateTimeFormatter.ofPattern(FORMATO_FECHA);

	/** The label direccion. */
	private JLabel labelDireccion = new JLabel("Direccion: ", SwingConstants.CENTER);

	/** The caja texto direccion. */
	private JTextField cajaTextoDireccion = new JTextField();

	/** The label provincia. */
	private JLabel labelProvincia = new JLabel("Provincia: ", SwingConstants.CENTER);

	/** The Constant PROVINCIAS. */
	private static final String[] PROVINCIAS = { "A Corunha", "alava", "Albacete", "Alicante", "Almeria", "Asturias",
			"avila", "Badajoz", "Barcelona", "Bizkaia", "Burgos", "Caceres", "Cadiz", "Cantabria", "Castellon",
			"Ciudad Real", "Cordoba", "Cuenca", "Girona", "Granda", "Guadalajara", "Gipuzcoa", "Huelva", "Huesca",
			"Islas Baleares", "Jaen", "La Rioja", "Las Palmas", "Leon", "Lleida", "Lugo", "Madrid", "Malaga", "Murcia",
			"Navarra", "Ourense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla",
			"Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Zamora", "Zaragoza" };

	/** The combo box provincias. */
	private JComboBox<String> comboBoxProvincias = new JComboBox<>(PROVINCIAS);

	/** The label fecha alta. */
	private JLabel labelFechaAlta = new JLabel("Fecha de alta: ", SwingConstants.CENTER);

	/** The caja texto formateado fecha alta. */
	private JFormattedTextField cajaTextoFormateadoFechaAlta;

	/** The label fecha disponibilidad. */
	private JLabel labelFechaDisponibilidad = new JLabel("Fecha final de disponibilidad: ", SwingConstants.CENTER);

	/** The caja texto formateado fecha disponibilidad. */
	private JFormattedTextField cajaTextoFormateadoFechaDisponibilidad;

	/** The label huespedes. */
	private JLabel labelHuespedes = new JLabel("Nº de huespedes: ", SwingConstants.CENTER);

	/** The spinner huespedes. */
	private JSpinner spinnerHuespedes = new JSpinner(new SpinnerNumberModel(0, 0, 8, 1));

	/** The label dormitorios. */
	private JLabel labelDormitorios = new JLabel("Nº de dormitorios: ", SwingConstants.CENTER);

	/** The spinner dormitorios. */
	private JSpinner spinnerDormitorios = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));

	/** The label banhos. */
	private JLabel labelBanhos = new JLabel("Nº de banhos: ", SwingConstants.CENTER);

	/** The spinner banhos. */
	private JSpinner spinnerBanhos = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));

	/** The label camas. */
	private JLabel labelCamas = new JLabel("Nº de camas: ", SwingConstants.CENTER);

	/** The spinner camas. */
	private JSpinner spinnerCamas = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));

	/** The label tipo cama. */
	private JLabel labelTipoCama = new JLabel("Tipo de camas: ", SwingConstants.CENTER);

	/** The grupo camas. */
	private ButtonGroup grupoCamas = new ButtonGroup();

	/** The radio cama simple. */
	private JRadioButton radioCamaSimple = new JRadioButton("Cama Simple");

	/** The radio cama doble. */
	private JRadioButton radioCamaDoble = new JRadioButton("Cama Doble");

	/** The radio sofa cama. */
	private JRadioButton radioSofaCama = new JRadioButton("Sofa Cama");

	/** The checkbox ninhos. */
	private JCheckBox checkboxNinhos = new JCheckBox("Ninhos");

	/** The panenl ninhos. */
	private JPanel panenlNinhos = new JPanel(new GridLayout(1, 4));

	/** The label edad ninhos. */
	private JLabel labelEdadNinhos = new JLabel("Edad de ninhos: ", SwingConstants.CENTER);

	/** The spinner edad ninhos. */
	private JSpinner spinnerEdadNinhos = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

	/** The label extras. */
	private JLabel labelExtras = new JLabel("Extras: ", SwingConstants.CENTER);

	/** The caja texto extras. */
	private JTextField cajaTextoExtras = new JTextField();

	/** The label precio minimo. */
	private JLabel labelPrecioMinimo = new JLabel("Precio Minimo: ", SwingConstants.CENTER);

	/**
	 * Instantiates a new panel inmueble formulario.
	 */
	public PanelInmuebleFormulario() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();

		addComponent(labelDireccion, 0, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(cajaTextoDireccion, 1, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelProvincia, 2, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(comboBoxProvincias, 3, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelFechaAlta, 4, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		DateFormat formatoFechaAlta = new SimpleDateFormat("dd/MM/yyyy");
		cajaTextoFormateadoFechaAlta = new JFormattedTextField(formatoFechaAlta);
		cajaTextoFormateadoFechaAlta.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		String hoy = String.format("%s", FORMATEADOR_FECHA.format(now));
		cajaTextoFormateadoFechaAlta.setText(hoy);
		addComponent(cajaTextoFormateadoFechaAlta, 5, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelFechaDisponibilidad, 6, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		cajaTextoFormateadoFechaDisponibilidad = new JFormattedTextField(formatoFechaAlta);
		cajaTextoFormateadoFechaDisponibilidad.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		String anhoSiguiente = String.format("%s", FORMATEADOR_FECHA.format(now.plusYears(1)));
		cajaTextoFormateadoFechaDisponibilidad.setText(anhoSiguiente);
		addComponent(cajaTextoFormateadoFechaDisponibilidad, 7, 0, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelHuespedes, 0, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		spinnerBanhos.addChangeListener(this);
		addComponent(spinnerHuespedes, 1, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelDormitorios, 2, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		spinnerDormitorios.addChangeListener(this);
		addComponent(spinnerDormitorios, 3, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelBanhos, 4, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		spinnerBanhos.addChangeListener(this);
		addComponent(spinnerBanhos, 5, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelCamas, 6, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		spinnerCamas.addChangeListener(this);
		addComponent(spinnerCamas, 7, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		addComponent(labelTipoCama, 0, 2, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		radioCamaSimple.setSelected(true);
		radioCamaSimple.setEnabled(false);
		radioCamaDoble.setEnabled(false);
		radioSofaCama.setEnabled(false);
		radioCamaSimple.addActionListener(this);
		radioCamaDoble.addActionListener(this);
		radioSofaCama.addActionListener(this);
		grupoCamas.add(radioCamaSimple);
		grupoCamas.add(radioCamaDoble);
		grupoCamas.add(radioSofaCama);
		addComponent(radioCamaSimple, 1, 2, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(radioCamaDoble, 2, 2, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		addComponent(radioSofaCama, 3, 2, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		checkboxNinhos.addActionListener(this);
		addComponent(checkboxNinhos, 4, 2, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
		labelEdadNinhos.setForeground(COLOR_COMPONENTES);
		panenlNinhos.add(labelEdadNinhos);
		spinnerEdadNinhos.setForeground(COLOR_COMPONENTES);
		panenlNinhos.add(spinnerEdadNinhos);
		labelExtras.setForeground(COLOR_COMPONENTES);
		panenlNinhos.add(labelExtras);
		cajaTextoExtras.addFocusListener(this);
		cajaTextoExtras.setForeground(COLOR_COMPONENTES);
		panenlNinhos.add(cajaTextoExtras);
		labelEdadNinhos.setEnabled(false);
		spinnerEdadNinhos.setEnabled(false);
		labelExtras.setEnabled(false);
		cajaTextoExtras.setEnabled(false);
		addComponent(panenlNinhos, 5, 2, 3, 1, 1, 0, GridBagConstraints.HORIZONTAL);

		calcularPrecioMinimo();
		addComponent(labelPrecioMinimo, 4, 3, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL);
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
		component.setForeground(COLOR_COMPONENTES);
		this.add(component);
	}

	/**
	 * State changed.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spinnerCamas) {
			boolean camasActivado = (Integer) spinnerCamas.getValue() > 0;
			radioCamaSimple.setEnabled(camasActivado);
			radioCamaDoble.setEnabled(camasActivado);
			radioSofaCama.setEnabled(camasActivado);

			calcularPrecioMinimo();
		} else if (e.getSource() == spinnerBanhos) {
			calcularPrecioMinimo();
		}

	}

	/**
	 * Calcular precio minimo.
	 */
	private void calcularPrecioMinimo() {
		int precioMinimo = 0;
		int camas = (Integer) spinnerCamas.getValue();

		if (radioCamaSimple.isSelected() || radioSofaCama.isSelected()) {
			precioMinimo += 15 * camas;
		} else if (radioCamaDoble.isSelected()) {
			precioMinimo += 20 * camas;
		}

		int banhos = (Integer) spinnerBanhos.getValue();
		precioMinimo += 25 * banhos;

		if (checkboxNinhos.isSelected()) {
			precioMinimo += 12;
		}

		labelPrecioMinimo.setText(String.format("Precio minimo: %d€", precioMinimo));

	}

	/**
	 * Campos validos.
	 *
	 * @return true, if successful
	 */
	public boolean camposValidos() {
		boolean validos = false;
		try {

			validos = !(cajaTextoDireccion.getText().isBlank()
					|| (new SimpleDateFormat(FORMATO_FECHA).parse(cajaTextoFormateadoFechaAlta.getText()))
							.after(new SimpleDateFormat(FORMATO_FECHA)
									.parse(cajaTextoFormateadoFechaDisponibilidad.getText())));

		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return validos;
	}

	/**
	 * Imprimir campos.
	 *
	 * @return the string
	 */
	public String imprimirCampos() {
		String tipoCamas = "NA";
		String edadNinhos = "NA";
		String extrasNinhos = "NA";

		if ((Integer) spinnerCamas.getValue() > 0) {
			if (radioCamaSimple.isSelected()) {
				tipoCamas = radioCamaSimple.getText();
			} else if (radioCamaDoble.isSelected()) {
				tipoCamas = radioCamaDoble.getText();
			} else if (radioSofaCama.isSelected()) {
				tipoCamas = radioSofaCama.getText();
			}
		}

		if (checkboxNinhos.isSelected()) {
			edadNinhos = String.format("%s", spinnerEdadNinhos.getValue());

			if ((Integer) spinnerEdadNinhos.getValue() <= 3) {
				extrasNinhos = "Cuna";
			} else {
				extrasNinhos = "Cuna supletoria pequenha";
			}
		}

		return String.format("%s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s%s, %s",
				labelDireccion.getText(), cajaTextoDireccion.getText(), labelProvincia.getText(),
				comboBoxProvincias.getSelectedItem(), labelFechaAlta.getText(), cajaTextoFormateadoFechaAlta.getText(),
				labelFechaDisponibilidad.getText(), cajaTextoFormateadoFechaDisponibilidad.getText(),
				labelHuespedes.getText(), spinnerHuespedes.getValue(), labelDormitorios.getText(),
				spinnerDormitorios.getValue(), labelBanhos.getText(), spinnerBanhos.getValue(), labelCamas.getText(),
				spinnerCamas.getValue(), labelTipoCama.getText(), tipoCamas, checkboxNinhos.getText(),
				checkboxNinhos.isSelected(), labelEdadNinhos.getText(), edadNinhos, labelExtras.getText(), extrasNinhos,
				labelPrecioMinimo.getText());
	}

	/**
	 * Reset.
	 */
	public void reset() {
		cajaTextoDireccion.setText("");
		comboBoxProvincias.setSelectedIndex(0);
		cajaTextoFormateadoFechaAlta.setText(String.format("%s", FORMATEADOR_FECHA.format(now)));
		cajaTextoFormateadoFechaDisponibilidad.setText(String.format("%s", FORMATEADOR_FECHA.format(now.plusYears(1))));
		spinnerHuespedes.setValue(0);
		spinnerDormitorios.setValue(0);
		spinnerBanhos.setValue(0);
		spinnerCamas.setValue(0);
		radioCamaSimple.setSelected(true);
		radioCamaSimple.setEnabled(false);
		radioCamaDoble.setEnabled(false);
		radioSofaCama.setEnabled(false);
		checkboxNinhos.setSelected(false);
		spinnerEdadNinhos.setValue(0);
		cajaTextoExtras.setText("");
		labelEdadNinhos.setEnabled(false);
		spinnerEdadNinhos.setEnabled(false);
		labelExtras.setEnabled(false);
		cajaTextoExtras.setEnabled(false);
		calcularPrecioMinimo();
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkboxNinhos) {
			boolean ninhosActivado = checkboxNinhos.isSelected();
			labelEdadNinhos.setEnabled(ninhosActivado);
			spinnerEdadNinhos.setEnabled(ninhosActivado);
			labelExtras.setEnabled(ninhosActivado);
			cajaTextoExtras.setEnabled(ninhosActivado);

			calcularPrecioMinimo();
		} else if (e.getSource() == radioCamaSimple || e.getSource() == radioCamaDoble
				|| e.getSource() == radioSofaCama) {
			calcularPrecioMinimo();
		}

	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == cajaTextoExtras) {
			if ((Integer) spinnerEdadNinhos.getValue() <= 3) {
				cajaTextoExtras.setText("Cuna");
			} else {
				cajaTextoExtras.setText("Cuna supletoria pequenha");
			}

		}

	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// No se hace uso de este metodo, implementado para poder usar focusGained
	}

}
