package rutaoptima;

import java.util.Scanner;



/**
 *
 * @author Carlos
 */
public class RutaOptima {
    public static void main(String[] args) {   
        dijkstra d = new dijkstra();
        int origen = 0;
        int destino = 0;
        
            d.ciudad[0] = "Cdmx";
            d.ciudad[1] = "Iztapalapa";
            d.ciudad[2] = "Gustavo Madero";
            d.ciudad[3] = "Naucalpan";
            d.ciudad[4] = "Alvaro Obregon";
            d.ciudad[5] = "Tlanepantla";
            d.ciudad[6] = "Ecatepec";
            d.ciudad[7] = "Nezahualcoytl";
            d.ciudad[8] = "Guadalajara";
            d.ciudad[9] = "Leon";
            d.ciudad[10] = "Zapopan";
            d.ciudad[11] = "San Luis";
            d.ciudad[12] = "Culiacan";
            d.ciudad[13] = "Puebla";
            d.ciudad[14] = "Aguascalientes";
            d.ciudad[15] = "Guadalupe";
            d.ciudad[16] = "Monterey";
            d.ciudad[17] = "Merida";
            d.ciudad[18] = "Chihuahua";
            d.ciudad[19] = "Juarez";
            d.ciudad[20] = "Tijuana"; 
        
        
        for(int i = 0 ; i < 21 ; i++)
            for(int j = 0 ; j < 21 ; j++){
                d.costo[i][j] = 9999;
            }
        
        for(int i = 0 ; i < 21 ; i++)
            d.costo[i][i] = 0;
        
        d.costo[0][1] = 11;
        d.costo[0][2] = 7;
        d.costo[0][3] = 13;
        d.costo[0][4] = 11;
        d.costo[0][5] = 14;
        d.costo[0][6] = 21;
        d.costo[0][7] = 12;
        
        d.costo[1][0] = 11;
        
        d.costo[2][0] = 7;
        d.costo[2][8] = 459;
        d.costo[2][9] = 319;
        d.costo[2][10] = 460;
        d.costo[2][11] = 351;
        d.costo[2][12] = 1030;
        
        d.costo[3][0] = 13;
        
        d.costo[4][0] = 11;
        
        d.costo[5][0] = 14;
        
        d.costo[6][0] = 21;
        
        d.costo[7][0] = 12;
        d.costo[7][13] = 94;
        
        d.costo[8][2] = 459;
        
        d.costo[9][2] = 319;
        d.costo[9][14] = 93;
        
        d.costo[10][2] = 460;
        
        d.costo[11][2] = 351;
        d.costo[11][15] = 345;
        d.costo[11][16] = 346;
        
        d.costo[12][2] = 1030;
        
        d.costo[13][7] = 94;
        d.costo[13][17] = 888;
        
        d.costo[14][9] = 93;
        
        d.costo[15][11] = 345;
        d.costo[15][18] = 542;
        
        d.costo[16][11] = 346;
        
        d.costo[17][13] = 888;
        
        d.costo[18][15] = 542;
        d.costo[18][19] = 304;
        d.costo[18][20] = 1049;
        
        d.costo[19][18] = 304;
        
        d.costo[20][18] = 1049;
        
        for(int i = 0 ; i < 21 ; i++)
            System.out.println((i+1)+".-"+d.ciudad[i]);
        
        System.out.println("Ingrese el estado origen y el estado destino (solo el id)");
        Scanner in = new Scanner(System.in);
        origen = in.nextInt();
        destino = in.nextInt();
        
        System.out.println("Pasas por las ciudades:");  
        d.calc(21,(origen-1),(destino-1));

        System.out.println(d.ciudad[origen] +" a "+ d.ciudad[20] + " distancia minima " + d.distancia[20]);
        
    } 
    
}
