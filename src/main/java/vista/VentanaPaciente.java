/**
 * @author Marcelo Ruben Anton
 * @Change: Se agregó el el icono a la ventana y se modificó la vista de la misma para que sea mas comoda
 */

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
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Toolkit;


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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPaciente.class.getResource("/images/logo.png")));
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
		panel_1.setLayout(new MigLayout("", "[][54px][2px][39px][2px][15px][4px][212.00px]", "[30px][30px][30px][30px][30px][30px][30px][30px][30px][30px][30px][30px]"));
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel, "cell 1 0,growx,aligny center");
		
		txtDni = new JTextField();
		txtDni.setToolTipText("Ingresa en DNI sin puntos");
		panel_1.add(txtDni, "cell 7 0,grow");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1, "cell 1 1,alignx left,aligny center");
		
		txtApe = new JTextField();
		panel_1.add(txtApe, "cell 7 1,grow");
		txtApe.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2, "cell 1 2,alignx left,aligny center");
		
		txtNom = new JTextField();
		panel_1.add(txtNom, "cell 7 2,grow");
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3, "cell 1 3,growx,aligny center");
		
		txtSex = new JTextField();
		panel_1.add(txtSex, "cell 7 3,grow");
		txtSex.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_4, "cell 1 4,growx,aligny center");
		
		txtFNac = new JTextField();
		panel_1.add(txtFNac, "cell 7 4,grow");
		txtFNac.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Domicilio:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_5, "cell 1 5,alignx left,aligny bottom");
		
		txtDom = new JTextField();
		panel_1.add(txtDom, "cell 7 5,grow");
		txtDom.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Localidad:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_6, "cell 1 6,growx,aligny center");
		
		txtLoc = new JTextField();
		panel_1.add(txtLoc, "cell 7 6,grow");
		txtLoc.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Peso:");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_7, "cell 1 7,growx,aligny center");
		
		txtPeso = new JTextField();
		panel_1.add(txtPeso, "cell 7 7,grow");
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Altura:");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_8, "cell 1 8,growx,aligny center");
		
		txtAlt = new JTextField();
		panel_1.add(txtAlt, "cell 7 8,grow");
		txtAlt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Grupo:");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_9, "cell 1 9,growx,aligny center");
		
		txtGrup = new JTextField();
		panel_1.add(txtGrup, "cell 7 9,grow");
		txtGrup.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Factor:");
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_10, "cell 1 10,growx,aligny bottom");
		
		txtFac = new JTextField();
		panel_1.add(txtFac, "cell 7 10,grow");
		txtFac.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("N° Historial Clinico:");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_11, "cell 1 11,growx,aligny center");
		
		txtNroHC = new JTextField();
		panel_1.add(txtNroHC, "cell 7 11,grow");
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
