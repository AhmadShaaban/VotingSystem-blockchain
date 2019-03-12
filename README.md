# BlockChain-Simple-Program
its is a practice on Blockchain , we made a vote system to vote to your favourite  **premier league** team.
```
    Liverpool.
    Manchester City.
    Manchester United.
```

we learnt some cool stuff like  how to produce hash using **SHA-256** .
```
MessageDigest digest;
        String temp = Integer.toString(nonce) + data + timestamp + PrevHash;
        String EncodedString = new String();
        try {
             digest = MessageDigest.getInstance("SHA-256");
            byte [] EncodedMessage = digest.digest(temp.getBytes(StandardCharsets.UTF_8));
            }
```

we also learnt how to produce private key and public key using elliptic curve.
```
try {
            KeyPairGenerator GENERATOR = KeyPairGenerator.getInstance("EC");
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            GENERATOR.initialize(192, rand);
            KeyPair key = GENERATOR.generateKeyPair();
            publicKey = key.getPublic();
            privateKey = key.getPrivate();
        }
```

# To Run it on your machine you should have
**Java JDK 11**

**you should import [this](https://www.bouncycastle.org/download/bcprov-jdk15on-159.jar)**


