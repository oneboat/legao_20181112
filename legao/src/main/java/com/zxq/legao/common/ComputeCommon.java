package com.zxq.legao.common;

import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.util.DateUtil;

import java.util.List;

/**
 * Description:
 * <p>
 * 抽取的公共方法
 * </p>
 *
 * @author dengzhenxiang
 * @Date 2019/1/2 17:59
 */
public class ComputeCommon {
    /**
     * 计算星期
     */
    public static SchedulePO computeWeek(SchedulePO schedulePO) {
        List<Integer> dateList = DateUtil.getWeek(schedulePO.getCourseDate());
        schedulePO.setCourseWeek(String.valueOf(dateList.get(0)));
        schedulePO.setWeekOfYear(String.valueOf(dateList.get(1)));
        return schedulePO;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};

        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


}
