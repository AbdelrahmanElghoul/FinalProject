package com.example.javalibrary;

import java.util.Random;

public class Jokes {

   private String[] joke={"joke 1","joke 2","joke 3","joke 4"};
   public String getJoke(){
        return joke[new Random().nextInt(joke.length)];
    }
}
