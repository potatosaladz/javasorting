package anaydis.ngarnil.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;
import anaydis.ngarnil.sort.Sorter;
import anaydis.ngarnil.sort.SorterType;
import anaydis.ngarnil.sort.data.DataSetGenerator;
import anaydis.ngarnil.sort.data.IntegerDataSetGenerator;
import anaydis.ngarnil.sort.provider.SorterProvider;

public class SortersTest extends TestCase {

	public void testSorters() {
		Iterable<Sorter> sorters = new SorterProvider().getAllSorters();
		DataSetGenerator<Integer> gen = new IntegerDataSetGenerator();
		List<Integer> unsortedList = gen.createRandom(100000);

		for (Sorter sorter : sorters) {
			if (sorter.getType().equals(SorterType.H)) {
				continue;
			}

			List<Integer> copy1 = new ArrayList<Integer>(unsortedList);
			Collections.sort(copy1, gen.getComparator());

			List<Integer> copy2 = new ArrayList<Integer>(unsortedList);
			try {
				sorter.sort(gen.getComparator(), copy2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			assertEquals(copy1, copy2);
		}
	}
}
