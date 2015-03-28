package io.daocloud;

import static spark.Spark.*;

import spark.*;

public class HelloWorld {

   public static void main(String[] args) {

      Storage storage = new Storage();
      
      get(new Route("/") {
         @Override
         public Object handle(Request request, Response response) {
            storage.populate();
        Integer score = null;
        try {
          score = storage.getScore();
        } catch (Exception e) {
          e.printStackTrace();
        }

        return "Hello world, " + score + "!";
         }
      });

   }

}
