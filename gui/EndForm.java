package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.*;

public class EndForm extends JFrame {

	private JLabel gameOverLabel;
	private JLabel scoreLabel;
	private JLabel actualScoreLabel;
	private JButton playAgainButton;
	private JButton returnToMainMenuButton;
	private Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	private Font levelFont = new Font("Showcard Gothic", Font.PLAIN, 24);
	private Font buttonsFont = new Font("Comic Sans MS", Font.PLAIN, 16);
	public EndForm() {
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOverLabel = new JLabel("GAME OVER!");
		gameOverLabel.setFont(levelFont);
		gameOverLabel.setBounds(75, 50, 150, 30);
		add(gameOverLabel);
		scoreLabel = new JLabel("Score");
		scoreLabel.setFont(mainFont);
		scoreLabel.setBounds(115,80,100,30);
		add(scoreLabel);
		actualScoreLabel = new JLabel();
		actualScoreLabel.setFont(mainFont);
		actualScoreLabel.setBounds(115,110, 100, 30);
		actualScoreLabel.setVisible(false);
		add(actualScoreLabel);
		playAgainButton = new JButton("Try again");
		playAgainButton.setBounds(20, 170, 120, 50);
		playAgainButton.setFont(buttonsFont);
		playAgainButton.setBackground(new Color(247, 170, 232));
		add(playAgainButton);
		returnToMainMenuButton = new JButton("Go home");
		returnToMainMenuButton.setBounds(160, 170, 120, 50);
		returnToMainMenuButton.setFont(buttonsFont);
		returnToMainMenuButton.setBackground(new Color(247, 170, 232));
		add(returnToMainMenuButton);
		setSize(300,300);
		setVisible(true);
	}
}
