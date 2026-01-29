class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] split = skill.split("");
        for (String skillTree : skill_trees) {
            String string = skillTree.replaceAll("[^" + skill + "]", "");

            int index = 0;
            for (String s : string.split("")) {
                if (!split[index].equals(s)) {
                    break;
                }
                index++;
            }

            if (index == string.length()) answer++;
        }
        return answer;
    }
}