package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class Bench {

    @Benchmark
    public void bench() {
        int num = 0;
        while (num <= 10) {
            System.out.println(num);
            num++;
        }
    }
}

class RunBench {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("Bench")
                .warmupIterations(11)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(1)
                .measurementTime(TimeValue.seconds(1))
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}



class Test {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.add("Igor");
        stack.add("Boris");
        System.out.println(stack.getLast());
        String a = new String("Hello").intern();
        String b = a;
        b.intern();
        b = "123";
        System.out.println(a);
    }
}