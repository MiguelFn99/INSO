package modelo.vo;

import modelo.dao.EquipoDao;

public class PartidoVo {
	private int idPartido;
	private int idEquipoLocal;
	private int idEquipoVis;
	private int idArbitro;
	private String fecha;
	private String hora;
	private Integer golesLocal;
	private Integer golesVis;
	private int tarjAma;
	private int tarRojas;
	
	
	public PartidoVo(int idPartido, int idEquipoLocal, int idEquipoVis, int idArbitro, String fecha, String hora) {
		
		this.idPartido = idPartido;
		this.idEquipoLocal = idEquipoLocal;
		this.idEquipoVis = idEquipoVis;
		this.idArbitro = idArbitro;
		this.fecha = fecha;
		this.hora = hora;
	}

	public PartidoVo(int idPartido, int idEquipoLocal, int idEquipoVis, int idArbitro, String fecha, String hora,
			int golesLocal, int golesVis, int tarjAma, int tarRojas) {
		this.idPartido = idPartido;
		this.idEquipoLocal = idEquipoLocal;
		this.idEquipoVis = idEquipoVis;
		this.idArbitro = idArbitro;
		this.fecha = fecha;
		this.hora = hora;
		this.golesLocal = golesLocal;
		this.golesVis = golesVis;
		this.tarjAma = tarjAma;
		this.tarRojas = tarRojas;
	}



	public PartidoVo() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	public int getIdEquipoLocal() {
		return idEquipoLocal;
	}
	public void setIdEquipoLocal(int idEquipoLocal) {
		this.idEquipoLocal = idEquipoLocal;
	}
	public int getIdEquipoVis() {
		return idEquipoVis;
	}
	public void setIdEquipoVis(int idEquipoVis) {
		this.idEquipoVis = idEquipoVis;
	}
	public int getIdArbitro() {
		return idArbitro;
	}
	public void setIdArbitro(int idArbitro) {
		this.idArbitro = idArbitro;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVis() {
		return golesVis;
	}
	public void setGolesVis(int golesVis) {
		this.golesVis = golesVis;
	}
	public int getTarjAma() {
		return tarjAma;
	}
	public void setTarjAma(int tarjAma) {
		this.tarjAma = tarjAma;
	}
	public int getTarRojas() {
		return tarRojas;
	}
	public void setTarRojas(int tarRojas) {
		this.tarRojas = tarRojas;
	}
	
	@Override
	public String toString() {
		EquipoDao equipoDao = new EquipoDao();
		EquipoVo equipoLoc = equipoDao.buscarEquipo(idEquipoLocal);
		EquipoVo equipoVis = equipoDao.buscarEquipo(idEquipoVis);
		return equipoLoc.getNombre() + " vs " + equipoVis.getNombre();
	}
	
}
