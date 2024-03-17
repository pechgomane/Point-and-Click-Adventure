package Main;

public class Player {
	
	GameManager gm;

	public int playerMaxLife;
	
	public int playerLife;
	
	public int hasSword;
	public int hasShield;
	public int hasRing;
	public int hasLantern;
	
	
	public Player(GameManager gm) {
		this.gm = gm;
	}
	//status equipment bar
	public void setPlayerDefautstatus() {
		playerMaxLife = 5;
		playerLife = 3;
		hasSword = 0;
		hasRing = 0;
		hasShield = 0;
		hasLantern = 0;
		
		updatePlayerStatus();
			
		
	}
	public void updatePlayerStatus() {
		//remove all life icon
		int i =1;
			while(i<6) {
				gm.ui.lifeLabel[i].setVisible(false);
				i++;
			}
			int lifeCount = playerLife;
			while(lifeCount!=0) {
				gm.ui.lifeLabel[lifeCount].setVisible(true);
				lifeCount--;
			}
		//check player item
		if(hasSword == 0){
			gm.ui.swordLabel.setVisible(false);
		}
		if(hasSword == 1){
			gm.ui.swordLabel.setVisible(true);
		}
		if(hasShield == 0){
			gm.ui.shieldLabel.setVisible(false);
		}
		if(hasShield == 1){
			gm.ui.shieldLabel.setVisible(true);
		}
		if(hasRing == 0){
			gm.ui.ringLabel.setVisible(false);
		}
		if(hasRing == 1){
			gm.ui.ringLabel.setVisible(true);
		}
		if(hasLantern == 0){
			gm.ui.lanternLabel.setVisible(false);
		}
		if(hasLantern == 1){
			gm.ui.lanternLabel.setVisible(true);
		}
	}
}
