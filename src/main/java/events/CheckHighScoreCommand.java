package events;

import com.adem.Controller.Controller;

public class CheckHighScoreCommand implements Command{

	private Controller controller = new Controller();
	private final int LEADERBOARD_POSITION = 3;
	
	public CheckHighScoreCommand() {}
	
	@Override
	public void execute() {
		controller.start(LEADERBOARD_POSITION);
		
	}

}
