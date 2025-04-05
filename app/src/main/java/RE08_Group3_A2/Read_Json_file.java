package RE08_Group3_A2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read_Json_file {

    private String path;
    private ArrayList<JSONObject> user_cards;

    public Read_Json_file(String path){
        this.path = path;
        this.user_cards = new ArrayList<JSONObject>();
    }

    //return name and number
    public void ReadCCfile() throws IOException, ParseException {
        JSONArray array = (JSONArray) new JSONParser().parse(new FileReader(this.path)) ;
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj  = (JSONObject) array.get(i);
            user_cards.add(obj);

        }
    }

    public ArrayList<JSONObject> getUser_cards(){

        return this.user_cards;
    }
}
