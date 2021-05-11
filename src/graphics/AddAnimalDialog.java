package graphics;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class AddAnimalDialog extends JDialog implements ActionListener {

	// ok & cancel buttons
	private JButton[] okCancelButtons = new JButton[2];

	// Air, Water & Terrestrial radio buttons
	private JRadioButton[] animalTypeRadioButtons = new JRadioButton[3];
	// Eagle & pigeon radio buttons
	private JRadioButton[] airAnimalRadioButtons = new JRadioButton[2];
	// Alligator, Dolphin & Whale radio buttons
	private JRadioButton[] waterAnimalRadioButtons = new JRadioButton[3];
	// Cat, Dog & Snake radio buttons
	private JRadioButton[] terrAnimalRadioButtons = new JRadioButton[3];
	// Lane/Track selection radio buttons
	private JRadioButton[] trackRadioButtons;

	// Animal Icons radio buttons
	private JRadioButton[] catIconRB, dogIconRB, snakeIconRB, alligatorIconRB, dolphinIconRB, whaleIconRB, eagleIconRB;

	// airAnimalBG - Eagle & Pigeon ButtonGroup so only 1 could be selected, waterAnimalBG - same for Alligator, Dolphin & Whale , terrAnimalBG - same for Cat, Dog & Snake
	private ButtonGroup airAnimalBG, waterAnimalBG, terrAnimalBG;

	// the user selection via radio buttons are saved to these variables
	private String firstSelection, secondSelection, track, model;

	private CompetitionPanel compPanel;
	CardLayout cardLayout = new CardLayout();
	JPanel categorySwitchPanel = new JPanel(cardLayout);
	JPanel iconSwitchPanel = new JPanel(cardLayout);

	public AddAnimalDialog(CompetitionPanel cp) {
		setCompPanel(cp);
		setTitle("Add Animal");
		mainPanel();
		pack();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(compPanel);
		setVisible(true);
	}

	public void mainPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(topPanel(), BorderLayout.NORTH);
		mainPanel.add(centerPanel(), BorderLayout.CENTER);
		mainPanel.add(bottomPanel(), BorderLayout.SOUTH);
		add(mainPanel);
	}

	// create the top panel of the dialog
	public JPanel topPanel() {
		JPanel topPanel;
		topPanel = new JPanel(new FlowLayout());
		ButtonGroup animalTypeBG = new ButtonGroup();
		animalTypeRadioButtons[0] = new JRadioButton("Air Animal");
		animalTypeRadioButtons[1] = new JRadioButton("Water Animal");
		animalTypeRadioButtons[2] = new JRadioButton("Terrestrial Animal");
		TitledBorder animalTypeBorder = new TitledBorder("Choose the animal type");

		for (int i = 0; i < animalTypeRadioButtons.length; i++) {
			animalTypeBG.add(animalTypeRadioButtons[i]);
			animalTypeRadioButtons[i].addActionListener(this);
			topPanel.add(animalTypeRadioButtons[i]);
		}
		topPanel.setBorder(animalTypeBorder);

		return topPanel;

	}

	public JPanel waterPanel() {
		JPanel waterPanel = new JPanel();
		TitledBorder waterAnimalBorder = new TitledBorder("Choose Water Animal:");
		waterPanel.setBorder(waterAnimalBorder);

		waterAnimalBG = new ButtonGroup();
		waterAnimalRadioButtons[0] = new JRadioButton("Alligator");
		waterAnimalRadioButtons[1] = new JRadioButton("Dolphin");
		waterAnimalRadioButtons[2] = new JRadioButton("Whale");

		for (int i = 0; i < waterAnimalRadioButtons.length; i++) {
			waterAnimalBG.add(waterAnimalRadioButtons[i]);
			waterAnimalRadioButtons[i].addActionListener(this);
			waterPanel.add(waterAnimalRadioButtons[i]);
		}
		return waterPanel;
	}

	public JPanel airPanel() {
		JPanel airPanel = new JPanel();
		TitledBorder airAnimalBorder = new TitledBorder("Choose Air Animal:");
		airPanel.setBorder(airAnimalBorder);

		airAnimalBG = new ButtonGroup();
		airAnimalRadioButtons[0] = new JRadioButton("Eagle");
		airAnimalRadioButtons[1] = new JRadioButton("Pigeon");

		for (int i = 0; i < airAnimalRadioButtons.length; i++) {
			airAnimalBG.add(airAnimalRadioButtons[i]);
			airAnimalRadioButtons[i].addActionListener(this);
			airPanel.add(airAnimalRadioButtons[i]);
		}

		return airPanel;
	}

	public JPanel terrestrialPanel() {
		JPanel terrestrialPanel = new JPanel();
		TitledBorder terrAnimalBorder = new TitledBorder("Choose Terrestrial Animal:");
		terrestrialPanel.setBorder(terrAnimalBorder);

		terrAnimalBG = new ButtonGroup();
		terrAnimalRadioButtons[0] = new JRadioButton("Cat");
		terrAnimalRadioButtons[1] = new JRadioButton("Dog");
		terrAnimalRadioButtons[2] = new JRadioButton("Snake");

		for (int i = 0; i < terrAnimalRadioButtons.length; i++) {
			terrAnimalBG.add(terrAnimalRadioButtons[i]);
			terrAnimalRadioButtons[i].addActionListener(this);
			terrestrialPanel.add(terrAnimalRadioButtons[i]);
		}

		return terrestrialPanel;
	}

	public JPanel centerPanel() {
		JPanel centerPanel;
		centerPanel = new JPanel(new GridLayout());

		// Create the "cards"

		JPanel emptyPanel = new JPanel();

		categorySwitchPanel.add(emptyPanel, "");
		iconSwitchPanel.add(emptyPanel, "");

		categorySwitchPanel.add(airPanel(), "air");
		categorySwitchPanel.add(waterPanel(), "water");
		categorySwitchPanel.add(terrestrialPanel(), "terr");

		centerPanel.add(categorySwitchPanel, BorderLayout.CENTER);

		return centerPanel;
	}

	public JPanel bottomPanel() {
		JPanel bottomPanel = new JPanel(new BorderLayout());

		iconSwitchPanel.add(catPanel(), "cat");
		iconSwitchPanel.add(dogPanel(), "dog");
		iconSwitchPanel.add(snakePanel(), "snake");
		iconSwitchPanel.add(alligatorPanel(), "alligator");
		iconSwitchPanel.add(dolphinPanel(), "dolphin");
		iconSwitchPanel.add(whalePanel(), "whale");
		iconSwitchPanel.add(eaglePanel(), "eagle");

		bottomPanel.add(iconSwitchPanel, BorderLayout.NORTH);
		bottomPanel.add(trackPanel(), BorderLayout.CENTER);
		// bottomPanel.add(presetPanel(), BorderLayout.NORTH);
		bottomPanel.add(okCancelPanel(), BorderLayout.SOUTH);
		return bottomPanel;
	}

	public JPanel catPanel() {
		JPanel presetPanel = new JPanel();

		TitledBorder presetBorder = new TitledBorder("Choose Cat:");
		presetPanel.setBorder(presetBorder);

		ButtonGroup iconBG = new ButtonGroup();
		catIconRB = new JRadioButton[2];
		ImageIcon icon1 = new ImageIcon("src\\images\\cat1E.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\cat2E.png");
		catIconRB[0] = new JRadioButton("1", icon1);
		catIconRB[1] = new JRadioButton("2", icon2);
		for (int i = 0; i < catIconRB.length; i++) {
			iconBG.add(catIconRB[i]);
			catIconRB[i].addActionListener(this);
			presetPanel.add(catIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel dogPanel() {
		JPanel presetPanel = new JPanel();
		TitledBorder presetBorder = new TitledBorder("Choose Dog:");
		presetPanel.setBorder(presetBorder);
		ButtonGroup iconBG = new ButtonGroup();
		dogIconRB = new JRadioButton[6];
		ImageIcon icon1 = new ImageIcon("src\\images\\dog1E.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\dog2E.png");
		ImageIcon icon3 = new ImageIcon("src\\images\\dog3E.png");
		ImageIcon icon4 = new ImageIcon("src\\images\\dog4E.png");
		ImageIcon icon5 = new ImageIcon("src\\images\\dog5E.png");
		ImageIcon icon6 = new ImageIcon("src\\images\\dog6E.png");
		dogIconRB[0] = new JRadioButton("1", icon1);
		dogIconRB[1] = new JRadioButton("2", icon2);
		dogIconRB[2] = new JRadioButton("3", icon3);
		dogIconRB[3] = new JRadioButton("4", icon4);
		dogIconRB[4] = new JRadioButton("5", icon5);
		dogIconRB[5] = new JRadioButton("6", icon6);
		for (int i = 0; i < dogIconRB.length; i++) {
			iconBG.add(dogIconRB[i]);
			dogIconRB[i].addActionListener(this);
			presetPanel.add(dogIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel snakePanel() {
		JPanel presetPanel = new JPanel();
		TitledBorder presetBorder = new TitledBorder("Choose Snake:");
		presetPanel.setBorder(presetBorder);
		ButtonGroup iconBG = new ButtonGroup();
		snakeIconRB = new JRadioButton[3];
		ImageIcon icon1 = new ImageIcon("src\\images\\snake1E.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\snake2E.png");
		ImageIcon icon3 = new ImageIcon("src\\images\\snake3E.png");
		snakeIconRB[0] = new JRadioButton("1", icon1);
		snakeIconRB[1] = new JRadioButton("2", icon2);
		snakeIconRB[2] = new JRadioButton("3", icon3);
		for (int i = 0; i < snakeIconRB.length; i++) {
			iconBG.add(snakeIconRB[i]);
			snakeIconRB[i].addActionListener(this);
			presetPanel.add(snakeIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel alligatorPanel() {
		JPanel presetPanel = new JPanel();
		TitledBorder presetBorder = new TitledBorder("Choose Alligator:");
		presetPanel.setBorder(presetBorder);
		ButtonGroup iconBG = new ButtonGroup();
		alligatorIconRB = new JRadioButton[3];
		ImageIcon icon1 = new ImageIcon("src\\images\\alligator1E.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\alligator2E.png");
		ImageIcon icon3 = new ImageIcon("src\\images\\alligator3E.png");
		alligatorIconRB[0] = new JRadioButton("1", icon1);
		alligatorIconRB[1] = new JRadioButton("2", icon2);
		alligatorIconRB[2] = new JRadioButton("3", icon3);
		for (int i = 0; i < alligatorIconRB.length; i++) {
			iconBG.add(alligatorIconRB[i]);
			alligatorIconRB[i].addActionListener(this);
			presetPanel.add(alligatorIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel dolphinPanel() {
		JPanel presetPanel = new JPanel();
		TitledBorder presetBorder = new TitledBorder("Choose Dolphin:");
		presetPanel.setBorder(presetBorder);
		ButtonGroup iconBG = new ButtonGroup();
		dolphinIconRB = new JRadioButton[3];
		ImageIcon icon1 = new ImageIcon("src\\images\\dolphin1E.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\dolphin2E.png");
		ImageIcon icon3 = new ImageIcon("src\\images\\dolphin3E.png");
		dolphinIconRB[0] = new JRadioButton("1", icon1);
		dolphinIconRB[1] = new JRadioButton("2", icon2);
		dolphinIconRB[2] = new JRadioButton("3", icon3);
		for (int i = 0; i < dolphinIconRB.length; i++) {
			iconBG.add(dolphinIconRB[i]);
			dolphinIconRB[i].addActionListener(this);
			presetPanel.add(dolphinIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel whalePanel() {
		JPanel presetPanel = new JPanel();
		TitledBorder presetBorder = new TitledBorder("Choose Whale:");
		presetPanel.setBorder(presetBorder);
		ButtonGroup iconBG = new ButtonGroup();
		whaleIconRB = new JRadioButton[2];
		ImageIcon icon1 = new ImageIcon("src\\images\\whaleE.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\whale2E.png");
		whaleIconRB[0] = new JRadioButton("1", icon1);
		whaleIconRB[1] = new JRadioButton("2", icon2);
		for (int i = 0; i < whaleIconRB.length; i++) {
			iconBG.add(whaleIconRB[i]);
			whaleIconRB[i].addActionListener(this);
			presetPanel.add(whaleIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel eaglePanel() {
		JPanel presetPanel = new JPanel(new GridLayout());
		TitledBorder presetBorder = new TitledBorder("Choose Eagle:");
		presetPanel.setBorder(presetBorder);
		ButtonGroup iconBG = new ButtonGroup();
		eagleIconRB = new JRadioButton[3];
		ImageIcon icon1 = new ImageIcon("src\\images\\eagle1.png");
		ImageIcon icon2 = new ImageIcon("src\\images\\eagle2.png");
		ImageIcon icon3 = new ImageIcon("src\\images\\eagle3.png");
		eagleIconRB[0] = new JRadioButton("1", icon1);
		eagleIconRB[1] = new JRadioButton("2", icon2);
		eagleIconRB[2] = new JRadioButton("3", icon3);
		for (int i = 0; i < eagleIconRB.length; i++) {
			iconBG.add(eagleIconRB[i]);
			eagleIconRB[i].addActionListener(this);
			presetPanel.add(eagleIconRB[i]);
		}
		return presetPanel;
	}

	public JPanel trackPanel() {
		JPanel trackPanel = new JPanel();
		if (this.compPanel.getCompType() == "Terrestrial") {
			return trackPanel;
		}
		TitledBorder trackBorder = new TitledBorder("Choose your starting Track:");
		trackPanel.setBorder(trackBorder);

		ButtonGroup trackBG = new ButtonGroup();
		if (this.compPanel.getCompType() == "Air") {
			trackRadioButtons = new JRadioButton[5];
			trackRadioButtons[0] = new JRadioButton("1");
			trackRadioButtons[1] = new JRadioButton("2");
			trackRadioButtons[2] = new JRadioButton("3");
			trackRadioButtons[3] = new JRadioButton("4");
			trackRadioButtons[4] = new JRadioButton("5");
		} else if (this.compPanel.getCompType() == "Water") {
			trackRadioButtons = new JRadioButton[4];
			trackRadioButtons[0] = new JRadioButton("1");
			trackRadioButtons[1] = new JRadioButton("2");
			trackRadioButtons[2] = new JRadioButton("3");
			trackRadioButtons[3] = new JRadioButton("4");
		}

		trackRadioButtons[0].setSelected(true);
		for (int i = 0; i < trackRadioButtons.length; i++) {
			trackBG.add(trackRadioButtons[i]);
			trackRadioButtons[i].addActionListener(this);
			trackPanel.add(trackRadioButtons[i]);
		}
		return trackPanel;
	}

	public JPanel okCancelPanel() {
		// create the panel that contain the ok and cancel buttons
		JPanel okCancelPanel = new JPanel(new GridLayout());
		okCancelButtons[0] = new JButton("OK");
		okCancelButtons[1] = new JButton("Cancel");
		for (int i = 0; i < okCancelButtons.length; i++) {
			okCancelPanel.add(okCancelButtons[i]);
			okCancelButtons[i].addActionListener(this);
			okCancelButtons[i].setBackground(java.awt.Color.LIGHT_GRAY);
		}
		return okCancelPanel;
	}

	public String getFirstSelection() {
		return this.firstSelection;
	}

	public String getTrack() {
		return this.track;
	}

	public String getModel() {
		return this.model;
	}

	public void setCompPanel(CompetitionPanel cp) {
		this.compPanel = cp;
	}

	public String getSecondSelection() {
		return this.secondSelection;
	}

	public void setFirstSelection() {
		if (animalTypeRadioButtons[0].isSelected())
			this.firstSelection = "Air Animal";
		else if (animalTypeRadioButtons[1].isSelected())
			this.firstSelection = "Water Animal";
		else if (animalTypeRadioButtons[2].isSelected())
			this.firstSelection = "Terrestrial Animal";
	}

	public void setSecondSelection() {
		if (airAnimalRadioButtons[0].isSelected())
			this.secondSelection = "Eagle";
		else if (airAnimalRadioButtons[1].isSelected())
			this.secondSelection = "Pigeon";

		else if (waterAnimalRadioButtons[0].isSelected())
			this.secondSelection = "Alligator";
		else if (waterAnimalRadioButtons[1].isSelected())
			this.secondSelection = "Dolphin";
		else if (waterAnimalRadioButtons[2].isSelected())
			this.secondSelection = "Whale";

		else if (terrAnimalRadioButtons[0].isSelected())
			this.secondSelection = "Cat";
		else if (terrAnimalRadioButtons[1].isSelected())
			this.secondSelection = "Dog";
		else if (terrAnimalRadioButtons[2].isSelected())
			this.secondSelection = "Snake";

	}

	public void setTrack() {
		if (trackRadioButtons[0].isSelected())
			this.track = "1";
		else if (trackRadioButtons[1].isSelected())
			this.track = "2";
		else if (trackRadioButtons[2].isSelected())
			this.track = "3";
		else if (trackRadioButtons[3].isSelected())
			this.track = "4";
		else if (trackRadioButtons[4].isSelected())
			this.track = "5";
		else
			this.track = "1";
	}

	public void setIcon() {
		if (catIconRB[0].isSelected())
			this.model = "1";
		else if (catIconRB[1].isSelected())
			this.model = "2";

		else if (dogIconRB[0].isSelected())
			this.model = "1";
		else if (dogIconRB[1].isSelected())
			this.model = "2";
		else if (dogIconRB[2].isSelected())
			this.model = "3";
		else if (dogIconRB[3].isSelected())
			this.model = "4";
		else if (dogIconRB[4].isSelected())
			this.model = "5";
		else if (dogIconRB[5].isSelected())
			this.model = "6";

		else if (snakeIconRB[0].isSelected())
			this.model = "1";
		else if (snakeIconRB[1].isSelected())
			this.model = "2";
		else if (snakeIconRB[2].isSelected())
			this.model = "3";

		else if (alligatorIconRB[0].isSelected())
			this.model = "1";
		else if (alligatorIconRB[1].isSelected())
			this.model = "2";
		else if (alligatorIconRB[2].isSelected())
			this.model = "3";

		else if (dolphinIconRB[0].isSelected())
			this.model = "1";
		else if (dolphinIconRB[1].isSelected())
			this.model = "2";
		else if (dolphinIconRB[2].isSelected())
			this.model = "3";

		else if (whaleIconRB[0].isSelected())
			this.model = "1";
		else if (whaleIconRB[1].isSelected())
			this.model = "2";

		else if (eagleIconRB[0].isSelected())
			this.model = "1";
		else if (eagleIconRB[1].isSelected())
			this.model = "2";
		else if (eagleIconRB[2].isSelected())
			this.model = "3";
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if the user clicked OK
		if (e.getSource() == okCancelButtons[0]) {
			{
				// if competition type is air and eagle is selected
				if (airAnimalRadioButtons[0].isSelected() && compPanel.getCompType() == "Air") {
					setFirstSelection();
					setSecondSelection();
					setTrack();
					setIcon();
				} // if competition type is air and pigeon is selected
				else if (airAnimalRadioButtons[1].isSelected() && compPanel.getCompType() == "Air") {
					setFirstSelection();
					setSecondSelection();
					setTrack();
					setIcon();
				} // if competition type is water and alligator is selected
				else if (waterAnimalRadioButtons[0].isSelected() && compPanel.getCompType() == "Water") {
					setFirstSelection();
					setSecondSelection();
					setTrack();
					setIcon();
				} // if competition type is water and dolphin is selected
				else if (waterAnimalRadioButtons[1].isSelected() && compPanel.getCompType() == "Water") {
					setFirstSelection();
					setSecondSelection();
					setTrack();
					setIcon();
				} // if competition type is water and whale is selected
				else if (waterAnimalRadioButtons[2].isSelected() && compPanel.getCompType() == "Water") {
					setFirstSelection();
					setSecondSelection();
					setTrack();
					setIcon();
				} // if competition type is terrestrial and cat is selected
				else if (terrAnimalRadioButtons[0].isSelected() && compPanel.getCompType() == "Terrestrial") {
					setFirstSelection();
					setSecondSelection();
					setIcon();
				} // if competition type is terrestrial and dog is selected
				else if (terrAnimalRadioButtons[1].isSelected() && compPanel.getCompType() == "Terrestrial") {
					setFirstSelection();
					setSecondSelection();
					setIcon();
				} // if competition type is terrestrial and snake is selected
				else if (terrAnimalRadioButtons[2].isSelected() && compPanel.getCompType() == "Terrestrial") {
					setFirstSelection();
					setSecondSelection();
					setIcon();
				} else {
					JOptionPane.showMessageDialog(null,
							"Please select the right animal for this competition:" + " " + compPanel.getCompType(), "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			dispose();
		} // Clicking on Cancel button close the dialog
		else if (e.getSource() == okCancelButtons[1]) {
			dispose();
		} else if (animalTypeRadioButtons[1].isSelected()) {
			cardLayout.show(categorySwitchPanel, "water");
			airAnimalBG.clearSelection();
			terrAnimalBG.clearSelection();
			if (waterAnimalRadioButtons[0].isSelected())
				cardLayout.show(iconSwitchPanel, "alligator");
			else if (waterAnimalRadioButtons[1].isSelected())
				cardLayout.show(iconSwitchPanel, "dolphin");
			else if (waterAnimalRadioButtons[2].isSelected())
				cardLayout.show(iconSwitchPanel, "whale");
		} else if (animalTypeRadioButtons[0].isSelected()) {
			cardLayout.show(categorySwitchPanel, "air");
			waterAnimalBG.clearSelection();
			terrAnimalBG.clearSelection();
			if (airAnimalRadioButtons[0].isSelected())
				cardLayout.show(iconSwitchPanel, "eagle");
			else
				cardLayout.show(iconSwitchPanel, "");
		} else if (animalTypeRadioButtons[2].isSelected()) {
			cardLayout.show(categorySwitchPanel, "terr");
			cardLayout.show(iconSwitchPanel, "");
			airAnimalBG.clearSelection();
			waterAnimalBG.clearSelection();
			if (terrAnimalRadioButtons[0].isSelected())
				cardLayout.show(iconSwitchPanel, "cat");
			else if (terrAnimalRadioButtons[1].isSelected())
				cardLayout.show(iconSwitchPanel, "dog");
			else if (terrAnimalRadioButtons[2].isSelected())
				cardLayout.show(iconSwitchPanel, "snake");
		}
	}
}