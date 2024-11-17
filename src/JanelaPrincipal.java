import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        JFrame janela = new JFrame();
        janela.setTitle("ENERGI");

        JLabel title = new JLabel("BEM VINDO AO SISTEMA!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(50, 20, 800, 60);

        JButton equipamentos = new JButton("EQUIPAMENTOS");
        JButton consumo = new JButton("CONSUMO");

        // Modelo da Tabela
        String[] colunas = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" }; // Cabeçalho

        // exemplo dados que vão vim da classe equipamentos
        Object[][] dados = {
                { "Geladeira", "TV", 0, "Notebook", "TV", 0, "TV" },
        };

        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(modelo);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20)); // Define fonte e tamanho

        // Personalizando os botoes
        ImageIcon iconeEquipamento = new ImageIcon(getClass().getResource("/image/equipamentos.png"));
        Image imgEquipamento = iconeEquipamento.getImage();
        Image newImageEquipamento = imgEquipamento.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        equipamentos.setIcon(new ImageIcon(newImageEquipamento));
        equipamentos.setIconTextGap(15);
        equipamentos.setHorizontalTextPosition(SwingConstants.RIGHT);
        equipamentos.setBackground(new Color(70, 130, 180));
        equipamentos.setForeground(Color.WHITE);
        equipamentos.setFocusPainted(false);

        ImageIcon iconeConsumo = new ImageIcon(getClass().getResource("/image/consumo.png"));
        Image imgConsumo = iconeConsumo.getImage();
        Image newImageConsumo = imgConsumo.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        consumo.setIcon(new ImageIcon(newImageConsumo));
        consumo.setIconTextGap(15);
        consumo.setHorizontalTextPosition(SwingConstants.RIGHT);
        consumo.setBackground(new Color(34, 139, 34));
        consumo.setForeground(Color.WHITE);

        // add objetos na janela
        janela.add(title);
        janela.add(scrollPane);
        janela.add(equipamentos);
        janela.add(consumo);

        // Tamanho da janela
        // coordenadas (X(0,0), Y(0,0)) -> (0,0,0,0)
        scrollPane.setBounds(50, 140, 800, 120);
        janela.setBounds(800, 100, 900, 800);
        janela.setLayout(null);// anula a coordenada padrão dos objetos
        equipamentos.setBounds(50, 80, 200, 40);
        consumo.setBounds(250, 80, 200, 40);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

}
