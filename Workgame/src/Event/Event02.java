package Event;

import Main.GameManager;
public class Event02 {

	public GameManager gm;
	
	public Event02(GameManager gm) {
		this.gm = gm;
	}
	public void lookcave() {
		gm.ui.messageText.setText("What the hell is that !?");
	}
	public void talkcave() {
		gm.ui.messageText.setText("who you talk too.\n(Again man?)");
	}
	public void entercave() {
		if(gm.player.hasLantern==0) {
			gm.ui.messageText.setText("I'm scared man!\n(You have to find some equipment.)");
		}
		else {
			gm.sChanger.showScene3();
		}
	}
	public void lookwater() {
		gm.ui.messageText.setText("Something's under water.");
	}
	public void talkwater() {
		gm.ui.messageText.setText("Water : Beware about yellow gate\nYou : Bruh!,I don't trust you dirty water.\nWater : Be careful how you speak to me young man. I've lived ten of your lifetimes.");
	}
	public void searchwater() {
		if(gm.player.hasLantern==0) {
			gm.ui.messageText.setText("You found holy torch.");
			gm.player.hasLantern=1;
			gm.player.updatePlayerStatus();
		}
		else {
			gm.ui.messageText.setText("You didn't find anything.");
		}
	}
	
}
