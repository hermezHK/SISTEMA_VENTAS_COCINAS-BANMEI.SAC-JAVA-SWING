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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author <a href="Nyxseals:angelo_stk06@hotmail.com">Hermez Jaramillo</a>
 * @project SistemasVentasCocinas
 * @class ListarCocinas
 * @description
 * @HU_CU_REQ
 * @date 5 jun. 2024
 */
public class ListarCocinas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btn_cerrar;
	private JButton btn_listar;
	private JTextArea textArea;

	/**
	 * Create the dialog.
	 */
	public ListarCocinas() {
		setTitle("Listado de cocinas");
		setBounds(155, 230, 558, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// Titulo
		JLabel lblNewLabel = new JLabel("COCINAS BANMEI S.A.C");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 237, 41);
		contentPanel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 522, 285);
		contentPanel.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(textArea);

		btn_cerrar = new JButton("Cerrar");
		btn_cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonCerrarLista(); // BOTÓN CERRAR DE LA VENTANA LISTAR
			}
		});
		btn_cerrar.setBounds(175, 357, 89, 23);
		contentPanel.add(btn_cerrar);

		btn_listar = new JButton("Listar");
		btn_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarModeloCocina(); // MÉTODO PARA LISTAR MODELOS DE COCINA
			}
		});
		btn_listar.setBounds(283, 357, 89, 23);
		contentPanel.add(btn_listar);
	}

	void listarModeloCocina() {
		// MODELO - Mabe EMP6120PG0
		textArea.append("===================================================\n");
		textArea.append("Modelo          -->    " + MenuPrincipal.m_0 + "\n");
		textArea.append("Precio            -->    " + MenuPrincipal.p_0 + "\n");
		textArea.append("Profundidad  -->    " + MenuPrincipal.prof_0 + "\n");
		textArea.append("Ancho           -->    " + MenuPrincipal.anch_0 + "\n");
		textArea.append("Alto               -->    " + MenuPrincipal.alt_0 + "\n");
		textArea.append("Quemadores  -->    " + MenuPrincipal.qdr_0 + "\n");
		textArea.append("===================================================\n");

		// MODELO - Indurama Parma
		textArea.append("Modelo          -->    " + MenuPrincipal.m_1 + "\n");
		textArea.append("Precio            -->    " + MenuPrincipal.p_1 + "\n");
		textArea.append("Profundidad  -->    " + MenuPrincipal.prof_1 + "\n");
		textArea.append("Ancho           -->    " + MenuPrincipal.anch_1 + "\n");
		textArea.append("Alto               -->    " + MenuPrincipal.alt_1 + "\n");
		textArea.append("Quemadores  -->    " + MenuPrincipal.qdr_1 + "\n");
		textArea.append("===================================================\n");

		// MODELO - Sole COSOL027
		textArea.append("Modelo          -->    " + MenuPrincipal.m_2 + "\n");
		textArea.append("Precio            -->    " + MenuPrincipal.p_2 + "\n");
		textArea.append("Profundidad  -->    " + MenuPrincipal.prof_2 + "\n");
		textArea.append("Ancho           -->    " + MenuPrincipal.anch_2 + "\n");
		textArea.append("Alto               -->    " + MenuPrincipal.alt_2 + "\n");
		textArea.append("Quemadores  -->    " + MenuPrincipal.qdr_2 + "\n");
		textArea.append("===================================================\n");

		// MODELO - Coldex CX602
		textArea.append("Modelo          -->    " + MenuPrincipal.m_3 + "\n");
		textArea.append("Precio            -->    " + MenuPrincipal.p_3 + "\n");
		textArea.append("Profundidad  -->    " + MenuPrincipal.prof_3 + "\n");
		textArea.append("Ancho           -->    " + MenuPrincipal.anch_3 + "\n");
		textArea.append("Alto               -->    " + MenuPrincipal.alt_3 + "\n");
		textArea.append("Quemadores  -->    " + MenuPrincipal.qdr_3 + "\n");
		textArea.append("===================================================\n");

		// MODELO - Reco Dakota
		textArea.append("Modelo          -->    " + MenuPrincipal.m_4 + "\n");
		textArea.append("Precio            -->    " + MenuPrincipal.p_4 + "\n");
		textArea.append("Profundidad  -->    " + MenuPrincipal.prof_4 + "\n");
		textArea.append("Ancho           -->    " + MenuPrincipal.anch_4 + "\n");
		textArea.append("Alto               -->    " + MenuPrincipal.alt_4 + "\n");
		textArea.append("Quemadores  -->    " + MenuPrincipal.qdr_4 + "\n");
		textArea.append("===================================================\n");

	}

	void botonCerrarLista() {
		this.dispose(); // MÉTODO DE HACE REFERENCIA PARA CERRAR LA VENTANA ACTUAL

	}
}
