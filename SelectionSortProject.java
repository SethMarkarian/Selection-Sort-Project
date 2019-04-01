import java.io.*;

public class SelectionSortProject
{
    // Change these to test.
    // Just make sure HOW_MANY <= ARRAY_SIZE
    // If they are equal, the array is sorted completely.
    private static final int ARRAY_SIZE = 10;
    private static final int HOW_MANY = 3;
    
    /**
     * Implements ordinary Selection Sort.
     */
    private static void selectionSort(Comparable[] a, int n) {
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            Comparable min = a[i];
            int k = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j].compareTo(min) < 0) {
                    min = a[j];
                    k = j;
                }
            }
            swap(a, i, k);
            count++;
            if(count == n) {
                    break;
                }
        }
    }
    
    /**
     * Implements tail-first Selection Sort.
     */
    private static void tailFirstSelectionSort(Comparable[] a, int n) {
        int count = 0;
        for(int i = a.length - 1; i > -1; i--) {
            Comparable max = a[i];
            int k = i;
            for(int j = 0; j < i; j++) {
                if(a[j].compareTo(max) > 0) {
                    max = a[j];
                    k = j;
                }
            }
            swap(a, i, k);
            count++;
            if(count == n) {
                    break;
                }
        }
    }
    
    /**
     * Please write this (short) method and
     * call it in both methods above.
     * Swaps elements at indices i and j in the array.
     */
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    /**
     * Please write this (short) method and
     * call it in both methods above.
     * Swaps elements at indices i and j in the array.
     */
    private static void swap(int[][] a, int i, int j, int w, int y) {
        int temp = a[i][j];
        a[i][j] = a[w][y];
        a[w][y] = temp;
    }
    
    /**
     * Completely implements selection sort on a 2D array of int.
     */
    private static void selectionSortTwoDArray(int[][] a) {
        int rows = a.length;
        int columns = a[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                int min = a[i][j];
                int start = 0;
                int k = i;
                int l = j;
                for(int y = i; y < rows; y++) {
                    if(i < y) {
                        start = 0;
                    }
                    if(i == y) {
                        start = j + 1;
                    }
                    for(int w = start; w < columns; w++) {
                        if(a[y][w] < min) {
                            min = a[y][w];
                            k = y;
                            l = w;
                        }
                    }
                }  
                swap(a, i, j, k, l);            
            }
        }
    }
    
    /**
     * Tester code for selectionSort
     */
    public static void selectionSortTester() {
        System.out.println("Tester for front-first (normal) Selection Sort");
        
        System.out.println();
        
        System.out.println("### Test 1 ###");
        String[] s = stringArray(ARRAY_SIZE);
        String[] t = s.clone();
        
        System.out.println("Original array: ");
        printArray(s);
        selectionSort(s, HOW_MANY);
        System.out.println("Selection Sort with " + HOW_MANY + " passes: ");
        printArray(s);
        Key.selectionSort(t, HOW_MANY);
        System.out.println("Correct: " + checkAllEqual(s, t));
        
        System.out.println();
        System.out.println();
        
        System.out.println("### Test 2 ###");
        Fraction[] f = fractionArray(ARRAY_SIZE);
        Fraction[] g = f.clone();
        
        System.out.println("Original array: ");
        printArray(f);
        selectionSort(f, HOW_MANY);
        System.out.println("Selection Sort with " + HOW_MANY + " passes: ");
        printArray(f);
        Key.selectionSort(g, HOW_MANY);
        System.out.println("Correct: " + checkAllEqual(s, t));
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Tester code for tailFirstSelectionSort
     */
    public static void tailFirstSelectionSortTester() {
        System.out.println("Tester for tail-first Selection Sort");
        
        System.out.println();
        
        System.out.println("### Test 1 ###");
        String[] s = stringArray(ARRAY_SIZE);
        String[] t = s.clone();
        
        System.out.println("Original array: ");
        printArray(s);
        tailFirstSelectionSort(s, HOW_MANY);
        System.out.println("Tail-first Selection Sort with " + HOW_MANY + " passes: ");
        printArray(s);
        Key.tailFirstSelectionSort(t, HOW_MANY);
        System.out.println("Correct: " + checkAllEqual(s, t));
        
        System.out.println();
        System.out.println();
        
        System.out.println("### Test 2 ###");
        Fraction[] f = fractionArray(ARRAY_SIZE);
        Fraction[] g = f.clone();
        
        System.out.println("Original array: ");
        printArray(f);
        tailFirstSelectionSort(f, HOW_MANY);
        System.out.println("Tail-first Selection Sort with " + HOW_MANY + " passes: ");
        printArray(f);
        Key.tailFirstSelectionSort(g, HOW_MANY);
        System.out.println("Correct: " + checkAllEqual(s, t));
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * Tester code for selectionSortArray
     */
    public static void selectionSortTwoDTester() {
        System.out.println("Tester for Selection Sort on an array");
        
        System.out.println();
        
        System.out.println("### Test 1 ###");
        int[][] a = twoDArray(3, 5);
        int[][] b = a.clone();
        
        System.out.println("Original array: ");
        printTwoDArray(a);
        selectionSortTwoDArray(a);
        System.out.println();
        System.out.println("Sorted array: ");
        printTwoDArray(a);
        
        Key.selectionSortTwoDArray(b);
        System.out.println();
        System.out.println("Correct: " + checkAllEqual(a, b));
    }
    
    /**
     * Built-in code; ignore
     */
    private static boolean checkAllEqual(Comparable[] a, Comparable[] b) {
        if(a.length != b.length) {
            return false;
        }
        else {
            for(int i = 0; i < a.length; i++) {
                if(a[i].compareTo(b[i]) != 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
    private static boolean checkAllEqual(int[][] a, int[][] b) {
        if(a.length != b.length || a[0].length != b[0].length) {
            return false;
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                if(a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Built-in code; ignore
     */
    private static Fraction[] fractionArray(int n) {
        Fraction[] f = new Fraction[n];
        for(int i = 0; i < n; i++) {
            int a = 1 + (int) (100 * Math.random());
            int b = 1 + (int) (100 * Math.random());
            f[i] = new Fraction(a, b);
        }
        return f;
    }
    
    /**
     * Built-in code; ignore.
     */
    private static String[] stringArray(int n) {
        // Read file
        String[] s = new String[n];
        try {
            FileReader fileReader = new FileReader("words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int i = 0;
            int N = 5000;
            while(line != null) {
                double prob = ((double) (n - i))/N;
                line = bufferedReader.readLine();
                if(Math.random() < prob) {
                    s[i] = line;
                    i++;
                }
                N--;
            }   
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file ' words.txt");             
        }
        catch(IOException ex) {
            System.out.println("Error reading file ' words.txt ");                  
        }
        
        return s;
    }
    
    private static int[][] twoDArray(int rows, int cols) {
        int[][] a = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                a[i][j] = 10 + (int) (40 * Math.random());
            }
        }
        return a;
    }
    
    private static void printArray(Object[] a) {
        System.out.print("[");
        for(int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1]);
        System.out.println("]");
    }
    
    private static void printTwoDArray(int[][] a) {
        for(int[] row : a) {
            for(int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
