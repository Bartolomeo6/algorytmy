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

        System.out.println(haslo);

    }
}