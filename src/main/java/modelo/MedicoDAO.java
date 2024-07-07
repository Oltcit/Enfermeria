package modelo;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {

    // Métodos CRUD

	public void registrarMedico(MedicoVO medico) {
	    Conexion conex = new Conexion();
	    Connection connection = null;
	    PreparedStatement estatuto = null;

	    try {
	        connection = conex.getConnection();
	        String consulta = "INSERT INTO medico (dni_med, ape, nom, dom, loc, matricula, especializacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        estatuto = connection.prepareStatement(consulta);

	        estatuto.setInt(1, medico.getDniMed());
	        estatuto.setString(2, medico.getApellido());
	        estatuto.setString(3, medico.getNombre());
	        estatuto.setString(4, medico.getDomicilio());
	        estatuto.setString(5, medico.getLocalidad());
	        estatuto.setString(6, medico.getMatricula());
	        estatuto.setString(7, medico.getEspecializacion());

	        System.out.println("SQL Query: " + estatuto);

	        estatuto.executeUpdate();

	        JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	    } catch (SQLException e) {
	        System.out.println(e);
	        JOptionPane.showMessageDialog(null, "No se Registro", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (estatuto != null) estatuto.close();
	            if (connection != null) conex.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	public void modificarMedico(MedicoVO medico) {
	    Conexion conex = new Conexion();
	    Connection connection = null;
	    PreparedStatement estatuto = null;

	    try {
	        connection = conex.getConnection();
	        String consulta = "UPDATE medico SET ape = ?, nom = ?, dom = ?, loc = ?, matricula = ?, especializacion = ? WHERE dni_med = ?";
	        estatuto = connection.prepareStatement(consulta);

	        estatuto.setString(1, medico.getApellido());
	        estatuto.setString(2, medico.getNombre());
	        estatuto.setString(3, medico.getDomicilio());
	        estatuto.setString(4, medico.getLocalidad());
	        estatuto.setString(5, medico.getMatricula());
	        estatuto.setString(6, medico.getEspecializacion());
	        estatuto.setInt(7, medico.getDniMed());

	        System.out.println("SQL Query: " + estatuto);

	        estatuto.executeUpdate();

	        JOptionPane.showMessageDialog(null, "Se ha Modificado Correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	    } catch (SQLException e) {
	        System.out.println(e);
	        JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (estatuto != null) estatuto.close();
	            if (connection != null) conex.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	public void eliminarMedico(int dniMed) {
	    Conexion conex = new Conexion();
	    Connection connection = null;
	    PreparedStatement estatuto = null;

	    try {
	        connection = conex.getConnection();
	        String consulta = "DELETE FROM medico WHERE dni_med = ?";
	        estatuto = connection.prepareStatement(consulta);
	        estatuto.setInt(1, dniMed);

	        System.out.println("SQL Query: " + estatuto);

	        estatuto.executeUpdate();

	        JOptionPane.showMessageDialog(null, "Se ha Eliminado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
	    } catch (SQLException e) {
	        System.out.println(e);
	        JOptionPane.showMessageDialog(null, "No se Eliminó", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (estatuto != null) estatuto.close();
	            if (connection != null) conex.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
}

