import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCustomerFileAndFilter {
    public static void main(String[] args){
        BufferedReader reader;
        List<List<String>> list = new ArrayList<List<String>>();
        List<List<String>> finalList = new ArrayList<List<String>>();
        try{
            reader = new BufferedReader(new FileReader("src/test/Files/latest-customers.txt"));
            String line = reader.readLine();
            while(line!=null)
            {
                line = reader.readLine();
                if(line!= null) {
                    ArrayList<String> lst = new ArrayList<>(Arrays.asList(line.split(",")));
                    list.add(lst);
                }
            }
            for(List<String> li : list){
                if(Integer.parseInt(li.get(1) )<=59 && Integer.parseInt(li.get(1)) >=40){
                    finalList.add(li);
                }
            }
          //  for (List<String> eachLine : finalList) {
               // String commaSeparated = String.join(",", eachLine);
                File f = new File("src/test/Files/latest-customers -filtered.txt");
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                    for (List<String> eachLine : finalList) {
                        String commaSeparated = String.join(",", eachLine);
                        bw.append(commaSeparated);
                        bw.newLine();
                    }
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}