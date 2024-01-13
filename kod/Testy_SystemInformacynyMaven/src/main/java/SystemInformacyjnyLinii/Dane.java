/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SystemInformacyjnyLinii;

import systeminformacyjny.model.*;
import java.util.*;

/**
 *
 * @author erykm
 */
public class Dane {
    public static RozkladJazdyKursu rozklady[] = {
    new RozkladJazdyKursu(),
    new RozkladJazdyKursu(),
    new RozkladJazdyKursu(),
    new RozkladJazdyKursu()
    };
    
    public static List<List<Integer>> godziny = new ArrayList<>();
    
    // Statyczna inicjalizacja pol
    static {
        // Dodawanie wierszy do listy 2D
        godziny.add(List.of(1, 2, 3, 4, 5));
        godziny.add(List.of(6, 7, 8, 9, 10));
        godziny.add(List.of(11, 12, 13, 14, 15));
        godziny.add(List.of(13, 14, 16, 17, 18));
        
        for(int i=0; i<4; i++) {
            rozklady[i].setGodziny(godziny.get(i));
        }
    }
}
