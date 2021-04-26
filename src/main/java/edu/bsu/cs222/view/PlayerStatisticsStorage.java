package edu.bsu.cs222.view;

public class PlayerStatisticsStorage {
    private final SearchProcessor searchProcessor = new SearchProcessor();

    public String pointsString = searchProcessor.PPG;
    public String reboundsString = searchProcessor.RPG;
    public String blocksString = searchProcessor.BPG;
    public String stealsString  = searchProcessor.SPG;
    public String assistsString = searchProcessor.APG;
    public String heightString = searchProcessor.height;
    public String weightString = searchProcessor.weight;
}
