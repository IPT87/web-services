package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {
	
	private Shape shape;
	
	private void initTimer() {
        Timer t = new Timer(10000, e -> {
            shape.repaint();
        });
        t.start();
    }
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JMenu mnUsuarioMenu = new JMenu("Usuario");

	/**
	 * Create the frame.
	 */
	public Agenda() {
		initTimer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		ImageIcon img = new ImageIcon("src/resources/icono_agenda.png");
		setIconImage(img.getImage());

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuBar.add(Box.createHorizontalGlue());

		JLabel lblMenuLabel = new JLabel();
		lblMenuLabel.setIcon(new ImageIcon("src/resources/female-avatar.png"));
		menuBar.add(lblMenuLabel);
		menuBar.add(mnUsuarioMenu);

		JMenuItem LogInMenuItem = new JMenuItem("LogIn");
		LogInMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogIn login = new LogIn();
							login.setUndecorated(true);
							login.setLocationRelativeTo(null);
							login.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		mnUsuarioMenu.add(LogInMenuItem);
		getContentPane().setLayout(null);
		getContentPane().add(shape = new Shape());

	}

	public static void setUserName(String userName) {
		
		mnUsuarioMenu.setText(userName);
	}
	
	public class Shape extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public Shape() {
			setBounds(40, 10, 1120, 610);
			
			//Falta completar el diseño
			JLabel labelHoraActual = new JLabel(drawTimeLine());
			labelHoraActual.setBounds(10, 525 + Integer.parseInt(drawTimeLine().substring(3)), 46, 13);
			getContentPane().add(labelHoraActual);
			
			JLabel label_10h = new JLabel("10:00");
			label_10h.setForeground(new Color(153, 153, 153));
			label_10h.setBounds(10, 45, 46, 13);
			getContentPane().add(label_10h);
			
			JLabel label_11h = new JLabel("11:00");
			label_11h.setForeground(new Color(153, 153, 153));
			label_11h.setBounds(10, 105, 46, 13);
			getContentPane().add(label_11h);
			
			JLabel label_12h = new JLabel("12:00");
			label_12h.setForeground(new Color(153, 153, 153));
			label_12h.setBounds(10, 165, 46, 13);
			getContentPane().add(label_12h);
			
			JLabel label_13h = new JLabel("13:00");
			label_13h.setForeground(new Color(153, 153, 153));
			label_13h.setBounds(10, 225, 46, 13);
			getContentPane().add(label_13h);
			
			JLabel label_14h = new JLabel("14:00");
			label_14h.setForeground(new Color(153, 153, 153));
			label_14h.setBounds(10, 285, 46, 13);
			getContentPane().add(label_14h);
			
			JLabel label_15h = new JLabel("15:00");
			label_15h.setForeground(new Color(153, 153, 153));
			label_15h.setBounds(10, 345, 46, 13);
			getContentPane().add(label_15h);
			
			JLabel label_16h = new JLabel("16:00");
			label_16h.setForeground(new Color(153, 153, 153));
			label_16h.setBounds(10, 405, 46, 13);
			getContentPane().add(label_16h);
			
			JLabel label_17h = new JLabel("17:00");
			label_17h.setForeground(new Color(153, 153, 153));
			label_17h.setBounds(10, 465, 46, 13);
			getContentPane().add(label_17h);
			
			JLabel label_18h = new JLabel("18:00");
			label_18h.setForeground(new Color(153, 153, 153));
			label_18h.setBounds(10, 525, 46, 13);
			getContentPane().add(label_18h);
			
			JLabel label_19h = new JLabel("19:00");
			label_19h.setForeground(new Color(153, 153, 153));
			label_19h.setBounds(10, 585, 46, 13);
			getContentPane().add(label_19h);
		}

		@Override
		public void paintComponent(Graphics g) {
			
			int pixels = 43;
			int hour = Integer.parseInt(drawTimeLine().substring(0, 2));
			int minutes = Integer.parseInt(drawTimeLine().substring(3));
			super.paintComponent(g);
			
			g.setColor(Color.LIGHT_GRAY);
			
			for (int i = 0; i < 10; i++) {
			
				g.drawLine(5, pixels, 1120, pixels);
				pixels += 60;
			}
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLUE);
			g2d.setStroke(new BasicStroke(2));
			
			switch (hour) {
			case 10:
				g.drawLine(10, (120 + minutes), 1120, (120 + minutes));
				break;
			case 11:
				g.drawLine(10, (180 + minutes), 1120, (180 + minutes));
				break;
			case 12:
				g.drawLine(10, (240 + minutes), 1120, (240 + minutes));
				break;
			case 13:
				g.drawLine(10, (300 + minutes), 1120, (300 + minutes));
				break;
			case 14:
				g.drawLine(10, (360 + minutes), 1120, (360 + minutes));
				break;
			case 15:
				g.drawLine(10, (420 + minutes), 1120, (420 + minutes));
				break;
			case 16:
				g.drawLine(10, (480 + minutes), 1120, (480 + minutes));
				break;
			case 17:
				g.drawLine(10, (540 + minutes), 1120, (540 + minutes));
				break;
			case 18:
				g.drawLine(10, (520 + minutes), 1120, (520 + minutes));
				break;
			}
		    
		}
		
}
private static String drawTimeLine() {
	
	String time = "";
	LocalDateTime dateTime = LocalDateTime.now();
	time += dateTime.getHour() + ":" + dateTime.getMinute();
	
	return time;
}
		
}
