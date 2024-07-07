package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HistoriaDAO {
	public void registrarHistoria(HistoriaVO miHistoriaVO) {
		try{
			Conexion conex = new Conexion();
			Statement estatuto=conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO enfermeria VALUES ('"+miHistoriaVO.getId_hc()+"','"+miHistoriaVO.getId_medico()+"','"+miHistoriaVO.getId_pac()+"','"+miHistoriaVO.getDiagnostico()+"','"+miHistoriaVO.getFecha_hc()+"')");			
			JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e){
			System.out.println("Id HC: "+miHistoriaVO.getId_hc()+" Fecha: "+miHistoriaVO.getFecha_hc()+" Id Médico: "+miHistoriaVO.getId_medico());
			System.out.println("Id Paciente: "+miHistoriaVO.getId_pac()+" Diagnostico: "+miHistoriaVO.getDiagnostico());
			JOptionPane.showMessageDialog(null, "No se registró", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	public void modificarHC(HistoriaVO miHistoriaVO) {
		try {
			Conexion conex= new Conexion();
			String consulta="UPDATE enfermeria SET id_hc=?, id_madico=?, id_pac=?, diagnostico=?,fecha_hc "
					+ "WHERE id_hc=?";
			PreparedStatement estatuto=conex.getConnection().prepareStatement(consulta);
			estatuto.setInt(1, miHistoriaVO.getId_hc());
			estatuto.setInt(2, miHistoriaVO.getId_medico());
			estatuto.setInt(3, miHistoriaVO.getId_pac());
			estatuto.setString(4, miHistoriaVO.getDiagnostico());
			estatuto.setString(5, miHistoriaVO.getFecha_hc());
			estatuto.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente","Confirmación"
					,JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al modificar","Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		
	}

	public void buscarHC(DefaultTableModel modelo) {
		try {
			Conexion conex = new Conexion();
			java.sql.Statement estatuto = conex.getConnection().createStatement();
			ResultSet  res = estatuto.executeQuery("select * from enfermeria order by id_hc");
			
			while (res.next())
			{
				Object fila[] = new Object[4];
				for (int i=0; i<4; i++)
				{
					fila[i]=res.getObject(i+1);
					
				}
				modelo.addRow(fila);
			}
			res.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar","Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void eliminarHC(Integer hc) {
		try {
			Conexion conex=new Conexion();
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM enfermeria where id_hc ="+hc);
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente","Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se eliminó","Información",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}

