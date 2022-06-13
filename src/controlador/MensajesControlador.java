package controlador;

import java.util.ArrayList;

import modelo.dao.JugadorDao;
import modelo.dao.MensajeDao;
import modelo.vo.JugadorVo;
import modelo.vo.MensajeVo;

public class MensajesControlador {

	MensajeDao mensajeDao;
	MensajeVo mensajeVo;
	
	public ArrayList<MensajeVo> listaMensajes() {
		
		mensajeDao = new MensajeDao();
		ArrayList<MensajeVo> listaMensajes = mensajeDao.buscarMensajes();
		
		return listaMensajes;
	}

	public JugadorVo buscarJugador(int idJugador)  {
		
		 JugadorDao jugadorDao = new JugadorDao();
		 JugadorVo jugadorVo = jugadorDao.buscarJugador(idJugador);
		 
		return jugadorVo;
	}
	
}
