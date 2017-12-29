package study.java8;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Test;
/**
 * http://www.jb51.net/article/48304.html
 * http://www.importnew.com/11908.html
 * http://www.cnblogs.com/figure9/archive/2014/10/24/4048421.html
 * @author fengjianzhong
 *
 */
public class Java8Test {
	interface Formula {
	    double calculate(int a);
	    default double sqrt(int a) {
	        return Math.sqrt(a);
	    }
	}
	@Test
	public void lambda(){
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
//		Lambda表达式中是无法访问到默认方法的，以下代码将无法编译
//		separator="899128912";
//		System.out.println(separator);
//		Formula formula = (1) -> {
//			return sqrt(a);
//			};
	}
	
	@FunctionalInterface
	interface Converter<F, T> {
	    T convert(F from);
	}
	class Person {
	    String firstName;
	    String lastName;
	    Person() {}
	    Person(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }
	}
	interface PersonFactory<P extends Person> {
	    P create(String firstName, String lastName);
	}
//	Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//	Integer converted = converter.convert("123");
//	System.out.println(converted);    // 123
	@Test//方法引用
	public void importMothed(){
		//把Integer的方法valueOf赋予给接口onverter<String, Integer> converter
		Converter<String, Integer> converter = Integer::valueOf;
		System.out.println(converter);
		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123
		String something="Java12312";
		Converter<String, Boolean> converter1 = something::startsWith;
		Boolean converted1 = converter1.convert("Java");
		System.out.println(converted1);    // "J"
		
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
//		我们只需要使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
	}
	
	public static String sub(int s){
		return s+"====";
	}
	@Test//Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
	public void FunctionTest(){
		Function<String, Integer> toInteger = Integer::valueOf;
		System.out.println(toInteger.apply("123"));
//		"".substring(beginIndex)
//		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		Function<String, String> backToString = toInteger.andThen(Java8Test::sub);
		backToString.apply("123");     // "123"
		System.out.println(backToString.apply("123"));
	}
	@Test
	public void SupplierTest(){
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
	}
	@Test
	public void ConsumerTest(){
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));
	}
	@Test
	public void OptionalTest(){
		Optional<String> optional = Optional.of("bam");
		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}
	
	
	
	 private enum Status {
	        OPEN, CLOSED
	    };
	     
	    private static final class Task {
	        private final Status status;
	        private final Integer points;
	 
	        Task( final Status status, final Integer points ) {
	            this.status = status;
	            this.points = points;
	        }
	         
	        public Integer getPoints() {
	            return points;
	        }
	         
	        public Status getStatus() {
	            return status;
	        }
	         
	        @Override
	        public String toString() {
	            return String.format( "[%s, %d]", status, points );
	        }
	    }
	@Test
	public void StreamTest(){
		final Collection< Task > tasks = Arrays.asList(
			    new Task( Status.OPEN, 5 ),
			    new Task( Status.OPEN, 13 ),
			    new Task( Status.CLOSED, 8 ) 
			);
		final long totalPointsOfOpenTasks = tasks
			    .stream()
			    .filter( task -> task.getStatus() == Status.OPEN )
			    .mapToInt( Task::getPoints )//mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream
			    .sum();
		System.out.println( "Total points: " + totalPointsOfOpenTasks );
		//，但这个例子的不同之处在于这个程序是并行运行的，其次使用reduce方法来算最终的结果。
		final double totalPoints = tasks
				   .stream()
				   .parallel()
				   .map( task -> task.getPoints() ) // or map( Task::getPoints ) 
//				   .reduce( 0, Integer::sum );//和下面那句等價
				   .reduce(0 , (x, y) -> x + y);
				     
		System.out.println( "Total points (all tasks): " + totalPoints );
//				经常会有这个一个需求：我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求
		// Group tasks by their status
		final Map< Status, List< Task > > map = tasks
		    .stream()
		    .collect( Collectors.groupingBy( Task::getStatus ) );
		System.out.println( map );
//		让我们来计算整个集合中每个task分数（或权重）的平均值来结束task的例子。
		// Calculate the weight of each tasks (as percent of total points) 
		final Collection< String > result = tasks
		    .stream()                                        // Stream< String >
		    .mapToInt( Task::getPoints )                     // IntStream
		    .asLongStream()                                  // LongStream
		    .mapToDouble( points -> points / totalPoints )   // DoubleStream
		    .boxed()                                         // Stream< Double >
		    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
		    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
		    .collect( Collectors.toList() );                 // List< String > 
		System.out.println( result );
	}
	
	@Test
	public void Base64Test(){
        final String text = "Base64 finally in Java 8!";
        
        final String encoded = Base64
            .getEncoder()
            .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
        System.out.println( encoded );
         
        final String decoded = new String( 
            Base64.getDecoder().decode( encoded ),
            StandardCharsets.UTF_8 );
        System.out.println( decoded );
//        Base64类同时还提供了对URL、MIME友好的编码器与解码器
//        （Base64.getUrlEncoder() / Base64.getUrlDecoder(), Base64.getMimeEncoder() / Base64.getMimeDecoder()）。
	}

	@Test
	public void ParallelArraysTest(){
		long[] arrayOfLong = new long [ 20000 ]; 
        Arrays.parallelSetAll( arrayOfLong, 
            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
         
        Arrays.parallelSort( arrayOfLong );     
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
	}
}
