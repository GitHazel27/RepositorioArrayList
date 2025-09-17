

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI_ejercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<String> alumnos = new ArrayList<>(); // ArrayList para guardar alumnos

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ejercicio frame = new GUI_ejercicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_ejercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alumnos");
		lblNewLabel.setBounds(44, 28, 89, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(44, 70, 70, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(124, 67, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Botón Agregar
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				if(!nombre.isEmpty()) {
					alumnos.add(nombre);
					JOptionPane.showMessageDialog(null, "Alumno agregado: " + nombre);
					textField.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor ingresa un nombre");
				}
			}
		});
		btnNewButton.setBounds(44, 122, 85, 21);
		contentPane.add(btnNewButton);
		
		// Botón Buscar
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				if(alumnos.contains(nombre)) {
					JOptionPane.showMessageDialog(null, "El alumno '" + nombre + "' SÍ está registrado");
				} else {
					JOptionPane.showMessageDialog(null, "El alumno '" + nombre + "' NO está registrado");
				}
			}
		});
		btnNewButton_1.setBounds(190, 122, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
