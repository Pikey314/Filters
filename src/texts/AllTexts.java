/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

/**
 *
 * @author Maciek P
 */
public class AllTexts {
    //kolory
    public static String redFilterText = "Filtr czerwony\n\nZwiększa dominacje koloru czerwonego w obrazie\n\nZmniejsz wartość składowych niebieskiej i zielonej w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String greenFilterText = "Filtr zielony\n\nZwiększa dominacje koloru zielonego w obrazie\n\nZmniejsz wartość składowych czerwonej i niebieskiej w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String blueFilterText = "Filtr niebieski\n\nZwiększa dominacje koloru niebieskiego w obrazie\n\nZmniejsz wartość składowych czerwonej i zielonej w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String yellowFilterText = "Filtr zółty\n\nZwiększa dominacje koloru żółtego w obrazie\n\nZmniejsz wartość składowej niebieskiej w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String purpleFilterText = "Filtr fioletowy\n\nZwiększa dominacje koloru fioletowego w obrazie\n\nZmniejsz wartość składowej zielonej w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String cyanFilterText = "Filtr cyjanowy\n\nZwiększa dominacje koloru cyjanowego w obrazie\n\nZmniejsz wartość składowej czerwonej w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String ownColorFilterText = "Stwórz własny kolor\n\nZa pomocą suwaków zmniejsz lub zwiększ wartości kolorów czerwonego, zielonego i niebieskiego w obrazie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    
    //jasnosc/ciemnosc
    public static String brightFilterText = "Filtr rozjaśniający\n\nZwiększa jasność obrazu\n\nWybierz skale jasności w obrazie za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String darkFilterText = "Filtr przyciemniający\n\nZmniejsza jasność obrazu\n\nWybierz skale przyciemnienia obrazu za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    
    //filtry symetryczne
    public static String negativeFilterText = "Negatyw obrazu\n\nWprowadź efekt negatywu na obraz\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String greyScaleFilterText = "Skala szarości\n\nWprowadź efekt skali szarości na obraz\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String sepiaFilterText = "Sepia\n\nWprowadź efekt sepii na obraz\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";

   //filtry dolnoprzepystowe
    public static String averageFilterText = "Filtr Uśredniający\n\nFiltr Powodujący rozmycie obrazu\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String lp1FilterText = "Filtr LP1\n\nFiltr Powodujący rozmycie obrazu (mniejsze niż filtr uśredniający)\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String lp2FilterText = "Filtr LP2\n\nFiltr Powodujący rozmycie obrazu (mniejsze niż filtr LP1)\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String lp3FilterText = "Filtr LP3\n\nFiltr Powodujący rozmycie obrazu (mniejsze niż filtr LP2)\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String gauss1FilterText = "Filtr Gaussa1\n\nFiltr Powodujący rozmycie obrazu macierzą gaussa 3x3\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";    
    
    //filtry górnoprzepustowe
    public static String removeAverageFilterText = "Filtr usuwający średnią\n\nFiltr Powodujący wyostrzenie obrazu oraz wzmocnienie szumów\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String hp1FilterText = "Filtr HP1\n\nFiltr Powodujący wyostrzenie obrazu z lżejszym wzmocnieniem szumów niż usuwanie średniej\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String hp2FilterText = "Filtr HP2\n\nFiltr Powodujący wyostrzenie obrazu z lżejszym wzmocnieniem szumów niż HP1\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String hp3FilterText = "Filtr HP3\n\nFiltr Powodujący wyostrzenie obrazu z lżejszym wzmocnieniem szumów niż HP2\n\nWybierz moc rozmycia za pomocą suwaka\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";

    //filtry przesuwania i odejmowania
    public static String verticalFilterText = "Filtr Pionowy\n\nFiltr wykrywający krawędzie pionowe w obrazie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String horizontalFilterText = "Filtr Poziomy\n\nFiltr wykrywający krawędzie poziome w obrazie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String oblique1FilterText = "Filtr Ukośny 1\n\nFiltr wykrywający krawędzie ukośne (w kierunku prawej dolnej krawędzi) w obrazie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String oblique2FilterText = "Filtr Ukośny 2\n\nFiltr wykrywający krawędzie ukośne (w kierunku lewej dolnej krawędzi) w obrazie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    
    //filtry gradientowe
    public static String westGradientFilterText = "Filtr Gradientowy Zachodni\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String eastGradientFilterText = "Filtr Gradientowy Wschodni\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String nothGradientFilterText = "Filtr Gradientowy Północny\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String southGradientFilterText = "Filtr Gradientowy Południowy\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String southEastGradientFilterText = "Filtr Gradientowy Południowo-Wschodni\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String southWestGradientFilterText = "Filtr Gradientowy Połódniowo-Zachodni\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String northWestGradientFilterText = "Filtr Gradientowy Północno-Zachodni\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String northEastGradientFilterText = "Filtr Gradientowy Północno-Wschodni\n\nFiltr wykrywający krawędzie metodą gradientową zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    
    //filtry Uwypuklające
    public static String westEmbossingFilterText = "Filtr Uwypuklający Zachodni\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String eastEmbossingFilterText = "Filtr Uwypuklający Wschodni\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String nothEmbossingFilterText = "Filtr Uwypuklający Północny\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String southEmbossingFilterText = "Filtr Uwypuklający Południowy\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String southEastEmbossingFilterText = "Filtr Uwypuklający Południowo-Wschodni\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String southWestEmbossingFilterText = "Filtr Uwypuklający Połódniowo-Zachodni\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String northWestEmbossingFilterText = "Filtr Uwypuklający Północno-Zachodni\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String northEastEmbossingFilterText = "Filtr Uwypuklający Północno-Wschodni\n\nFiltr wprowadzający złudzenie wypukłości na krawędziach zgdonie z kierunkiem podanym w nazwie\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    
    //filtry Laplace'a
    public static String lap1FilterText = "Filtr Laplace'a 1\n\nFiltr wykrywający krawędzie we wszystkich kierunkach zgodnie z macierzą LAPL1\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String lap2FilterText = "Filtr Laplace'a 2\n\nFiltr wykrywający krawędzie we wszystkich kierunkach zgodnie z macierzą LAPL2\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String lap3FilterText = "Filtr Laplace'a 3\n\nFiltr wykrywający krawędzie we wszystkich kierunkach zgodnie z macierzą LAPL3\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String lapObliqueFilterText = "Filtr Laplace'a ukośny\n\nFiltr wykrywający krawędzie w ukośnych kierunkach\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";

    //filtry konturowe
    public static String sobelVerticalFilterText = "Filtr Sobela Pionowy\n\nFiltr wykrywający krawędzie pionowe zgodnie z metodą Sobela\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String sobelHorizontalFilterText = "Filtr Sobela Pionowy\n\nFiltr wykrywający krawędzie poziome zgodnie z metodą Sobela\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String prewittVerticalFilterText = "Filtr Prewitta Pionowy\n\nFiltr wykrywający krawędzie pionowe zgodnie z macierzą Prewitta\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";
    public static String prewittHorizontalFilterText = "Filtr Prewitta Poziomy\n\nFiltr wykrywający krawędzie poziome zgodnie z metodą Prewitta\n\nWciśnij przycisk 'Zatwiedź' aby zaobserwować zmiany";


}
