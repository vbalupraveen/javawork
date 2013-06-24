package com.ulab.strutss.service;

public class GameActionService {
	public String getResult(String team){
		if(team.equals("ravens"))
		return "Baltimore Won";
		else
			return "Lost Super Bowl";
	}
}
