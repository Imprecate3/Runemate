package com.runemate.WireCollectorImproved.Variables;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;

public class Places {
    public static Area WireArea = new Area.Rectangular(new Coordinate(2724, 5263, 0), new Coordinate(2712, 5277, 0));
    public static Area StairArea = new Area.Rectangular(new Coordinate(2709, 5275, 1), new Coordinate(2717, 5285, 1));
    public static Coordinate nearMainAreaUpStairs = new Coordinate(2713, 5282, 0);
    public static Coordinate MainAreaUpStairs = new Coordinate(2713, 5282, 0);
    public static Coordinate WireAreaDownStairs = new Coordinate(2713, 5279, 1);
    public static Coordinate nextToMachine = new Coordinate(2715, 5274, 0);
    public static Coordinate wire = new Coordinate(2716, 5274, 0);
    public static Area bankArea = new Area.Rectangular(new Coordinate(2700, 5345, 0), new Coordinate(2706, 5354, 0));
    public static Area bankBooths = new Area.Rectangular(new Coordinate(2700, 5347, 0), new Coordinate(2700, 5352, 0));
    public static Area wireStairs = new Area.Rectangular(new Coordinate(2713, 5277, 0), new Coordinate(2714, 5277, 0));
    public static Coordinate WireUpStairs = new Coordinate(2713, 5278, 0);
    public static Coordinate mainDownStairs = new Coordinate(2713, 5282, 1);
    public static Area mainAreaStairs = new Area.Rectangular(new Coordinate(2713, 5282,0), new Coordinate(2714, 5284,0));
}
