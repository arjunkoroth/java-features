package features;

import java.util.StringJoiner;

public class StringJoinerExamples {
    
    public StringJoinerExamples() {
        // Joiner with a delimeter.
        StringJoiner joiner1 = new StringJoiner(",");
        joiner1.add("A");
        joiner1.add("B");
        joiner1.add("C");
        System.out.println(joiner1);
        // Joiner with delimiter, prefix and suffix.
        StringJoiner joiner2 = new StringJoiner(":", "[", "]");
        joiner2.add("D");
        joiner2.add("E");
        joiner2.add("F");
        System.out.println(joiner2);
        // Merger one joiner with another
        StringJoiner merger = joiner1.merge(joiner2);
        System.out.println(merger);
        // Length
        System.out.println("Length--" + merger.length());
    }
}
