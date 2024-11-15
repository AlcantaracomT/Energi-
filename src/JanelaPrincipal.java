import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal()
    {
        JFrame janela  = new JFrame();
        
        
        JButton equipamentos = new JButton("EQUIPAMENTOS");
        JButton consumo = new JButton("CONSUMO"); 

        // Modelo da Tabela
        String[] colunas = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" }; // Cabeçalho
        
        //exemplo dados que vão vim da classe equipamentos
        Object[][] dados = {
            { "Geladeira", "TV", 0, "Notebook"}
        };

        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20)); // Define fonte e tamanho

        
        // add objetos na janela
        janela.add(scrollPane);
        janela.add(equipamentos);
        janela.add(consumo);
        
        
        // Tamanho da janela 
        // coordenadas (X(0,0), Y(0,0)) -> (0,0,0,0)
        scrollPane.setBounds(50, 100, 800, 120);
        equipamentos.setBounds(50, 50, 150, 30);
        consumo.setBounds(250, 50, 150, 30);
        janela.setBounds(800,100,900,800);

        janela.setLayout(null);// anula a coordenada padrão dos objetos
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

}
