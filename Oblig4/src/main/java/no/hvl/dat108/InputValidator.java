package no.hvl.dat108;

public class InputValidator {

	    public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
	    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
	    public static final String SIX_OR_MORE_TIMES = "{6,}";
	    public static final String TWO_TIL_FOURTHY = "{2,40}";
	    public static final String EIGHT_DIGIT_LONG = "\\d{8}";

	    //Etternavn må være 2 lang og inneholde kun bokstaver
	    public static boolean gyldigEtternavn(String etternavn) {
	    	return etternavn != null && etternavn.matches("^" + ANY_LETTER + TWO_TIL_FOURTHY + "$");
	    }
	    //Passordet kan inneholde tegn + digit og må være minst 
	    public static boolean gyldigPassord(String passord) {
	    	return passord != null && passord.matches("^"+ ANY_LETTER_OR_DIGIT + SIX_OR_MORE_TIMES +"$");
	    }
	    //Må være likt på passord og ikkje tomt
//	    public static boolean gyldigRepetertPassord(String repetertPassord) {
//	    	return repetertPassord != null && repetertPassord.compareTo(String passord);
//	    }
	    //Fornavn må være 2 lang og innholde kun bokstaver
	    public static boolean gyldigFornavn(String fornavn) {
	    	return fornavn != null && fornavn.matches("^"+ ANY_LETTER + TWO_TIL_FOURTHY +"$");
	    }
	    //Mobil må være nøyaktig 8 og ikkje være registrert før
	    public static boolean gyldigMobil(String mobil) {
	    	//Les gjennom deltagerliste?
	    	return mobil != null && mobil.equals("^"+ EIGHT_DIGIT_LONG +"$");
	    }
	}