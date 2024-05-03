import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int maxMinerals = Math.min(picks[0] * 5 + picks[1] * 5 + picks[2] * 5, minerals.length);
        
        Queue<Chunk> chunks = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<maxMinerals;i+=5) {
            String[] copied = Arrays.copyOfRange(minerals, i, Math.min(i+5, maxMinerals));
            Chunk chunk = new Chunk();
            for (String mineral : copied) {
                if (mineral.equals("diamond")) {
                    chunk.dia();
                }
                if (mineral.equals("iron")) {
                    chunk.iron();
                }
                if (mineral.equals("stone")) {
                    chunk.stone();
                }
            }
            chunks.add(chunk);
        }
        
        int answer = 0;
        for (int i=0;i<3;i++) {
            if (picks[i] < 1) {
                continue;
            }
            if (chunks.isEmpty()) {
                break;
            }
            for (int j=0;j<picks[i];j++) {
                if (chunks.isEmpty()) {
                    break;
                }
                Chunk now = chunks.poll();
                if (i == 0) {
                    answer += now.dia + now.iron + now.stone;
                }
                if (i == 1) {
                    answer += now.dia*5 + now.iron + now.stone;
                }
                if (i == 2) {
                    answer += now.dia*25 + now.iron*5 + now.stone;
                }
            }
        }
        
        return answer;
    }
}

class Chunk implements Comparable<Chunk> {
    int dia, iron, stone;
    
    public Chunk() {
        dia = 0;
        iron = 0;
        stone = 0;
    }
    
    public void dia() {
        dia++;
    }
    
    public void iron() {
        iron++;
    }
    
    public void stone() {
        stone++;
    }
    
    @Override
    public int compareTo(Chunk o) {
        if (this.dia == o.dia) {
            if (this.iron == o.iron) {
                return this.stone - o.stone;
            } else {
                return this.iron - o.iron;
            }
        } else {
            return this.dia - o.dia;
        }
    }
}