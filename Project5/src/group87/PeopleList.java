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
                    if (myPeople.get(i).getAnswers().get(count).equals(" Yes"))
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
            if (hobby.equals(" reading"))
            {
                readList.addPerson(person);
            }
            else if (hobby.equals(" art"))
            {
                artList.addPerson(person);
            }
            else if (hobby.equals(" sports"))
            {
                sportsList.addPerson(person);
            }
            else if (hobby.equals(" music"))
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
     * Calculates the percentage of answers by hobby.
     * @return An array of doubles with a -1 indicating a change in hobby.
     */
    public double[] getPercentageByMajor()
    {
        PeopleList csList = new PeopleList();
        csList.setAnswerKey(answerKey);
        PeopleList otherEngList = new PeopleList();
        otherEngList.setAnswerKey(answerKey);
        PeopleList mathList = new PeopleList();
        mathList.setAnswerKey(answerKey);
        PeopleList otherList = new PeopleList();
        otherList.setAnswerKey(answerKey);
        double[] returnArray = new double[this.getAnswerKey().size() * 8 + 3];
        int returnIndex = 0;
        for (int count = 0; count < this.getPopulation(); count++)
        {
            Person person = this.getPeople().get(count);
            String major = person.getMajor();
            if (major.equals(" Computer Science"))
            {
                csList.addPerson(person);
            }
            else if (major.equals(" Other Engineering"))
            {
                otherEngList.addPerson(person);
            }
            else if (major.equals(" Math or CMDA"))
            {
                mathList.addPerson(person);
            }
            else if (major.equals(" Other"))
            {
                otherList.addPerson(person);
            }
        }
        double[] csArray = csList.getPercentage();
        for (int count = 0; count < csArray.length; count++)
        {
            returnArray[count] = csArray[count];
        }
        returnIndex = returnIndex + csArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] otherEngArray = otherEngList.getPercentage();
        for (int count = 0; count < otherEngArray.length; count++)
        {
            returnArray[count + returnIndex] = otherEngArray[count];

        }
        returnIndex = returnIndex + otherEngArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] mathArray = mathList.getPercentage();
        for (int count = 0; count < mathArray.length; count++)
        {
            returnArray[count + returnIndex] = mathArray[count];
        }
        returnIndex = returnIndex + mathArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] otherArray = otherList.getPercentage();
        for (int count = 0; count < otherArray.length; count++)
        {
            returnArray[count + returnIndex] = otherArray[count];
        }
        return returnArray;
    }


    /**
     * Calculates the percentage of answers by hobby.
     * @return An array of doubles with a -1 indicating a change in hobby.
     */
    public double[] getPercentageByRegion()
    {
        PeopleList neList = new PeopleList();
        neList.setAnswerKey(answerKey);
        PeopleList seList = new PeopleList();
        seList.setAnswerKey(answerKey);
        PeopleList usList = new PeopleList();
        usList.setAnswerKey(answerKey);
        PeopleList otherList = new PeopleList();
        otherList.setAnswerKey(answerKey);
        double[] returnArray = new double[this.getAnswerKey().size() * 8 + 3];
        int returnIndex = 0;
        for (int count = 0; count < this.getPopulation(); count++)
        {
            Person person = this.getPeople().get(count);
            String region = person.getState();
            if (region.equals(" Northeast"))
            {
                neList.addPerson(person);
            }
            else if (region.equals(" Southeast"))
            {
                seList.addPerson(person);
            }
            else if (region.equals(" United States (other than Southeast or Northwest)"))
            {
                usList.addPerson(person);
            }
            else if (region.equals(" Outside of United States"))
            {
                otherList.addPerson(person);
            }
        }
        double[] neArray = neList.getPercentage();
        for (int count = 0; count < neArray.length; count++)
        {
            returnArray[count] = neArray[count];
        }
        returnIndex = returnIndex + neArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] seArray = seList.getPercentage();
        for (int count = 0; count < seArray.length; count++)
        {
            returnArray[count + returnIndex] = seArray[count];

        }
        returnIndex = returnIndex + seArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] usArray = usList.getPercentage();
        for (int count = 0; count < usArray.length; count++)
        {
            returnArray[count + returnIndex] = usArray[count];
        }
        returnIndex = returnIndex + usArray.length;
        returnArray[returnIndex] = -1;
        returnIndex++;
        double[] otherArray = otherList.getPercentage();
        for (int count = 0; count < otherArray.length; count++)
        {
            returnArray[count + returnIndex] = otherArray[count];
        }
        return returnArray;
    }
}