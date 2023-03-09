public class Main {
    public static void main(String[] args) {
        // Maak enkele spelers
        Speler speler1 = new Speler("Frodo");
        Speler speler2 = new Speler("Aragorn");
        // Maak enkele vijanden
        Vijand vijand1 = new Vijand("Ork", 5);
        Vijand vijand2 = new Vijand("Sauron", 8);
        // Maak enkele levels
        Level level1 = new Level("Hobbiton", 1, 10);
        Level level2 = new Level("Mordor", 2, 15);
        // Maak enkele wapens
        Wapen wapen1 = new Wapen("Zwaard", 8);
        Wapen wapen2 = new Wapen("Boog", 5);
        // Maak het Game-object en voeg alle elementen toe
        Game game = new Game();
        game.addSpeler(speler1);
        game.addSpeler(speler2);
        game.addVijand(vijand1);
        game.addVijand(vijand2);
        game.addLevel(level1);
        game.addLevel(level2);
        game.addWapen(wapen1);
        game.addWapen(wapen2);
        // Laat de eerste speler level 1 spelen
        Speler huidigeSpeler = speler1;
        Level huidigLevel = level1;
        ArrayList<Wapen> huidigeWapens = new ArrayList<Wapen>();
        huidigeWapens.add(wapen1);
        for (Vijand vijand : game.getVijanden()) {
            System.out.println("Speler "
                    + huidigeSpeler.getNaam() +
                    " valt "
                    +
                    vijand.getNaam() +
                    " aan met "
                    +
                    huidigeWapens.get(0).getNaam() +
                    ".");
            vijand.setLevens(vijand.getLevens() - huidigeWapens.get(0).getAanvalskracht());
            if (vijand.getLevens() <= 0) {
                System.out.println("Vijand "
                        + vijand.getNaam() +
                        " is verslagen door speler "
                        +
                        huidigeSpeler.getNaam() +
                        ".");
                huidigeSpeler.addScore(huidigLevel.getScorePerVijand());
            }
        }
        System.out.println("Score van "
                + huidigeSpeler.getNaam() +
                ": "
                + huidigeSpeler.getScore());
    }
}