class Solution {
    public long solution(int w, int h) {
        int gcd = euclidean(w, h);
        int nw = w / gcd; 
        int nh = h / gcd;
        return (long) w * h - (nw + nh - 1) * gcd;
    }
    
    int euclidean(int w, int h) {
        if (h == 0) {
            return w;
        }
        
        return euclidean(h, w % h);
    }
}