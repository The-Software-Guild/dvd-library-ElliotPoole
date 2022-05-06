package dvdroster.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dvdroster.dto.dvd;

public class dvdRosterDaoFileImpl implements dvdRosterDao{

    private Map<String, dvd> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "src/main/java/dvdroster/roster.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public dvd addDVD(String title, dvd dvd) throws dvdRosterDaoException{
            dvd newdvd = dvds.put(title, dvd);
            return newdvd;
        }
    
    @Override
    public List<dvd> getAllDVDs() throws dvdRosterDaoException{
            return new ArrayList<>(dvds.values());
        }

    @Override
    public dvd getDVD(String title) throws dvdRosterDaoException{
            return dvds.get(title);
        }

    @Override
    public dvd removeDVD(String title) throws dvdRosterDaoException{
            return dvds.remove(title);
        }
    
    @Override
    public dvd editDVD(String title, dvd dvd) throws dvdRosterDaoException{
            dvd editdvd = dvds.replace(title, dvd);
            return editdvd;
        }

    @Override
    public List<String> searchDVD(String title, List<dvd> dvd) throws dvdRosterDaoException{
            List<String> dvdtitle = new ArrayList<>();
            for(dvd k : dvd){
                if(k.getTitle().substring(0,title.length()).equals(title)){
                    dvdtitle.add(k.getTitle());
                }
            }
            return dvdtitle;
        }

    @Override
    public void loadRoster() throws dvdRosterDaoException{
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(ROSTER_FILE))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(DELIMITER, 6);
                
                if (keyValuePair.length > 1) {
                    dvd DVD = new dvd(keyValuePair[0]);
                    
                    DVD.setReleaseDate(keyValuePair[1]);
                    DVD.setRating(keyValuePair[2]);
                    DVD.setDirector(keyValuePair[3]);
                    DVD.setStudio(keyValuePair[4]);
                    DVD.setUserNote(keyValuePair[5]);
                    
                    dvds.put(keyValuePair[0], DVD);
                } else {
                    System.out.println("No Key::Value found in line, ignoring: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeRoster() throws dvdRosterDaoException{
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new dvdRosterDaoException("Could not save DVD data.", e);
        }

        List<dvd> dvdList = this.getAllDVDs();
        for(dvd currentDVD : dvdList){
            out.println(currentDVD.getTitle()+DELIMITER+
                        currentDVD.getReleaseDate()+DELIMITER+
                        currentDVD.getRating()+DELIMITER+
                        currentDVD.getDirector()+DELIMITER+
                        currentDVD.getStudio()+DELIMITER+
                        currentDVD.getUserNote());
            out.flush();
        }
        out.close();
        }
}
