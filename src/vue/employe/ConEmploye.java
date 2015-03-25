package vue.employe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue pour cosulter une employe
 */
public class ConEmploye extends JFrame {

	private JPanel contentPane;
	public JScrollPane scrollPane;
	public JTable tblemp;
	public DefaultTableModel dTblMdl;
	private JLabel lblemp;
	public JButton btnConEmpSortir;
	public JComboBox<String> cmbConEmpPuesto;
	private JLabel lblSeleccioneTipoDe;
	public JRadioButton rdbtnConEmpTous;
	public JRadioButton rdbtnConEmpPue;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblBase3;
	private JLabel lblBase4;
	private JLabel lblBase5;

	/**
	 * Create the frame.
	 */
	public ConEmploye() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConEmploye.class.getResource("../../images/FormatFactoryempleado.png")));
		setTitle("Consulter Employ\u00E9s");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 9));
		scrollPane.setBounds(10, 141, 1268, 122);
		contentPane.add(scrollPane);

		String[] columnNames = { "No. Employ\u00E9", "NOM", "Prenom", "Date de Naissance", "Sexe", "Rue",
				"Número", "Ville", "Pays", "Telephone", "Emploi"};
		dTblMdl = new DefaultTableModel(null, columnNames);
		tblemp = new JTable(dTblMdl);
		tblemp.setRowSelectionAllowed(false);
		tblemp.setCellEditor(null);
		scrollPane.setViewportView(tblemp);

		lblemp = new JLabel("CONSULTER EMPLOY\u00C9S");
		lblemp.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblemp.setBounds(486, 23, 337, 20);
		contentPane.add(lblemp);

		btnConEmpSortir = new JButton("Sortir");
		btnConEmpSortir.setBackground(new Color(255, 192, 203));
		btnConEmpSortir.setBounds(542, 283, 128, 39);
		contentPane.add(btnConEmpSortir);

		cmbConEmpPuesto = new JComboBox<String>();
		cmbConEmpPuesto.setEnabled(false);
		cmbConEmpPuesto.setToolTipText("Puesto");
		cmbConEmpPuesto.setModel(new DefaultComboBoxModel<String>(new String[] { "Emploi","Caissier", "Cuisinier", "Serveur", "Manager" }));
		cmbConEmpPuesto.setBounds(334, 92, 151, 20);
		contentPane.add(cmbConEmpPuesto);

		lblSeleccioneTipoDe = new JLabel("S\u00E9lectionnez un type de recherche");
		lblSeleccioneTipoDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccioneTipoDe.setBounds(25, 44, 259, 14);
		contentPane.add(lblSeleccioneTipoDe);

		rdbtnConEmpTous = new JRadioButton("Tous les registres");
		rdbtnConEmpTous.setBackground(new Color(238, 232, 170));
		rdbtnConEmpTous.setBounds(25, 91, 178, 23);
		contentPane.add(rdbtnConEmpTous);

		rdbtnConEmpPue = new JRadioButton("Par Emploi");
		rdbtnConEmpPue.setBackground(new Color(238, 232, 170));
		rdbtnConEmpPue.setBounds(204, 93, 109, 23);
		contentPane.add(rdbtnConEmpPue);

		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(ConEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 354, 315, 24);
		contentPane.add(lblBase1);

		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(ConEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(310, 354, 315, 24);
		contentPane.add(lblBase2);

		lblBase3 = new JLabel("");
		lblBase3.setIcon(new ImageIcon(ConEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase3.setBounds(622, 354, 315, 24);
		contentPane.add(lblBase3);

		lblBase4 = new JLabel("");
		lblBase4.setIcon(new ImageIcon(ConEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase4.setBounds(935, 354, 315, 24);
		contentPane.add(lblBase4);

		lblBase5 = new JLabel("");
		lblBase5.setIcon(new ImageIcon(ConEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase5.setBounds(1249, 354, 49, 24);
		contentPane.add(lblBase5);

	}

//	public void consultaPuesto() {
//
//		ResultSet dato1 = Hacienda.Consultar();
//		String puesto = cmbPuesto.getSelectedItem().toString();
//		// System.out.println(""+i);
//
//		try {
//			while (dTblMdl.getRowCount() > 0)
//				dTblMdl.removeRow(0);
//			Connection con = Conectar.obtenerConexion();
//			String sent = "select * from empleado where puesto='" + puesto
//					+ "'";
//			Statement s = con.createStatement();
//			ResultSet dato = s.executeQuery(sent);
//			System.out.println(dato);
//
//			if (dato.next()) {
//				Object[] aux = { dato.getInt(1), dato.getString(2),
//						dato.getString(3), dato.getString(4),
//						dato.getString(5), dato.getString(6),
//						dato.getString(7), dato.getInt(8), dato.getString(9),
//						dato.getString(10), dato.getInt(11),
//						dato.getString(12), dato.getString(13) };
//				dTblMdl.addRow(aux);
//			} else {
//				if (cmbPuesto.getSelectedItem().equals("Puesto")) {
//					JOptionPane.showMessageDialog(null, "Selecciona un puesto");
//				} else {
//					JOptionPane.showMessageDialog(null,
//							"No hay registros para ese puesto");
//				}
//			}
//
//		} catch (SQLException e) {
//			System.out.println("Error " + e);
//		}
//	}

//	public static void mostrar() {
//		try {
//			while (dTblMdl.getRowCount() > 0)
//				dTblMdl.removeRow(0);
//			// dTblMdl.removeRow(0);
//			java.sql.ResultSet dato = Hacienda.Consultar();
//			while (dato.next()) {
//				Object[] aux = { dato.getInt(1), dato.getString(2),
//						dato.getString(3), dato.getString(4),
//						dato.getString(5), dato.getString(6),
//						dato.getString(7), dato.getInt(8), dato.getString(9),
//						dato.getString(10), dato.getInt(11),
//						dato.getString(12), dato.getString(13) };
//				dTblMdl.addRow(aux);
//			}
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "ERROR");
//		}
//
//	}

}
