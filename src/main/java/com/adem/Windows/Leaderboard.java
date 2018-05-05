package com.adem.Windows;

import java.util.ArrayList;
import java.util.Collections;

import DAO.UserDaoImpl;
import Entities.User;
import Entities.UserProperties;

public class Leaderboard implements Window{

	private UserDaoImpl database = new UserDaoImpl();
	private ArrayList<User> list = new ArrayList<>();
	
	public Leaderboard() {}
	
	@Override
	public void start() {
		makeList();
		System.out.println("==L E A D E R B O A R D==");
		for(User temp : list) {
			String name = temp.getName();
			System.out.println(name + getCorrectSpaces(name) + temp.getBest());
		}
		System.out.println("=========================");
	}

	private String getCorrectSpaces(String name) {
		String temp = "";
		for(int i = name.length();i<20;i++) {
			temp+=" ";
		}
		return temp;
	}

	private void makeList() {
		ArrayList<UserProperties> temp = database.getAlluser();
		
		Collections.sort(temp);
		Collections.reverse(temp);
		
		for(UserProperties props : temp) {
			list.add(new User(props));
		}
	}
}
