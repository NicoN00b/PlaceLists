import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

    public class App {
        public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
            staticFileLocation("/public");

            get("/places/new", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "place-form.hbs");
            }, new HandlebarsTemplateEngine());

            post("/places/new", (request, response) -> { //URL to make new place on POST route
                Map<String, Object> model = new HashMap<String, Object>();
                String name = request.queryParams("name");
                String newLocation = request.queryParams("location");
                String newDate = request.queryParams("date");
                Place newPlace = new Place(name, newLocation, newDate);
                model.put("place", newPlace);
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());

            get("/", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                ArrayList<Place> places = Place.getAll();
                model.put("places", places);
                return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());

            get("/places/delete", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                Place.clearAllPlaces();
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());

            get("/places/:id", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                int idOfPlaceToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
                Place foundPlace = Place.findById(idOfPlaceToFind); //use it to find place
                model.put("place", foundPlace); //add it to model for template to display
                return new ModelAndView(model, "place-details.hbs"); //individual place page.
            }, new HandlebarsTemplateEngine());

            get("/places/:id/update", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                int idOfPlaceToEdit = Integer.parseInt(req.params("id"));
                Place editPlace = Place.findById(idOfPlaceToEdit);
                model.put("editPlace", editPlace);
                return new ModelAndView(model, "place-form.hbs");
            }, new HandlebarsTemplateEngine());

            post("/places/:id/update", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                String newName = req.queryParams("name");
                String newLocation = req.queryParams("location");
                String newDate = req.queryParams("date");
                int idOfPlaceToEdit = Integer.parseInt(req.params("id"));
                Place editPlace = Place.findById(idOfPlaceToEdit);
                editPlace.update(newName, newLocation, newDate); //don’t forget me
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());

            get("/places/:id/delete", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                int idOfPlaceToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
                Place deletePlace = Place.findById(idOfPlaceToDelete); //use it to find place
                deletePlace.deletePlace();
                return new ModelAndView(model, "success.hbs");
            }, new HandlebarsTemplateEngine());


        }


    }



