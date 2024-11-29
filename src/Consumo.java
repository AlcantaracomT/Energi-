import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Consumo extends JFrame {

    public Consumo(ArrayList<Equipa> listaEquipamentos, JanelaPrincipal janelaPrincipal) {
        setTitle("Consumo de Equipamentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Painel principal com Layout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        // Header
        JLabel titleHeader = new JLabel("CONSUMO", SwingConstants.CENTER);
        titleHeader.setFont(new Font("Arial", Font.BOLD, 20));
        titleHeader.setOpaque(true);
        titleHeader.setBackground(new Color(70, 130, 80));
        titleHeader.setForeground(Color.WHITE);
        panel.add(titleHeader, BorderLayout.NORTH);

        // Painel central para entrada de dados
        JPanel formPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.add(formPanel, BorderLayout.CENTER);

        // Selecione o dia
        formPanel.add(createLabel("Selecione o dia da semana"));
        JComboBox<String> comboBoxDias = new JComboBox<>(new String[]{
            "Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"
        });
        formPanel.add(comboBoxDias);

        // Selecione o equipamento
        formPanel.add(createLabel("Selecione o equipamento desejado"));
        JComboBox<String> comboBoxEquipamentos = new JComboBox<>();
        for (Equipa e : listaEquipamentos) {
            comboBoxEquipamentos.addItem(e.getNomeLocal());
        }
        formPanel.add(comboBoxEquipamentos);

        // Digite a quantidade de horas
        formPanel.add(createLabel("Digite a quantidade de Horas Ligado"));
        JTextField horasField = new JTextField();
        formPanel.add(horasField);

        // Botão Adicionar
        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.setFont(new Font("Arial", Font.BOLD, 20));
        adicionarButton.setBackground(new Color(70, 130, 80));
        adicionarButton.setForeground(Color.WHITE);
        panel.add(adicionarButton, BorderLayout.SOUTH);

        // Listener para o botão Adicionar
        adicionarButton.addActionListener((ActionEvent e) -> {
            try {
                String diaSelecionado = (String) comboBoxDias.getSelectedItem();
                String equipamentoSelecionado = (String) comboBoxEquipamentos.getSelectedItem();
                String horasTexto = horasField.getText().trim();

                if (horasTexto.isEmpty()) {
                    throw new IllegalArgumentException("Digite a quantidade de horas ligado.");
                }

                int horasLigado = Integer.parseInt(horasTexto);
                if (horasLigado <= 0) {
                    throw new IllegalArgumentException("A quantidade de horas deve ser maior que zero.");
                }

                Equipa equipaSelecionada = listaEquipamentos.stream()
                    .filter(equip -> equip.getNomeLocal().equals(equipamentoSelecionado))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Equipamento não encontrado."));

                float consumoTotal = equipaSelecionada.getWats() * horasLigado;
                String html = String.format("<html><b>%s</b><br>%.2f W</html>", equipamentoSelecionado, consumoTotal);

                janelaPrincipal.adicionarEquipamentoNaTabela(diaSelecionado, html, consumoTotal);
                JOptionPane.showMessageDialog(this, "Equipamento adicionado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Fecha a janela
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para as horas.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        return label;
    }
}
