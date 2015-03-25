package vue.commande;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
 * Description : Vue {@link ListAssiettesCommandes}
 */
public class ListAssiettesCommandes extends JFrame {

	private JPanel contentPane;
	public JTable tableAssComm;
	public DefaultTableModel dtmList;
	public JScrollPane scrollPaneAssComm;
	public JButton btnAssCommCancelar;
	public JPopupMenu popupMenuAssComm;
	private JLabel lblAssietesComandes;
	Object [][] llen;
	int contador=0;
	String detalle;
	float precio=0f, total=0f;
	private JLabel lblSeleccionaUnaFila;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	public JMenuItem mntmModificarASCom;

	/**
	 * Create the frame.
	 */
	public ListAssiettesCommandes() {
		setTitle("Assiettes command\u00E9es");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListAssiettesCommandes.class.getResource("../../images/steak-32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPaneAssComm = new JScrollPane();
		scrollPaneAssComm.setBounds(10, 76, 644, 128);
		contentPane.add(scrollPaneAssComm);
		String[] columnNames = {"No. commande","No. personne","No. Ligne","Assiette"};
		dtmList= new DefaultTableModel(null, columnNames); // se crea un nuevo modelo de para la tabla
		tableAssComm = new JTable(dtmList);
		tableAssComm.setBounds(34, 11, 374, 101);
		//contentPane.add(tablebs);
		scrollPaneAssComm.setViewportView(tableAssComm);
		
		popupMenuAssComm = new JPopupMenu();
		addPopup(tableAssComm, popupMenuAssComm);
		
		mntmModificarASCom = new JMenuItem("Modifier");
//		mntmModificar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				modificar();// para editar los platillos
//			}
//		});
		popupMenuAssComm.add(mntmModificarASCom);
		
		btnAssCommCancelar = new JButton("Fermer");
		btnAssCommCancelar.setBackground(new Color(255, 192, 203));
		btnAssCommCancelar.setForeground(new Color(0, 0, 0));
		btnAssCommCancelar.setBounds(289, 215, 96, 36);
		contentPane.add(btnAssCommCancelar);
		
		lblAssietesComandes = new JLabel("ASSIETTES COMMAND\u00C9ES");
		lblAssietesComandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssietesComandes.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblAssietesComandes.setBounds(10, 11, 644, 22);
		contentPane.add(lblAssietesComandes);
		
		lblSeleccionaUnaFila = new JLabel("Il choisit une file et donne click droit pour MODIFIER la ligne d'ordre");
		lblSeleccionaUnaFila.setForeground(new Color(0, 0, 0));
		lblSeleccionaUnaFila.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblSeleccionaUnaFila.setBounds(10, 61, 474, 14);
		contentPane.add(lblSeleccionaUnaFila);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ListAssiettesCommandes.class.getResource("../../images/BARRA.jpg")));
		label.setBounds(0, 277, 315, 49);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ListAssiettesCommandes.class.getResource("../../images/BARRA.jpg")));
		label_1.setBounds(314, 277, 315, 49);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ListAssiettesCommandes.class.getResource("../../images/BARRA.jpg")));
		label_2.setBounds(625, 277, 41, 49);
		contentPane.add(label_2);
	}
	
//	/** Metodo que se usa para llenar la tabla */
//	public void llenarTabla(Object [][] obj, int cont){
//		contador=cont;
//		llen=obj;
//		Object a = null, b = null, c = null, d = null, e = null;
//		for(int fila=0; fila<contador; fila++){
//			for(int columna=0; columna<5; columna++){
//				if(columna==0){// no mesa
//					a=llen [fila][columna];
//				}else if(columna==1){// no comensal
//					b=llen [fila][columna];
//				}else if(columna==2){// no linea
//					c=llen [fila][columna];
//				}else if(columna==3){// id platillo
//					try {
//						plat=Hacienda.NomPlat(Integer.parseInt(llen [fila][columna].toString()));
//						while(plat.next()){
//							d=plat.getString(1);
//						}
//					} catch (SQLException e1) {
//						JOptionPane.showMessageDialog(null, e1+" AlimOrd");
//					}
//				}else if(columna==4){// notas
//					//System.out.println("Impresion de alim ord notas: "+llen [fila][columna]);
//					e=llen [fila][columna];
//				}
//				
//			}
//			Object[] aux={a, b, c , d, e};// se agregan la filas
//			dtm.addRow(aux);
//		}
//		
//	}
	
	/**Eventos del menu PopUp*/
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
	
//	/** Metodo que envia los datos para ser modificados */
//	public void modificar(){
//		int fila=tablebs.getSelectedRow();
//		if(fila>=0){
//			//System.out.println("se envia el id plat: "+tablebs.getValueAt(fila, 3));
//			ModificaLinea mdlin=new ModificaLinea();
//			mdlin.setVisible(true);
//			int idplat=0;
//			try {
//				plat=Hacienda.IdPlat(tablebs.getValueAt(fila, 3).toString());
//				while(plat.next()){
//					idplat=plat.getInt(1);
//				}
//			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(null, e+" Error al sacar el ID tabla");
//			}
//			
//			mdlin.recibe(tablebs.getValueAt(fila, 0).toString(), tablebs.getValueAt(fila, 1).toString(), 
//						 tablebs.getValueAt(fila, 2).toString(), Integer.toString(idplat), 
//					     tablebs.getValueAt(fila, 4).toString(), fila, llen, contador);
//			setVisible(false);
//		}else{
//			JOptionPane.showMessageDialog(null,"No selecciono alguna fila");
//		}
//	}
	
//	/** Metodo que rellenara la ventana de Nueva Orden */
//	public void nuevaord(int orden){
//		try{
//			NuevaOrden no=new NuevaOrden();
//			plat=Hacienda.Orden(orden);
//			while(plat.next()){
//				no.txtOrden.setText(Integer.toString(plat.getInt(1)));
//				no.txtmesa.setText(Integer.toString(plat.getInt(2)));
//				no.txtcomensal.setText(Integer.toString(plat.getInt(3)));
//				no.txtempleado.setText(Integer.toString(plat.getInt(4)));
//				no.lblEnProceso.setText(plat.getString(5));
//			}
//			no.setVisible(true);
//			setVisible(false);
//		}catch(SQLException sql){
//			JOptionPane.showMessageDialog(null,"Error al rellenar nueva orden");
//		}
//	}
}