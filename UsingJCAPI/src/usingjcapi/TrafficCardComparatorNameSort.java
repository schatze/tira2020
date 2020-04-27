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
public class TrafficCardComparatorNameSort implements Comparator<TrafficCard> {
    @Override
    public int compare(TrafficCard c1, TrafficCard c2) {
        return c1.mOwnerName.compareTo(c2.mOwnerName);
    }
}
