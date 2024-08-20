package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import javax.swing.JOptionPane;

public class CalculaAi {
	public int calculaIdHistoria(){
		int id=1;
		
		
		Conexion con= new Conexion();
		ResultSet resId=null;
		
		try {
			String consulta = "SELECT MAX(id_hc) FROM Item Historia";
			PreparedStatement estatuto = con.getConnection().prepareStatement(consulta);
			resId = estatuto.executeQuery();
					
			while(resId.next()){
				id=resId.getInt(1)+1;
			}
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
			}
		
		finally{
			try {
				resId.close();
				con.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return id;
	}
	
	public int calculaIdEstudio(){
		int id=1;
		
		
		Conexion conex= new Conexion();
		ResultSet res=null;
		
		try {
			String consulta = "SELECT MAX(id_estudio) FROM mesa";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			res = estatuto.executeQuery();
					
			while(res.next()){
				id=res.getInt(1)+1;
			}
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
			}
		finally{
			try {
				res.close();
				conex.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return id;
	}

	public int calculaIdPatologia() {
		int id=1;
		
		
		Conexion conex= new Conexion();
		ResultSet res=null;
		
		try {
			String consulta = "SELECT MAX(id_pato) FROM patologia";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			res = estatuto.executeQuery();
					
			while(res.next()){
				id=res.getInt(1)+1;
			}
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
			}
		finally{
			try {
				res.close();
				conex.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}		
		return id;	
		
	}
}
