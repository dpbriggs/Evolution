/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evolution2.pkg0;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author david
 *
 * Genome (Length 8)
 *
 * First two slots are identifier slots: 00 --> Consume (process) 01 --> Produce
 *
 * Energy:
 *
 * 011011 - Glucose 011111 - Maltose
 *
 * Structure:
 *
 * 110110 - Cell_Membrane
 *
 * Movement:
 *
 * && Add more here &&
 */
public class Genome {

    ArrayList<String> genome = new ArrayList<>();
    HashMap<String, String> genomeSorted = new HashMap<>();

    public Genome() { // Produce BASIC creature
        fillBasicGenomeSort();
    }

    private void fillBasicGenomeSort() {
        genomeSorted.put("Glucose", "011011");
        genomeSorted.put("Cell_Membrane", "110110");
        genome.add("011011");
        genome.add("110110");
    }

    public String makeConsume(String incompleteGenome) {
        if (incompleteGenome.length() == 6) {
            return "00" + incompleteGenome;
        } else {
            return "00" + incompleteGenome.substring(2);
        }
    }

    public String makeProcess(String incompleteGenome) {
        if (incompleteGenome.length() == 6) {
            return "01" + incompleteGenome;
        } else {
            return "01" + incompleteGenome.substring(2);
        }
    }
}
