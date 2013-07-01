package com.ulab.myTicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe_old extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JMenuItem mntmExit = new JMenuItem("Exit");
	JMenu mnNewGame = new JMenu("Menu");
	JMenuItem mntmPlayerVsPlayer = new JMenuItem("Player Vs. Player");
	JMenuItem mntmPlayerVsCpu = new JMenuItem("Player Vs. Computer");
	JLabel lblWelcomeLabel = new JLabel("Welcome to Tic Tac Toe");
	JMenuBar menuBar = new JMenuBar();

	final String[] winningCombo = { "012", "036", "048", "147", "246", "258",
			"345", "678" };

	boolean won = false;
	private final JPanel welcomePanel = new JPanel();
	JPanel fieldPanel = new JPanel();
	private final JLabel lblWelcomeToTic = new JLabel("Welcome to Tic Toc Toe");
	MyButton[] button = new MyButton[9];
	MyButton myButton = new MyButton();
	Integer play = 0;
	Player playerOne, playerTwo, winner;
	String gamePath = "";
	final int numOfClicks = 9;
	int i = 0;
	String playerLastStep = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe_old() {
		setName("tttFrame");
		setTitle("Tic Toc Toe");
		frame = new JFrame("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(menuBar);
		menuBar.add(mnNewGame);
		mnNewGame.add(mntmPlayerVsPlayer);
		mnNewGame.add(mntmPlayerVsCpu);
		mnNewGame.add(mntmExit);
		mntmExit.addActionListener(this);
		mntmPlayerVsCpu.addActionListener(this);
		mntmPlayerVsPlayer.addActionListener(this);
		getContentPane().add(welcomePanel, BorderLayout.NORTH);
		lblWelcomeToTic.setForeground(Color.GREEN);
		lblWelcomeToTic.setFont(new Font("Century Gothic", Font.BOLD, 20));
		welcomePanel.add(lblWelcomeToTic);
		getContentPane().add(fieldPanel, BorderLayout.CENTER);
		fieldPanel.setLayout(new GridLayout(3, 3, 3, 3));
		/* create button */
		for (int i = 0; i < 9; i++) {
			button[i] = new MyButton();
			button[i].setForeground(Color.DARK_GRAY);
			button[i].addActionListener(this);
			button[i].setName("Button");
			button[i].setLoc(i);
			button[i].setText("");
			fieldPanel.add(button[i]);
		}
		frame.setLocationRelativeTo(null);
		clearAll();
	}

	/* enable frame components with fresh values */
	public void enableAll() {
		Component[] com = fieldPanel.getComponents();
		for (int a = 0; a < com.length; a++) {
			com[a].setVisible(true);
		}
		for (int i = 0; i < button.length; i++) {
			button[i].setEnabled(true);
		}
	}

	/* clear all panel components */
	public void clearAll() {
		Component[] com = fieldPanel.getComponents();
		for (int a = 0; a < com.length; a++) {
			com[a].setVisible(false);
		}
		for (int i = 0; i < button.length; i++) {
			button[i].setText("");
		}
		play = 0;
		i = 0;
		gamePath = "";
		won = false;
		playerLastStep = "";
	}

	/* check whether the path has winning combination */
	public boolean matchPaths(String test, String combo, int reqResults) {
		int result = 0;
		for (int i = 0; i < combo.length(); i++) {
			if (test.contains("" + combo.charAt(i)))
				result++;
		}
		if (result == reqResults)
			return true;
		else
			return false;
	}

	/* check whether the player has winning combination */
	public boolean checkCombo(Player player) {
		if (player.getPath().length() > 2)
			for (int i = 0; i < winningCombo.length; i++) {
				if (matchPaths(player.getPath(), winningCombo[i], 3)) {
					won = true;
					return true;
				}
			}
		return false;
	}

	/* Check for the winner */
	public Player checkWinner(Player pone, Player ptwo) {
		List<Player> players = new ArrayList<>();
		players.add(pone);
		players.add(ptwo);
		for (Player player : players) {
			if (checkCombo(player))
				return player;
		}
		return null;
	}

	/* select random option for CPU step */
	public Integer randomOption(String path) {
		Random rn = new Random();
		Integer num = 0;
		int count = 0;
		while (count < 9) {
			num = rn.nextInt(9);
			if (!path.contains(num.toString())) {
				break;
			}
			count++;
		}
		return num;
	}

	/* get anticipated step location */
	public char getStep(String anticipatedCombo, String pair) {
		for (int i = 0; i < anticipatedCombo.length(); i++) {
			if (!pair.contains(anticipatedCombo.subSequence(i, i + 1)))
				return anticipatedCombo.charAt(i);
		}
		return 'N';
	}

	/* anticipates CPU's next step based one players's step */
	public String anticipateStep(String step, String playerPath, String gamePath) {
		String cpuStep = "";
		String pair = "";
		String anticipatedCombo = "";
		int gamePathLength = gamePath.length();
		boolean found = false;
		StringBuilder path = new StringBuilder(playerPath);
		if (gamePath.length() == 1)
			cpuStep = randomOption(gamePath).toString();
		else {
			while (gamePath.contains(cpuStep) || gamePathLength > 0) {
				cpuStep = "";
				pair = "";
				for (int k = 0; k < path.length() - 1; k++) {
					pair = step + path.charAt(k);
					for (int i = 0; i < winningCombo.length; i++) {
						if (matchPaths(pair, winningCombo[i], 2)) {
							anticipatedCombo = winningCombo[i];
							found = true;
							break;
						}
					}
					if (found)
						break;
				}
				cpuStep += getStep(anticipatedCombo, pair);

				gamePathLength--;
				if (gamePathLength < 0) {
					cpuStep = randomOption(gamePath).toString();
					if (!gamePath.contains(cpuStep)) {
						break;
					}
				}
			}
		}
		return cpuStep;
	}

	/* CPU selecting option */
	public void cpuTurn(Player cpu, String playerLastStep) {
		// Integer anticipatedLoc=randomOption(gamePath);
		Integer anticipatedLoc = Integer.parseInt(anticipateStep(
				playerLastStep, playerOne.getPath(), gamePath));
		System.out.println(anticipatedLoc);
		myButton.setLoc(anticipatedLoc);
		button[anticipatedLoc].setText("O");
		button[anticipatedLoc].setEnabled(false);
	}

	/* controls events performed in game */
	public void gameEvents(JComponent event) {
		myButton = (MyButton) event;
		/* i reads the number of clicks and play decides the player */
		if (i <= numOfClicks - 1 && play < 9) {
			i++;
			if (play % 2 == 0) {
				button[myButton.getLoc()].setText("X");
				button[myButton.getLoc()].setEnabled(false);
				playerOne.setPath(myButton.getLoc().toString());
				playerLastStep = myButton.getLoc().toString();
			} else if (playerTwo.getName().equals("CPU")) {
				cpuTurn(playerTwo, playerLastStep);
				playerTwo.setPath(myButton.getLoc().toString());
			} else {
				button[myButton.getLoc()].setText("O");
				button[myButton.getLoc()].setEnabled(false);
				playerTwo.setPath(myButton.getLoc().toString());
			}
			++play;
			/* game path reads the whole clicks */
			gamePath = gamePath.concat(myButton.getLoc().toString());
			try {
				winner = checkWinner(playerOne, playerTwo);
				/* if player win, display dialog */
				if (winner != null) {
					JOptionPane.showMessageDialog(null, winner.getName()
							+ " is the winner");
					clearAll();
				}
				/* if user out of button, display no winner */
				else if (i == 9
						&& event.getClass().getName() == myButton.getClass()
								.getName()) {
					JOptionPane.showMessageDialog(null, "No Winner. Try again");
					clearAll();
				}
			} catch (Exception e) {
			}
		}
		/*
		 * If any thing else happens other than these steps. Display Invalid
		 * move error
		 */
		else {
			JOptionPane.showMessageDialog(null, "Invalid move.", "Move Error",
					0);
		}
		/* raising dummy event for CPU */
		if (playerTwo.getName().equals("CPU") && play % 2 != 0 && won == false) {
			actionPerformed(new ActionEvent(new MyButton(), 0, "none"));
		}
	}

	/*
	 * Event action. Note: since the main job is button clicked event included
	 * all events in single function. Always player must click first.
	 */
	@Override
	public void actionPerformed(ActionEvent mouseClick) {
		JComponent event = (JComponent) mouseClick.getSource();
		/* user selected Player vs. Player */
		if (event == mntmPlayerVsPlayer) {
			clearAll();
			playerOne = new Player("Player One");
			playerTwo = new Player("Player Two");
			enableAll();
		}
		/* user selected Player vs. CPU */
		else if (event == mntmPlayerVsCpu) {
			clearAll();
			enableAll();
			playerOne = new Player("Player");
			playerTwo = new Player("CPU");
		}
		/* user selected to quit */
		else if (event == mntmExit) {
			int decision = JOptionPane.showConfirmDialog(null,
					"Do you really want to exit the game?", "Exit",
					JOptionPane.YES_NO_OPTION);
			if (decision == JOptionPane.YES_OPTION)
				System.exit(ABORT);
		}
		/* user clicked on a button the execute gameEvents */
		else if (event.getClass().equals(myButton.getClass())) {
			gameEvents(event);
		}
	}

	public void displayAll() {
		System.out.println("game path:" + gamePath);
		System.out.println("playerOne path:" + playerOne.path);
		System.out.println("playerTwo path:" + playerTwo.path);
		System.out.println("play count:" + play);
		System.out.println("number of clicks:" + i);
	}
}