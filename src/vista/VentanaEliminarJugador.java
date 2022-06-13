package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Coordinador;
import controlador.EliminarJugadorControlador;
import modelo.vo.EquipoVo;
import modelo.vo.JugadorVo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class VentanaEliminarJugador extends JFrame implements ActionListener {

	private JLabel lblInfo, lblEqSelec, lblJugSelec;
	private EliminarJugadorControlador eliminarJugadorControlador = new EliminarJugadorControlador();
	private JComboBox<String> equipoCb, jugadorCb;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private Coordinador coordinador;
	private JButton eliminarJugadorBtn;
	

	public VentanaEliminarJugador() {
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		setSize(400,410);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblInfo = new JLabel("Seleccione el jugador a eliminar");
		lblInfo.setBounds(95, 105, 275, 23);
		getContentPane().add(lblInfo);
		
		lblEqSelec = new JLabel("Equipo jugador:");
		lblEqSelec.setBounds(31, 169, 113, 16);
		getContentPane().add(lblEqSelec);
		
		lblJugSelec = new JLabel("Jugador:");
		lblJugSelec.setBounds(31, 221, 113, 16);
		getContentPane().add(lblJugSelec);
		
		
		EquipoVo[] equipos = eliminarJugadorControlador.listarEquipos();
		equipoCb = new JComboBox(equipos);
		equipoCb.setLocation(157, 158);
		equipoCb.setSize(201, 40);
		equipoCb.addActionListener(this);
		getContentPane().add(equipoCb);
		
		eliminarJugadorBtn = new JButton("Eliminar Jugador");
		eliminarJugadorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminarJugadorBtn.setBackground(new Color(255, 255, 255));
		eliminarJugadorBtn.setLocation(118, 272);
		eliminarJugadorBtn.setSize(159, 40);
		eliminarJugadorBtn.addActionListener(this);
		getContentPane().add(eliminarJugadorBtn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(107, 6, 201, 87);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblPrecaucion = new JLabel("Precaución: tenga en cuenta que esta acción es irreversible");
		lblPrecaucion.setBounds(16, 345, 388, 16);
		getContentPane().add(lblPrecaucion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(15, 332, 371, 12);
		getContentPane().add(separator);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==eliminarJugadorBtn) {
			JugadorVo jugadorSelec = (JugadorVo) jugadorCb.getSelectedItem();
			eliminarJugadorControlador.eliminarJugador(jugadorSelec.getIdJugador());
			coordinador.cerrarVentanaEliminarJugador();
		}
		
		if(e.getSource()== equipoCb) {
			EquipoVo eqSelec = (EquipoVo) equipoCb.getSelectedItem();
			JugadorVo[] jugadoresEq = eliminarJugadorControlador.listarJugadoresEquipo(eqSelec.getIdEquipo());
			if(jugadorCb != null) {
				getContentPane().remove(jugadorCb);
			}
			jugadorCb = new JComboBox(jugadoresEq);
			jugadorCb.setLocation(157, 210);
			jugadorCb.setSize(201, 40);
			getContentPane().add(jugadorCb);
		}
		
	}

	public void setCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		this.coordinador = coordinador;
	}
}
