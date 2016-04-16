package com.aa.hackathon.seatmate.Utils;

import android.util.Log;

/**
 * Created by 522121 on 4/15/2016.
 */
public class ProfileHolder
{
    private static final String TAG = ProfileHolder.class.getName();

    public enum Industry
    {
        Advertising, Aerospace, Agriculture, Automotive, Banking, Broadcasting,
        Building, Cable, Chemical, Clergy, Software, Defense, Education,
        Environmental, Finance, Food, Gambling, Gas, Hotel, Manufacturing,
        Film, Health, Pharmaceuticals, Publishing, Media, Power, Rail,
        Recording, RealEstate, Restaurant, Retail, Transportation, Trucking,
        VentureCapital, WasteManagement
    }


    private boolean likeToTalk;
    private boolean doNotDisturb;
    private boolean likesSittingByKids;
    private boolean likesSittingByPets;
    private Industry industry;
    private String company;
    private int age;
    private boolean travelingWithPet;

    private int weightLikeToTalk;
    private int weightDoNotDisturb;
    private int weightLikesSittingByKids;
    private int weightLikesSittingByPets;
    private int weightIndustry;
    private int weightCompany;
    private int weightAge;
    private int weightTravelingWithPet;

    private static final int STANDARD_UPTICK = 1;

    public ProfileHolder(boolean likeToTalk,
                         boolean doNotDisturb,
                         boolean likesSittingByKids,
                         boolean likesSittingByPets,
                         Industry industry,
                         String company,
                         int age,
                         boolean travelingWithPet,
                         int weightLikeToTalk,
                         int weightDoNotDisturb,
                         int weightLikesSittingByKids,
                         int weightLikesSittingByPets,
                         int weightIndustry,
                         int weightCompany,
                         int weightAge,
                         int weightTravelingWithPet)
    {
        this.likeToTalk = likeToTalk;
        this.doNotDisturb = doNotDisturb;
        this.likesSittingByKids = likesSittingByKids;
        this.likesSittingByPets = likesSittingByPets;
        this.industry = industry;
        this.company = company;
        this.age = age;
        this.travelingWithPet = travelingWithPet;
        this.weightLikeToTalk = weightLikeToTalk;
        this.weightDoNotDisturb = weightDoNotDisturb;
        this.weightLikesSittingByKids = weightLikesSittingByKids;
        this.weightLikesSittingByPets = weightLikesSittingByPets;
        this.weightIndustry = weightIndustry;
        this.weightCompany = weightCompany;
        this.weightAge = weightAge;
        this.weightTravelingWithPet = weightTravelingWithPet;
    }

    public boolean isLikeToTalk()
    {
        return likeToTalk;
    }

    public void setLikeToTalk(boolean likeToTalk)
    {
        this.likeToTalk = likeToTalk;
    }

    public boolean isDoNotDisturb()
    {
        return doNotDisturb;
    }

    public void setDoNotDisturb(boolean doNotDisturb)
    {
        this.doNotDisturb = doNotDisturb;
    }

    public boolean isLikesSittingByKids()
    {
        return likesSittingByKids;
    }

    public void setLikesSittingByKids(boolean likesSittingByKids)
    {
        this.likesSittingByKids = likesSittingByKids;
    }

    public boolean isLikesSittingByPets()
    {
        return likesSittingByPets;
    }

    public void setLikesSittingByPets(boolean likesSittingByPets)
    {
        this.likesSittingByPets = likesSittingByPets;
    }

    public Industry getIndustry()
    {
        return industry;
    }

    public void setIndustry(Industry industry)
    {
        this.industry = industry;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public boolean isTravelingWithPet()
    {
        return travelingWithPet;
    }

    public void setTravelingWithPet(boolean travelingWithPet)
    {
        this.travelingWithPet = travelingWithPet;
    }

    public int getWeightLikeToTalk()
    {
        return weightLikeToTalk;
    }

    public void setWeightLikeToTalk(int weightLikeToTalk)
    {
        this.weightLikeToTalk = weightLikeToTalk;
    }

    public int getWeightDoNotDisturb()
    {
        return weightDoNotDisturb;
    }

    public void setWeightDoNotDisturb(int weightDoNotDisturb)
    {
        this.weightDoNotDisturb = weightDoNotDisturb;
    }

    public int getWeightLikesSittingByKids()
    {
        return weightLikesSittingByKids;
    }

    public void setWeightLikesSittingByKids(int weightLikesSittingByKids)
    {
        this.weightLikesSittingByKids = weightLikesSittingByKids;
    }

    public int getWeightLikesSittingByPets()
    {
        return weightLikesSittingByPets;
    }

    public void setWeightLikesSittingByPets(int weightLikesSittingByPets)
    {
        this.weightLikesSittingByPets = weightLikesSittingByPets;
    }

    public int getWeightIndustry()
    {
        return weightIndustry;
    }

    public void setWeightIndustry(int weightIndustry)
    {
        this.weightIndustry = weightIndustry;
    }

    public int getWeightCompany()
    {
        return weightCompany;
    }

    public void setWeightCompany(int weightCompany)
    {
        this.weightCompany = weightCompany;
    }

    public int getWeightAge()
    {
        return weightAge;
    }

    public void setWeightAge(int weightAge)
    {
        this.weightAge = weightAge;
    }

    public int getWeightTravelingWithPet()
    {
        return weightTravelingWithPet;
    }

    public void setWeightTravelingWithPet(int weightTravelingWithPet)
    {
        this.weightTravelingWithPet = weightTravelingWithPet;
    }

    public int getCombinedScoreComparison(ProfileHolder inputHolder)
    {
        int weight = 0;

        if (likesSittingByKids)
        {
            if (inputHolder.getAge() < 12)
            {
                weight += getWeightLikesSittingByKids() * STANDARD_UPTICK;
            }
        }

        if (likesSittingByPets)
        {
            if (inputHolder.isTravelingWithPet())
            {
                weight += weightTravelingWithPet * STANDARD_UPTICK;
            }
        }
        else
        {
            if (inputHolder.isTravelingWithPet())
            {
                weight -= weightTravelingWithPet * STANDARD_UPTICK;
            }
        }

        if (likeToTalk)
        {
            if (inputHolder.isLikeToTalk())
            {
                weight += weightLikeToTalk * STANDARD_UPTICK;
            }

            if (inputHolder.isDoNotDisturb())
            {
                weight -= weightLikeToTalk * STANDARD_UPTICK;
            }
        }

        if (doNotDisturb)
        {
            if (inputHolder.isDoNotDisturb())
            {
                weight += weightDoNotDisturb * STANDARD_UPTICK;
            }
            else if (inputHolder.isLikeToTalk())
            {
                weight -= weightDoNotDisturb * STANDARD_UPTICK;
            }
        }

        if (Math.abs(age - inputHolder.getAge()) <= 10)
        {
            weight += weightAge * STANDARD_UPTICK;
        }
        else
        {
            weight -= weightAge * STANDARD_UPTICK;
        }

        if (industry == inputHolder.industry)
        {
            weight += weightIndustry * STANDARD_UPTICK;
        }

        if (company.startsWith(inputHolder.getCompany()))
        {
            weight += weightCompany * STANDARD_UPTICK;
        }

        Log.d(TAG, "Weight: " + weight);

        return weight;
    }

    public int getCombinedScoreComparison(ProfileHolder inputHolder, DetailedCompatabilityResults results)
    {
        int weight = 0;

        if (likesSittingByKids)
        {
            if (inputHolder.getAge() < 12)
            {
                weight += getWeightLikesSittingByKids() * STANDARD_UPTICK;

                results.setResultsLikesSittingByKids(weight);
            }
        }

        int petsResult = 0;

        if (likesSittingByPets)
        {
            if (inputHolder.isTravelingWithPet())
            {
                petsResult = weightTravelingWithPet * STANDARD_UPTICK;
                weight += petsResult;
            }
        }
        else
        {
            if (inputHolder.isTravelingWithPet())
            {
                petsResult = 0 - weightTravelingWithPet * STANDARD_UPTICK;
                weight -= weightTravelingWithPet * STANDARD_UPTICK;
            }
        }

        results.setResultsLikesSittingByPets(petsResult);

        if (likeToTalk)
        {
            int talkResult = 0;

            if (inputHolder.isLikeToTalk())
            {
                talkResult = weightLikeToTalk * STANDARD_UPTICK;
                weight += talkResult;
            }

            if (inputHolder.isDoNotDisturb())
            {
                talkResult = 0 - weightLikeToTalk * STANDARD_UPTICK;
                weight -= weightLikeToTalk * STANDARD_UPTICK;
            }

            results.setResultsLikeToTalk(talkResult);
        }

        if (doNotDisturb)
        {
            int leaveMeAloneResult = 0;

            if (inputHolder.isDoNotDisturb())
            {
                leaveMeAloneResult = weightDoNotDisturb * STANDARD_UPTICK;
                weight += weightDoNotDisturb * STANDARD_UPTICK;
            }
            else if (inputHolder.isLikeToTalk())
            {
                leaveMeAloneResult = 0 - weightDoNotDisturb * STANDARD_UPTICK;
                weight -= weightDoNotDisturb * STANDARD_UPTICK;
            }

            results.setResultsDoNotDisturb(leaveMeAloneResult);
        }

        if (Math.abs(age - inputHolder.getAge()) <= 10)
        {
            results.setResultsAge(weightAge * STANDARD_UPTICK);
            weight += weightAge * STANDARD_UPTICK;
        }
        else
        {
            results.setResultsAge(0 - weightAge * STANDARD_UPTICK);
            weight -= weightAge * STANDARD_UPTICK;
        }

        if (industry == inputHolder.industry)
        {
            results.setResultsIndustry(weightIndustry * STANDARD_UPTICK);
            weight += weightIndustry * STANDARD_UPTICK;
        }

        if (company.startsWith(inputHolder.getCompany()))
        {
            results.setResultsCompany(weightCompany * STANDARD_UPTICK);
            weight += weightCompany * STANDARD_UPTICK;
        }

//        Log.d(TAG, results.toString());
//        Log.d(TAG, "Weight: " + weight);

        return weight;
    }

}