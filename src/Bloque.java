import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Calendar;

public class Bloque {


    int index;
    Timestamp timestamp;
    String data;
    String previous_hash;
    String hash;

    public Bloque(){

    }

    public Bloque(int index, Timestamp timestamp, String data, String previous_hash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previous_hash = previous_hash;
        this.hash = hash_block();
    }

    public String hash_block(){
        String sha = Hashing.sha256()
                .hashString(String.valueOf(index)+String.valueOf(timestamp)+String.valueOf(data)+String.valueOf(previous_hash), StandardCharsets.UTF_8)
                .toString();
        return sha;
    }

    public static Bloque create_genesis_block(){
        return new Bloque(0, new Timestamp(Calendar.getInstance().getTime().getTime()), "Genesis Block","0");
    }

    public Bloque next_block(Bloque last_block){
        Bloque b = new Bloque();
        b.setIndex(last_block.getIndex() + 1);
        b.setTimestamp(new Timestamp(Calendar.getInstance().getTime().getTime()));
        b.setData("Hey! I'm block #" + String.valueOf(b.getIndex()));
        b.setPrevious_hash(last_block.getHash());
        b.setHash(b.hash_block());
        return b;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
