package controlador;

import java.util.ArrayList;

import modelo.dao.ArbitroDao;
import modelo.vo.ArbitroVo;


public class EliminarArbitroControlador {
ArbitroDao arbitroDao;
	
	public ArbitroVo[] listaArbitros() {
		arbitroDao = new ArbitroDao();
		ArrayList<ArbitroVo> arbitros = arbitroDao.buscarArbitros();
		ArbitroVo[] listaArbitros = new ArbitroVo[arbitros.size()];
		
		for (int i = 0; i < arbitros.size(); i++) {
			listaArbitros[i] = arbitros.get(i);
		}

		return listaArbitros;
	}

	public void eliminarArbitro(int idArbitro) {
		arbitroDao.eliminarArbitro(idArbitro);
	}
}
