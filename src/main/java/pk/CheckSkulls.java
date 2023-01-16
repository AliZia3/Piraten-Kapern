package pk;

import java.util.ArrayList;

public class CheckSkulls {
    public static int Skulls(ArrayList<Faces> roll_results) {
        int skullCount = 0;
        for (int i = 0; i < roll_results.size(); i++) {
            if (roll_results.get(i) == Faces.SKULL) {
                skullCount++;
            }
        }
        return skullCount;
    }
}
