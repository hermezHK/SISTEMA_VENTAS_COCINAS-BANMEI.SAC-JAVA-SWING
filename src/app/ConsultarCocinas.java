package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class ConsultarCocinas
 * @description
 * @HU_CU_REQ
 * @date 5 jun. 2024
 */
public class ConsultarCocinas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_precio;
	private JTextField txt_ancho;
	private JTextField txt_alto;
	private JTextField txt_fondo;
	private JTextField txt_quemadores;
	private JComboBox cmb_modelo;
	private JButton btn_cerrar;
	private JLabel lbl_alto;
	private JLabel lbl_ancho;
	private JLabel lbl_precio;
	private JLabel lbl_modelo;
	private JLabel lbl_quemadores;
	private JLabel lbl_fondo;

	/**
	 * Create the dialog.
	 */
	public ConsultarCocinas() {
		setTitle("Consultar cocina");
		setBounds(130, 150, 558, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 29, 237, 41);
		contentPanel.add(lblNewLabel);

		lbl_modelo = new JLabel("Modelo");
		lbl_modelo.setBounds(20, 98, 89, 14);
		contentPanel.add(lbl_modelo);

		lbl_precio = new JLabel("Precio (S/)");
		lbl_precio.setBounds(20, 140, 89, 14);
		contentPanel.add(lbl_precio);

		lbl_ancho = new JLabel("Ancho (cm)");
		lbl_ancho.setBounds(20, 190, 103, 14);
		contentPanel.add(lbl_ancho);

		lbl_alto = new JLabel("Alto (cm)");
		lbl_alto.setBounds(20, 236, 89, 14);
		contentPanel.add(lbl_alto);

		lbl_fondo = new JLabel("Fondo (cm)");
		lbl_fondo.setBounds(20, 282, 89, 14);
		contentPanel.add(lbl_fondo);

		lbl_quemadores = new JLabel("Quemadores");
		lbl_quemadores.setBounds(20, 330, 89, 14);
		contentPanel.add(lbl_quemadores);

		txt_precio = new JTextField();
		txt_precio.setEditable(false);
		txt_precio.setColumns(10);
		txt_precio.setBounds(145, 137, 129, 20);
		contentPanel.add(txt_precio);

		txt_ancho = new JTextField();
		txt_ancho.setEditable(false);
		txt_ancho.setColumns(10);
		txt_ancho.setBounds(145, 187, 129, 20);
		contentPanel.add(txt_ancho);

		txt_alto = new JTextField();
		txt_alto.setEditable(false);
		txt_alto.setColumns(10);
		txt_alto.setBounds(145, 233, 129, 20);
		contentPanel.add(txt_alto);

		txt_fondo = new JTextField();
		txt_fondo.setEditable(false);
		txt_fondo.setColumns(10);
		txt_fondo.setBounds(145, 279, 129, 20);
		contentPanel.add(txt_fondo);

		txt_quemadores = new JTextField();
		txt_quemadores.setEditable(false);
		txt_quemadores.setColumns(10);
		txt_quemadores.setBounds(145, 327, 129, 20);
		contentPanel.add(txt_quemadores);

		cmb_modelo = new JComboBox();
		cmb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCaracteristicasConsultas();
			}
		});
		cmb_modelo.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cmb_modelo.setBounds(145, 91, 129, 22);
		contentPanel.add(cmb_modelo);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerrarVentana(); // BOTÓN CERRAR - VENTANA CONSULTAS
			}
		});
		btn_cerrar.setBounds(389, 94, 89, 23);
		contentPanel.add(btn_cerrar);
	}

	void CerrarVentana() {
		this.dispose(); // MÉTODO DE HACE REFERENCIA PARA CERRAR LA VENTANA ACTUAL

	}

	void cargarCaracteristicasConsultas() {

		// CARGAR CARACTERISTICA POR MODELO
		int elegirModelo;
		elegirModelo = cmb_modelo.getSelectedIndex();

		// ELEGIR POR MODELO
		switch (elegirModelo) {
		case 0: // m_0 - Mabe EMP6120PG0
			txt_precio.setText("" + MenuPrincipal.p_0);
			txt_ancho.setText("" + MenuPrincipal.anch_0);
			txt_alto.setText("" + MenuPrincipal.alt_0);
			txt_fondo.setText("" + MenuPrincipal.prof_0);
			txt_quemadores.setText("" + MenuPrincipal.qdr_0);

			break;
		case 1:// m_1 - Indurama Parma
			txt_precio.setText("" + MenuPrincipal.p_1);
			txt_ancho.setText("" + MenuPrincipal.anch_1);
			txt_alto.setText("" + MenuPrincipal.alt_1);
			txt_fondo.setText("" + MenuPrincipal.prof_1);
			txt_quemadores.setText("" + MenuPrincipal.qdr_1);
			break;

		case 2:// m_2 - Sole COSOL027
			txt_precio.setText("" + MenuPrincipal.p_2);
			txt_ancho.setText("" + MenuPrincipal.anch_2);
			txt_alto.setText("" + MenuPrincipal.alt_2);
			txt_fondo.setText("" + MenuPrincipal.prof_2);
			txt_quemadores.setText("" + MenuPrincipal.qdr_2);
			break;

		case 3:// m_3 - Coldex CX602
			txt_precio.setText("" + MenuPrincipal.p_3);
			txt_ancho.setText("" + MenuPrincipal.anch_3);
			txt_alto.setText("" + MenuPrincipal.alt_3);
			txt_fondo.setText("" + MenuPrincipal.prof_3);
			txt_quemadores.setText("" + MenuPrincipal.qdr_3);
			break;

		default:// m_4 - Reco Dakota
			txt_precio.setText("" + MenuPrincipal.p_4);
			txt_ancho.setText("" + MenuPrincipal.anch_4);
			txt_alto.setText("" + MenuPrincipal.alt_4);
			txt_fondo.setText("" + MenuPrincipal.prof_4);
			txt_quemadores.setText("" + MenuPrincipal.qdr_4);
			break;
		}

	}

}
