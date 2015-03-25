package vue.employe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue pour effacer une employe
 */
public class DelEmploye extends JFrame {

	private JPanel contentPane;
	public JScrollPane scrollPane;
	public JTable tblDelEmp;
	public DefaultTableModel dTblMdl;
	private JLabel lblemp;
	public JButton btnDelEmpSortir;
	public JComboBox<String> cmbDelEmpPuesto;
	private JLabel lblSeleccioneTipoDe;
	public JRadioButton rdbtnDelEmpTous;
	public JRadioButton rdbtnDelEmpPuesto;
	public JMenuItem mntmEliminar;
	public JPopupMenu popupMenu;
	private JLabel lblELI;
	private JLabel lblDaClicDerecho;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblBase3;
	private JLabel lblBase4;
	private JLabel lblBase5;

	/**
	 * Create the frame.
	 */
	public DelEmploye() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DelEmploye.class.getResource("../../images/FormatFactoryempleado.png")));
		setResizable(false);
		setTitle("Effacer Employ\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 455);
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
				"Numero", "Ville", "Pays", "Telephone", "Emploi"};
		dTblMdl = new DefaultTableModel(null, columnNames);
		tblDelEmp= new JTable(dTblMdl);
		tblDelEmp.setBounds(0, 22, 33, 22);
		
		popupMenu = new JPopupMenu();
		addPopup(tblDelEmp, popupMenu);
		
		mntmEliminar = new JMenuItem("Effacer");
		popupMenu.add(mntmEliminar);
		scrollPane.setViewportView(tblDelEmp);
		
		lblemp = new JLabel("E  M  P  L  E  A  D  O  S");
		lblemp.setBounds(458, 21, 207, 20);
		
		btnDelEmpSortir = new JButton("Sortir");
		btnDelEmpSortir.setBackground(new Color(255, 192, 203));
		btnDelEmpSortir.setBounds(550, 285, 130, 39);
		contentPane.add(btnDelEmpSortir);
		
		cmbDelEmpPuesto = new JComboBox<String>();
		cmbDelEmpPuesto.setEnabled(false);
		cmbDelEmpPuesto.setToolTipText("Puesto");
		cmbDelEmpPuesto.setModel(new DefaultComboBoxModel<String>(new String[] {"Emploi","Caissier", "Cuisinier", "Serveur", "Manager"}));
		cmbDelEmpPuesto.setBounds(337, 78, 151, 20);
		contentPane.add(cmbDelEmpPuesto);
		
		lblSeleccioneTipoDe = new JLabel("S\u00E9lectionnez un type de recherche");
		lblSeleccioneTipoDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccioneTipoDe.setBounds(23, 56, 257, 14);
		contentPane.add(lblSeleccioneTipoDe);
		
		rdbtnDelEmpTous = new JRadioButton("Tous les registres");
		rdbtnDelEmpTous.setBackground(new Color(238, 232, 170));
		rdbtnDelEmpTous.setBounds(25, 77, 178, 23);
		contentPane.add(rdbtnDelEmpTous);
		
		rdbtnDelEmpPuesto = new JRadioButton("Par Emploi");
		rdbtnDelEmpPuesto.setBackground(new Color(238, 232, 170));
		rdbtnDelEmpPuesto.setBounds(207, 77, 109, 23);
		contentPane.add(rdbtnDelEmpPuesto);
		
		lblELI = new JLabel("E F F A C E R    E M P L O Y \u00C9");
		lblELI.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblELI.setBounds(451, 30, 425, 14);
		contentPane.add(lblELI);
		
		lblDaClicDerecho = new JLabel("Il donne clic droit dans le registre que vous souhaitez \u00E9liminer");
		lblDaClicDerecho.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		lblDaClicDerecho.setBounds(39, 116, 364, 14);
		contentPane.add(lblDaClicDerecho);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(DelEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 355, 315, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(DelEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(316, 355, 315, 24);
		contentPane.add(lblBase2);
		
		lblBase3 = new JLabel("");
		lblBase3.setIcon(new ImageIcon(DelEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase3.setBounds(628, 355, 315, 24);
		contentPane.add(lblBase3);
		
		lblBase4 = new JLabel("");
		lblBase4.setIcon(new ImageIcon(DelEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase4.setBounds(938, 355, 315, 24);
		contentPane.add(lblBase4);
		
		lblBase5 = new JLabel("");
		lblBase5.setIcon(new ImageIcon(DelEmploye.class.getResource("../../images/BARRA.jpg")));
		lblBase5.setBounds(1249, 355, 50, 24);
		contentPane.add(lblBase5);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
