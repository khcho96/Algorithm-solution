class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 1;
        for (int[] attack : attacks) {
            // 체력 회복
            health += (attack[0] - time) * bandage[1];
            if (attack[0] - time >= bandage[0]) {
                health += ((attack[0] - time) / bandage[0]) * bandage[2];
            }
            health = Math.min(health, maxHealth);

            // 공격 받음
            health -= attack[1];
            if (health <= 0) {
                health = -1;
                break;
            }

            // 시간 업데이트
            time = attack[0] + 1;
        }
        return health;
    }
}