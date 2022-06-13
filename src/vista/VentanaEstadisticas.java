package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import controlador.EstadisticasControlador;
import controlador.Principal;
import modelo.vo.JugadorVo;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;

public class VentanaEstadisticas extends JFrame implements ActionListener {

	private JMenuBar barraMenu;
	private JMenuItem menuLogin;
	private JMenu menuTablas;
	private JMenuItem tablaClasificacionMenuItem;
	private JMenuItem tablaPartidosMenuItem;
	private JMenuItem tablaEstadisticasMenuItem;
	private JTable tablaJugadores;
	private EstadisticasControlador estadisticasControlador;
	private Coordinador coordinador;
	private JButton refrescarBtn;

	public VentanaEstadisticas() {
		estadisticasControlador = new EstadisticasControlador();
		setSize(1000, 800);
		getContentPane().setLayout(new BorderLayout());
		barraMenu = new JMenuBar();
		barraMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuLogin = new JMenuItem("Identificarse");
		menuLogin.addActionListener(this);

		menuTablas = new JMenu("Tablas");
		menuTablas.setHorizontalTextPosition(SwingConstants.LEFT);
		menuTablas.setHorizontalAlignment(SwingConstants.LEFT);
		menuTablas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		barraMenu.add(menuTablas);

		tablaClasificacionMenuItem = new JMenuItem("Clasificación");
		tablaClasificacionMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaClasificacionMenuItem.addActionListener(this);
		menuTablas.add(tablaClasificacionMenuItem);

		tablaPartidosMenuItem = new JMenuItem("Partidos");
		tablaPartidosMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaPartidosMenuItem.addActionListener(this);
		menuTablas.add(tablaPartidosMenuItem);

		tablaEstadisticasMenuItem = new JMenuItem("Estadisticas Jugadores");
		tablaEstadisticasMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaEstadisticasMenuItem.addActionListener(this);
		menuTablas.add(tablaEstadisticasMenuItem);
		barraMenu.add(menuLogin);
		getContentPane().add(barraMenu, BorderLayout.NORTH);

		tablaJugadores = new JTable();
		tablaJugadores.setAutoCreateRowSorter(true);
		try {
			llenarTabla(tablaJugadores);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			e.getCause();
		}
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tablaJugadores.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tablaJugadores.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tablaJugadores.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		tablaJugadores.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		tablaJugadores.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		tablaJugadores.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		
		((DefaultTableCellRenderer) tablaJugadores.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(new JScrollPane(tablaJugadores), BorderLayout.CENTER);
		
		refrescarBtn = new JButton("REFRESCAR");
		getContentPane().add(refrescarBtn, BorderLayout.SOUTH);
		refrescarBtn.addActionListener(this);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void llenarTabla(JTable tablaEquipos) throws SQLException, IOException {
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int columna) {
				if (columna == 1 || columna == 0)
					return String.class;
				return Integer.class;

			}

			public boolean isCellEditable(int row, int column) {
				// Aqu� devolvemos true o false seg�n queramos que una celda
				// identificada por fila,columna (row,column), sea o no editable
				return false;
			}
		};
		// Establecemos el modelo correspondiente en la JTable
		tablaEquipos.setModel(modeloTabla);

		// A�adimos las columnas correspondientes
		modeloTabla.addColumn("NOMBRE");
		modeloTabla.addColumn("EQUIPO");
		modeloTabla.addColumn("GOLES");
		modeloTabla.addColumn("ASISTENCIAS");
		modeloTabla.addColumn("TARJETAS AMARILLAS");
		modeloTabla.addColumn("TARJETAS ROJAS");
		Object[] columna = new Object[6];
		
		ArrayList <JugadorVo> listaJugadores = estadisticasControlador.listarJugadores();

		int numRegistros = listaJugadores.size();

		for (int i = 0; i < numRegistros; i++) {
			columna[0] = listaJugadores.get(i).toString();
			columna[1] = estadisticasControlador.buscarEquipo(listaJugadores.get(i).getIdEquipo()).toString();
			columna[2] = listaJugadores.get(i).getGoles();
			columna[3] = listaJugadores.get(i).getAsistencias();
			columna[4] = listaJugadores.get(i).getTarjAma();
			columna[5] = listaJugadores.get(i).getTarjRojas();

			// A�adimos la fila al modelo
			modeloTabla.addRow(columna);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == menuLogin) {
			coordinador.mostrarVentanaLogin();
		}
		if (e.getSource() == tablaEstadisticasMenuItem) {
			coordinador.mostrarVentanaEstadisticas();
		}
		if(e.getSource() == tablaClasificacionMenuItem) {
			coordinador.mostrarVentanaTablas();
		}
		if(e.getSource() == tablaPartidosMenuItem) {
			coordinador.mostrarVentanaPartidos();;
		}
		if(e.getSource() == refrescarBtn) {
			coordinador.cerrarTodas();
			Principal principal = new Principal();
			principal.iniciar();
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador=coordinador;
	}
}
