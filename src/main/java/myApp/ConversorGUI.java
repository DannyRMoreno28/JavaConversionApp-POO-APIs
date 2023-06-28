package myApp;

//Importar clases necesarias
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase principal ConversorGUI
public class ConversorGUI {

	public static void main(String[] args) {
		// Crear ventana principal de la APP
		final JFrame frame = new JFrame("Conversor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		// Crear paneles para contener botones y otros componentes
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		// Crear botones
		JButton boton1 = new JButton("Moneda");
		JButton boton2 = new JButton("Temperatura");
		JButton boton3 = new JButton("Longitud");

		// Crear botones para cada tipo de conversión
		panel1.add(boton1);
		panel1.add(boton2);
		panel1.add(boton3);

		// A�adir botones al panel1
		frame.getContentPane().add(panel1, "North");
		frame.getContentPane().add(panel2, "South");

		// Hacer visible la ventana
		frame.setVisible(true);

		// --- Manejar eventos de los botones cuando estos sean accionados ---

		// Boton 1 - Acci�n para el bot�n de conversi�n de moneda
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  Crear una instancia de ConversorDivisasGUI para la conversi�n de divisas
				ConversorDivisasGUI conversorDivisas = new ConversorDivisasGUI();
			}
		});

		// Boton 2 - Acci�n para el bot�n de conversi�n de temperatura
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar cuadro de di�logo para ingresar la cantidad a convertir
				final String cantidadString = JOptionPane.showInputDialog(frame, "Introduce la cantidad a convertir:");
				double cantidad = Double.parseDouble(cantidadString);

				// Mostrar cuadro de di�logo para seleccionar unidades de temperatura
				Object[] opciones = ConversorTemperatura.UnidadTemperatura.values();
				ConversorTemperatura.UnidadTemperatura unidadOrigen = (ConversorTemperatura.UnidadTemperatura) JOptionPane
						.showInputDialog(frame, "Selecciona la unidad de origen:", "Conversi�n de temperatura",
								JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
				ConversorTemperatura.UnidadTemperatura unidadDestino = (ConversorTemperatura.UnidadTemperatura) JOptionPane
						.showInputDialog(frame, "Selecciona la unidad de destino:", "Conversi�n de temperatura",
								JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

				// Realizar la conversi�n de temperatura
				ConversorTemperatura conversor = new ConversorTemperatura(unidadOrigen, unidadDestino);
				double resultado = conversor.convertir(cantidad);

				// Mostrar el resultado en un cuadro de di�logo
				JOptionPane.showMessageDialog(frame,
						cantidad + " " + unidadOrigen + " = " + resultado + " " + unidadDestino);
			}
		});

		// Boton 3 - Acci�n para el bot�n de conversi�n de longitud
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar cuadro de di�logo para ingresar la cantidad a convertir
				String cantidadString = JOptionPane.showInputDialog(frame, "Introduce la cantidad a convertir:");
				double cantidad = Double.parseDouble(cantidadString);

				// Mostrar cuadro de di�logo para seleccionar unidades de longitud
				Object[] opciones = ConversorLongitud.UnidadLongitud.values();
				ConversorLongitud.UnidadLongitud unidadOrigen = (ConversorLongitud.UnidadLongitud) JOptionPane
						.showInputDialog(frame, "Selecciona la unidad de origen:", "Conversi�n de longitud",
								JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
				ConversorLongitud.UnidadLongitud unidadDestino = (ConversorLongitud.UnidadLongitud) JOptionPane
						.showInputDialog(frame, "Selecciona la unidad de destino:", "Conversi�n de longitud",
								JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

				// Realizar la conversi�n de la longitud
				ConversorLongitud conversor = new ConversorLongitud(unidadOrigen, unidadDestino);
				double resultado = conversor.convertir(cantidad);

				// Mostrar el resultado en un cuadro de di�logo
				JOptionPane.showMessageDialog(frame,
						cantidad + " " + unidadOrigen+"S" + " = " + resultado + " " + unidadDestino+"S");
			}
		});
	}

	// Clase interna para el conversor de divisas (Nueva ventana para el calculo de la conversi�n de divisas)
	static class ConversorDivisasGUI extends JFrame implements ActionListener {
		// Declaraci�n de componentes de la GUI
		private JTextField baseCurrencyField;
		private JTextField targetCurrencyField;
		private JTextField amountField;
		private JButton convertButton;
		private JLabel resultLabel;

		// Constructor de la clase ConversorDivisasGUI
		public ConversorDivisasGUI() {
			// Configuraci�n de la ventana
			setTitle("Conversor de divisas");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			// Crear panel principal y configurar su layout
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints();

			// Establecer el tama�o m�nimo y preferido del panel principal
			mainPanel.setMinimumSize(new Dimension(300, 200));
			mainPanel.setPreferredSize(new Dimension(300, 200));

			// Crear e inicializar componentes de la GUI
			baseCurrencyField = new JTextField(5);
			targetCurrencyField = new JTextField(5);
			amountField = new JTextField(5);
			convertButton = new JButton("Convertir");
			resultLabel = new JLabel("Resultado: ");

			// Agregar componentes al panel principal usando GridBagConstraints. Aqu� se
			// agregan los JLabel,
			// JTextFields y JButton con sus respectivas posiciones y configuraciones en el
			// panel principal
			constraints.gridx = 0;
			constraints.gridy = 0;
			mainPanel.add(new JLabel("Moneda base:"), constraints);

			constraints.gridx = 1;
			constraints.gridy = 0;
			mainPanel.add(baseCurrencyField, constraints);
			constraints.insets = new Insets(0, 0, 10, 0); // Espacio en la parte inferior de 10 p�xeles
			mainPanel.add(baseCurrencyField, constraints);

			constraints.gridx = 0;
			constraints.gridy = 1;
			mainPanel.add(new JLabel("Moneda objetivo:"), constraints);

			constraints.gridx = 1;
			constraints.gridy = 1;
			mainPanel.add(targetCurrencyField, constraints);
			constraints.insets = new Insets(0, 0, 10, 0); // Espacio en la parte inferior de 10 p�xeles
			mainPanel.add(targetCurrencyField, constraints);

			constraints.gridx = 0;
			constraints.gridy = 2;
			mainPanel.add(new JLabel("Monto:"), constraints);

			constraints.gridx = 1;
			constraints.gridy = 2;
			mainPanel.add(amountField, constraints);
			constraints.insets = new Insets(0, 0, 10, 0); // Espacio en la parte inferior de 10 p�xeles
			mainPanel.add(amountField, constraints);

			constraints.gridx = 1;
			constraints.gridy = 3;
			constraints.gridwidth = 5;
			constraints.anchor = GridBagConstraints.WEST;
			mainPanel.add(convertButton, constraints);

			constraints.gridx = 0;
			constraints.gridy = 4;
			constraints.gridwidth = 2;
			constraints.anchor = GridBagConstraints.WEST;
			mainPanel.add(resultLabel, constraints);

			// Agregar el panel principal a la ventana
			getContentPane().add(mainPanel);

			// Agregar el ActionListener al bot�n de conversi�n
			convertButton.addActionListener(this);

			// Ajustar el tama�o de la ventana seg�n los componentes y hacerla visible
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
		}

		// M�todo que maneja la acci�n del bot�n de conversi�n
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == convertButton) {
				// Obtener la moneda base, la moneda objetivo y el monto a convertir
				String baseCurrency = baseCurrencyField.getText().toUpperCase();
				String targetCurrency = targetCurrencyField.getText().toUpperCase();
				double amount = Double.parseDouble(amountField.getText());

				try {
					// Crear una instancia de ConversorMoneda y realizar la conversi�n
					ConversorMoneda conversorMoneda = new ConversorMoneda();
					double convertedAmount = conversorMoneda.convertCurrency(baseCurrency, targetCurrency, amount);
					// Mostrar el resultado en la etiqueta
					resultLabel.setText(String.format("Resultado: %.2f %s", convertedAmount, targetCurrency));
				} catch (Exception ex) {
					// Mostrar un mensaje de error en caso de excepci�n
					JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
