package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VentanaItemHistoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid_medico;
	private JTextField textField;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaItemHistoria frame = new VentanaItemHistoria();
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
	public VentanaItemHistoria() {
		setTitle("ITEM HISTORIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					guardar();
			}

			private void guardar() {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { modificar();
			}

			private void modificar() {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				eliminar();
			}

			private void eliminar() {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				
			}

			private void guardar() {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("+ ENFERMERIA +");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Castellar", Font.PLAIN, 40));
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Historia Clínica");
		lblNewLabel_1.setBounds(5, 8, 83, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de Médico");
		lblNewLabel_2.setBounds(5, 40, 97, 14);
		panel_3.add(lblNewLabel_2);
		
		txtid_medico = new JTextField();
		txtid_medico.setBounds(103, 37, 86, 20);
		panel_3.add(txtid_medico);
		txtid_medico.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Diagnóstico");
		lblNewLabel_3.setBounds(27, 77, 61, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de Paciente");
		lblNewLabel_4.setBounds(193, 40, 102, 14);
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(295, 37, 86, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(93, 72, 212, 65);
		panel_3.add(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("nro_hc");
		lblNewLabel_5.setBounds(120, 8, 83, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setBounds(236, 8, 46, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("fecha_hc");
		lblNewLabel_7.setBounds(296, 8, 46, 14);
		panel_3.add(lblNewLabel_7);
	//	contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnAgregar, btnModificar, btnEliminar, btnGuardar, btnCancelar, panel, panel_1, lblNewLabel, lblNewLabel_1, panel_3, lblNewLabel_2, txtid_medico, lblNewLabel_3, lblNewLabel_4, textField, textArea, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7}));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}

			private void cancelar() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public JButton getbtnAgregar() {
		return btnAgregar;
	}
	public JButton getbtnModificar() {
		return btnModificar;
	}
	public JButton getbtnEliminar() {
		return btnEliminar;
	}
	public JButton getbtnGuardar() {
		return btnGuardar;
	}
	public JButton getbtnCancelar() {
		return btnCancelar;
	}
}
