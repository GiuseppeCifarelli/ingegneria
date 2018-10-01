/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Dastler
 */
public enum Categorie {
    
    CONCERTI("Concerti"),MOSTRE_E_MUSEI("Mostre e Musei"),SPORT("Sport"),TEATRO("Teatro"),CINEMA("Cinema"),CONFERENZE("Conferenze"),SPETTACOLI("Spettacoli");
    private final String name;
    private Categorie(String name){
        this.name=name;
    }
    public static String[] getAllCategories(){
        String []ret={Categorie.CINEMA.name,Categorie.CONCERTI.name,Categorie.CONFERENZE.name,Categorie.MOSTRE_E_MUSEI.name,Categorie.SPORT.name,Categorie.TEATRO.name,Categorie.SPETTACOLI.name};
        return ret;
    }
}

    

