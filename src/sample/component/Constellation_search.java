package sample.component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Constellation_search {
    public Constellation_search() {

    }

    public String show_constellation(String birthday) throws Exception {
        // DONE Read the txt
        File f = new File("src\\sample\\constellation\\constellation_search.txt");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String s = "";
        Boolean flag = false;
        String constellation_description = "";
        while ((s = reader.readLine()) != null) {
            // if match the constellation, begin load the description
            if (s.equals(filter_constellation(birthday))) flag = true;
            // if match the '#', stop load
            if (flag && s.contains("#")) break;
            // get the description
            if (flag) constellation_description += s + "\n";
        }
       return constellation_description;
    }

    public String filter_constellation(String birthday) throws Exception {
        // DONE Compare and Filter the constellation
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        Date birth = df.parse(birthday);

        Date baiyang_start = df.parse("03-20");
        Date baiyang_end = df.parse("04-21");
        Boolean is_baiyang = birth.after(baiyang_start) && birth.before(baiyang_end);

        Date jinniu_start = df.parse("04-20");
        Date jinniu_end = df.parse("05-21");
        Boolean is_jinniu = birth.after(jinniu_start) && birth.before(jinniu_end);

        Date shuangzi_start = df.parse("05-20");
        Date shuangzi_end = df.parse("06-22");
        Boolean is_shuangzi = birth.after(shuangzi_start) && birth.before(shuangzi_end);

        Date juxie_start = df.parse("06-21");
        Date juxie_end = df.parse("07-23");
        Boolean is_juxie = birth.after(juxie_start) && birth.before(juxie_end);

        Date shizi_start = df.parse("07-22");
        Date shizi_end = df.parse("08-23");
        Boolean is_shizi = birth.after(shizi_start) && birth.before(shizi_end);

        Date chunv_start = df.parse("08-22");
        Date chunv_end = df.parse("09-23");
        Boolean is_chunv = birth.after(chunv_start) && birth.before(chunv_end);

        Date tiancheng_start = df.parse("09-22");
        Date tiancheng_end = df.parse("10-23");
        Boolean is_tiancheng = birth.after(tiancheng_start) && birth.before(tiancheng_end);

        Date tianxie_start = df.parse("10-22");
        Date tianxie_end = df.parse("11-23");
        Boolean is_tianxie = birth.after(tianxie_start) && birth.before(tianxie_end);

        Date sheshou_start = df.parse("11-22");
        Date sheshou_end = df.parse("12-22");
        Boolean is_sheshou = birth.after(sheshou_start) && birth.before(sheshou_end);

        Date mojie_start = df.parse("12-21");
        Date mojie_end = df.parse("01-20");
        Boolean is_mojie = birth.after(mojie_start) || birth.before(mojie_end);

        Date shuiping_start = df.parse("01-19");
        Date shuiping_end = df.parse("02-19");
        Boolean is_shuiping = birth.after(shuiping_start) && birth.before(shuiping_end);

        Date shuangyu_start = df.parse("02-18");
        Date shuangyu_end = df.parse("03-21");
        Boolean is_shuangyu = birth.after(shuangyu_start) && birth.before(shuangyu_end);

        ArrayList<Boolean> constellation = new ArrayList<>(Arrays.asList(is_baiyang, is_jinniu, is_shuangzi, is_juxie, is_shizi, is_chunv, is_tiancheng, is_tianxie, is_sheshou, is_mojie, is_shuiping, is_shuangyu));
        String[] xingzuo = {"白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};

        return xingzuo[constellation.indexOf(true)];
    }
}
