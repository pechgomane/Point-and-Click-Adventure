package Event;

import Main.GameManager;

public class Event01 {
	GameManager gm;
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
	}
	public void LookAtCampfire() {
		gm.ui.messageText.setText("This is your safe zone.");
	}
	public void TalkwithCampfire() {
		gm.ui.messageText.setText("Who are you Talking to ? \n(Seriously ? bro)");
	}
	public void Worseship() {
		
		if(gm.player.playerLife != gm.player.playerMaxLife) {
			gm.ui.messageText.setText("You rest at the Campfire.\n(Your life has recovered)");
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
		}
		else {
			gm.ui.messageText.setText("Your life is full my Tarnished.");
		}
		
	}
	public void LookatFriend() {
		gm.ui.messageText.setText("Stranger standing in front of you.\n(He want to solo something ?)");
	}
	public void TalkwithFriend() {
		gm.ui.messageText.setText("Stranger : Don't go any further without weapon!\nYou choose check the chest over there!");
	}
	public void MessupwithFriend() {
		
		if(gm.player.hasShield==0) {
			if(gm.player.hasSword==0) {
				
				if(gm.player.playerLife!=1) {
					gm.ui.messageText.setText("Stranger : Don't mess up with me man!\n(Your friend hit you back and your life decreases by 1)");
					gm.player.playerLife--;
					gm.player.updatePlayerStatus();
				}
				else if(gm.player.playerLife==1) {
					gm.ui.messageText.setText("Stranger : YOU MUST DIE FOOL!!!!");
					gm.player.playerLife--;
					gm.sChanger.showGameOverScreen(1);
				}
			}
			else if(gm.player.hasSword==1) {
				gm.ui.messageText.setText("Stranger : Oh So you want to fight?\nYou : I can't beat you from far away.\nYour friend : Oh, then approach as you must.\n(You have defeat Stranger (You get Reward Gladiator))  ");
				gm.player.hasShield=1;
				gm.player.hasRing=1;
					}
			gm.player.updatePlayerStatus();
		}
		else {
			gm.ui.messageText.setText("Stranger : Leave me alone please.");
		}
		
	}
	public void LookAtChest() {
		gm.ui.messageText.setText("Why the chest is over here?\n(You should be careful)");
	}
	public void TalkwithChest() {
		gm.ui.messageText.setText("You talk with the chest but it say get out of my mouth!!\n(Don't put it in with your dirty hand!! )");
	}
	public void OpenChest() {
		if(gm.player.hasSword==0) {
			gm.ui.messageText.setText("You opend the chest and find the sword");
			gm.player.hasSword=1;
			gm.player.updatePlayerStatus();
		}
		else {
			gm.ui.messageText.setText("There's nothing inside");
		}
		
	}
}
