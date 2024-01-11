/**
 * PanelImpresos.java
 * Nov 25, 2023 11:52:34 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * The Class PanelImpresos.
 */
public class PanelImpresos extends JTabbedPane {

	/** The panel arrendados. */
	private JPanel panelArrendados = new JPanel();

	/** The label arrendados. */
	private JLabel labelArrendados = new JLabel();

	/** The panel inmuebles. */
	private JPanel panelInmuebles = new JPanel();

	/** The label inmuebles. */
	private JLabel labelInmuebles = new JLabel();

	/**
	 * Instantiates a new panel impresos.
	 */
	public PanelImpresos() {
		labelArrendados.setFont(new Font("Arial", Font.BOLD, 25));
		panelArrendados.add(labelArrendados);
		this.add("Impreso Arrendados", panelArrendados);

		labelInmuebles.setFont(new Font("TimesRoman", Font.ITALIC, 10));
		panelInmuebles.add(labelInmuebles);
		this.add("Impreso Inmuebles", panelInmuebles);
	}

	/**
	 * Insertar arrendados.
	 *
	 * @param arrendados the arrendados
	 */
	public void insertarArrendados(String arrendados) {
		labelArrendados.setText(arrendados);
	}

	/**
	 * Insertar inmuebles.
	 *
	 * @param inmuebles the inmuebles
	 */
	public void insertarInmuebles(String inmuebles) {
		labelInmuebles.setText(inmuebles);
	}

	/**
	 * Reset.
	 */
	public void reset() {
		labelArrendados.setText("");
		labelInmuebles.setText("");
	}
}
