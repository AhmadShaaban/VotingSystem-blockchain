import java.security.PublicKey;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        wallet a = new wallet();
        Block.diff = 2;
       while (true) {
           System.out.println("1 for new wallet");
           System.out.println("2 for vote");
           System.out.println("3 for Mining");
           System.out.println("4 for Validating the Chain");
           Scanner sc = new Scanner(System.in);
           int option = sc.nextInt();
           if (option == 1)
                 a = new wallet();
           else if (option == 2)
                a.DoVote();
           else if (option == 3)
            vote.DoMining();
           else
               BlockChain.isValid();

       }


    }
}
