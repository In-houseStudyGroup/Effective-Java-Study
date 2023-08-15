package item4Interface;

import java.util.List;
import java.util.stream.Collector;

public interface CollectionInterface {
    
    <T> Collector<T, ?, List<T>> toList();
}
