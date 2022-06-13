package vista;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
import controlador.PartidosControlador;
import controlador.Principal;
import modelo.vo.PartidoVo;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class VentanaPartidos extends JFrame implements ActionListener{
	private JMenuBar barraMenu;
	private JMenuItem menuLogin;
	private Coordinador coordinador;
	private JTable tablaEquipos;
	private JMenu menuTablas;
	private JMenuItem tablaClasificacionMenuItem;
	private JMenuItem tablaPartidosMenuItem;
	private JMenuItem tablaEstadisticasMenuItem;
	private PartidosControlador partidosControlador;
	private JButton refrescarBtn;

	public VentanaPartidos() {
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

		tablaEquipos = new JTable();
		tablaEquipos.setBackground(new Color(255, 255, 255));
		tablaEquipos.setAutoCreateRowSorter(true);
		try {
			llenarTabla(tablaEquipos);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			e.getCause();
		}
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tablaEquipos.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tablaEquipos.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tablaEquipos.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		tablaEquipos.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		tablaEquipos.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		tablaEquipos.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		
		tablaEquipos.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		((DefaultTableCellRenderer) tablaEquipos.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(new JScrollPane(tablaEquipos), BorderLayout.CENTER);
		
		refrescarBtn = new JButton("REFRESCAR");
		getContentPane().add(refrescarBtn, BorderLayout.SOUTH);
		refrescarBtn.addActionListener(this);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		if (e.getSource() == tablaPartidosMenuItem) {
			coordinador.mostrarVentanaPartidos();
		}
		if(e.getSource() == tablaClasificacionMenuItem) {
			coordinador.mostrarVentanaTablas();
		}
		if(e.getSource() == refrescarBtn) {
			setVisible(false);
			coordinador.cerrarTodas();
			Principal principal = new Principal();
			principal.iniciar();
		}

	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;

	}

	public void llenarTabla(JTable tablaEquipos) throws SQLException, IOException {
		DefaultTableModel modeloTabla = new DefaultTableModel() {

			public boolean isCellEditable(int row, int column) {
				// Aqu� devolvemos true o false seg�n queramos que una celda
				// identificada por fila,columna (row,column), sea o no editable
				return false;
			}
		};
		// Establecemos el modelo correspondiente en la JTable
		tablaEquipos.setModel(modeloTabla);

		// A�adimos las columnas correspondientes
		modeloTabla.addColumn("PARTIDO");
		modeloTabla.addColumn("GOLES LOCAL");
		modeloTabla.addColumn("GOLES VISITANTE");
		modeloTabla.addColumn("ARBITRO");
		modeloTabla.addColumn("FECHA");
		modeloTabla.addColumn("HORA");
		
		Object[] columna = new Object[6];

		partidosControlador = new PartidosControlador();
		
		ArrayList<PartidoVo> listaPartidos = partidosControlador.listarPartidos();

		int numRegistros = listaPartidos.size();

		for (int i = 0; i < numRegistros; i++) {
			columna[0] = listaPartidos.get(i).toString();
			if(listaPartidos.get(i).getGolesLocal()!=null) {
				columna[1] = listaPartidos.get(i).getGolesLocal();
				columna[2] = listaPartidos.get(i).getGolesVis();
			}else {
				columna[1] = "PARTIDO";
				columna[2] = "NO JUGADO";
			}
			
			columna[3] = partidosControlador.buscarArbitro(listaPartidos.get(i).getIdArbitro()).toString();
			columna[4] = listaPartidos.get(i).getFecha();
			columna[5] = listaPartidos.get(i).getHora();

			// A�adimos la fila al modelo
			modeloTabla.addRow(columna);

		}

	}

}
