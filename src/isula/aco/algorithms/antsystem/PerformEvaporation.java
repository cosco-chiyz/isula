package isula.aco.algorithms.antsystem;

import isula.aco.ConfigurationProvider;
import isula.aco.DaemonAction;
import isula.aco.DaemonActionType;

import java.util.logging.Logger;

public class PerformEvaporation<E> extends DaemonAction<E> {

  private static Logger logger = Logger.getLogger(PerformEvaporation.class
      .getName());

  public PerformEvaporation() {
    super(DaemonActionType.AFTER_ITERATION_CONSTRUCTION);
  }

  @Override
  public void applyDaemonAction(ConfigurationProvider configurationProvider) {
    double evaporationRatio = configurationProvider.getEvaporationRatio();

    logger.info("Performing evaporation on all edges");
    logger.info("Evaporation ratio: " + evaporationRatio);

    getEnvironment().applyFactorToPheromoneMatrix(evaporationRatio);
  }

}