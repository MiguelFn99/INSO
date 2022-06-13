package modelo.vo;

public class JugadorVo {
	private int idJugador;
	private String nombre;
	private String apellidos;
	private String dni;
	private int dorsal;
	private String fechanac;
	private int goles;
	private int asistencias;
	private int tarjAma;
	private int tarjRojas;
	private int idEquipo;
	private boolean capitan;
	private String email;
	private String contrasena;
	
	public JugadorVo(int idJugador, String nombre, String apellidos, String dni, int dorsal, String fechanac, int goles,
			int asistencias, int tarjAma, int tarjRojas, int idEquipo, boolean capitan, String email,
			String contrasena) {
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.dorsal = dorsal;
		this.fechanac = fechanac;
		this.goles = goles;
		this.asistencias = asistencias;
		this.tarjAma = tarjAma;
		this.tarjRojas = tarjRojas;
		this.idEquipo = idEquipo;
		this.capitan = capitan;
		this.email = email;
		this.contrasena = contrasena;
	}
	
	public JugadorVo(int idJugador, String email, String contrasena) {
        this.idJugador = idJugador;
        this.email = email;
        this.contrasena = contrasena;
    }
	
	public JugadorVo() {
		
	}
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
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
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getFechanac() {
		return fechanac;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public int getGoles() {
		return goles;
	}
	public void setGoles(int goles) {
		this.goles = goles;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getTarjAma() {
		return tarjAma;
	}
	public void setTarjAma(int tarjAma) {
		this.tarjAma = tarjAma;
	}
	public int getTarjRojas() {
		return tarjRojas;
	}
	public void setTarjRojas(int tarjRojas) {
		this.tarjRojas = tarjRojas;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public int isCapitan() {
		if (capitan) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public void setCapitan(boolean capitan) {
		this.capitan = capitan;
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
		return nombre+ " " + apellidos;
	}
}
