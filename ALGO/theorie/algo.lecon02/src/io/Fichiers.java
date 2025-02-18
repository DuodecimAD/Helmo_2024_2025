package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fichiers {

	public static String[] lireCSV(String chemin) {
		List<String> lignes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                lignes.add(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
        return lignes.toArray(new String[lignes.size()]);
	}
}
