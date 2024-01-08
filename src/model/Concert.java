/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author LENOVO
 */
public abstract class Concert {
    private int concertId;
    private String artistName;
    private String category;
    private String concertDate;
    private String location;
    private String artistCountry;

    public Concert(int concertId, String artistName, String category, String concertDate, String location, String artistCountry) {
        this.concertId = concertId;
        this.artistName = artistName;
        this.category = category;
        this.concertDate = concertDate;
        this.location = location;
        this.artistCountry = artistCountry;
    }

    public int getConcertId() {
        return concertId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCategory() {
        return category;
    }

    public String getConcertDate() {
        return concertDate;
    }
    
    public String getLocation() {
        return location;
    }


    public String getArtistCountry() {
        return artistCountry;
    }

    public abstract void displayConcertDetails();

}
