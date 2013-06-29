package com.ulab.myTicTacToe;

import javax.swing.JButton;

/*MyButton class adds location facility for button.*/
public class MyButton extends JButton {

	private static final long serialVersionUID = 1L;
	Integer loc;

	public void setLoc(Integer loc) {
		this.loc = loc;
	}

	public Integer getLoc() {
		return loc;
	}
}
