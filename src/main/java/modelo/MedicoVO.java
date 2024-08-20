package modelo;

public class MedicoVO {
	
	// Atributos
	
	private int dniMed;
    private String ape;
    private String nom;
    private String dom;
    private String loc;
    private String matricula;
    private String especializacion;
    
    // Getters and Setters
    
	public int getDniMed() {
		return dniMed;
	}
	public void setDniMed(int dniMed) {
		this.dniMed = dniMed;
	}
	public String getApellido() {
		return ape;
	}
	public void setApellido(String apellido) {
		this.ape = apellido;
	}
	public String getNombre() {
		return nom;
	}
	public void setNombre(String nombre) {
		this.nom = nombre;
	}
	public String getDomicilio() {
		return dom;
	}
	public void setDomicilio(String domicilio) {
		this.dom = domicilio;
	}
	public String getLocalidad() {
		return loc;
	}
	public void setLocalidad(String localidad) {
		this.loc = localidad;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEspecializacion() {
		return especializacion;
	}
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
    
    
}
