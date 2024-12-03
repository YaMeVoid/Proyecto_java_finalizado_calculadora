/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora_finalizada;

import javax.swing.*;

/**
 *
 * @author chett
 */
public class Calculadora_Finalizada extends JFrame {
    
    private JTextField Cajadetexto = new JTextField("");
    private JButton boton1 = new JButton("1");
    private JButton boton2 = new JButton("2");
    private JButton boton3 = new JButton("3");
    private JButton boton4 = new JButton("4");
    private JButton boton5 = new JButton("5");
    private JButton boton6 = new JButton("6");
    private JButton boton7 = new JButton("7");
    private JButton boton8 = new JButton("8");
    private JButton boton9 = new JButton("9");
    private JButton boton0 = new JButton("0");
    private JButton botonsumar = new JButton("+");
    private JButton botonRestar = new JButton("-");
    private JButton botonMultiplicar = new JButton("*");
    private JButton botonDivision = new JButton("/");
    private JButton botonBorrar = new JButton("Ce");
    private JButton botonResultado = new JButton("=");

    private double resultadoActual = 0;
    private String operacionActual = "";
    private boolean nuevaOperacion = true;

    public Calculadora_Finalizada() {
        setTitle("Calculadora"); // título de la ventana
        setSize(450, 450); // tamaño de ventana
        setLocationRelativeTo(null); // centrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Componentes(JPanel panel) {
        Cajadetexto.setBounds(20, 20, 400, 50);
        panel.add(Cajadetexto);
        
        boton7.setBounds(20, 70, 75, 75);
        panel.add(boton7);
        boton4.setBounds(20, 145, 75, 75);
        panel.add(boton4);
        boton1.setBounds(20, 220, 75, 75);
        panel.add(boton1);
        boton8.setBounds(95, 70, 75, 75);
        panel.add(boton8);
        boton5.setBounds(95, 145, 75, 75);
        panel.add(boton5);
        boton2.setBounds(95, 220, 75, 75);
        panel.add(boton2);
        boton9.setBounds(170, 70, 75, 75);
        panel.add(boton9);
        boton6.setBounds(170, 145, 75, 75);
        panel.add(boton6);
        boton3.setBounds(170, 220, 75, 75);
        panel.add(boton3);
        boton0.setBounds(95, 294, 75, 75);
        panel.add(boton0);
        botonsumar.setBounds(245, 220, 75, 75);
        panel.add(botonsumar);
        botonBorrar.setBounds(170, 294, 75, 75);
        panel.add(botonBorrar);
        botonResultado.setBounds(245, 294, 75, 75);
        panel.add(botonResultado);
        botonRestar.setBounds(245, 145, 75, 75);
        panel.add(botonRestar);
        botonDivision.setBounds(245, 70, 75, 75);
        panel.add(botonDivision);
        botonMultiplicar.setBounds(20, 294, 75, 75);
        panel.add(botonMultiplicar);

        // Asignando las acciones a los botones numéricos
        boton0.addActionListener(e -> agregarNumero("0"));
        boton1.addActionListener(e -> agregarNumero("1"));
        boton2.addActionListener(e -> agregarNumero("2"));
        boton3.addActionListener(e -> agregarNumero("3"));
        boton4.addActionListener(e -> agregarNumero("4"));
        boton5.addActionListener(e -> agregarNumero("5"));
        boton6.addActionListener(e -> agregarNumero("6"));
        boton7.addActionListener(e -> agregarNumero("7"));
        boton8.addActionListener(e -> agregarNumero("8"));
        boton9.addActionListener(e -> agregarNumero("9"));

        // Asignando las acciones a los botones de operación
        botonsumar.addActionListener(e -> realizarOperacion("+"));
        botonRestar.addActionListener(e -> realizarOperacion("-"));
        botonMultiplicar.addActionListener(e -> realizarOperacion("*"));
        botonDivision.addActionListener(e -> realizarOperacion("/"));

        // Acción para el botón de resultado
        botonResultado.addActionListener(e -> mostrarResultado());

        // Acción para el botón de borrar
        botonBorrar.addActionListener(e -> borrarPantalla());
    }

    private void agregarNumero(String numero) {
        if (nuevaOperacion) {
            Cajadetexto.setText(numero);
            nuevaOperacion = false;
        } else {
            Cajadetexto.setText(Cajadetexto.getText() + numero);
        }
    }

    private void realizarOperacion(String operacion) {
        if (!operacionActual.isEmpty()) {
            mostrarResultado();
        }
        operacionActual = operacion;
        resultadoActual = Double.parseDouble(Cajadetexto.getText());
        nuevaOperacion = true;
    }

    private void mostrarResultado() {
        double numero = Double.parseDouble(Cajadetexto.getText());
        switch (operacionActual) {
            case "+":
                resultadoActual += numero;
                break;
            case "-":
                resultadoActual -= numero;
                break;
            case "*":
                resultadoActual *= numero;
                break;
            case "/":
                if (numero != 0) {
                    resultadoActual /= numero;
                } else {
                    Cajadetexto.setText("Error");
                    return;
                }
                break;
        }
        Cajadetexto.setText(String.valueOf(resultadoActual));
        operacionActual = "";
        nuevaOperacion = true;
    }

    private void borrarPantalla() {
        Cajadetexto.setText("");
        resultadoActual = 0;
        operacionActual = "";
        nuevaOperacion = true;
    }

    public static void main(String[] args) {
        Calculadora_Finalizada ventana = new Calculadora_Finalizada();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        ventana.getContentPane().add(panel);
        ventana.Componentes(panel);
        ventana.setVisible(true);
    }
}

