package fcast.simulation;

import java.util.Set;

import fcast.universe.world.cell.CellType;
import javafx.scene.Node;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * Grafico del tasso di evoluzione
 *
 * @param <T>
 *            tipo di cella presente nella simulazione
 */
public class EvolutionRateChart<T extends CellType> extends SimulationChart<T> {

	public EvolutionRateChart() {
		super(new NumberAxis(), new NumberAxis(), null);
		this.getXAxis().setLabel("Generation");
		this.getYAxis().setLabel("Evolution Rate");
		Series<Integer, Integer> rate = new Series<Integer, Integer>();
		rate.setName("Rate");
		getData().add(rate);
		rate.getNode().getStyleClass().add(rate.getName());
		Set<Node> lineNode = this.lookupAll("." + rate.getName());
		for (final Node line : lineNode) {
			line.setStyle("-fx-stroke-width: 1.5px;");
		}
	}

	@Override
	public void updateInfo(int generation, Object o) {
		int info = (Integer) o;
		this.getData().get(0).getData().add(new XYChart.Data(generation, info));

	}

}
