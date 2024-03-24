public class Dog {
    public static void main(String[] args) {
            double sum = 0;
            for(String num : args){
                sum += Integer.parseInt(num);
            }
        System.out.println(sum);
    }
}
