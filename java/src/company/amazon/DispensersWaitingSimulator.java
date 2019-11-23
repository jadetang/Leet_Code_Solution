package company.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DispensersWaitingSimulator {

  public int solution(int[] A, int X, int Y, int Z) {
    int maxWaitTime = 0;
    List<Dispenser> dispensers = new ArrayList<>();
    dispensers.add(new Dispenser(X));
    dispensers.add(new Dispenser(Y));
    dispensers.add(new Dispenser(Z));
    for (int carToFill : A) {
      int waitTime = minimalTimeToWait(dispensers, carToFill);
      if (waitTime == -1) {
        return -1;
      }
      maxWaitTime = Math.max(maxWaitTime, waitTime);
    }
    return maxWaitTime;
  }

  /**
   * Return minimal time to wait begin to fill this car
   *
   * @param dispensers the list of Dispensers
   * @param newCarToFill the car to fill
   * @return minimal time to wait begin to fill this car, if can not fill the car, return -1
   */
  private int minimalTimeToWait(List<Dispenser> dispensers, int newCarToFill) {

    Optional<Dispenser> availableStation =
        dispensers.stream().filter(dispenser -> dispenser.canFillCar(newCarToFill))
            .findFirst();
    if (availableStation.isPresent()) {
      availableStation.get().beginToFillCar(newCarToFill);
      return 0;
    } else {
      List<Dispenser> availableDispenserIfWait = dispensers
          .stream()
          .filter(dispenser -> dispenser.remainingFuelAfterFillingTheCurrentCar() >= newCarToFill)
          .collect(Collectors.toList());
      if (availableDispenserIfWait.size() == 0) {
        return -1;
      }
      availableDispenserIfWait
          .sort(Comparator.comparingInt(dispenser -> dispenser.currentCarInStationToFill));
      int waitTime = availableDispenserIfWait.get(0).finishFillingTheCurrentCar();
      availableDispenserIfWait.get(0).beginToFillCar(newCarToFill);
      return waitTime;
    }
  }

  public static class Dispenser {

    int availableFuel;

    int currentCarInStationToFill;

    public Dispenser(int availableFuel) {
      this.availableFuel = availableFuel;
      this.currentCarInStationToFill = 0;
    }

    public boolean canFillCar(int newCarToFill) {
      return this.currentCarInStationToFill == 0 && this.availableFuel >= newCarToFill;
    }

    public int remainingFuelAfterFillingTheCurrentCar() {
      return this.availableFuel - currentCarInStationToFill;
    }

    public void beginToFillCar(int carToFill) {
      this.currentCarInStationToFill = carToFill;
    }

    /**
     * Finish filling the current car in this dispenser, return how many second spent.
     */
    public int finishFillingTheCurrentCar() {
      this.availableFuel -= currentCarInStationToFill;
      int timeSpent = currentCarInStationToFill;
      this.currentCarInStationToFill = 0;
      return timeSpent;
    }
  }

}
