package com.ulab.strutss.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.ulab.strutss.service.GameActionService;

public class GameAction {
	String result;
	String team;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String execute() {
		GameActionService gaService = new GameActionService();
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> stackTest = new HashMap<String, Object>();
		stackTest.put("stackTest", "Hello Stack Test Passed");
		System.out.println("Hello this is Game Action class");
		stack.push(stackTest);
		setResult(gaService.getResult(team));
		return "success";
	}
}
