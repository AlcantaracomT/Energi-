import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
         // Lista global de pessoas
        ArrayList<Equipa> listaEquipamentos = new ArrayList<>();


        setTitle("ENERGI+");
        getContentPane().setBackground(new Color(230, 230, 230));

        JLabel title = new JLabel("BEM VINDO AO SISTEMA!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(0, 20, 1100, 60);

        JButton equipamentos = new JButton("EQUIPAMENTOS");
        JButton consumo = new JButton("CONSUMO");

        // Adicionando eventos de click nos botoes
        consumo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Consumo();
            }
        });

        equipamentos.addActionListener(e -> {
            Equipamentos equipamento = new Equipamentos(listaEquipamentos);
            equipamento.exibir();
        });

        // Modelo da Tabela
        String[] colunas = { " ", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" }; // Cabeçalho

        // exemplo dados que vão vim da classe equipamentos
        Object[][] dados = {
                { "-", "Geladeira", "TV", 0, "Notebook", "TV", 0, "TV" },
                { "-", "Geladeira", "TV", 0, "Notebook", "TV", 0, "TV" },
                { "-", "Geladeira", "TV", 0, "Notebook", "TV", 0, "TV" },
                { "-", "Geladeira", "TV", 0, "Notebook", "TV", 0, "TV" },
                { "TOTAL", 0, 0, 0, 0, 0, 0, 0 },
        };
        
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(modelo);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20)); // Define fonte e tamanho

        // Personalizando a tabela
        tabela.getTableHeader().setBackground(new Color(70, 130, 180));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.setBackground(new Color(245, 245, 245));
        tabela.setRowHeight(30);

        // Adicionando cor diferente para as 3 primeiras linhas da tabela
        tabela.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column)//utilizando value(representa o valor da celula no table) e row(indice de linhas) 
            {
                JLabel label = new JLabel(value.toString());
                label.setHorizontalAlignment(SwingConstants.CENTER);
                if (row < 3)//muda a cor das 3 primeiras linhas
                    label.setBackground(new Color(255, 182, 193));
                label.setOpaque(true);
                return label;
            }
        });

        // Personalizando os botoes
        ImageIcon iconeEquipamento = new ImageIcon(getClass().getResource("/image/equipamentos.png"));
        Image imgEquipamento = iconeEquipamento.getImage();
        Image newImageEquipamento = imgEquipamento.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        equipamentos.setIcon(new ImageIcon(newImageEquipamento));
        equipamentos.setBackground(new Color(70, 130, 180));
        equipamentos.setForeground(Color.WHITE);
        equipamentos.setFocusPainted(false);

        ImageIcon iconeConsumo = new ImageIcon(getClass().getResource("/image/consumo.png"));
        Image imgConsumo = iconeConsumo.getImage();
        Image newImageConsumo = imgConsumo.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        consumo.setIcon(new ImageIcon(newImageConsumo));
        consumo.setBackground(new Color(34, 139, 34));
        consumo.setForeground(Color.WHITE);

        // add objetos na janela
        add(title);
        add(scrollPane);
        add(equipamentos);
        add(consumo);

        // Tamanho da janela, coordenadas (x,x,y,y)
        setBounds(400, 100, 1100, 800);
        scrollPane.setBounds(50, 140, 1000, 200);
        equipamentos.setBounds(50, 80, 200, 40);//botão
        consumo.setBounds(250, 80, 200, 40);
        
        //layout
        setLayout(null);// anula a coordenada padrão dos objetos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
