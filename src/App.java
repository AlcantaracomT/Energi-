import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame janela  = new JFrame();
        
        JLabel dias = new JLabel("Segunda  |  Terça  |  Quarta  |  Quinta  |  Sexta  |  Sabado  |  Domingo");
        dias.setFont(new Font("Arial", Font.PLAIN, 24));// tamanho das letras
        
        JButton equipamentos = new JButton("EQUIPAMENTOS");
        JButton consumo = new JButton("CONSUMO"); 

        // add objetos na janela
        janela.add(dias);
        janela.add(equipamentos);
        janela.add(consumo);
        
        
        // Tamanho da janela 
        // coordenadas (X(0,0), Y(0,0)) -> (0,0,0,0)
        equipamentos.setBounds(50, 50, 150, 30);
        consumo.setBounds(250, 50, 150, 30);
        dias.setBounds(50, 100, 800, 30);
        janela.setBounds(800,100,900,800);

        janela.setLayout(null);// anula a coordenada padrão dos objetos
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}
