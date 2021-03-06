package Simulation;

import java.util.ArrayList;

/**
 * Class for QB player.
 *
 * @author Achi
 */
public class PlayerQB extends Player {

    //PassPow affects how far he can throw
    public int ratPassPow;
    //PassAcc affects how accurate his passes are
    public int ratPassAcc;
    //PassEva (evasiveness) affects how easily he can dodge sacks
    public int ratEvasion;
    public int ratSpeed;

    //Stats
    public int statsPassAtt;
    public int statsPassComp;
    public int statsPassTD;
    public int statsInt;
    public int statsPassYards;
    public int statsSacked;
    public int statsRushAtt;
    public int statsRushYards;
    public int statsRushTD;
    public int statsFumbles;

    public int careerPassAtt;
    public int careerPassComp;
    public int careerTDs;
    public int careerInt;
    public int careerPassYards;
    public int careerSacked;
    public int careerRushAtt;
    public int careerRushYards;
    public int careerRushTD;
    public int careerFumbles;

    public PlayerQB(String nm, Team t, int yr, int pot, int iq, int pow, int acc, int eva, boolean rs, int dur, int spd, int reg, int trait) {
        team = t;
        name = nm;
        year = yr;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratOvr = (pow * 3 + acc * 4 + eva + spd) / 9;
        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratPassPow = pow;
        ratPassAcc = acc;
        ratEvasion = eva;
        ratSpeed = spd;
        isRedshirt = rs;
        if (isRedshirt) year = 0;
        region = reg;
        personality = trait;
        troubledTimes = 0;

        statsPassAtt = 0;
        statsPassComp = 0;
        statsPassTD = 0;
        statsInt = 0;
        statsPassYards = 0;
        statsSacked = 0;
        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;
        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerPassAtt = 0;
        careerPassComp = 0;
        careerTDs = 0;
        careerInt = 0;
        careerPassYards = 0;
        careerSacked = 0;
        careerRushAtt = 0;
        careerRushYards = 0;
        careerRushTD = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerWins = 0;

        position = "QB";
    }

    public PlayerQB(String nm, Team t, int yr, int pot, int iq, int pow, int acc, int eva, boolean rs, int dur, int spd,
                    int cGamesPlayed, int cPassAtt, int cPassComp, int cTDs, int cInt, int cPassYards, int cSacked,
                    int cRushAtt, int cRushYards, int cRushTD, int cFumbles, int cHeismans, int cAA, int cAC, int cWins, boolean transfer, int reg, int trait) {
        team = t;
        name = nm;
        year = yr;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratOvr = (pow * 3 + acc * 4 + eva + spd) / 9;
        ratPot = pot;
        ratFootIQ = iq;
        ratDur = dur;
        ratPassPow = pow;
        ratPassAcc = acc;
        ratEvasion = eva;
        ratSpeed = spd;
        isRedshirt = rs;
        if (isRedshirt) year = 0;
        isTransfer = transfer;
        region = reg;
        personality = trait;
        troubledTimes = 0;

        statsPassAtt = 0;
        statsPassComp = 0;
        statsPassTD = 0;
        statsInt = 0;
        statsPassYards = 0;
        statsSacked = 0;
        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerPassAtt = cPassAtt;
        careerPassComp = cPassComp;
        careerTDs = cTDs;
        careerInt = cInt;
        careerPassYards = cPassYards;
        careerSacked = cSacked;
        careerRushAtt = cRushAtt;
        careerRushYards = cRushYards;
        careerRushTD = cRushTD;
        careerFumbles = cFumbles;

        careerGames = cGamesPlayed;
        careerHeismans = cHeismans;
        careerAllAmerican = cAA;
        careerAllConference = cAC;
        careerWins = cWins;

        position = "QB";
    }

    public PlayerQB(String nm, int yr, int stars, Team t) {
        name = nm;
        year = yr;
        team = t;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratPot = (int) (attrBase + 50 * Math.random());
        ratFootIQ = (int) (attrBase + 50 * Math.random());
        ratDur = (int) (attrBase + 50 * Math.random());
        ratPassPow = (int) (ratBase + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratPassAcc = (int) (ratBase + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratEvasion = (int) (ratBase + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratSpeed = (int) ((ratBase-15) + year*yearFactor + stars*starFactor - ratTolerance*Math.random());
        ratOvr = (ratPassPow * 3 + ratPassAcc * 4 + ratEvasion + ratSpeed) / 9;
        region = (int)(Math.random()*5);
        personality = (int) (attrBase + 50 * Math.random());
        //cost = (int) (Math.pow((float) ratOvr - 55, 2) / 1.5) + 150 + (int) (Math.random() * 100) - 50;

        recruitTolerance = (int)((60 - team.teamPrestige)/qbImportance);
        cost = (int)((Math.pow((float) ratOvr - costBaseRating, 2)/5) + (int)Math.random()*recruitTolerance);

        cost = (int)(cost/qbImportance);

        double locFactor = Math.abs(team.location - region) - 2.5;
        cost = cost + (int)(Math.random()*(locFactor * locationDiscount));

        if (cost < 0) cost = (int)Math.random()*7+1;

        troubledTimes = 0;

        statsPassAtt = 0;
        statsPassComp = 0;
        statsPassTD = 0;
        statsInt = 0;
        statsPassYards = 0;
        statsSacked = 0;
        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerPassAtt = 0;
        careerPassComp = 0;
        careerTDs = 0;
        careerInt = 0;
        careerPassYards = 0;
        careerSacked = 0;
        careerRushAtt = 0;
        careerRushYards = 0;
        careerRushTD = 0;
        careerFumbles = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerWins = 0;

        position = "QB";
    }

    public PlayerQB(String nm, int yr, int stars, Team t, Boolean custom) {
        name = nm;
        year = yr;
        team = t;
        gamesStarted = 0;
        gamesPlayed = 0;
        isInjured = false;
        ratPot = (int) (attrBase + 50 * Math.random());
        ratFootIQ = (int) (attrBase + 50 * Math.random());
        ratDur = (int) (attrBase + 50 * Math.random());
        ratPassPow = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratPassAcc = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratEvasion = (int) (ratBase + stars * customFactor - ratTolerance * Math.random());
        ratSpeed = (int) ((ratBase-10)  + stars * customFactor - ratTolerance * Math.random());
        ratOvr = (ratPassPow * 3 + ratPassAcc * 4 + ratEvasion + ratSpeed) / 9;
        region = (int)(Math.random()*5);
        personality = (int) (attrBase + 50 * Math.random());

        troubledTimes = 0;

        statsPassAtt = 0;
        statsPassComp = 0;
        statsPassTD = 0;
        statsInt = 0;
        statsPassYards = 0;
        statsSacked = 0;
        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        wonHeisman = false;
        wonAllAmerican = false;
        wonAllConference = false;
        statsWins = 0;

        careerPassAtt = 0;
        careerPassComp = 0;
        careerTDs = 0;
        careerInt = 0;
        careerPassYards = 0;
        careerSacked = 0;
        careerRushAtt = 0;
        careerRushYards = 0;
        careerRushTD = 0;
        careerFumbles = 0;
        careerGames = 0;
        careerHeismans = 0;
        careerAllAmerican = 0;
        careerAllConference = 0;
        careerWins = 0;

        position = "QB";
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
            ratPassPow += (int) (Math.random() * (progression + games - 35)) / 10;
            ratPassAcc += (int) (Math.random() * (progression + games - 35)) / 10;
            ratEvasion += (int) (Math.random() * (progression + games - 35)) / 10;
            ratSpeed += (int) (Math.random() * (progression + games - 20)) / 10;

            if (Math.random() * 100 < progression) {
                //breakthrough
                ratPassPow += (int) (Math.random() * (progression + games - 40)) / 10;
                ratPassAcc += (int) (Math.random() * (progression + games - 40)) / 10;
                ratEvasion += (int) (Math.random() * (progression + games - 40)) / 10;
                ratSpeed += (int) (Math.random() * (progression + games - 25)) / 10;
            }
        }

        ratOvr = (ratPassPow * 3 + ratPassAcc * 4 + ratEvasion + ratSpeed) / 9;
        ratImprovement = ratOvr - oldOvr;
        //reset stats (keep career stats?)
        careerPassAtt += statsPassAtt;
        careerPassComp += statsPassComp;
        careerTDs += statsPassTD;
        careerInt += statsInt;
        careerPassYards += statsPassYards;
        careerSacked += statsSacked;
        careerRushAtt += statsRushAtt;
        careerRushYards += statsRushYards;
        careerRushTD += statsRushTD;
        careerFumbles += statsFumbles;
        careerGames += gamesPlayed;
        careerWins += statsWins;

        if (wonHeisman) careerHeismans++;
        if (wonAllAmerican) careerAllAmerican++;
        if (wonAllConference) careerAllConference++;

        statsPassAtt = 0;
        statsPassComp = 0;
        statsPassTD = 0;
        statsInt = 0;
        statsPassYards = 0;
        statsSacked = 0;
        statsRushAtt = 0;
        statsRushYards = 0;
        statsRushTD = 0;
        statsFumbles = 0;

        if (isTransfer) {
            isTransfer = false;
            year -= 1;
        }
    }

    @Override
    public int getHeismanScore() {
        return statsPassTD * 150 - statsInt * 300 + statsPassYards + statsRushTD * 150 + statsRushYards + team.confPrestige * 7;
    }

    public int getPasserRating() {
        if (statsPassAtt < 1) {
            return 0;
        } else {
            int rating = (int) (((8.4 * statsPassYards) + (300 * statsPassTD) + (100 * statsPassComp) - (200 * statsInt)) / statsPassAtt);
            return rating;
        }
    }

    public int getPassPCT() {
        if (statsPassAtt < 1) {
            return 0;
        } else {
            int rating = 100 * statsPassComp / (statsPassAtt);
            return rating;
        }
    }

    public int getCareerPassPCT() {
        if (statsPassAtt < 1) {
            return 0;
        } else {
            int rating = (100 * (statsPassComp + careerPassComp) / (statsPassAtt + careerPassAtt));
            return rating;
        }
    }

    public int getCareerPasserRating() {
        if (statsPassAtt < 1) {
            return 0;
        } else {
            int rating = (int) (((8.4 * (statsPassYards + careerPassYards)) + (300 * (statsPassTD + careerTDs)) + (100 * (statsPassComp + careerPassComp)) - (200 * (statsInt + careerInt))) / (statsPassAtt + careerPassAtt));
            return rating;
        }
    }


    @Override
    public ArrayList<String> getDetailStatsList(int games) {
        ArrayList<String> pStats = new ArrayList<>();
        pStats.add("Passer Rating " + getPasserRating() + ">Comp Percent: " + (100 * statsPassComp / (statsPassAtt + 1)) + "%");
        pStats.add("Touchdowns: " + statsPassTD + ">Interceptions: " + statsInt);
        pStats.add("Pass Yards: " + statsPassYards + " yds>Yards/Att: " + ((double) (10 * statsPassYards / (statsPassAtt + 1)) / 10) + " yds");
        pStats.add("Yds/Game: " + (statsPassYards / getGames()) + " yds/g>Sacks: " + statsSacked);
        pStats.add("Rush Yards: " + (statsRushYards) + ">Rush TDs: " + statsRushTD);
        pStats.add("Fumbles: " + statsFumbles + "> Games: " + gamesPlayed + " (" + statsWins + "-" + (gamesStarted - statsWins) + ")");
        pStats.add("Home Region: " + getRegion(region) + ">Personality: " + getLetterGrade(personality));
        pStats.add("Durability: " + getLetterGrade(ratDur) + ">Football IQ: " + getLetterGrade(ratFootIQ));
        pStats.add("Pass Strength: " + getLetterGrade(ratPassPow) + ">Accuracy: " + getLetterGrade(ratPassAcc));
        pStats.add("Speed: " + getLetterGrade(ratSpeed) + ">Evasion: " + getLetterGrade(ratEvasion));
        pStats.add(" > ");
        return pStats;
    }

    @Override
    public ArrayList<String> getDetailAllStatsList(int games) {
        ArrayList<String> pStats = new ArrayList<>();
        pStats.add("Passer Rating " + getPasserRating() + ">Comp Percent: " + (100 * statsPassComp / (statsPassAtt + 1)) + "%");
        pStats.add("Touchdowns: " + statsPassTD + ">Interceptions: " + statsInt);
        pStats.add("Yds/Game: " + (statsPassYards / getGames()) + " yds/g>Sacks: " + statsSacked);
        pStats.add("Rush Yards: " + (statsRushYards) + ">Rush TDs: " + statsRushTD);
        pStats.add("Fumbles: " + statsFumbles + "> Games: " + gamesPlayed + " (" + statsWins + "-" + (gamesStarted - statsWins) + ")");
        pStats.add("Home Region: " + getRegion(region) + ">Personality: " + personality);
        pStats.add("Durability: " + ratDur + ">Football IQ: " + ratFootIQ);
        pStats.add("Pass Strength: " + ratPassPow + ">Accuracy: " + ratPassAcc);
        pStats.add("Speed: " + ratSpeed + ">Evasion: " + ratEvasion);
        pStats.add("[B]CAREER STATS:");
        pStats.addAll(getCareerStatsList());
        return pStats;
    }

    @Override
    public ArrayList<String> getCareerStatsList() {
        ArrayList<String> pStats = new ArrayList<>();
        pStats.add("Passer Rating " + (int) (((8.4 * (statsPassYards + careerPassYards)) + (300 * (statsPassTD + careerTDs)) + (100 * (statsPassComp + careerPassComp)) - (200 * (statsInt + careerInt))) / (statsPassAtt + careerPassAtt + 1)) + ">Comp Percent: " + (100 * (statsPassComp + careerPassComp) / (statsPassAtt + careerPassAtt+ 1)) + "%");
        pStats.add("Touchdowns: " + (statsPassTD + careerTDs) + ">Interceptions: " + (statsInt + careerInt));
        pStats.add("Pass Yards: " + (statsPassYards + careerPassYards) + " yds>Yards/Att: " + ((double) (10 * (statsPassYards + careerPassYards) / (statsPassAtt + careerPassAtt + 1)) / 10) + " yds");
        pStats.add("Yds/Game: " + ((statsPassYards + careerPassYards) / (getGames() + careerGames)) + " yds/g>Sacks: " + (statsSacked + careerSacked));
        pStats.add("Rush Yards: " + (statsRushYards + careerRushYards) + ">Rush TDs: " + (statsRushTD + careerRushTD));
        pStats.addAll(super.getCareerStatsList());
        return pStats;
    }

    @Override
    public String getInfoForLineup() {
        if (injury != null)
            return getInitialName() + " [" + getYrStr() + "] " + ratOvr + "/" + getLetterGrade(ratPot) + " " + injury.toString();
        return getInitialName() + " [" + getYrStr() + "] " + ratOvr + "/" + getLetterGrade(ratPot) + " (" +
                getLetterGrade(ratPassPow) + ", " + getLetterGrade(ratPassAcc) + ", " + getLetterGrade(ratEvasion) + ", " + getLetterGrade(ratSpeed) + ")";
    }

}
