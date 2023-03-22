package com.bo.coding.competition.week211;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,1,1,1,1,1,1,1,1,1]
 * [811,364,124,873,790,656,581,446,885,134]
 */
public class C {
    static class Player {
        int score;
        int age;
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        List<Player> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            Player player = new Player();
            player.score = scores[i];
            player.age = ages[i];
            list.add(player);
        }
        list.sort((o1, o2) -> {
            if (o1.age != o2.age) {
                return o1.age - o2.age;
            }
            return o1.score - o2.score;
        });
        int max = 0;
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dp[i] = list.get(i).score;
            for (int j = 0; j < i; j++) {
                if (list.get(i).age > list.get(j).age) {
                    if (list.get(i).score >= list.get(j).score) {
                        dp[i] = Math.max(dp[i], dp[j] + list.get(i).score);
                    }
                } else {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).score);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
