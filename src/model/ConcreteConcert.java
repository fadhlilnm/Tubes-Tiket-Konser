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
public class ConcreteConcert extends Concert {
    public ConcreteConcert(int concertId, String artistName, String category, String concertDate, String location, String artistCountry) {
        super(concertId, artistName, category, concertDate, location, artistCountry);
    }

    @Override
    public void displayConcertDetails() {
        System.out.println("Concert ID: " + getConcertId());
        System.out.println("Artist Name: " + getArtistName());
        System.out.println("Category: " + getCategory());
        System.out.println("Concert Date: " + getConcertDate());
        System.out.println("Location: " + getLocation());
        System.out.println("Country: " + getArtistCountry());
    }
}
