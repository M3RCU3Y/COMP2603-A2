import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SanctuaryGUI extends JFrame {
    private Sanctuary sanctuary;
    private JTextField nameField;
    private JComboBox<String> typeCombo;
    private JCheckBox injuredCheck;
    private JButton searchButton;
    private JTextArea resultArea;
    private JLabel statusLabel;

    public SanctuaryGUI() {
        super("Caribbean Wildlife Conservation Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Search:"));
        nameField = new JTextField(14);
        topPanel.add(nameField);
        topPanel.add(new JLabel("Type:"));
        String[] types = {"All", "Bird", "Reptile", "Marine"};
        typeCombo = new JComboBox<String>(types);
        topPanel.add(typeCombo);
        injuredCheck = new JCheckBox("Injured/Critical only");
        topPanel.add(injuredCheck);



        searchButton = new JButton("Search");
        topPanel.add(searchButton);


        add(topPanel, BorderLayout.NORTH);
        resultArea = new JTextArea();
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setEditable(false);


        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);


        statusLabel = new JLabel("Ready");

        add(statusLabel, BorderLayout.SOUTH);


        searchButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                runSearch();
            }
        });

        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                runSearch();
            }
        });

        setLocationRelativeTo(null);
    }

    public void setModel(Sanctuary s) {
        sanctuary = s;

        if (sanctuary != null) {
            setTitle("Caribbean Wildlife Conservation Tracker - " + sanctuary.getName());
            runSearch();
        } 
    }

    private void runSearch() { 
        if (sanctuary == null) {
            resultArea.setText(""); 
            statusLabel.setText("No sanctuary loaded");
            return;
        }

        String searchText = nameField.getText().trim().toLowerCase();
        String selectedType = (String) typeCombo.getSelectedItem();
        boolean injuredOnly = injuredCheck.isSelected(); 

        String output = "";
        int count = 0;

        ArrayList<Animal> animals = sanctuary.getAnimals();

        for (int i = 0; i < animals.size(); i++) {
            Animal current = animals.get(i);
            boolean keepAnimal = true;

            if (!searchText.equals("")) {
                String species = current.getSpecies().toLowerCase();
                String nickname = current.getNickname().toLowerCase();
                if (!species.contains(searchText) && !nickname.contains(searchText)) {
                    keepAnimal = false;
                }
            }
            if (!selectedType.equals("All")) {
                if (!current.getType().equals(selectedType)) {
                    keepAnimal = false;
                }
            }
            if (injuredOnly) {
                String health = current.getHealthStatus();

                if (!health.equals("Injured") && !health.equals("Critical")) {
                    keepAnimal = false;
                }
            }
            if (keepAnimal) {
                output = output + current.toString() + "\n";
                count++;
            }
        }

        resultArea.setText(output);
        if (count == 0) {
            statusLabel.setText("No matches");
        } else if (count == 1) {
            statusLabel.setText("1 result");
        } else {
            statusLabel.setText(count + " results");
        }
    }





    
    public static void main(String[] args) { 


        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Bird ruby = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird blaze = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird dusty = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile brutus = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile medusa = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine atlas = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(ruby);
        caroni.addAnimal(blaze);
        caroni.addAnimal(dusty);
        caroni.addAnimal(brutus);
        caroni.addAnimal(medusa);
        caroni.addAnimal(atlas); 
        SanctuaryGUI gui = new SanctuaryGUI();
        gui.setModel(caroni);
        gui.setVisible(true);
    }
}