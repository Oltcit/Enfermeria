package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PacienteDAO {
	int dni;
	String ape;
	String nom;
	String sex;
	String fnac;
	String dom;
	String loc;
	float peso;
	float alt;
	String grup;
	String fac;
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFnac() {
		return fnac;
	}
	public void setFnac(String fnac) {
		this.fnac = fnac;
	}
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAlt() {
		return alt;
	}
	public void setAlt(float alt) {
		this.alt = alt;
	}
	public String getGrup() {
		return grup;
	}
	public void setGrup(String grup) {
		this.grup = grup;
	}
	public String getFac() {
		return fac;
	}
	public void setFac(String fac) {
		this.fac = fac;
	}
	public void registrarPaciente(PacienteVO miPacienteVO) {
		try {
			Conexion conex = new Conexion();
			
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("Insert into paciente values('"+miPacienteVO.getDni()+"','"+miPacienteVO.getApe()+"','"+miPacienteVO.getSex()+
					"','"+miPacienteVO.getFnac()+"','"+miPacienteVO.getDom()+"','"+miPacienteVO.getLoc()+"','"+miPacienteVO.getPeso()+
					"','"+miPacienteVO.getAlt()+"','"+miPacienteVO.getGrup()+"','"+miPacienteVO.getFac()+"','"+miPacienteVO.getNroHC()+"')");
			JOptionPane.showMessageDialog(null, "Se registró", "Información", JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se registró", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
	}
	public void modificarPaciente(PacienteVO miPacienteVO) {
		
		
	}
	public void buscarPaciente(DefaultTableModel modelo) {
		try {
			Conexion conex = new Conexion();
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet res = estatuto.executeQuery("Select * from paciente order by dni");
			while (res.next()) {
				Object fila [] = new Object[11];
				for (int i=0;i<11;i++) {
					fila[i] = res.getObject(i+1);
				}
				modelo.addRow(fila);
				
				
			}
			res.close();
			estatuto.close();
			conex.desconectar();
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
