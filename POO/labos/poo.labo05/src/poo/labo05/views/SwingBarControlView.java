package poo.labo05.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import poo.labo05.supervisors.BarControlPanelSupervisor;


public final class SwingBarControlView extends JPanel {
	private static final long serialVersionUID = -8493715512783198945L;

	private final BarControlPanelSupervisor supervisor;
	private final JComboBox<String> selection;
	private final JSpinner quantity;
	private final DefaultTableModel stockTableModel;
	
	static {
		try {
			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace ();
		}
	}
	
	public SwingBarControlView(BarControlPanelSupervisor supervisor) {
		super(new  GridBagLayout());
		
		var constraint = new GridBagConstraints();
		constraint.insets = new Insets(4, 4, 4, 4);
		
		stockTableModel = new DefaultTableModel(new String[] {"Vins", "Bouteilles en stock", "Volume total restant (ml)"}, 0);
		
		JTable stockTable = new JTable(stockTableModel);
		stockTable.setShowVerticalLines(false);
		constraint.anchor = GridBagConstraints.NORTH;
		constraint.fill = GridBagConstraints.NONE;
		constraint.gridwidth = 4;
		constraint.gridheight = 4;
		constraint.gridx = 0;
		constraint.gridy = 0;
		add(new JScrollPane(stockTable), constraint);
		
		var membersLabel = new JLabel(String.format("%-40s", "Vins :"));
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridwidth = 2;
		constraint.gridheight = 1;
		constraint.gridx = 0;
		constraint.gridy = 5;
		
		add(membersLabel, constraint);
		
		var pointsLabel = new JLabel(String.format("%-40s", "Quantité :"));	
		constraint.gridx = 2;
		constraint.gridy = 5;
		
		add(pointsLabel, constraint);
		
		
		selection = new JComboBox<>();
		constraint.gridx = 0;
		constraint.gridy = 6;
		
		add(selection, constraint);
		
		
		quantity = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		constraint.gridx = 2;
		constraint.gridy = 6;
		
		add(quantity, constraint);
		
		JButton bottleButton = new JButton("Consommation bouteille");
		bottleButton.addActionListener(this::onBottleConsumptionAsked);
		constraint.gridx = 0;
		constraint.gridy = 7;
		
		add(bottleButton, constraint);

		JButton glassButton = new JButton("Consommation verre");
		glassButton.addActionListener(this::onGlassConsumptionAsked);
		constraint.gridx = 2;
		constraint.gridy = 7;
		
		add(glassButton, constraint);
		
		this.supervisor = supervisor;
		this.supervisor.setView(this);
	}

	public void setStockTable(String[][] tableData) {
		boolean validData = checkNoNull(tableData);
		if(validData) {
			stockTableModel.setRowCount(0);
			
			for(var rowData : tableData) {
				stockTableModel.addRow(rowData);
			}
		} else {
			showErrorMessage("You must provide at least one two-columns header row.");
		}
	}

	public void setWines(Collection<String> wines) {
		boolean validNames = checkNoNull(wines, 1);
		if(validNames) {
			selection.removeAllItems();
			for(var name : wines) {
				selection.addItem(name.toString());
			}
		} else {
			showErrorMessage("You must provide at least one options");
		}
	}

	private void onBottleConsumptionAsked(ActionEvent ae) {
		this.supervisor.consumeBottle(
					(String)selection.getSelectedItem(), 
					(int)quantity.getValue());
	}
	
	private void onGlassConsumptionAsked(ActionEvent ae) {
		this.supervisor.consumeGlass(
					(String)selection.getSelectedItem(), 
					(int)quantity.getValue());
	}

	private boolean checkNoNull(String[][] table) {
		return Arrays.stream(table)
				.allMatch(row -> checkNoNull(Arrays.asList(row), 2));
	}
	
	private boolean checkNoNull(Collection<String> row, int minLength) {
		return row != null && row.size() >= minLength 
				&& row.stream().allMatch(col -> col != null);
	}
	
	/**
	 * Display an error message within a dialog box.
	 * 
	 * @param message the dialog box content
	 * */
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, 
				message, 
				"Error",
				JOptionPane.ERROR_MESSAGE);
	}

}