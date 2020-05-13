/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutaoptima;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class dijkstra {
    public int distancia[] = new int [21];
    public static String ciudad[] = new String [21];
    public static int costo[][] = new int [21][21];
    public String aux [][] =  new String[21][21];
    
    public void calc(int n, int origen , int destino){
        int flag[] = new int [n+1];
        int i, k, c, minimo;
        int minpos = 1;
        
        for(i = 0; i < n ; i++){
            flag[i] = 0;
            this.distancia[i] = this.costo[origen][i];
        }
        c = 2;
        while(c <= n){
            minimo = 9999;
            
            for(k = 0; k < n; k++){
                
                if(this.distancia[k] < minimo && flag[k] != 1){
                    
                    
                    minimo = this.distancia[k];
                    minpos = k;
                     
                }
            }
            flag[minpos] = 1;
            c++;
            for(k = 0; k < n; k++){
                
                if(this.distancia[minpos] + this.costo[minpos][k] < this.distancia[k] && flag[k] != 1){
                    if(destino == k){
                        this.calc(n, origen, minpos);
                        System.out.println(ciudad[minpos]); 
                    }
                    this.distancia[k] = this.distancia[minpos] + this.costo[minpos][k];
                }
                
            }
            
        }
        
    }
}
