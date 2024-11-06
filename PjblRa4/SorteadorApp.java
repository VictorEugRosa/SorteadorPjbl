import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set; 

public class SorteadorApp extends JFrame {
    private SorteadorItem sorteadorItem;
    private SorteadorIntervalo sorteadorIntervalo;
    private SorteadorPalavras sorteadorPalavras;

    public SorteadorApp() {
        sorteadorItem = new SorteadorItem();
        sorteadorIntervalo = new SorteadorIntervalo();
        sorteadorPalavras = new SorteadorPalavras();

        setTitle("Escolha o Modo de Sorteio");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        JLabel titleLabel = new JLabel("Selecione o Modo de Sorteio");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(new Color(63, 81, 181));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton sorteioItemButton = new JButton("Sorteio de Itens");
        estilizarBotao(sorteioItemButton, new Color(33, 150, 243));
        sorteioItemButton.addActionListener(e -> abrirInterfaceSorteioItem());

        JButton sorteioIntervaloButton = new JButton("Sorteio por Intervalo");
        estilizarBotao(sorteioIntervaloButton, new Color(76, 175, 80));
        sorteioIntervaloButton.addActionListener(e -> abrirInterfaceSorteioIntervalo());

        JButton sorteioPalavrasButton = new JButton("Sorteio de Palavras");
        estilizarBotao(sorteioPalavrasButton, new Color(156, 39, 176));
        sorteioPalavrasButton.addActionListener(e -> abrirInterfaceSorteioPalavras());

        buttonPanel.add(sorteioItemButton);
        buttonPanel.add(sorteioIntervaloButton);
        buttonPanel.add(sorteioPalavrasButton);

        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void estilizarBotao(JButton botao, Color corFundo) {
        botao.setFont(new Font("SansSerif", Font.BOLD, 16));
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(corFundo.darker(), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
    }

    private void abrirInterfaceSorteioItem() {
        JFrame itemFrame = new JFrame("Sorteador de Itens");
        itemFrame.setSize(600, 500);
        itemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        itemFrame.setLayout(new BorderLayout(10, 10));
        itemFrame.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField inputField = new JTextField(15);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultado"));

        JButton addButton = new JButton("Adicionar Item");
        estilizarBotao(addButton, new Color(33, 150, 243));
        addButton.addActionListener(e -> {
            String item = inputField.getText();
            if (!item.isEmpty()) {
                sorteadorItem.adicionarItem(item);
                resultArea.append("Item Adicionado: " + item + "\n"); 
                inputField.setText("");
            } else {
                JOptionPane.showMessageDialog(itemFrame, "Por favor, insira um item.");
            }
        });

        JButton sortearButton = new JButton("Sortear Item");
        estilizarBotao(sortearButton, new Color(76, 175, 80));
        sortearButton.addActionListener(e -> {
            String resultado = sorteadorItem.sortearItem();
            resultArea.append(resultado + "\n"); 
        });

        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(sortearButton);

        itemFrame.add(inputPanel, BorderLayout.NORTH);
        itemFrame.add(scrollPane, BorderLayout.CENTER);
        itemFrame.setVisible(true);
    }

    private void abrirInterfaceSorteioIntervalo() {
        JFrame intervaloFrame = new JFrame("Sorteio por Intervalo");
        intervaloFrame.setSize(700, 550);
        intervaloFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        intervaloFrame.setLayout(new BorderLayout(10, 10));
        intervaloFrame.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField minField = new JTextField(5);
        JTextField maxField = new JTextField(5);
        JTextField quantField = new JTextField(5);
        JLabel resultLabel = new JLabel("Resultado:");

        inputPanel.add(new JLabel("Mínimo:"));
        inputPanel.add(minField);
        inputPanel.add(new JLabel("Máximo:"));
        inputPanel.add(maxField);
        inputPanel.add(new JLabel("Quantidade:"));
        inputPanel.add(quantField);

        JButton sortearButton = new JButton("Sortear");
        estilizarBotao(sortearButton, new Color(76, 175, 80));
        sortearButton.addActionListener(e -> {
            try {
                int min = Integer.parseInt(minField.getText());
                int max = Integer.parseInt(maxField.getText());
                int quantidade = Integer.parseInt(quantField.getText());
                Set<Integer> resultado = sorteadorIntervalo.sortearIntervalo(min, max, quantidade);
                resultLabel.setText("Resultado: " + resultado.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(intervaloFrame, "Digite números válidos.");
            }
        });

        intervaloFrame.add(inputPanel, BorderLayout.NORTH);
        intervaloFrame.add(resultLabel, BorderLayout.CENTER);
        intervaloFrame.add(sortearButton, BorderLayout.SOUTH);
        intervaloFrame.setVisible(true);
    }

    private void abrirInterfaceSorteioPalavras() {
        JFrame palavrasFrame = new JFrame("Sorteio de Palavras");
        palavrasFrame.setSize(700, 550);
        palavrasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        palavrasFrame.setLayout(new BorderLayout(10, 10));
        palavrasFrame.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField inputField = new JTextField(15);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultado"));

        JButton addButton = new JButton("Adicionar Palavra");
        estilizarBotao(addButton, new Color(33, 150, 243));
        addButton.addActionListener(e -> {
            String palavra = inputField.getText();
            if (!palavra.isEmpty()) {
                sorteadorPalavras.adicionarPalavra(palavra);
                resultArea.append("Palavra Adicionada: " + palavra + "\n");
                inputField.setText("");
            } else {
                JOptionPane.showMessageDialog(palavrasFrame, "Por favor, insira uma palavra.");
            }
        });

        JButton sortearButton = new JButton("Sortear Palavra");
        estilizarBotao(sortearButton, new Color(76, 175, 80));
        sortearButton.addActionListener(e -> {
            try {
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog(palavrasFrame, "Quantas palavras sortear?"));
                List<String> resultado = sorteadorPalavras.sortearPalavras(quantidade);
                resultArea.append("Resultado: " + resultado.toString() + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(palavrasFrame, "Digite um número válido.");
            }
        });

        inputPanel.add(new JLabel("Palavra:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(sortearButton);

        palavrasFrame.add(inputPanel, BorderLayout.NORTH);
        palavrasFrame.add(scrollPane, BorderLayout.CENTER);
        palavrasFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SorteadorApp app = new SorteadorApp();
            app.setVisible(true);
        });
    }
}
