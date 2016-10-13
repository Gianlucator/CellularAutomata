package framework.simulation;

import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class EvolutionRateChart extends LineChart<Integer, Integer>{

	public EvolutionRateChart(Axis xAxis, Axis yAxis) {
		super(xAxis, yAxis);
		this.getXAxis().setLabel("Generation");
		this.getYAxis().setLabel("Evolution Rate");
		Series<Integer, Integer> rate = new Series<Integer, Integer>();
		rate.setName("Rate");
        getData().add(rate);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateInfo(int generation, int evolutionRate) {
		this.getData().get(0).getData().add(new XYChart.Data(generation, evolutionRate));
	}

}