package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class ConfigurarObsequios
 * @description
 * @HU_CU_REQ
 * @date 10 jun. 2024
 */
public class ConfigurarObsequios extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_unid1;
	private JTextField txt_unid_2_a_5;
	private JButton btn_aceptar;
	private JButton btn_cancelar;
	private JTextField txt_6_a_mas;

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(490, 190, 558, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// TITULO
		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 237, 41);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("1 unidad");
		lblNewLabel_1.setBounds(10, 63, 95, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("2 a 5 unidades");
		lblNewLabel_1_1.setBounds(10, 99, 95, 14);
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("6 a más unidades");
		lblNewLabel_1_2.setBounds(10, 141, 109, 14);
		contentPanel.add(lblNewLabel_1_2);

		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAceptar();//BOTÓN ACEPTAR DE LA VENTANA CONFIGURAR-OBSEQUIOS
			}
		});
		btn_aceptar.setBounds(417, 59, 89, 23);
		contentPanel.add(btn_aceptar);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelar();//BOTÓN CANCELAR DE LA VENTANA CONFIGURAR-OBSEQUIOS
			}
		});
		btn_cancelar.setBounds(417, 95, 89, 23);
		contentPanel.add(btn_cancelar);

		txt_unid1 = new JTextField();
		txt_unid1.setBounds(129, 63, 132, 20);
		contentPanel.add(txt_unid1);
		txt_unid1.setColumns(10);

		txt_unid_2_a_5 = new JTextField();
		txt_unid_2_a_5.setColumns(10);
		txt_unid_2_a_5.setBounds(129, 96, 132, 20);
		contentPanel.add(txt_unid_2_a_5);

		txt_6_a_mas = new JTextField();
		txt_6_a_mas.setColumns(10);
		txt_6_a_mas.setBounds(129, 138, 132, 20);
		contentPanel.add(txt_6_a_mas);

		// MUESTRA LOS OBSEQUIOS EN PANTALLA (OUTPUT)
		txt_unid1.setText("" + MenuPrincipal.obsq1);
		txt_unid_2_a_5.setText("" + MenuPrincipal.obsq2);
		txt_6_a_mas.setText("" + MenuPrincipal.obsq3);

	}

	void botonCancelar() {
		this.dispose();// MÉTODO DE HACE REFERENCIA PARA CERRAR LA VENTANA ACTUAL

	}

	void botonAceptar() {
		//SE GUARDA LOS DATOS MODIFICADOS DEL USUARIO LOCALMENTE
		MenuPrincipal.obsq1 = txt_unid1.getText();
		MenuPrincipal.obsq2 = txt_unid_2_a_5.getText();
		MenuPrincipal.obsq3 = txt_6_a_mas.getText();

		JOptionPane.showInternalMessageDialog(null, "Modificado correctamente", "Datos", 1);
		this.dispose();// USUARIO ACEPTA LOS CAMBIOS SE INGRESA METODO CERRAR VENTANA ACTUAL

	}
	
}
