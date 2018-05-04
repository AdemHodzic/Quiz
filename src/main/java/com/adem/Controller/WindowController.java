package com.adem.Controller;

import com.adem.Windows.AdminMenu;
import com.adem.Windows.Game;
import com.adem.Windows.Leaderboard;
import com.adem.Windows.Login;
import com.adem.Windows.MainMenu;
import com.adem.Windows.MyStats;
import com.adem.Windows.Window;

public class WindowController {

	private final Window[] WINDOWS_ARR = {
		new Login(), new MainMenu(), new Game(), new Leaderboard(), new MyStats(), new AdminMenu()	
	};
	
	public WindowController() {}
	
	public void start() {
		WINDOWS_ARR[0].start();
	}
	
	public void start(int index) {
		WINDOWS_ARR[index].start();
	}
}
