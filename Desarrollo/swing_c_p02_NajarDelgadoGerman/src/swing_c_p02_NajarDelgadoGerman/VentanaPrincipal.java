/**
 * VentanaPrincipal.java
 * Nov 19, 2023 1:55:56 AM
 * @author Germán Nájar Delgado
*/
package swing_c_p02_NajarDelgadoGerman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

	/** The barra menu. */
	private JMenuBar barraMenu;

	/** The menu archivo. */
	private JMenu menuArchivo;

	/** The item salir. */
	private JMenuItem itemSalir;

	/** The menu registro. */
	private JMenu menuRegistro;

	/** The item alta pisos. */
	private JMenuItem itemAltaPisos;

	/** The item baja pisos. */
	private JMenuItem itemBajaPisos;

	/** The menu ayuda. */
	private JMenu menuAyuda;

	/** The item acerca de. */
	private JMenuItem itemAcercaDe;

	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {
		super("Gestión Apartamentos Turísticos MikeleTroll");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimensiones = pantalla.getScreenSize();

		int altoPantalla = dimensiones.height;
		int anchoPantalla = dimensiones.width;

		this.setBounds(anchoPantalla / 4, altoPantalla / 4, anchoPantalla / 2, altoPantalla / 2);

		this.setIconImage(new ImageIcon(getClass().getResource("/resources/Icon.PNG")).getImage());

		barraMenu = new JMenuBar();
		barraMenu.setBackground(Color.decode("#BB97EC"));

		menuArchivo = new JMenu("Archivo");
		itemSalir = new JMenuItem("Salir");

		menuRegistro = new JMenu("Registro");
		menuRegistro.setMnemonic(KeyEvent.VK_R);
		itemAltaPisos = new JMenuItem("Alta Pisos");
		itemAltaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		itemBajaPisos = new JMenuItem("Baja Pisos");
		itemBajaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));

		menuAyuda = new JMenu("Ayuda");
		itemAcercaDe = new JMenuItem("Acerca de...");

		insertarItems(menuArchivo, itemSalir);
		insertarItems(menuRegistro, itemAltaPisos, itemBajaPisos);
		insertarItems(menuAyuda, itemAcercaDe);

		insertarMenus(barraMenu, menuArchivo, menuRegistro, menuAyuda);

		this.setJMenuBar(barraMenu);

		JPanel panelPrincipal = new PanelPrincipal();
		this.add(panelPrincipal);
	}

	/**
	 * Insertar items.
	 *
	 * @param menu  the menu
	 * @param items the items
	 */
	private void insertarItems(JMenu menu, JMenuItem... items) {
		if (menu == null) {
			throw new NullPointerException("No se puede insertar items en un menú nulo");
		}
		if (items == null) {
			throw new NullPointerException("No se pueden insertar una lista de items nula");
		}
		if (items.length == 0) {
			throw new IllegalArgumentException("La lista de items de un menú no puede estar vacía");
		}

		for (JMenuItem item : items) {
			item.addActionListener(this);
			item.setBackground(Color.decode("#D59CC8"));
			menu.add(item);
		}
	}

	/**
	 * Insertar menus.
	 *
	 * @param barra the barra
	 * @param menus the menus
	 */
	private void insertarMenus(JMenuBar barra, JMenu... menus) {
		if (barra == null) {
			throw new NullPointerException("No se puede insertar items en un menú nulo");
		}
		if (menus == null) {
			throw new NullPointerException("No se pueden insertar una lista de menus nula");
		}
		if (menus.length == 0) {
			throw new IllegalArgumentException("La lista de menus de un menú no puede estar vacía");
		}

		for (JMenu menu : menus) {
			barra.add(menu);
		}
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemSalir) {
			this.dispose();
		} else if (e.getSource() == itemAltaPisos) {
			VentanaDialogo ventanaDialogo = new VentanaDialogo(this, "Alta Pisos", true);
			ventanaDialogo.setVisible(true);
		} else if (e.getSource() == itemBajaPisos) {
			JOptionPane.showMessageDialog(null, "Esta opción todavía no se encuentra desarrollada", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		} else if (e.getSource() == itemAcercaDe) {
			JOptionPane.showMessageDialog(null,
					"Nombre de la empresa: Gestión Apartamentos Turísticos MikeleTroll\nDescripción en esta empresa nos encargamos de gestionar apartamentos turísticos",
					"Información", JOptionPane.PLAIN_MESSAGE);
		}

	}

}
