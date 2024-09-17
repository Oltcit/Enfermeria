/**
 * @author Marcelo Ruben Anton
 * @Change: Se agregó el cambio de skins
 */

package controlador;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import vista.VentanaEstudio;
import vista.VentanaEstudioBuscar;
import vista.VentanaMedico;
import vista.VentanaPaciente;
import vista.VentanaPacienteBuscar;
import vista.VentanaPrincipal;

public class Principal {

	Coordinador miCoordinador;
	VentanaPrincipal miVentanaPrincipal;
	VentanaMedico miVentanaMedico;
	VentanaPaciente miVentanaPaciente;
	VentanaPacienteBuscar miVentanaPacienteBuscar;
	VentanaEstudio miVentanaEstudio;
	VentanaEstudioBuscar miVentanaEstudioBuscar;

	public static void main(String[] args) {

		// Inicializamos el cambio de Skin de la App
		try {
			UIManager.setLookAndFeel(new FlatMacDarkLaf());
		} catch (Exception ex) {
			System.err.println("Error al inicializar el skin");
		}

		Principal miPrincipal = new Principal();
		miPrincipal.iniciar();

	}

	private void iniciar() {
		miVentanaPrincipal = new VentanaPrincipal();
		miCoordinador = new Coordinador();
		miVentanaMedico = new VentanaMedico();
		miVentanaPaciente = new VentanaPaciente();
		miVentanaPacienteBuscar = new VentanaPacienteBuscar();
		miVentanaEstudio = new VentanaEstudio();
		miVentanaEstudioBuscar = new VentanaEstudioBuscar();

		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaMedico(miVentanaMedico);
		miCoordinador.setMiVentanaPaciente(miVentanaPaciente);
		miCoordinador.setMiVentanaPacienteBuscar(miVentanaPacienteBuscar);
		miCoordinador.setMiVentanaEstudio(miVentanaEstudio);
		miCoordinador.setMiVentanaEstudioBuscar(miVentanaEstudioBuscar);

		miVentanaPrincipal.setMiCoordinador(miCoordinador);
		miVentanaMedico.setMiCoordinador(miCoordinador);
		miVentanaPaciente.setMiCoordinador(miCoordinador);
		miVentanaPacienteBuscar.setMiCoordinador(miCoordinador);
		miVentanaEstudio.setMiCoordinador(miCoordinador);
		miVentanaEstudioBuscar.setMiCoordinador(miCoordinador);

		miVentanaPrincipal.setVisible(true);

	}

}
