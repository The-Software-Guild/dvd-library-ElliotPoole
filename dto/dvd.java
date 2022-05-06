package dvdroster.dto;

public class dvd {
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String userNote;

    public dvd(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public String getRating(){
        return rating;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getDirector(){
        return director;
    }

    public void setStudio(String studio){
        this.studio = studio;
    }

    public String getStudio(){
        return studio;
    }

    public void setUserNote(String userNote){
        this.userNote = userNote;
    }

    public String getUserNote(){
        return userNote;
    }

}
