package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.PacienteDAO;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPacienteBuscar extends JFrame {

	private JPanel contentPane;
	Coordinador miCoordinador;
	JTable tabla;
	
	

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
					VentanaPacienteBuscar frame = new VentanaPacienteBuscar();
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
	public VentanaPacienteBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnVolv = new JButton("Volver");
		btnVolv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnVolv);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	public void mostrarDatosConTableModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabla = new JTable();
		tabla.setModel(modelo);
		modelo.addColumn("Dni");
		modelo.addColumn("Apellido");
		modelo.addColumn("Nombre");
		modelo.addColumn("Sexo");
		modelo.addColumn("Fecha nacimiento");
		modelo.addColumn("Domicilio");
		modelo.addColumn("Localidad");
		modelo.addColumn("Peso");
		modelo.addColumn("Altura");
		modelo.addColumn("Grupo sanguíneo");
		modelo.addColumn("Factor");
		modelo.addColumn("Numero historial clinico");
		PacienteDAO miPacienteDAO = new PacienteDAO();
		miPacienteDAO.buscarPaciente(modelo);
	}

}
