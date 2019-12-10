import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class GUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtSpecificUserSubreddit;
	
	public static void start(connector main){
		//HERE BE GUI
	};
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1153, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setHgap(6);
		flowLayout.setVgap(17);
		contentPane.add(panel);
		
		JLabel lblQuerySelection = new JLabel("Query Selection");
		panel.add(lblQuerySelection);
		//test 
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 - How many comments have a specific user posted?", "2 - How many comments does a specific subreddit get per day?", "3 - How many comments include the word 'lol'?", "4 - Users that commented on a specific link has also posted to which subreddits?", "5 - Which users have the highest and lowest combined scores? (combined as the sum of all scores)", "6 - Which subreddits have the highest and lowest scored comments?", "7 - Given a specific user, list all the users he or she has potentially interacted with (i.e., everyone who as commented on a link that the specific user has commented on).", "8 - Which users has only posted to a single subreddit?"}));
		comboBox.setToolTipText("");
		panel.add(comboBox);
		
		JButton btnSubmitt = new JButton("SUBMITT");
		btnSubmitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = comboBox.getSelectedIndex() + 1;
				String text = txtSpecificUserSubreddit.getText();
				System.out.println("test: " + text +" " +number);
			}
		});
		
		txtSpecificUserSubreddit = new JTextField();
		txtSpecificUserSubreddit.setText("add  specific user, subreddit or link");
		txtSpecificUserSubreddit.setToolTipText("add  specific user, subreddit or link");
		panel.add(txtSpecificUserSubreddit);
		txtSpecificUserSubreddit.setColumns(25);
		panel.add(btnSubmitt);
		
		JTextPane txtpnHierKommtDie = new JTextPane();
		txtpnHierKommtDie.setForeground(new Color(0, 0, 0));
		txtpnHierKommtDie.setEditable(false);
		txtpnHierKommtDie.setText("Hier kommt die Lösung hin. Wenn wir sie haben...");
		panel.add(txtpnHierKommtDie);
	}
}
