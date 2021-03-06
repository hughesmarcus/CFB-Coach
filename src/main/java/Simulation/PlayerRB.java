package Simulation;

import java.util.ArrayList;

/**
 * Class for the RB player.
 *
 * @author Achi
 */
public class PlayerRB extends Player {

    //RushPow affects how consistenly he can get past line of scrimmage
    public int ratRushPower;
    //RushSpd affects how long he can run
    public int ratSpeed;
    //RushEva affects how easily he can dodge tackles
    public int ratEvasion;
    public int ratCatch;

    //public Vector ratingsVector;

    //Stats
    public int statsRushAtt;
    public int statsRushYards;
    public int statsRushTD;
    public int statsFumbles;

    public int careerRushAtt;
    public int careerRushYards;
    public int careerTDs;
    public int careerFumbles;

    public int statsReceptions;
    public int statsRecYards;
    public int statsRecTD;

    public int careerReceptions;
    public int careerRecYards;
    public int careerRecTD;


    public PlayerRB(String nm, Team t, int yr, int pot, int iq, int pow, int spd, int eva, boolean rs, int dur, int cat, int reg, int trait) {
        team = t;
        name = nm;
        year = yr;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratOvr = (pow + spd + eva) / 3;
        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratRushPower = pow;
        ratSpeed = spd;
        ratEvasion = eva;
        ratCatch = cat;
        isRedshirt = rs;
        if (isRedshirt) year = 0;
        region = reg;
        personality = trait;

        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        statsReceptions = 0;
        statsRecYards = 0;
        statsRecTD = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerRushAtt = 0;
        careerRushYards = 0;
        careerTDs = 0;
        careerFumbles = 0;
        careerReceptions = 0;
        careerRecYards = 0;
        careerRecTD = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerWins = 0;

        position = "RB";
    }

    public PlayerRB(String nm, Team t, int yr, int pot, int iq, int pow, int spd, int eva, boolean rs, int dur, int cat,
                    int cGamesPlayed, int cRushAtt, int cRushYards, int cTDs, int cFumbles, int cRec, int cRecYards, int cRecTD,
                    int cHeismans, int cAA, int cAC, int cWins, boolean transfer, int reg, int trait) {
        team = t;
        name = nm;
        year = yr;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratOvr = (pow + spd + eva) / 3;
        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratRushPower = pow;
        ratSpeed = spd;
        ratEvasion = eva;
        ratCatch = cat;
        isRedshirt = rs;
        if (isRedshirt) year = 0;
        isTransfer = transfer;
        region = reg;
        personality = trait;

        troubledTimes = 0;

        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        statsReceptions = 0;
        statsRecYards = 0;
        statsRecTD = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerRushAtt = cRushAtt;
        careerRushYards = cRushYards;
        careerTDs = cTDs;
        careerFumbles = cFumbles;
        careerReceptions = cRec;
        careerRecYards = cRecYards;
        careerRecTD = cRecTD;
        careerGames = cGamesPlayed;
        careerHeismans = cHeismans;
        careerAllAmerican = cAA;
        careerAllConference = cAC;
        careerWins = cWins;

        position = "RB";
    }

    public PlayerRB(String nm, int yr, int stars, Team t) {
        name = nm;
        year = yr;
        team = t;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratPot = (int) (attrBase + 50 * Math.random());
        ratFootIQ = (int) (attrBase + 50 * Math.random());
        ratDur = (int) (attrBase + 50 * Math.random());
        ratRushPower = (int) (ratBase + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratSpeed = (int) (ratBase + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratEvasion = (int) (ratBase + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratCatch = (int) ((ratBase-15) + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratOvr = (ratRushPower + ratSpeed + ratEvasion) / 3;
        region = (int)(Math.random()*5);
        personality = (int) (attrBase + 50 * Math.random());

        //cost = (int) (Math.pow((float) ratOvr - 55, 2) / 2) + 70 + (int) (Math.random() * 100) - 50;

        recruitTolerance = (int)((60 - team.teamPrestige)/rbImportance);
        cost = (int)((Math.pow((float) ratOvr - costBaseRating, 2)/5) + (int)Math.random()*recruitTolerance);

        cost = (int)(cost/rbImportance);

        double locFactor = Math.abs(team.location - region) - 2.5;
        cost = cost + (int)(Math.random()*(locFactor * locationDiscount));
        if (cost < 0) cost = (int)Math.random()*7+1;

        troubledTimes = 0;

        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        statsReceptions = 0;
        statsRecYards = 0;
        statsRecTD = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerRushAtt = 0;
        careerRushYards = 0;
        careerTDs = 0;
        careerFumbles = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerWins = 0;

        position = "RB";
    }

    public PlayerRB(String nm, int yr, int stars, Team t, boolean custom) {
        name = nm;
        year = yr;
        team = t;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratPot = (int) (attrBase + 50 * Math.random());
        ratFootIQ = (int) (attrBase + 50 * Math.random());
        ratDur = (int) (attrBase + 50 * Math.random());
        ratRushPower = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratSpeed = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratEvasion = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratCatch = (int) ((ratBase-15) + stars * customFactor - ratTolerance * Math.random());
        ratOvr = (ratRushPower + ratSpeed + ratEvasion) / 3;
        region = (int)(Math.random()*5);
        personality = (int) (attrBase + 50 * Math.random());

        troubledTimes = 0;

        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        statsReceptions = 0;
        statsRecYards = 0;
        statsRecTD = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerRushAtt = 0;
        careerRushYards = 0;
        careerTDs = 0;
        careerFumbles = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerWins = 0;

        position = "RB";
    }

    @Override
    public void advanceSeason() {
        int oldOvr = ratOvr;
        progression = (ratPot * 3 + team.HC.get(0).ratTalent * 2 + team.HC.get(0).ratOff) / 6;
        int games = gamesStarted + (gamesPlayed-gamesStarted)/3;

        if (!isMedicalRS) {
            year++;
            if (wonAllConference) ratPot++;
            if (wonAllAmerican) ratPot++;
            if (year > 2 && games < 4) ratPot -= (int) (Math.random() * 15);

            ratFootIQ += (int) (Math.random() * (progression + games - 35)) / 10;
            ratRushPower += (int) (Math.random() * (progression + games - 35)) / 10;
            ratSpeed += (int) (Math.random() * (progression + games - 35)) / 10;
            ratEvasion += (int) (Math.random() * (progression + games - 35)) / 10;
            ratCatch += (int) (Math.random() * (progression + games - 30)) / 10;
            if (Math.random() * 100 < progression) {
                //breakthrough
                ratRushPower += (int) (Math.random() * (progression + games - 40)) / 10;
                ratSpeed += (int) (Math.random() * (progression + games - 40)) / 10;
                ratEvasion += (int) (Math.random() * (progression + games - 40)) / 10;
                ratCatch += (int) (Math.random() * (progression + games - 35)) / 10;
            }
        }
        ratOvr = (ratRushPower + ratSpeed + ratEvasion) / 3;
        ratImprovement = ratOvr - oldOvr;
        //reset stats (keep career stats?)
        careerRushAtt += statsRushAtt;
        careerRushYards += statsRushYards;
        careerTDs += statsRushTD;
        careerFumbles += statsFumbles;
        careerReceptions += statsReceptions;
        careerRecYards += statsRecYards;
        careerRecTD += statsRecTD;
        careerGames += gamesPlayed;
        careerWins += statsWins;

        if (wonHeisman) careerHeismans++;
        if (wonAllAmerican) careerAllAmerican++;
        if (wonAllConference) careerAllConference++;

        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;
        statsReceptions = 0;
        statsRecYards = 0;
        statsRecTD = 0;

        if (isTransfer) {
            isTransfer = false;
            year -= 1;
        }

    }

    @Override
    public int getHeismanScore() {
        return statsRushTD * 140 - statsFumbles * 100 + statsRushYards * 3 + statsRecYards + statsRecTD * 140 + team.confPrestige * 7;
    }

    @Override
    public ArrayList<String> getDetailStatsList(int games) {
        ArrayList<String> pStats = new ArrayList<>();
        pStats.add("Rush TDs: " + statsRushTD + ">Fumbles: " + statsFumbles);
        pStats.add("Rush Yards: " + statsRushYards + " yds>Yards/Att: " + ((double) (10 * statsRushYards / (statsRushAtt + 1)) / 10) + " yds");
        pStats.add("Yds/Game: " + (statsRushYards / getGames()) + " yds/g>Rush Att: " + statsRushAtt);
        pStats.add("Rec Yards: " + statsRecYards + " yds>Receptions: " + statsReceptions + " ");
        pStats.add("Rec TDs: " + statsRecTD + ">Games: " + gamesPlayed + " (" + statsWins + "-" + (gamesStarted - statsWins) + ")");
        pStats.add("Home Region: " + getRegion(region) + ">Personality: " + getLetterGrade(personality));
        pStats.add("Durability: " + getLetterGrade(ratDur) + ">Football IQ: " + getLetterGrade(ratFootIQ));
        pStats.add("Rush Speed: " + getLetterGrade(ratSpeed) + ">Rush Power: " + getLetterGrade(ratRushPower));
        pStats.add("Catching: " + getLetterGrade(ratCatch) + ">Evasion: " + getLetterGrade(ratEvasion));
        pStats.add(" > ");
        return pStats;
    }

    @Override
    public ArrayList<String> getDetailAllStatsList(int games) {
        ArrayList<String> pStats = new ArrayList<>();
        pStats.add("TDs: " + statsRushTD + ">Fumbles: " + statsFumbles);
        pStats.add("Rush Yards: " + statsRushYards + " yds>Yards/Att: " + ((double) (10 * statsRushYards / (statsRushAtt + 1)) / 10) + " yds");
        pStats.add("Yds/Game: " + (statsRushYards / getGames()) + " yds/g>Rush Att: " + statsRushAtt);
        pStats.add("Rec Yards: " + statsRecYards + " yds>Receptions: " + statsReceptions + " ");
        pStats.add("Rec TDs: " + statsRecTD + ">Games: " + gamesPlayed + " (" + statsWins + "-" + (gamesStarted - statsWins) + ")");
        pStats.add("Home Region: " + getRegion(region) + ">Personality: " + personality);
        pStats.add("Durability: " + ratDur + ">Football IQ: " + ratFootIQ);
        pStats.add("Rush Speed: " + ratSpeed + ">Rush Power: " + ratRushPower);
        pStats.add("Catching: " + ratCatch + ">Evasion: " + ratEvasion);
        pStats.add("[B]CAREER STATS:");
        pStats.addAll(getCareerStatsList());
        return pStats;
    }

    @Override
    public ArrayList<String> getCareerStatsList() {
        ArrayList<String> pStats = new ArrayList<>();
        pStats.add("TDs: " + (statsRushTD + careerTDs) + ">Fumbles: " + (statsFumbles + careerFumbles));
        pStats.add("Rush Yards: " + (statsRushYards + careerRushYards) + " yds>Yards/Att: " + ((double) (10 * (statsRushYards + careerRushYards) / (statsRushAtt + careerRushAtt + 1)) / 10) + " yds");
        pStats.add("Yds/Game: " + ((statsRushYards + careerRushYards) / (getGames() + careerGames)) + " yds/g>Rush Att: " + (statsRushAtt + careerRushAtt));
        pStats.add("Rec Yards: " + (statsRecYards + careerRecYards) + " yds>Receptions: " + (statsReceptions + careerReceptions) + " ");
        pStats.add("Rec TDs: " + (statsRecTD + careerRecTD) + "> ");
        pStats.addAll(super.getCareerStatsList());
        return pStats;
    }

    @Override
    public String getInfoForLineup() {
        if (injury != null)
            return getInitialName() + " [" + getYrStr() + "] " + ratOvr + "/" + getLetterGrade(ratPot) + " " + injury.toString();
        return getInitialName() + " [" + getYrStr() + "] " + ratOvr + "/" + getLetterGrade(ratPot) + " (" +
                getLetterGrade(ratRushPower) + ", " + getLetterGrade(ratSpeed) + ", " + getLetterGrade(ratEvasion) + ", " + getLetterGrade(ratCatch) + ")";
    }

}
