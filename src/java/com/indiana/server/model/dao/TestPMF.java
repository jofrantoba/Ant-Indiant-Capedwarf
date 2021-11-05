/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indiana.server.model.dao;

import javax.jdo.PersistenceManager;

/**
 *
 * @author jona
 */
public class TestPMF {
    public static void main(String arg[]){
        PersistenceManager pm = PMF.getPMF().getPersistenceManager();
        System.out.println("Date Server database:{} "+pm.getServerDate());
    }
}
