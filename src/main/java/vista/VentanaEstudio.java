package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.EstudioVO;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEstudio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtTipo;
	private JTextField txtEstudio;
	private JTextField txtResultado;
	private JTextField txtMedico;
	private JButton btneliminar;
	private JButton btncancelar;
	private JButton btnagregar;
	private JButton btnbuscar;
	private JButton btnmodificar;
	private JButton btnguar;
	protected int accion;
	private JTextField txtFecha;
	private Coordinador miCoordinador;
	
	

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
					VentanaEstudio frame = new VentanaEstudio();
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
	public VentanaEstudio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 226, 531, 43);
		contentPane.add(panel);
		
		
		btnguar = new JButton("Guardar");
		btnguar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarEstudio();
			}
		});
		panel.add(btnguar);
		
		btnagregar = new JButton("Agregar");
		btnagregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion =1;
				agregarEstudio();
			}
		});
		panel.add(btnagregar);
		
		btnmodificar = new JButton("Modificar");
		btnmodificar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				accion=2;
				habilita(true,false,false,true,true,true,false,true,false,true,false);
			}
		});
		panel.add(btnmodificar);
		
		btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEstudio();
			}
		});
		panel.add(btnbuscar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  eliminarEstudio();
			}
		});
		panel.add(btneliminar);
		
		btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelar();
			}
		});
		panel.add(btncancelar);
		
		JLabel lbldni = new JLabel("DNI");
		lbldni.setBounds(10, 50, 46, 14);
		contentPane.add(lbldni);
		
		txtDni = new JTextField();
		txtDni.setBounds(77, 50, 106, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lbltipo = new JLabel("Tipo");
		lbltipo.setBounds(10, 91, 46, 14);
		contentPane.add(lbltipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(77, 88, 106, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblestudio = new JLabel("Estudio");
		lblestudio.setBounds(10, 24, 46, 14);
		contentPane.add(lblestudio);
		
		txtEstudio = new JTextField();
		txtEstudio.setBounds(77, 19, 149, 20);
		contentPane.add(txtEstudio);
		txtEstudio.setColumns(10);
		
		JLabel lblresultado = new JLabel("Resultado");
		lblresultado.setBounds(10, 132, 56, 14);
		contentPane.add(lblresultado);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(77, 129, 139, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		JLabel lblmedico = new JLabel("Medico");
		lblmedico.setBounds(10, 172, 46, 14);
		contentPane.add(lblmedico);
		
		txtMedico = new JTextField();
		txtMedico.setBounds(77, 169, 106, 20);
		contentPane.add(txtMedico);
		txtMedico.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 197, 46, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(77, 200, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
	}

	protected void guardarEstudio() {
		try {
			EstudioVO miEstudio = new EstudioVO();
		//	miEstudio.setAlestudio(Integer.valueOf(.getText());
			miEstudio.setAldni(Integer.parseInt(txtDni.getText()));
			miEstudio.setAltipo(txtTipo.getText());
			miEstudio.setAlres(txtResultado.getText());
		    miEstudio.setAlmedic(txtMedico.getText());
		    
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error en el Ingreso de Datos", "Error",
					JOptionPane.ERROR_MESSAGE);
			limpiar();
	
		}
		}	
	

	private void limpiar() {
		txtEstudio.setText("");
		txtDni.setText("");
		txtTipo.setText("");
		txtResultado.setText("");
		txtMedico.setText("");
		habilita(true,false,false,false,false,true,true,false,true,false,true);
	}

	private void habilita(boolean estudio, boolean dni, boolean tipo, boolean resultado, boolean medico, boolean bGuardar, boolean bAgregar, boolean bModificar, boolean bBuscar, boolean bEliminar, boolean bCancelar) {
		txtEstudio.setEditable(estudio);
		txtDni.setEditable(dni);
		txtTipo.setEditable(tipo);
		txtResultado.setEditable(resultado);
		txtMedico.setEditable(medico);
		btnguar.setVisible(bGuardar);
		btneliminar.setEnabled(bEliminar);
		btncancelar.setVisible(bCancelar);
		btnmodificar.setEnabled(bModificar);
        btnbuscar.setEnabled(bBuscar);
        btnagregar.setEnabled(bAgregar);
	}

	protected void buscarEstudio() {
		int doc;
		if(txtDni.getText().isEmpty())
			doc=0;
		else
			doc=Integer.valueOf(txtDni.getText());
		miCoordinador.mostrarVentanaEstudio();
		
	}

	protected void eliminarEstudio() {
		if(!txtDni.getText().equals(""))
		{
			int respuesta = JOptionPane.showConfirmDialog(null,"Esta seguro que quiere eliminar el estudio?","Confirmacion",JOptionPane.YES_NO_OPTION );
		
	 	    if(respuesta == JOptionPane.YES_NO_OPTION)
	 	    {
	 	    
	 	    }
		}
		else {
			JOptionPane.showConfirmDialog(null, "IIngrese un numero de Documento","Informacion", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected void agregarEstudio() {
		habilita(true,true,true,true,true,true,true,false,true,false,false);
		
	}

	protected void Cancelar() {
		limpiar();

	}
	public JButton getBtneliminar() {
		return btneliminar;
	}
	public JButton getBtncancelar() {
		return btncancelar;
	}
	public JButton getBtnagregar() {
		return btnagregar;
	}
	public JButton getBtnbuscar() {
		return btnbuscar;
	}
	public JButton getBtnmodificar() {
		return btnmodificar;
	}
	public JButton getBtnguar() {
		return btnguar;
	}
}
