import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        List<Integer> result = new ArrayList<>();
        Logger logger = Logger.getInstance();
        for (int value : source) {
            if (value >= treshold) {
                result.add(value);
                logger.log("Элемент " + value + " проходит");
            } else {
                logger.log("Элемент " + value + " не проходит");
            }
        }
        return result;
    }
}