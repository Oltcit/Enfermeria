package modelo;

public class HistoriaVO {
	private int id_hc;
	private int id_medico;
	private String diagnostico;
	private int id_pac;
	private String fecha_hc;
	public int getId_hc() {
		return id_hc;
	}
	public void setId_hc(int id_hc) {
		this.id_hc = id_hc;
	}
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public int getId_pac() {
		return id_pac;
	}
	public void setId_pac(int id_pac) {
		this.id_pac = id_pac;
	}
	public String getFecha_hc() {
		return fecha_hc;
	}
	public void setFecha_hc(String fecha_hc) {
		this.fecha_hc = fecha_hc;
	}
	

}
