import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Equipamentos extends JFrame {
    private ArrayList<Equipa> listaEquipamentos;
    private JFrame divAdd;
    private DefaultTableModel modelo;

    public Equipamentos(ArrayList<Equipa> listaEquipamentos) {
        this.listaEquipamentos = listaEquipamentos != null ? listaEquipamentos : new ArrayList<>();
    }

    public void exibir() {
        divAdd = new JFrame("Gerenciamento de Equipamentos");
        divAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        divAdd.setSize(800, 600);
        divAdd.setLayout(new BorderLayout(10, 10));
        divAdd.setLocationRelativeTo(null);

        // Painel da Tabela (lado direito)
        modelo = new DefaultTableModel(new String[]{"ID", "NOME", "LOCALIDADE"}, 0);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        atualizarTabelaLista();

        // Estilo da tabela
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabela.getTableHeader().setBackground(new Color(70, 130, 180));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.setRowHeight(25);

        // Painel de Entrada de Dados (lado esquerdo)
        JPanel panelAdiciona = new JPanel();
        panelAdiciona.setLayout(new BoxLayout(panelAdiciona, BoxLayout.Y_AXIS));
        panelAdiciona.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelNome = new JLabel("Nome do Equipamento:");
        labelNome.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField inputNome = new JTextField(15);
        inputNome.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelLocal = new JLabel("Local do Equipamento:");
        labelLocal.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField inputLocal = new JTextField(15);
        inputLocal.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton addEquipamento = new JButton("Adicionar");
        addEquipamento.setBackground(new Color(70, 130, 180));
        addEquipamento.setForeground(Color.WHITE);
        addEquipamento.setFont(new Font("Arial", Font.BOLD, 14));
        addEquipamento.addActionListener(e -> adicionouEquipamento(inputNome, inputLocal));

        panelAdiciona.add(labelNome);
        panelAdiciona.add(Box.createVerticalStrut(5));
        panelAdiciona.add(inputNome);
        panelAdiciona.add(Box.createVerticalStrut(10));
        panelAdiciona.add(labelLocal);
        panelAdiciona.add(Box.createVerticalStrut(5));
        panelAdiciona.add(inputLocal);
        panelAdiciona.add(Box.createVerticalStrut(15));
        panelAdiciona.add(addEquipamento);

        // Adiciona os painéis ao layout principal
        JPanel painelPrincipal = new JPanel(new GridLayout(1, 2, 10, 0));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelPrincipal.add(panelAdiciona);
        painelPrincipal.add(scrollPane);

        divAdd.add(painelPrincipal, BorderLayout.CENTER);
        divAdd.setVisible(true);
    }

    private void adicionouEquipamento(JTextField inputNome, JTextField inputLocal) {
        String nome = inputNome.getText().trim();
        String local = inputLocal.getText().trim();

        if (!nome.isEmpty() && !local.isEmpty()) {
            int id = listaEquipamentos.size() + 1;
            Equipa equipa = new Equipa(id, nome, local);
            listaEquipamentos.add(equipa);
            atualizarTabelaLista();
            inputNome.setText("");
            inputLocal.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabelaLista() {
        modelo.setRowCount(0);
        for (Equipa e : listaEquipamentos) {
            modelo.addRow(new Object[]{e.getId(), e.getNome(), e.getNome()});
        }
    }
}
