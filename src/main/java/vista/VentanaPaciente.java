package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.PacienteDAO;
import modelo.PacienteVO;


public class VentanaPaciente extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtApe;
	private JTextField txtNom;
	private JTextField txtSex;
	private JTextField txtFNac;
	private JTextField txtDom;
	private JTextField txtLoc;
	private JTextField txtPeso;
	private JTextField txtAlt;
	private JTextField txtGrup;
	private JTextField txtFac;
	private JTextField txtNroHC;
	int accion;
	private JButton btnMod;
	private JButton btnCancel;
	private JButton btnElim;
	private JButton btnAgre;
	private JButton btnBusc;
	private JButton btnGuar;
	Coordinador miCoordinador;
	
	

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
					VentanaPaciente frame = new VentanaPaciente();
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
	public VentanaPaciente() {
		setTitle("Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnGuar = new JButton("Guardar");
		btnGuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuar);
		
		btnAgre = new JButton("Agregar");
		btnAgre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		panel.add(btnAgre);
		
		btnMod = new JButton("Modificar");
		panel.add(btnMod);
		
		btnElim = new JButton("Eliminar");
		panel.add(btnElim);
		
		btnBusc = new JButton("Buscar");
		panel.add(btnBusc);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				limpiar();
			}
		});
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setBounds(66, 8, 86, 20);
		panel_1.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setBounds(10, 51, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		txtApe = new JTextField();
		txtApe.setBounds(66, 48, 86, 20);
		panel_1.add(txtApe);
		txtApe.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 99, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		txtNom = new JTextField();
		txtNom.setBounds(66, 96, 86, 20);
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo:");
		lblNewLabel_3.setBounds(10, 141, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		txtSex = new JTextField();
		txtSex.setBounds(66, 138, 86, 20);
		panel_1.add(txtSex);
		txtSex.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setBounds(10, 182, 112, 14);
		panel_1.add(lblNewLabel_4);
		
		txtFNac = new JTextField();
		txtFNac.setBounds(126, 179, 86, 20);
		panel_1.add(txtFNac);
		txtFNac.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Domicilio:");
		lblNewLabel_5.setBounds(10, 228, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		txtDom = new JTextField();
		txtDom.setBounds(66, 222, 86, 20);
		panel_1.add(txtDom);
		txtDom.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Localidad:");
		lblNewLabel_6.setBounds(10, 264, 54, 14);
		panel_1.add(lblNewLabel_6);
		
		txtLoc = new JTextField();
		txtLoc.setBounds(66, 261, 86, 20);
		panel_1.add(txtLoc);
		txtLoc.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Peso:");
		lblNewLabel_7.setBounds(10, 298, 46, 14);
		panel_1.add(lblNewLabel_7);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(66, 295, 86, 20);
		panel_1.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Altura:");
		lblNewLabel_8.setBounds(10, 337, 46, 14);
		panel_1.add(lblNewLabel_8);
		
		txtAlt = new JTextField();
		txtAlt.setBounds(66, 334, 86, 20);
		panel_1.add(txtAlt);
		txtAlt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Grupo:");
		lblNewLabel_9.setBounds(10, 365, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		txtGrup = new JTextField();
		txtGrup.setBounds(66, 362, 86, 20);
		panel_1.add(txtGrup);
		txtGrup.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Factor:");
		lblNewLabel_10.setBounds(10, 400, 46, 14);
		panel_1.add(lblNewLabel_10);
		
		txtFac = new JTextField();
		txtFac.setBounds(66, 393, 86, 20);
		panel_1.add(txtFac);
		txtFac.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("N° Historial Clinico:");
		lblNewLabel_11.setBounds(10, 442, 95, 14);
		panel_1.add(lblNewLabel_11);
		
		txtNroHC = new JTextField();
		txtNroHC.setBounds(107, 439, 86, 20);
		panel_1.add(txtNroHC);
		txtNroHC.setColumns(10);
		
		limpiar();
	}

	protected void guardar() {
		try {
			PacienteVO miPacienteVO = new PacienteVO();
			miPacienteVO.setDni(Integer.valueOf(txtDni.getText()));
			miPacienteVO.setApe(txtApe.getText());
			miPacienteVO.setNom(txtNom.getText());
			miPacienteVO.setSex(txtSex.getText());
			miPacienteVO.setFnac(txtFNac.getText());
			miPacienteVO.setDom(txtDom.getText());
			miPacienteVO.setLoc(txtLoc.getText());
			miPacienteVO.setPeso(Float.valueOf(txtPeso.getText()));
			miPacienteVO.setAlt(Float.valueOf(txtAlt.getText()));
			miPacienteVO.setGrup(txtGrup.getText());
			miPacienteVO.setFac(txtFac.getText());
			miPacienteVO.setNroHC(Integer.valueOf(txtNroHC.getText()));
			
			PacienteDAO miPacienteDAO = new PacienteDAO();
			if(accion==1) {
				
				miPacienteDAO.registrarPaciente(miPacienteVO);
			}
			else {
				miPacienteDAO.modificarPaciente(miPacienteVO);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el Ingreso", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void agregar() {
		accion=1;
		habilita(true,true,true,true,true,true,true,true,true,true,true,true,true,false,false,false,false,true);
		
	}
	public void habilita(boolean dni, boolean ape, boolean nom, boolean sex, boolean fnac, boolean dom, boolean loc, boolean peso, boolean alt, boolean grup, boolean fac, boolean nroHC, boolean guar,boolean agre, boolean mod, boolean elim, boolean busc,  boolean cancel ) {
		txtDni.setEditable(dni);
		txtApe.setEditable(ape);
		txtNom.setEditable(nom);
		txtSex.setEditable(sex);
		txtFNac.setEditable(fnac);
		txtDom.setEditable(dom);
		txtLoc.setEditable(loc);
		txtPeso.setEditable(peso);
		txtAlt.setEditable(alt);
		txtGrup.setEditable(grup);
		txtFac.setEditable(fac);
		txtNroHC.setEditable(nroHC);
		btnGuar.setVisible(guar);
		btnMod.setEnabled(mod);
		btnElim.setEnabled(elim);
		btnBusc.setEnabled(busc);
		btnAgre.setEnabled(agre);
		btnCancel.setEnabled(cancel);
		
	}
	
	public void limpiar() {
		txtDni.setText("");
		txtApe.setText("");
		txtNom.setText("");
		txtSex.setText("");
		txtFNac.setText("");
		txtDom.setText("");
		txtLoc.setText("");
		txtPeso.setText("");
		txtAlt.setText("");
		txtGrup.setText("");
		txtFac.setText("");
		txtNroHC.setText("");
		
		habilita(true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true);
	}
}
