package controlador;

import modelo.dao.EquipoDao;
import modelo.vo.EquipoVo;

public class CrearEquipoControlador {
	private EquipoVo equipo;
	private EquipoDao equipoDao;

	public void crearEquipo(String nombre) {
		// TODO Auto-generated method stub
		equipoDao= new EquipoDao();
		equipo = new EquipoVo(0, nombre, 0, 0, 0);
		equipoDao.crearEquipo(equipo);
	}

}
