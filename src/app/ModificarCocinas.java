package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class ModificarCocinas
 * @description
 * @HU_CU_REQ
 * @date 5 jun. 2024
 */
public class ModificarCocinas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_precio;
	private JTextField txt_ancho;
	private JTextField txt_alto;
	private JTextField txt_fondo;
	private JTextField txt_quemadores;
	private JButton btn_grabar;
	private JButton btn_cerrar;
	private JComboBox cmb_modelo;

	/**
	 * Create the dialog.
	 */
	public ModificarCocinas() {
		setTitle("Modificar cocina");
		setBounds(143, 195, 558, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 29, 237, 41);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Modelo");
		lblNewLabel_1.setBounds(20, 98, 89, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Precio (S/)");
		lblNewLabel_1_1.setBounds(20, 140, 89, 14);
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Ancho (cm)");
		lblNewLabel_1_2.setBounds(20, 190, 89, 14);
		contentPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Alto (cm)");
		lblNewLabel_1_3.setBounds(20, 236, 89, 14);
		contentPanel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Fondo (cm)");
		lblNewLabel_1_4.setBounds(20, 282, 89, 14);
		contentPanel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Quemadores");
		lblNewLabel_1_5.setBounds(20, 330, 89, 14);
		contentPanel.add(lblNewLabel_1_5);

		cmb_modelo = new JComboBox();
		cmb_modelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCaracteristicasModificar();

			}
		});
		cmb_modelo.setModel(new DefaultComboBoxModel(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cmb_modelo.setBounds(128, 91, 129, 22);
		contentPanel.add(cmb_modelo);

		txt_precio = new JTextField();
		txt_precio.setBounds(128, 134, 129, 20);
		contentPanel.add(txt_precio);
		txt_precio.setColumns(10);

		txt_ancho = new JTextField();
		txt_ancho.setColumns(10);
		txt_ancho.setBounds(128, 184, 129, 20);
		contentPanel.add(txt_ancho);

		txt_alto = new JTextField();
		txt_alto.setColumns(10);
		txt_alto.setBounds(128, 230, 129, 20);
		contentPanel.add(txt_alto);

		txt_fondo = new JTextField();
		txt_fondo.setColumns(10);
		txt_fondo.setBounds(128, 276, 129, 20);
		contentPanel.add(txt_fondo);

		txt_quemadores = new JTextField();
		txt_quemadores.setColumns(10);
		txt_quemadores.setBounds(128, 324, 129, 20);
		contentPanel.add(txt_quemadores);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCerrar(); // // BOTÓN CERRAR - VENTANA MODIFICAR
			}
		});
		btn_cerrar.setBounds(396, 98, 89, 23);
		contentPanel.add(btn_cerrar);

		btn_grabar = new JButton("Grabar");
		btn_grabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grabarDatosModificados();
			}
		});
		btn_grabar.setBounds(396, 132, 89, 23);
		contentPanel.add(btn_grabar);
	}

	void botonCerrar() {
		this.dispose(); // MÉTODO DE HACE REFERENCIA PARA CERRAR LA VENTANA ACTUAL
	}

	void cargarCaracteristicasModificar() {
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

	// @PARAM OBTENER MODELO-COCINA SELECIONADO
	int getModelo() {
		return cmb_modelo.getSelectedIndex();
	}

	void grabarDatosModificados() {
		/*
		 * DECLARA VARIABLES MODELO -> ( GUARDAR DATOS MODIFICADOS DEL MODELO-COCINA LOCALMENTE) 
		 * OPCION -> ( VENTANA DE CONFIRMACIÓN )
		 */
		int modelo, opcion;
		modelo = getModelo();
		opcion = JOptionPane.showConfirmDialog(this, "Confirmar cambios?", "Datos Modificados",
				JOptionPane.YES_NO_OPTION);
		if (opcion == 0) {
			modificarDatosCocinas(modelo);

			// USUARIO ACEPTA LOS CAMBIOS SE INGRESA METODO CERRAR VENTANA ACTUAL
			this.dispose();
		}

	}

	//ENTRADA DE DATOS DEL USUARIO QUE ESTA MODIFICANDO
	void modificarDatosCocinas(int modelo) {
		switch (modelo) {
		case 0: // m_0 - Mabe EMP6120PG0
			MenuPrincipal.p_0 = Double.parseDouble(txt_precio.getText());
			MenuPrincipal.anch_0 = Double.parseDouble(txt_ancho.getText());
			MenuPrincipal.alt_0 = Double.parseDouble(txt_alto.getText());
			MenuPrincipal.prof_0 = Double.parseDouble(txt_fondo.getText());
			MenuPrincipal.qdr_0 = Integer.parseInt(txt_quemadores.getText());
			break;

		case 1: // m_1 - Indurama Parma
			MenuPrincipal.p_1 = Double.parseDouble(txt_precio.getText());
			MenuPrincipal.anch_1 = Double.parseDouble(txt_ancho.getText());
			MenuPrincipal.alt_1 = Double.parseDouble(txt_alto.getText());
			MenuPrincipal.prof_1 = Double.parseDouble(txt_fondo.getText());
			MenuPrincipal.qdr_1 = Integer.parseInt(txt_quemadores.getText());
			break;

		case 2: // m_2 - Sole COSOL027
			MenuPrincipal.p_2 = Double.parseDouble(txt_precio.getText());
			MenuPrincipal.anch_2 = Double.parseDouble(txt_ancho.getText());
			MenuPrincipal.alt_2 = Double.parseDouble(txt_alto.getText());
			MenuPrincipal.prof_2 = Double.parseDouble(txt_fondo.getText());
			MenuPrincipal.qdr_2 = Integer.parseInt(txt_quemadores.getText());
			break;

		case 3: // m_3 - Coldex CX602
			MenuPrincipal.p_3 = Double.parseDouble(txt_precio.getText());
			MenuPrincipal.anch_3 = Double.parseDouble(txt_ancho.getText());
			MenuPrincipal.alt_3 = Double.parseDouble(txt_alto.getText());
			MenuPrincipal.prof_3 = Double.parseDouble(txt_fondo.getText());
			MenuPrincipal.qdr_3 = Integer.parseInt(txt_quemadores.getText());
			break;

		default:// m_4 - Reco Dakota
			MenuPrincipal.p_4 = Double.parseDouble(txt_precio.getText());
			MenuPrincipal.anch_4 = Double.parseDouble(txt_ancho.getText());
			MenuPrincipal.alt_4 = Double.parseDouble(txt_alto.getText());
			MenuPrincipal.prof_4 = Double.parseDouble(txt_fondo.getText());
			MenuPrincipal.qdr_4 = Integer.parseInt(txt_quemadores.getText());
			break;
		}
	}

}
