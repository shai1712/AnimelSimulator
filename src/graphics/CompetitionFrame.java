/**
 * 
 */
package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author משתמש
 *
 */
public class CompetitionFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem helpItem, exitItem;

	/**
	 * 
	 */
	public CompetitionFrame() {
		// the title of the frame
		setTitle("Competition");

		// the size of the frame
		setSize(800, 600);

		// the layout manager of the frame
		setLayout(new BorderLayout());

		// the default close operation
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// the location of the frame when it's opened, null mean the center of the
		// screen.
		setLocationRelativeTo(null);

		// non resizable frame
		setResizable(false);

		// create the Menu for this frame
		competitionFrameMenu();

		// create a new instance of CityPanel and add it to this frame
		CompetitionPanel cp = new CompetitionPanel();
		add(cp);

		// set the frame visible
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompetitionFrame mainFrame = new CompetitionFrame();

	}

	public void competitionFrameMenu() {
		// create the menu bar
		JMenuBar menuBar = new JMenuBar();

		// create the headers
		JMenu file = new JMenu("File"), help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(help);

		// create the menu items
		helpItem = new JMenuItem("Help");
		exitItem = new JMenuItem("Exit");
		file.add(exitItem);
		help.add(helpItem);
		
		addActionListener();
		// add the menu bar to the Frame
		add(menuBar, BorderLayout.PAGE_START);
	}
	
	public void addActionListener()
	{
		helpItem.addActionListener(this);
		exitItem.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == helpItem)
			JOptionPane.showMessageDialog(null, "HomeWork 2\n GUI");
		else if(e.getSource()==exitItem)
			System.exit(0);
	}
}
