import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Editor {
	public static void main(String[] args) {
		
		ClockLabel date = new ClockLabel("date");
		ClockLabel time = new ClockLabel("time");
		ClockLabel day = new ClockLabel("day");
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Clock");
		frame.setSize(300,150);
		frame.getContentPane().setLayout(new GridLayout(3,1));
		frame.setVisible(true);
		
		frame.getContentPane().add(date);
		frame.getContentPane().add(time);
		frame.getContentPane().add(day);
		frame.getContentPane().setBackground(Color.black);
	}
}

class ClockLabel extends JLabel implements ActionListener {
	
	String type;
	SimpleDateFormat sdf;
	
	public ClockLabel(String type) {
		
		this.type = type;
		setForeground(Color.green);
		
		switch(type) {
		
		case "date" : sdf = new SimpleDateFormat("MMMM dd YYYY");
				setFont(new Font("sans-sarif",Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				break;
				
		case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
				setFont(new Font("sans-sarif",Font.PLAIN, 40));
				setHorizontalAlignment(SwingConstants.CENTER);
				break;
				
		case "day" : sdf = new SimpleDateFormat("EEEE ");
				setFont(new Font("sans-sarif",Font.PLAIN, 16));
				setHorizontalAlignment(SwingConstants.RIGHT);
				break;
				
		default : sdf = new SimpleDateFormat();
				break;
		
		}
		
		Timer timer = new Timer(1000, this);
		timer.start();
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		Date d = new Date();
		setText(sdf.format(d));
		
	}
}
