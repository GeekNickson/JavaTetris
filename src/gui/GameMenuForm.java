package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.Highlighter;
import javax.xml.crypto.Data;

public class GameMenuForm extends JFrame{
	private JButton playButton;
	private JLabel selectLevelLabel;
	private JTable ScoreboardTable;
	//You can't click play until you select one of those levels
	private JButton levelOneButton;
	private JButton levelFiveButton;
	private JButton levelTenButton;
	private JButton levelFifteenButton;
	private JButton levelTwentyButton;
	private JButton levelTwentyFiveButton;
	private JLabel nameScoreLabel;
	private Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	private Font levelFont = new Font("Showcard Gothic", Font.PLAIN, 24);
	private Font levelTextFont = new Font("Showcard Gothic", Font.PLAIN, 14);
	public GameMenuForm() {
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Main Menu");
		playButton = new JButton("Play");
		playButton.setBounds(100, 300, 300, 30);
		playButton.setFont(mainFont);
		playButton.setBackground(new Color(247, 170, 232));
		add(playButton);
		selectLevelLabel = new JLabel("Level");
		selectLevelLabel.setFont(levelFont);
		selectLevelLabel.setBounds(220, 350, 200, 30);
		add(selectLevelLabel);
		levelOneButton = new JButton("1");
		levelOneButton.setBounds(100,390, 50, 30);
		levelOneButton.setBackground(new Color(231, 0, 0));
		levelOneButton.setFont(levelTextFont);
		levelOneButton.setForeground(new Color(255,255,255));
		add(levelOneButton);
		levelFiveButton = new JButton("5");
		levelFiveButton.setBounds(150,390, 50, 30);
		levelFiveButton.setBackground(new Color(255, 140, 0));
		levelFiveButton.setFont(levelTextFont);
		levelFiveButton.setForeground(new Color(255,255,255));
		add(levelFiveButton);
		levelTenButton = new JButton("10");
		levelTenButton.setBounds(200,390, 50, 30);
		levelTenButton.setBackground(new Color(255, 239, 0));
		levelTenButton.setFont(levelTextFont);
		levelTenButton.setForeground(new Color(255,255,255));
		add(levelTenButton);
		levelFifteenButton = new JButton("15");
		levelFifteenButton.setBounds(250,390, 50, 30);
		levelFifteenButton.setBackground(new Color(0, 129, 31));
		levelFifteenButton.setFont(levelTextFont);
		levelFifteenButton.setForeground(new Color(255,255,255));
		add(levelFifteenButton);
		levelTwentyButton = new JButton("20");
		levelTwentyButton.setBounds(300,390, 50, 30);
		levelTwentyButton.setBackground(new Color(0, 68, 255));
		levelTwentyButton.setFont(levelTextFont);
		levelTwentyButton.setForeground(new Color(255,255,255));
		add(levelTwentyButton);
		levelTwentyFiveButton = new JButton("25");
		levelTwentyFiveButton.setBounds(350,390, 50, 30);
		levelTwentyFiveButton.setBackground(new Color(118, 0, 137));
		levelTwentyFiveButton.setFont(levelTextFont);
		levelTwentyFiveButton.setForeground(new Color(255,255,255));
		add(levelTwentyFiveButton);
		nameScoreLabel = new JLabel("       Name           Score");
		nameScoreLabel.setFont(mainFont);
		nameScoreLabel.setBounds(100, 470, 300, 30);
		add(nameScoreLabel);
		ScoreboardTable = new JTable(5,2) {
			public Component prepareRenderer( TableCellRenderer renderer, int row, int column) {
		        JComponent jc = (JComponent)super.prepareRenderer(renderer, row, column);
		        jc.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 3));
		        return jc;
		    }
		};
		//MatteBorder border = new MatteBorder(0,0,0,0, Color.black);
		ScoreboardTable.setDefaultEditor(Object.class, null);;
		ScoreboardTable.setBounds(100,500, 300, 200);
		ScoreboardTable.setBackground(new Color(240, 240, 240));
		ScoreboardTable.setSelectionBackground(new Color(240, 240, 240));
		ScoreboardTable.setOpaque(true);
		//ScoreboardTable.setBorder(border);
		ScoreboardTable.setRowHeight(40);
		add(ScoreboardTable);
		getContentPane().setBackground(new Color(240, 240, 240));
		setSize(500,800);
		setVisible(true);
	}
	

}
