import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

public  class Block {
    public int index;
    private long timestamp;
    private String Hash;
    private String PrevHash;
    private String data;
    private int nonce = 1;
    public static  int diff ;
    public static int cnt = 0;


    public  String HashBlock(){
        MessageDigest digest;
        String temp = Integer.toString(nonce) + data + timestamp + PrevHash;
        String EncodedString = new String();
        try {
             digest = MessageDigest.getInstance("SHA-256");
            byte [] EncodedMessage = digest.digest(temp.getBytes(StandardCharsets.UTF_8));


            for (int i = 0 ; i < EncodedMessage.length; ++i){
                String t = new String();
                t = Integer.toHexString(0xff&EncodedMessage[i]);
                if (t.length()==1)
                    t+="0";
                EncodedString +=t;
            }
        }
        catch (Exception e){}

        //System.out.println("aho aho aho " + EncodedString);

        return EncodedString;
    }

    //generate strings of x zeros

    public String solve(int x){
        String temp = new String();
        for (int i = 0 ; i < x ;++i){
            temp+="0";
        }
        return  temp;
    }

    public boolean OK(String x){
        boolean flag = true;
        for (int i = 0 ; i < x.length() ;++i){
            if (x.charAt(i)!= Hash.charAt(i)){
                flag = false;
                break;
            }
        }
        return  flag;
    }

    public void BlockMinig(){
        //String feh diff Zeroos
        String Target = solve(diff);

        //System.out.println("target " + Target);

        while (!OK(Target)){
            nonce++;
            //System.out.println(nonce);
            Hash = HashBlock();
        }

        System.out.println("Hola ! Block is mined .");
        BlockChain.blockchain.add(this);
        //System.out.println("555" + Hash);

    }


    public Block(String data){
        this.data = data;
        index = cnt;
        timestamp = new Date().getTime();
        setHash();
        nonce = 1;
        if (cnt >= 1){
            PrevHash = BlockChain.blockchain.get(cnt-1).getHash();
        }
        else{
            PrevHash = "0";
        }
        cnt++;

    }







    //setters
    public void setIndex(int index) {
        this.index = index;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setHash (){
        Hash = HashBlock();
    }

    public void setPrevHash(String prevHash) {
        PrevHash = prevHash;
    }

    public int getIndex() {
        return index;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    //getters

    public int getNonce() {
        return nonce;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public String getHash() {
        return Hash;
    }

    public String getPrevHash() {
        return PrevHash;
    }





}
