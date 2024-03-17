package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
	
	GameManager gm;
	
	JFrame window;
	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];
	
	
	// Player UI
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	public JLabel swordLabel,shieldLabel,ringLabel,lanternLabel;
	
	//Game over UI
	public JLabel titleLabel;
	public JLabel bestLabel;
	public JButton restartButton;
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		createPlayerField();
		generateScene();
		createGameOverField();
		createGameOverGood();
		window.setVisible(true);
	}
	public void createMainField() {
		//background behind scene
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		//bar text
		messageText = new JTextArea("Example");
		messageText.setBounds(50, 410, 700, 150);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua",Font.PLAIN,26));
		//show text area bar
		window.add(messageText);
			
			
		
	}
	public void createBackground(int bgNum , String bgFilemNane) {
		//background picture
		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350);
		bgPanel[bgNum].setBackground(Color.blue);
		bgPanel[bgNum].setLayout(null);
		bgPanel[bgNum].setVisible(false);
		//show scene
		window.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFilemNane));
		bgLabel[bgNum].setIcon(bgIcon);
		

		
	}
	public void createObject(int bgNum,int objx , int objy , int objWidth , int objHeight ,String objFileName
			 ,String choice1Name ,String choice2Name,String choice3Name,String choice1Command,String choice2Command,String choice3Command) {
		// create pop up bar menu item
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem menuItem [] = new JMenuItem[4];
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1Command);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2Command);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(choice3Command);
		popMenu.add(menuItem[3]);


		
		
		
		
		//create object
		JLabel objectlabel = new JLabel();
		//setBounds x,y,width,height
		//location picture
		
		objectlabel.setBounds(objx, objy, objWidth, objHeight);
		
		//put image camp fire the game
		ImageIcon objectIcon= new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectlabel.setIcon(objectIcon);
//		objectlabel.setOpaque(true);
//		objectlabel.setBackground(Color.GREEN);
		objectlabel.addMouseListener(new MouseListener() {


			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				
				if(SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(objectlabel,e.getX(),e.getY());
				}
				
			}
			public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		
		
		bgPanel[bgNum].add(objectlabel);
		bgPanel[bgNum].add(bgLabel[bgNum]);
		
		
	}
	public void createArrowButton(int bgNum , int x , int y , int width , int height , String arrowFileName, String command) {
		//arrow to next page
		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
		
		JButton arrowButton = new JButton();
		arrowButton.setBounds(x, y, width, height);
		arrowButton.setBackground(null);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setFocusPainted(false);
		arrowButton.setIcon(arrowIcon);
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		arrowButton.setBorderPainted(false);
		//setBorderPainted เอาขอบออก
		bgPanel[bgNum].add(arrowButton);
		
		
	}
	
	
	public void createPlayerField() {
		//bar player
		lifePanel = new JPanel();
		lifePanel.setBounds(50,0,250,50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(1,5));
		window.add(lifePanel);
		
		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		Image image = lifeIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		lifeIcon = new ImageIcon(image);
		
		//blood bar show
		int i=1;
		while(i<6) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;
		}
		//bar inventory
		inventoryPanel = new JPanel();
		//size bar inventory
		inventoryPanel.setBounds(618, 0, 140, 50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,4));
		window.add(inventoryPanel);
		
		// create items
		swordLabel = new JLabel();
		ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("sword.png"));
		image  = swordIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		swordIcon = new ImageIcon(image);
		swordLabel.setIcon(swordIcon);
		inventoryPanel.add(swordLabel);
		
		
		
		shieldLabel = new JLabel();
		ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("shield.png"));
		image  = shieldIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		shieldIcon = new ImageIcon(image);
		shieldLabel.setIcon(shieldIcon);
		inventoryPanel.add(shieldLabel);
		
		ringLabel = new JLabel();
		ImageIcon ringIcon = new ImageIcon(getClass().getClassLoader().getResource("ring.png"));
		image  = ringIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		ringIcon = new ImageIcon(image);
		ringLabel.setIcon(ringIcon);
		inventoryPanel.add(ringLabel);
		
		
		lanternLabel = new JLabel();
		ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("torch.png"));
		image  = lanternIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		lanternIcon = new ImageIcon(image);
		lanternLabel.setIcon(lanternIcon);
		inventoryPanel.add(lanternLabel);
		
	}
	
	public void createGameOverField() {
		titleLabel = new JLabel("",JLabel.CENTER);
		titleLabel.setBounds(200,150,400,200);
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(new Font("Times New Roman",Font.PLAIN,70));
		titleLabel.setVisible(false);
		window.add(titleLabel);
		
		
		restartButton = new JButton();
		restartButton.setBounds(340,320,120,50);
		restartButton.setBorder(null);
		restartButton.setBackground(null);
		restartButton.setForeground(Color.white);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(gm.aHandler);
		restartButton.setActionCommand("restart");
		restartButton.setVisible(false);
		window.add(restartButton);		
	}
	
	public void createGameOverGood() {
		bestLabel = new JLabel("",JLabel.CENTER);
		bestLabel.setBounds(200,150,400,200);
		bestLabel.setForeground(Color.red);
		bestLabel.setFont(new Font("Times New Roman",Font.PLAIN,70));
		bestLabel.setVisible(false);
		window.add(bestLabel);
		
		
		restartButton = new JButton();
		restartButton.setBounds(340,320,120,50);
		restartButton.setBorder(null);
		restartButton.setBackground(null);
		restartButton.setForeground(Color.white);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(gm.aHandler);
		restartButton.setActionCommand("restart");
		restartButton.setVisible(false);
		window.add(restartButton);		
	}
	
	public void generateScene() {
		
		//Scene1
		createBackground(1,"location1.png");
		//location picture
		createObject(1,480, 200, 100, 100,"camp.png","Look","Talk","Rest","LookAtCampfire","TalkwithCampfire","Worseship");
		createObject(1,125, 200, 100, 100,"knight.png","Look","Talk","Attack","LookatFriend","TalkwithFriend","MessupwithFriend");
		createObject(1,280, 250, 60, 30,"chest.png","Look","Talk","Open","LookAtChest","TalkwithChest","OpenChest");
		createArrowButton(1,0,150,65,50,"left.png","goScene2");
		bgPanel[1].add(bgLabel[1]);
		
		//scene2
		createBackground(2,"outsidecave.png");
		createObject(2,360, 100, 135, 130,"blank .png","Look","Talk","Enter","lookcave","talkCave","enterCave");
		createObject(2,330, 280, 30, 30,"blank .png","Look","Talk","Search","lookwater","talkwater","searchwater");
		createArrowButton(2,600,150,65,50,"right.png","goScene1");
		bgPanel[2].add(bgLabel[2]);
		
		
		//scene3
		createBackground(3,"insidecave.png");
		createObject(3,200, 105, 200, 200,"malenia.png","Look","Talk","Attack","LookatMalenia","TalkwithMalenia","AttackMalenia");
		createArrowButton(3,600,150,65,50,"right.png","goScene2");
		
		bgPanel[3].add(bgLabel[3]);
	}
	

}