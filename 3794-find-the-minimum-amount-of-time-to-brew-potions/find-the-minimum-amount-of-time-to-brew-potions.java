class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;

        long sumSkill = 0;
        for (int x : skill) sumSkill += x;

        // prevWizardDone is the finish time of wizard n-1 for previous potion j-1
        long prevWizardDone = sumSkill * mana[0];

        for (int j = 1; j < m; j++) {
            long prevPotionDone = prevWizardDone;  // end time for last wizard on potion j-1
            
            // Walk backwards through wizards to enforce no-wait constraints
            for (int i = n - 2; i >= 0; i--) {
                // First subtract the time wizard i+1 took on potion j-1
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];
                // Now prevWizardDone becomes:
                // max( prevPotionDone, (prevWizardDone minus time for wizard i on current potion) )
                prevWizardDone = Math.max(prevPotionDone, prevWizardDone - (long) skill[i] * mana[j]);
            }
            // After adjusting offsets, add full pipeline time for potion j
            prevWizardDone += sumSkill * mana[j];
        }

        return prevWizardDone;
    }
}
