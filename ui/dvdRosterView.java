package dvdroster.ui;

import java.util.List;
import java.util.Date;
import dvdroster.dto.dvd;

public class dvdRosterView {

    private userIO io;

    public dvdRosterView(userIO io){
        this.io = io;
    }

    public int  printAndGetSelectionMenu(){
        io.print("\nMain Menu");
        io.print("1. List DVD's");
        io.print("2. Add a new DVD");
        io.print("3. Remove a DVD");
        io.print("4. Edit a DVD");
        io.print("5. View a DVD");
        io.print("6. Search a DVD");
        io.print("7. Exit");

        io.print("\nPlease select from the choices above");
        return io.getInt(1,7);
    }

    public dvd getNewDVDInfo(){
        io.print("Please enter the title");
        String title       = io.getString();
        io.print("Please enter the release date");
        String releaseDate = io.getString();
        io.print("Please enter the rating");
        String rating      = io.getString();
        io.print("Please enter the director");
        String director    = io.getString();
        io.print("Please enter the studio");
        String studio      = io.getString();
        io.print("Please enter any additional notes");
        String userNote    = io.getString();

        dvd newDVD = new dvd(title);
        newDVD.setReleaseDate(releaseDate);
        newDVD.setRating(rating);
        newDVD.setDirector(director);
        newDVD.setStudio(studio);
        newDVD.setUserNote(userNote);
        return newDVD;
    }

    public void displayAddDVDBanner() {
        io.print("=== Adding a new DVD ===");
    }
    
    public void displayAddSuccessBanner() {
        io.print("DVD successfully added. Please hit enter to continue");
        io.next();
    }

    public void displayDVDList(List<dvd> DVDList) {
        for (dvd currentDVD : DVDList) {
            String DVDInfo = String.format("%s : %s, %s, %s, %s, %s",
                currentDVD.getTitle(),
                currentDVD.getReleaseDate(),
                currentDVD.getRating(),
                currentDVD.getDirector(),
                currentDVD.getStudio(),
                currentDVD.getUserNote());
            io.print(DVDInfo);
        }
        io.print("Please hit enter to continue.");
        io.next();
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Displaying All DVD's ===");
    }

    public void displayDisplayDVDBanner () {
        io.print("=== Displaying the DVD ===");
    }
    
    public String getDVDTitle() {
        io.print("Please enter the title of the DVD.");
        return io.getString();
    }

    public void displayDVD(dvd DVD) {
        if (DVD != null) {
            io.print("");
            io.print("Title: "+DVD.getTitle());
            io.print("Release Date: "+DVD.getReleaseDate());
            io.print("Rating: "+DVD.getRating());
            io.print("Director: "+DVD.getDirector());
            io.print("Studio: "+DVD.getStudio());
            io.print("User Notes: "+DVD.getUserNote());
            io.print("");
        } else {
            io.print("No such DVD exists in this database.");
        }
        io.print("Please hit enter to continue.");
        io.next();
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Removing a DVD ===");
    }
    
    public void displayRemoveResult(dvd DVDRecord) {
        if(DVDRecord != null){
          io.print("The DVD has been successfully removed.");
        }else{
          io.print("No such DVD exists in this database.");
        }
        io.print("Please hit enter to continue.");
        io.next();
    }

    public void displayEditDVDBanner(){
        io.print("=== Editing a DVD ===");
    }

    public void displayEditSuccessBanner(){
        io.print(" Successfully edited a DVD. Hit enter to continue");
        io.next();
    }

    public void displaySearchDVDBanner(){
        io.print("=== Searching for a DVD ===");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displaySearch(List<String> dvd) {
        io.print("Here are all of the DVD's that contain your search");
        for(String title : dvd){
            io.print(title);
        }
        io.print("press enter to continue");
        io.next();
    }

    public dvd editInfo(String title, dvd dvd) {
        io.print("Which piece of information would you like to change?");
        io.print("1. Release Date");
        io.print("2. Rating");
        io.print("3. Director");
        io.print("4. Studio");
        io.print("5. User Notes");
        io.print("6. Exit");

        

        second:
        while (true) {
            int choice = io.getInt(1,6);
            switch (choice) {
                case 1:
                    io.print("Please enter a new date");
                    dvd.setReleaseDate(io.getString());
                    break;
                case 2:
                    io.print("Please enter a new rating");
                    dvd.setRating(io.getString());
                    break;
                case 3:
                    io.print("Please enter a new director");
                    dvd.setDirector(io.getString());
                    break;
                case 4:
                    io.print("Pleasae enter a new studio");
                    dvd.setStudio(io.getString());
                    break;
                case 5:
                    io.print("Please enter a new user note");
                    dvd.setUserNote(io.getString());
                    break;
                case 6:
                    break second;
            }
            io.print("What else would you like to do?");
        }
        return dvd;
    }

}
