package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	
	GameManager gm;
	
	
	public  ActionHandler(GameManager gm) {
		this.gm = gm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		//Scene1
		case"LookAtCampfire":gm.ev1.LookAtCampfire();break;
		case"TalkwithCampfire":gm.ev1.TalkwithCampfire();break;
		case"Worseship":gm.ev1.Worseship();break;
		case"LookatFriend":gm.ev1.LookatFriend();break;
		case"TalkwithFriend":gm.ev1.TalkwithFriend();break;
		case"MessupwithFriend":gm.ev1.MessupwithFriend();break;
		case"LookAtChest":gm.ev1.LookAtChest();break;
		case"TalkwithChest":gm.ev1.TalkwithChest();break;
		case"OpenChest":gm.ev1.OpenChest();break;
		
		
		//scene2
		case"lookcave":gm.ev2.lookcave();break;
		case"talkCave":gm.ev2.talkcave();break;
		case"enterCave":gm.ev2.entercave();break;
		case"lookwater":gm.ev2.lookwater();break;
		case"talkwater":gm.ev2.talkwater();break;
		case"searchwater":gm.ev2.searchwater();break;
		
		
		//scene3
		case"LookatMalenia":gm.ev3.LookatMalenia();break;
		case"TalkwithMalenia":gm.ev3.TalkwithMalenia();break;
		case"AttackMalenia":gm.ev3.AttackMalenia();break;
		
		
		
		//Change Screen
		case"goScene1":gm.sChanger.showScreen1();break;
		case"goScene2":gm.sChanger.showScene2();break;
		
		
		//other
		case"restart":gm.sChanger.existGameOverScreen();gm.sChanger.showScreen1();break;
		}
	}

}
