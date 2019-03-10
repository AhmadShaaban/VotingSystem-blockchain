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
        return EncodedString;
    }