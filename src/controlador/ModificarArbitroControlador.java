package controlador;

import java.util.ArrayList;

import modelo.dao.ArbitroDao;
import modelo.vo.ArbitroVo;

public class ModificarArbitroControlador {

	private ArbitroDao arbitroDao;
	
	public ModificarArbitroControlador() {}
	
	public ArbitroVo[] listaArbitros() {
		arbitroDao = new ArbitroDao();
		ArrayList<ArbitroVo> arbitros = arbitroDao.buscarArbitros();
		ArbitroVo[] listaArbitros = new ArbitroVo[arbitros.size()];
		
		for (int i = 0; i < arbitros.size(); i++) {
			listaArbitros[i] = arbitros.get(i);
		}

		return listaArbitros;
	}
	
	public void modificarArbitro(int idArbitro, String nombre, String apellidos, String dni, String fechaNac,
			int licencia, String email, String contrasena) {
		arbitroDao = new ArbitroDao();
		ArbitroVo arbitro = new ArbitroVo(idArbitro, nombre, apellidos, dni, fechaNac, licencia, email, contrasena);
		arbitroDao.modificarArbitro(arbitro);
		
	}
	
}
