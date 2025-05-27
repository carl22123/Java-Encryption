import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Function
{
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;

    public Function()
    {
        random = new Random();
        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' ';

        newKey();
    }

    public void newKey()
    {
        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i=32;i<127;i++)
        {
            list.add(Character.valueOf(character));
            character++;
        }
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
    }

    public String getKey()
    {
        String key = "";
        for(Character x : shuffledList)
        {
           key = key + x.toString();
        }
        return key;
    }

    public void setKey(String Key)
    {
        shuffledList.clear();
        for(int i = 0; i < Key.length(); i++)
        {
            shuffledList.add(Key.charAt(i));
        }
    }

    public String encrypt(String message)
    {
        letters = message.toCharArray();

        for(int i =0;i<letters.length;i++)
        {
            for(int j =0;j<list.size();j++)
            {
                if(letters[i]==list.get(j))
                {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        String outputMessage = "";
        for(char x : letters) // put the char to a string
        {
            outputMessage = outputMessage + x;
        }
        return outputMessage;
    }

    public String decrypt(String message)
    {
        letters = message.toCharArray();
        for(int i =0;i<letters.length;i++)
        {
            for(int j =0;j<shuffledList.size();j++)
            {
                if(letters[i]==shuffledList.get(j))
                {
                    letters[i]=list.get(j);
                    break;
                }
            }
        }
        String outputMessage = "";
        for(char x : letters) // put the char to a string
        {
            outputMessage = outputMessage + x;
        }
        return outputMessage;
    }
}
