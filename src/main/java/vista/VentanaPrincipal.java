/**
 * @author Marcelo Ruben Anton
 * @Change: + `cvCambiarSkins`
 * 			+ `btnCambiarSkin`
 * 			+ Window Drageer
 * 			+ Se saco el marco de la ventana
 * 			- Se corrigio un error que al momento de sacar el marco, provoca un error en el coordinador
 * 			+ Se agregaron los skins "FlatLightLaf", "FlatDarkLaf", "FlatMacDarkLaf"
 * 			+ Se agregó un panel que funciona como boton de cierre `btnClose` junto con su `lblX` 
 * 			+ Se agregó una nueva clase para configurar los Skins `CambiarSkin`
 */

package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controlador.CambiarSkin;
import controlador.Coordinador;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaPrincipal extends JFrame {
	// Guardamos la posición del mouse
	private static Point mouseDownCompCoords = null;
	private JPanel panelPrincipal;
	private Coordinador miCoordinador;
	private JComboBox<String> cbCambiarSkin;

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();

					// Inicializar el Coordinador antes de mostrar la ventana
					Coordinador miCoordinador = new Coordinador();
					frame.setMiCoordinador(miCoordinador); // Asignar el Coordinador

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {

		JButton btnPacientes = new JButton("Pacientes");
		JButton btnMedicos = new JButton("Médicos");
		JButton btnEstudios = new JButton("Estudios");
		JLabel lblLogo = new JLabel("");
		JPanel panel = new JPanel();
		JPanel btnClose = new JPanel();
		JLabel lblX = new JLabel("X");

		panelPrincipal = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(SystemColor.controlDkShadow);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/images/logo.png")));

		setResizable(false); // La ventana no se puyede cambiar de tamaño
		setUndecorated(true); // Elimina el marco de la ventana
		setLocationRelativeTo(null); // Centramos la ventana en la pantalla

		setBounds(100, 100, 720, 340);
		panelPrincipal.setBackground(SystemColor.controlDkShadow);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		// Botón Pacientes
		btnPacientes.setBounds(51, 150, 120, 35);
		btnPacientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Botón Médicos
		btnMedicos.setBounds(181, 150, 120, 35);
		btnMedicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Boton Estudio
		btnEstudios.setBounds(311, 150, 120, 35);
		btnEstudios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Agremos el logo del Superior Logo
		lblLogo.setBounds(470, 0, 200, 340);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/logo.png")));

		// Panel de cierre
		panel.setBounds(680, 0, 40, 40);
		panel.setLayout(null);

		// Botón cerrar
		btnClose.setBackground(new Color(45, 45, 45));
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setBounds(0, 0, 41, 40);
		panel.add(btnClose);
		btnClose.setLayout(null);

		// Label para mostrar la X para que de manera visual denote que es para cerrar
		// la aplicacion
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblX.setBounds(0, 0, 40, 40);
		btnClose.add(lblX);

		// ComboBox para seleccionar el skin
		JComboBox cbCambiarSkin = new JComboBox();
		JButton btnCambiarSkin = new JButton("Cambiar");
		cbCambiarSkin.setToolTipText("Cambia los colores de la aplicación");
		btnCambiarSkin.setBounds(212, 11, 94, 29);
		cbCambiarSkin
				.setModel(new DefaultComboBoxModel(new String[] { "FlatLightLaf", "FlatDarkLaf", "FlatMacDarkLaf" }));
		cbCambiarSkin.setBounds(51, 11, 151, 29);

		panelPrincipal.add(panel);
		panelPrincipal.add(cbCambiarSkin);
		panelPrincipal.add(btnCambiarSkin);
		panelPrincipal.add(lblLogo);
		panelPrincipal.add(btnEstudios);
		panelPrincipal.add(btnPacientes);
		panelPrincipal.add(btnMedicos);

		// Mostramos la ventana Estudio
		btnEstudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.mostrarVentanaEstudio();
			}
		});
		// Eventos del botón cerrar
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			// Cambiamos el color del panel y del lbl si el mouse entro
			public void mouseEntered(MouseEvent e) {
				btnClose.setBackground(Color.RED);
				lblX.setForeground(Color.WHITE);
			}

			@Override
			// Cambiamos el color del panel y del lbl si el mouse salio
			public void mouseExited(MouseEvent e) {
				btnClose.setBackground(new Color(45, 45, 45));
				lblX.setForeground(Color.BLACK);
			}

			@Override
			// Si el panel (btnClose) esta presionado la aplicacion se cierra
			public void mouseClicked(MouseEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});

		// Guardamos la posicion del mouse
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}
		});

		// movemos la ventana a la poosicion del mouse si el boton del mouse esta
		// presionado
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});
		// Mostramos la ventana Medico
		btnMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miCoordinador != null) {
					miCoordinador.mostrarVentanaMedico();
				} else {
					System.out.println("Error: miCoordinador no ha sido inicializado.");
				}
			}
		});
		// Mostramos la ventana paciente
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miCoordinador != null) {
					miCoordinador.mostrarVentanaPaciente();
				} else {
					System.out.println("Error: miCoordinador no ha sido inicializado.");
				}
			}
		});

		// Boton para ejecutar el skin elegido en el combobox y realizar el cambio

		btnCambiarSkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String skinSeleccionado = (String) cbCambiarSkin.getSelectedItem();
				CambiarSkin.setSkin(skinSeleccionado);
				SwingUtilities.updateComponentTreeUI(VentanaPrincipal.this);

			}
		});

	}
}
