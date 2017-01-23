/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import colorModelFunctions.HSVModelFunctions;
import colorModelFunctions.RGBModelFunctions;
import guiOperations.FileOperations;
import guiOperations.UndoRedoOperations;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import matrixModelFunctions.MatrixFunctions;
import matrixModelFunctions.StatisticFunctions;
import matrixes.Matrixes3;
import matrixes.Matrixes5;
import matrixes.Matrixes7;
import texts.AllTexts;

/**
 *
 * @author Maciek P
 */
public class MenuBar {
    
    private final RGBModelFunctions rgbFilters = new RGBModelFunctions();
    private final HSVModelFunctions hsvFilters = new HSVModelFunctions();
    private final MatrixFunctions matrixFunction = new MatrixFunctions();
    private final FileOperations fileOperations = new FileOperations();
    private final SideMenu sideMenu = new SideMenu();
    private final StatisticFunctions statisticFunction = new StatisticFunctions();
    private final Matrixes3 matrixes3 = new Matrixes3();
    private final Matrixes5 matrixes5 = new Matrixes5();
    private MainFrame mainFrame;
    private UndoRedoOperations undoRedo;
    private OptionPanelButtons optionPanelButtons;
    
    
    public JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("   Plik   ");
            JMenuItem openFile = new JMenuItem("Otwórz Nowy Plik");
            JMenuItem saveFile = new JMenuItem("Zapisz Na Dysku");
        file.add(openFile);
        file.addSeparator();
        file.add(saveFile);
            
        JMenu filters = new JMenu("Wszystkie");
            JMenu colorFilters = new JMenu("   Kolor   ");
                JMenuItem redFilter = new JMenuItem("Czerwony"); //filtr czerwony
                JMenuItem greenFilter = new JMenuItem("Zielony"); //filtr zielony
                JMenuItem blueFilter = new JMenuItem("Niebieski"); //filtr niebieski
                JMenuItem yellowFilter = new JMenuItem("Żółty"); //filtr żółty
                JMenuItem purpleFilter = new JMenuItem("Fioletowy"); //filtr fioletowy
                JMenuItem cyanFilter = new JMenuItem("Cyjanowy"); //filtr cyjanowy
                JMenuItem ownColor = new JMenuItem("Stwórz własny kolor");
            colorFilters.add(redFilter);
            colorFilters.add(greenFilter);
            colorFilters.add(blueFilter);
            colorFilters.add(yellowFilter);
            colorFilters.add(purpleFilter);
            colorFilters.add(cyanFilter);
            colorFilters.add(ownColor);
        filters.add(colorFilters);
            JMenu brightFilters = new JMenu("   Jasność   ");
                JMenuItem dark = new JMenuItem("Przyciemnienie"); //filtr ciemny
                JMenuItem bright = new JMenuItem("Rozjaśnienie"); //filtr jasny
            brightFilters.add(dark);
            brightFilters.add(bright);
        filters.add(brightFilters);
            JMenu symetric = new JMenu("   Efekty   ");
                JMenuItem negative = new JMenuItem("Negatyw"); //filtr negatyw
                JMenuItem greyScale = new JMenuItem("Odcień Szarości");
                JMenuItem sepia = new JMenuItem("Sepia");
                JMenuItem solarDefault = new JMenuItem("Solaryzacja");//Solaryzajca (normalna)
            symetric.add(negative);
            symetric.add(greyScale);
            symetric.add(sepia);
            symetric.add(solarDefault);
        filters.add(symetric);
            JMenu lowPass = new JMenu("   Dolnoprzepustowe   "); //filtry dolnoprzepustowe
                JMenuItem averaging = new JMenuItem("Uśrednienie"); //filtr usredniający (rozmwyanie)
                JMenuItem lp1 = new JMenuItem("Rozmycie LP1"); //filtr LP1 (rozmwyanie)
                JMenuItem lp2 = new JMenuItem("Rozmycie LP2"); //filtr LP2 (rozmwyanie)
                JMenuItem lp3 = new JMenuItem("Rozmycie LP3"); //filtr LP3 (rozmwyanie)
                JMenuItem gauss1 = new JMenuItem("Gauss 1"); //filtr Gauss1 (rozmwyanie)
                JMenuItem gauss2 = new JMenuItem("Gauss 2"); //filtr Gauss1 (rozmwyanie)
                JMenuItem gauss3 = new JMenuItem("Gauss 3"); //filtr Gauss1 (rozmwyanie)
                JMenuItem gauss4 = new JMenuItem("Gauss 4"); //filtr Gauss1 (rozmwyanie)
                JMenuItem gauss5 = new JMenuItem("Gauss 5"); //filtr Gauss1 (rozmwyanie)
                JMenuItem piramide = new JMenuItem("Piramidowy"); //filtr Gauss1 (rozmwyanie)
                JMenuItem cone = new JMenuItem("Stożkowy"); //filtr Gauss1 (rozmwyanie)
                JMenuItem circle = new JMenuItem("Kołowy"); //filtr Gauss1 (rozmwyanie)
            lowPass.add(averaging);
            lowPass.add(lp1);
            lowPass.add(lp2);
            lowPass.add(lp3);
            lowPass.add(gauss1);
            lowPass.add(gauss2);
            lowPass.add(gauss3);
            lowPass.add(gauss4);
            lowPass.add(gauss5);
            lowPass.add(piramide);
            lowPass.add(cone);
            lowPass.add(circle);
        filters.add(lowPass);
            JMenu highPass = new JMenu("   Górnoprzepustowe   "); //filtry górnoprzepustowe
                JMenuItem removeAverage = new JMenuItem("Usuwanie średniej"); //filtr usuń średnią (wysostrzanie)
                JMenuItem hp1 = new JMenuItem("Filtr HP1"); //filtr HP1
                JMenuItem hp2 = new JMenuItem("Filtr HP2"); //filtr HP2
                JMenuItem hp3 = new JMenuItem("Filtr HP3"); //filtr HP3
            highPass.add(removeAverage);
            highPass.add(hp1);
            highPass.add(hp2);
            highPass.add(hp3);
        filters.add(highPass);
            JMenu edges = new JMenu("   Krawędzie   ");
                JMenuItem vertical = new JMenuItem("Wykrywanie Pionowe");  //fitr pionowy
                JMenuItem horizontal = new JMenuItem("Wykrywanie Poziome"); //filtr poziomy
                JMenuItem oblique1 = new JMenuItem("Wykrywanie Ukośne 1"); //filtr ukośny 1
                JMenuItem oblique2 = new JMenuItem("Wykrywanie Ukośne 2"); //filtr ukośny 2
            edges.add(vertical);
            edges.add(horizontal);
            edges.add(oblique1);
            edges.add(oblique2);
                JMenuItem west = new JMenuItem("Gradient Zachodni"); //filtr zachodni
                JMenuItem east = new JMenuItem("Gradient Wschodni"); //filtr wschodni
                JMenuItem north = new JMenuItem("Gradient Północny"); //filtr północny
                JMenuItem south = new JMenuItem("Gradient Południowy"); //filtr południowy
                JMenuItem northwest = new JMenuItem("Gradient Płn-Zach"); //filtr północno - zachodni
                JMenuItem southwest = new JMenuItem("Gradient Płd-Zach"); //filtr południowo - zachodni
                JMenuItem northeast = new JMenuItem("Gradient Płn-Wsch"); //filtr północno - wschodni
                JMenuItem southeast = new JMenuItem("Gradient Płd-Wsch"); //filtr południowo - wschodni
            edges.add(west);
            edges.add(east);
            edges.add(north);
            edges.add(south);
            edges.add(northwest);
            edges.add(southwest);
            edges.add(northeast);
            edges.add(southeast);
            JMenu embossing = new JMenu("   Uwypuklanie   "); //filtry uwypuklające
                JMenuItem westE = new JMenuItem("Zachodni"); //filtr zachodni
                JMenuItem eastE = new JMenuItem("Wschodni"); //filtr wschodni
                JMenuItem northE = new JMenuItem("Północny"); //filtr północny
                JMenuItem southE = new JMenuItem("Południowy"); //filtr południowy
                JMenuItem northwestE = new JMenuItem("Płn-Zach"); //filtr północno - zachodni
                JMenuItem southwestE = new JMenuItem("Płd-Zach"); //filtr południowo - zachodni
                JMenuItem northeastE = new JMenuItem("Płn-Wsch"); //filtr północno - wschodni
                JMenuItem southeastE = new JMenuItem("Płd-Wsch"); //filtr południowo - wschodni
                JMenuItem strongE = new JMenuItem("Mocny"); //filtr południowo - wschodni
           embossing.add(westE); 
           embossing.add(eastE);
           embossing.add(northE);
           embossing.add(southE);
           embossing.add(northwestE);
           embossing.add(southwestE);
           embossing.add(northeastE);
           embossing.add(southeastE);
           embossing.add(strongE);
        filters.add(embossing);
                JMenuItem lap1 = new JMenuItem("Laplace 1");
                JMenuItem lap2 = new JMenuItem("Laplace 2");
                JMenuItem lap3 = new JMenuItem("Laplace 3");
                JMenuItem lapOblique = new JMenuItem("Laplace ukośny");
                JMenuItem lapHorizontal = new JMenuItem("Laplace Poziomy");
                JMenuItem lapVertical = new JMenuItem("Laplace Pionowy");
            edges.add(lap1);
            edges.add(lap2);
            edges.add(lap3);
            edges.add(lapOblique);
            edges.add(lapHorizontal);
            edges.add(lapVertical);
                JMenuItem sobelVertical = new JMenuItem("Sobel Pionowy");
                JMenuItem sobelHorizontal = new JMenuItem("Sobel Poziomy");
                JMenuItem prewittVertical = new JMenuItem("Prewitt Pionowy");
                JMenuItem prewittHorizontal = new JMenuItem("Prewitt Poziomy");
            edges.add(sobelVertical);
            edges.add(sobelHorizontal);
            edges.add(prewittVertical);
            edges.add(prewittHorizontal);
        filters.add(edges);
            JMenu statistics = new JMenu("   Styl   ");
                JMenuItem median = new JMenuItem("Medianowy");
                JMenuItem maximal = new JMenuItem("Maksymalny");
                JMenuItem minimal = new JMenuItem("Minimalny");
            statistics.add(median);
            statistics.add(maximal);
            statistics.add(minimal);
        filters.add(statistics);
            JMenu HSVModel = new JMenu("   Model HSV   ");
                JMenuItem accent = new JMenuItem("Akcent");
                JMenuItem color = new JMenuItem("Kolor");
                JMenuItem saturation = new JMenuItem("Nasycenie");
                JMenuItem light = new JMenuItem("Jasność");
            HSVModel.add(accent);
            HSVModel.add(color);
            HSVModel.add(saturation);
            HSVModel.add(light);
        filters.add(HSVModel);
            JMenu inverting = new JMenu("   Dostosowanie   ");
                JMenuItem gamma = new JMenuItem("Korekcja Gamma");//Gamma
                JMenuItem exposition = new JMenuItem("Ekspozycja");//Expozycja
            inverting.add(gamma);
            inverting.add(exposition);
        filters.add(inverting);
            JMenu histogram = new JMenu("   Histogram   ");
                JMenuItem rozciaganie = new JMenuItem("Rozciaganie");
            histogram.add(rozciaganie);
        filters.add(histogram);
            JMenu createOwnFilters = new JMenu("   Stwórz Własny Filtr   ");
                JMenuItem own3x3Filter = new JMenuItem("Mały Filtr");
                JMenuItem own5x5Filter = new JMenuItem("Duży Filtr");
            createOwnFilters.add(own3x3Filter);
            createOwnFilters.add(own5x5Filter);
        filters.add(createOwnFilters);
        menuBar.add(file);
        //menuBar.add(filters);
        menuBar.add(colorFilters);
        menuBar.add(brightFilters);
        menuBar.add(symetric);
        menuBar.add(lowPass);
        menuBar.add(highPass);
        menuBar.add(embossing);
        menuBar.add(edges);
        menuBar.add(statistics);
        menuBar.add(HSVModel);
        menuBar.add(inverting);
        menuBar.add(histogram);
        menuBar.add(createOwnFilters);
        
        
        //SET INITIAL ACCTION LISTENER START
        sideMenu.getAcceptButton().addActionListener((ActionEvent event) -> {
        });
        //SET INITIAL ACCTION LISTENER END
        

        //funkcje
        
        //for FILES START
        openFile.addActionListener((ActionEvent event) -> {
            fileOperations.openFile(mainFrame);
        });
        
        saveFile.addActionListener((ActionEvent event) -> {
            try {
                fileOperations.saveFile(mainFrame);
            } catch (IOException ex) {
                Logger.getLogger(OptionPanelButtons.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //for FILES END
        
        
        //for FILTERS START
        median.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Moc",1,3,1,1,1,AllTexts.medianFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                if (sideMenu.getTextField1Value() == 1)
                   statisticFunction.statisticFunction3x3(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Median");
                else if (sideMenu.getTextField1Value() == 2)
                   statisticFunction.statisticFunction5x5(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Median");
                else
                   statisticFunction.statisticFunction7x7(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Median");
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        maximal.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Moc",1,3,1,1,1,AllTexts.maximalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                if (sideMenu.getTextField1Value() == 1)
                   statisticFunction.statisticFunction3x3(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Maximal");
                else if (sideMenu.getTextField1Value() == 2)
                   statisticFunction.statisticFunction5x5(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Maximal");
                else
                   statisticFunction.statisticFunction7x7(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Maximal");
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        minimal.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Moc",1,3,1,1,1,AllTexts.minimalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                if (sideMenu.getTextField1Value() == 1)
                   statisticFunction.statisticFunction3x3(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Minimal");
                else if (sideMenu.getTextField1Value() == 2)
                   statisticFunction.statisticFunction5x5(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Minimal");
                else
                   statisticFunction.statisticFunction7x7(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "Minimal");
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        prewittHorizontal.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.prewittHorizontalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.prewittHorizontalMatrix, 3);
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        prewittVertical.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.prewittVerticalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.prewittVerticalMatrix, 3);
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        sobelHorizontal.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.sobelHorizontalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.sobelHorizontalMatrix, 3);
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        sobelVertical.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.sobelVerticalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.sobelVerticalMatrix, 3);
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        lapVertical.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.lapVerticalFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lapVerticalMatrix, 3);
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        lapHorizontal.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.lapHorizontalFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lapHorizontalMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lapOblique.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.lapObliqueFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lapObliqueMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lap3.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.lap3FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lap3Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lap2.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.lap2FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lap2Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lap1.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.lap1FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lap1Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        eastE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.eastEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingEastMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        westE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.westEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingWestMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        southE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.southEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingSouthMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        northE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.nothEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingNorthMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        northwestE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.northWestEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingNorthWestMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
         southwestE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.southWestEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingSouthWestMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
         
         northeastE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.northEastEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingNorthEastMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
         
        southeastE.addActionListener((ActionEvent event) -> {
              mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.southEastEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingSouthEastMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        northeast.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.northEastGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.northEastMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        southeast.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.southEastGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.southEastMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        northwest.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.northWestGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.northWestMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        southwest.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.southWestGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.southWestMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        south.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.southGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.southMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        north.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.northGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.northMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        east.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.eastGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.eastMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        west.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.westGradientFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.westMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        oblique2.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.oblique2FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.oblique2Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        oblique1.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.oblique1FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.oblique1Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        horizontal.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.horizontalFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.horizontalMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
         vertical.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.verticalFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.verticalMatrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
         
        removeAverage.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Moc",1,3,1,1,1,AllTexts.removeAverageFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    if (sideMenu.getTextField1Value() == 1)
                        matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.removeAverageMatrix, 3);
                    else if (sideMenu.getTextField1Value() == 2)
                        matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.removeAverageMatrix, 5);
                    else 
                        matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.removeAverageMatrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        hp3.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.hp3FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.hp3Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        hp2.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.hp2FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.hp2Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        hp1.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.hp1FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.hp1Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        gauss1.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.gauss1FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.gauss1Matrix, 3);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        gauss2.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.gauss2FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.gauss2Matrix, 5);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        gauss3.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.gauss3FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.gauss3Matrix, 5);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        gauss4.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.gauss4FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.gauss4Matrix, 5);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        gauss5.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.gauss5FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.gauss5Matrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        cone.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.coneFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.coneMatrix, 5);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        circle.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.circleFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.circleMatrix, 5);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        piramide.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.piramideFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.piramideMatrix, 5);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        strongE.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Moc", 1,3,1,1,1,AllTexts.strongEmbossingFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    if (sideMenu.getTextField1Value() == 1)
                        matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.embossingNorthMatrix, 3);
                    else if (sideMenu.getTextField1Value() == 2)
                        matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.embossingNorthMatrix, 5);
                    else
                        matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.embossingNorthMatrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lp3.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Moc", 1,3,1,1,1,AllTexts.lp3FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    if (sideMenu.getTextField1Value() == 1)
                        matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lP3Matrix, 3);
                    else if (sideMenu.getTextField1Value() == 2)
                        matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.lP3Matrix, 5);
                    else 
                        matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.lP3Matrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lp2.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Moc", 1,3,1,1,1,AllTexts.lp2FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    if (sideMenu.getTextField1Value() == 1)
                        matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lP2Matrix, 3);
                    else if (sideMenu.getTextField1Value() == 2)
                        matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.lP2Matrix, 5);
                    else 
                        matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.lP2Matrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        lp1.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Moc", 1,3,1,1,1,AllTexts.lp1FilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    if (sideMenu.getTextField1Value() == 1)
                        matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.lP1Matrix, 3);
                    else if (sideMenu.getTextField1Value() == 2)
                        matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.lP1Matrix, 5);
                    else 
                        matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.lP1Matrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        averaging.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Moc", 1,3,1,1,1,AllTexts.averageFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    if (sideMenu.getTextField1Value() == 1)
                        matrixFunction.matrix3x3Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes3.averagingMatrix, 3);
                    else if (sideMenu.getTextField1Value() == 2)
                        matrixFunction.matrix5x5Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes5.averagingMatrix, 5);
                    else 
                        matrixFunction.matrix7x7Funtion(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), Matrixes7.averagingMatrix, 7);
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        blueFilter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu1Slider("Wartość",0,255,177,51,1, AllTexts.blueFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "blue", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        greenFilter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu1Slider("Wartość", 0,255,177,51,1,AllTexts.greenFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "green", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        redFilter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu1Slider("Wartość",0,255,177,51,1, AllTexts.redFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "red", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        yellowFilter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu1Slider("Wartość",0,255,177,51,1, AllTexts.yellowFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                        undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "yellow", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        purpleFilter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu1Slider("Wartość",0,255,177,51,1, AllTexts.purpleFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "purple", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        cyanFilter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu1Slider("Wartość",0,255,177,51,1, AllTexts.cyanFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "cyan", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        ownColor.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu3Sliders("Czerwony", -255,255,0,100,10, "Zielony", -255,255,0,100,10, "Niebieski", -255,255,0,100,10,AllTexts.ownColorFilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.ownRGBFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "ownColor", sideMenu.getTextField1Value(), sideMenu.getTextField2Value(), sideMenu.getTextField3Value());
                    mainFrame.revalidate();
                });
              mainFrame.revalidate();
        });
        
        bright.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", 0,255,177,51,1,AllTexts.brightFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "white", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
                mainFrame.revalidate();
        });
        
        dark.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", 0,255,177,51,1,AllTexts.darkFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "black", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
                mainFrame.revalidate();
        });
        
        negative.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.negativeFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "negative", 0);
                    mainFrame.revalidate();
                });
                mainFrame.revalidate();
        });
        
        greyScale.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.greyScaleFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "greyScale", 0);
                    mainFrame.revalidate();
                });
                mainFrame.revalidate();
        });
        
        sepia.addActionListener((ActionEvent event) -> {
                mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", 20,40,30,5,1,AllTexts.sepiaFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "sepia", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
                });
                mainFrame.revalidate();
        });
        
        accent.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.setSideMenu2Sliders("Kolor", 0,360,180,72,2, "Zakres", 0, 180, 20, 36,1,AllTexts.accentFilterText), BorderLayout.WEST);
                sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
                sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    hsvFilters.hsvFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "accent", sideMenu.getTextField1Value(),sideMenu.getTextField2Value());
                    mainFrame.revalidate();
                });
                mainFrame.revalidate();
        });
        
        color.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", -180,180,0,72,2,AllTexts.colorHSVFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    hsvFilters.hsvFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "color", sideMenu.getTextField1Value(),0);
                    mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        light.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", -255,255,0,100,5,AllTexts.lightFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    hsvFilters.hsvFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "light", sideMenu.getTextField1Value(),0);
                    mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
         
        saturation.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", -100,100,0,50,2,AllTexts.saturationFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    hsvFilters.hsvFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "saturation", sideMenu.getTextField1Value(),0);
                    mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
  
        
        solarDefault.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", 0,255,177,51,1,AllTexts.solarisationFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "solarisation", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        gamma.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", 1,50,22,5,1,AllTexts.gammaFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "gamma", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        exposition.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setSideMenu1Slider("Poziom", -10,10,2,2,1,AllTexts.expositionFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                    undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                    rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "exposition", sideMenu.getTextField1Value());
                    mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        rozciaganie.addActionListener((ActionEvent event) -> {
            mainFrame.add(sideMenu.setEmptySideMenu(AllTexts.histogramExtendFilterText), BorderLayout.WEST);
            sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
            sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                undoRedo.addToUndoList(mainFrame.getImageToSave(), optionPanelButtons.getUndoButton());
                rgbFilters.rgbFilter(mainFrame.getImageToSave(), mainFrame.getPicturePanel(), "histogramExtend", -1);
                mainFrame.revalidate();
            });
            mainFrame.revalidate();
        });
        
        own3x3Filter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.ownFilter3x3SidePanel(AllTexts.own3x3FilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                        matrixes3.setOwnMatrix(sideMenu.getOwnMatrix3x3());
                        optionPanelButtons.setFunctionalityForMyFilter3x3(sideMenu.getMatrixFirst3x3Button(), mainFrame.getImageToSave(), mainFrame.getPicturePanel(), matrixes3.getOwnMatrix(), sideMenu.getTextField1Value(), sideMenu.getTextField2Value(), sideMenu.getTextField3Value());
               });
               mainFrame.revalidate();
        });
        
        own5x5Filter.addActionListener((ActionEvent event) -> {
               mainFrame.add(sideMenu.ownFilter5x5SidePanel(AllTexts.own5x5FilterText), BorderLayout.WEST);
               sideMenu.getAcceptButton().removeActionListener(sideMenu.getAcceptButton().getActionListeners()[0]);
               sideMenu.getAcceptButton().addActionListener((ActionEvent event1) -> {
                   matrixes5.setOwnMatrix(sideMenu.getOwnMatrix5x5());
                   optionPanelButtons.setFunctionalityForMyFilter5x5(sideMenu.getMatrixFirst5x5Button(), mainFrame.getImageToSave(), mainFrame.getPicturePanel(), matrixes5.getOwnMatrix(), sideMenu.getTextField1Value(), sideMenu.getTextField2Value(), sideMenu.getTextField3Value());
               });
               mainFrame.revalidate();
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
     
     public UndoRedoOperations getUndoRedo(){
         return this.undoRedo;
     }
}
