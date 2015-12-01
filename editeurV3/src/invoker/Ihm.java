/***********************************************************************
 * Module:  Ihm.java
 * Author:  21000155
 * Purpose: Defines the Class Ihm
 ***********************************************************************/
package invoker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import command.*;
import commandV2.*;
import commandV3.*;
import receiver.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Ihm extends JFrame implements Observer, ActionListener, KeyListener, CaretListener {

	//Attribut de la barre de menu
	private JMenuBar menuBar;
	private JMenu menuFichier;
	private JMenuItem quitter;
	private JMenu menuEdition;
	private JMenuItem mCopier;
	private JMenuItem mCouper;
	private JMenuItem mColler;
	private JMenu menuMemento;
	private JMenuItem mDemarrer;
	private JMenuItem mArreter;
	private JMenuItem mRejouer;
	private JMenu menuV3;
	private JMenuItem mDefaire;
	private JMenuItem mRefaire;
	//Attribut de notre barre d'outils
	private JToolBar toolBar = new JToolBar();
	//Attribut contenant les boutons de la barre d'outils
	private JButton btnCopier = new JButton(new ImageIcon("images/copier.jpg"));
	private JButton btnCouper = new JButton(new ImageIcon("images/couper.jpg"));
	private JButton btnColler = new JButton(new ImageIcon("images/coller.jpg"));
	private JTextArea  zoneTxt = new JTextArea(30,50);
	//renvoie dernier caract�re saisie
	private String txt;
	//booleen indiquant si un enregistrement est actif
	private boolean enregistrementActif;
	//Commandes � ex�cuter
	private Coller cmdColler;
	private Copier cmdCopier;
	private Couper cmdCouper;
	private Saisir cmdSaisir;
	private Selectionner cmdSelectionner;
	private SuppressionArriere cmdSuppressionArriere;
	private SuppressionAvant cmdSuppressionAvant;
	private CollerEnregistrableV2 cmdCollerEnregistrableV2;
	private CopierEnregistrableV2 cmdCopierEnregistrableV2;
	private CouperEnregistrableV2 cmdCouperEnregistrableV2;
	private SaisirEnregistrableV2 cmdSaisirEnregistrableV2;
	private SelectionnerEnregistrableV2 cmdSelectionnerEnregistrableV2;
	private SuppressionArriereEnregistrableV2 cmdSuppressionArriereEnregistrableV2;
	private SuppressionAvantEnregistrableV2 cmdSuppressionAvantEnregistrableV2;
	private CollerEnregistrableV3 cmdCollerEnregistrableV3;
	private CouperEnregistrableV3 cmdCouperEnregistrableV3;
	private SaisirEnregistrableV3 cmdSaisirEnregistrableV3;
	private Demarrer cmdDemarrer;
	private Arreter cmdArreter;
	private Rejouer cmdRejouer;
	private Defaire cmdDefaire;
	private Refaire cmdRefaire;

	/**
	 * retourne la zone de texte de l'IHM
	 * @return zoneTxt zone de texte de l'IHM
	 */
	public JTextArea getZoneTxt() {
		return zoneTxt;
	}

	/**
	 * retourne vrai si un enregistrement est en cours, faux sinon
	 * @return enregistrementActif booleen indiquant si un enregistrement est en cours
	 */
	public boolean isEnregistrementActif() {
		return enregistrementActif;
	}

	/**
	 * Affecte la comande Coller � l'IHM (Invoker)
	 * @param cmdColler Commande coller de l'IHM
	 */
	public void setCmdColler(Coller cmdColler) {
		this.cmdColler = cmdColler;
	}

	/**
	 * Affecte la comande Copier � l'IHM (Invoker)
	 * @param cmdCopier Commande copier de l'IHM
	 */
	public void setCmdCopier(Copier cmdCopier) {
		this.cmdCopier = cmdCopier;
	}

	/**
	 * Affecte la comande Couper � l'IHM (Invoker)
	 * @param cmdCouper Commande couper de l'IHM
	 */
	public void setCmdCouper(Couper cmdCouper) {
		this.cmdCouper = cmdCouper;
	}

	/**
	 * Affecte la comande saisir � l'IHM (Invoker)
	 * @param cmdSaisir Commande saisir de l'IHM
	 */
	public void setCmdSaisir(Saisir cmdSaisir) {
		this.cmdSaisir = cmdSaisir;
	}

	/**
	 * Affecte la comande Selectionner � l'IHM (Invoker)
	 * @param cmdSelectionner Commande Selectionner de l'IHM
	 */
	public void setCmdSelectionner(Selectionner cmdSelectionner) {
		this.cmdSelectionner = cmdSelectionner;
	}

	/**
	 * Affecte la comande SuppressionArriere � l'IHM (Invoker)
	 * @param cmdSuppressionArriere Commande SuppressionArriere de l'IHM
	 */
	public void setCmdSuppressionArriere(SuppressionArriere cmdSuppressionArriere) {
		this.cmdSuppressionArriere = cmdSuppressionArriere;
	}

	/**
	 * Affecte la comande SuppressionAvant � l'IHM (Invoker)
	 * @param cmdSuppressionAvant Commande SuppressionAvant de l'IHM
	 */
	public void setCmdSuppressionAvant(SuppressionAvant cmdSuppressionAvant) {
		this.cmdSuppressionAvant = cmdSuppressionAvant;
	}

	/**
	 * Affecte la comande CollerEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdCollerEnregistrable Commande CollerEnregistrable V2 de l'IHM
	 */
	public void setCmdCollerEnregistrableV2(CollerEnregistrableV2 cmdCollerEnregistrableV2) {
		this.cmdCollerEnregistrableV2 = cmdCollerEnregistrableV2;
	}

	/**
	 * Affecte la comande CopierEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdCopierEnregistrable Commande CopierEnregistrable V2 de l'IHM
	 */
	public void setCmdCopierEnregistrableV2(CopierEnregistrableV2 cmdCopierEnregistrableV2) {
		this.cmdCopierEnregistrableV2 = cmdCopierEnregistrableV2;
	}

	/**
	 * Affecte la comande CouperEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdCouperEnregistrable Commande CouperEnregistrable V2 de l'IHM
	 */
	public void setCmdCouperEnregistrableV2(CouperEnregistrableV2 cmdCouperEnregistrableV2) {
		this.cmdCouperEnregistrableV2 = cmdCouperEnregistrableV2;
	}

	/**
	 * Affecte la comande SaisirEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdSaisirEnregistrable Commande SaisirEnregistrable V2 de l'IHM
	 */
	public void setCmdSaisirEnregistrableV2(SaisirEnregistrableV2 cmdSaisirEnregistrableV2) {
		this.cmdSaisirEnregistrableV2 = cmdSaisirEnregistrableV2;
	}

	/**
	 * Affecte la comande SelectionnerEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdSelectionnerEnregistrable Commande SelectionnerEnregistrable V2 de l'IHM
	 */
	public void setCmdSelectionnerEnregistrableV2(SelectionnerEnregistrableV2 cmdSelectionnerEnregistrableV2) {
		this.cmdSelectionnerEnregistrableV2 = cmdSelectionnerEnregistrableV2;
	}

	/**
	 * Affecte la comande SuppressionArriereEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdSuppressionArriereEnregistrable Commande SuppressionArriereEnregistrable V2 de l'IHM
	 */
	public void setCmdSuppressionArriereEnregistrableV2(SuppressionArriereEnregistrableV2 cmdSuppressionArriereEnregistrableV2) {
		this.cmdSuppressionArriereEnregistrableV2 = cmdSuppressionArriereEnregistrableV2;
	}

	/**
	 * Affecte la comande SuppressionAvantEnregistrableV2 � l'IHM (Invoker)
	 * @param cmdSuppressionAvantEnregistrable Commande SuppressionAvantEnregistrable V2 de l'IHM
	 */
	public void setCmdSuppressionAvantEnregistrableV2(SuppressionAvantEnregistrableV2 cmdSuppressionAvantEnregistrableV2) {
		this.cmdSuppressionAvantEnregistrableV2 = cmdSuppressionAvantEnregistrableV2;
	}

	/**
	 * Affecte la comande CollerEnregistrableV3 � l'IHM (Invoker)
	 * @param cmdCollerEnregistrable Commande CollerEnregistrable V3 de l'IHM
	 */
	public void setCmdCollerEnregistrableV3(CollerEnregistrableV3 cmdCollerEnregistrableV3) {
		this.cmdCollerEnregistrableV3 = cmdCollerEnregistrableV3;
	}

	/**
	 * Affecte la comande CouperEnregistrableV3 � l'IHM (Invoker)
	 * @param cmdCouperEnregistrable Commande CouperEnregistrable V3 de l'IHM
	 */
	public void setCmdCouperEnregistrableV3(CouperEnregistrableV3 cmdCouperEnregistrableV3) {
		this.cmdCouperEnregistrableV3 = cmdCouperEnregistrableV3;
	}

	/**
	 * Affecte la comande SaisirEnregistrableV3 � l'IHM (Invoker)
	 * @param cmdSaisirEnregistrable Commande SaisirEnregistrable V3 de l'IHM
	 */
	public void setCmdSaisirEnregistrableV3(SaisirEnregistrableV3 cmdSaisirEnregistrableV3) {
		this.cmdSaisirEnregistrableV3 = cmdSaisirEnregistrableV3;
	}

	/**
	 * Affecte la comande Demarrer � l'IHM (Invoker)
	 * @param cmdDemarrer Commande Demarrer de l'IHM
	 */
	public void setCmdDemarrer(Demarrer cmdDemarrer) {
		this.cmdDemarrer = cmdDemarrer;
	}

	/**
	 * Affecte la comande Arreter � l'IHM (Invoker)
	 * @param cmdArreter Commande Arreter de l'IHM
	 */
	public void setCmdArreter(Arreter cmdArreter) {
		this.cmdArreter = cmdArreter;
	}

	/**
	 * Affecte la comande Rejouer � l'IHM (Invoker)
	 * @param cmdRejouer Commande Rejouer de l'IHM
	 */
	public void setCmdRejouer(Rejouer cmdRejouer) {
		this.cmdRejouer = cmdRejouer;
	}

	/**
	 * Affecte la comande Defaire � l'IHM (Invoker)
	 * @param cmdDefaire Commande Defaire de l'IHM
	 */
	public void setCmdDefaire(Defaire cmdDefaire) {
		this.cmdDefaire = cmdDefaire;
	}

	/**
	 * Affecte la comande Refaire � l'IHM (Invoker)
	 * @param cmdRefaire Commande Refaire de l'IHM
	 */
	public void setCmdRefaire(Refaire cmdRefaire) {
		this.cmdRefaire = cmdRefaire;
	}

	/**
	 * Constructeur
	 */
	public Ihm(){
		this.enregistrementActif=false;
		this.setTitle("Moteur d'�dition V3");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		Font police = new Font("Arial", Font.BOLD, 14);
		zoneTxt.setFont(police);
		zoneTxt.setForeground(Color.BLUE);
		this.initMenu();
		this.initToolBar();
		this.creerTextArea();
		this.setVisible(true); 
	}
	
	/**
	 * Cette m�thode initialise le menu de l'IHM.
	 */
	public void initMenu() {
		this.menuBar = new JMenuBar();
		// Menu Fichier
		this.menuFichier = new JMenu("Fichier");
		this.quitter = new JMenuItem("Quitter");
		this.quitter.addActionListener(this);
		this.menuFichier.add(this.quitter);
		this.menuBar.add(this.menuFichier);
		// Menu Edition
		this.menuEdition = new JMenu("Edition");
		this.menuEdition.addSeparator();
		//Menu copier
		this.mCopier = new JMenuItem("Copier");
		this.mCopier.addActionListener(this);
		this.menuEdition.add(this.mCopier);
		//Menu couper
		this.mCouper = new JMenuItem("Couper");
		this.mCouper.addActionListener(this);
		this.menuEdition.add(this.mCouper);
		//Menu coller
		this.mColler = new JMenuItem("Coller");
		this.mColler.addActionListener(this);
		this.menuEdition.add(this.mColler);
		// Menu Memento
		this.menuMemento = new JMenu("Memento");
		// Menu D�marrerEnregistrement
		this.mDemarrer  = new JMenuItem("D�marrer Enregistrement");
		//Activation menu d�marrer 
		this.mDemarrer.setEnabled(true);
		this.mDemarrer.addActionListener(this);
		this.menuMemento.add(this.mDemarrer);
		// Menu ArreterEnregistrement
		this.mArreter = new JMenuItem("Arr�ter Enregistrement");
		//D�sactivation menu arreter 
		this.mArreter.setEnabled(false);
		this.menuMemento.add(this.mArreter);
		this.mArreter.addActionListener(this);
		this.menuMemento.addSeparator();
		// Menu RejouerEnregistrement
		this.mRejouer = new JMenuItem("Rejouer");
		//Desactivation menu rejouer
		this.mRejouer.setEnabled(false);		
		this.mRejouer.addActionListener(this);
		this.menuMemento.add(this.mRejouer);
		// Menu V3
		this.menuV3= new JMenu("V3");
		// Menu D�faire
		this.mDefaire= new JMenuItem("D�faire");
		this.mDefaire.addActionListener(this);
		this.menuV3.add(this.mDefaire);
		// Menu Refaire
		this.mRefaire= new JMenuItem("Refaire");
		this.mRefaire.addActionListener(this);
		this.menuV3.add(this.mRefaire);
		//Ajout des menus
		this.menuBar.add(this.menuEdition);
		this.menuBar.add(this.menuMemento);
		this.menuBar.add(this.menuV3);
		this.setJMenuBar(this.menuBar);
	}

	/**
	 * Cette m�thode initialise la toolbar de l'IHM. Elle ajoute les boutons : 
	 * - couper
	 * - copier
	 * - coller
	 */
	private void initToolBar(){
		//Ajout des boutons � la barre d'outils
		this.toolBar.add(btnCouper);
		this.toolBar.add(btnCopier);
		this.toolBar.add(btnColler);
		//Affichage du texte au survol des boutons
		btnCouper.setToolTipText("Couper");
		btnCopier.setToolTipText("Copier");
		btnColler.setToolTipText("Coller");
		//On ajoute le listener sur les boutons
		btnCouper.addActionListener(this);
		btnCopier.addActionListener(this);
		btnColler.addActionListener(this);
		this.getContentPane().add(toolBar,BorderLayout.NORTH);    
	}

	/**
	 * Methode qui cree une zone de texte editable dans l'IHM.
	 */
	public void creerTextArea() {
		this.getContentPane().add(zoneTxt,BorderLayout.WEST);
		//On ajoute le listener du clavier pour la zone de texte
		zoneTxt.addKeyListener(this);
		//On ajoute le listener de la s�lection pour la zone de texte
		zoneTxt.addCaretListener(this);
	}

	/**
	 * retourne le d�but de la s�lection de la zone de texte
	 * @return this.zoneTxt.getSelectionStart() position du d�but de la s�lection de la zone texte
	 */
	public int getSelectionDebut(){
		return this.zoneTxt.getSelectionStart();
	}

	/**
	 * retourne la longueur de la s�lection de la zone de texte
	 * @return longueurSelection longueur de la s�lection de la zone texte
	 */
	public int getSelectionLongueur(){
		int longueurSelection=this.zoneTxt.getSelectionEnd()-this.zoneTxt.getSelectionStart();
		return longueurSelection;
	}

	/**
	 * retourne la fin de la s�lection de la zone de texte
	 * @return this.zoneTxt.getSelectionEnd() position de la fin de la s�lection de la zone texte
	 */
	public int getSelectionFin(){
		return this.zoneTxt.getSelectionEnd();
	}
	
	/**
	 * renvoie dernier caract�re saisie
	 * @return this.txt dernier caract�re saisie
	 */
	public String getText(){
		return this.txt;
	}

	/**
	 * permet de stocker le dernier caract�re saisi
	 * @param txt dernier caract�re saisi
	 */
	public void setText(String txt){
		this.txt=txt;
	}

	/**
	 * Listener du clavier
	 * M�thode appel�e lorsqu'une touche du clavier est press�e
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		//Test du type de touche press�
		if(event.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
			// Caractere special (SHIFT, CTRL, ALT) => On ne l'�crit pas dans le buffer
		} else if(event.getKeyCode() == KeyEvent.VK_DELETE) {
			// Traitement pour suppression caract�re suivant
			//Test si l'enregistrement est d�marr�
			if(this.enregistrementActif){
				//Appel de la commande SuppressionAvant enregistrable
				cmdSuppressionAvantEnregistrableV2.execute();
			}else{
				//Appel de la commande SuppressionAvant
				cmdSuppressionAvant.execute();
			}
		} else if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			// Traitement pour suppression caract�re pr�c�dent
			//Test si l'enregistrement est d�marr�
			if(this.enregistrementActif){
				//Appel de la commande SuppressionArriere enregistrable
				cmdSuppressionArriereEnregistrableV2.execute();
			}else{
				//Appel de la commande SuppressionArriere
				cmdSuppressionArriere.execute();
			}
		} else {
			//Appel de saisie
			txt=Character.toString(event.getKeyChar());
			//Test si l'enregistrement est d�marr�
			if(this.enregistrementActif){
				//Appel de la commande Saisir enregistrable
				cmdSaisirEnregistrableV2.execute();
			}else{
				//Appel de la commande Saisir
				cmdSaisirEnregistrableV3.execute();
			}
		}
	}	

	/**
	 * Listener du clavier
	 * M�thode appel�e lorsqu'une touche du clavier est relach�e
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Listener du clavier
	 * M�thode appel�e lorsqu'une touche du clavier est enfonc�e puis relev�e
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Listener du curseur de la zone texte
	 * M�thode appel�e lorsque le curseur de s�lection est modifi�
	 */
	@Override
	public void caretUpdate(CaretEvent e) {
		if(this.enregistrementActif){
			cmdSelectionnerEnregistrableV2.execute();
		}else{
			cmdSelectionner.execute();
		}
	}

	/**
	 * Listener des menus et des boutons
	 * M�thode appel�e lorsqu'on clique sur un bouton ou un �l�ment du menu
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//fonction copier
		if((event.getSource() == this.btnCopier) | (event.getSource() == this.mCopier)) {
			//Test si l'enregistrement est d�marr�
			if(this.enregistrementActif){
				//Appel de la commande copier enregistrable
				System.out.println("Appel de la commande copier enregistrable");
				cmdCopierEnregistrableV2.execute();
			}else{
				//Appel de la commande copier 
				System.out.println("Appel de la commande copier EnregistrableV3");
				cmdCopier.execute();
			}
		//fonction couper
		} else if((event.getSource() == this.btnCouper) | (event.getSource() == this.mCouper)) {
			//Test si l'enregistrement est d�marr�
			if(this.enregistrementActif){
				//Appel de la commande couper enregistrable
				System.out.println("Appel de la commande couper enregistrable");
				cmdCouperEnregistrableV2.execute();
			}else{
				//Appel de la commande couper
				System.out.println("Appel de la commande couper EnregistrableV3");
				cmdCouperEnregistrableV3.execute();
			}
		//fonction coller
		} else if((event.getSource() == this.btnColler) | (event.getSource() == this.mColler)) {
			//Test si l'enregistrement est d�marr�
			if(this.enregistrementActif){
				//Appel de la commande coller enregistrable
				System.out.println("Appel de la commande coller enregistrable");
				cmdCollerEnregistrableV2.execute();
			}else{
				//Appel de la commande coller
				System.out.println("Appel de la commande coller EnregistrableV3");
				cmdCollerEnregistrableV3.execute();
			}
		//fonction d�marrer enregistrement
		} else if((event.getSource() == this.mDemarrer)) {
			//Appel de la commande d�marrer l'enregistrement
			System.out.println("Appel de la commande d�marrer enregistrement");
			//Test si un enregistrement est en cours
			if(this.enregistrementActif){
				//Bo�te du message pr�ventif
				JOptionPane dialogBox = new JOptionPane();
				dialogBox.showMessageDialog(null, "Demarrer enregistrement non autoris�", "Il y a d�j� un enregistrement en cours. ", JOptionPane.WARNING_MESSAGE);
			}else{
				//Desactivation menu d�marrer et rejouer
				this.mDemarrer.setEnabled(false);
				this.mRejouer.setEnabled(false);		
				//Activation menu arreter 
				this.mArreter.setEnabled(true);
				this.enregistrementActif=true;
				cmdDemarrer.execute();
			}
		//fonction arreter enregistrement
		} else if((event.getSource() == this.mArreter)) {
			//Appel de la commande arr�ter l'enregistrement
			System.out.println("Appel de la commande arr�ter enregistrement");
			//Test si un enregistrement est en cours
			if(this.enregistrementActif){
				//Activation menu d�marrer et rejouer
				this.mDemarrer.setEnabled(true);
				this.mRejouer.setEnabled(true);		
				//D�sactivation menu arreter 
				this.mArreter.setEnabled(false);
				this.enregistrementActif=false;
				cmdArreter.execute();
			}else{
				//Bo�te du message pr�ventif
				JOptionPane dialogBox = new JOptionPane();
				dialogBox.showMessageDialog(null, "Arr�t enregistrement non autoris�", "Il n'y a pas d'enregistrement en cours. ", JOptionPane.WARNING_MESSAGE);
			}
		//fonction rejouer enregistrement
		} else if((event.getSource() == this.mRejouer)) {
			//Appel de la commande arr�ter l'enregistrement
			System.out.println("Appel de la commande rejouer enregistrement");
			//Test si un enregistrement est en cours
			if(this.enregistrementActif){
				//Bo�te du message pr�ventif
				JOptionPane dialogBox = new JOptionPane();
				dialogBox.showMessageDialog(null, "Rejouer enregistrement non autoris�", "Il y a un enregistrement en cours. ", JOptionPane.WARNING_MESSAGE);
			}else{
				cmdRejouer.execute();
			}
		//fonction defaire
		} else if((event.getSource() == this.mDefaire)) {
			//Appel de la commande arr�ter l'enregistrement
			System.out.println("Appel de la commande D�faire");
			cmdDefaire.execute();
		//fonction refaire
		} else if((event.getSource() == this.mRefaire)) {
			//Appel de la commande arr�ter l'enregistrement
			System.out.println("Appel de la commande Refaire");
			cmdRefaire.execute();
		//fonction quitter
		}else if(event.getSource() == this.quitter) {
			System.exit(0);
		}else {
			System.out.println("Action listener ne prend pas en compte cette action: \n"+event.getSource());
		}
	}

	/**
	 * M�thode qui met � jour l'Observer (l'IHM) lorsque l'observable (le moteur d'�dition) est modifi�
	 * @param o the observable object.
	 * @param arg an argument passed to the notifyObservers method.
	 */	
	@Override
	public void update(Observable o, Object arg) {
		// Test si l'observable est un moteur d'�dition
		if(o instanceof MoteurEditionImpl){
//			this.moteurEdition=(MoteurEditionImpl) o;
			// On r�cup�re le texte du buffer pour mettre � jour la zone de texte
			String txtBuffer=((MoteurEditionImpl) o).getBuffer().getContenu().toString();
			this.zoneTxt.setText(txtBuffer);
			// Mise � jour la position du curseur
			this.zoneTxt.setCaretPosition(((MoteurEditionImpl) o).getSelection().getDebutSelection());
			this.zoneTxt.moveCaretPosition(((MoteurEditionImpl) o).getSelection().getLongueurSelection());
		}
	}
}