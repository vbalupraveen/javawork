package com.ulab.myTicTacToe.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ulab.myTicTacToe.Player;
import com.ulab.myTicTacToe.TicTacToe;

public class TicTacToeTest {
	static TicTacToe ttt=new TicTacToe();

	@Test
	public void matchPathsTest() {
		assertFalse(ttt.matchPaths("4567", "123",3));
	}
	@Test
	public void winnerTest(){
		Player player=new Player("Balu");
		player.setPath("01234");
		assertTrue(ttt.checkCombo(player));
	}
	@Test
	public void cpuPositionTest() {
		int num=ttt.randomOption("46789");
		System.out.println(num);
		assertTrue(num<9 && num>=0);
	}
	public static void main(String[] args){
		TicTacToeTest test=new TicTacToeTest();
		test.matchPathsTest();
		test.winnerTest();
		test.cpuPositionTest();
		}
}
