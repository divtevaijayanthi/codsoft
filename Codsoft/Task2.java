import java.util.*;
class Task2{
    public static int Count(String str,String[] textArray){
        int count=0;
        for(int i=0;i<textArray.length;i++){
            if(str.equals(textArray[i])){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the Text that you want to count word:");
        String text=s.nextLine();
        String textArray[]=text.split("[!._,'@? ]");
        int words=0;
        int uniqueWords=0;
        for(int i=0;i<textArray.length;i++){
            words++;
            String str=textArray[i];
            int check=Count(str,textArray);
            if(check==1){
                uniqueWords++;
            }
        }
        System.out.println("Total no.of Words present in given string is: "+words);
        System.out.println("Unique Words are: "+uniqueWords);
    }
}
