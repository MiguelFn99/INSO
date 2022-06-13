package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Coordinador;
import controlador.CrearPartidoControlador;
import modelo.vo.ArbitroVo;
import modelo.vo.EquipoVo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;

public class VentanaCrearPartido extends JFrame implements ActionListener {

	private JLabel arbitroLb, fechaLb, horaLb;
	private CrearPartidoControlador crearPartidoControlador = new CrearPartidoControlador();
	private JTextField fechaTf, horaTf;
	private JComboBox<String> eqLocCb, eqVisCb, arbitroCb;
	private Image img_logo = new ImageIcon(VentanaLogin.class.getResource("/resources/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	private Coordinador coordinador;
	private JButton crearPartidoBtn;
	private JLabel lblInfo;
	private JLabel eqLocLb;
	private JLabel eqVisLb;
	

	public VentanaCrearPartido() {
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		setSize(400,550);
		setLocationRelativeTo(null);
		setResizable(false);
		
		arbitroLb = new JLabel("Arbitro:");
		arbitroLb.setLocation(31, 266);
		arbitroLb.setSize(66, 30);
		
		fechaLb = new JLabel("Fecha:");
		fechaLb.setLocation(31, 324);
		fechaLb.setSize(66, 30);
		
		horaLb = new JLabel("Hora:");
		horaLb.setLocation(31, 383);
		horaLb.setSize(66, 30);
		
		EquipoVo[] equiposLocales = crearPartidoControlador.listarEquipos();
		eqLocCb = new JComboBox(equiposLocales);
		eqLocCb.setLocation(157, 158);
		eqLocCb.setSize(201, 40);
		
		EquipoVo[] equiposVisitantes = crearPartidoControlador.listarEquipos();
		eqVisCb = new JComboBox(equiposVisitantes);
		eqVisCb.setLocation(157, 210);
		eqVisCb.setSize(201, 40);
		
		ArbitroVo[] listaArbitros = crearPartidoControlador.listarArbitros();
		arbitroCb = new JComboBox(listaArbitros);
		arbitroCb.setLocation(157, 262);
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
		fechaTf.setLocation(163, 324);
		fechaTf.setSize(190, 30);
		
		horaTf = new JTextField();
		horaTf.setBorder(new EmptyBorder(0, 0, 0, 0));
		horaTf.setLocation(163, 383);
		horaTf.setSize(190, 30);
		getContentPane().add(eqLocCb);
		getContentPane().add(eqVisCb);
		
		getContentPane().add(arbitroLb);
		getContentPane().add(arbitroCb);
		
		getContentPane().add(fechaLb);
		getContentPane().add(fechaTf);
		
		getContentPane().add(horaLb);
		getContentPane().add(horaTf);
		
		
		crearPartidoBtn = new JButton("Crear Partido");
		crearPartidoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearPartidoBtn.setBackground(new Color(255, 255, 255));
		crearPartidoBtn.setLocation(117, 454);
		crearPartidoBtn.setSize(159, 40);
		crearPartidoBtn.addActionListener(this);
		getContentPane().add(crearPartidoBtn);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(107, 6, 201, 87);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon(img_logo));
		
		lblInfo = new JLabel("Introduzca los datos del partido");
		lblInfo.setBounds(102, 105, 275, 23);
		getContentPane().add(lblInfo);
		
		eqLocLb = new JLabel("Equipo Local:");
		eqLocLb.setBounds(31, 169, 113, 16);
		getContentPane().add(eqLocLb);
		
		eqVisLb = new JLabel("Equipo Visitante:");
		eqVisLb.setBounds(31, 221, 113, 16);
		getContentPane().add(eqVisLb);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==crearPartidoBtn) {
			EquipoVo equipoLocal = (EquipoVo) eqLocCb.getSelectedItem();
			EquipoVo equipoVisitante = (EquipoVo) eqVisCb.getSelectedItem();
			ArbitroVo arbitro = (ArbitroVo) arbitroCb.getSelectedItem();
			crearPartidoControlador.crearPartido(equipoLocal.getIdEquipo(), equipoVisitante.getIdEquipo(), arbitro.getIdArbitro(), fechaTf.getText(), horaTf.getText());
		}
	}

	public void setCoordinador(Coordinador coordinador) {
		// TODO Auto-generated method stub
		this.coordinador = coordinador;
	}

}
