package edu.bsu.cs222.view;

public class PlayerStatisticsStorage {
    private final FakeSportRadarProcessor fakeSportRadarProcessor = new FakeSportRadarProcessor();

    public String pointsString = fakeSportRadarProcessor.PPG;
    public String reboundsString = fakeSportRadarProcessor.RPG;
    public String blocksString = fakeSportRadarProcessor.BPG;
    public String stealsString  = fakeSportRadarProcessor.SPG;
    public String assistsString = fakeSportRadarProcessor.APG;
    public String heightString = fakeSportRadarProcessor.height;
    public String weightString = fakeSportRadarProcessor.weight;
}
