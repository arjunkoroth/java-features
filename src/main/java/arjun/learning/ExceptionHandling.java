package arjun.learning;

/**
 *
 * @author Arjun
 */
public class ExceptionHandling {

    private static String exceptionHandlings() {
        try {
            int a = 5/0;
            return "A";
        } catch (Exception e) {
            e.printStackTrace();
            return "B";
        }finally{
            return "C";
        }
    }

    public static void main(String[] args) {
        System.out.println(exceptionHandlings());
    }
}
