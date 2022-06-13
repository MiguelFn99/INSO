package vista;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.AnotarResultadoControlador;
import controlador.Coordinador;
import modelo.vo.JugadorVo;
import modelo.vo.PartidoVo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

public class VentanaArbitro extends JFrame implements ActionListener{
	
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage()
			.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private JComboBox partidoCb;
	private JLabel label;
	private AnotarResultadoControlador anotarResultadoControlador;
	private Coordinador coordinador;
	private JButton anotarResultadoBtn;
	
	public VentanaArbitro(int idArbitro) {
		getContentPane().setBackground(new Color(135, 206, 235));
		setSize(400, 300);
		anotarResultadoControlador = new AnotarResultadoControlador();
		PartidoVo[] partidos = anotarResultadoControlador.listarPartidos(idArbitro);
		label = new JLabel("Elija un partido:");
		label.setBounds(139, 90, 106, 34);
		partidoCb = new JComboBox(partidos);
		partidoCb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		((JLabel)partidoCb.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		partidoCb.setBounds(18, 136, 366, 34);
		partidoCb.addActionListener(this);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(label);
		getContentPane().add(partidoCb);
		
		anotarResultadoBtn = new JButton("Anotar Resultado");
		anotarResultadoBtn.setBounds(115, 186, 152, 34);
		anotarResultadoBtn.addActionListener(this);
		getContentPane().add(anotarResultadoBtn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(150, 6, 106, 72);
		lblLogo.setIcon(new ImageIcon(img_logo));
		getContentPane().add(lblLogo);
		this.setVisible(true);
	}

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==anotarResultadoBtn) {
			PartidoVo partidoSelec = (PartidoVo) partidoCb.getSelectedItem();
			ArrayList<JugadorVo> jugadoresLoc = anotarResultadoControlador.listarJugadoresEquipo(partidoSelec.getIdEquipoLocal());
			ArrayList<JugadorVo> jugadoresVis = anotarResultadoControlador.listarJugadoresEquipo(partidoSelec.getIdEquipoVis());
			VentanaAnotarResultados ventanaAnotarResultado = new VentanaAnotarResultados(jugadoresLoc, jugadoresVis, partidoSelec);
			ventanaAnotarResultado.setVisible(true);
		}
	}


	public void setCoordinador(Coordinador coordinador) {
		this.coordinador=coordinador;
	}

}