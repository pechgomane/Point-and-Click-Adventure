package Main;

import Event.Event01;
import Event.Event02;
import Event.Event03;

public class GameManager {
	//66160028 Pechgomane Mekdum
	//This project game make for Education 
	//Don't use for business
	ActionHandler aHandler = new ActionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);
	
	public Event01 ev1 = new  Event01(this);
	public Event02 ev2 = new  Event02(this);
	public Event03 ev3 = new  Event03(this);
	
	public static void main(String[] args) {
		
		new GameManager();

	}
	public  GameManager() {

		player.setPlayerDefautstatus();
		sChanger.showScreen1();
	}

}