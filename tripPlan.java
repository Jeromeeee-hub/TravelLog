class tripPlan {

    String planName, planDescription, planListActivities, planInstructions;
    int planPrepTime, planTravelTime, planActivities, planNumInstructions;

    tripPlan(
        String planName,
        String planDescription,
        int planPrepTime,
        int planTravelTime,
        int planActivities,
        String planListActivities,
        int planNumInstructions,
        String planInstructions

    ) {
        this.planName = planName;
        this.planDescription = planDescription;
        this.planPrepTime = planPrepTime;
        this.planTravelTime = planTravelTime;
        this.planActivities = planActivities;
        this.planListActivities = planListActivities;
        this.planNumInstructions = planNumInstructions;
        this.planInstructions = planInstructions;
    }
}
