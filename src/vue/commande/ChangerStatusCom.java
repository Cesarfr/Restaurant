package vue.commande;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Vue {@link ChangerStatusCom}
 */
public class ChangerStatusCom extends JFrame {

	private JPanel contentPane;
	public JTable tablaOrdenesChSt;
	public JButton btnChStSortir;
	private JLabel lblEligeUnaOrden;
	public JScrollPane scrollTablaChSt;
	public JPopupMenu popupMenuChSt;
	public JMenuItem mntmChangerStausAss;
	public DefaultTableModel dtm;
	private JLabel lblSeleccionaUnaFila;
	private JLabel lblBase1;
	private JLabel lblBase2;

	/**
	 * Create the frame.
	 */
	public ChangerStatusCom() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangerStatusCom.class.getResource("../../images/steak-32.png")));
		setTitle("Changer \u00E9tat de la commande");
		setResizable(false);
		setBounds(100, 100, 610, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEligeUnaOrden = new JLabel("CHANGER \u00C9TAT DE LA COMMANDE");
		lblEligeUnaOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeUnaOrden.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblEligeUnaOrden.setBounds(10, 23, 584, 25);
		contentPane.add(lblEligeUnaOrden);
		
		scrollTablaChSt = new JScrollPane();
		scrollTablaChSt.setBounds(21, 83, 561, 246);
		contentPane.add(scrollTablaChSt);
		
		String[] columnNames = {"No. Commande","No. Tableau","No. Personnes","Status", "Date"};
		dtm= new DefaultTableModel(null, columnNames);
		tablaOrdenesChSt = new JTable(dtm);
		tablaOrdenesChSt.setBounds(30, 293, 59, 25);
		//contentPane.add(tablaOrdenes);
		scrollTablaChSt.setViewportView(tablaOrdenesChSt);
		
		popupMenuChSt = new JPopupMenu();
		addPopup(tablaOrdenesChSt, popupMenuChSt);
		
		mntmChangerStausAss = new JMenuItem("Changer status");
		popupMenuChSt.add(mntmChangerStausAss);
		
		btnChStSortir = new JButton("Sortir");
		btnChStSortir.setBackground(new Color(255, 102, 102));
		btnChStSortir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChStSortir.setBounds(240, 340, 108, 38);
		contentPane.add(btnChStSortir);
		
		lblSeleccionaUnaFila = new JLabel("S\u00E9lectionnez une ligne et cliquez \u00E0 droite pour changer le statut de la commande");
		lblSeleccionaUnaFila.setForeground(new Color(0, 0, 0));
		lblSeleccionaUnaFila.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblSeleccionaUnaFila.setBounds(20, 68, 501, 14);
		contentPane.add(lblSeleccionaUnaFila);
		
		lblBase1 = new JLabel("");
		lblBase1.setIcon(new ImageIcon(ChangerStatusCom.class.getResource("../../images/BARRA.jpg")));
		lblBase1.setBounds(0, 389, 315, 46);
		contentPane.add(lblBase1);
		
		lblBase2 = new JLabel("");
		lblBase2.setIcon(new ImageIcon(ChangerStatusCom.class.getResource("../../images/BARRA.jpg")));
		lblBase2.setBounds(314, 389, 315, 46);
		contentPane.add(lblBase2);
	}
	/** M etodo para los popup menu */
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
//	/** Metodo para llenar la tabla con las ordenes */
//	public void llenarTabla(){
//		try{
//			orsipre=Hacienda.OrdenesSinPreparar();
//			while(orsipre.next()){
//				Object [] aux={orsipre.getInt(1), orsipre.getInt(2), orsipre.getInt(3), orsipre.getString(5),orsipre.getString(6)};
//				dtm.addRow(aux);
//			}
//		}catch(SQLException sql){
//			JOptionPane.showMessageDialog(null, "Error: "+sql.getMessage());
//		}
//	}
//	/** Metodo para modificar las ordenes y cambiarlas de estado */
//	public void modificar(){
//		int fila=tablaOrdenes.getSelectedRow();
//		if(fila>=0){
//			NuevoEstadoOrden neo=new NuevoEstadoOrden();
//			neo.estadoactual(tablaOrdenes.getValueAt(fila, 3).toString(), Integer.parseInt(tablaOrdenes.getValueAt(fila, 0).toString()));
//			neo.setLocationRelativeTo(null);
//			neo.setVisible(true);
//			setVisible(false);
//		}else{
//			JOptionPane.showMessageDialog(null,"No selecciono alguna fila");
//		}
//	}
	
}
