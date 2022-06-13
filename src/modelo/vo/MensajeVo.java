package modelo.vo;

public class MensajeVo {
	int idMensaje;
	int idJugador;
	String mensaje;

	public MensajeVo(int idMensaje, int idJugador, String mensaje) {
		this.idMensaje = idMensaje;
		this.idJugador = idJugador;
		this.mensaje = mensaje;
	}

	public MensajeVo() {}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
