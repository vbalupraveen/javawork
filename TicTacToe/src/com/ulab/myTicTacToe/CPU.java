package com.ulab.myTicTacToe;

import java.util.Random;

public class CPU {
	final String[] winningCombo = { "012", "036", "048", "147", "246", "258",
			"345", "678" };
	String gamePath = "";

	public static char getStep(String anticipatedCombo, String pair) {
		for (int i = 0; i < anticipatedCombo.length(); i++) {
			if (!pair.contains(anticipatedCombo.subSequence(i, i + 1)))
				return anticipatedCombo.charAt(i);
		}
		return 'N';
	}

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
				System.out.println(cpuStep + "   " + pair);
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

	public static void main(String[] args) {
		System.out.println(new CPU().anticipateStep("6", "36", "306"));
	}

	public static Integer randomOption(String path) {
		Random rn = new Random();
		Integer num = 0;
		int count = 0;
		while (count < path.length()) {
			num = rn.nextInt(9);
			if (!path.contains(num.toString())) {
				break;
			}
			count++;
		}
		return num;
	}

	public static boolean matchPaths(String test, String combo, int reqResults) {
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
}
