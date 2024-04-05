public class example {
    static void printOne(int i){
        System.out.print(i);
        int temp = i - 1;
        if (temp != 0)
            printOne (temp);
        System.out.print(i);
    }
        public static void main(String[] args) {
        printOne (3);
}
}