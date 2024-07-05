package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class GenerarReportes
 * @description
 * @HU_CU_REQ
 * @date 10 jun. 2024
 */
public class GenerarReportes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	int item;
	// variables que guardan los valores de las variables globales Public Static de
	// FrmSistema
	String modelo0 = MenuPrincipal.m_0, modelo1 = MenuPrincipal.m_1, modelo2 = MenuPrincipal.m_2,
			modelo3 = MenuPrincipal.m_3, modelo4 = MenuPrincipal.m_4;

	int cantVentas0 = MenuPrincipal.contadorVenta0, cantVentas1 = MenuPrincipal.contadorVenta1,
			cantVentas2 = MenuPrincipal.contadorVenta2, cantVentas3 = MenuPrincipal.contadorVenta3,
			cantVentas4 = MenuPrincipal.contadorVenta4;

	int unidVendidas0 = MenuPrincipal.cantUniVendidas0, unidVendidas1 = MenuPrincipal.cantUniVendidas1,
			unidVendidas2 = MenuPrincipal.cantUniVendidas2, unidVendidas3 = MenuPrincipal.cantUniVendidas3,
			unidVendidas4 = MenuPrincipal.cantUniVendidas4;

	double impAcum0 = MenuPrincipal.importeAcumulado0, impAcum1 = MenuPrincipal.importeAcumulado1,
			impAcum2 = MenuPrincipal.importeAcumulado2, impAcum3 = MenuPrincipal.importeAcumulado3,
			impAcum4 = MenuPrincipal.importeAcumulado4;

	double porCuota0 = MenuPrincipal.porcentajeCuota0, porCuota1 = MenuPrincipal.porcentajeCuota1,
			porCuota2 = MenuPrincipal.porcentajeCuota2, porCuota3 = MenuPrincipal.porcentajeCuota3,
			porCuota4 = MenuPrincipal.porcentajeCuota4;

	int cantOptima = MenuPrincipal.cantVent;

	double precio0 = MenuPrincipal.p_0, precio1 = MenuPrincipal.p_1, precio2 = MenuPrincipal.p_2,
			precio3 = MenuPrincipal.p_3, precio4 = MenuPrincipal.p_4;

	double ancho0 = MenuPrincipal.anch_0, ancho1 = MenuPrincipal.anch_1, ancho2 = MenuPrincipal.anch_2,
			ancho3 = MenuPrincipal.anch_3, ancho4 = MenuPrincipal.anch_4;

	// CALCULAR PRECIO Y ANCHO PROMEDIO
	double precioPromedio = (precio0 + precio1 + precio2 + precio3 + precio4) / 5;
	double anchoPromedio = (ancho0 + ancho1 + ancho2 + ancho3 + ancho4) / 5;
	private JTextArea txt_area_reportes;
	private JComboBox cmb_tipo_reporte;
	private JButton btn_cerrar;

	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setTitle("Generar reportes");
		setBounds(298, 195, 700, 439);
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

		JLabel lblNewLabel_1 = new JLabel("Tipo de reporte");
		lblNewLabel_1.setBounds(10, 63, 85, 14);
		contentPanel.add(lblNewLabel_1);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCerrar();
			}
		});
		btn_cerrar.setBounds(581, 59, 97, 22);
		contentPanel.add(btn_cerrar);

		cmb_tipo_reporte = new JComboBox();
		cmb_tipo_reporte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				obtenerTipoReporte(); // OBTENER EL TIPO DE REPORTE
			}
		});
		cmb_tipo_reporte.setModel(
				new DefaultComboBoxModel(new String[] { "Ventas por modelo", "Ventas en relación a la venta óptima",
						"Precios en relación al precio promedio", "Promedios, menores y mayores" }));
		cmb_tipo_reporte.setBounds(114, 59, 418, 22);
		contentPanel.add(cmb_tipo_reporte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 522, 281);
		contentPanel.add(scrollPane);

		txt_area_reportes = new JTextArea();
		scrollPane.setViewportView(txt_area_reportes);
		
		reportePorModelo();
	}

	 void botonCerrar() {
		this.dispose();
		
	}

	// METODOS PARA EL JCOMBOBOX TIPO REPORTE
	void obtenerTipoReporte() { // OBTENER LA SELECCION DEL CMB
		item = cmb_tipo_reporte.getSelectedIndex();

		// OBTENER LA SELECCION DEL COMBO BOX
		switch (item) {
		// SELECIONAR POR MÉTODO
		case 0:
			reportePorModelo();
			break;
		case 1:
			reporteVentaOptima();
			break;
		case 2:
			reportePrecioPromedio();
			break;
		default:
			reportePromedioMenoresMayores();

		}
		/*
		 * INDICANDO LA POSICIÓN 0 AREA DE TEXTO QUE MUESTRE EN LA PRIMERA LINEA LOS
		 * REPORTES
		 */
		txt_area_reportes.setCaretPosition(0);
	}

	void reportePorModelo() {

		// REDONDEO A 2 DECIMALES MÉTODO DECIMAL FORMAT
		DecimalFormat formato1 = new DecimalFormat("0.00");

		// TITULO
		txt_area_reportes.setText("VENTAS POR MODELO \n\n");

		// MUESTRA LA LISTA X MODELO

		// MODELO-O
		txt_area_reportes.append("Modelo                        : " + modelo0 + "\n");
		txt_area_reportes.append("Cantidad de Ventas            : " + cantVentas0 + "\n");
		txt_area_reportes.append("Cantidad de Unidades Vendidas : " + unidVendidas0 + "\n");
		txt_area_reportes.append("Importe total vendido         : S/." + formato1.format(impAcum0) + "\n");
		txt_area_reportes.append("Aporte a la cuota diaria      : " + formato1.format(porCuota0) + "%" + "\n\n");

		// MODELO-1
		txt_area_reportes.append("Modelo                        : " + modelo1 + "\n");
		txt_area_reportes.append("Cantidad de Ventas            : " + cantVentas1 + "\n");
		txt_area_reportes.append("Cantidad de Unidades Vendidas : " + unidVendidas1 + "\n");
		txt_area_reportes.append("Importe total vendido         : S/." + formato1.format(impAcum1) + "\n");
		txt_area_reportes.append("Aporte a la cuota diaria      : " + formato1.format(porCuota1) + "%" + "\n\n");

		// MODELO-2
		txt_area_reportes.append("Modelo                        : " + modelo2 + "\n");
		txt_area_reportes.append("Cantidad de Ventas            : " + cantVentas2 + "\n");
		txt_area_reportes.append("Cantidad de Unidades Vendidas : " + unidVendidas2 + "\n");
		txt_area_reportes.append("Importe total vendido         : S/." + formato1.format(impAcum2) + "\n");
		txt_area_reportes.append("Aporte a la cuota diaria      : " + formato1.format(porCuota2) + "%" + "\n\n");

		// MODELO-3
		txt_area_reportes.append("Modelo                        : " + modelo3 + "\n");
		txt_area_reportes.append("Cantidad de Ventas            : " + cantVentas3 + "\n");
		txt_area_reportes.append("Cantidad de Unidades Vendidas : " + unidVendidas3 + "\n");
		txt_area_reportes.append("Importe total vendido         : S/." + formato1.format(impAcum3) + "\n");
		txt_area_reportes.append("Aporte a la cuota diaria      : " + formato1.format(porCuota3) + "%" + "\n\n");

		// MODELO-4
		txt_area_reportes.append("Modelo                        : " + modelo4 + "\n");
		txt_area_reportes.append("Cantidad de Ventas            : " + cantVentas4 + "\n");
		txt_area_reportes.append("Cantidad de Unidades Vendidas : " + unidVendidas4 + "\n");
		txt_area_reportes.append("Importe total vendido         : S/." + formato1.format(impAcum4) + "\n");
		txt_area_reportes.append("Aporte a la cuota diaria      : " + formato1.format(porCuota4) + "%" + "\n\n");

		/*
		 * INDICANDO LA POSICIÓN 0 AREA DE TEXTO QUE MUESTRE EN LA PRIMERA LINEA LOS
		 * REPORTES
		 */
		txt_area_reportes.setCaretPosition(0);

	}

	// METODO REPORTE VENTAS EN RELACION A LA VENTA ÓPTIMA
	void reporteVentaOptima() {
		// TITULO
		txt_area_reportes.setText("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA" + "\n\n");

		// MOSTRAR LISTA X MODELO

		// MODELO-0
		txt_area_reportes.append("Modelo                        : " + modelo0 + "\n");
		if (unidVendidas0 < cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas0 + "("
					+ (cantOptima - unidVendidas0) + " menor a la  cantidad óptima)" + "\n\n");
		else if (unidVendidas0 > cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas0 + "("
					+ (unidVendidas0 - cantOptima) + " mayor que la cantidad óptima)" + "\n\n");
		else
			txt_area_reportes.append(
					"Cantidad de unidades vendidas : " + unidVendidas0 + "(igual a la cantidad óptima)" + "\n\n");

		// MODELO-1
		txt_area_reportes.append("Modelo                        : " + modelo1 + "\n");
		if (unidVendidas1 < cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas1 + "("
					+ (cantOptima - unidVendidas1) + " menor a la  cantidad óptima)" + "\n\n");
		else if (unidVendidas1 > cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas1 + "("
					+ (unidVendidas1 - cantOptima) + " mayor que la cantidad óptima)" + "\n\n");
		else
			txt_area_reportes.append(
					"Cantidad de unidades vendidas : " + unidVendidas1 + "(igual a la cantidad óptima)" + "\n\n");

		// MODELO-2
		txt_area_reportes.append("Modelo                        : " + modelo2 + "\n");
		if (unidVendidas2 < cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas2 + "("
					+ (cantOptima - unidVendidas2) + " menor a la  cantidad óptima)" + "\n\n");
		else if (unidVendidas2 > cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas2 + "("
					+ (unidVendidas2 - cantOptima) + " mayor que la cantidad óptima)" + "\n\n");
		else
			txt_area_reportes.append(
					"Cantidad de unidades vendidas : " + unidVendidas2 + "(igual a la cantidad óptima)" + "\n\n");

		// MODELO-3
		txt_area_reportes.append("Modelo                        : " + modelo3 + "\n");
		if (unidVendidas3 < cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas3 + "("
					+ (cantOptima - unidVendidas3) + " menor a la  cantidad óptima)" + "\n\n");
		else if (unidVendidas3 > cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas3 + "("
					+ (unidVendidas3 - cantOptima) + " mayor que la cantidad óptima)" + "\n\n");
		else
			txt_area_reportes.append(
					"Cantidad de unidades vendidas : " + unidVendidas3 + "(igual a la cantidad óptima)" + "\n\n");

		// MODELO-4
		txt_area_reportes.append("Modelo                        : " + modelo4 + "\n");
		if (unidVendidas4 < cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas4 + "("
					+ (cantOptima - unidVendidas4) + " menor a la  cantidad óptima)" + "\n\n");
		else if (unidVendidas4 > cantOptima)
			txt_area_reportes.append("Cantidad de unidades vendidas : " + unidVendidas4 + "("
					+ (unidVendidas4 - cantOptima) + " mayor que la cantidad óptima)" + "\n\n");
		else
			txt_area_reportes.append(
					"Cantidad de unidades vendidas : " + unidVendidas4 + "(igual a la cantidad óptima)" + "\n\n");
	}

	// METODO REPORTE EN RELACION AL PRECIO PROMEDIO
	void reportePrecioPromedio() {
		// TITULO
		txt_area_reportes.setText("PRECIO EN RELACIÓN AL PRECIO PROMEDIO" + "\n\n");

		// MODELO-0
		txt_area_reportes.append("Modelo : " + modelo0 + "\n");
		if (precio0 < precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio0 + "(Menor al Promedio)\n\n");
		else if (precio0 > precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio0 + "(Mayor al Promedio)\n\n");
		else
			txt_area_reportes.append("Precio : S/. " + precio0 + "(Igual al Promedio)\n\n");

		// MODELO-1
		txt_area_reportes.append("Modelo : " + modelo1 + "\n");
		if (precio1 < precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio1 + "(Menor al Promedio)\n\n");
		else if (precio1 > precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio1 + "(Mayor al Promedio)\n\n");
		else
			txt_area_reportes.append("Precio : S/. " + precio1 + "(Igual al Promedio)\n\n");

		// MODELO-2
		txt_area_reportes.append("Modelo : " + modelo2 + "\n");
		if (precio2 < precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio2 + "(Menor al Promedio)\n\n");
		else if (precio2 > precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio2 + "(Mayor al Promedio)\n\n");
		else
			txt_area_reportes.append("Precio : S/. " + precio2 + "(Igual al Promedio)\n\n");

		// MODELO-3
		txt_area_reportes.append("Modelo : " + modelo3 + "\n");
		if (precio3 < precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio3 + "(Menor al Promedio)\n\n");
		else if (precio3 > precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio3 + "(Mayor al Promedio)\n\n");
		else
			txt_area_reportes.append("Precio : S/. " + precio3 + "(Igual al Promedio)\n\n");

		// MODELO-4
		txt_area_reportes.append("Modelo : " + modelo4 + "\n");
		if (precio4 < precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio4 + "(Menor al Promedio)\n\n");
		else if (precio4 > precioPromedio)
			txt_area_reportes.append("Precio : S/. " + precio4 + "(Mayor al Promedio)\n\n");
		else
			txt_area_reportes.append("Precio : S/. " + precio4 + "(Igual al Promedio)\n\n");
	}

	// METODO REPORTE PROMEDIOS, MENORES Y MAYORES
	void reportePromedioMenoresMayores() {

		// REDONDEO A 2 DECIMALES MÉTODO DECIMAL FORMAT
		DecimalFormat formato1 = new DecimalFormat("0.00");

		// TITULO
		txt_area_reportes.setText("PROMEDIOS, MENORES Y MAYORES" + "\n\n");

		txt_area_reportes.append("Precio Promedio : S/. " + formato1.format(precioPromedio) + "\n");

		// OBTENER Y MOSTRAR PRECIO MENOR
		if (precio0 <= precio1 && precio0 <= precio2 && precio0 <= precio3 && precio0 <= precio4)
			txt_area_reportes.append("Precio menor    : S/. " + precio0 + "\n");
		else if (precio1 <= precio0 && precio1 <= precio2 && precio1 <= precio3 && precio1 <= precio4)
			txt_area_reportes.append("Precio menor    : S/. " + precio1 + "\n");
		else if (precio2 <= precio0 && precio2 <= precio1 && precio2 <= precio3 && precio2 <= precio4)
			txt_area_reportes.append("Precio menor    : S/. " + precio2 + "\n");
		else if (precio3 <= precio0 && precio3 <= precio2 && precio3 <= precio1 && precio3 <= precio4)
			txt_area_reportes.append("Precio menor    : S/. " + precio3 + "\n");
		else
			txt_area_reportes.append("Precio menor    : S/. " + precio4 + "\n");

		// OBTENER Y MOSTRAR PRECIO MAYOR
		if (precio0 >= precio1 && precio0 >= precio2 && precio0 >= precio3 && precio0 >= precio4)
			txt_area_reportes.append("Precio mayor    : S/. " + precio0 + "\n\n");
		else if (precio1 >= precio0 && precio1 >= precio2 && precio1 >= precio3 && precio1 >= precio4)
			txt_area_reportes.append("Precio mayor    : S/. " + precio1 + "\n\n");
		else if (precio2 >= precio0 && precio2 >= precio1 && precio2 >= precio3 && precio2 >= precio4)
			txt_area_reportes.append("Precio mayor    : S/. " + precio2 + "\n\n");
		else if (precio3 >= precio0 && precio3 >= precio2 && precio3 >= precio1 && precio3 >= precio4)
			txt_area_reportes.append("Precio mayor    : S/. " + precio3 + "\n\n");
		else
			txt_area_reportes.append("Precio mayor    : S/. " + precio4 + "\n\n");

		// MOSTRAR EL ANCHO PROMEDIO
		txt_area_reportes.append("Ancho promedio  : " + anchoPromedio + " cm\n");

		// OBTENER Y MOSTRAR ANCHO MENOR
		if (ancho0 <= ancho1 && ancho0 <= ancho2 && ancho0 <= ancho3 && ancho0 <= ancho4)
			txt_area_reportes.append("Ancho menor     : " + ancho0 + " cm\n");
		else if (ancho1 <= ancho0 && ancho1 <= ancho2 && ancho1 <= ancho3 && ancho1 <= ancho4)
			txt_area_reportes.append("Ancho menor     : " + ancho1 + " cm\n");
		else if (ancho2 <= ancho0 && ancho2 <= ancho1 && ancho2 <= ancho3 && ancho2 <= ancho4)
			txt_area_reportes.append("Ancho menor     : " + ancho2 + " cm\n");
		else if (ancho3 <= ancho0 && ancho3 <= ancho2 && ancho3 <= ancho1 && ancho3 <= ancho4)
			txt_area_reportes.append("Ancho menor     : " + ancho3 + " cm\n");
		else
			txt_area_reportes.append("Ancho menor     : " + ancho4 + " cm\n");

		// OBTENER Y MOSTRAR ANCHO MAYOR
		if (ancho0 >= ancho1 && ancho0 >= ancho2 && ancho0 >= ancho3 && ancho0 >= ancho4)
			txt_area_reportes.append("Ancho mayor     : " + ancho0 + " cm");
		else if (ancho1 >= ancho0 && ancho1 >= ancho2 && ancho1 >= ancho3 && ancho1 >= ancho4)
			txt_area_reportes.append("Ancho mayor     : " + ancho1 + " cm");
		else if (ancho2 >= ancho0 && ancho2 >= ancho1 && ancho2 >= ancho3 && ancho2 >= ancho4)
			txt_area_reportes.append("Ancho mayor     : " + ancho2 + " cm");
		else if (ancho3 >= ancho0 && ancho3 >= ancho2 && ancho3 >= ancho1 && ancho3 >= ancho4)
			txt_area_reportes.append("Ancho mayor     : " + ancho3 + " cm");
		else
			txt_area_reportes.append("Ancho mayor     : " + ancho4 + " cm");
	}

}
