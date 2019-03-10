import java.security.PublicKey;
 
public class Trie {
    public PublicKey first;
    public byte[] second;
    public String third;
    Trie(PublicKey first,byte[] second,String third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}