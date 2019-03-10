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


