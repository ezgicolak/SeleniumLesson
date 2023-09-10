import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class E14_Streams1 {

    @Test

    public void regular(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ali");
        names.add("Deniz");
        names.add("Ali");
        names.add("Aleyna");
        names.add("Rıza");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);


        names.stream().filter(s -> s.length()>4).limit(2).forEach(s -> System.out.println(s));


    }

    @Test
    public void streamMap()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("Don");
        names.add("women");

        Stream.of("Ezgi","Deniz","Buse","Ali","Ajda").filter(s ->s.endsWith("i")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        List<String>names1 = Arrays.asList("Ezgi","Deniz","Buse","Ali","Ajda");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Ali"));
        Assert.assertTrue(flag);






    }



}
