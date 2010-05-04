package anaydis.ngarnil.sort.data;

import java.util.List;
import java.util.Comparator;

/**
 * 
 * This interface was created for testing purposes. It is not a must to use
 * a DataSetGenerator to use the Sorters but please note you will have to implement
 * a java.util.Comparator for being for the Sorter to work.
 * 
 * @author Nicolas Garnil
 *
 * @param <T> the type of objects the generator will generate
 */

public interface DataSetGenerator<T> {

	List<T> createAscending(int length);

	List<T> createDescending(int length);

	List<T> createRandom(int length);

	Comparator<T> getComparator();
}
