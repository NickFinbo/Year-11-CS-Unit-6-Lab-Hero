public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent) {
        double prob = Math.random();

        if(prob < 0.5) {
            opponent.setHitPoints(opponent.getHitPoints() - 10);
        } else {
            hitPoints -= 10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    public void fightUntilTheDeathHelper(Hero opponent) {

        while(hitPoints > 0 && opponent.getHitPoints() > 0) {
                double number = Math.random();

                if(number > 0.5) {
                    opponent.setHitPoints(opponent.getHitPoints() - 10);
                } else {
                    hitPoints -= 10;
                }
            }
        }


    public String fightUntilTheDeath(Hero opponent) {
        hitPoints = 100;
        opponent.senzuBean();

        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + " " + opponent.getName() + ": " + opponent.getHitPoints();
    }

    public int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int opponentW = 0;
        int heroW = 0;
        int[] result = new int[2];

        for(int i = 0; i < n; i++) {
            fightUntilTheDeathHelper(opponent);

            if(opponent.getHitPoints() <= 0) {
                heroW++;
            } else {
                opponentW++;
            }

            opponent.senzuBean();
            hitPoints = 100;
        }

        result[0] = opponentW;
        result[1] = heroW;

        return result;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] result = nFightsToTheDeathHelper(opponent, n);
        String opponentScore = opponent.getName() + ": " + result[0] + " wins";
        String heroScore = name + ": " + result[1] + " wins";
        String message;

        if(result[0] > result[1]) {
            message = opponent.getName() + " wins!";;
        } else if (result[0] < result[1]) {
            message = name + " wins!";
        } else {
            message = "OMG! It was actually a draw!";
        }
        return opponentScore + " " + heroScore + " " + message;
    }
}