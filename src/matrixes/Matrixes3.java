/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixes;

/**
 *
 * @author Maciek P
 */
public class Matrixes3 {
            //SET NECESSARRY VARIALBLES START
        //Filtry dolnoprzepustowe - macierze
        public static int averagingMatrix[][]   =    {{1,1,1},
                                        {1,1,1},
                                        {1,1,1}};
       
        public static int lP1Matrix[][]   =           {{1,1,1},
                                        {1,2,1},
                                        {1,1,1}};
        
        public static int lP2Matrix[][]   =          {{1,1,1},
                                        {1,4,1},
                                        {1,1,1}};
        
        public static int lP3Matrix[][]   =          {{1,1,1},
                                        {1,12,1},
                                        {1,1,1}};
        
        public static int gauss1Matrix[][]   =       {{1,2,1},
                                        {2,4,2},
                                        {1,2,1}};
       
        //Filtry górnoprzepustowe - macierze
        public static int removeAverageMatrix[][] = {{-1,-1,-1},
                                         {-1,9,-1},
                                        {-1,-1,-1}};
         
        public static int hp1Matrix[][] =           {{0,-1,0},
                                        {-1,5,-1},
                                         {0,-1,0}};
          
        public static int hp2Matrix[][] =           {{1,-2,1},
                                         {-2,5,-2},
                                         {1,-2,1}};
           
        public static int hp3Matrix[][] =           {{0,-1,0},
                                         {-1,20,-1},
                                         {0,-1,0}};
        
        //Filtry przesuwania i odejmowania - macierze
        public static int horizontalMatrix[][] =           {{0,0,0},
                                            {-1,1,0},
                                            {0,0,0}};
        
        public static int verticalMatrix[][] =           {{0,-1,0},
                                            {0,1,0},
                                            {0,0,0}};
        
        public static int oblique1Matrix[][] =           {{-1,0,0},
                                            {0,1,0},
                                            {0,0,0}};
        
        public static int oblique2Matrix[][] =           {{0,0,-1},
                                            {0,1,0},
                                            {0,0,0}};
        
        //Filtry gradientowe kierunkowe
        public static int eastMatrix[][] =               {{-1,1,1},
                                            {-1,-2,1},
                                            {-1,1,1}};
        
        public static int westMatrix[][] =                {{1,1,-1},
                                            {1,-2,-1},
                                             {1,1,-1}};
        
        public static int northMatrix[][] =              {{1,1,1},
                                            {1,-2,1},
                                           {-1,-1,-1}};
        
        public static int southMatrix[][] =              {{-1,-1,-1},
                                            {1,-2,1},
                                            {1,1,1}};
        
        public static int southEastMatrix[][] =          {{-1,-1,1},
                                           {-1,-2,1},
                                            {1,1,1}};
        
        public static int southWestMatrix[][] =          {{1,-1,-1},
                                           {1,-2,-1},
                                           {1,1,1}};
        
        public static int northWestMatrix[][] =          {{1,1,1},
                                           {1,-2,-1},
                                           {1,-1,-1}};
        
        public static int northEastMatrix[][] =          {{1,1,1},
                                           {-1,-2,1},
                                           {-1,-1,1}};
        
        //filtry uwypuklające - macierze
        public static int embossingEastMatrix[][] =      {{-1,0,1},
                                            {-1,1,1},
                                            {-1,0,1}};
        
        public static int embossingWestMatrix[][] =      {{1,0,-1},
                                            {1,1,-1},
                                             {1,0,-1}};
        
        public static int embossingNorthMatrix[][] =     {{1,1,1},
                                            {0,1,0},
                                           {-1,-1,-1}};
        
        public static int embossingSouthMatrix[][] =     {{-1,-1,-1},
                                            {0,1,0},
                                            {1,1,1}};
        
        public static int embossingSouthEastMatrix[][] = {{-1,-1,0},
                                           {-1,1,1},
                                            {0,1,1}};
        
        public static int embossingSouthWestMatrix[][] = {{0,-1,-1},
                                           {1,1,-1},
                                           {1,1,0}};
        
        public static int embossingNorthWestMatrix[][] =  {{1,1,0},
                                           {1,1,-1},
                                           {0,-1,-1}};
        
        public static int embossingNorthEastMatrix[][] =  {{0,1,1},
                                           {-1,1,1},
                                           {-1,-1,0}};       
        
        //filtry laplace'a - macierze
        
        public static int lap1Matrix[][] =               {{0,-1,0},
                                           {-1,4,-1},
                                           {0,-1,0}}; 
        
        public static int lap2Matrix[][] =               {{-1,-1,-1},
                                            {-1,8,-1},
                                           {-1,-1,-1}}; 
        
        public static int lap3Matrix[][] =               {{1,-2,1},
                                           {-2,4,-2},
                                           {1,-2,1}}; 
        
        public static int lapObliqueMatrix[][] =         {{-1,0,-1},
                                           {0,4,0},
                                           {-1,0,-1}};
        
        public static int lapVerticalMatrix[][] =        {{0,0,0},
                                           {-1,2,-1},
                                           {0,0,0}};
        
        public static int lapHorizontalMatrix[][] =      {{0,-1,0},
                                           {0,2,0},
                                           {0,-1,0}};
        
        //filtry konturowe - macierze
        
        public static int sobelVerticalMatrix[][] =      {{1,0,-1},
                                           {2,0,-2},
                                           {1,0,-1}};
        
        public static int sobelHorizontalMatrix[][] =    {{1,2,1},
                                           {0,0,0},
                                           {-1,-2,-1}};
        
        public static int prewittHorizontalMatrix[][] =  {{-1,-1,-1},
                                           {0,0,0},
                                           {1,1,1}};
        
        public static int prewittVerticalMatrix[][] =   {{1,0,-1},
                                           {1,0,-1},
                                           {1,0,-1}};
}
