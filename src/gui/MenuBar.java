/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import colorFilters.HSVFilters;
import colorFilters.RGBFilters;
import guiOperations.FileOperations;
import guiOperations.UndoRedoOperations;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import matrixManiFunctions.MatrixFunctions;
import matrixManiFunctions.StatisticFunctions;

/**
 *
 * @author Maciek P
 */
public class MenuBar {
    
    private final RGBFilters rgbFilters = new RGBFilters();
    private final HSVFilters hsvFilters = new HSVFilters();
    private final ArrayList buttons = new ArrayList();
    private MainFrame mainFrame;
    UndoRedoOperations undoRedo;
    OptionPanelButtons optionPanelButtons;
    private final JTextField filename = new JTextField();
    private final JTextField dir = new JTextField();
    private final MatrixFunctions matrixFunction = new MatrixFunctions();
    FileOperations fileOperations = new FileOperations();
    private final SideMenu sideMenu = new SideMenu();
    JPopupMenu popupMenu = new JPopupMenu("Title");
    StatisticFunctions statisticFunction = new StatisticFunctions();
    
    public JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
            JMenuItem openFile = new JMenuItem("Open File");
            JMenuItem saveFile = new JMenuItem("Save File");
        file.add(openFile);
        file.addSeparator();
        file.add(saveFile);
            
        JMenu filters = new JMenu("Filters");
            JMenu colorFilters = new JMenu("Color Filtes");
                JMenuItem redFilter = new JMenuItem("Red Filter"); //filtr czerwony
                JMenuItem greenFilter = new JMenuItem("Green Filter"); //filtr zielony
                JMenuItem blueFilter = new JMenuItem("Blue Filter"); //filtr niebieski
                JMenuItem yellowFilter = new JMenuItem("Yellow Filter"); //filtr żółty
                JMenuItem purpleFilter = new JMenuItem("Purple Filter"); //filtr fioletowy
                JMenuItem cyanFilter = new JMenuItem("Cyan Filter"); //filtr cyjanowy
            colorFilters.add(redFilter);
            colorFilters.add(greenFilter);
            colorFilters.add(blueFilter);
            colorFilters.add(yellowFilter);
            colorFilters.add(purpleFilter);
            colorFilters.add(cyanFilter);
        filters.add(colorFilters);
            JMenu brightFilters = new JMenu("Brightness Filtes");
                JMenuItem dark = new JMenuItem("Dark Filter"); //filtr ciemny
                JMenuItem bright = new JMenuItem("Bright Filter"); //filtr jasny
            brightFilters.add(dark);
            brightFilters.add(bright);
        filters.add(brightFilters);
            JMenu symetric = new JMenu("Symetric Filtes");
                JMenuItem negative = new JMenuItem("Negative Filter"); //filtr negatyw
                JMenuItem greyScale = new JMenuItem("Grey Scale Filter");
                JMenuItem sepia = new JMenuItem("Sepia Filter");
            symetric.add(negative);
            symetric.add(greyScale);
            symetric.add(sepia);
        filters.add(symetric);
            JMenu lowPass = new JMenu("Lowpass Filters"); //filtry dolnoprzepustowe
                JMenuItem averaging = new JMenuItem("Averaging Filter"); //filtr usredniający (rozmwyanie)
                JMenuItem lp1 = new JMenuItem("LP1 Filter"); //filtr LP1 (rozmwyanie)
                JMenuItem lp2 = new JMenuItem("LP2 Filter"); //filtr LP2 (rozmwyanie)
                JMenuItem lp3 = new JMenuItem("LP3 Filter"); //filtr LP3 (rozmwyanie)
                JMenuItem gauss1 = new JMenuItem("Gauss1 Filter"); //filtr Gauss1 (rozmwyanie)
            lowPass.add(averaging);
            lowPass.add(lp1);
            lowPass.add(lp2);
            lowPass.add(lp3);
            lowPass.add(gauss1);
        filters.add(lowPass);
            JMenu highPass = new JMenu("Highpass Filters"); //filtry górnoprzepustowe
                JMenuItem removeAverage = new JMenuItem("Remove Average Filter"); //filtr usuń średnią (wysostrzanie)
                JMenuItem hp1 = new JMenuItem("HP1 Filter"); //filtr HP1
                JMenuItem hp2 = new JMenuItem("HP2 Filter"); //filtr HP2
                JMenuItem hp3 = new JMenuItem("HP3 Filter"); //filtr HP3
            highPass.add(removeAverage);
            highPass.add(hp1);
            highPass.add(hp2);
            highPass.add(hp3);
        filters.add(highPass);
            JMenu moveAndRemove = new JMenu("Move and Remove Filters"); //filtry przesuwania i odejmowania
                JMenuItem vertical = new JMenuItem("Vertical Filter");  //fitr pionowy
                JMenuItem horizontal = new JMenuItem("Horizontal Filter"); //filtr poziomy
                JMenuItem oblique1 = new JMenuItem("Oblique 1 Filter"); //filtr ukośny 1
                JMenuItem oblique2 = new JMenuItem("Oblique 2 Filter"); //filtr ukośny 2
            moveAndRemove.add(vertical);
            moveAndRemove.add(horizontal);
            moveAndRemove.add(oblique1);
            moveAndRemove.add(oblique2);
        filters.add(moveAndRemove);
            JMenu gradient = new JMenu("Gradient Directional Filters"); // gradientowe filtry kierunkowe
                JMenuItem west = new JMenuItem("West Filter"); //filtr zachodni
                JMenuItem east = new JMenuItem("East Filter"); //filtr wschodni
                JMenuItem north = new JMenuItem("North Filter"); //filtr północny
                JMenuItem south = new JMenuItem("South Filter"); //filtr południowy
                JMenuItem northwest = new JMenuItem("North-West Filter"); //filtr północno - zachodni
                JMenuItem southwest = new JMenuItem("South-West Filter"); //filtr południowo - zachodni
                JMenuItem northeast = new JMenuItem("North-East Filter"); //filtr północno - wschodni
                JMenuItem southeast = new JMenuItem("South-East Filter"); //filtr południowo - wschodni
            gradient.add(west);
            gradient.add(east);
            gradient.add(north);
            gradient.add(south);
            gradient.add(northwest);
            gradient.add(southwest);
            gradient.add(northeast);
            gradient.add(southeast);
        filters.add(gradient);
            JMenu embossing = new JMenu("Embossing filters"); //filtry uwypuklające
                JMenuItem westE = new JMenuItem("West Filter"); //filtr zachodni
                JMenuItem eastE = new JMenuItem("East Filter"); //filtr wschodni
                JMenuItem northE = new JMenuItem("North Filter"); //filtr północny
                JMenuItem southE = new JMenuItem("South Filter"); //filtr południowy
                JMenuItem northwestE = new JMenuItem("North-West Filter"); //filtr północno - zachodni
                JMenuItem southwestE = new JMenuItem("South-West Filter"); //filtr południowo - zachodni
                JMenuItem northeastE = new JMenuItem("North-East Filter"); //filtr północno - wschodni
                JMenuItem southeastE = new JMenuItem("South-East Filter"); //filtr południowo - wschodni
           embossing.add(westE); 
           embossing.add(eastE);
           embossing.add(northE);
           embossing.add(southE);
           embossing.add(northwestE);
           embossing.add(southwestE);
           embossing.add(northeastE);
           embossing.add(southeastE);
        filters.add(embossing);
            JMenu laplace = new JMenu("Laplace Filters");
                JMenuItem lap1 = new JMenuItem("LAP1");
                JMenuItem lap2 = new JMenuItem("LAP2");
                JMenuItem lap3 = new JMenuItem("LAP3");
                JMenuItem lapOblique = new JMenuItem("oblique");
                JMenuItem lapHorizontal = new JMenuItem("horizontal");
                JMenuItem lapVertical = new JMenuItem("vertical");
            laplace.add(lap1);
            laplace.add(lap2);
            laplace.add(lap3);
            laplace.add(lapOblique);
            laplace.add(lapHorizontal);
            laplace.add(lapVertical);
        filters.add(laplace);
            JMenu edges = new JMenu("Edges Filters");
                JMenuItem sobelVertical = new JMenuItem("Sobel Vertical filter");
                JMenuItem sobelHorizontal = new JMenuItem("Sobel Horizontal filter");
                JMenuItem prewittVertical = new JMenuItem("Prewitt Vertical filter");
                JMenuItem prewittHorizontal = new JMenuItem("Prewitt Horizontal filter");
            edges.add(sobelVertical);
            edges.add(sobelHorizontal);
            edges.add(prewittVertical);
            edges.add(prewittHorizontal);
        filters.add(edges);
            JMenu statistics = new JMenu("Statistic Filters");
                JMenuItem median = new JMenuItem("Median Filter");
                JMenuItem maximal = new JMenuItem("Maximal Filter");
                JMenuItem minimal = new JMenuItem("Minimal Filter");
            statistics.add(median);
            statistics.add(maximal);
            statistics.add(minimal);
        filters.add(statistics);
            JMenu HSVModel = new JMenu("HSV Color Model Filters");
                JMenuItem accent = new JMenuItem("Accent");
            HSVModel.add(accent);
        filters.add(HSVModel);
            JMenu inverting = new JMenu("Nieuporzadkowane Filters");
                JMenuItem solarCustom = new JMenuItem("Solarise Custom Filter"); //Niby solaryzacja - można ustawiać jasnośc i wartość do odejmowania od RGB
                JMenuItem solarDefault = new JMenuItem("Solarise Default Filter");//Solaryzajca (normalna)
                JMenuItem gamma = new JMenuItem("Gamma Filter");//Gamma
                JMenuItem exposition = new JMenuItem("Exposition Filter");//Expozycja
            inverting.add(solarCustom);
            inverting.add(solarDefault);
            inverting.add(gamma);
            inverting.add(exposition);
        filters.add(inverting);
        menuBar.add(file);
        menuBar.add(filters);
        
        //SET INITIAL ACCTION LISTENER START
        sideMenu.getAcceptButton().addActionListener((ActionEvent event) -> {
        });
        //SET INITIAL ACCTION LISTENER END
        


        //SET NECESSARRY VARIALBLES START
        //Filtry dolnoprzepustowe - macierze
        int averagingMatrix[][]   =    {{1,1,1},
                                        {1,1,1},
                                        {1,1,1}};
       
        int lP1Matrix[][]   =           {{1,1,1},
                                        {1,2,1},
                                        {1,1,1}};
        
        int lP2Matrix[][]   =          {{1,1,1},
                                        {1,4,1},
                                        {1,1,1}};
        
        int lP3Matrix[][]   =          {{1,1,1},
                                        {1,12,1},
                                        {1,1,1}};
        
        int gauss1Matrix[][]   =       {{1,2,1},
                                        {2,4,2},
                                        {1,2,1}};
       
        //Filtry górnoprzepustowe - macierze
        int removeAverageMatrix[][] = {{-1,-1,-1},
                                         {-1,9,-1},
                                        {-1,-1,-1}};
         
        int hp1Matrix[][] =           {{0,-1,0},
                                        {-1,5,-1},
                                         {0,-1,0}};
          
        int hp2Matrix[][] =           {{1,-2,1},
                                         {-2,5,-2},
                                         {1,-2,1}};
           
        int hp3Matrix[][] =           {{0,-1,0},
                                         {-1,20,-1},
                                         {0,-1,0}};
        
        //Filtry przesuwania i odejmowania - macierze
        int horizontalMatrix[][] =           {{0,0,0},
                                            {-1,1,0},
                                            {0,0,0}};
        
        int verticalMatrix[][] =           {{0,-1,0},
                                            {0,1,0},
                                            {0,0,0}};
        
        int oblique1Matrix[][] =           {{-1,0,0},
                                            {0,1,0},
                                            {0,0,0}};
        
        int oblique2Matrix[][] =           {{0,0,-1},
                                            {0,1,0},
                                            {0,0,0}};
        
        //Filtry gradientowe kierunkowe
        int eastMatrix[][] =               {{-1,1,1},
                                            {-1,-2,1},
                                            {-1,1,1}};
        
        int westMatrix[][] =                {{1,1,-1},
                                            {1,-2,-1},
                                             {1,1,-1}};
        
        int northMatrix[][] =              {{1,1,1},
                                            {1,-2,1},
                                           {-1,-1,-1}};
        
        int southMatrix[][] =              {{-1,-1,-1},
                                            {1,-2,1},
                                            {1,1,1}};
        
        int southEastMatrix[][] =          {{-1,-1,1},
                                           {-1,-2,1},
                                            {1,1,1}};
        
        int southWestMatrix[][] =          {{1,-1,-1},
                                           {1,-2,-1},
                                           {1,1,1}};
        
        int northWestMatrix[][] =          {{1,1,1},
                                           {1,-2,-1},
                                           {1,-1,-1}};
        
        int northEastMatrix[][] =          {{1,1,1},
                                           {-1,-2,1},
                                           {-1,-1,1}};
        
        //filtry uwypuklające - macierze
        int embossingEastMatrix[][] =      {{-1,0,1},
                                            {-1,1,1},
                                            {-1,0,1}};
        
        int embossingWestMatrix[][] =      {{1,0,-1},
                                            {1,1,-1},
                                             {1,0,-1}};
        
        int embossingNorthMatrix[][] =     {{1,1,1},
                                            {0,1,0},
                                           {-1,-1,-1}};
        
        int embossingSouthMatrix[][] =     {{-1,-1,-1},
                                            {0,1,0},
                                            {1,1,1}};
        
        int embossingSouthEastMatrix[][] = {{-1,-1,0},
                                           {-1,1,1},
                                            {0,1,1}};
        
        int embossingSouthWestMatrix[][] = {{0,-1,-1},
                                           {1,1,-1},
                                           {1,1,0}};
        
        int embossingNorthWestMatrix[][] =  {{1,1,0},
                                           {1,1,-1},
                                           {0,-1,-1}};
        
        int embossingNorthEastMatrix[][] =  {{0,1,1},
                                           {-1,1,1},
                                           {-1,-1,0}};       
        
        //filtry laplace'a - macierze
        
        int lap1Matrix[][] =               {{0,-1,0},
                                           {-1,4,-1},
                                           {0,-1,0}}; 
        
        int lap2Matrix[][] =               {{-1,-1,-1},
                                            {-1,8,-1},
                                           {-1,-1,-1}}; 
        
        int lap3Matrix[][] =               {{1,-2,1},
                                           {-2,4,-2},
                                           {1,-2,1}}; 
        
        int lapObliqueMatrix[][] =         {{-1,0,-1},
                                           {0,4,0},
                                           {-1,0,-1}};
        
        int lapVerticalMatrix[][] =        {{0,0,0},
                                           {-1,2,-1},
                                           {0,0,0}};
        
        int lapHorizontalMatrix[][] =      {{0,-1,0},
                                           {0,2,0},
                                           {0,-1,0}};
        
        //filtry konturowe - macierze
        
        int sobelVerticalMatrix[][] =      {{1,0,-1},
                                           {2,0,-2},
                                           {1,0,-1}};
        
        int sobelHorizontalMatrix[][] =    {{1,2,1},
                                           {0,0,0},
                                           {-1,-2,-1}};
        
        int prewittHorizontalMatrix[][] =  {{-1,-1,-1},
                                           {0,0,0},
                                           {1,1,1}};
        
        int prewittVerticalMatrix[][] =   {{1,0,-1},
                                           {1,0,-1},
                                           {1,0,-1}};
        
        
        
        
        
        
        
        //SET INITIAL ACCTION LISTENER END
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //funkcje
        
        //for FILES START
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                fileOperations.openFile(mainFrame);
            }
        });
        
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    fileOperations.saveFile(mainFrame);
                } catch (IOException ex) {
                    Logger.getLogger(OptionPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //for FILES END
        
        
        //for FILTERS START
        median.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              statisticFunction.statisticFunction(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Median");
              mainFrame.revalidate();
            }
        });
        
        maximal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              statisticFunction.statisticFunction(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Maximal");
              mainFrame.revalidate();
            }
        });
        
        minimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              statisticFunction.statisticFunction(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Minimal");
              mainFrame.revalidate();
            }
        });
        
        prewittHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), prewittHorizontalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        prewittVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), prewittVerticalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        sobelHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), sobelHorizontalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        sobelVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), sobelVerticalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lapVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lapVerticalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lapHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lapHorizontalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lapOblique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lapObliqueMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lap3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lap3Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lap2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lap2Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lap1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lap1Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        eastE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingEastMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        westE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingWestMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        southE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingSouthMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        northE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingNorthMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        northwestE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingNorthWestMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
         southwestE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingSouthWestMatrix, 3);
              mainFrame.revalidate();
            }
        });
         
         northeastE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingNorthEastMatrix, 3);
              mainFrame.revalidate();
            }
        });
         
        southeastE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), embossingSouthEastMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        northeast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), northEastMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        southeast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), southEastMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        northwest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), northWestMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        southwest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), southWestMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        south.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), southMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        north.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), northMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        east.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), eastMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        west.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), westMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        oblique2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), oblique2Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        oblique1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), oblique1Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        horizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), horizontalMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
         vertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), verticalMatrix, 3);
              mainFrame.revalidate();
            }
        });
         
        removeAverage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), removeAverageMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        hp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), hp3Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        hp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), hp2Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        hp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), hp1Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        gauss1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), gauss1Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lP3Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lP2Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        lp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), lP1Matrix, 3);
              mainFrame.revalidate();
            }
        });
        
        averaging.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
              matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), averagingMatrix, 3);
              mainFrame.revalidate();
            }
        });
        
        blueFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "blue", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        greenFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "green", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        redFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "red", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        yellowFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "yellow", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        purpleFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "purple", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        cyanFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "cyan", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        bright.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "white", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        dark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "black", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        negative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "negative", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        greyScale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "greyScale", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        sepia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "sepia", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        accent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    hsvFilters.hsvFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "sepia", sideMenu.getTextFieldValue(),50);
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        solarCustom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.solarFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "sepia", sideMenu.getTextFieldValue(),40);
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        solarDefault.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "solarisation", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        gamma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "gamma", sideMenu.getTextFieldValue());
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
        
        exposition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               mainFrame.add(sideMenu.setSideMenu(), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "exposition", -2); //zmieniamy suwakiem wartośc EV - małe wartość (-4,4)
                    mainFrame.revalidate();
                    }
                });
              mainFrame.revalidate();
            }
        });
         //for FILTERS END
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return menuBar;
    }
    
     public void setProperMainFrame(MainFrame mF) {
        this.mainFrame = mF;
    }
    
     public void setProperUndoRedo(UndoRedoOperations ur) {
        this.undoRedo = ur;
    }
     
     public void setProperOptionPanelButtons(OptionPanelButtons opb) {
        this.optionPanelButtons = opb;
    }
}
