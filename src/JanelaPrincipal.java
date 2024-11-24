import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        // Lista global de equipamentos
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
                new Consumo(listaEquipamentos);
            }
        });

        equipamentos.addActionListener(e -> {
            Equipamentos equipamento = new Equipamentos(listaEquipamentos);
            equipamento.exibir();
        });

        // Definindo os dias da semana
        String[] diasSemana = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" };

        // Cabeçalho da tabela
        String[] colunas = { "Equipamento", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" };

        // Modelo da Tabela
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        atualizarTabela(listaEquipamentos, modelo, diasSemana);

        // Personalizando a tabela
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabela.getTableHeader().setBackground(new Color(70, 130, 180));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.setRowHeight(25);

        // Personalizando os botoes
        equipamentos.setBackground(new Color(70, 130, 180));
        equipamentos.setForeground(Color.WHITE);
        consumo.setBackground(new Color(34, 139, 34));
        consumo.setForeground(Color.WHITE);

        // Adicionando objetos na janela
        add(title);
        add(scrollPane);
        add(equipamentos);
        add(consumo);

        // Tamanho da janela, coordenadas (x,x,y,y)
        setBounds(400, 100, 1100, 800);
        scrollPane.setBounds(50, 140, 1000, 200);
        equipamentos.setBounds(50, 80, 200, 40);
        consumo.setBounds(250, 80, 200, 40);

        // layout
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método para atualizar a tabela com o consumo
    private void atualizarTabela(ArrayList<Equipa> listaEquipamentos, DefaultTableModel modelo, String[] diasSemana) {
        modelo.setRowCount(0);  // Limpa as linhas da tabela

        // Adicionar os dados na tabela, ordenados pelo maior consumo de cada dia
        for (Equipa e : listaEquipamentos) {
            // Preparando os dados para cada equipamento
            Object[] rowData = new Object[8];
            rowData[0] = e.getNomeLocal();

            // Preencher os consumos para cada dia
            for (int i = 0; i < diasSemana.length; i++) {
                String dia = diasSemana[i];
                // Consumo de cada equipamento para o dia da semana
                Float consumo = e.getConsumoDiario().getOrDefault(dia, 0f);
                rowData[i + 1] = consumo;
            }

            modelo.addRow(rowData);
        }

        // Ordenar as linhas da tabela para mostrar o maior consumo em primeiro lugar (em cada coluna)
        for (int col = 1; col <= 7; col++) {
            int finalCol = col;
            Collections.sort(listaEquipamentos, new Comparator<Equipa>() {
                @Override
                public int compare(Equipa e1, Equipa e2) {
                    return Float.compare(e2.getConsumoDiario().getOrDefault(diasSemana[finalCol - 1], 0f),
                                         e1.getConsumoDiario().getOrDefault(diasSemana[finalCol - 1], 0f));
                }
            });
        }
    }
}
