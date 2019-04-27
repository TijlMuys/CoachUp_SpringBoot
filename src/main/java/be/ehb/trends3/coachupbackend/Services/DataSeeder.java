package be.ehb.trends3.coachupbackend.Services;

import be.ehb.trends3.coachupbackend.Exceptions.AccountNotFoundException;
import be.ehb.trends3.coachupbackend.Exceptions.CoachNotFoundException;
import be.ehb.trends3.coachupbackend.Models.*;
import be.ehb.trends3.coachupbackend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {


    @Autowired
    private LocationRepository locationRepos;

    @Autowired
    private SportRepository sportRepos;

    @Autowired
    private CoachRepository coachRepos;

    @Autowired
    private SporterRepository sporterRepos;

    @Autowired
    private LessonRepository lessonRepos;

    @Autowired
    private AccountRepository accountRepos;


    @Override
    public void run(String...args) throws Exception {

        Location location1 = new Location();
        location1.setStreet("Jagerij");
        location1.setNumber("343");
        location1.setZipCode("2800");
        location1.setCity("Mechelen");
        locationRepos.save(location1);

        //Sports
        Sport wrestling = new Sport("Wrestling", "https://images.unsplash.com/photo-1541337082051-5959dbb57d5d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(wrestling);

        Sport waterpolo = new Sport("Water Polo", "https://images.unsplash.com/photo-1523631112603-45de7c0731fc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(waterpolo);

        Sport skiiing = new Sport("Skiing", "https://images.unsplash.com/photo-1507492147080-3d1b3e5cd0aa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(skiiing);

        Sport snowboard = new Sport("Snowboarding", "https://images.unsplash.com/photo-1518608774889-b04d2abe7702?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1300&q=80");
        sportRepos.save(snowboard);

        Sport mixedMartialArts = new Sport("Mixed Martial Arts", "https://images.unsplash.com/photo-1520529301226-42abc4cd766b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(mixedMartialArts);

        Sport bowling = new Sport("Bowling", "https://images.unsplash.com/photo-1422913687378-69480576789e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1287&q=80");
        sportRepos.save(bowling);

        Sport handball = new Sport("Handball", "https://images.unsplash.com/photo-1513028738826-f000cded30a4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1352&q=80");
        sportRepos.save(handball);

        Sport trackAndField = new Sport("Track and Field", "https://images.unsplash.com/photo-1457470572216-1240fac24b37?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(trackAndField);

        Sport lacrosse = new Sport("Lacrosse", "https://images.unsplash.com/photo-1525354251932-d74bad03d4fa?ixlib=rb-1.2.1&auto=format&fit=crop&w=1387&q=80");
        sportRepos.save(lacrosse);

        Sport cycling = new Sport("Cycling", "https://images.unsplash.com/photo-1512588617594-f80495876bff?ixlib=rb-1.2.1&auto=format&fit=crop&w=1489&q=80");
        sportRepos.save(cycling);

        Sport americanFootball = new Sport("American Football", "https://images.unsplash.com/photo-1549963921-a936ee5b69e6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1255&q=80");
        sportRepos.save(americanFootball);

        Sport motorSports = new Sport("Motor Sports", "https://images.unsplash.com/photo-1506424482693-1f123321fa53?ixlib=rb-1.2.1&auto=format&fit=crop&w=1292&q=80");
        sportRepos.save(motorSports);

        Sport baseball = new Sport("Baseball", "https://images.unsplash.com/photo-1508344928928-7165b67de128?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(baseball);

        Sport boxing = new Sport("Boxing", "https://images.unsplash.com/photo-1495555687398-3f50d6e79e1e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(boxing);

        Sport rugby = new Sport("Rugby", "https://images.unsplash.com/photo-1480099225005-2513c8947aec?ixlib=rb-1.2.1&auto=format&fit=crop&w=1465&q=80");
        sportRepos.save(rugby);

        Sport iceHockey = new Sport("Ice Hockey", "https://images.unsplash.com/photo-1553130745-2bdd25a396f0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80");
        sportRepos.save(iceHockey);

        Sport golf = new Sport("Golf", "https://images.unsplash.com/photo-1530028828-25e8270793c5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(golf);

        Sport cricket = new Sport("Cricket", "https://images.unsplash.com/photo-1552435053-01c010307582?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1425&q=80");
        sportRepos.save(cricket);

        Sport volleyball = new Sport("Volleyball", "https://images.unsplash.com/photo-1547347298-4074fc3086f0?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(volleyball);

        Sport airSports = new Sport("Air Sports", "https://images.unsplash.com/photo-1506588345361-5e12b7840845?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(airSports);

        Sport badminton = new Sport("Badminton", "https://images.unsplash.com/photo-1521537634581-0dced2fee2ef?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(badminton);

        Sport archery = new Sport("Archery", "https://images.unsplash.com/photo-1538432091670-e6b79bd9bffa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1489&q=80");
        sportRepos.save(archery);

        Sport soccer = new Sport("Soccer", "https://images.unsplash.com/photo-1508087625439-de3978963553?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1352&q=80");
        sportRepos.save(soccer);

        Sport gymnastics = new Sport("Gymnastics", "https://images.unsplash.com/photo-1516208962313-9d183d94f577?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1267&q=80");
        sportRepos.save(gymnastics);

        Sport running = new Sport("Jogging", "https://images.unsplash.com/photo-1486218119243-13883505764c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1352&q=80");
        sportRepos.save(running);

        Sport mtb = new Sport("Mountainbike", "https://images.unsplash.com/photo-1458372810370-daad23adb565?ixlib=rb-1.2.1&auto=format&fit=crop&w=1488&q=80");
        sportRepos.save(mtb);

        Sport cyclocross = new Sport("Cyclo-cross", "https://images.unsplash.com/photo-1542663388-5c468b7a4a45?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1942&q=80");
        sportRepos.save(cyclocross);

        Sport swimming = new Sport("Swimming", "https://images.unsplash.com/photo-1461567797193-e5b489ac026a?ixlib=rb-1.2.1&auto=format&fit=crop&w=2089&q=80");
        sportRepos.save(swimming);

        Sport fitness = new Sport("Fitness", "https://images.unsplash.com/photo-1534438327276-14e5300c3a48?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(fitness);

        Sport hiking = new Sport("Hiking", "https://images.unsplash.com/photo-1502126324834-38f8e02d7160?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(hiking);

        Sport climbing = new Sport("Climbing", "https://images.unsplash.com/photo-1495482479037-588f9b3712c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(climbing);

        Sport fencing = new Sport("Fencing", "https://images.unsplash.com/photo-1487491491904-a48f73cd4078?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(fencing);

        Sport iceSkating = new Sport("Ice Skating", "https://images.unsplash.com/photo-1550865811-cc8872a15d1b?ixlib=rb-1.2.1&auto=format&fit=crop&w=2134&q=80");
        sportRepos.save(iceSkating);

        Sport equitation = new Sport("Equitation", "https://images.unsplash.com/photo-1546894239-c9865f479ad0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1949&q=80");
        sportRepos.save(equitation);

        Sport tennis = new Sport("Tennis", "https://images.unsplash.com/photo-1485908953667-cf6d88997642?ixlib=rb-1.2.1&auto=format&fit=crop&w=1320&q=80");
        sportRepos.save(tennis);

        Sport inlineSkating = new Sport("Inline Skating", "https://images.unsplash.com/photo-1501782223170-a04fc18cba9e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(inlineSkating);

        Sport tableTennis = new Sport("Table Tennis", "https://images.unsplash.com/photo-1543165057-6fbd4d3d3bcc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(tableTennis);

        Sport basketball = new Sport("Basketball", "https://images.unsplash.com/photo-1519861531473-9200262188bf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80");
        sportRepos.save(basketball);

        Sport fieldhockey = new Sport("Field Hockey", "https://images.unsplash.com/photo-1540862758454-694a03e98110?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(fieldhockey);

        Sport judo = new Sport("Judo", "https://images.unsplash.com/photo-1542937307-e90d0cc07237?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(judo);

        Sport skateboard = new Sport("Skateboarding", "https://images.unsplash.com/photo-1536318431364-5cc762cfc8ec?ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80");
        sportRepos.save(skateboard);

        Sport surfing = new Sport("Surfing", "https://images.unsplash.com/photo-1502680390469-be75c86b636f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(surfing);

        Sport frisbee = new Sport("Frisbee", "https://images.unsplash.com/photo-1550606275-154cef1f823b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(frisbee);

        Sport dance = new Sport("Dance", "https://images.unsplash.com/photo-1474308371634-c715850e8d8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(dance);

        Sport yoga = new Sport("Yoga", "https://images.unsplash.com/photo-1516208398649-d5d401ba8c49?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80");
        sportRepos.save(yoga);

        Coach coach = new Coach();
        coach.setProfileText("ome quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.Some quick example text to build on the card title and make up the bulk of the card's content.");
        coach.setProfileImg("https://images.unsplash.com/photo-1457470572216-1240fac24b37?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80");
        coachRepos.save(coach);

        Lesson lesson = new Lesson();
        lesson.setDifficulty(3);
        lesson.setLessonName("Soccer Skills Advanced");
        lesson.setLessonDescription("In this lesson you will learn how to control the ball while keeping your eyes on the opposing team. Additionally, you will learn how to curve the ball and perform the perfect pass to your teammate.");
        lesson.setSport(soccer);
        lesson.setCoach(coach);
        lesson.setLessonLocation(location1);
        lessonRepos.save(lesson);

        Lesson lesson2 = new Lesson();
        lesson2.setDifficulty(1);
        lesson2.setLessonName("Golf Beginner");
        lesson2.setLessonDescription("In this lesson we will go over the basics of Golf go over the different types of gold clubs, how to hold your club and properly swing to reach the maximal distance.");
        lesson2.setSport(golf);
        lesson2.setCoach(coach);
        lesson2.setLessonLocation(location1);
        lessonRepos.save(lesson2);

        Sporter sporter = new Sporter();
        sporter.setProfileText("Ik ben een testcoach");
        sporterRepos.save(sporter);

        List<Account> foundAccounts = (accountRepos.findAccountByEmail("testcoach@gmail.com"));
        if(foundAccounts.size() != 1){
            Account coachAccount = new Account("testcoach@gmail.com", "Test Coach", "$2a$10$f7sHcIdjKvMTGkc.8dJUFe9n.Qoaa9fvO2WzLqpZEsCalLkGGYtri", "coach", "Rue Henri Lambert", "182", "3500", "Hasselt", null, true, "0490 61 78002", null, coach);
            accountRepos.save(coachAccount);
        }

        List<Account> foundAccounts2 = (accountRepos.findAccountByEmail("testsporter@gmail.com"));
        if(foundAccounts2.size() != 1) {
            Account sporterAccount = new Account("testsporter@gmail.com", "Test Sporter", "$2a$10$f7sHcIdjKvMTGkc.8dJUFe9n.Qoaa9fvO2WzLqpZEsCalLkGGYtri", "regular", "Rue de Fromelenne", "407", "9000", "Gent", null, true, "0479 81 97000", sporter, null);
            accountRepos.save(sporterAccount);
        }

        List<Account> foundAccounts3 = (accountRepos.findAccountByEmail("admin@gmail.com"));
        if(foundAccounts3.size() != 1) {
            Account adminAccount = new Account("admin@gmail.com", "Admin", "$2a$10$f7sHcIdjKvMTGkc.8dJUFe9n.Qoaa9fvO2WzLqpZEsCalLkGGYtri", "regular", "Rue de Fromelenne", "407", "9000", "Gent", null, true, null, sporter, null);
            accountRepos.save(adminAccount);
        }


    }
}