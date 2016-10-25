package name.lplade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by lade on 10/25/16.
 */
public class PetSurvey extends JFrame {
    private JPanel rootPanel;
    private JCheckBox dogCheckBox;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    private boolean fish, cat, dog;

    PetSurvey(){
        setContentPane(rootPanel);
        pack();
        setSize(350,200);
        setTitle("Pet Survey");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);

                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults(){
        String hasDog = dog ? "one dog" : "no dogs";
        String hasCat = cat ? "one cat" : "no cats";
        String hasFish = fish ? "one fish" : "no fish";

        String results = "you have " + hasDog + " and "  + hasCat + " and " + hasFish;
        surveyResultsLabel.setText(results);
    }
}
