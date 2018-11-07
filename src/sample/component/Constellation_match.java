package sample.component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Constellation_match {
    public Constellation_match() {

    }

    public String constellation_point(String man,String women) throws Exception {
        // DONE get the match point
        File f = new File("src\\sample\\constellation\\constellation_point.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String s = "";
        String point="";
        while ((s = reader.readLine()) != null) {
            if (s.contains(man) && s.contains(women)) {
                point=s.split(":")[1];
                break;
            }
        }
        return point;
    }

    public String constellation_match(String man,String women) throws Exception {
        // DONE get the match info
        File f = new File("src\\sample\\constellation\\constellation_match.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String s = "";
        Boolean flag = false;
        String constellation_description = "";
        while ((s = reader.readLine()) != null) {
            if (s.contains(man) && s.contains(women)) flag = true;
            // if match the '#', stop load
            if (flag && s.contains("#")) break;
            // get the description
            if (flag) constellation_description += s + "\n";
        }
        return constellation_description;
    }
}
