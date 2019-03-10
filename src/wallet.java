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