package fil.coordinates;

import java.util.Collection;
import java.util.List;

public class CalculatingDistance {

    public static double distanceBetween(Coordinates a, Coordinates b){
        return Math.sqrt(
                Math.pow((b.getX()-a.getX()), 2)
                + Math.pow((b.getY()-a.getY()), 2)
                + Math.pow((b.getZ()-a.getZ()), 2));
    }

    public static double distanceTotal(List<Coordinates> pointsList){
        if (pointsList.size() < 2) return 0;
        double total = 0.0;
        for (int i = 1; i < pointsList.size(); i++){
            total += distanceBetween(pointsList.get(i), pointsList.get(i-1));
        }
        return total;
    }

}
