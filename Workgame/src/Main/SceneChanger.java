package Main;

public class SceneChanger {

	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		this.gm = gm;
	}
	public void showScreen1() {
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.messageText.setText("Let's be the Lord Elden man!!");
	}
	public void showScene2() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.messageText.setText("Oh Lord here we go again!");
	}
	public void showScene3() {
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.messageText.setText("I am Melania , Blade of Miquella\nAnd I never known defeat.");
	}
	public void showGameOverScreen(int currentBgNum) {
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("YOU DIED");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to restart");	
	}
	public void showGameOvergood(int currentBgNum) {
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.bestLabel.setVisible(true);
		gm.ui.bestLabel.setText("YOU GOOD");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to restart");	
	}
	
	
	
	public void existGameOverScreen() {
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.player.setPlayerDefautstatus();
		
	}
}
