// Welcome to the Judge!
import java.util.*;
import java.io.*;
public class SourceCode extends Thread {

    // Paste or write your code here--------------------
    public static void main(String[] args) {
      

      
    }
    // ----------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



    
    
    // Please ignore this section. Admin use only
    final static boolean judgeOfficially = true;
    public SourceCode(String fileName) {
        out = "";
        error = false;
        finished = false;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } 
        catch (Exception e) {
            error = true;
            errorMessage = "Input file not found or cannot be read";
        }
    }
    static String out;
    String errorMessage;
    public boolean error, finished;
    static BufferedReader reader;
    static class System {
        static class out {
            static void print(Object obj) {
                out += String.valueOf(obj);
                if (!judgeOfficially) Main.print(obj);
            }
            static void println(Object obj) {
                out += String.valueOf(obj) + "\n";
                if (!judgeOfficially) Main.print(obj + "\n");
            }
            static void println() {
                out += "\n";
                if (!judgeOfficially) Main.print("\n");
            }
        }
    }
    @Override
    public void run() {
        try {
            main(new String[]{});
        } catch (Exception e) {
            error = true;
            errorMessage = e.getMessage();
        }
        finished = true;
        if (!judgeOfficially) Main.exit();
    }
    private static StringTokenizer st; 
    static String next() { 
        while (st == null || !st.hasMoreElements()) { 
            try { 
                st = new StringTokenizer(reader.readLine()); 
            } 
            catch (IOException e) {} 
        } 
        return st.nextToken(); 
    } 
    static int nextInt() { 
        return Integer.parseInt(next()); 
    } 
    static int lineInt() {
        return Integer.parseInt(nextLine());
    }
    static long nextLong() { 
        return Long.parseLong(next()); 
    } 
    static double nextDouble() { 
        return Double.parseDouble(next()); 
    } 
    static String nextLine() { 
        try { 
            return reader.readLine(); 
        } 
        catch (IOException e) {
	    return null;
	}
    } 
}