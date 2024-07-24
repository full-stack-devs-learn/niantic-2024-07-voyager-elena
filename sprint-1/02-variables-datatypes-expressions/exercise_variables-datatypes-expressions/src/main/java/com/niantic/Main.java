package com.niantic;

public class Main {
    public static void main(String[] args) {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples() {
        // i. Create a variable that stores the name of the best
        // programming language.
        String bestLanguage;
        bestLanguage = "Java";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + bestLanguage);
        System.out.println();


        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01() {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();


        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)
        String name = "Elena";

        System.out.println("1. My name: " + name);
        System.out.println();


        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age = 17;

        System.out.println("2. My age: " + age + " :)");
        System.out.println();


        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        double pi = 3.1415;

        System.out.println("3. The first 5 digits of PI: " + pi);
        System.out.println();


        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)

        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
        double price = 12.34;

        System.out.println("4. The price of an adult meal: " + price);
        System.out.println();

    }

    public static void section02() {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.


        // 5. Declare a variable to store the name of your
        // favorite super hero.

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.
        String myFavoriteSuperHeroName = "Wolverine";

        System.out.println("5. My favorite super hero name: " + myFavoriteSuperHeroName);
        System.out.println();


        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)
        int questionWeight = 1;
        int questionsTotal = 100;
        int questionsCorrect = (int) (Math.random() * (questionsTotal + 1));
        int testScore = questionsCorrect * questionWeight;

        System.out.println("6. Test Score: " + testScore);
        System.out.println();


        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)
        long currentUSAPopulation = 341_932_630L;

        System.out.println("7. Current population in the United States: " + currentUSAPopulation);


        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)
        long currentChinaPopulation = 1_425_146_846L;

        System.out.println("8. Current population in China: " + currentChinaPopulation);


        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)
        long currentWorldPopulation = 8_123_652_270L; // it is impossible to copy it because it is constantly increasing :)

        System.out.println("9. Current population in the world: " + currentWorldPopulation);
        System.out.println();

        System.out.println("7-8 My attempt to print it nicely:");
        System.out.printf("%-45s", "7. Current population in the United States:");
        System.out.printf("%,15d", currentUSAPopulation);
        System.out.println();
        System.out.printf("%-45s", "8. Current population in China:");
        System.out.printf("%,15d", currentChinaPopulation);
        System.out.println();
        System.out.printf("%-45s", "9. Current population in the world:");
        System.out.printf("%,15d", currentWorldPopulation);
        System.out.println();
        System.out.println();


        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.
        boolean isWireless = true;
        System.out.println("10. Is my mouse wireless: " + isWireless);
        System.out.println();


        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.
        double latitudeOfDublin = 37.702152;
        double longitudeOfDublin = -121.935791;
        System.out.println("11. The latitude of Dublin, CA, USA is " + latitudeOfDublin + " and the longitude is " + longitudeOfDublin);
        System.out.println();

        // 12. Create a variable that holds the current
        // Microsoft stock price.
        double microsoftStockPrice = 444.85;
        System.out.println("12. Microsoft stock price: " + microsoftStockPrice);
        System.out.println();
    }

    public static void section03() {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.

        // How many shots did Pete take?
        int shotsMade = 7;
        int shotsMissed = 3;
        int shotsSuccessful = shotsMade - shotsMissed;

        System.out.println("13.");
        System.out.println("Pete made " + shotsMade + " shots");
        System.out.println("Pete missed " + shotsMissed + " of his shots");
        System.out.println("Pete did " + shotsSuccessful + " successful shots");
        System.out.println();

        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.

        // How many 2 point shots did Pete make?
        shotsMade = 20;
        shotsMissed = 6;
        int shots3Points = 3;
        int shots2Points;
        shotsSuccessful = shotsMade - shotsMissed;
        shots2Points = shotsSuccessful - shots3Points;

        System.out.println("14.");
        System.out.println("Pete made " + shotsMade + " shots");
        System.out.println("Pete missed " + shotsMissed + " of his shots");
        System.out.println("Pete made " + shots3Points + " three point shots");
        System.out.println("Pete made " + shots2Points + " two point shots");
        System.out.println();

        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.

        // How many total shots did they make?
        int shotsPete = 6;
        int shotsPat = 2 * shotsPete;
        int shotsTotal = shotsPat + shotsPete;

        System.out.println("15.");
        System.out.println("Pete made " + shotsPete + " shots");
        System.out.println("Pat made " + shotsPat + " shots");
        System.out.println("Total shots they made: " + shotsTotal);
        System.out.println();


        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?
        shotsPete = 13;
        shotsPat = 9;
        shotsPete++;
        shotsPat++;
        shotsTotal = shotsPat + shotsPete;

        System.out.println("16.");
        System.out.println("Pete made " + shotsPete + " shots");
        System.out.println("Pat made " + shotsPat + " shots");
        System.out.println("Total shots they made: " + shotsTotal);
        System.out.println();

        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.

        // What percentage of his shots did he make?
        shotsMade = 11;
        shotsMissed = 4;
        shotsSuccessful = shotsMade - shotsMissed;
        double percent = shotsSuccessful * 100.00 / shotsMade;

        System.out.println("17.");
        System.out.println("Pete made " + shotsMade + " shots");
        System.out.println("Pete missed " + shotsMissed + " of his shots");
        System.out.println("Pete did " + shotsSuccessful + " successful shots");
        System.out.println("Percentage of successful shots: " + percent + "%");
        System.out.println();

        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.

        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?

        // Honestly, I think I did not get the problem correctly
        // What does it mean "Together they make 70% of their 3 point shots"?
        // Is 70% their success rate / percentage of good shots?
        int opponentScore = 31;
        int requiredScore = opponentScore + 1;
        int pointsPerShot = 3;
        double successRate = 0.7;

        double averagePointsPerShot = pointsPerShot * successRate;
        int requiredShots = (int) Math.ceil(requiredScore / averagePointsPerShot);

        System.out.println("18.");
        System.out.println("Pete and Pat need to take at least " + requiredShots + " shots to win the game given that their success rate is 70% and their opponent scored 31 points");
        System.out.println();


    }

    public static void clairesCookies() {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();


        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)

        int studentsTotal = 14;
        int cookiesPerDozen = 12;
        int dozenTotal = 3;

        int cookiesTotal = cookiesPerDozen * dozenTotal;
        int cookiesPerStudent = cookiesTotal / studentsTotal;

        System.out.println("19.");
        System.out.println("Total student in class: " + studentsTotal);
        System.out.println("Total number of cookies: " + cookiesTotal);
        System.out.println("Each student will receive: " + cookiesPerStudent);
        System.out.println();


        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?
        int remainder = cookiesTotal % studentsTotal;

        System.out.println("20.");
        System.out.println("Total student in class: " + studentsTotal);
        System.out.println("Total number of cookies: " + cookiesTotal);
        System.out.println("Each student will receive: " + cookiesPerStudent);
        System.out.println("Number of cookies will be left over: " + remainder);
        System.out.println();


        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.

        cookiesPerStudent = 3;
        cookiesTotal = studentsTotal * cookiesPerStudent;
        dozenTotal = (int) Math.ceil((double) cookiesTotal / cookiesPerDozen);

        System.out.println("21.");
        System.out.println("Total student in class: " + studentsTotal);
        System.out.println("Each student will receive: " + cookiesPerStudent);
        System.out.println("Total number of cookies needed: " + cookiesTotal);
        System.out.println("Number of dozen cookies to buy: " + dozenTotal);
        System.out.println();


        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy.
        int cookiesFor100 = 4;
        int cookiesFor90 = 3;
        int cookiesForRest = 2;
        int studentsGot100 = 2;
        int studentsGot90 = 4;

        int restStudents = studentsTotal - studentsGot100 - studentsGot90;
        cookiesTotal = studentsGot100 * cookiesFor100 + studentsGot90 * cookiesFor90 + restStudents * cookiesForRest;
        dozenTotal = (int) Math.ceil((double) cookiesTotal / cookiesPerDozen);

        System.out.println("22.");
        System.out.println("Total student in class: " + studentsTotal);
        System.out.println("Number of students got 100: " + studentsGot100);
        System.out.println("Number of students got 90+: " + studentsGot90);
        System.out.println("Total number of cookies needed: " + cookiesTotal);
        System.out.println("Number of dozen cookies to buy: " + dozenTotal);
        System.out.println();


        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.
        double pricePerDozen = 12.99;
        dozenTotal = 4;
        double totalCost = pricePerDozen * dozenTotal;

        System.out.println("23.");
        System.out.println("Price for dozen cookies: $" + pricePerDozen);
        System.out.println("Number of dozen cookies bought: " + dozenTotal);
        System.out.println("Total cost: $" + totalCost);
        System.out.println();


        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?
        double snickerDoodlesPrice = 12.99;
        double chocolateChipPrice = 13.99;
        double frostedChocolateChipPrice = 15.99;

        int snickerDoodlesCookies = 9;
        int chocolateChipCookies = 15;
        int frostedChocolateChipCookies = 18;

        int snickerDoodlesDozen = (int) Math.ceil((double) snickerDoodlesCookies / cookiesPerDozen);
        int chocolateChipDozen = (int) Math.ceil((double) chocolateChipCookies / cookiesPerDozen);
        int frostedChocolateChipDozen = (int) Math.ceil((double) frostedChocolateChipCookies / cookiesPerDozen);

        dozenTotal = snickerDoodlesDozen + chocolateChipDozen + frostedChocolateChipDozen;

        System.out.println("24.");
        System.out.println("Cookies student selected:");
        System.out.println("Snicker Doodles: " + snickerDoodlesCookies);
        System.out.println("Chocolate Chip: " + chocolateChipCookies);
        System.out.println("Frosted Chocolate Chip: " + frostedChocolateChipCookies);
        System.out.println();
        System.out.println("Sean needs to buy:");
        System.out.println("Snicker Doodles: " + snickerDoodlesDozen + "dz");
        System.out.println("Chocolate Chip: " + chocolateChipDozen + "dz");
        System.out.println("Frosted Chocolate Chip: " + frostedChocolateChipDozen + "dz");
        System.out.println("Total dozen cookies Sean needs to buy: " + dozenTotal);
        System.out.println();


        // 25. What is the total cost of this order?
        totalCost = snickerDoodlesDozen * snickerDoodlesPrice +
                chocolateChipDozen * chocolateChipPrice +
                frostedChocolateChipDozen * frostedChocolateChipPrice;

        System.out.println("25.");
        System.out.println("Total cost of the order above: $" + totalCost);
        System.out.println();


        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)
        int snickerDoodlesCookiesRemainder = snickerDoodlesDozen * cookiesPerDozen - snickerDoodlesCookies;
        int chocolateChipCookiesRemainder = chocolateChipDozen * cookiesPerDozen - chocolateChipCookies;
        int frostedChocolateChipCookiesRemainder = frostedChocolateChipDozen * cookiesPerDozen - frostedChocolateChipCookies;

        System.out.println("26.");
        System.out.println("Cookies will be left:");
        System.out.println("Snicker Doodles: " + snickerDoodlesCookiesRemainder);
        System.out.println("Chocolate Chip: " + chocolateChipCookiesRemainder);
        System.out.println("Frosted Chocolate Chip: " + frostedChocolateChipCookiesRemainder);
        System.out.println();


        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle
        int frostedChocolateChipDozen2 = 2;
        int chocolateChipDozen2 = 1;
        int snickerDoodlesDozen2 = 1;

        double savedMoney = (frostedChocolateChipDozen - frostedChocolateChipDozen2) * frostedChocolateChipPrice +
                (chocolateChipDozen - chocolateChipDozen2) * chocolateChipPrice +
                (snickerDoodlesDozen - snickerDoodlesDozen2) * snickerDoodlesPrice;

        System.out.println("27.");
        System.out.println("If Sean would have bought: ");
        System.out.println("   " + frostedChocolateChipDozen2 + "dz Frosted Chocolate Chip");
        System.out.println("   " + chocolateChipDozen2 + "dz Chocolate Chip");
        System.out.println("   " + snickerDoodlesDozen2 + "dz Snicker Doodle");
        System.out.println("He could save: $" + savedMoney);
    }


    // bonus - challenge
    public static void elliotsYardCare() {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.

        int unitSize = 100 * 50;
        double unitPrice = 30.00;
        double cost1000 = 2.5;
        double goalEarningRate = 10.0;
        double time1000 = 45;


        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?
        double unitCost = cost1000 / 1000 * unitSize;

        System.out.println("28");
        System.out.println("Total cost to Elliot when he mows a yard that is 100 x 50 feet: $" + unitCost);
        System.out.println();


        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?
        double unitMoneyEarn = unitPrice - unitCost;

        System.out.println("29");
        System.out.println("Money Elliot earns to maintain a 100 x 50 ft yard: $" + unitMoneyEarn);
        System.out.println();


        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?
        double unitTime = time1000 / 1000 * unitSize;
        int hours = (int) Math.floor(unitTime / 60);
        int minutes = (int) unitTime - hours * 60;

        System.out.println("30");
        System.out.println("Time it takes Elliot to mow a 100 x 50 ft yard: " + (int) unitTime + " minutes = " +
                hours + " hours and " + minutes + " minutes");
        System.out.println();


        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?

        double earningRate = unitMoneyEarn / unitTime * 60;

        System.out.println("31");
        System.out.println("Money Elliot earns per hour on a 100 x 50 ft yard: $" + earningRate);
        System.out.println();


        // 32. What is Elliot's cost per hour on a medium
        // sized yard?

        double spendingRate = unitCost / unitTime * 60;

        System.out.println("32");
        System.out.println("Elliot's cost per hour on a 100 x 50 ft yard: $" + spendingRate);
        System.out.println();


        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?

        double goalUnitPrice = unitPrice * goalEarningRate / earningRate;
        goalUnitPrice = Math.ceil(goalUnitPrice * 100) / 100;
        
        System.out.println("33");
        System.out.println("Elliot should charge for a medium yard $" + goalUnitPrice + " in order to earn " +
                goalEarningRate + " per hour") ;
        System.out.println();


    }
}