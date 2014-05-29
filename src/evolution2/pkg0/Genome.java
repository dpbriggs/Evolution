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
 * All genomes are made up of bases (arbitrary)
 * G, A, C, T
 *
 * All proteins are made up of these bases
 * 
 * The first two slots are dedicated to protein identifiers
 * 
 * Identifiers:
 * Consume - CA
 * Produce - GT
 * Transport - TA
 * Special - GG
 * 
 * The next 4 slots are dedicated to identifying specific molecules
 * 
 * Molecules:
 * Glucose - AACT
 * Maltose - AAGT
 * Cell_Membrane (Phosphlipid by layer) - GGAT
 * 
 * Bits of bases can be added on the back of molecules which change their
 * function.
 * 
 * Example:
 * Consume Glucose - CAAACT + (extra bases for special effects)
 * TODO:
 * Add file parsing for totalGnome HashMap
 */
public class Genome {
    
    ArrayList<String> genome = new ArrayList<>(); //actual genome list for creature
    HashMap<String, String> genomeSorted = new HashMap<>(); // translate genome names
    HashMap<String, String> totalGenome = new HashMap<>(); // hashmap of all kniwn genomes
    public Genome() { // Produce BASIC creature
        fillBasicGenomeSort();
    }

    private void fillBasicGenomeSort() {
        genomeSorted.put(makeConsume("AACT"), "Glucose");
        genomeSorted.put(makeProcess("GGAT"), "Cell_Membrane");
        genome.add(makeConsume("AACT"));
        genome.add(makeProcess("GGAT"));
    }

    public String makeConsume(String incompleteGenome) {
        if (incompleteGenome.length() == 4) {
            return "CA" + incompleteGenome;
        } else {
            return "CA" + incompleteGenome.substring(2); 
        }
    }

    public String makeProcess(String incompleteGenome) {
        if (incompleteGenome.length() == 4) {
            return "GT" + incompleteGenome;
        } else {
            return "GT" + incompleteGenome.substring(2); 
        }
    }
    public String returnGenomeName(String genome){
        String hold = ""; // Find genome identifier and genome name from Total Genome
        String genomeRoot = genome.substring(2, 6);
        if (genome.length() > 4){
            if("GT".equals(genome.substring(0, 2))){
                hold = "Produce " + genomeRoot;
            } else if ("CA".equals(genome.substring(0, 2))) {
                hold = "Consume " + genomeRoot;
            }
        }
        return hold;
    }
    public void fillTotalGenome(){
        // Make this later
    }
}
