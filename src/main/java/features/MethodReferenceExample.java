package features;

import features.beans.MethodReference;
import features.interfaces.ReadableInterface;

public class MethodReferenceExample {
    public MethodReferenceExample() {
        // Method reference to a static method
        ReadableInterface rdStatic = MethodReference::sayHello;
        rdStatic.read("Alice");
        // Method reference to an instance method
        ReadableInterface rdInstance = new MethodReference()::sayHelloInstance;
        rdInstance.read("Bob");
        // Method reference to a constructor.
        ReadableInterface rdConstructor = MethodReference::new;
        rdConstructor.read("Charlie");
    }

    public static void main(String[] args) {
        new MethodReferenceExample();
    }
}
