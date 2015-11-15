package group87;

/**
 * A list of people.
 * @author Larissa Schneider (larissa6), Simone Stewart (simone5), Tara Amruthur (taraa2)
 * @version 2015.11.15
 */
public class PeopleList 
{
    private int population;
    private DoublyLinkedList<Person> people;
    public static DoublyLinkedList<Song> answerKey;
    
    /**
     * Creates a new People List.
     */
    public PeopleList()
    {
        population = 0;
        people = new DoublyLinkedList<Person>();
    }
    
    /**
     * Gets the people in the list.
     * @return The people
     */
    public DoublyLinkedList<Person> getPeople()
    {
        return people;
    }
    
    /**
     * Gets the population of the list.
     * @return The population.
     */
    public int getPopulation()
    {
        return population;
    }
    
    /**
     * Adds a person to the people list.
     * @param person The person to be added.
     */
    public void addPerson(Person person)
    {
        people.add(person);
        population++;
    }
    
    /**
     * Calculates the percentages of responses by song.
     * @param list The people whose results are being calculated.
     * @return The percentages.
     */
    public double[] getPercentage(PeopleList list)
    {
        DoublyLinkedList<Person> myPeople = list.getPeople();
        double sum;
        double[] returnDouble = new double[answerKey.size()];
        for (int count = 0; count < answerKey.size(); count++)
        {
            sum = 0;
            for (int i = 0; i < population; i++)
            {
                if (myPeople.get(i).getAnswers().get(count).equals("Yes"))
                {
                    sum++;
                }
            }
            returnDouble[count] = sum / population * 100;
        }
        return returnDouble;
    }
    
    /**
     * Sorts 
     * @param answers
     */
    public void sortByArtistName(double[] answers)
    {
        int count1 = 1;
        int index = -1;
        if (answers.length > 1)
        {
            while (count1 < answers.length)
            {
                Song songToInsert = answerKey.get(count1);
                //remove original.
                String name = songToInsert.getArtistName();
                int count2 = count1 + 1;
                while (count1 < count2)
                {
                    if (name.compareTo(answerKey.get(count2).getArtistName()) < 0);
                    {
                        index = count2;
                        count2 = answers.length;
                    }
                    count2++;
                }
                if (index > -1)
                {
                    answerKey.addNodeAtIndex(songToInsert, index);
                }
                count1++;
            }
        }
    }
}
