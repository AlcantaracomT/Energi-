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
        modelo = new DefaultTableModel(new String[] { "ID", "NOME", "LOCALIDADE" }, 0);
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
        inputNome.setColumns(20);

        JLabel labelLocal = new JLabel("Local do Equipamento:");
        labelLocal.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField inputLocal = new JTextField(15);
        inputLocal.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelWats = new JLabel("Watts/h do equipamento:");
        labelWats.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField inputWats = new JTextField(15);
        inputWats.setFont(new Font("Arial", Font.PLAIN, 14));

        // Botão Adicionar
        JButton addEquipamento = new JButton("Adicionar");
        addEquipamento.setBackground(new Color(70, 130, 180));
        addEquipamento.setForeground(Color.WHITE);
        addEquipamento.setFont(new Font("Arial", Font.BOLD, 14));
        // Faz o botão expandir horizontalmente
        addEquipamento.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        addEquipamento.addActionListener(e -> adicionouEquipamento(inputNome, inputLocal, inputWats));

        // Remover por ID
        JLabel labelID = new JLabel("REMOVER POR ID:");
        labelID.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField inputID = new JTextField(15);
        inputID.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton removeEquipamento = new JButton("Remover");
        removeEquipamento.setBackground(new Color(255, 0, 0));
        removeEquipamento.setForeground(Color.WHITE);
        removeEquipamento.setFont(new Font("Arial", Font.BOLD, 14));
        // Faz o botão expandir horizontalmente
        removeEquipamento.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        removeEquipamento.addActionListener(e -> removeEquipamentoPorID(inputID));

        // Adiciona os componentes ao painel
        panelAdiciona.add(labelNome);
        panelAdiciona.add(Box.createVerticalStrut(5));
        panelAdiciona.add(inputNome);
        panelAdiciona.add(Box.createVerticalStrut(10));
        panelAdiciona.add(labelLocal);
        panelAdiciona.add(Box.createVerticalStrut(5));
        panelAdiciona.add(inputLocal);
        panelAdiciona.add(Box.createVerticalStrut(15));
        panelAdiciona.add(labelWats);
        panelAdiciona.add(Box.createVerticalStrut(5));
        panelAdiciona.add(inputWats);
        panelAdiciona.add(Box.createVerticalStrut(15));
        panelAdiciona.add(addEquipamento);
        panelAdiciona.add(Box.createVerticalStrut(15));
        panelAdiciona.add(labelID);
        panelAdiciona.add(Box.createVerticalStrut(5));
        panelAdiciona.add(inputID);
        panelAdiciona.add(Box.createVerticalStrut(15));
        panelAdiciona.add(removeEquipamento);

        // Adiciona os painéis ao layout principal
        JPanel painelPrincipal = new JPanel(new GridLayout(1, 2, 10, 0));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelPrincipal.add(panelAdiciona);
        painelPrincipal.add(scrollPane);

        divAdd.add(painelPrincipal, BorderLayout.CENTER);
        divAdd.setVisible(true);
    }

    private void adicionouEquipamento(JTextField inputNome, JTextField inputLocal, JTextField inputWats) {
        String nome = inputNome.getText().trim();
        String local = inputLocal.getText().trim();
        Float wats = Float.parseFloat(inputWats.getText().trim());

        if (!nome.isEmpty() && !local.isEmpty()) {
            int id = listaEquipamentos.size() + 1;
            Equipa equipa = new Equipa(id, nome, local, wats);
            listaEquipamentos.add(equipa);
            atualizarTabelaLista();
            inputNome.setText("");
            inputLocal.setText("");
            inputWats.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeEquipamentoPorID(JTextField inputID) {
        int id = Integer.parseInt(inputID.getText().trim());
        boolean removido = false;
        for (Equipa e : listaEquipamentos) {
            if (e.getId() == id) {
                listaEquipamentos.remove(e);
                atualizarTabelaLista();
                removido = true;
                break;
            }
        }
        if (removido) {
            JOptionPane.showMessageDialog(null, "Equipamento removido com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ID não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        inputID.setText("");
    }

    private void atualizarTabelaLista() {
        modelo.setRowCount(0);
        for (Equipa e : listaEquipamentos) {
            modelo.addRow(new Object[] { e.getId(), e.getNome(), e.getLocal() });
        }
    }
}
