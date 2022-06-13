package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class VentanaAdministrador extends JFrame implements ActionListener{

	private Coordinador coordinador;
	private JButton crearEquipoBtn, crearPartidoBtn, crearJugadorBtn, crearArbitroBtn;
	private JButton eliminarPartidoBtn, eliminarEquipoBtn, eliminarJugadorBtn, eliminarArbitroBtn;
	private JButton modificarPartidoBtn, modificarEquipoBtn, modificarJugadorBtn, modificarArbitroBtn;
	private JButton menajesBtn;
	private JLabel lblEquipos;
	private JLabel lblJugadores;
	private JLabel lblArbitros;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

	
	
	public VentanaAdministrador() {
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(900,420);
		setLocationRelativeTo(null);
		setResizable(false);
		crearEquipoBtn = new JButton("Crear Equipo");
		crearEquipoBtn.setBackground(Color.WHITE);
		crearEquipoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearEquipoBtn.setBounds(267, 102, 168, 29);
		crearJugadorBtn = new JButton("Crear Jugador");
		crearJugadorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearJugadorBtn.setBackground(Color.WHITE);
		crearJugadorBtn.setBounds(473, 102, 168, 29);
		crearEquipoBtn.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(crearEquipoBtn, BorderLayout.CENTER);
		crearPartidoBtn = new JButton("Crear Partido");
		crearPartidoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearPartidoBtn.setBackground(Color.WHITE);
		crearPartidoBtn.setBounds(59, 102, 168, 29);
		crearPartidoBtn.addActionListener(this);
		getContentPane().add(crearPartidoBtn);

		crearJugadorBtn.addActionListener(this);
		getContentPane().add(crearEquipoBtn);
		getContentPane().add(crearJugadorBtn);
		
		JLabel lblPartidos = new JLabel("Administrar Partidos");
		lblPartidos.setFont(new Font("Chalkboard", Font.PLAIN, 16));
		lblPartidos.setBounds(70, 37, 174, 35);
		getContentPane().add(lblPartidos);
		
		lblEquipos = new JLabel("Administrar Equipos");
		lblEquipos.setFont(new Font("Chalkboard", Font.PLAIN, 16));
		lblEquipos.setBounds(277, 37, 158, 35);
		getContentPane().add(lblEquipos);
		
		lblJugadores = new JLabel("Administrar Jugadores");
		lblJugadores.setFont(new Font("Chalkboard", Font.PLAIN, 16));
		lblJugadores.setBounds(473, 37, 203, 35);
		getContentPane().add(lblJugadores);
		
		lblArbitros = new JLabel("Administrar Arbitros");
		lblArbitros.setFont(new Font("Chalkboard", Font.PLAIN, 16));
		lblArbitros.setBounds(697, 37, 203, 35);
		getContentPane().add(lblArbitros);
		
		eliminarPartidoBtn = new JButton("Eliminar Partido");
		eliminarPartidoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarPartidoBtn.setBackground(Color.WHITE);
		eliminarPartidoBtn.setBounds(59, 165, 168, 29);
		eliminarPartidoBtn.addActionListener(this);
		getContentPane().add(eliminarPartidoBtn);
		
		modificarPartidoBtn = new JButton("Modificar Partido");
		modificarPartidoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarPartidoBtn.setBackground(Color.WHITE);
		modificarPartidoBtn.setBounds(59, 232, 168, 29);
		modificarPartidoBtn.addActionListener(this);
		getContentPane().add(modificarPartidoBtn);
		
		eliminarEquipoBtn = new JButton("Eliminar Equipo");
		eliminarEquipoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarEquipoBtn.setBackground(Color.WHITE);
		eliminarEquipoBtn.setBounds(267, 165, 168, 29);
		eliminarEquipoBtn.addActionListener(this);
		getContentPane().add(eliminarEquipoBtn);
		
		modificarEquipoBtn = new JButton("Modificar Equipo");
		modificarEquipoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarEquipoBtn.setBackground(Color.WHITE);
		modificarEquipoBtn.setBounds(267, 232, 168, 29);
		modificarEquipoBtn.addActionListener(this);
		getContentPane().add(modificarEquipoBtn);
		
		eliminarJugadorBtn = new JButton("Eliminar Jugador");
		eliminarJugadorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarJugadorBtn.setBackground(Color.WHITE);
		eliminarJugadorBtn.setBounds(473, 165, 168, 29);
		eliminarJugadorBtn.addActionListener(this);
		getContentPane().add(eliminarJugadorBtn);
		
		modificarJugadorBtn = new JButton("Modificar Jugador");
		modificarJugadorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarJugadorBtn.setBackground(Color.WHITE);
		modificarJugadorBtn.setBounds(473, 232, 168, 29);
		modificarJugadorBtn.addActionListener(this);
		getContentPane().add(modificarJugadorBtn);
		
		crearArbitroBtn = new JButton("Crear Arbitro");
		crearArbitroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearArbitroBtn.setBackground(Color.WHITE);
		crearArbitroBtn.setBounds(690, 102, 168, 29);
		crearArbitroBtn.addActionListener(this);
		getContentPane().add(crearArbitroBtn);
		
		eliminarArbitroBtn = new JButton("Eliminar Arbitro");
		eliminarArbitroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarArbitroBtn.setBackground(Color.WHITE);
		eliminarArbitroBtn.setBounds(690, 165, 168, 29);
		eliminarArbitroBtn.addActionListener(this);
		getContentPane().add(eliminarArbitroBtn);
		
		modificarArbitroBtn = new JButton("Modificar Arbitro");
		modificarArbitroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarArbitroBtn.setBackground(Color.WHITE);
		modificarArbitroBtn.setBounds(690, 232, 168, 29);
		modificarArbitroBtn.addActionListener(this);
		getContentPane().add(modificarArbitroBtn);
		
		menajesBtn = new JButton("Mensajes");
		menajesBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menajesBtn.setBackground(Color.WHITE);
		menajesBtn.setBounds(370, 299, 168, 29);
		menajesBtn.addActionListener(this);
		getContentPane().add(menajesBtn);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(447, 49, 14, 208);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(241, 49, 14, 208);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(662, 49, 14, 208);
		getContentPane().add(separator_2);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(809, 307, 85, 65);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==crearEquipoBtn) {
			coordinador.mostrarVentanaCrearEquipo();
		}
		
		if(e.getSource()==crearPartidoBtn) {
			coordinador.mostrarVentanaCrearPartido();
		}
		
		if (e.getSource()==crearJugadorBtn) {
			coordinador.mostrarVentanaCrearJugador();
		}
		
		if(e.getSource()==crearArbitroBtn) {
			coordinador.mostrarVentanaCrearArbitro();
		}
		
		if(e.getSource()==modificarEquipoBtn) {
			coordinador.mostrarVentanaModificarEquipo();
		}

		if(e.getSource()==modificarPartidoBtn) {
			coordinador.mostrarVentanaModificarPartido();
		}
		
		if(e.getSource()==eliminarEquipoBtn) {
			coordinador.mostrarVentanaEliminarEquipo();
		}
		
		if(e.getSource()==eliminarArbitroBtn) {
			coordinador.mostrarVentanaEliminarArbitro();
		}
		
		if(e.getSource()==eliminarPartidoBtn) {
			coordinador.mostrarVentanaEliminarPartido();
		}
		if(e.getSource()==eliminarJugadorBtn) {
			coordinador.mostrarVentanaEliminarJugador();
		}
		if(e.getSource()==modificarArbitroBtn) {
			coordinador.mostrarVentanaModificarArbitro();
		}
		if(e.getSource()==modificarJugadorBtn) {
			coordinador.mostrarVentanaModificarJugador();
		}
		if(e.getSource() == menajesBtn) {
			coordinador.mostrarVentanaMensajes();
		}
	} 
}
