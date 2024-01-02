

/*
 *                 Remember that sentence well 
 *  The biggest secret to success is the importance of time awareness
 *  
 */



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Splash_Screen extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	ImageIcon image = new ImageIcon("images.png");

	JPanel panel = new JPanel();

	JButton button_start;
	JButton button_reset;

	JLabel label = new JLabel();
	JLabel labeloo = new JLabel();

	JLabel label_hours = new JLabel();
	JLabel label_2_hours = new JLabel(":");
	JLabel label_minutes = new JLabel();
	JLabel label_3_minutes = new JLabel(":");
	JLabel label_seconds = new JLabel();
	JLabel label_4_seconds = new JLabel(":");
	
	JLabel label_hr = new JLabel("hr");
	JLabel label_min = new JLabel("min");
	JLabel label_sec = new JLabel("sec");

	int elapsedTime = 0, seconds = 0, minutes = 0, hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

	public void SET_FORMATE() {
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
	}

	Timer timer = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			elapsedTime = elapsedTime + 1000;
			hours = (elapsedTime / 3600000);
			minutes = (elapsedTime / 60000) % 60;
			seconds = (elapsedTime / 1000) % 60;

			SET_FORMATE();

			label_hours.setText(hours_string);
			label_minutes.setText(minutes_string);
			label_seconds.setText(seconds_string);

		}

	});

	/************************* Constrator **********************************/
	Splash_Screen() {

		panel.setBackground(Color.GRAY);
		panel.setLayout(null);

		label_hours.setText(hours_string);
		label_hours.setFont(new Font("Verdana", Font.PLAIN, 35));
		label_hours.setBorder(BorderFactory.createBevelBorder(1));
		label_hours.setOpaque(true);

		label_minutes.setText(minutes_string);
		label_minutes.setFont(new Font("Verdana", Font.PLAIN, 35));
		label_minutes.setBorder(BorderFactory.createBevelBorder(1));
		label_minutes.setOpaque(true);

		label_seconds.setText(seconds_string);
		label_seconds.setFont(new Font("Verdana", Font.PLAIN, 35));
		label_seconds.setBorder(BorderFactory.createBevelBorder(1));
		label_seconds.setOpaque(true);

		label_2_hours.setBounds(72, 15, 10, 40);
		label_2_hours.setFont(new Font("Verdana", Font.PLAIN, 20));

		label_3_minutes.setBounds(147, 15, 10, 40);
		label_3_minutes.setFont(new Font("Verdana", Font.PLAIN, 20));

		label_hours.setBounds(15, 15, 50, 40);
		label_minutes.setBounds(90, 15, 50, 40);
		label_seconds.setBounds(165, 15, 50, 40);
		
		label_hr.setBounds(33, 50, 50, 40);
		panel.add(label_hr);
		
		label_min.setBounds(105, 50, 50, 40);
		panel.add(label_min);
		
		label_sec.setBounds(180, 50, 50, 40);
		panel.add(label_sec);
		
		panel.setBounds(80, 30, 230, 80);

		panel.add(label_hours);
		panel.add(label_2_hours);

		panel.add(label_minutes);
		panel.add(label_3_minutes);

		panel.add(label_seconds);

		this.add(panel);

		Border line = BorderFactory.createLineBorder(Color.CYAN, 5);
		label.setBorder(line);
		this.add(label);

		this.setSize(400, 250);
		this.setLocation(510, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(0x123456));
		this.setTitle("FOCUS EA ZEZO");
		this.setIconImage(image.getImage());
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);

		button_start = new JButton("START");
		button_reset = new JButton("RESET");
		button_start.setFocusable(false);
		button_reset.setFocusable(false);
		button_start.setBorder(BorderFactory.createLineBorder(Color.blue));
		button_reset.setBorder(BorderFactory.createLineBorder(Color.cyan));
		button_start.setBackground(Color.white);
		button_reset.setBackground(Color.white);
		button_start.setForeground(Color.blue);
		button_reset.setForeground(Color.cyan);
		button_start.setFont(new Font("MV Boli", Font.BOLD, 15));
		button_reset.setFont(new Font("MV Boli", Font.BOLD, 15));
		this.add(button_start);
		this.add(button_reset);
		button_start.setBounds(100, 150, 80, 30);
		button_reset.setBounds(200, 150, 80, 30);

		button_start.addActionListener(this);
		button_reset.addActionListener(this);

//******************************End_Constraor******************************************//       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_start) {
			if (started == false) {
				started = true;
				button_start.setText("STOP");
				button_start.setForeground(Color.red);
				button_start.setBorder(BorderFactory.createLineBorder(Color.red));
				timer.start();
			}

			else {
				started = false;
				button_start.setForeground(Color.blue);
				button_start.setBorder(BorderFactory.createLineBorder(Color.blue));

				button_start.setText("START");
				timer.stop();
			}
		}
//**************************************************************//
		if (e.getSource() == button_reset) {
			started = false;
			button_start.setText("START");
			button_start.setForeground(Color.blue);
			button_start.setBorder(BorderFactory.createLineBorder(Color.blue));

			timer.stop();
			elapsedTime = 0;
			seconds = 0;
			minutes = 0;
			hours = 0;
			SET_FORMATE();

			label_hours.setText(hours_string);
			label_minutes.setText(minutes_string);
			label_seconds.setText(seconds_string);

		}

	}
}
