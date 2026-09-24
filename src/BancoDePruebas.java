public class BancoDePruebas {

    public static void experimentoUno() {
        System.out.println("=== EXPERIMENTO UNO ===");
        probarBusquedaLineal();
    }

    public static void experimentoDos() {
        System.out.println("=== EXPERIMENTO DOS ===");

        RepositorioLecturas repositorio = new RepositorioLecturas();

        repositorio.agregar(new LecturaSensor(
                "S01", "2026-09-18 08:00",
                20.0, 50.0, 15.0));

        repositorio.agregar(new LecturaSensor(
                "S02", "2026-09-18 09:00",
                21.0, 51.0, 18.0));

        repositorio.agregar(new LecturaSensor(
                "S03", "2026-09-18 10:00",
                22.0, 52.0, 20.0));

        repositorio.agregar(new LecturaSensor(
                "S04", "2026-09-18 11:00",
                23.0, 53.0, 25.0));

        String timestampBuscado = "2026-09-18 10:00";

        LecturaSensor encontrada =
                BuscadorLecturas.busquedaBinaria(
                        repositorio,
                        timestampBuscado);

        System.out.println(
                "Buscando timestamp: " + timestampBuscado);

        if (encontrada != null) {
            System.out.println("Encontrada:");
            System.out.println(encontrada);
        } else {
            System.out.println("No encontrada.");
        }
    }

    public static void experimentoTres() {
        System.out.println("=== EXPERIMENTO TRES ===");

        RepositorioLecturas repositorio = new RepositorioLecturas();

        for (int i = 0; i < 100; i++) {
            repositorio.agregar(
                    GeneradorDatos.generarLectura());
        }

        LecturaSensor objetivo = repositorio.obtener(50);

        System.out.println(
                "Buscando sensor: " + objetivo.getIdSensor());

        long inicio = System.nanoTime();

        LecturaSensor encontrada =
                BuscadorLecturas.busquedaLineal(
                        repositorio,
                        objetivo.getIdSensor());

        long fin = System.nanoTime();

        if (encontrada != null) {
            System.out.println("Encontrada:");
            System.out.println(encontrada);
        } else {
            System.out.println("No encontrada.");
        }

        System.out.println(
                "Tiempo búsqueda lineal: "
                + (fin - inicio) + " ns");
    }

    public static void experimentoCuatro() {
        System.out.println("=== EXPERIMENTO CUATRO ===");

        RepositorioLecturas repositorio = new RepositorioLecturas();

        repositorio.agregar(new LecturaSensor(
                "S01", "2026-09-18 08:00",
                20.0, 50.0, 15.0));

        repositorio.agregar(new LecturaSensor(
                "S02", "2026-09-18 09:00",
                21.0, 51.0, 18.0));

        repositorio.agregar(new LecturaSensor(
                "S03", "2026-09-18 10:00",
                22.0, 52.0, 20.0));

        repositorio.agregar(new LecturaSensor(
                "S04", "2026-09-18 11:00",
                23.0, 53.0, 25.0));

        String timestampBuscado = "2026-09-18 10:00";

        long inicioLineal = System.nanoTime();

        LecturaSensor resultadoLineal = null;

        for (int i = 0; i < repositorio.tamano(); i++) {
            LecturaSensor lectura = repositorio.obtener(i);

            if (lectura.getTimestamp().equals(timestampBuscado)) {
                resultadoLineal = lectura;
                break;
            }
        }

        long finLineal = System.nanoTime();

        long inicioBinaria = System.nanoTime();

        LecturaSensor resultadoBinario =
                BuscadorLecturas.busquedaBinaria(
                        repositorio,
                        timestampBuscado);

        long finBinaria = System.nanoTime();

        System.out.println(
                "Timestamp buscado: " + timestampBuscado);

        System.out.println("Resultado búsqueda lineal:");
        System.out.println(resultadoLineal);

        System.out.println(
                "Tiempo lineal: "
                + (finLineal - inicioLineal) + " ns");

        System.out.println("Resultado búsqueda binaria:");
        System.out.println(resultadoBinario);

        System.out.println(
                "Tiempo binario: "
                + (finBinaria - inicioBinaria) + " ns");
    }

    public static void probarBusquedaLineal() {

        RepositorioLecturas repositorio =
                new RepositorioLecturas();

        for (int i = 0; i < 20; i++) {
            repositorio.agregar(
                    GeneradorDatos.generarLectura());
        }

        LecturaSensor objetivo =
                repositorio.obtener(10);

        System.out.println(
                "Buscando sensor: "
                + objetivo.getIdSensor());

        LecturaSensor encontrada =
                BuscadorLecturas.busquedaLineal(
                        repositorio,
                        objetivo.getIdSensor());

        if (encontrada != null) {
            System.out.println("Encontrada:");
            System.out.println(encontrada);
        } else {
            System.out.println("No encontrada.");
        }
    }
}