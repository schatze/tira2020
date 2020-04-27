/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapi;

import java.util.Comparator;

/**
 *
 * @author Osku
 */
public class TrafficCardComparatorBalanceSort implements Comparator<TrafficCard> {
    @Override
    public int compare(TrafficCard c1, TrafficCard c2) {
        int balance1Upscaled = (int)(c1.mBalance*1000);
        int balance2Upscaled = (int)(c2.mBalance*1000);
        
        return balance1Upscaled - balance2Upscaled;
    }
}
