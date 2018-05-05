package events;

import com.adem.Controller.Controller;

public class LogOutCommand implements Command{
	
	private Controller controller = new Controller();
	private final int LOGIN_POSITION = 0;
	
	public LogOutCommand() {}

	@Override
	public void execute() {
		controller.start(LOGIN_POSITION);
	}
	
	
	
}
