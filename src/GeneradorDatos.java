import java.util.Random;

public class GeneradorDatos {

    private static final Random random = new Random();

    public static LecturaSensor generarLectura() {

        String[] estaciones = {
            "S01", "S02", "S03", "S04", "S05",
            "S06", "S07", "S08", "S09"
        };

        String idSensor = estaciones[random.nextInt(estaciones.length)];

        String timestamp = String.format(
                "2026-09-18 %02d:00",
                random.nextInt(24)
        );

        double temperatura = 15 + random.nextDouble() * 20;
        double humedad = 30 + random.nextDouble() * 60;
        double pm25 = random.nextDouble() * 100;

        return new LecturaSensor(
                idSensor,
                timestamp,
                temperatura,
                humedad,
                pm25
        );
    }
}