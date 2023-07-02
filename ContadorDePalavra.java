import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorDePalavra extends JFrame {
    private JLabel caracteresLabel;
    private JLabel palavrasLabel;
    private JTextArea textoTextArea;

    public ContadorDePalavra() {
        setTitle("Contador de Palavras");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        caracteresLabel = new JLabel("Número de caracteres: 0");
        palavrasLabel = new JLabel("Número de palavras: 0");
        textoTextArea = new JTextArea(10, 30);
        JButton contarButton = new JButton("Contar");

        Font fonte = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
        caracteresLabel.setFont(fonte);
        palavrasLabel.setFont(fonte);
        textoTextArea.setFont(fonte);
        contarButton.setFont(fonte);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(Box.createVerticalGlue()); 
        painelCentral.add(contarButton);
        painelCentral.add(caracteresLabel);
        painelCentral.add(palavrasLabel);
        painelCentral.add(Box.createVerticalGlue()); 

        setLayout(new BorderLayout());
        add(painelCentral, BorderLayout.CENTER);
        add(new JScrollPane(textoTextArea), BorderLayout.SOUTH); 

        contarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = textoTextArea.getText();
                int numeroCaracteres = contarCaracteres(texto);
                int numeroPalavras = contarPalavras(texto);

                caracteresLabel.setText("Número de caracteres: " + numeroCaracteres);
                palavrasLabel.setText("Número de palavras: " + numeroPalavras);
            }
        });
    }

    public static int contarCaracteres(String texto) {
        return texto.length();
    }

    public static int contarPalavras(String texto) {
        String[] palavras = texto.split("\\s+");
        return palavras.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ContadorDePalavra frame = new ContadorDePalavra();
                frame.setVisible(true);
            }
        });
    }
}
