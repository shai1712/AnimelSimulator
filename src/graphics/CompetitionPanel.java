package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import animals.Animal;
import animals.AnimalCreator;
import mobility.Point;

public class CompetitionPanel extends JPanel implements ActionListener {

	// the user selection of competition type
	private String competitionType = "";

	// the background image path
	private final static String BACKGROUND_PATH = "src\\images\\competitionBackground.png";

	private BufferedImage backgroundImage = null;

	// The buttons on the lower panel
	private JButton[] cpButtons = new JButton[6];

	private Animal animal = null;

	private Dictionary<Integer, Animal> dict = new Hashtable<Integer, Animal>();

	public CompetitionPanel() {

		// the layout manager of the panel

		setLayout(new BorderLayout());

		// build the buttons panel
		competitionPanelButtons();
	}

	public boolean setAnimal(Animal a) {
		if (a == null)
			return false;
		this.animal = a;
		return true;
	}

	private void competitionPanelButtons() {

		// make the buttons panel
		JPanel buttonsPanel = new JPanel();

		// set the layout manager to GridLayout
		buttonsPanel.setLayout(new GridLayout());

		// create the buttons
		cpButtons[0] = new JButton("Competition");
		cpButtons[1] = new JButton("Add Animal");
		cpButtons[2] = new JButton("Clear");
		cpButtons[3] = new JButton("Eat");
		cpButtons[4] = new JButton("Info");
		cpButtons[5] = new JButton("Exit");

		// set the Action listener to the buttons and set their colors to light gray
		for (int i = 0; i < cpButtons.length; i++) {
			buttonsPanel.add(cpButtons[i]);
			cpButtons[i].addActionListener(this);
			cpButtons[i].setBackground(Color.LIGHT_GRAY);
		}

		add(buttonsPanel, BorderLayout.PAGE_END);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// try to read the image
		try {
			backgroundImage = ImageIO.read(new File(BACKGROUND_PATH));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		if (animal != null) { // if the animal object exists
			animal.drawObject(g);
			animal.animalMove(animal.nextLocation());
		}
	}

	public Dictionary<Integer, Animal> getDict() {
		return dict;
	}

	///////////////// drawing object
	/*
	 * Animal tmp = AnimalCreator.makeAnimal("Terrestrial Animal", "Cat");
	 * this.setAnimal(tmp); animal.setCompetitionPanel(this); animal = (Cat)animal;
	 * animal.loadImages(); repaint();
	 */

	/**
	 * create the Info table
	 */
	public void info() {
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(this);
		String[] columnNames = { "Name", "Category", "Type", "Speed", "Energy Amount", "Distance",
				"Energy Consumption" };

		DefaultTableModel dtm = new DefaultTableModel();
		JTable infoTable = new JTable(dtm) {
			public boolean isCellEditable(int data, int columns) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(columnNames);
		for (Enumeration e = dict.keys(); e.hasMoreElements();) {
			Object[] data = updateInfoTable(e.nextElement());
			dtm.addRow(data);
		}

		JScrollPane scrollPanel = new JScrollPane(infoTable);
		infoTable.setFillsViewportHeight(true);
		frame.add(scrollPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(1, 0));
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * update Info table
	 * 
	 * @param id - the Object to update
	 * @return updated Object
	 */
	public Object[] updateInfoTable(Object id) {
		Animal animal = dict.get(id);
		Object[] data = { animal.getName(), animal.getCategory(), animal.getType(), animal.getSpeed(),
				animal.getCurrentEnergy(), animal.getTD(), animal.getTotalEnergyConsumption() };

		return data;
	}

	/**
	 * 
	 * @return the competition type
	 */
	public String getCompType() {
		return this.competitionType;
	}

	public void createCompetitionDialog() {
		String[] options = { "Air", "Water", "Terrestrial" };
		int selection = JOptionPane.showOptionDialog(this, "Select The Competition Type:\n",
				"Competition Selection Dialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
		if (selection == 0) {
			competitionType = "Air";
		} else if (selection == 1) {
			competitionType = "Water";
		} else if (selection == 2) {
			competitionType = "Terrestrial";
		}
	}

	public void createAnimal() {
		AddAnimalDialog animalDialog = new AddAnimalDialog(this);
		if (animalDialog.getFirstSelection() == null || animalDialog.getSecondSelection() == null) {

		} else {
			Animal tmp = AnimalCreator.makeAnimal(animalDialog.getFirstSelection(), animalDialog.getSecondSelection());
			this.setAnimal(tmp);
			animal.setCompetitionPanel(this);
			animal.loadImages(animalDialog.getModel());
			animal.setLocation(setStartingLocation(animalDialog.getTrack()));
			int key = System.identityHashCode(animal);
			this.getDict().put(key, animal);
			animal.animalMove(animal.nextLocation());
		}
	}

	public Point setStartingLocation(String s) {
		if (this.getCompType() == "Air") {
			if (s == "1") {
				return new Point();
			} else if (s == "2") {
				return new Point(0, 120);
			} else if (s == "3") {
				return new Point(0, 230);
			} else if (s == "4") {
				return new Point(0, 350);
			} else if (s == "5") {
				return new Point(0, 460);
			}
		} else if (this.getCompType() == "Water") {
			if (s == "1") {
				return new Point(40, 50);
			} else if (s == "2") {
				return new Point(40, 180);
			} else if (s == "3") {
				return new Point(40, 290);
			} else if (s == "4") {
				return new Point(0, 405);
			}
		}
		return new Point();
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if (act.getSource() == cpButtons[0]) {
			createCompetitionDialog();
		} else if (act.getSource() == cpButtons[1] && getCompType() != "") {
			createAnimal();
		} else if (act.getSource() == cpButtons[1] && getCompType() == "") {
			JOptionPane.showMessageDialog(null, "Please first select a competition", "", JOptionPane.ERROR_MESSAGE);
		} else if (act.getSource() == cpButtons[2]) {
			if (animal == null) {
				JOptionPane.showMessageDialog(null, "There is no animal(s) to clear", "", JOptionPane.ERROR_MESSAGE);
			} else {
				animal = null;
				repaint();
			}
		} else if (act.getSource() == cpButtons[3]) {
			// TODO EAT

			if (this.animal == null) {
				JOptionPane.showMessageDialog(null, "There are no animal(s) to feed", "", JOptionPane.ERROR_MESSAGE);
			} else {
				int energy = 0;
				energy = Integer.parseInt(JOptionPane.showInputDialog("Enter energy amount:"));
				this.animal.eat(energy);
			}
		} else if (act.getSource() == cpButtons[4]) {
			info();
		} else if (act.getSource() == cpButtons[5]) {
			System.exit(0);
		}
	}

}
