package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EstudioDAO {
	
	public void registrarEstudio(EstudioVO miEstudio) {
		Conexion conex = new Conexion();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSTERT INTO estudio VALUES('"+miEstudio.getAldni()+"','"+miEstudio.getAlestudio()+"','"+miEstudio.getAltipo()+"','"+miEstudio.getAlres()+"'.'"+miEstudio.getAlmedic()+"')");
		JOptionPane.showConfirmDialog(null, "se ha registrado con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
		estatuto.close();
		conex.desconectar();
		}catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, "No se registro");
		}
		
	}
	
	public void modificarEstudio(EstudioVO miEstudio) {
		Conexion conex = new Conexion();
		try {
			String consulta="UPDATE estudio SET id_estudio=? , dni_pac=? , ip_med=? , tipo=? , resultado=? , fecha_c=?"+ "WHERE dni_pac" ;
	     
			PreparedStatement estatuto  = conex.getConnection().prepareStatement(consulta);
			
			estatuto.setInt(1, miEstudio.getAlestudio());
			estatuto.setInt(2, miEstudio.getAldni());
			estatuto.setInt(3, miEstudio.getAlmedico());
			estatuto.setString(4, miEstudio.getAltipo());
			estatuto.setString(5, miEstudio.getAlres());
            estatuto.executeUpdate();
            
            JOptionPane.showConfirmDialog(null, "Se modifico correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
		
		    estatuto.close();
		    conex.desconectar();
		}catch(SQLException e) {
			System.out.println(e);
			JOptionPane.showConfirmDialog(null, "Error al modificar","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

}
