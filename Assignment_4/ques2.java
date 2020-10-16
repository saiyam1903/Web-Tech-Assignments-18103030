
public class ques2 {
    public static void main(String[] args){
        int int_value = -1;
        System.out.println("int Value: " + int_value);

        // Convert integer to byte
        byte byte_value = (byte) int_value;
        System.out.println("byte Value: " +byte_value);

        // Convert byte to character
        char char_value = (char) byte_value;
        System.out.println("char Value: " +char_value);

        // Convert character back to integer
        int_value = (int) char_value;
        System.out.println("Int Value: " +int_value);

        System.out.println("The value does not return back to where it started as char\n" +
                "It ranges from 0 to 65,536 inclusive\n" +
                "The conversion from byte to char is a special case and \n" +
                "represents widening and narrowing at the same time.\n" +
                " The conversion starts by converting the byte to an int and\n" +
                " then the int gets converted to the char.\n" +
                "Also the fact that in java byte is signed.\n" +
                "this results in the sign part being truncated\n"
        );
    }

}
