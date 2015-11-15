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
     * Calculates the percentage of answers by hobby.
     * @param list The list of people to be calculated.
     * @return An array of doubles with a -1 indicating a change in hobby.
     */
    public double[] getPercentageByHobby(PeopleList list)
    {
        PeopleList readList = new PeopleList();
        PeopleList artList = new PeopleList();
        PeopleList sportsList = new PeopleList();
        PeopleList musicList = new PeopleList();
        double[] returnArray = new double[list.getPopulation() + 3];
        int returnIndex = 0;
        for (int count = 0; count < list.getPopulation(); count++)
        {
            Person person = list.getPeople().get(count);
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
        double[] readArray = getPercentage(readList);
        for (int count = 0; count < readArray.length; count++)
        {
            returnArray[count] = readArray[count];
        }
        returnIndex = returnIndex + readArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] artArray = getPercentage(artList);
        for (int count = 0; count < artArray.length; count++)
        {
            returnArray[count + returnIndex] = artArray[count];
            
        }
        returnIndex = returnIndex + artArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] sportsArray = getPercentage(sportsList);
        for (int count = 0; count < sportsArray.length; count++)
        {
            returnArray[count + returnIndex] = sportsArray[count];
        }
        returnIndex = returnIndex + sportsArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] musicArray = getPercentage(musicList);
        for (int count = 0; count < musicArray.length; count++)
        {
            returnArray[count + returnIndex] = sportsArray[count];
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
        int count1 = 1;
        int index = -1;
        if (answers.length > 1)
        {
            while (count1 < answers.length)
            {
                Song songToInsert = answerKey.get(count1);
                //remove original.
                String name = songToInsert.getSongTitle();
                int count2 = count1 + 1;
                while (count1 < count2)
                {
                    if (name.compareTo(answerKey.get(count2).getSongTitle()) < 0);
                    {
                        index = count2;
                        count2 = answers.length;
                    }
                    count2++;
                }
                if (index > -1)
                {
                    answerKey.addNodeAtIndex(songToInsert, index);
                    double answerToInsert = answers[count1];
                    double displacedAnswer = answers[index];
                    answers[index] = answerToInsert;
                    answers[count1] = displacedAnswer;
                }
                count1++;
            }
        }
        return answers;
    }
    
    /**
     * Sorts the song key and the percentages by genre.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortByGenre(double[] answers)
    {
        int count1 = 1;
        int index = -1;
        if (answers.length > 1)
        {
            while (count1 < answers.length)
            {
                Song songToInsert = answerKey.get(count1);
                //remove original.
                String name = songToInsert.getGenre();
                int count2 = count1 + 1;
                while (count1 < count2)
                {
                    if (name.compareTo(answerKey.get(count2).getGenre()) < 0);
                    {
                        index = count2;
                        count2 = answers.length;
                    }
                    count2++;
                }
                if (index > -1)
                {
                    answerKey.addNodeAtIndex(songToInsert, index);
                    double answerToInsert = answers[count1];
                    double displacedAnswer = answers[index];
                    answers[index] = answerToInsert;
                    answers[count1] = displacedAnswer;
                }
                count1++;
            }
        }
        return answers;
    }
    
    /**
     * Sorts the song key and the percentages by year.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortByYear(double[] answers)
    {
        int count1 = 1;
        int index = -1;
        if (answers.length > 1)
        {
            while (count1 < answers.length)
            {
                Song songToInsert = answerKey.get(count1);
                //remove original.
                String name = songToInsert.getYear();
                int count2 = count1 + 1;
                while (count1 < count2)
                {
                    if (name.compareTo(answerKey.get(count2).getYear()) < 0);
                    {
                        index = count2;
                        count2 = answers.length;
                    }
                    count2++;
                }
                if (index > -1)
                {
                    answerKey.addNodeAtIndex(songToInsert, index);
                    double answerToInsert = answers[count1];
                    double displacedAnswer = answers[index];
                    answers[index] = answerToInsert;
                    answers[count1] = displacedAnswer;
                }
                count1++;
            }
        }
        return answers;
    }
    
    /**
     * Sorts the song key and the percentages by artist name.
     * @param answers The answers to be sorted.
     * @return The sorted answers
     */
    public double[] sortByArtistName(double[] answers)
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
                    double answerToInsert = answers[count1];
                    double displacedAnswer = answers[index];
                    answers[index] = answerToInsert;
                    answers[count1] = displacedAnswer;
                }
                count1++;
            }
        }
        return answers;
    }
}
