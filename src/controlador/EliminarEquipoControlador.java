package controlador;

import java.util.ArrayList;

import modelo.dao.EquipoDao;
import modelo.vo.EquipoVo;

public class EliminarEquipoControlador {
	EquipoDao equipoDao;
	
	public EquipoVo[] listaEquipos() {
		equipoDao = new EquipoDao();
		ArrayList<EquipoVo> equipos = equipoDao.buscarEquipos();
		EquipoVo[] listaEquipos = new EquipoVo[equipos.size()];
		
		for (int i = 0; i < equipos.size(); i++) {
			listaEquipos[i] = equipos.get(i);
		}

		return listaEquipos;
	}

	public void eliminarEquipo(int idEquipo) {
		equipoDao.eliminarEquipo(idEquipo);
	}
}
