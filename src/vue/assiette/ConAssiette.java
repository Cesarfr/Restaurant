package vue.assiette;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue ConAssiette
 */
public class ConAssiette extends JFrame {

	private JPanel contentPane;
	public DefaultTableModel dTblMdl;
	public JScrollPane scrollPaneCAss;
	public JButton btnCAssSortir;
	public JComboBox<String> cmbCAssTipo;
	public JComboBox<String> cmbCAssNom;
	public JButton btnCAssSearch;
	private JLabel lblBase1;
	private JLabel lblBase2;
	private JLabel lblBase3;
	public JTable tblCAssAssiettes;
	private JLabel lblELI;


	/**
	 * Create the frame.
	 */
	public ConAssiette() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConAssiette.class.getResource("../../images/Food_Icon_32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 354);
		setTitle("Consulter assiettes");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCAssSortir = new JButton("Sortir");
		btnCAssSortir.setBackground(new Color(255, 192, 203));
		btnCAssSortir.setForeground(new Color(0, 0, 0));
		btnCAssSortir.setBounds(317, 220, 89, 31);
		contentPane.add(btnCAssSortir);
		
		cmbCAssTipo = new JComboBox<String>();
		cmbCAssTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"S\u00E9lectionnez un type", "Salade", "Entree", "Dessert"}));
		cmbCAssTipo.setBounds(61, 85, 140, 23);
		contentPane.add(cmbCAssTipo);
		
		cmbCAssNom = new JComboBox<String>();
		cmbCAssNom.setEnabled(false);
		cmbCAssNom.setBounds(265, 86, 202, 20);
		contentPane.add(cmbCAssNom);
		
		btnCAssSearch = new JButton("Chercher");
		btnCAssSearch.setBackground(new Color(143, 188, 143));
		btnCAssSearch.setBounds(531, 78, 89, 37);
		contentPane.add(btnCAssSearch);
		
		lblELI = new JLabel("CONSULTER ASSEITTES");
		lblELI.setHorizontalAlignment(SwingConstants.CENTER);
		lblELI.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblELI.setBounds(218, 34, 266, 14);
		contentPane.add(lblELI);
		
		scrollPaneCAss = new JScrollPane();
		scrollPaneCAss.setBounds(22, 134, 660, 57);
		contentPane.add(scrollPaneCAss);
		
		String[] columnNames = {"ID Assiette","Description","Prix","Ingredients","Type"};
		dTblMdl= new DefaultTableModel(null, columnNames);
		tblCAssAssiettes = new JTable(dTblMdl);
		tblCAssAssiettes.setBounds(32, 220, 647, 90);
		scrollPaneCAss.setViewportView(tblCAssAssiettes);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(ConAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 278, 322, 24);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(ConAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(310, 278, 322, 24);
		contentPane.add(lblBase2);
		
		lblBase3 = new JLabel("");
		lblBase3.setIcon(new ImageIcon(ConAssiette.class.getResource("../../images/BARRA.jpg")));
		lblBase3.setBounds(620, 278, 95, 24);
		contentPane.add(lblBase3);
	
	}
}
