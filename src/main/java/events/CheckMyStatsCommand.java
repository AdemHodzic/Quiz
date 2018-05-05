package events;

import com.adem.Controller.Controller;

public class CheckMyStatsCommand implements Command{
	
	private Controller controller = new Controller();
	private final int STATS_POSITION = 4;
	
	public CheckMyStatsCommand() {
		
	}

	@Override
	public void execute() {
		this.controller.start(STATS_POSITION);
	}
	
	
	
}
