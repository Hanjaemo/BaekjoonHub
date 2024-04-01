import java.time.*;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        m = m.replace("B#", "b");
        
        List<Music> musics = new ArrayList<>();
        int order = 1;
        for (int i=0;i<musicinfos.length;i++) {
            
            String[] musicinfo = musicinfos[i].split(",");
            
            int[] start = Arrays.stream(musicinfo[0].split(":")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(musicinfo[1].split(":")).mapToInt(Integer::parseInt).toArray();
            int diff = (int) Duration.between(LocalTime.of(start[0], start[1]), LocalTime.of(end[0], end[1])).toMinutes();
            
            String title = musicinfo[2];
            String a = musicinfo[3];
            
            a = a.replace("C#", "c");
            a = a.replace("D#", "d");
            a = a.replace("F#", "f");
            a = a.replace("G#", "g");
            a = a.replace("A#", "a");
            a = a.replace("B#", "b");
            
            String aCopy = "";
            int n = diff / a.length();
            System.out.println("n = " + n);
            for (int j=0;j<n;j++) {
                aCopy += a;
            }
            
            int remain = diff % a.length();
            System.out.println("remain = " + remain);
            aCopy += a.substring(0, remain);
            
            System.out.println("a = " + a);
            System.out.println("aCopy = " + aCopy);

            if (aCopy.contains(m)) {
                musics.add(new Music(title, diff, order));
            }
            
            order++;
        }
        
        Collections.sort(musics);
        
        if (musics.size() == 0) {
            return "(None)";
        } else {
            return musics.get(0).title;
        }
    }
}

class Music implements Comparable<Music> {
    
    String title;
    int time;
    int order;
    
    public Music(String title, int time, int order) {
        this.title = title;
        this.time = time;
        this.order = order;
    }
    
    @Override
    public int compareTo(Music other) {
        if (this.time == other.time) {
            return this.order - other.order;
        }
        return other.time - this.time;
    }
}