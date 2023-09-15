import java.util.Scanner;

public class Main {

    // SZYFR CEZARA + KLUCZ "3" (przesuwanie liter o "3" w prawo) //

    /**
     * szyfruj() -> metoda szyfrująca słowo szyfrem Cezara z kluczem
     * @param slowo -> słowo przekazane do zaszyfrowania
     * @param klucz -> liczba całkowita, która określa przesunięcie w alfabecie
     * @return -> zaszyfrowane słowo
     */

    public static String szyfruj(String slowo, int klucz){

        String szyfr = "";
        String alfabet = "abcdefghijklmnoprstuvwxyz";

        klucz = klucz % alfabet.length();

        String alfabetPrzesuniety = alfabet.substring(klucz) + alfabet.substring(0,klucz);

        for (int i = 0; i < slowo.length(); i++) {
            szyfr = szyfr + alfabetPrzesuniety.charAt(alfabet.indexOf(slowo.charAt(i)));
        }

        System.out.println(alfabet);
        System.out.println(alfabetPrzesuniety);

        return szyfr;
    }
    public static void main(String[] args) {

        System.out.println("Wpisz słowo: ");
        Scanner klawa = new Scanner(System.in);

        String tekst = klawa.nextLine();
        String haslo = szyfruj(tekst,3);

        System.out.println("Twoj tekst: "+tekst+"\n to teraz: "+haslo);         //szyfr

        System.out.println("------------------------------------");

        System.out.println(generujHaslo(9));        //generacja hasla

    }

    // ---------------------------------------------------------------- //

    //  LOSOWANIE HASLA 20-ZNAKOWEGO //

    public static String generujHaslo(int dl) {
        String password = "";

        String wszystkieZnaki = "";
        String maleLitery = "qwertyuiopasdfghjklzxcvbnm";
        String duzeLitery = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String znakiSpecjalne = "!@#$%^&*()_+{}:.,|<>?";
        String cyfry = "1234567890";

        wszystkieZnaki = maleLitery + duzeLitery + znakiSpecjalne + cyfry;

        for (int i = 0; i < dl; i++) {
            int losowa = (int)(Math.random()*wszystkieZnaki.length());
            password += wszystkieZnaki.charAt(losowa);
        }

        boolean czyMalaLitera = czyHasloZawieraCos(password, maleLitery);
        boolean czyDuzaLitera = czyHasloZawieraCos(password,duzeLitery);
        boolean czyZnakSpecjalny = czyHasloZawieraCos(password,znakiSpecjalne);
        boolean czyCyfra = czyHasloZawieraCos(password,cyfry);

        //TODO: DOKOŃCZ

        return password;
    }

    public static boolean czyHasloZawieraCos(String haslo, String ciag) {
        for (int i = 0; i < ciag.length(); i++) {

            char litera = ciag.charAt(i);
            if(haslo.indexOf(litera) >= 0) {
                return true;
            }

        }

        return false;
    }
}