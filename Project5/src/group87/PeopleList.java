package group87;

/**
 * A list of people.
 * @author Larissa Schneider (larissa6)
 * @author Simone Stewart (simone5)
 * @author Tara Amruthur (taraa2)
 * @version 2015.11.15
 */
public class PeopleList 
{
    private int population;
    private DoublyLinkedList<Person> people;
    private DoublyLinkedList<Song> answerKey;

    /**
     * Creates a new People List.
     */
    public PeopleList()
    {
        population = 0;
        people = new DoublyLinkedList<Person>();
    }

    /**
     * Establishes the answer key.
     * @param key The answer key to be set.
     */
    public void setAnswerKey(DoublyLinkedList<Song> key)
    {
        answerKey = key;
    }

    /**
     * Gets the answer key.
     * @return The key.
     */
    public DoublyLinkedList<Song> getAnswerKey()
    {
        return answerKey;
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
     * @return The percentages.
     */
    public double[] getPercentage()
    {
        DoublyLinkedList<Person> myPeople = this.getPeople();
        double sum;
        double[] returnDouble = new double[this.getAnswerKey().size() * 2];
        if (this.getPopulation() == 0)
        {
            for (int count = 0; count < this.getAnswerKey().size() * 2; count++)
            {
                returnDouble[count] = -2;
            }
        }
        else
        {
            for (int count = 0; count < this.getAnswerKey().size() * 2; count++)
            {
                sum = 0;
                for (int i = 0; i < this.getPopulation(); i++)
                {
                    if (myPeople.get(i).getAnswers().get(count).equals("Yes"))
                    {
                        sum++;
                    }
                }
                returnDouble[count] = sum / this.getPopulation() * 100;
            }
        }
        return returnDouble;
    }

    /**
     * Calculates the percentage of answers by hobby.
     * @return An array of doubles with a -1 indicating a change in hobby.
     */
    public double[] getPercentageByHobby()
    {
        PeopleList readList = new PeopleList();
        readList.setAnswerKey(answerKey);
        PeopleList artList = new PeopleList();
        artList.setAnswerKey(answerKey);
        PeopleList sportsList = new PeopleList();
        sportsList.setAnswerKey(answerKey);
        PeopleList musicList = new PeopleList();
        musicList.setAnswerKey(answerKey);
        double[] returnArray = new double[this.getAnswerKey().size() * 8 + 3];
        int returnIndex = 0;
        for (int count = 0; count < this.getPopulation(); count++)
        {
            Person person = this.getPeople().get(count);
            String hobby = person.getHobby();
            if (hobby.equals("read"))
            {
                readList.addPerson(person);
            }
            else if (hobby.equals("art"))
            {
                artList.addPerson(person);
            }
            else if (hobby.equals("sports"))
            {
                sportsList.addPerson(person);
            }
            else if (hobby.equals("music"))
            {
                musicList.addPerson(person);
            }
        }
        double[] readArray = readList.getPercentage();
        for (int count = 0; count < readArray.length; count++)
        {
            returnArray[count] = readArray[count];
        }
        returnIndex = returnIndex + readArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] artArray = artList.getPercentage();
        for (int count = 0; count < artArray.length; count++)
        {
            returnArray[count + returnIndex] = artArray[count];

        }
        returnIndex = returnIndex + artArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] sportsArray = sportsList.getPercentage();
        for (int count = 0; count < sportsArray.length; count++)
        {
            returnArray[count + returnIndex] = sportsArray[count];
        }
        returnIndex = returnIndex + sportsArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] musicArray = musicList.getPercentage();
        for (int count = 0; count < musicArray.length; count++)
        {
            returnArray[count + returnIndex] = musicArray[count];
        }
        return returnArray;
    }

    /**
     * Sorts the song key and the percentages by song title.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortBySongTitle(double[] answers)   
    {
        // Sorting moved to DoublyLinkedList
        return null;
    }

    /**
     * Sorts the song key and the percentages by genre.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortByGenre(double[] answers)
    {
        // Sorting moved to DoublyLinkedList
        return null;
    }

    /**
     * Sorts the song key and the percentages by year.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortByYear(double[] answers)
    {
        // Sorting moved to DoublyLinkedList
        return null;
    }

    /**
     * Sorts the song key and the percentages by artist name.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortByArtistName(double[] answers)
    {
        // Sorting moved to DoublyLinkedList
        return null;   
    }

    public void intermediateOutput()
    {
        double[] results = this.getPercentageByHobby();
        double[] resultsByTitle = 
                answerKey.insertionSort("Song Title", results);
        System.out.println("Hobby, sorted by song title: ");
        for (int count = 0; count < resultsByTitle.length; count++)
        {
            System.out.println(resultsByTitle[count]);
        }
        double[] resultsByGenre = answerKey.insertionSort("Genre", results);
        System.out.println("Hobby, sorted by genre ");
        for (int count = 0; count < resultsByGenre.length; count++)
        {
            System.out.println(resultsByGenre[count]);
        }

    }
}
