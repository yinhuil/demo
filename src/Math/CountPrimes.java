package Math;

public class CountPrimes {

	public static int countPrimes(int n) {
		boolean[] notprime=new boolean[n];
		int count=0;
		for(int i=2;i<n;i++){
			if(!notprime[i]){
				count++;
				for(int j=2;j*i<n;j++){
					notprime[i*j]=true;
				}
			}
		}
		return count;
	}
    public int countPrimes1(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
	public static void main(String[] args) {
		System.out.println(countPrimes(3));
		

	}

}
