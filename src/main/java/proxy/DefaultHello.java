package proxy;

public class DefaultHello {

    public String sayHello(String toName) {
        String helloString = "Mehtod in HelloIMP: Hello" + toName;
        System.out.println(helloString);
        return helloString;
    }

}
