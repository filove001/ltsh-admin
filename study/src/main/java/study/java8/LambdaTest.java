package study.java8;

import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.Test;

public class LambdaTest {
	@Test
	public void arrayforEach(){
		Arrays.asList("a","b","c").forEach(e-> System.out.println(e));
		Arrays.asList("a","b","c").forEach((String e)-> System.out.println(e));
		Arrays.asList("a","b","c").forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach( e -> {
		    System.out.print( e+separator );
		    System.out.print( e );
		} );
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
	}
}
