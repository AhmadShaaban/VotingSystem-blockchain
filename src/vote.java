
public class vote {

    public static Vector<Trie> v = new Vector<>();
    public static int choice;

    public static int votee() {
        System.out.println("please enter your choice , What's the best team in EPL");
        System.out.println("1 for Liverpool");
        System.out.println("2 for Manchester City");
        System.out.println("3 For Manchester United");
        Scanner in = new Scanner(System.in);
        while (true) {
            choice = in.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                break;
            } else {
                System.out.println("Invalid Choice , retry again");
            }
        }
        return choice;
    }

    public static void DoMining() {
        int x = 0, y = 0, z = 0;
        // System.out.println("VectorSize");
        if (v.size() == 0) {
            System.out.println("There are nothing to mine ! ");
            return;
        }
        for (int i = 0; i < v.size(); ++i) {
            PublicKey q = vote.v.elementAt(i).first;
            byte[] sss = vote.v.elementAt(i).second;
            String data = vote.v.elementAt(i).third;
            if (wallet.verify(q, sss, data)) {
                if (data.equals("1")) {
                    x++;
                } else if (data.equals("2"))
                    y++;
                else if (data.equals("3"))
                    z++;


            }
        }
        if (Block.cnt != 0) {
            String arr[] = BlockChain.blockchain.get(Block.cnt - 1).getData().split(" ");
            x += Integer.parseInt(arr[0]);
            y += Integer.parseInt(arr[1]);
            z += Integer.parseInt(arr[2]);
        }
        String TEMP = Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z);
        Block b = new Block(TEMP);
        b.BlockMinig();
        v.clear();

    }
}