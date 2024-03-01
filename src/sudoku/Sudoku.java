/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author Adam
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("Prosze podac nazwe pliku: ");
        String plik = in.nextLine() + ".txt";
        int[][] plansza = new int[9][9];
        try
        {         
           FileReader fr = new FileReader(plik);
           BufferedReader br = new BufferedReader(fr);
           String linia = null;
           int iteracja = 0;
           String[] wiersz = new String[9];
           while((linia=br.readLine())!= null)
           {
               wiersz = linia.split(" ");
               for(int x = 0; x < wiersz.length; x++)
               {
                   plansza[iteracja][x] = Integer.parseInt(wiersz[x]);
               }
               iteracja++;
           }
           
        }
        catch(Exception e)
        {
            System.out.print("Blad");
        }
        Plansza sudoku = new Plansza(plansza);
        if (sudoku.czyPoprawnaCalosc())
        {
            System.out.print("Poprawnie");
        }
        else
        {
            System.out.print("Niepoprawnie");
        }
    }
    
}
