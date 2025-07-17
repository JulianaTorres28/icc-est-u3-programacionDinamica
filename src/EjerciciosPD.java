import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {

    public long getFibonaci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return getFibonaci(n - 1) + getFibonaci(n - 2);
        }
    }

    public long getFibonaciPD(int n) {
        Map<Integer, Long> caching = new HashMap<>();
        return getFibonaciPDHelper(n, caching);
    }

    private long getFibonaciPDHelper(int n, Map<Integer, Long> cache) {
        if (n <= 1) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long resultado = getFibonaciPDHelper(n - 1, cache) + getFibonaciPDHelper(n - 2, cache);
            cache.put(n, resultado);
            return resultado;
        }
    }
}
