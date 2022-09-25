package features.beans;

/**
 *
 * @author Arjun
 */
public class MethodReference {

    public static void sayHello(String str) {
        System.out.println("Hello " + str + "(Static)");
    }

    public void sayHelloInstance(String str) {
        System.out.println("Hello " + str + "(Instance)");
    }

    public MethodReference(String str) {
        System.out.println("Hello " + str + "(Constructor)");
    }

    public MethodReference() {
    }
}
