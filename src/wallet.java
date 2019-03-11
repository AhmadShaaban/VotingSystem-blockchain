import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.MessageDigest;
import java.util.*;


public class wallet {
    public PublicKey publicKey;
    public PrivateKey privateKey;
    public String StrPublicKey ;
    public String StrPrivateKey;
    public static HashMap<String,Integer> HasVoted = new HashMap<String, Integer>();



    wallet(){
        DO();
    }

    public void DoVote(){
        if (HasVoted.containsKey(StrPublicKey)){
            System.out.println("You can't vote again");
        }
        else{
            int choice = vote.votee();
            byte [] temp = generateSignature(Integer.toString(choice));
            Trie t = new Trie(publicKey,temp,Integer.toString(choice));
            vote.v.add(t);
            HasVoted.put(StrPublicKey,1);
        }
    }


    public void DO() {
        try {
            KeyPairGenerator GENERATOR = KeyPairGenerator.getInstance("EC");
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            GENERATOR.initialize(192, rand);
            KeyPair key = GENERATOR.generateKeyPair();
            publicKey = key.getPublic();
            privateKey = key.getPrivate();
        }

        catch (Exception e) {
        }

        StrPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        StrPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public byte[] generateSignature(String data){
        byte ss[] = new byte[0];
        try {
            Signature s = Signature.getInstance("SHA256withECDSA");
            s.initSign(privateKey);
            s.update(data.getBytes());
             ss = s.sign();
        }
        catch (Exception e){}
        return ss;
    }

    public static boolean verify(PublicKey publicKey,byte[] ss,String data){
        boolean flag = true;
        try {
            Signature sd = Signature.getInstance("SHA256withECDSA");
            sd.initVerify(publicKey);
            sd.update(data.getBytes());
            flag = sd.verify(ss);

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return  flag;
    }

}
