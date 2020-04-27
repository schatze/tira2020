/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapi;

import java.util.*;

/**
 *
 * @author kamaj
 */
public class TrafficCard implements Comparable<TrafficCard> {
    int mTravellerNumber;
    String mOwnerName;
    float mBalance;
    
    public TrafficCard(int tNumber, String oName, float balance){
        mTravellerNumber = tNumber;
        mOwnerName = oName;
        mBalance = balance;
    }
    
    @Override
    public String toString(){
        return "owner: "+mOwnerName+" number: "+mTravellerNumber+" balance: "+mBalance;
    }
    
    @Override
    public int compareTo( final TrafficCard card ) {
        return Integer.compare(this.mTravellerNumber, card.mTravellerNumber);
    }
}
