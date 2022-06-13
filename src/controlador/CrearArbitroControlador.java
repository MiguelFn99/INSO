package controlador;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.dao.ArbitroDao;
import modelo.vo.ArbitroVo;

import java.text.SimpleDateFormat;

public class CrearArbitroControlador {

	public void crearArbitro(String nombre, String apellidos, String dni, String fechaNac, int nLicencia, String usuario,
			String contrasena) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaNacimiento = formatter.parse(fechaNac);
			ArbitroVo arbitro = new ArbitroVo(0, nombre, apellidos, dni, fechaNac, nLicencia, usuario, contrasena);
			ArbitroDao arbitroDao = new ArbitroDao();
			arbitroDao.crearArbitro(arbitro);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error! El formato de la fecha de nacimiento es yyyy-MM-dd");
			e.printStackTrace();
		}
		
	}

}
