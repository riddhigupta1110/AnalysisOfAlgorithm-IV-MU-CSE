//Riddhi Gupta - SE CMPN B B1 - 05
import java.util.*;
public class RobinKarp {
    static void robinKarp(char T[], char P[], int d, int q){
        int n = T.length;
        int m = P.length;
        int h = ((int)Math.pow(d, m-1))%q;
        int p = 0, t = 0;
        int spuriousHit = 0;
        int i;
        for (i = 0; i < m; i++) {
            p = (d*p + P[i])%q;
            t = (d*t + T[i])%q;
        }
        for(int s=0; s<=(n-m); s++){
            if(p==t){
                for (i = 0; i < m; i++) {
                    if(P[i]!=T[s+i]){
                        spuriousHit++;
                        break;
                    }
                }
                if(i==m){
                    System.out.println("Pattern occured with shift " + s);
                }
            }
            if(s<n-m){
                t = (d*(t-T[s]*h) + T[s+m]) % q;
                if(t<0){
                    t = t + q;
                }
            }
        }
        System.out.println("Spurious Hit: "+ spuriousHit);
    }
    static void robinKarpCaller(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String strT = sc.next();
        char T[] = strT.toCharArray();
        System.out.println("Enter pattern: ");
        String strP = sc.next();
        char P[] = strP.toCharArray();
        System.out.println("Enter radix: ");
        int d = sc.nextInt();
        System.out.println("Enter prime: ");
        int q = sc.nextInt();
        robinKarp(T, P, d, q);
    }
    public static void main(String[] args) {
        robinKarpCaller();
    }
}
