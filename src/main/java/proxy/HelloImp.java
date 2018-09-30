package proxy;

public class HelloImp implements Hello {

    @Override
    public String sayHello(String toName) {
        String helloString = "Mehtod in HelloIMP: Hello" + toName;
        System.out.println(helloString);
        return helloString;
    }

}
