package controlador;

import modelo.dao.MensajeDao;
import modelo.vo.MensajeVo;

public class EnviarMensajeControlador {

	private MensajeDao mensajeDao;
	private MensajeVo mensajeVo;
	
	//Constructor vacío
	public EnviarMensajeControlador() {}
	
	//Método para crear el mensaje
	public void crearMensaje(int idJugador, String mensaje) {
		
		mensajeVo = new MensajeVo();
		mensajeDao = new MensajeDao();
		
		mensajeVo.setIdJugador(idJugador);
		mensajeVo.setMensaje(mensaje);
		
		mensajeDao.crearMensaje(mensajeVo);
		
	}
	
}
