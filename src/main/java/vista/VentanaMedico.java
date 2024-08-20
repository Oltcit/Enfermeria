package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.MedicoVO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMedico extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMedDni;
    private JTextField txtMedApellido;
    private JTextField txtMedNombre;
    private JTextField txtMedDomicilio;
    private JTextField txtMedMatricula;
    private JTextField txtMedEspecializacion;
    private JComboBox<String> cbLocalidad;

    private Coordinador miCoordinador;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnAgregar;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private int accion;
    private JButton btnBuscar;

    /**
     * Inicio aplicación.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaMedico frame = new VentanaMedico();
                    frame.setVisible(true);
                    frame.limpiar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crea la ventana.
     */
    public VentanaMedico() {
        setTitle("Medico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 640, 419);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelMedico = new JPanel();
        contentPane.add(panelMedico, BorderLayout.CENTER);
        panelMedico.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel label = new JLabel("DNI:");
        panelMedico.add(label);

        txtMedDni = new JTextField();
        txtMedDni.setColumns(10);
        panelMedico.add(txtMedDni);

        JLabel label_1 = new JLabel("Apellido:");
        panelMedico.add(label_1);

        txtMedApellido = new JTextField();
        txtMedApellido.setColumns(10);
        panelMedico.add(txtMedApellido);

        JLabel label_2 = new JLabel("Nombre:");
        panelMedico.add(label_2);

        txtMedNombre = new JTextField();
        txtMedNombre.setColumns(10);
        panelMedico.add(txtMedNombre);

        JLabel label_3 = new JLabel("Domicilio:");
        panelMedico.add(label_3);

        txtMedDomicilio = new JTextField();
        txtMedDomicilio.setColumns(10);
        panelMedico.add(txtMedDomicilio);

        JLabel label_4 = new JLabel("Localidad:");
        panelMedico.add(label_4);

        cbLocalidad = new JComboBox<String>();
        cbLocalidad.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Cañuelas", "Gral. Las Heras", "Marcos Paz", "Mariano Acosta", "Merlo", "Navarro"}));
        cbLocalidad.setEditable(true);
        panelMedico.add(cbLocalidad);

        JLabel label_5 = new JLabel("Matrícula:");
        panelMedico.add(label_5);

        txtMedMatricula = new JTextField();
        txtMedMatricula.setColumns(10);
        panelMedico.add(txtMedMatricula);

        JLabel label_6 = new JLabel("Especialización:");
        panelMedico.add(label_6);

        txtMedEspecializacion = new JTextField();
        txtMedEspecializacion.setColumns(10);
        panelMedico.add(txtMedEspecializacion);

        JPanel panelBotones = new JPanel();
        contentPane.add(panelBotones, BorderLayout.SOUTH);
        panelBotones.setLayout(new FlowLayout());

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accion = 1;
                agregarMedico();
            }
        });
        
                btnGuardar = new JButton("Guardar");
                btnGuardar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        guardarMedico();
                    }
                });
                panelBotones.add(btnGuardar);
        panelBotones.add(btnAgregar);

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                accion = 2;
               habilita(false, true, true, true, true, true, true, true, false, false, false, false, true);
            }
        });
        panelBotones.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                eliminarMedico();
            }
        });
        panelBotones.add(btnEliminar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
        
        btnBuscar = new JButton("Buscar");
        panelBotones.add(btnBuscar);
        panelBotones.add(btnCancelar);
        
        limpiar();
    }

    /**
     * Guarda un médico nuevo o uno modificado
     */
    private void guardarMedico() {
        try {
            MedicoVO miMedico = new MedicoVO();
            miMedico.setDniMed(Integer.parseInt(txtMedDni.getText()));
            miMedico.setApellido(txtMedApellido.getText());
            miMedico.setNombre(txtMedNombre.getText());
            miMedico.setDomicilio(txtMedDomicilio.getText());
            miMedico.setLocalidad((String) cbLocalidad.getSelectedItem());
            miMedico.setMatricula(txtMedMatricula.getText());
            miMedico.setEspecializacion(txtMedEspecializacion.getText());

            if (accion == 1) {
                miCoordinador.registrarMedico(miMedico);
                limpiar();
            } else {
                miCoordinador.modificarMedico(miMedico);
                limpiar();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en el Ingreso de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        }
    }


    /**
     * Elimina el registro de un médico
     */
    public void eliminarMedico() {
        if (!txtMedDni.getText().equals("")) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar este Médico?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                int codigo = Integer.parseInt(txtMedDni.getText());
                miCoordinador.eliminarMedico(codigo);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el DNI del Médico", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Agrega un nuevo médico
     */
    public void agregarMedico() {
       habilita(true, true, true, true, true, true, true, true, false, false, false, false, true);
    }

    /**
     * Limpia los campos de texto de la ventana
     */
    public void limpiar() {
        txtMedDni.setText("");
        txtMedApellido.setText("");
        txtMedNombre.setText("");
        txtMedDomicilio.setText("");
        txtMedMatricula.setText("");
        txtMedEspecializacion.setText("");
        cbLocalidad.setSelectedIndex(0);
        habilita(true, false, false, false, false, false, false, false, true, false, false, true, true);
        
    }

    /**
     * Habilita o deshabilita los campos de texto
     */
    private void habilita(boolean dni, boolean ape, boolean nom, boolean dom, boolean loc, boolean mat, boolean esp, boolean bguardar, 
    		boolean bagrega, boolean bmodifica, boolean belimina, boolean bBusca, boolean bcancela) {
        txtMedDni.setEditable(dni);
        txtMedApellido.setEditable(ape);
        txtMedNombre.setEditable(nom);
        txtMedDomicilio.setEditable(dom);
        cbLocalidad.setEnabled(loc);
        txtMedMatricula.setEditable(mat);
        txtMedEspecializacion.setEditable(esp);
        btnGuardar.setVisible(bguardar);
        btnAgregar.setEnabled(bagrega);
        btnModificar.setEnabled(bmodifica);
        btnEliminar.setEnabled(belimina);
        btnBuscar.setEnabled(bBusca);
        btnCancelar.setEnabled(bcancela);
    }

    /**
     * Vuelve a la ventana principal
     */
    private void volver() {
        this.dispose();
        limpiar();
    }

    public void setMiCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public void setMedico(MedicoVO miMedico) {
        txtMedDni.setText(String.valueOf(miMedico.getDniMed()));
        txtMedApellido.setText(miMedico.getApellido());
        txtMedNombre.setText(miMedico.getNombre());
        txtMedDomicilio.setText(miMedico.getDomicilio());
        cbLocalidad.setSelectedItem(miMedico.getLocalidad());
        txtMedMatricula.setText(miMedico.getMatricula());
        txtMedEspecializacion.setText(miMedico.getEspecializacion());
       
        habilita(false, false, false, false, false, false, false, false, false, true, true, false, true);
    }
}

