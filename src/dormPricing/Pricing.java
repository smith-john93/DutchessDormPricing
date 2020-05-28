//John Smith
//Assignment #4

package dormPricing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
//Suppresses yellow flag of GUI not being called locally

public class Pricing extends JFrame{
	//Room prices
	final int DUTCHESS_SUITES_DOUBLE = 3688;
	final int HUDSON_SUITES_SINGLE = 4346;
	final int HUDSON_SUITES_DOUBLE = 3688;
	final int HUDSON_SUITES_TRIPLE = 3316;
	final int FALCON_SUITES_DOUBLE = 3898;
	final int DRUMLIN_SUITES_SINGLE = 4346;
	final int DRUMLIN_SUITES_DOUBLE = 5000;
			
	//Meal plans
	final int TEN_PER = 1525;
	final int FOURTEEN_PER = 1659;
	final int TWENTYONE_PER = 2000;
	
	//arrays for cost
	int[] housingPrices = {DUTCHESS_SUITES_DOUBLE, HUDSON_SUITES_SINGLE,
							HUDSON_SUITES_DOUBLE, HUDSON_SUITES_TRIPLE,
						    FALCON_SUITES_DOUBLE, DRUMLIN_SUITES_SINGLE,
						    DRUMLIN_SUITES_DOUBLE};
	
	int[] mealPrices = {TEN_PER, FOURTEEN_PER,
						TWENTYONE_PER};
	
	//used to calculate cost
	private int totalCost = 0;
	private int housingCost;
	private int mealCost;
	
	//window size
	final int WINDOW_WIDTH = 700;
	final int WINDOW_HEIGHT = 250;
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	//Suppressing warnings because this looks better
	@SuppressWarnings("rawtypes")
	private JComboBox combo1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	private JComboBox combo2 = new JComboBox();
	
	private JLabel housingLabel;
	private JLabel mealLabel;
	private JLabel finalPrice;
	private JLabel total;
	
		public Pricing() throws IOException {
			
			setTitle("Housing and Food plans");
			setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(1,3)); // sets grid layout

			buildPanel1();
			add(panel1);
			//builds and adds panel 1 to the grid
			
			buildPanel2();
			add(panel2);
			//builds and adds panel 1 to the grid
			
			buildPanel3();
			add(panel3);
			//builds and adds panel 1 to the grid
			
			setVisible(true);
		}
	
		private void buildPanel1() {
			housingLabel = new JLabel("Housing Options");
			panel1.add(housingLabel);
			
			//creates the array for display in the housing combo box
			String[] housing = { "Duchess Suites Double $" + DUTCHESS_SUITES_DOUBLE,
								 "Hudson Suites Single  $" +  HUDSON_SUITES_SINGLE
							   , "Hudson Suites Double  $" + HUDSON_SUITES_DOUBLE
							   , "Hudson Suites Triple  $" + HUDSON_SUITES_TRIPLE
							   , "Falcon Suites Double  $" + FALCON_SUITES_DOUBLE
							   , "Drumlin Suites Single $" + DRUMLIN_SUITES_SINGLE
							   , "Drumlin Suites Double $" + DRUMLIN_SUITES_DOUBLE};
			//calls action listener
			combo1 = new JComboBox<String>(housing);
			combo1.addActionListener(new calculate());

			panel1.add(combo1);	
		}
		
		private void buildPanel2() {
			mealLabel = new JLabel("Meal Plans");
			panel2.add(mealLabel);
			
			//creates an array for display in the meal combo box
			String[] meals = { "10 Meals per Week $" + TEN_PER,
					 "14 Meals per Week  $" + FOURTEEN_PER,
				     "21 Meals per Week  $" + TWENTYONE_PER};

			//calls action listener
			combo2 = new JComboBox<String>(meals);
			combo2.addActionListener(new calculate());
			
			panel2.add(combo2);
		}
		
		private void buildPanel3() {
			finalPrice = new JLabel("TotalCost:");
			total = new JLabel("");
			panel3.add(finalPrice);
			panel3.add(total);
		}
		
		private class calculate implements ActionListener {
			//listens for any comboBox click and recalculates cost
			public void actionPerformed(ActionEvent a){
				housingCost = combo1.getSelectedIndex();
				mealCost = combo2.getSelectedIndex();
				totalCost=housingPrices[housingCost] + mealPrices[mealCost];
				total.setText(" $" +totalCost);
			}
		}
}
