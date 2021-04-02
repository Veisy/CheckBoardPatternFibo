public class PowerSeries {

    private final int baseInteger;
    private final long[] powerSeries;

    public PowerSeries(int baseInteger, int size) {
        this.baseInteger = baseInteger;
        this.powerSeries = new long[size];

        calculatePowers();
    }

    private void calculatePowers() {
        long tempPowerValue = baseInteger;

        for (int i = 0; i < powerSeries.length; i++) {
            powerSeries[i] = tempPowerValue;
            tempPowerValue *= baseInteger;
        }
    }

    public long[] getPowerSeries() {
        return powerSeries;
    }
}
