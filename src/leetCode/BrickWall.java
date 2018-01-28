package leetCode;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
 /*   There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

    The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

    If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

    You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

            Example:
    Input:
            [[1,2,2,1],
            [3,1,2],
            [1,3,2],
            [2,4],
            [3,1,2],
            [1,3,1,1]]
    Output: 2
    Explanation:*/
//题解：这道题考虑的是每个节点的存在位置，能够找到在一定行的过程中一共有的非节点数。
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size()==0) return 0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int count=0;
        for(List<Integer> list:wall){
            int lens=0;
            for(int i=0;i<list.size()-1;i++){
                lens+=list.get(i);
                hashMap.put(lens,hashMap.getOrDefault(lens,0)+1);
                count=Math.max(count,hashMap.get(lens));
            }
        }
        return wall.size()-count;
    }
}
