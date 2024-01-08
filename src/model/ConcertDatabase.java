/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.HashMap;

/**
 *
 * @author LENOVO
 */
public class ConcertDatabase {
    private HashMap<Integer, Concert> concertMap;
    private int nextConcertId;

    public ConcertDatabase() {
        this.concertMap = new HashMap<>();
        this.nextConcertId = 1;
    }

    public void addConcert(Concert concert) {
        concertMap.put(concert.getConcertId(), concert);
    }

    public Concert getConcertById(int concertId) {
        return concertMap.get(concertId);
    }
    
    public void removeConcertById(int concertId) {
        concertMap.remove(concertId);
        System.out.println("Concert with ID " + concertId + " has been removed.");
    }

    public HashMap<Integer, Concert> getConcertMap() {
        return concertMap;
    }

    public int getNextConcertId() {
        return nextConcertId++;
    }
}
