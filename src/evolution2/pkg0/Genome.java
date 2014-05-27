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
 * Genome:
 * Have a total length of 8, 
 * but base genome has length of 6
 *
 * First two slots are identifier slots: 
 *      00 --> Consume (process) 
 *      01 --> Produce
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
 * 
 * TODO:
 * Add file parsing for totalGnome HashMap
 */
public class Genome {
    
    ArrayList<String> genome = new ArrayList<>(); //actual genome list for creature
    HashMap<String, String> genomeSorted = new HashMap<>(); // translate genome names
    HashMap<String, String> totalGenome = new HashMap<>(); // hashmap of all knpwn genomes
    public Genome() { // Produce BASIC creature
        fillBasicGenomeSort();
    }

    private void fillBasicGenomeSort() {
        genomeSorted.put(makeConsume("011011"), "Glucose");
        genomeSorted.put(makeProcess("110110"), "Cell_Membrane");
        genome.add(makeConsume("011011"));
        genome.add(makeProcess("110110"));
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
    public String returnGenomeName(Genome creature, String genome){
        String hold = ""; // Find genome identifier and genome name from Total Genome
        String genomeRoot = genome.substring(2, 8);
        if (genome.length() > 6){
            if("01".equals(genome.substring(0, 2))){
                hold = "Produce" + genomeRoot;
            } else if ("00".equals(genome.substring(0, 2))) {
                hold = "Consume" + genomeRoot;
            }
        }
        return hold;
    }
    public void fillTotalGenome(){
        // Make this later
    }
}
