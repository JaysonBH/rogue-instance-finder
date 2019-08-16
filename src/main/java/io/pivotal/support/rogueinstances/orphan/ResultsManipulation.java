package io.pivotal.support.rogueinstances.orphan;

import java.util.ArrayList;

public class ResultsManipulation {

    public static ArrayList<String> findOrphans(String[] resultSetOne, String[] resultSetTwo){
        Boolean found;
        ArrayList<String> missingGUIDs = new ArrayList<>();
        for (int i=0; i < resultSetOne.length; i++){
            found = false;
            for (int j=0; j < resultSetTwo.length; j++){
                if (resultSetOne[i].equals(resultSetTwo[j])){
                    found = true;
                }
            }
            if (!found){
                missingGUIDs.add(resultSetOne[i]);
            }
        }
        return missingGUIDs;
    }

}
