import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JLabel titleLabel;
    private final JTextArea fortuneTextArea;
    private final JButton readFortuneButton;
    private final JButton quitButton;

    private final ArrayList<String> fortunes;
    private int lastDisplayedFortuneIndex;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 36));

        fortuneTextArea = new JTextArea(10, 30);
        fortuneTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);

        readFortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");

        // Initialize the fortunes array
        fortunes = new ArrayList<>();
        fortunes.add("Fortune 1: You will find happiness in unexpected places.");
        fortunes.add("Fortune 2: A surprise awaits you in the near future.");
        fortunes.add("Fortune 3: Your creativity will lead to success.");
        fortunes.add("Fortune 4:A new opportunity will come your way soon.");
        fortunes.add("Fortune 5:Take a risk, and you will be rewarded.");
        fortunes.add("Fortune 6:Good fortune will come to you in unexpected ways.");
        fortunes.add("Fortune 7:Your hard work will pay off in the end.");
        // Add more fortunes as needed

        lastDisplayedFortuneIndex = -1; // Initialize to an invalid index

        // Add components to the frame using BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readFortuneButton);
        buttonPanel.add(quitButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners using lambda expressions
        readFortuneButton.addActionListener(e -> readFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void readFortune() {
        if (fortunes.isEmpty()) {
            fortuneTextArea.setText("No more fortunes available.");
            return;
        }

        int randomIndex;
        do {
            randomIndex = new Random().nextInt(fortunes.size());
        } while (randomIndex == lastDisplayedFortuneIndex);

        String fortune = fortunes.get(randomIndex);
        fortuneTextArea.append(fortune + "\n");
        lastDisplayedFortuneIndex = randomIndex;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}