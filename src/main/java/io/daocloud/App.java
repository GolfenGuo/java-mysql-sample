package io.daocloud;

import static spark.Spark.*;

import spark.*;

public class App {

   public static void main(String[] args) throws Exception{
      
      get(new Route("/") {
         @Override
         public Object handle(Request request, Response response) {
           
        Integer score = null;
        try {
          Storage storage = new Storage();
          storage.populate();
          score = storage.getScore();
        } catch (Exception e) {
          e.printStackTrace();
        }

        return "Hello world, " + score + "!";
         }
      });

   }

}
