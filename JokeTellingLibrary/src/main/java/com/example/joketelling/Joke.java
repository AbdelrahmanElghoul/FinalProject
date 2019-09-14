package com.example.joketelling;


import java.util.Random;

public class Joke {
    private String[] jokeList={
            "I told my girlfriend she drew her eyebrows too high. She seemed surprised."
            ,"A woman walks into a library and asked if they had any books about paranoia. The librarian says \" They're right behind you!\""
            ,"What did the pirate say when he turned 80 years old? Aye matey."
            ,"A husband and wife were dining at a 5-star restaurant. When their food arrived, the husband said: \" Our food has arrived! Let's eat!\"\n" +
            "\n" +
            "His wife reminded him: \"Honey, you always say your prayers at home before your dinner! \"\n" +
            "\n" +
            "Her husband replied: \" That's at home, my dear. Here the chef knows how to cook...\""
            ,"Q: What did the cannibal's wife do when her husband came home an hour late for dinner?\n" +
            "\n" +
            "A: She gave him the cold shoulder."
            ,"A police officer in a small town stopped a driver speeding down the main street. The driver said he could explain why he was speeding, but the police officer said he was going to put him in jail until the Chief got back, but lucky for the driver that the chief will be in a good mood because he is at his daughter's wedding. The driver said,\n" +
            "\" Don't count on it. I'm the groom. \" "
    };
   public String getJoke(){
        return jokeList[new Random().nextInt(jokeList.length)] ;
    }
}
