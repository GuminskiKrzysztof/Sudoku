/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.*;
/**
 *
 * @author Adam
 */
public class Plansza {
    private int[][] plansza = new int[9][9];
    public Plansza(int[][] plansza)
    {
        this.plansza = plansza;
    }
    boolean czyPoprawnyRegion(int poczatkowyWiersz, int poczatkowaKolumna)
    {
        ArrayList<Integer> wykorzystaneLiczby = new ArrayList<>();
        for (int i = poczatkowyWiersz; i <= (poczatkowyWiersz + 2); i++)
        {
            for (int j = poczatkowaKolumna; j <= (poczatkowaKolumna + 2); j++)
            {
                for (int liczba:wykorzystaneLiczby)
                {
                    if (liczba == plansza[i][j])
                    {
                        return false;
                    }
                }
                wykorzystaneLiczby.add(plansza[i][j]);                    
            }
        }
        return true;
    }
    boolean czyPoprawneRegiony()
    {
        for (int i = 0; i < 9; i = i + 3)
        {
            for (int j = 0; j < 9; j = j + 3)
            {
                if (!czyPoprawnyRegion(i,j))
                {
                    return false;
                }
            }
        }
        return true;
    }
    boolean czyPoprawneWiersze()
    {
        ArrayList<Integer> wykorzystaneLiczby = new ArrayList<>();
        for(int i = 0; i < 9;i++)
        {
            for(int j = 0;j < 9; j++)
            {
                for(int liczba:wykorzystaneLiczby)
                {
                    if(liczba == plansza[i][j])
                    {
                        return false;
                    }
                }
                wykorzystaneLiczby.add(plansza[i][j]);
            }
            wykorzystaneLiczby.clear();
        }
        return true;
    }
    boolean czyPoprawneKolumny()
    {
        ArrayList<Integer> wykorzystaneLiczby = new ArrayList<>();
        int j = 0;
        while (j < 9)
        {
            for (int i = 0; i < 9; i++)
            {
                for (int liczba:wykorzystaneLiczby)
                {
                    if (liczba == plansza[i][j])
                    {
                        return false;
                    }
                }
                wykorzystaneLiczby.add(plansza[i][j]);
            }
            wykorzystaneLiczby.clear();
            j++;
        }
        return true;
    }
    boolean czyPoprawnaCalosc()
    {
        if(!czyPoprawneRegiony())
        {
            return false;
        }
        if(!czyPoprawneWiersze())
        {
            return false;
        }
        if(!czyPoprawneKolumny())
        {
            return false;
        }
        return true;
    }
}
