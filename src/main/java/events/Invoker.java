package events;

public class Invoker {
	
	private Command command;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void execute() {
		command.execute();
	}
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
}
