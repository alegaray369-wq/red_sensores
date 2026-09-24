public class BuscadorLecturas {

    public static LecturaSensor busquedaLineal(
            RepositorioLecturas repositorio,
            String idSensor) {

        for (int i = 0; i < repositorio.tamano(); i++) {

            LecturaSensor lectura = repositorio.obtener(i);

            if (lectura != null &&
                    lectura.getIdSensor().equals(idSensor)) {

                return lectura;
            }
        }

        return null;
    }

    public static LecturaSensor busquedaBinaria(
            RepositorioLecturas repositorio,
            String timestamp) {

        int inicio = 0;
        int fin = repositorio.tamano() - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            LecturaSensor lectura = repositorio.obtener(medio);

            int comparacion =
                    lectura.getTimestamp().compareTo(timestamp);

            if (comparacion == 0) {
                return lectura;
            }

            if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;
    }
}