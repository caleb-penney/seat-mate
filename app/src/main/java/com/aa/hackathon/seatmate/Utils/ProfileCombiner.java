package com.aa.hackathon.seatmate.Utils;

import java.util.HashMap;

/**
 * Created by 522121 on 4/15/2016.
 */
public class ProfileCombiner
{
    private static ProfileCombiner thisCombiner;

    private static DetailedCompatabilityResults compatDetail = new DetailedCompatabilityResults();

    private static HashMap<String, Integer> seatToScoreMap = new HashMap<>();

    private static HashMap<String, ProfileHolder> seatToProfileMap = new HashMap<>();

    private static String[] columns = {"A", "B", "C", "D", "E", "F"};

    private static HashMap<String, Integer> columnToIndexMap = new HashMap<>();

    private static int[] weightArray = {5, 4, 3, 5, 4, 3, 5, 4};

    private static boolean[][] likesToTalk = {{true, true, false, false, false, false},
            {false, false, true, true, true, false},
            {true, true, true, false, true, false},
            {false, false, true, true, true, false},
            {true, true, true, false, true, false},
            {true, false, false, false, false, true},
            {false, false, true, true, true, true},
            {false, true, true, true, false, false},
            {false, true, true, true, false, true},
            {true, true, false, false, false, true}};

    private static boolean[][] doNotDisturb = {{true, true, false, false, false, false},
            {false, false, true, true, true, false},
            {true, true, true, false, true, false},
            {false, false, true, true, true, true},
            {false, true, true, true, false, false},
            {true, false, false, false, false, true},
            {false, false, true, true, true, false},
            {true, true, true, false, true, false},
            {true, false, false, false, false, true},
            {false, true, true, true, false, false}};

    private static boolean[][] likesSittingByKids = {{false, false, false, false, false, false},
            {false, true, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, true, false, false},
            {false, false, false, false, false, false},
            {true, false, false, false, false, false},
            {false, false, true, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false}};

    private static boolean[][] likesSittingByPets = {{false, true, false, false, false, false},
            {false, true, false, false, true, false},
            {false, false, false, false, false, false},
            {false, true, false, false, false, true},
            {false, false, false, true, false, false},
            {false, false, true, false, false, false},
            {true, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, true, false, false, false, false},
            {false, false, false, true, false, false}};

    private static ProfileHolder.Industry[][] industry = {{ProfileHolder.Industry.Advertising, ProfileHolder.Industry.Broadcasting, ProfileHolder.Industry.Media, ProfileHolder.Industry.Agriculture, ProfileHolder.Industry.Restaurant, ProfileHolder.Industry.Banking},
            {ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation, ProfileHolder.Industry.Broadcasting, ProfileHolder.Industry.Transportation, ProfileHolder.Industry.Advertising, ProfileHolder.Industry.RealEstate},
            {ProfileHolder.Industry.Restaurant, ProfileHolder.Industry.Automotive, ProfileHolder.Industry.VentureCapital, ProfileHolder.Industry.Trucking, ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation},
            {ProfileHolder.Industry.Advertising, ProfileHolder.Industry.Broadcasting, ProfileHolder.Industry.Media, ProfileHolder.Industry.Agriculture, ProfileHolder.Industry.Restaurant, ProfileHolder.Industry.Banking},
            {ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation, ProfileHolder.Industry.Broadcasting, ProfileHolder.Industry.Transportation, ProfileHolder.Industry.Advertising, ProfileHolder.Industry.RealEstate},
            {ProfileHolder.Industry.Restaurant, ProfileHolder.Industry.Automotive, ProfileHolder.Industry.VentureCapital, ProfileHolder.Industry.Trucking, ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation},
            {ProfileHolder.Industry.Advertising, ProfileHolder.Industry.Broadcasting, ProfileHolder.Industry.Media, ProfileHolder.Industry.Agriculture, ProfileHolder.Industry.Restaurant, ProfileHolder.Industry.Banking},
            {ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation, ProfileHolder.Industry.Broadcasting, ProfileHolder.Industry.Transportation, ProfileHolder.Industry.Advertising, ProfileHolder.Industry.RealEstate},
            {ProfileHolder.Industry.Restaurant, ProfileHolder.Industry.Automotive, ProfileHolder.Industry.VentureCapital, ProfileHolder.Industry.Trucking, ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation},
            {ProfileHolder.Industry.Aerospace, ProfileHolder.Industry.Building, ProfileHolder.Industry.Chemical, ProfileHolder.Industry.Trucking, ProfileHolder.Industry.Media, ProfileHolder.Industry.Transportation}};

    private static String[][] company = {{"IBM", "CISCO", "AMERICAN", "SWA", "HP", "SHELL"},
            {"SAMSUNG", "APPLE", "TEK", "FORD", "LEVI", "US STEEL"},
            {"NEC", "FUJITSU", "METALS4U", "CONTINENTAL", "GOODYEAR", "MMR"},
            {"CISCO", "BEBE", "BBK", "GE", "HILTON", "HERCULES"},
            {"IBM", "CISCO", "AMERICAN", "SWA", "HP", "SHELL"},
            {"SAMSUNG", "APPLE", "TEK", "FORD", "LEVI", "US STEEL"},
            {"NEC", "FUJITSU", "METALS4U", "CONTINENTAL", "GOODYEAR", "MMR"},
            {"CISCO", "BEBE", "BBK", "GE", "HILTON", "HERCULES"},
            {"NEC", "FUJITSU", "METALS4U", "CONTINENTAL", "GOODYEAR", "MMR"},
            {"CISCO", "BEBE", "BBK", "GE", "HILTON", "HERCULES"}};

    private static int[][] age = {{20, 25, 50, 40, 45, 55},
            {22, 33, 32, 53, 26, 53},
            {23, 43, 56, 42, 35, 33},
            {40, 33, 42, 32, 44, 43},
            {23, 43, 56, 42, 35, 33},
            {40, 33, 42, 32, 44, 43},
            {43, 46, 50, 53, 45, 33},
            {24, 27, 25, 28, 24, 24},
            {43, 46, 50, 53, 45, 33},
            {24, 27, 25, 28, 24, 24}};

    private static boolean[][] travelingWithPet = {{false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, true, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, true, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, true, false},
            {false, false, false, false, false, false}};


    private ProfileCombiner()
    {

    }

    public static ProfileCombiner getInstance()
    {
        if (thisCombiner == null)
        {
            thisCombiner = new ProfileCombiner();

            prepopulate();

        }

        return thisCombiner;
    }

    private static void prepopulate()
    {
        //Set up the index map
        int index = 0;

        for (String col : columns)
        {
            columnToIndexMap.put(col, index);

            index++;
        }

        //Populate them all first
        for (String s : columns)
        {
            int col = columnToIndexMap.get(s);

            for (int row = 0; row < 10; row++)
            {
                ProfileHolder holder = new ProfileHolder(likesToTalk[row][col],
                        doNotDisturb[row][col],
                        likesSittingByKids[row][col],
                        likesSittingByPets[row][col],
                        industry[row][col],
                        company[row][col],
                        age[row][col],
                        travelingWithPet[row][col],
                        weightArray[0],
                        weightArray[1],
                        weightArray[2],
                        weightArray[3],
                        weightArray[4],
                        weightArray[5],
                        weightArray[6],
                        weightArray[7]);

                seatToProfileMap.put(s + row, holder);
            }
        }
    }

    //Note column is true column name. Row is 0 based, not 1 based
    public static float getCombinedValue(String column, int row)
    {
        compatDetail = new DetailedCompatabilityResults();

        //Get base seat data
        ProfileHolder compareHolder = seatToProfileMap.get(column + row);

        if (column.equals("A"))
        {
            return handleA(row, compareHolder);
        }
        else if (column.equals("F"))
        {
            return handleF(row, compareHolder);
        }
        else
        {
            return handleOther(column, row, compareHolder);
        }
    }

    //Note column is true column name. Row is 0 based, not 1 based
    public static float getCombinedValue(ProfileHolder compareHolder, String column, int row)
    {
        compatDetail = new DetailedCompatabilityResults();

        if (column.equals("A"))
        {
            return handleA(row, compareHolder);
        }
        else if (column.equals("F"))
        {
            return handleF(row, compareHolder);
        }
        else
        {
            return handleOther(column, row, compareHolder);
        }
    }

    private static float handleA(int row, ProfileHolder compareToHolder)
    {
        //If we are in column A, we cannot look to the left.
        //Look B, C, then B on our row, then B on row behind, then finally A on row behind
        float weight = 0;

        if (row == 0)
        {
            //Well we can't look in front
            ProfileHolder holder = seatToProfileMap.get("B0");

            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("B1");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("A1");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            //Since we have an empty row in front, we average it differently
            weight /= 3.0;
        }
        else if (row == 9)
        {
            //Well we can't look behind
            ProfileHolder holder = seatToProfileMap.get("A8");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("B8");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("B9");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            //Since we have an empty row in front, we average it differently
            weight /= 3.0;
        }
        else
        {
            //We can go forward and back
            ProfileHolder holder = seatToProfileMap.get("A" + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("B" + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("B" + row);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("B" + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("A" + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            //Since we have an empty row in front, we average it differently
            weight  /= 5.0;
        }

        return weight;
    }

    private static float handleF(int row, ProfileHolder compareToHolder)
    {
        //If we are in column F, we cannot look to the right.
        float weight = 0;

        if (row == 0)
        {
            //Well we can't look in front
            ProfileHolder holder = seatToProfileMap.get("E0");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("E1");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("F1");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            //Since we have an empty row in front, we average it differently
            weight  /= 3.0;
        }
        else if (row == 9)
        {
            //Well we can't look behind
            ProfileHolder holder = seatToProfileMap.get("F8");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("E8");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("E9");
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            //Since we have an empty row in front, we average it differently
            weight  /= 3.0;
        }
        else
        {
            //We can go forward and back
            ProfileHolder holder = seatToProfileMap.get("F" + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("E" + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("E" + row);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("E" + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get("F" + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            //Since we have an empty row in front, we average it differently
            weight  /= 5.0;
        }

        return weight;
    }

    private static float handleOther(String column, int row, ProfileHolder compareToHolder)
    {
        float weight = 0;

        //No column restriction...can do full scan
        if (row == 0)
        {
            int index = columnToIndexMap.get(column);

            //Well we can't look in front
            ProfileHolder holder = seatToProfileMap.get(columns[index - 1] + 0);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + 0);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index - 1] + 1);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index] + 1);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + 1);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            weight  /= 5.0;
        }
        else if (row == 9)
        {
            int index = columnToIndexMap.get(column);

            ProfileHolder holder = seatToProfileMap.get(columns[index - 1] + 8);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index] + 8);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + 8);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index - 1] + 9);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + 9);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            weight /= 5.0;
        }
        else
        {
            //Completely unrestricted
            int index = columnToIndexMap.get(column);

            //Well we can't look in front
            ProfileHolder holder = seatToProfileMap.get(columns[index - 1] + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index] + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + (row - 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index - 1] + row);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + row);
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index - 1] + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index] + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            holder = seatToProfileMap.get(columns[index + 1] + (row + 1));
            weight += holder.getCombinedScoreComparison(compareToHolder, compatDetail);

            weight  /= 8.0;
        }

        return weight;
    }

    public static DetailedCompatabilityResults getLastCompatabilityDetail()
    {
        return compatDetail;
    }
}
