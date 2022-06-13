package modelo.vo;

public class ArbitroVo {
	private int idArbitro;
	private String nombre;
	private String apellidos;
	private String dni;
	private String fechanac;
	private int licencia;
	private String email;
	private String contrasena;

	public ArbitroVo(int idArbitro, String nombre, String apellidos, String dni, String fechaNac, int licencia,
			String email, String contrasena) {
		this.idArbitro = idArbitro;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechanac = fechaNac;
		this.licencia = licencia;
		this.email = email;
		this.contrasena = contrasena;
	}
	
	public ArbitroVo(int idArbitro, String email, String contrasena) {
        this.idArbitro = idArbitro;
        this.email = email;
        this.contrasena = contrasena;
    }
	
	public ArbitroVo() {
		
	}

	public int getIdArbitro() {
		return idArbitro;
	}
	
	public void setIdArbitro(int idArbitro) {
		this.idArbitro=idArbitro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}

	
}
