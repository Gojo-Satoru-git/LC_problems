
class Solution {
    public double separateSquares(int[][] squares) {
        double low = 1e7;
        double high = 0;

        for (int[] sq : squares) {
            high = Math.max(high, (double) sq[1] + sq[2]);
            low  = Math.min(low,sq[1]);
        }

        double eps = 1e-6;

        while (high - low > eps) {
            double mid = (high + low) / 2.0;
            double diff = check(mid, squares);

            if (diff > 0) {
                low = mid;      
            } else {
                high = mid;    
            }
        }

        return low;
    }

    private double check(double mid, int[][] squares) {
        double above = 0, below = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double area = l * l;

            double bottom = y;
            double top = y + l;

            if (top < mid) {       
                below += area;
            } else if (bottom > mid) {
                above += area;
            } else {                
                double aboveHeight = top - mid;
                double belowHeight = mid - bottom;
                above += aboveHeight * l;
                below += belowHeight * l;
            }
        }

        return above - below;
    }
}