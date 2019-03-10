
public class vote {

    public static Vector<Trie> v = new Vector<>();
    public static int choice;
    public static int votee(){
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