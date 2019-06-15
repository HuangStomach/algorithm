/**
 * 矩形面积
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (E >= C || G <= A || H <= B || F >= D) return (D - B) * (C - A) + (H - F) * (G - E); // 没有重合情况
        int mAreaWidth = Math.min(C, G) - Math.max(E, A); // 重合部分的宽
        int mAreaHeight = Math.min(H, D) - Math.max(B, F); // 重合部分的高
        int sumArea = (D - B) * (C - A) + (H - F) * (G - E); // 总面积
        int mArea = mAreaWidth * mAreaHeight;
        return sumArea - mArea;
    }
}
