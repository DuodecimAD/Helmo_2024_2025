package poo.labo03.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import poo.labo03.HousesCup;


public class SwingHouseCupView extends JPanel {
	private static final long serialVersionUID = -8493715512783198945L;

	private final HousesCup cup;

	private final JComboBox<String> members;
	private final JComboBox<Integer> pointsObjects;
	private final JButton grantPointsButton;
	private final JTable scoreTable;
	private final DefaultTableModel scoreTableModel;
	
	static {
		try {
			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace ();
			System.exit(-1);
		}
	}
	
	public SwingHouseCupView(HousesCup cup) {
		super(new  GridBagLayout());
		
		this.cup = cup;
		
		var constraint = new GridBagConstraints();
		constraint.insets = new Insets(4, 4, 4, 4);
		
		var membersLabel = new JLabel(String.format("%-60s", "Wizard :"));
		constraint.fill = GridBagConstraints.NONE;
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridwidth = 2;
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		add(membersLabel, constraint);
		
		var pointsLabel = new JLabel(String.format("%-30s", "Points :"));
		constraint.fill = GridBagConstraints.NONE;		
		constraint.gridwidth = 2;
		constraint.gridx = 2;
		constraint.gridy = 0;
		
		add(pointsLabel, constraint);
		
		
		members = new JComboBox<>();
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 1;
		
		add(members, constraint);
		
		
		pointsObjects = new JComboBox<>(new Integer[] {5, 10, 15, 20, 30, 40, 50});
		constraint.gridx = 2;
		constraint.gridy = 1;
		
		add(pointsObjects, constraint);
		
		grantPointsButton = new JButton("Grant points");
		grantPointsButton.addActionListener(this::onPointsGranted);
		grantPointsButton.setEnabled(false);
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridwidth = 4;
		constraint.gridx = 0;
		constraint.gridy = 2;
		
		add(grantPointsButton, constraint);
		
		scoreTableModel = new DefaultTableModel(new String[] {"Name", "Points"}, 0);
		
		scoreTable = new JTable(scoreTableModel);
		scoreTable.setShowVerticalLines(false);
		
		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.gridheight = 4;
		constraint.fill = GridBagConstraints.BOTH;
		add(new JScrollPane(scoreTable), constraint);
		
		fillComponents();
	}

	private void fillComponents() {
		boolean validNames = fillNamesCombo();
		boolean validTable = fillTable();
		
		grantPointsButton.setEnabled(validNames && validTable);
		
		this.updateUI();
	}

	private boolean fillTable() {
		String[][] tableData = cup.getRankingTable();
		boolean validData = checkNoNull(tableData);
		if(validData) {
			scoreTableModel.setRowCount(0);
			
			for(var rowData : tableData) {
				scoreTableModel.addRow(rowData);
			}
		} else {
			showErrorMessage("You must provide at least one two-columns header row.");
		}
		return validData;
	}

	private boolean fillNamesCombo() {
		String[] names = cup.getMembersNames();
		boolean validNames = checkNoNull(names, 1);
		if(validNames) {
			members.removeAllItems();
			for(var name : names) {
				members.addItem(name);
			}
		} else {
			showErrorMessage("You must provide at least one wizard");
		}
		return validNames;
	}

	private void onPointsGranted(ActionEvent ae) {
		this.cup.grantPoints(
					(String)members.getSelectedItem(), 
					(int)pointsObjects.getSelectedItem());
		
		fillComponents();
	}

	private boolean checkNoNull(String[][] table) {
		return Arrays.stream(table)
				.allMatch(row -> checkNoNull(row, 2));
	}
	
	private boolean checkNoNull(String[] row, int minLength) {
		return row != null && row.length >= minLength 
				&& Arrays.stream(row).allMatch(col -> col != null);
	}
	
	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, 
				message, 
				"Initialization error",
				JOptionPane.ERROR_MESSAGE);
	}
}