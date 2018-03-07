import java.util.Scanner;

public class GeneratorPesel {
	public static void main(String[] args) {
		int rok, miesiac, dzien, plec, plecNumer = 0, kontrolna;
		int[] pesel = new int[11];
		
		Scanner sc = new Scanner(System.in);
		
//		Pytamy o date urodzenia: rok, dzieñ, miesi¹c
		System.out.print("Podaj rok urodzenia: ");
		rok = sc.nextInt();
		System.out.print("Podaj miesiac urodzenia: ");
		miesiac = sc.nextInt();
		System.out.print("Podaj dzien urodzenia: ");
		dzien = sc.nextInt();	
		
//		pytamy o p³eæ
		System.out.print("Podaj p³eæ: Mê¿czyzna: 1, Kobieta: 2  ");
		plec = sc.nextInt(); 
		sc.close();
		
//		Jeœli wybrana p³eæ to kobieta to generujemy parzyst¹ liczbê 4 cyfrow¹, jeœli mê¿czyzna to nieparzyst¹
		int licznik = 0;
		while (licznik==0) {
			plecNumer = (int) (Math.random() * 10000);
			System.out.println("Losowanie liczby " + plecNumer);
			if (plec==1 && plecNumer%2 != 0) {
				licznik = 1;
			}
			else if (plec==2 && plecNumer%2 == 0) {
				licznik = 1;
			}
		}
				
//		Wprowadzamy do tablicy PESEL odpowiednie cyfry dla roku, miesi¹ca, dnia
		pesel[0] = rok/10%10;
		pesel[1] = rok%10;
		if (miesiac < 10) {
			pesel[2] = 0;
		}
		else {
			pesel[2] = 1;
		}
		pesel[3] = miesiac%10;
		if (dzien < 10) {
			pesel[4] = 0;
		}
		else {
			pesel[4] = dzien/10;
		}
		pesel[5] = dzien%10;

//		Wprowadzamy wygenerowan¹ liczbê dla p³ci, jeœli liczba by³a mniejsza ni¿ 1000 to dodajemy przedni¹ "0"
		if (plecNumer < 10) {
			pesel[6] = 0;
			pesel[7] = 0;
			pesel[8] = 0;
			pesel[9] = plecNumer;
		}
		else if (plecNumer < 100 && plecNumer >= 10) {
			pesel[6] = 0;
			pesel[7] = 0;
			pesel[8] = plecNumer/10;
			pesel[9] = plecNumer%10;
		}
		else if (plecNumer < 1000 && plecNumer >= 100) {
			pesel[6] = 0;
			pesel[7] = plecNumer/100;
			pesel[8] = plecNumer/10%10;
			pesel[9] = plecNumer%10;
		}
		else {
			pesel[6] = plecNumer/1000;
			pesel[7] = plecNumer/100%10;
			pesel[8] = plecNumer/10%10;
			pesel[9] = plecNumer%10;
		}
		
//		Generujemy kontroln¹ liczbê
		kontrolna = 1*pesel[0] + 3*pesel[1] + 7*pesel[2] + 9*pesel[3] + 1*pesel[4] + 3*pesel[5] + 7*pesel[6] + 9*pesel[7] + 1*pesel[8] + 3*pesel[9];
		kontrolna = kontrolna%10;
		kontrolna = 10 - kontrolna;
		kontrolna = kontrolna%10;
		pesel[10] = kontrolna;
		
		System.out.println("PESEL to: ");
		for (int kazdy: pesel) {
			System.out.print(kazdy);
		}
	}	
}
