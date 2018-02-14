package com.alphatica.genotick.genotick;

import com.alphatica.genotick.chart.GenoChartMode;
import com.alphatica.genotick.data.FilterSettings;
import com.alphatica.genotick.timepoint.TimePoint;

public class EngineSettings {
    public final TimePoint startTimePoint;
    public final TimePoint endTimePoint;
    public final boolean performTraining;
    public final int maximumDataOffset;
    public final int killNonPredictingRobots;
    public final int ageBeforeKillingNonPredictingRobots;
    public final boolean requireSymmetricalRobots;
    public final double minimumScoreToSaveToDisk;
    public final double resultThreshold;
    public final GenoChartMode chartMode;
    public final double profitReinvestFactor;
    public final FilterSettings filterSettings;
    
    public EngineSettings(final MainSettings settings) {
        this.startTimePoint = settings.startTimePoint;
        this.endTimePoint = settings.endTimePoint;
        this.performTraining = settings.performTraining;
        this.maximumDataOffset = settings.maximumDataOffset;
        this.killNonPredictingRobots = settings.killNonPredictingRobots;
        this.ageBeforeKillingNonPredictingRobots = settings.ageBeforeKillingNonPredictingRobots;
        this.requireSymmetricalRobots = settings.requireSymmetricalRobots;
        this.minimumScoreToSaveToDisk = settings.minimumScoreToSaveToDisk;
        this.resultThreshold = settings.resultThreshold;
        this.chartMode = settings.chartMode;
        this.profitReinvestFactor = settings.profitReinvestFactor;
        this.filterSettings = new FilterSettings(settings);
    }
}
