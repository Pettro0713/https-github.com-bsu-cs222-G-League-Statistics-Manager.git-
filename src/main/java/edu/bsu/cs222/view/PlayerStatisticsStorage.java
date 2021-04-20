package edu.bsu.cs222.view;

import edu.bsu.cs222.view.FakeSportRadarProcessor;

public class PlayerStatisticsStorage {
    FakeSportRadarProcessor fakeSportRadarProcessor = new FakeSportRadarProcessor();
    String pointsString = fakeSportRadarProcessor.PPG;
    String reboundsString = fakeSportRadarProcessor.RPG;
    String blocksString = fakeSportRadarProcessor.BPG;
    String stealsString  = fakeSportRadarProcessor.SPG;
    String assistsString = fakeSportRadarProcessor.APG;
    String heightString = fakeSportRadarProcessor.height;
    String weightString = fakeSportRadarProcessor.weight;
}
