import java.util.ArrayList;
import java.util.Scanner;

public class BlockChain {
    public static ArrayList<Block> blockchain = new ArrayList<>();

    public void  AddBlock(){
        System.out.println("Please enter data");
        String data;
        Scanner in = new Scanner(System.in);
        data = in.nextLine();
        System.out.println(data);
        Block b = new Block(data);
        blockchain.add(b);

    }

    public static void  isValid(){
        boolean flag = true;
        for (int i = 0 ; i < blockchain.size(); ++i){

            if (!blockchain.get(i).HashBlock().equals(blockchain.get(i).getHash())) {
                flag = false;
                break;
            }
            if (i == 0){
                if (blockchain.get(i).getPrevHash() != "0"){
                    flag = false;
                    break;
                }
            }
            else {
                if (blockchain.get(i).getPrevHash() != blockchain.get(i-1).getHash()){
                    flag = false;
                    break;
                }
            }
        }

        if (flag){
            System.out.println("The BlockChain is Valid ! ");
        }
        else {
            System.out.println("The BlockChain is InValid !");
        }
    }


}
