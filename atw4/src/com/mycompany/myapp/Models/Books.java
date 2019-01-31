/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Models;

import java.util.List;

/**
 *
 * @author Monta
 */
public class Books {
    private List<ReservationVoyage> books;

    /**
     * @return the books
     */
    public List<ReservationVoyage> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<ReservationVoyage> books) {
        this.books = books;
    }
    
}
