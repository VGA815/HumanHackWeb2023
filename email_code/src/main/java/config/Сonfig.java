package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Сonfig {
	String apikey;
	String disgustingMail;
	String textMessage;
	
	public Сonfig(){
		try {
			Scanner sc;sc = new Scanner(new File("config/config.cfg") ,  StandardCharsets.UTF_8.name());
			 this.apikey=encrypt(sc.nextLine(), "у");
			 this.disgustingMail=sc.nextLine();
			 this.textMessage=sc.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static String encrypt(String input, String key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = (char) (input.charAt(i) ^ key.charAt(i % key.length()));
            encryptedText.append(c);
        }
        return encryptedText.toString();
    }

	
	
	 	public String getApiKey() {
	        return apikey;
	    }

	    public String getDisgustingMail() {
	        return disgustingMail;
	    }

	    public String getTextMessage() {
	        return textMessage;
	    }
}
