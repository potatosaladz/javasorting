package anaydis.ngarnil.sort.data;

import java.util.*;

/**
 * 
 * DataGenerator implementation. Use it to generate ascending, descending and random 
 * lists of Strings.
 * 
 * @author Nicolas Garnil
 *
 */

public class StringDataSetGenerator
    implements DataSetGenerator<String>
{
    final List<String> dictionary;

    public StringDataSetGenerator()
    {
        dictionary = initDictionary();
    }

    public List<String> createAscending(int length)
    {
        if(length > dictionary.size()) {
            throw new IllegalArgumentException("Ojo! StringDataSetGenerator " +
                    "puede generar valores HASTA un length de " + dictionary.size());
        }

        final List<String> copy = new ArrayList<String>();

        copy.addAll(dictionary.subList(0, length));

        return copy;
    }

    public List<String> createDescending(int length)
    {
        final List<String> copy = createAscending(length);

        
        Collections.reverse(copy);

        return copy;
    }

    public List<String> createRandom(int length)
    {
        final List<String> copy = createAscending(length);

        Collections.shuffle(copy);

        return copy;
    }

    public Comparator<String> getComparator()
    {
        return STRING_COMPARATOR;
    }

    private List<String> initDictionary()
    {
        return  Arrays.asList("ALICE", "AMANDA",
                "AMY", "ANDREA", "ANGELA", "ANN", "ANNA", "ANNE", "ANNIE",
                "ASHLEY", "BARBARA", "BETTY", "BEVERLY", "BONNIE", "BRENDA",
                "CARMEN", "CAROL", "CAROLYN", "CATHERINE", "CHERYL",
                "CHRISTINA", "CHRISTINE", "CINDY", "CONNIE", "CRYSTAL",
                "CYNTHIA", "DAWN", "DEBORAH", "DEBRA", "DENISE", "DIANA",
                "DIANE", "DONNA", "DORIS", "DOROTHY", "EDITH", "EDNA",
                "ELIZABETH", "EMILY", "EVELYN", "FLORENCE", "FRANCES",
                "GLADYS", "GLORIA", "GRACE", "HEATHER", "HELEN", "IRENE",
                "JACQUELINE", "JANE", "JANET", "JANICE", "JEAN", "JENNIFER",
                "JESSICA", "JOAN", "JOYCE", "JUDITH", "JUDY", "JULIA", "JULIE",
                "KAREN", "KATHERINE", "KATHLEEN", "KATHRYN", "KATHY", "KELLY",
                "KIM", "KIMBERLY", "LAURA", "LILLIAN", "LINDA", "LISA", "LOIS",
                "LORI", "LOUISE", "MARGARET", "MARIA", "MARIE", "MARILYN",
                "MARTHA", "MARY", "MELISSA", "MICHELLE", "MILDRED", "NANCY",
                "NICOLE", "NORMA", "PABLIUS", "PAMELA", "PATRICIA", "PAULA", "PEDRO",
                "PEGGY", "PHYLLIS", "RACHEL", "REBECCA", "RITA", "ROBIN", "ROSA",
                "ROSE", "RUBY", "RUTH", "SANDRA", "SARA", "SARAH", "SHARON", "SHIRLEY",
                "STEPHANIE", "SUSAN", "TAMMY", "TERESA", "THERESA", "TIFFANY", 
                "TINA", "TRACY", "VICTORIA", "VIRGINIA", "WANDA", "WENDY");
    }

    /**
     * Constante privada estática del Comparator<String> para retornar en el
     * método {@link #getComparator()}.
     */
    private static final Comparator<String> STRING_COMPARATOR = new Comparator<String>(){

        public int compare(String a, String b)
        {
            return a.compareTo(b);
        }
    };
}
