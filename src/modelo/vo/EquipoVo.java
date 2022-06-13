package modelo.vo;

public class EquipoVo {
	int idEquipo;
	String nombre;
	int puntos;
	int golesFav;
	int golesContra;
	
	public EquipoVo(int idEquipo, String nombre, int puntos, int golesFav, int golesContra) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.puntos = puntos;
		this.golesFav = golesFav;
		this.golesContra = golesContra;
	}
	
	public EquipoVo(){
	
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getGolesFav() {
		return golesFav;
	}
	public void setGolesFav(int golesFav) {
		this.golesFav = golesFav;
	}
	public int getGolesContra() {
		return golesContra;
	}
	public void setGolesContra(int golesContra) {
		this.golesContra = golesContra;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
