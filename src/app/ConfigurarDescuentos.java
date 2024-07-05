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
 * @class ConfigurarDescuentos
 * @description
 * @HU_CU_REQ
 * @date 10 jun. 2024
 */
public class ConfigurarDescuentos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_1_5_unidades;
	private JTextField txt_6_10_unidades;
	private JTextField txt_11_15_unidades;
	private JTextField txt_mas_15_unidades;
	private JButton btn_aceptar;
	private JButton btn_cancelar;

	/**
	 * Create the dialog.
	 */
	public ConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(450, 150, 558, 439);
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

		JLabel lblNewLabel_1 = new JLabel("1 a 5 unidades");
		lblNewLabel_1.setBounds(10, 88, 110, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("6 a 10 unidades");
		lblNewLabel_1_1.setBounds(10, 140, 110, 14);
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("11 a 15 unidades");
		lblNewLabel_1_2.setBounds(10, 188, 110, 14);
		contentPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Más de 15 unidades");
		lblNewLabel_1_3.setBounds(10, 240, 121, 14);
		contentPanel.add(lblNewLabel_1_3);

		txt_1_5_unidades = new JTextField();
		txt_1_5_unidades.setBounds(153, 85, 110, 20);
		contentPanel.add(txt_1_5_unidades);
		txt_1_5_unidades.setColumns(10);

		txt_6_10_unidades = new JTextField();
		txt_6_10_unidades.setColumns(10);
		txt_6_10_unidades.setBounds(153, 137, 110, 20);
		contentPanel.add(txt_6_10_unidades);

		txt_11_15_unidades = new JTextField();
		txt_11_15_unidades.setColumns(10);
		txt_11_15_unidades.setBounds(153, 185, 110, 20);
		contentPanel.add(txt_11_15_unidades);

		txt_mas_15_unidades = new JTextField();
		txt_mas_15_unidades.setColumns(10);
		txt_mas_15_unidades.setBounds(153, 237, 110, 20);
		contentPanel.add(txt_mas_15_unidades);

		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();//BOTÓN ACEPTAR DE VENTANA CONFIGURAR-DESCUENTOS
			}
		});
		btn_aceptar.setBounds(435, 84, 89, 23);
		contentPanel.add(btn_aceptar);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCancelar(); //BOTÓN CANCELAR DE LA VENTANA CONFIGURAR-DESCUENTOS
			}
		});
		btn_cancelar.setBounds(435, 118, 89, 23);
		contentPanel.add(btn_cancelar);

		//MUESTRA LOS PORCENTAJE EN PANTALLA (OUTPUT)
		txt_1_5_unidades.setText("" + MenuPrincipal.porcRango1);
		txt_6_10_unidades.setText("" + MenuPrincipal.porcRango2);
		txt_11_15_unidades.setText("" + MenuPrincipal.porcRango3);
		txt_mas_15_unidades.setText("" + MenuPrincipal.porcRango4);
	}

	void botonCancelar() {
		this.dispose(); // MÉTODO DE HACE REFERENCIA PARA CERRAR LA VENTANA ACTUAL

	}

	void aceptar() {
		// PERMITE MANEJAR ERRORES DE TIEMPO DE EJECUCIÓN QUE PUEDEN OCURRIR MIENTRAS SE EJECUTA EL PROGRAMA.
		try { 
			MenuPrincipal.porcRango1 = Double.parseDouble(txt_1_5_unidades.getText());
			MenuPrincipal.porcRango2 = Double.parseDouble(txt_6_10_unidades.getText());
			MenuPrincipal.porcRango3 = Double.parseDouble(txt_11_15_unidades.getText());
			MenuPrincipal.porcRango4 = Double.parseDouble(txt_mas_15_unidades.getText());
			
			/* NumberFormatException LA EXCEPCIÓN SE USA COMO INDICADOR SI LA CONVERSIÓN DE STRING A UN NÚMERO
			   NO ES POSIBLE. EL NÚMERO PUEDE SER ENTERO, FLOTANTE O DECIMAL SEGÚN SUS REQUISITOS*/
		} catch (NumberFormatException e) { 
			//MENSAJE DE EXCEPTION INFORMA AL USUARIO FINAL
			JOptionPane.showMessageDialog(null, "Ingrese valores númericos ");
			 return;

		}
		 //MENSAJE MODIFICACIÓN EXITOSA DE LOS DATOS
		JOptionPane.showInternalMessageDialog(null, "Modificado correctamente");
		this.dispose(); // USUARIO ACEPTA LOS CAMBIOS SE INGRESA METODO CERRAR VENTANA ACTUAL
	}

}
