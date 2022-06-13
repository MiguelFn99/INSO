package vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.AnotarResultadoControlador;
import modelo.vo.JugadorVo;
import modelo.vo.PartidoVo;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;

public class VentanaAnotarResultados extends JFrame implements ActionListener {
	private AnotarResultadoControlador anotarResultadoControlador;
	private ArrayList<JugadorVo> jugadoresLoc, jugadoresVis;
	private PartidoVo partidoSelec;
	private JTable tablaJugadoresLocal, tablaJugadoresVisitante;
	private JButton guardarActa;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	private JLabel lblLogo_1;
	

	public VentanaAnotarResultados(ArrayList<JugadorVo> jugadoresLoc, ArrayList<JugadorVo> jugadoresVis,
			PartidoVo partidoSelec) {
		getContentPane().setBackground(new Color(135, 206, 235));
		anotarResultadoControlador = new AnotarResultadoControlador();
		this.jugadoresLoc = jugadoresLoc;
		this.jugadoresVis = jugadoresVis;
		this.partidoSelec = partidoSelec;
		setSize(1000, 500);
		tablaJugadoresLocal = new JTable();
		tablaJugadoresVisitante = new JTable();
		llenarTabla(tablaJugadoresLocal, jugadoresLoc);
		llenarTabla(tablaJugadoresVisitante, jugadoresVis);
		getContentPane().setLayout(null);
		scrollPane = new JScrollPane(tablaJugadoresLocal);
		scrollPane.setBackground(new Color(0, 0, 0));
		scrollPane.setLocation(40, 89);
		scrollPane.setSize(440, 316);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane2 = new JScrollPane(tablaJugadoresVisitante);
		scrollPane2.setBackground(new Color(0, 0, 0));
		scrollPane2.setLocation(504, 89);
		scrollPane2.setSize(440, 316);
		getContentPane().add(scrollPane2, BorderLayout.CENTER);

		guardarActa = new JButton("Guardar Acta");
		guardarActa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guardarActa.setBackground(new Color(255, 255, 255));
		guardarActa.setBounds(420, 429, 154, 23);
		guardarActa.addActionListener(this);
		getContentPane().add(guardarActa);

		JLabel lblNewLabel = new JLabel(partidoSelec.toString());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(203, 44, 578, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(40, 6, 100, 71);
		lblLogo.setIcon(new ImageIcon(img_logo));
		getContentPane().add(lblLogo);
		
		lblLogo_1 = new JLabel("");
		lblLogo_1.setBounds(869, 6, 100, 71);
		lblLogo_1.setIcon(new ImageIcon(img_logo));
		getContentPane().add(lblLogo_1);
	}

	private void llenarTabla(JTable tabla, ArrayList<JugadorVo> jugadores) {
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// Aqu� devolvemos true o false seg�n queramos que una celda
				// identificada por fila,columna (row,column), sea o no editable
				if (column == 0 || column == 1 || column == 2 || column == 3)
					return false;
				return true;
			}
		};
		modeloTabla.addColumn("ID");
		modeloTabla.addColumn("NOMBRE");
		modeloTabla.addColumn("APELLIDOS");
		modeloTabla.addColumn("DORSAL");
		modeloTabla.addColumn("GOLES");
		modeloTabla.addColumn("ASISTENCIAS");
		modeloTabla.addColumn("TARJETA AMARILLA");
		modeloTabla.addColumn("TARJETA ROJA");
		Object[] columna = new Object[8];
		int numRegistros = jugadores.size();
		for (int i = 0; i < numRegistros; i++) {
			columna[0] = jugadores.get(i).getIdJugador();
			columna[1] = jugadores.get(i).getNombre();
			columna[2] = jugadores.get(i).getApellidos();
			columna[3] = jugadores.get(i).getDorsal();
			columna[4] = 0;
			columna[5] = 0;
			columna[6] = 0;
			columna[7] = 0;
			modeloTabla.addRow(columna);
		}
		tabla.setModel(modeloTabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == guardarActa) {
			int golesLocal = 0;
			int golesVisitante = 0;
			for (int i = 0; i < jugadoresLoc.size(); i++) {
				int idJugador = Integer.parseInt(tablaJugadoresLocal.getValueAt(i, 0).toString());
				int goles = Integer.parseInt(tablaJugadoresLocal.getValueAt(i, 4).toString());
				int asistencias = Integer.parseInt(tablaJugadoresLocal.getValueAt(i, 5).toString());
				int tarjetasA = Integer.parseInt(tablaJugadoresLocal.getValueAt(i, 6).toString());
				int tarjetasR = Integer.parseInt(tablaJugadoresLocal.getValueAt(i, 7).toString());
				golesLocal += goles;
				JugadorVo jugador = null;
				for (int j = 0; j < jugadoresLoc.size(); j++) {
					if (idJugador == jugadoresLoc.get(j).getIdJugador()) {
						jugador = jugadoresLoc.get(j);
					}
				}
				jugador.setGoles(jugador.getGoles() + goles);
				jugador.setAsistencias(jugador.getAsistencias() + asistencias);
				jugador.setTarjAma(jugador.getTarjAma() + tarjetasA);
				jugador.setTarjRojas(jugador.getTarjRojas() + tarjetasR);
				anotarResultadoControlador.anotarEstadisticas(jugador);
			}
			for (int i = 0; i < jugadoresVis.size(); i++) {
				int idJugador = Integer.parseInt(tablaJugadoresVisitante.getValueAt(i, 0).toString());
				int goles = Integer.parseInt(tablaJugadoresVisitante.getValueAt(i, 4).toString());
				int asistencias = Integer.parseInt(tablaJugadoresVisitante.getValueAt(i, 5).toString());
				int tarjetasA = Integer.parseInt(tablaJugadoresVisitante.getValueAt(i, 6).toString());
				int tarjetasR = Integer.parseInt(tablaJugadoresVisitante.getValueAt(i, 7).toString());
				golesVisitante += goles;
				JugadorVo jugador = null;
				for (int j = 0; j < jugadoresVis.size(); j++) {
					if (idJugador == jugadoresVis.get(j).getIdJugador()) {
						jugador = jugadoresVis.get(j);
					}
				}
				jugador.setGoles(jugador.getGoles() + goles);
				jugador.setAsistencias(jugador.getAsistencias() + asistencias);
				jugador.setTarjAma(jugador.getTarjAma() + tarjetasA);
				jugador.setTarjRojas(jugador.getTarjRojas() + tarjetasR);
				anotarResultadoControlador.anotarEstadisticas(jugador);
			}
			partidoSelec.setGolesLocal(golesLocal);
			partidoSelec.setGolesVis(golesVisitante);
			anotarResultadoControlador.anotarResultado(partidoSelec);
			setVisible(false);
		}
	}
}
