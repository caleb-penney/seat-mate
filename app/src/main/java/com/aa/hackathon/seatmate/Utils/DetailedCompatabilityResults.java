package com.aa.hackathon.seatmate.Utils;

/**
 * Created by 522121 on 4/16/2016.
 */
public class DetailedCompatabilityResults
{
    private float resultsLikeToTalk;
    private float resultsDoNotDisturb;
    private float resultsLikesSittingByKids;
    private float resultsLikesSittingByPets;
    private float resultsIndustry;
    private float resultsCompany;
    private float resultsAge;
    private float resultsTravelingWithPet;

    public DetailedCompatabilityResults()
    {

    }

    public float getResultsLikeToTalk()
    {
        return resultsLikeToTalk;
    }

    public void setResultsLikeToTalk(float resultsLikeToTalk)
    {
        this.resultsLikeToTalk = resultsLikeToTalk;
    }

    public float getResultsDoNotDisturb()
    {
        return resultsDoNotDisturb;
    }

    public void setResultsDoNotDisturb(float resultsDoNotDisturb)
    {
        this.resultsDoNotDisturb = resultsDoNotDisturb;
    }

    public float getResultsLikesSittingByKids()
    {
        return resultsLikesSittingByKids;
    }

    public void setResultsLikesSittingByKids(float resultsLikesSittingByKids)
    {
        this.resultsLikesSittingByKids = resultsLikesSittingByKids;
    }

    public float getResultsLikesSittingByPets()
    {
        return resultsLikesSittingByPets;
    }

    public void setResultsLikesSittingByPets(float resultsLikesSittingByPets)
    {
        this.resultsLikesSittingByPets = resultsLikesSittingByPets;
    }

    public float getResultsIndustry()
    {
        return resultsIndustry;
    }

    public void setResultsIndustry(float resultsIndustry)
    {
        this.resultsIndustry = resultsIndustry;
    }

    public float getResultsCompany()
    {
        return resultsCompany;
    }

    public void setResultsCompany(float resultsCompany)
    {
        this.resultsCompany = resultsCompany;
    }

    public float getResultsAge()
    {
        return resultsAge;
    }

    public void setResultsAge(float resultsAge)
    {
        this.resultsAge = resultsAge;
    }

    public float getResultsTravelingWithPet()
    {
        return resultsTravelingWithPet;
    }

    public void setResultsTravelingWithPet(float resultsTravelingWithPet)
    {
        this.resultsTravelingWithPet = resultsTravelingWithPet;
    }

    public DetailedCompatabilityResults(float resultsLikeToTalk, float resultsDoNotDisturb, float resultsLikesSittingByKids, float resultsLikesSittingByPets, float resultsIndustry, float resultsCompany, float resultsAge, float resultsTravelingWithPet)
    {
        this.resultsLikeToTalk = resultsLikeToTalk;
        this.resultsDoNotDisturb = resultsDoNotDisturb;
        this.resultsLikesSittingByKids = resultsLikesSittingByKids;
        this.resultsLikesSittingByPets = resultsLikesSittingByPets;
        this.resultsIndustry = resultsIndustry;
        this.resultsCompany = resultsCompany;
        this.resultsAge = resultsAge;
        this.resultsTravelingWithPet = resultsTravelingWithPet;
    }

    @Override
    public String toString()
    {
        return "DetailedCompatabilityResults{" +
                "resultsLikeToTalk=" + resultsLikeToTalk +
                ", resultsDoNotDisturb=" + resultsDoNotDisturb +
                ", resultsLikesSittingByKids=" + resultsLikesSittingByKids +
                ", resultsLikesSittingByPets=" + resultsLikesSittingByPets +
                ", resultsIndustry=" + resultsIndustry +
                ", resultsCompany=" + resultsCompany +
                ", resultsAge=" + resultsAge +
                ", resultsTravelingWithPet=" + resultsTravelingWithPet +
                '}';
    }
}
