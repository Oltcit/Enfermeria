package controlador;

import modelo.MedicoDAO;
import modelo.MedicoVO;
import vista.VentanaEstudio;
import vista.VentanaEstudioBuscar;
import vista.VentanaMedico;
import vista.VentanaPaciente;
import vista.VentanaPacienteBuscar;
import vista.VentanaPrincipal;

public class Coordinador {

	VentanaPrincipal miVentanaPrincipal;
	VentanaMedico miVentanaMedico;
	VentanaPaciente miVentanaPaciente;
	VentanaPacienteBuscar miVentanaPacienteBuscar;
	VentanaEstudio miVentanaEstudio;
	VentanaEstudioBuscar miVentanaEstudioBuscar;
	
	
	

	public VentanaEstudioBuscar getMiVentanaEstudioBuscar() {
		return miVentanaEstudioBuscar;
	}

	public void setMiVentanaEstudioBuscar(VentanaEstudioBuscar miVentanaEstudioBuscar) {
		this.miVentanaEstudioBuscar = miVentanaEstudioBuscar;
	}

	public VentanaEstudio getMiVentanaEstudio() {
		return miVentanaEstudio;
	}

	public void setMiVentanaEstudio(VentanaEstudio miVentanaEstudio) {
		this.miVentanaEstudio = miVentanaEstudio;
	}

	public VentanaPaciente getMiVentanaPaciente() {
		return miVentanaPaciente;
	}

	public void setMiVentanaPaciente(VentanaPaciente miVentanaPaciente) {
		this.miVentanaPaciente = miVentanaPaciente;
	}

	public VentanaPacienteBuscar getMiVentanaPacienteBuscar() {
		return miVentanaPacienteBuscar;
	}

	public void setMiVentanaPacienteBuscar(VentanaPacienteBuscar miVentanaPacienteBuscar) {
		this.miVentanaPacienteBuscar = miVentanaPacienteBuscar;
	}

	public VentanaMedico getMiVentanaMedico() {
		return miVentanaMedico;
	}

	public void setMiVentanaMedico(VentanaMedico miVentanaMedico) {
		this.miVentanaMedico = miVentanaMedico;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public void mostrarVentanaPaciente() {
		miVentanaPaciente.setVisible(true);
		
	}

	public void mostrarVentanaMedico() {
		miVentanaMedico.setVisible(true);
		
	}

	public void registrarMedico(MedicoVO miMedico) {
		MedicoDAO miMedicoDAO = new MedicoDAO();
		miMedicoDAO.registrarMedico(miMedico);
		
	}

	public void modificarMedico(MedicoVO miMedico) {
		MedicoDAO miMedicoDAO = new MedicoDAO();
		miMedicoDAO.modificarMedico(miMedico);
		
	}

	public void eliminarMedico(int codigo) {
		// TODO Auto-generated method stub
		
	}

	public void mostrarVentanaEstudio() {
		
		
	}
	
	
}
