package com.tlabs.eve.fitting;

public interface FittingEngine {

    /** Returns a ship which attributes are calculated by this engine from the provided ship and its fitting.*/
    Ship fit(Ship ship);
}
