import org.w3c.dom.Text;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtSpecificUserSubreddit;
	
	public static void start(connector main){
		//HERE BE GUI 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI(main);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};
	
	/**
	 * Create the frame.
	 */
	public GUI(connector main) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1153, 500);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Table.focusCellForeground"));
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmMadeBy = new JMenuItem("Made by ");
		mntmMadeBy.setBackground(Color.GRAY);
		mnOptions.add(mntmMadeBy);
		
		JCheckBoxMenuItem chckbxmntmCarolinBrckmann = new JCheckBoxMenuItem("Carolin Brückmann");
		mnOptions.add(chckbxmntmCarolinBrckmann);
		
		JCheckBoxMenuItem chckbxmntmChristianBaltzer = new JCheckBoxMenuItem("Christian Baltzer");
		mnOptions.add(chckbxmntmChristianBaltzer);
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
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 - How many comments have a specific user posted?", "2 - How many comments does a specific subreddit get per day?", "3 - How many comments include the word 'lol'?", "4 - Users that commented on a specific link has also posted to which subreddits?", "5 - Which users have the highest and lowest combined scores? (combined as the sum of all scores)", "6 - Which subreddits have the highest and lowest scored comments?", "7 - Given a specific user, list all the users he or she has potentially interacted with (i.e., everyone who as commented on a link that the specific user has commented on).", "8 - Which users has only posted to a single subreddit?"}));
		comboBox.setToolTipText("");
		panel.add(comboBox);
		
		JButton btnSubmitt = new JButton("SUBMITT");
		
		
		txtSpecificUserSubreddit = new JTextField();
		txtSpecificUserSubreddit.setText("add  specific user, subreddit or link");
		txtSpecificUserSubreddit.setToolTipText("add  specific user, subreddit or link");
		panel.add(txtSpecificUserSubreddit);
		txtSpecificUserSubreddit.setColumns(25);
		panel.add(btnSubmitt);

		JTextArea TextAnzeigeLösung = new JTextArea("", 18, 90);
		TextAnzeigeLösung.setLineWrap(true);
		JScrollPane sp = new JScrollPane(TextAnzeigeLösung);
		TextAnzeigeLösung.setForeground(new Color(0, 0, 0));
		TextAnzeigeLösung.setEditable(false);
		TextAnzeigeLösung.setText(" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus mattis sapien vel lectus elementum viverra. Phasellus tristique id nibh sit amet dictum. Duis non lobortis augue. Phasellus vestibulum odio quis lectus finibus, ut ornare mi accumsan. Nullam purus sapien, efficitur non metus at, suscipit pharetra ante. Proin ac libero non purus maximus facilisis. Vivamus sit amet viverra urna. In euismod fringilla dolor, sit amet sagittis eros interdum non. Integer efficitur felis at magna lobortis congue. In quis condimentum augue. Sed semper massa quis purus accumsan, a varius arcu scelerisque. Nullam diam est, porttitor at varius eget, facilisis ac mi.\n" +
				"\n" +
				"Fusce consequat lectus nisl, vitae faucibus ex porttitor quis. Vestibulum non laoreet erat. Aliquam mauris magna, eleifend sit amet fermentum sed, placerat sed neque. Mauris non felis id est venenatis finibus ac nec neque. Proin blandit risus lorem, eu gravida libero porttitor sed. Mauris a finibus sapien. Ut eget erat a tellus fringilla mollis non in nibh. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam sit amet lobortis nibh.\n" +
				"\n" +
				"Donec purus lectus, rutrum quis nibh at, fermentum condimentum mi. Sed vel risus sit amet sem vehicula tristique eu in orci. Aliquam suscipit elit leo, in ultricies leo cursus vitae. Aenean vulputate, sapien ac eleifend condimentum, turpis dolor ullamcorper ligula, id viverra tortor sem nec erat. Vestibulum faucibus leo vitae felis dignissim mattis. Sed vitae dolor ligula. Vivamus dignissim dignissim tristique.\n" +
				"\n" +
				"Suspendisse quam ante, suscipit ut libero sit amet, viverra laoreet lorem. Nullam sapien leo, tempor et lacus a, venenatis vulputate lectus. Phasellus non feugiat turpis. Sed ut dapibus quam. Quisque varius id lectus ac fringilla. Cras eu tempor ipsum. Suspendisse nec convallis turpis, non dignissim velit. Aliquam molestie, ex facilisis dignissim tristique, tortor elit elementum enim, id malesuada sem quam et dui.\n" +
				"\n" +
				"In quis ullamcorper est, dapibus scelerisque tortor. Etiam interdum tortor sit amet porttitor gravida. Nunc sodales ex et enim ultrices, id varius neque porttitor. Nunc tincidunt imperdiet sagittis. Etiam et mi vitae nulla vulputate volutpat at nec arcu. Nullam lectus nulla, tempus id fermentum tincidunt, rutrum a sem. Donec pharetra, urna ac malesuada molestie, magna elit semper mauris, in facilisis ipsum risus id tortor. Mauris mattis ac eros ut ultricies. Sed tristique aliquam ante, congue euismod orci tincidunt eget. Morbi placerat libero vitae augue iaculis tempus. Vestibulum in elit id sapien lobortis aliquet. Suspendisse placerat suscipit nulla in lobortis. Cras pharetra mollis massa, sit amet placerat tellus laoreet vitae. Etiam non consectetur ipsum, sit amet scelerisque lectus. Etiam tincidunt turpis at ante malesuada vulputate. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.\n" +
				"\n" +
				"Donec a dictum erat, nec dignissim purus. Praesent odio justo, consequat quis pretium in, efficitur nec eros. Nunc vel dolor rhoncus, pulvinar justo ac, tristique nibh. Phasellus posuere aliquet mi ac molestie. Sed ultrices mi id tempor placerat. Duis et lectus eu urna eleifend posuere vel et mi. Donec rutrum tincidunt ligula ultricies egestas. Phasellus nec tellus vestibulum, feugiat mauris nec, ultrices dui. Nullam eget mi viverra orci fringilla faucibus. Mauris ac blandit magna, a cursus arcu. ");
		TextAnzeigeLösung.setAutoscrolls(true);
		panel.add(sp);
		
		btnSubmitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = comboBox.getSelectedIndex() + 1;
				String text = txtSpecificUserSubreddit.getText();
				//System.out.println("test: " + text +" " +number);
				TextAnzeigeLösung.setText(Logic.submittQuery(text, number, main));
				
			}
		});
	}
}
