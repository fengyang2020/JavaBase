package com.beingmate.learn.algorithm.leetcode.math;

import java.util.*;

/***
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 * @author yfeng
 * @date 2018-08-06 22:28
 */
public class GroupSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> datas = new ArrayList(candidates.length);
        for (int num : candidates) {
            datas.add(num);
        }
        Collections.sort(datas);
        return combinationSumWithList(datas, target);
    }

    public List<List<Integer>> combinationSumWithList(List<Integer> datas, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < datas.size(); i++) {
            int num = datas.get(i);
            if (sets.contains(num)) {
                continue;
            }
            sets.add(num);
            if (num == target) {
                List<Integer> curList = new ArrayList<>();
                curList.add(num);
                results.add(curList);
                continue;
            }

            if (num > target || i == datas.size() - 1) {
                break;
            }
            List<Integer> subLists = datas.subList(i + 1, datas.size());
            List<List<Integer>> subSumLists = combinationSumWithList(subLists, target - num);
            if (!subSumLists.isEmpty()) {
                for (List<Integer> innerList : subSumLists) {
                    innerList.add(num);
                }
                results.addAll(subSumLists);
            }
        }
        return results;
    }

    private List<Integer> excludeIdx(List<Integer> datas, int idex) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            if (idex != i) {
                results.add(datas.get(i));
            }
        }
        return results;
    }
}
