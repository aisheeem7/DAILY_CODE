class oneton {
    static void printNos(int n){
        
        if (n == 0)
            return;
    
        printNos(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args){
        int n = 10;
        printNos(n);
    }
}