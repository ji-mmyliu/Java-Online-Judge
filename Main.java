/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.io.*;
/**
 *
 * @author jimmy
 */
public class Main {
    public static void main(String[] args) {        
        // Parameters of the Judge cases (Settings)
        final long timeMillis = 2000; // Maximum amount of time to execute
        final boolean fullFeedback = false;
        final boolean showOutput = false;
        final String inputs[][] = {
            
            

        
        }; // Names of input files
        final String outputs[][] = {
            

                    
        }; // Names of output files
        final int score[] = {
            
            
        }; // Score allotted for each batch passed
        
        // End of Judge Settings
        
        
        /** BEGINNING OF JUDGE **/
        if (!SourceCode.judgeOfficially) {
            SourceCode m = new SourceCode("");
            SourceCode.reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nRunning program for testing...");
            m.start();
            while (true) {}
        }
        SourceCode m;
        int correct = 0;
        System.out.printf("\nEXECUTING PROGRAM:\tTime limit: %.3f seconds\n", (double) timeMillis / 1000);
        if (fullFeedback || showOutput) {
            System.out.println("WITH ADMIN SETTINGS\n");
        }
        if (inputs.length != outputs.length || inputs.length != score.length) {
            System.out.println("Error: Different number of input batches as output batches");
        }
        int total = 0; long totalTaken = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].length > 1) System.out.println("     Test Batch #" + (i+1) + ": ");
            total += score[i];
            if (inputs[i].length != outputs[i].length) {
                System.out.println(RED + "          Error: Different number of input files as output files" + RESET);
                continue;
            }
            boolean failed = false;
            for (int j = 0; j < inputs[i].length; j++) {
                finished = false;
                if (inputs[i].length > 1) {
                  System.out.print("          Test Case #" + (j+1) + ": ");
                }
                else {
                  System.out.print("     Test Case #" + (i+1) + ": ");
                }
                
                if (failed) {
                    System.out.println("--"); continue;
                }
                String expected = "";
                try {
                    BufferedReader br = new BufferedReader(new FileReader(outputs[i][j]));
                    String str = br.readLine();
                    int cnt = 0;
                    while (str != null) {
                        expected += str + "\n";
                        str = br.readLine();
                    }
                } catch (IOException e) {
                    System.out.println("IE  (Error: Output file " + outputs[i] + " not found)"); return;
                }
                m = new SourceCode(inputs[i][j]);
                m.start();
                long start = System.currentTimeMillis(); boolean flag = false;
                long temp = 0;
                while (start + timeMillis > System.currentTimeMillis() && !m.finished) {
                  System.out.print("");
                }
                long taken = System.currentTimeMillis() - start;
                if (totalTaken < Long.MAX_VALUE) totalTaken += taken;
                boolean wrong = false;
                if (m.error) {
                  System.out.print(RED + "RTE " + RESET);
                  if (fullFeedback) System.out.print("(" + m.errorMessage + ") ");
                  System.out.printf(" [%.3f seconds]", (double)taken / 1000);
                  if (inputs[i].length == 1) System.out.printf(" (0/%d points earned)", score[i]);
                  System.out.println();
                  failed = true;
                  continue;
                }
                if (!m.finished) {
                    System.out.print(RED + "TLE" + RESET);
                    System.out.printf(" [>%.3f seconds]", (double)timeMillis / 1000);
                    if (inputs[i].length == 1) System.out.printf(" (0/%d points earned)", score[i]);
                    System.out.println();
                    failed = true; totalTaken = Long.MAX_VALUE;

                    System.out.println("Your output (clipped): ");
                    System.out.print(SourceCode.out.length() > 15 ? SourceCode.out.substring(0,15) : SourceCode.out);
                    if (SourceCode.out.length() == 0) System.out.print("There is no output");
                    System.out.println("\n");

                    continue;
                }
                if (SourceCode.out.equals(expected)) {
                    System.out.print(GREEN + "AC" + RESET);
                } else {
                    System.out.print(RED + "WA" + RESET);
                    if (expected.length() > 0 && expected.substring(0, expected.length() - 1).equals(SourceCode.out))
                        System.out.print(" (Presentation Error)");
                    failed = true;
                    wrong = true;
                }
                System.out.printf(" [%.3f seconds]", (double)taken / 1000);
                if (inputs[i].length == 1) System.out.printf(" (%d/%d points earned)", wrong ? 0:score[i], score[i]);
                System.out.println();
                if (wrong && showOutput) {
                    System.out.println("Your output (clipped): ");
                    System.out.print(SourceCode.out.length() > 15 ? SourceCode.out.substring(0,15) : SourceCode.out);
                    if (SourceCode.out.length() == 0) System.out.print("There is no output");
                    System.out.println("\n");
                }
            }
            if (!failed) {
              correct += score[i];
              if (inputs[i].length > 1) {
                System.out.println("          (" + score[i] + "/" + score[i] + " points earned)");
                System.out.println();
              }
            }
            else if (inputs[i].length > 1) {
              System.out.println("          (0/" + score[i] + " points earned)");
              System.out.println();
            }
        }
        System.out.println("\nExecution finished");
        System.out.println("Final Score: " + correct + " / " + total + " points");
        if (totalTaken < Long.MAX_VALUE) {
          System.out.printf("Total time taken: %.3f seconds\n", totalTaken / 1000.0);
        }
        else {
          System.out.println("Total time taken: Indefinite");
        }
    }
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static void print(Object obj) {
        System.out.print(String.valueOf(obj));
    }
    public static void exit() {
        System.exit(0);
    }
    public static boolean finished;
}
