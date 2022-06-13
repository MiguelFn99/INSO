package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Coordinador;
import controlador.ModificarPartidoControlador;
import modelo.vo.ArbitroVo;
import modelo.vo.EquipoVo;
import modelo.vo.PartidoVo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaModificarPartido extends JFrame implements ActionListener {

	private JLabel arbitroLb, fechaLb, horaLb;
	private ModificarPartidoControlador modificarPartidoControlador = new ModificarPartidoControlador();
	private JTextField fechaTf, horaTf;
	private JComboBox<String> eqLocCb, eqVisCb, arbitroCb, partidoCb;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private Coordinador coordinador;
	private JButton modificarPartidoBtn;
	private JLabel lblInfo, eqLocLb, eqVisLb;
	private PartidoVo[] partidos;
	private JLabel lblNewLabel;
	
	

	public VentanaModificarPartido() {
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		setSize(400,550);
		setLocationRelativeTo(null);
		setResizable(false);
			
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(107, 6, 201, 87);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		lblInfo = new JLabel("Seleccione Partido:");
		lblInfo.setBounds(31, 146, 275, 23);
		getContentPane().add(lblInfo);
		
		eqLocLb = new JLabel("Equipo Local:");
		eqLocLb.setBounds(31, 201, 113, 16);
		getContentPane().add(eqLocLb);
		
		eqVisLb = new JLabel("Equipo Visitante:");
		eqVisLb.setBounds(31, 253, 113, 16);
		getContentPane().add(eqVisLb);
		
		arbitroLb = new JLabel("Arbitro:");
		arbitroLb.setLocation(31, 294);
		arbitroLb.setSize(66, 30);
		
		fechaLb = new JLabel("Fecha:");
		fechaLb.setLocation(31, 352);
		fechaLb.setSize(66, 30);
		
		horaLb = new JLabel("Hora:");
		horaLb.setLocation(31, 411);
		horaLb.setSize(66, 30);
	
		
		partidos = modificarPartidoControlador.listarPartidos();
		partidoCb = new JComboBox(partidos);
		partidoCb.setLocation(157, 138);
		partidoCb.setSize(201, 40);
		partidoCb.addActionListener(this); 
		
		EquipoVo[] equiposLocales = modificarPartidoControlador.listarEquipos();
		eqLocCb = new JComboBox(equiposLocales);
		eqLocCb.setLocation(157, 190);
		eqLocCb.setSize(201, 40);
		
		EquipoVo[] equiposVisitantes = modificarPartidoControlador.listarEquipos();
		eqVisCb = new JComboBox(equiposVisitantes);
		eqVisCb.setLocation(157, 242);
		eqVisCb.setSize(201, 40);
		
		ArbitroVo[] listaArbitros = modificarPartidoControlador.listarArbitros();
		arbitroCb = new JComboBox(listaArbitros);
		arbitroCb.setLocation(157, 290);
		arbitroCb.setSize(201, 40);
		
		fechaTf = new JTextField();
		
		//PlaceHolder
		fechaTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fechaTf.setForeground(new Color(0,0,0));
			}
		});
		fechaTf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(fechaTf.getText().equals("AAAA-MM-DD")) {
					fechaTf.setText("");
					fechaTf.setForeground(new Color(153,153,153));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(fechaTf.getText().equals("")) {
					fechaTf.setText("AAAA-MM-DD");
					fechaTf.setForeground(new Color(153,153,153));
				}
			}
		});
		fechaTf.setForeground(Color.LIGHT_GRAY);
		//------
		
		fechaTf.setText("AAAA-MM-DD");
		fechaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		fechaTf.setLocation(163, 352);
		fechaTf.setSize(190, 30);
		
		horaTf = new JTextField();
		horaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		horaTf.setLocation(163, 411);
		horaTf.setSize(190, 30);		
		
		modificarPartidoBtn = new JButton("Modificar Partido");
		modificarPartidoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificarPartidoBtn.setBackground(new Color(255, 255, 255));
		modificarPartidoBtn.setLocation(119, 469);
		modificarPartidoBtn.setSize(159, 40);
		modificarPartidoBtn.addActionListener(this);
		getContentPane().add(modificarPartidoBtn);
		
		getContentPane().add(partidoCb);
		getContentPane().add(eqLocCb);
		getContentPane().add(eqVisCb);
		
		getContentPane().add(arbitroLb);
		getContentPane().add(arbitroCb);
		
		getContentPane().add(fechaLb);
		getContentPane().add(fechaTf);
		
		getContentPane().add(horaLb);
		getContentPane().add(horaTf);
		
		lblNewLabel = new JLabel("Seleccione los Datos del Partido a Modificar");
		lblNewLabel.setBounds(63, 94, 306, 16);
		getContentPane().add(lblNewLabel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==modificarPartidoBtn) {
			PartidoVo partidoSelec = (PartidoVo) partidoCb.getSelectedItem();
			EquipoVo equipoLocal = (EquipoVo) eqLocCb.getSelectedItem();
			EquipoVo equipoVisitante = (EquipoVo) eqVisCb.getSelectedItem();
			ArbitroVo arbitro = (ArbitroVo) arbitroCb.getSelectedItem();
			modificarPartidoControlador.modificarPartido(partidoSelec.getIdPartido(), equipoLocal.getIdEquipo(), equipoVisitante.getIdEquipo(), arbitro.getIdArbitro(), fechaTf.getText(), horaTf.getText());
			coordinador.cerrarVentanaModificarPartido();
		}
		
		if(e.getSource()==partidoCb) {
			PartidoVo partidoSelec = (PartidoVo) partidoCb.getSelectedItem();
			fechaTf.setText(partidoSelec.getFecha());
			horaTf.setText(partidoSelec.getHora());
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

}
