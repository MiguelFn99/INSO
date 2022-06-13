package controlador;

import vista.VentanaAdministrador;
import vista.VentanaArbitro;
import vista.VentanaCrearArbitro;
import vista.VentanaCrearEquipo;

import vista.VentanaCrearPartido;
import vista.VentanaEliminarArbitro;
import vista.VentanaEliminarEquipo;
import vista.VentanaEliminarJugador;
import vista.VentanaEliminarPartido;
import vista.VentanaEstadisticas;
import vista.VentanaCrearJugador;
import vista.VentanaLogin;
import vista.VentanaMensajes;
import vista.VentanaModificarArbitro;
import vista.VentanaModificarEquipo;
import vista.VentanaModificarJugador;
import vista.VentanaModificarPartido;
import vista.VentanaTablas;
import vista.VentanaPartidos;

public class Coordinador {

	private VentanaTablas ventanaTablas;
	private VentanaLogin ventanaLogin;
	private VentanaAdministrador ventanaAdministrador;
	private VentanaCrearEquipo ventanaCrearEquipo;
	private VentanaCrearJugador ventanaCrearJugador;
	private VentanaCrearPartido ventanaCrearPartido;
	private VentanaCrearArbitro ventanaCrearArbitro;
	private VentanaModificarEquipo ventanaModificarEquipo;
	private VentanaModificarPartido ventanaModificarPartido;
	private VentanaEliminarEquipo ventanaEliminarEquipo;
	private VentanaModificarArbitro ventanaModificarArbitro;
	private VentanaArbitro ventanaArbitro;
	private VentanaEliminarArbitro ventanaEliminarArbitro;
	private VentanaEliminarPartido ventanaEliminarPartido;
	private VentanaEliminarJugador ventanaEliminarJugador;
	private VentanaModificarJugador ventanaModificarJugador;
	private VentanaEstadisticas ventanaEstadisticas;
	private VentanaPartidos ventanaPartidos;
	private VentanaMensajes ventanaMensajes;

///////---------------------- GETTERS Y SETTERS	

	public void setVentanaLogin(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;
	}

	public void setVentanaAdministrador(VentanaAdministrador ventanaAdministrador) {
		this.ventanaAdministrador = ventanaAdministrador;
	}

	public void setVentanaCrearEquipo(VentanaCrearEquipo ventanaCrearEquipo) {
		this.ventanaCrearEquipo = ventanaCrearEquipo;
	}

	public void setVentanaCrearPartido(VentanaCrearPartido ventanaCrearPartido) {
		this.ventanaCrearPartido = ventanaCrearPartido;
	}

	public void setVentanaCrearJugador(VentanaCrearJugador ventanaCrearJugador) {
		this.ventanaCrearJugador = ventanaCrearJugador;
	}

	public void setVentanaTablas(VentanaTablas ventanaTablas) {
		this.ventanaTablas = ventanaTablas;
	}

	public void setVentanaCrearArbitro(VentanaCrearArbitro ventanaCrearArbitro) {
		this.ventanaCrearArbitro = ventanaCrearArbitro;
	}

	public void setVentanaModificarEquipo(VentanaModificarEquipo ventanaModificarEquipo) {
		this.ventanaModificarEquipo = ventanaModificarEquipo;
	}

	public void setVentanaModificarPartido(VentanaModificarPartido ventanaModificarPartido) {
		this.ventanaModificarPartido = ventanaModificarPartido;
	}

	public void setVentanaEliminarEquipo(VentanaEliminarEquipo ventanaEliminarEquipo) {
		this.ventanaEliminarEquipo = ventanaEliminarEquipo;
	}

	public void setVentanaModificarArbitro(VentanaModificarArbitro ventanaModificarArbitro) {
		this.ventanaModificarArbitro = ventanaModificarArbitro;
	}

	public void setVentanaArbitro(VentanaArbitro ventanaArbitro) {
		this.ventanaArbitro = ventanaArbitro;
	}

	public void setVentanaEliminarArbitro(VentanaEliminarArbitro ventanaEliminarArbitro) {
		this.ventanaEliminarArbitro = ventanaEliminarArbitro;
	}

	public void setVentanaEliminarPartido(VentanaEliminarPartido ventanaEliminarPartido) {
		this.ventanaEliminarPartido = ventanaEliminarPartido;
	}

	public void setVentanaEliminarJugador(VentanaEliminarJugador ventanaEliminarJugador) {
		this.ventanaEliminarJugador = ventanaEliminarJugador;
	}

	public void setVentanaModificarJugador(VentanaModificarJugador ventanaModificarJugador) {
		this.ventanaModificarJugador = ventanaModificarJugador;
	}

	public void setVentanaEstadisticas(VentanaEstadisticas ventanaEstadisticas) {
		this.ventanaEstadisticas = ventanaEstadisticas;
	}
	public void setVentanaPartidos(VentanaPartidos ventanaPartidos) {
		this.ventanaPartidos = ventanaPartidos;
	}
	public void setVentanaMensajes(VentanaMensajes ventanaMensajes) {
		this.ventanaMensajes = ventanaMensajes;
	}

	/////// -------------------------- MOSTRAR VENTANAS

	public void mostrarVentanaLogin() {
		ventanaLogin.setVisible(true);
	}

	public void mostrarVentanaTablas() {
		ventanaTablas.setVisible(true);
		cerrarVentanaEstadisticas();
		cerrarVentanaPartidos();
	}

	public void mostrarVentanaAdministrador() {
		ventanaAdministrador.setVisible(true);
	}

	public void mostrarVentanaCrearEquipo() {
		ventanaCrearEquipo.setVisible(true);
	}

	public void mostrarVentanaCrearJugador() {
		ventanaCrearJugador.setVisible(true);
	}

	public void mostrarVentanaCrearPartido() {
		ventanaCrearPartido.setVisible(true);
	}

	public void mostrarVentanaCrearArbitro() {
		ventanaCrearArbitro.setVisible(true);
	}

	public void mostrarVentanaModificarEquipo() {
		ventanaModificarEquipo.setVisible(true);
	}

	public void mostrarVentanaModificarPartido() {
		ventanaModificarPartido.setVisible(true);
	}

	public void mostrarVentanaEliminarEquipo() {
		ventanaEliminarEquipo.setVisible(true);
	}

	public void mostrarVentanaEliminarArbitro() {
		ventanaEliminarArbitro.setVisible(true);
	}

	public void mostrarVentanaEliminarPartido() {
		ventanaEliminarPartido.setVisible(true);
	}

	public void mostrarVentanaEliminarJugador() {
		ventanaEliminarJugador.setVisible(true);
	}

	public void mostrarVentanaModificarArbitro() {
		ventanaModificarArbitro.setVisible(true);
	}

	public void mostrarVentanaAnotarResultado() {
		ventanaArbitro.setVisible(true);
	}

	public void mostrarVentanaModificarJugador() {
		ventanaModificarJugador.setVisible(true);
	}

	public void mostrarVentanaEstadisticas() {
		ventanaEstadisticas.setVisible(true);
		cerrarVentanaTablas();
		cerrarVentanaPartidos();
	}
	public void mostrarVentanaPartidos() {
		ventanaPartidos.setVisible(true);
		cerrarVentanaTablas();
		cerrarVentanaEstadisticas();
	}
	public void mostrarVentanaMensajes() {
		ventanaMensajes.setVisible(true);
	}

	//////// ------------------------- CERRAR VENTANAS

	public void cerrarVentanaLogin() {
		ventanaLogin.setVisible(false);
	}

	public void cerrarVentanaTablas() {
		ventanaTablas.setVisible(false);
	}

	public void cerrarVentanaAdministrador() {
		ventanaAdministrador.setVisible(false);
	}

	public void cerrarVentanaCrearEquipo() {
		ventanaCrearEquipo.setVisible(false);
	}

	public void cerrarVentanaCrearJugador() {
		ventanaCrearJugador.setVisible(false);
	}

	public void cerrarVentanaCrearArbitro() {
		ventanaCrearArbitro.setVisible(false);
	}

	public void cerrarVentanaModificarEquipo() {
		ventanaModificarEquipo.setVisible(false);
	}

	public void cerrarVentanaModificarPartido() {
		ventanaModificarPartido.setVisible(false);
	}

	public void cerrarVentanaEliminarEquipo() {
		ventanaEliminarEquipo.setVisible(false);
	}

	public void cerrarVentanaModificarArbitro() {
		ventanaModificarArbitro.setVisible(false);
	}

	public void cerrarVentanaEliminarArbitro() {
		ventanaEliminarArbitro.setVisible(false);
	}

	public void cerrarVentanaCrearPartido() {
		ventanaCrearPartido.setVisible(false);
	}

	public void cerrarVentanaEliminarPartido() {
		ventanaEliminarPartido.setVisible(false);
	}

	public void cerrarVentanaEliminarJugador() {
		ventanaEliminarJugador.setVisible(false);
	}

	public void cerrarVentanaModificarJugador() {
		ventanaModificarJugador.setVisible(false);
	}

	public void cerrarVentanaEstadisticas() {
		ventanaEstadisticas.setVisible(false);
	}

	public void cerrarVentanaPartidos() {
		ventanaPartidos.setVisible(false);
	}
	
	public void cerrarVentanaMensajes() {
	ventanaMensajes.setVisible(false);
	}
	public void cerrarTodas() {
		cerrarVentanaAdministrador();
		cerrarVentanaCrearArbitro();
		cerrarVentanaCrearEquipo();
		cerrarVentanaCrearJugador();
		cerrarVentanaCrearPartido();
		cerrarVentanaEliminarArbitro();
		cerrarVentanaEliminarEquipo();
		cerrarVentanaEliminarJugador();
		cerrarVentanaEliminarPartido();
		cerrarVentanaEstadisticas();
		cerrarVentanaLogin();
		cerrarVentanaModificarArbitro();
		cerrarVentanaModificarEquipo();
		cerrarVentanaModificarJugador();
		cerrarVentanaModificarPartido();
		cerrarVentanaTablas();
		cerrarVentanaMensajes();
	}
	

}
