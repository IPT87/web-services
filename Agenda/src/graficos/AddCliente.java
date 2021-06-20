package graficos;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graficos.Agenda.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AddCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombreTextField;
	private JTextField tratamientoTextField;
	private JTextField empleadoTextField;

	/**
	 * Create the dialog.
	 */
	public AddCliente() {
		setBounds(100, 100, 613, 598);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel labelPanelCliente = new JLabel("Nuevo cliente");
		labelPanelCliente.setFont(new Font("Stencil", Font.PLAIN, 13));
		labelPanelCliente.setBounds(244, 10, 113, 19);
		contentPanel.add(labelPanelCliente);
		
		JLabel labelNombreCliente = new JLabel("Nombre:");
		labelNombreCliente.setFont(new Font("Noto Serif", Font.PLAIN, 11));
		labelNombreCliente.setBounds(10, 74, 46, 13);
		contentPanel.add(labelNombreCliente);
		
		nombreTextField = new JTextField();
		nombreTextField.setBounds(66, 71, 497, 19);
		contentPanel.add(nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel labelTratamiento = new JLabel("Tratamiento:");
		labelTratamiento.setFont(new Font("Noto Serif", Font.PLAIN, 11));
		labelTratamiento.setBounds(10, 122, 68, 13);
		contentPanel.add(labelTratamiento);
		
		tratamientoTextField = new JTextField();
		tratamientoTextField.setBounds(88, 119, 475, 19);
		contentPanel.add(tratamientoTextField);
		tratamientoTextField.setColumns(10);
		
		JLabel labelDuracion = new JLabel("Duracion:");
		labelDuracion.setFont(new Font("Noto Serif", Font.PLAIN, 11));
		labelDuracion.setBounds(10, 165, 59, 13);
		contentPanel.add(labelDuracion);
		
		Integer[] duraciones = {15, 20, 30, 45, 60, 80, 90};
		JComboBox<Integer> duracionComboBox = new JComboBox<>(duraciones);
		duracionComboBox.setBounds(88, 161, 93, 21);
		contentPanel.add(duracionComboBox);
		
		JLabel labelEmpleado = new JLabel("Empleado:");
		labelEmpleado.setFont(new Font("Noto Sans", Font.PLAIN, 11));
		labelEmpleado.setBounds(10, 242, 68, 13);
		contentPanel.add(labelEmpleado);
		
		empleadoTextField = new JTextField();
		empleadoTextField.setText("");
		empleadoTextField.setBounds(88, 239, 475, 19);
		contentPanel.add(empleadoTextField);
		empleadoTextField.setColumns(10);
		
		JButton addClienteButton = new JButton("Guardar");
		addClienteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		addClienteButton.setBounds(244, 462, 85, 21);
		contentPanel.add(addClienteButton);
		
		addClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agenda a = new Agenda();
				Cliente cliente = a.new Cliente();
				cliente.setClientePanel(nombreTextField.getText(), tratamientoTextField.getText(), Integer.valueOf(duracionComboBox.getSelectedItem().toString()));
				AddCliente.this.dispose();
			}
		});
	}
}
