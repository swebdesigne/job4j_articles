package ood;

import java.util.List;

public interface SequenceGenerator<T> {
    List<T> generate(int size);
}
