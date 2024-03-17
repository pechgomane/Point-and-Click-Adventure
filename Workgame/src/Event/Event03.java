package Event;

import Main.GameManager;
public class Event03 {

	 GameManager gm;
	
	
	public Event03(GameManager gm) {
		this.gm = gm;
	}
	public void LookatMalenia() {
		gm.ui.messageText.setText("What the pretty woman!!");
	}
	public void TalkwithMalenia() {
		if(gm.player.hasRing==1) {
			gm.ui.messageText.setText("You : Will you marry me? (Show the DARK Moon Ring)\nMelania : Yes , I do.\nMelania : I will be your good wife. ;)");
			gm.sChanger.showGameOvergood(3);
			
		}
		else if (gm.player.hasRing==0) {
			
			if(gm.player.playerLife!=1) {
				gm.ui.messageText.setText("You : Will you marry me? (Show Your Hand)\nMelania : No , You didn't love me , you just want me be your slave.\nYou : Please..");
				gm.player.playerLife--;
			}
			
			else if(gm.player.playerLife==1) {
				gm.ui.messageText.setText("Melania : You don't know me that well. TT");
				gm.player.playerLife--;
				gm.sChanger.showGameOverScreen(3);
			}
		}
		gm.player.updatePlayerStatus();
	}
	public void AttackMalenia() {
		gm.ui.messageText.setText("I don't know you but I want you be my slave.\n(They're fighting)\n Ora Ora Ora Ora Ora Ora*99");
		if(gm.player.playerLife!=1) {
			gm.player.playerLife--;
		}
		else if(gm.player.playerLife==1) {
			gm.ui.messageText.setText("Melania : The world.....!!!!");
			gm.player.playerLife--;
			gm.sChanger.showGameOverScreen(3);
		}
		gm.player.updatePlayerStatus();
	}
	
	
	
}
