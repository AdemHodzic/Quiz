package events;

import com.adem.Controller.Controller;

public class PlayGameCommand implements Command{

	private Controller controller = new Controller();
	private final int GAME_POSITION = 2; 
	
	public PlayGameCommand() {}
	
	@Override
	public void execute() {
		controller.start(GAME_POSITION);
	}

}
