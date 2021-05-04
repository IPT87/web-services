package graficos;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldEmpleado;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			dialog = new LogIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setUndecorated(true);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public LogIn() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnLogInButton = new JButton("LogIn");
		btnLogInButton.setBackground(new Color(245, 255, 250));
		btnLogInButton.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		btnLogInButton.setBounds(219, 199, 85, 21);
		contentPanel.add(btnLogInButton);
		btnLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agenda.setUserName(textFieldEmpleado.getText());
				LogIn.this.dispose();
			}
		});
		
		JButton btnCancelButton = new JButton("Cancel\r\n");
		btnCancelButton.setBackground(new Color(245, 255, 250));
		btnCancelButton.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		btnCancelButton.setBounds(329, 199, 85, 21);
		contentPanel.add(btnCancelButton);
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn.this.dispose();
			}
		});
		
		JLabel lblEmpleadoLabel = new JLabel("Empleado");
		lblEmpleadoLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblEmpleadoLabel.setBounds(281, 44, 85, 13);
		contentPanel.add(lblEmpleadoLabel);
		
		textFieldEmpleado = new JTextField();
		textFieldEmpleado.setFont(new Font("Ebrima", Font.BOLD, 13));
		textFieldEmpleado.setBounds(246, 67, 149, 27);
		contentPanel.add(textFieldEmpleado);
		textFieldEmpleado.setColumns(10);
		
		JLabel lblPwdLabel = new JLabel("Contraseña");
		lblPwdLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblPwdLabel.setBounds(281, 117, 85, 13);
		contentPanel.add(lblPwdLabel);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("src/resources/depil.jpg"));
		lblNewLabel.setBounds(0, -13, 209, 316);
		contentPanel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(246, 140, 149, 27);
		contentPanel.add(passwordField);
	}
}
