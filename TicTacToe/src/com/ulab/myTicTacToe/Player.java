package com.ulab.myTicTacToe;

import java.util.ArrayList;
import java.util.List;

/*Player class holds the player moves and details*/
public class Player {
	String name;
	String path;
	List<String> list = new ArrayList<String>();

	public Player(String name) {
		setName(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPath(String pos) {
		path = "";
		list.add(pos);
		//Collections.sort(list);
		for (String ele : list)
			this.path += ele;
	}

	public String getPath() {
		//System.out.println(getName()+"      "+path);
		return path;
	}
}