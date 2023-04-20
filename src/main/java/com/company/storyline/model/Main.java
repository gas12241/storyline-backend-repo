//package com.company.storyline.model;
//import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
//import static com.mongodb.client.model.Filters.eq;
//import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
//import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
//
//import org.bson.codecs.configuration.CodecProvider;
//import org.bson.codecs.configuration.CodecRegistry;
//import org.bson.codecs.pojo.PojoCodecProvider;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//public class Main {
//    static CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
//    static CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
//    static String uri = "mongodb+srv://gas12241:Imawesome12241@cluster0.nxsjok0.mongodb.net/?retryWrites=true&w=majority";
//    static String databaseName = "DBcs5500";
//    static String collectionName = "Storyline";
//
//    public static Day firstDayObject() {
//        try (MongoClient mongoClient = MongoClients.create(uri)) {
//            MongoDatabase database = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
//            MongoCollection<Day> collection = database.getCollection(collectionName, Day.class);
//
//            Day day = collection.find(eq("date", "20130211")).first();
//            return day;
//        }
//    }
//
//    // Gets the locations based off of one day, but in specific
//    // for now its for the first day. Also there are times when
//    // I have a place with longitude and latitude but it's unknown
//    // In the future I should probably get rid of those as it's
//    // not helpful to the user.
//    public static void printLocationsForDay(Day day) {
//        Integer placeCounter = 0;
//        for (int i = 0; i < day.getSegments().size(); i++) {
//            if (day.getSegments().get(i).getType().equals("place")) {
//                placeCounter += 1;
//                Double lat = day.getSegments().get(i).getPlace().getLocation().getLat();
//                Double lon = day.getSegments().get(i).getPlace().getLocation().getLat();
//                String placeName = day.getSegments().get(i).getPlace().getName();
//                String placeType = day.getSegments().get(i).getPlace().getType();
//                System.out.println("Place " + placeCounter + " was " +
//                        placeName + ", which is of type "+
//                        placeType + ". It has the coordinates " + lat +
//                        " latitude and " + lon + " longitude!");
//            }
//        }
//    }
//
//    public static void printCaloriesForDay(Day day) {
//        Integer idleCalories = day.getCaloriesIdle();
//        Integer activityCalorieSum = 0;
//        for (int i = 0; i < day.getSummary().size(); i++) {
//            if (day.getSummary().get(i).getCalories() != null) {
//                activityCalorieSum += day.getSummary().get(i).getCalories();
//            }
//        }
//        Integer totalCalories = idleCalories + activityCalorieSum;
//        System.out.println("Overall, you burned " + totalCalories + ", of which " + activityCalorieSum + " were from activities and " + idleCalories + " were idle calories!");
//    }
//
//    public static void main(String[] args) {
//        Day day = firstDayObject();
//        printLocationsForDay(day);
//        printCaloriesForDay(day);
//    }
//}